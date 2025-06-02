package org.prontuario.controllers;

import jakarta.validation.Valid;
import org.prontuario.dto.MensagemResposta;
import org.prontuario.models.Medico;
import org.prontuario.models.Prontuario;

import org.prontuario.services.MedicoService;
import org.prontuario.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Medico medico = prontuario.getMedico();

        return prontuarioService.createProntuario(prontuario, medico)?
                ResponseEntity.ok(new MensagemResposta("Prontuario criado!")):
                ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                        .body(new MensagemResposta("Não foi possível criar o prontuário."));


    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Prontuario> getProntuario(@PathVariable Long codigo){

        Prontuario prontuario = prontuarioService.readProntuario(codigo);

        return ResponseEntity.status(HttpStatus.OK).body(prontuario);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteProntuario(@PathVariable Long codigo){
        prontuarioService.deleteProntuario(codigo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
