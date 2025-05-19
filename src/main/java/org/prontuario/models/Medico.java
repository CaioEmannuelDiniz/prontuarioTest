package org.prontuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;



@Entity
public class Medico extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O CRM não pode ser nulo")
    @Size(min = 5, max = 10, message = "O CRM deve ter entre 5 e 10 caracteres")
    private String crm;

    @NotNull(message = "Deve possuir no mínimo uma especialidade")
    @Size(min = 1, message = "Deve possuir no mínimo uma especialidade")
    @ElementCollection
    private List<String> especialidades;

    @NotNull(message = "O status do CRM não pode ser nulo")
    private String statusCrm;

    @Email(message = "O e-mail profissional deve ser válido")
    private String emailProfissional;


    public Medico() {
    }

    public Medico(String nomeCompleto, String rg, String genero, String estadoCivil, String email, String senha, String telefone, String cep, String endereco, String bairro, String cidade, String estado, Integer numero, LocalDate dataNascimento, Long id, String crm, List<String> especialidades, String statusCrm, String emailProfissional) {
        super(nomeCompleto, rg, genero, estadoCivil, email, senha, telefone, cep, endereco, bairro, cidade, estado, numero, dataNascimento);
        this.id = id;
        this.crm = crm;
        this.especialidades = especialidades;
        this.statusCrm = statusCrm;
        this.emailProfissional = emailProfissional;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O CRM não pode ser nulo") @Size(min = 5, max = 10, message = "O CRM deve ter entre 5 e 10 caracteres") String getCrm() {
        return crm;
    }

    public void setCrm(@NotNull(message = "O CRM não pode ser nulo") @Size(min = 5, max = 10, message = "O CRM deve ter entre 5 e 10 caracteres") String crm) {
        this.crm = crm;
    }

    public @NotNull(message = "Deve possuir no mínimo uma especialidade") @Size(min = 1, message = "Deve possuir no mínimo uma especialidade") List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(@NotNull(message = "Deve possuir no mínimo uma especialidade") @Size(min = 1, message = "Deve possuir no mínimo uma especialidade") List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public @NotNull(message = "O status do CRM não pode ser nulo") String getStatusCrm() {
        return statusCrm;
    }

    public void setStatusCrm(@NotNull(message = "O status do CRM não pode ser nulo") String statusCrm) {
        this.statusCrm = statusCrm;
    }

    public @Email(message = "O e-mail profissional deve ser válido") String getEmailProfissional() {
        return emailProfissional;
    }

    @Override
    public String getIdentificador() {
        return crm;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", crm='" + crm + '\'' +
                ", especialidades=" + especialidades +
                ", statusCrm='" + statusCrm + '\'' +
                ", emailProfissional='" + emailProfissional + '\'' +
                '}';
    }

    public void setEmailProfissional(@Email(message = "O e-mail profissional deve ser válido") String emailProfissional) {
        this.emailProfissional = emailProfissional;
    }
}
