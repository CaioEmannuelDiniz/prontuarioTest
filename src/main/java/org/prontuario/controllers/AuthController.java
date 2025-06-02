package org.prontuario.controllers;

import org.prontuario.dto.LoginMedicoDTO;
import org.prontuario.dto.LoginPacienteDTO;
import org.prontuario.repositories.MedicoRepository;
import org.prontuario.repositories.PacienteRepository;
import org.prontuario.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // ✅ injeta o encoder

    @PostMapping("/medico")
    public ResponseEntity<String> loginMedico(@RequestBody LoginMedicoDTO loginMedicoDTO) {
        var medico = medicoRepository.findByCrm(loginMedicoDTO.crm);
        if (medico.isEmpty() || !passwordEncoder.matches(loginMedicoDTO.senha,medico.get().getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CRM ou senha inválidos");
        }

        // Gera token com tipo TIPO_MEDICO
        String token = jwtUtil.generateToken(loginMedicoDTO.crm, "TIPO_MEDICO");
        return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
    }


    @PostMapping("/paciente")
    public ResponseEntity<String> loginPaciente(@RequestBody LoginPacienteDTO loginPacienteDTO) {
        var paciente = pacienteRepository.findByCpf(loginPacienteDTO.cpf);

        if (paciente.isEmpty() || !passwordEncoder.matches(loginPacienteDTO.senha, paciente.get().getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CPF ou senha inválidos");
        }

        String token = jwtUtil.generateToken(loginPacienteDTO.cpf, "TIPO_PACIENTE");
        return ResponseEntity.ok("{\"token\":\"" + token + "\"}");

    }
}