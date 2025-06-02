package org.prontuario.services;

import jakarta.persistence.EntityNotFoundException;
import org.prontuario.exceptions.ProntuarioNaoLocalizado;
import org.prontuario.models.Medico;
import org.prontuario.models.Paciente;
import org.prontuario.models.Prontuario;
import org.prontuario.models.Usuario;
import org.prontuario.repositories.PacienteRepository;
import org.prontuario.repositories.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProntuarioService {

    @Autowired
    private final ProntuarioRepository prontuarioRepository;
    @Autowired
    private final PacienteRepository pacienteRepository;


    //Construtor
    public ProntuarioService(ProntuarioRepository prontuarioRepository, PacienteService pacienteService, PacienteRepository pacienteRepository) {
        this.prontuarioRepository = prontuarioRepository;
        this.pacienteRepository = pacienteRepository;
    }

    //Criar um Prontuario
    public boolean createProntuario(Prontuario prontuario, Usuario usuario) {
        if (!(usuario instanceof Medico)) {
            throw new SecurityException("Apenas médicos podem criar prontuários.");
        }


        Paciente paciente = pacienteRepository.findById(
                prontuario
                .getPaciente()
                .getId())
                .orElseThrow(()-> new EntityNotFoundException("Paciente não encontrado"));

        Prontuario novoProntuario = new Prontuario();

        novoProntuario.setPaciente(paciente);
        novoProntuario.setMedico((Medico) usuario);
        novoProntuario.setCondutasPlanosTerapeuticos(prontuario.getCondutasPlanosTerapeuticos());
        novoProntuario.setQueixaPrincipal(prontuario.getQueixaPrincipal());
        novoProntuario.setExameFisico(prontuario.getExameFisico());
        novoProntuario.setDataCriacao(prontuario.getDataCriacao());
        novoProntuario.setDiagnostico(prontuario.getDiagnostico());
        novoProntuario.setCodigoProntuario(prontuario.getCodigoProntuario());
        novoProntuario.setPrescricaoMedica(prontuario.getPrescricaoMedica());
        novoProntuario.setEvolucaoClinica(prontuario.getEvolucaoClinica());

        prontuario.setMedico((Medico) usuario); // associa o médico logado

        prontuarioRepository.save(novoProntuario);

        return true;
    }

    //Localizar o Prontuario pelo codigo
    public Prontuario readProntuario(Long codigo) {

        return prontuarioRepository.findByCodigoProntuario(codigo)
                .orElseThrow(() -> new ProntuarioNaoLocalizado("Prontuário não localizado!"));


    }

    //Alterar um Prontuario
    public boolean updateProntuario(Prontuario prontuario) {
        if (!prontuarioRepository.existsById(prontuario.getId())) {
            return false;
        }

        prontuario.setPaciente(prontuario.getPaciente());
        prontuario.setEvolucaoClinica(prontuario.getEvolucaoClinica());
        prontuario.setMedico((prontuario.getMedico()));
        prontuario.setDiagnostico(prontuario.getDiagnostico());
        prontuario.setCodigoProntuario(prontuario.getCodigoProntuario());

        prontuario.setCondutasPlanosTerapeuticos(prontuario.getCondutasPlanosTerapeuticos());
        prontuario.setQueixaPrincipal(prontuario.getQueixaPrincipal());
        prontuario.setExameFisico(prontuario.getExameFisico());
        prontuario.setDataCriacao(prontuario.getDataCriacao());
        prontuario.setPrescricaoMedica(prontuario.getPrescricaoMedica());

        prontuarioRepository.save(prontuario);


        return true;
    }

    //Deletar um Prontuario
    public void deleteProntuario(Long codigo) {
        if (!prontuarioRepository.existsById(codigo)) {
            throw new ProntuarioNaoLocalizado("Prontuario não localizado");
        }

        prontuarioRepository.deleteById(codigo);

    }

}
