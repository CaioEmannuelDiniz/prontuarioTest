package org.prontuario.controllers;

import jakarta.validation.Valid;
import org.prontuario.dto.MensagemResposta;
import org.prontuario.models.Paciente;
import org.prontuario.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //Create
    @PostMapping("/cadastrar")
    @PreAuthorize("hasAnyAuthority('TIPO_MEDICO', 'TIPO_PACIENTE')")
    public ResponseEntity<Paciente> createPaciente(@Valid @RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.savePaciente(paciente);

        return  ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    //Read
    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }

    //Read
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id){
        Paciente paciente = pacienteService.getPacienteById(id);
        return ResponseEntity.ok(paciente);
    }

    //Read
    @GetMapping("nome/{name}")
    public ResponseEntity<List<Paciente>> getPacienteByName(@PathVariable String name){

        List<Paciente> pacientes = pacienteService.getPacienteByName(name);


        if (!pacientes.isEmpty()){
            return ResponseEntity.ok(pacientes);
        }

        return ResponseEntity.notFound().build();
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePacienteById(@PathVariable Long id,@RequestBody Paciente paciente){

        return ResponseEntity.ok(pacienteService.updatePaciente(id,paciente));
    }

    //Delete
    @DeleteMapping("/{id}")
    public  ResponseEntity<MensagemResposta> deletePaciente(@PathVariable long id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok(new MensagemResposta("Paciente deletado com sucesso"));
    }

}


