package org.prontuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
