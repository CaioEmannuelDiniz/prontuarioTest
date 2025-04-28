package org.prontuario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O CPF não pode ser nulo")
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

    @Size(min = 2, max = 2)
    private String tipoSanguineo;

    @Positive(message = "O peso não pode ser negativo")
    @Min(value = 1,message = "O peso deve ser maior que 0")
    private double peso;

    @Positive(message = "A altura não pode ser negativa")
    @Min(value = 1,message = "A altura deve ser maior que 0")
    private double altura;
}