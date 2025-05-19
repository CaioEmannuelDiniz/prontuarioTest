package org.prontuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Paciente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O CPF não pode ser nulo")
    @Column(unique = true)
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos numéricos")
    private String cpf;

    @ElementCollection
    private Set<String> alergias;

    @ElementCollection
    private Set<String> doencas;

    @ElementCollection
    private Set<String> medicamentos;

    @ElementCollection
    private Set<String> historicoMedico;

    @Size(min = 2, max = 3)
    private String tipoSanguineo;

    @Positive(message = "O peso não pode ser negativo")
    @Min(value = 1,message = "O peso deve ser maior que 0")
    private Double peso;

    @Positive(message = "A altura não pode ser negativa")
    @Min(value = 1,message = "A altura deve ser maior que 0")
    private Double altura;

    @ElementCollection
    private List<Long> prontuarios;

    public Paciente() {
    }

    public Paciente(String nomeCompleto, String rg, String genero, String estadoCivil, String email, String senha, String telefone, String cep, String endereco, String bairro, String cidade, String estado, Integer numero, LocalDate dataNascimento, Long id, String cpf, Set<String> alergias, Set<String> doencas, Set<String> medicamentos, Set<String> historicoMedico, String tipoSanguineo, Double peso, Double altura, List<Long> prontuarios) {
        super(nomeCompleto, rg, genero, estadoCivil, email, senha, telefone, cep, endereco, bairro, cidade, estado, numero, dataNascimento);
        this.id = id;
        this.cpf = cpf;
        this.alergias = alergias;
        this.doencas = doencas;
        this.medicamentos = medicamentos;
        this.historicoMedico = historicoMedico;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.altura = altura;
        this.prontuarios = prontuarios;
    }



    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", alergias=" + alergias +
                ", doencas=" + doencas +
                ", medicamentos=" + medicamentos +
                ", historicoMedico=" + historicoMedico +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public Long getId() {
        return id;
    }


    public @NotNull(message = "O CPF não pode ser nulo") @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos numéricos") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O CPF não pode ser nulo") @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos numéricos") String cpf) {
        this.cpf = cpf;
    }

    public Set<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(Set<String> alergias) {
        this.alergias = alergias;
    }

    public Set<String> getDoencas() {
        return doencas;
    }

    public void setDoencas(Set<String> doencas) {
        this.doencas = doencas;
    }

    public Set<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Set<String> getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(Set<String> historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public @Size(min = 2, max = 3) String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(@Size(min = 2, max = 3) String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public @Positive(message = "O peso não pode ser negativo") @Min(value = 1, message = "O peso deve ser maior que 0") Double getPeso() {
        return peso;
    }

    public void setPeso(@Positive(message = "O peso não pode ser negativo") @Min(value = 1, message = "O peso deve ser maior que 0") Double peso) {
        this.peso = peso;
    }

    public @Positive(message = "A altura não pode ser negativa") @Min(value = 1, message = "A altura deve ser maior que 0") Double getAltura() {
        return altura;
    }

    public void setAltura(@Positive(message = "A altura não pode ser negativa") @Min(value = 1, message = "A altura deve ser maior que 0") Double altura) {
        this.altura = altura;
    }

    public List<Long> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Long> prontuarios) {
        this.prontuarios = prontuarios;
    }

    @Override
    public String getIdentificador() {
        return cpf;
    }
}