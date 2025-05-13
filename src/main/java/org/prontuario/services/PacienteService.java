package org.prontuario.services;

import org.prontuario.exceptions.CpfJaCadastradoException;
import org.prontuario.exceptions.IdNaoLocalizado;
import org.prontuario.exceptions.NameNaoLocalizado;
import org.prontuario.models.Paciente;
import org.prontuario.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Inserir Regra de negocio aqui
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    //Constructor
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //CREATE
    public Paciente savePaciente(Paciente paciente){
        if (pacienteRepository.existsByCpf(paciente.getCpf())){
            throw new CpfJaCadastradoException("Já existe um paciente com esse CPF.");
        }
        return pacienteRepository.save(paciente);
    }

    //READ(ALL)
    public List<Paciente> getPacientes(){
        return pacienteRepository.findAll();
    }

    //READ(NAME)
    public List<Paciente> getPacienteByName(String name){

        List<Paciente> pacientes = pacienteRepository.findByNomeCompleto(name);

        if (pacientes.isEmpty()){
            throw new NameNaoLocalizado("Paciente "+name+" não foi localizado!");
        }


        return pacientes;
    }

    //READ(ID)
    public Paciente getPacienteById(Long id){

        return pacienteRepository.findById(id).orElseThrow(() -> new IdNaoLocalizado("Paciente não encontrado"));
    }

    //UPDATE
    public Paciente updatePaciente(Long id, Paciente pacienteAtualizado) {

        Optional<Paciente> paciente = Optional.ofNullable(getPacienteById(id));


        if (paciente.isEmpty()) {
            throw new IdNaoLocalizado("Paciente não encontrado para o ID: " + id);
        }


        Paciente pacienteExistente = paciente.get();


        pacienteExistente.setNomeCompleto(pacienteAtualizado.getNomeCompleto());
        pacienteExistente.setGenero(pacienteAtualizado.getGenero());
        pacienteExistente.setEstadoCivil(pacienteAtualizado.getEstadoCivil());
        pacienteExistente.setEmail(pacienteAtualizado.getEmail());
        pacienteExistente.setTelefone(pacienteAtualizado.getTelefone());
        pacienteExistente.setCep(pacienteAtualizado.getCep());
        pacienteExistente.setEndereco(pacienteAtualizado.getEndereco());
        pacienteExistente.setBairro(pacienteAtualizado.getBairro());
        pacienteExistente.setCidade(pacienteAtualizado.getCidade());
        pacienteExistente.setEstado(pacienteAtualizado.getEstado());
        pacienteExistente.setNumero(pacienteAtualizado.getNumero());
        pacienteExistente.setDataNascimento(pacienteAtualizado.getDataNascimento());
        pacienteExistente.setCpf(pacienteAtualizado.getCpf());
        pacienteExistente.setAlergias(pacienteAtualizado.getAlergias());
        pacienteExistente.setDoencas(pacienteAtualizado.getDoencas());
        pacienteExistente.setMedicamentos(pacienteAtualizado.getMedicamentos());
        pacienteExistente.setHistoricoMedico(pacienteAtualizado.getHistoricoMedico());
        pacienteExistente.setTipoSanguineo(pacienteAtualizado.getTipoSanguineo());
        pacienteExistente.setPeso(pacienteAtualizado.getPeso());
        pacienteExistente.setAltura(pacienteAtualizado.getAltura());


        return pacienteRepository.save(pacienteExistente);
    }

    //DELETE
    public void deletePaciente(Long id){
        Optional<Paciente> paciente = Optional.ofNullable(getPacienteById(id));

        if (paciente.isPresent()) {
            pacienteRepository.deleteById(id);
        }
    }
}
