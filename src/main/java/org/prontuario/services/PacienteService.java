package org.prontuario.services;

import org.prontuario.models.Paciente;
import org.prontuario.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


//Inserir Regra de negocio aqui
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    //Constructor
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //CREATE
    public Paciente savePaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    //READ(ALL)
    public List<Paciente> getPacientes(){
        return pacienteRepository.findAll();
    }

    //READ(ID)
    public Paciente getPacienteById(Long id){
        return pacienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Paciente no encontrado"));
    }

    //UPDATE
    public void updatePaciente(Long id, Paciente pacienteAtualizado) {

//        Paciente pacienteExistente = getPacienteById(id);
//        pacienteExistente.setNomeCompleto(pacienteAtualizado.getNomeCompleto());
//        pacienteExistente.setDataNascimento(pacienteAtualizado.getDataNascimento());
//        pacienteExistente.setGenero(pacienteAtualizado.getGenero());
//        pacienteExistente.setEstadoCivil(pacienteAtualizado.getEstadoCivil());
//        pacienteExistente.setRg(pacienteAtualizado.getRg());
//        pacienteExistente.setCpf(pacienteAtualizado.getCpf());
//
//            pacienteExistente.setEndereco(pacienteAtualizado.getEndereco());
//            pacienteExistente.setNumero(pacienteAtualizado.getNumero());
//            pacienteExistente.setBairro(pacienteAtualizado.getBairro());
//            pacienteExistente.setCep(pacienteAtualizado.getCep());
//            pacienteExistente.setCidade(pacienteAtualizado.getCidade());
//            pacienteExistente.setEstado(pacienteAtualizado.getEstado());
//
//            pacienteExistente.setTelefone(pacienteAtualizado.getTelefone());
//            pacienteExistente.setEmail(pacienteAtualizado.getEmail());
//
//
//            pacienteExistente.setAlergias(pacienteAtualizado.getAlergias());
//            pacienteExistente.setDoencas(pacienteAtualizado.getDoencas());
//            pacienteExistente.setMedicamentos(pacienteAtualizado.getMedicamentos());
//            pacienteExistente.setHistoricoMedico(pacienteAtualizado.getHistoricoMedico());
//            pacienteExistente.setTipoSanguineo(pacienteAtualizado.getTipoSanguineo());
//
//            pacienteExistente.setAltura(pacienteAtualizado.getAltura());
//            pacienteExistente.setPeso(pacienteAtualizado.getPeso());
//
//            return pacienteRepository.save(pacienteExistente);
    }

    //DELETE
    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
