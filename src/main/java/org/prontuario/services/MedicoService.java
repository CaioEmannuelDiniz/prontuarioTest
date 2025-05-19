package org.prontuario.services;

import org.prontuario.exceptions.CpfJaCadastradoException;
import org.prontuario.exceptions.IdNaoLocalizado;
import org.prontuario.models.Medico;
import org.prontuario.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    //CONSTRUTOR
    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    //Create
    public Medico createMedico(Medico medico){
        if (medicoRepository.existsByCrm(medico.getCrm())){
            throw new CpfJaCadastradoException("Já existe um paciente com esse CPF.");
        }
        return medicoRepository.save(medico);
    }

    //READ(ID)
    public Medico getMedicoById(Long id){

        return medicoRepository.findById(id).orElseThrow(() -> new IdNaoLocalizado("Médico não encontrado"));
    }

    //READ(ALL)
    public List<Medico> getAllMedicos(){
        return medicoRepository.findAll();
    }

    //Delete
    public void deleteMedico(Long id){
        Optional<Medico> medico = Optional.ofNullable(getMedicoById(id));

        if (medico.isPresent()){
            medicoRepository.deleteById(id);
        }
    }
}
