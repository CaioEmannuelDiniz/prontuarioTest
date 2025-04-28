package org.prontuario.models;


import jakarta.persistence.MappedSuperclass;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @NotNull(message = "O nome completo não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome completo deve ter entre 3 e 100 caracteres.")
    private String nomeCompleto;

    @NotNull(message = "O RG não pode ser nulo.")
    @Pattern(regexp = "\\d{9}", message = "O RG deve ter 9 dígitos numéricos.")
    private String rg;

    @NotNull(message = "O gênero não pode ser nulo.")
    private String genero;

    @NotNull(message = "O estado civil não pode ser nulo.")
    private String estadoCivil;

    @Email(message = "O e-mail deve ser válido.")
    @NotNull(message = "O e-mail não pode ser nulo.")
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    private String senha;

    @NotNull(message = "O telefone não pode ser nulo.")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve ter o formato (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.")
    private String telefone;

    @NotNull(message = "O CEP não pode ser nulo.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ter o formato 00000-000.")
    private String cep;

    @NotNull(message = "O endereço não pode ser nulo.")
    @Size(min = 5, max = 200, message = "O endereço deve ter entre 5 e 200 caracteres.")
    private String endereco;

    @NotNull(message = "O bairro não pode ser nulo.")
    private String bairro;

    @NotNull(message = "A cidade não pode ser nulo.")
    @Size(min = 5, max = 200, message = "A cidade deve ter entre 5 e 200 caracteres.")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo.")
    @Size(min = 5, max = 200, message = "O estado deve ter entre 5 e 200 caracteres.")
    private String estado;

    private int numero;

    @NotNull(message = "A data de nascimento não pode ser nula.")
    private LocalDate dataNascimento;


}
