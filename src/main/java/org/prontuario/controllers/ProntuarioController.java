package org.prontuario.controllers;

import jakarta.validation.Valid;
import org.prontuario.dto.MensagemResposta;
import org.prontuario.models.Medico;
import org.prontuario.models.Prontuario;
import org.prontuario.models.Usuario;
import org.prontuario.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {


    private final ProntuarioService prontuarioService;

    @Autowired
    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    //POST
    @PostMapping
    public ResponseEntity<MensagemResposta>createProntuario(@Valid @RequestBody Prontuario prontuario){

        Medico medico = new Medico();
        medico.setId(1L); // simula um médico que já existe no banco (se existir)
        medico.setNomeCompleto("Dr. João");
        medico.setEmail("joao@hospital.com");
        medico.setCrm("123456");



        boolean novoProntuario = prontuarioService.createProntuario(prontuario, medico);

        return ResponseEntity.ok(new MensagemResposta("Prontuario criado!"));
    }


}
