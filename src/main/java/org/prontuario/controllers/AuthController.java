package org.prontuario.controllers;

import org.prontuario.dto.LoginDTO;
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
    public ResponseEntity<String> loginMedico(@RequestParam String crm, @RequestParam String senha) {
        var medico = medicoRepository.findByCrm(crm);
        if (medico.isEmpty() || !medico.get().getSenha().equals(senha)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CRM ou senha inválidos");
        }

        // Gera token com tipo TIPO_MEDICO
        String token = jwtUtil.generateToken(crm, "TIPO_MEDICO");
        return ResponseEntity.ok(token);
    }


    @PostMapping("/paciente")
    public ResponseEntity<String> loginPaciente(@RequestBody LoginDTO loginDTO) {
        var paciente = pacienteRepository.findByCpf(loginDTO.cpf);

        if (paciente.isEmpty() || !passwordEncoder.matches(loginDTO.senha, paciente.get().getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CPF ou senha inválidos");
        }

        String token = jwtUtil.generateToken(loginDTO.cpf, "TIPO_PACIENTE");
        return ResponseEntity.ok("{\"token\":\"" + token + "\"}");

    }
}