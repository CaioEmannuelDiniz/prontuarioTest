package org.prontuario.controllers;

import jakarta.validation.Valid;
import org.prontuario.dto.MensagemResposta;
import org.prontuario.models.Medico;
import org.prontuario.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Medico> createMedico(@Valid @RequestBody Medico medico) {
        Medico novoMedico = medicoService.createMedico(medico);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getAllMedicos() {
        List<Medico> medicos = medicoService.getAllMedicos();
        return ResponseEntity.status(HttpStatus.OK).body(medicos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemResposta> deleteMedico(@PathVariable Long id){
        medicoService.deleteMedico(id);
        return ResponseEntity.ok(new MensagemResposta("Médico deletado com sucesso"));
    }
}
