package org.prontuario.services;

import jakarta.persistence.EntityNotFoundException;
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



    public ProntuarioService(ProntuarioRepository prontuarioRepository, PacienteService pacienteService, PacienteRepository pacienteRepository) {
        this.prontuarioRepository = prontuarioRepository;
        this.pacienteRepository = pacienteRepository;
    }

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
}
