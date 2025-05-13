package org.prontuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long codigoProntuario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @NotNull
    private Paciente paciente;

    private LocalDate dataCriacao;

    private String queixaPrincipal;

    private String exameFisico;

    private String diagnostico;

    private String condutasPlanosTerapeuticos;

    private String prescricaoMedica;

    private String evolucaoClinica;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


}
