package org.prontuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private Long codigoProntuario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @NotNull(message = "O paciente é obrigatorio")
    private Paciente paciente;

    @NotNull(message = "A data de criação é obrigatorio")
    private LocalDate dataCriacao;

    @NotBlank(message = "A queixa principal não pode estar em branco")
    private String queixaPrincipal;

    @NotBlank(message = "O exame fisico não pode estar em branco")
    private String exameFisico;

    @NotBlank(message = "O diagnóstico não pode estar em branco")
    private String diagnostico;

    @NotBlank(message = "As condutas/planos terapêuticos não podem estar em branco")
    private String condutasPlanosTerapeuticos;

    @NotBlank(message = "A prescrição médica não pode estar em branco")
    private String prescricaoMedica;

    @NotBlank(message = "A evolução clínica não pode estar em branco")
    private String evolucaoClinica;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;


    public Prontuario() {
    }

    public Prontuario(Long id, Long codigoProntuario, Paciente paciente, LocalDate dataCriacao, String queixaPrincipal, String exameFisico, String diagnostico, String condutasPlanosTerapeuticos, String prescricaoMedica, String evolucaoClinica, Medico medico) {
        this.id = id;
        this.codigoProntuario = codigoProntuario;
        this.paciente = paciente;
        this.dataCriacao = dataCriacao;
        this.queixaPrincipal = queixaPrincipal;
        this.exameFisico = exameFisico;
        this.diagnostico = diagnostico;
        this.condutasPlanosTerapeuticos = condutasPlanosTerapeuticos;
        this.prescricaoMedica = prescricaoMedica;
        this.evolucaoClinica = evolucaoClinica;
        this.medico = medico;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigoProntuario(@NotNull Long codigoProntuario) {
        this.codigoProntuario = codigoProntuario;
    }

    public void setDataCriacao(@NotNull(message = "A data de criação é obrigatorio") LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setQueixaPrincipal(@NotBlank(message = "A queixa principal não pode estar em branco") String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public void setExameFisico(@NotBlank(message = "O exame fisico não pode estar em branco") String exameFisico) {
        this.exameFisico = exameFisico;
    }

    public void setDiagnostico(@NotBlank(message = "O diagnóstico não pode estar em branco") String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setCondutasPlanosTerapeuticos(@NotBlank(message = "As condutas/planos terapêuticos não podem estar em branco") String condutasPlanosTerapeuticos) {
        this.condutasPlanosTerapeuticos = condutasPlanosTerapeuticos;
    }

    public void setPrescricaoMedica(@NotBlank(message = "A prescrição médica não pode estar em branco") String prescricaoMedica) {
        this.prescricaoMedica = prescricaoMedica;
    }

    public void setEvolucaoClinica(@NotBlank(message = "A evolução clínica não pode estar em branco") String evolucaoClinica) {
        this.evolucaoClinica = evolucaoClinica;
    }


    public Long getId() {
        return id;
    }

    public @NotNull Long getCodigoProntuario() {
        return this.codigoProntuario;
    }

    public @NotNull(message = "A data de criação é obrigatorio") LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public @NotBlank(message = "A queixa principal não pode estar em branco") String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public @NotBlank(message = "O exame fisico não pode estar em branco") String getExameFisico() {
        return exameFisico;
    }

    public @NotBlank(message = "O diagnóstico não pode estar em branco") String getDiagnostico() {
        return diagnostico;
    }

    public @NotBlank(message = "As condutas/planos terapêuticos não podem estar em branco") String getCondutasPlanosTerapeuticos() {
        return condutasPlanosTerapeuticos;
    }

    public @NotBlank(message = "A prescrição médica não pode estar em branco") String getPrescricaoMedica() {
        return prescricaoMedica;
    }

    public @NotBlank(message = "A evolução clínica não pode estar em branco") String getEvolucaoClinica() {
        return evolucaoClinica;
    }


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

    @Override
    public String toString() {
        return "Prontuario{" +
                "id=" + id +
                ", codigoProntuario=" + codigoProntuario +
                ", paciente=" + paciente +
                ", dataCriacao=" + dataCriacao +
                ", queixaPrincipal='" + queixaPrincipal + '\'' +
                ", exameFisico='" + exameFisico + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", condutasPlanosTerapeuticos='" + condutasPlanosTerapeuticos + '\'' +
                ", prescricaoMedica='" + prescricaoMedica + '\'' +
                ", evolucaoClinica='" + evolucaoClinica + '\'' +
                ", medico=" + medico +
                '}';
    }
}
