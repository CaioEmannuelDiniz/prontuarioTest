package org.prontuario.models;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.*;
import java.time.LocalDate;


@MappedSuperclass
public abstract class Usuario {

    @NotNull(message = "O nome completo não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome completo deve ter entre 3 e 100 caracteres.")
    private String nomeCompleto;

    @NotNull(message = "O RG não pode ser nulo.")
    @Column(unique = true)
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

    private Integer numero;

    @NotNull(message = "A data de nascimento não pode ser nula.")
    private LocalDate dataNascimento;


    public Usuario() {
    }

    public Usuario(String nomeCompleto, String rg, String genero, String estadoCivil, String email, String senha, String telefone, String cep, String endereco, String bairro, String cidade, String estado, Integer numero, LocalDate dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O nome completo não pode ser nulo.") @Size(min = 3, max = 100, message = "O nome completo deve ter entre 3 e 100 caracteres.") String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(@NotNull(message = "O nome completo não pode ser nulo.") @Size(min = 3, max = 100, message = "O nome completo deve ter entre 3 e 100 caracteres.") String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public @NotNull(message = "O RG não pode ser nulo.") @Pattern(regexp = "\\d{9}", message = "O RG deve ter 9 dígitos numéricos.") String getRg() {
        return rg;
    }

    public void setRg(@NotNull(message = "O RG não pode ser nulo.") @Pattern(regexp = "\\d{9}", message = "O RG deve ter 9 dígitos numéricos.") String rg) {
        this.rg = rg;
    }

    public @NotNull(message = "O gênero não pode ser nulo.") String getGenero() {
        return genero;
    }

    public void setGenero(@NotNull(message = "O gênero não pode ser nulo.") String genero) {
        this.genero = genero;
    }

    public @NotNull(message = "O estado civil não pode ser nulo.") String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(@NotNull(message = "O estado civil não pode ser nulo.") String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public @Email(message = "O e-mail deve ser válido.") @NotNull(message = "O e-mail não pode ser nulo.") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "O e-mail deve ser válido.") @NotNull(message = "O e-mail não pode ser nulo.") String email) {
        this.email = email;
    }

    public @NotNull(message = "A senha não pode ser nula.") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull(message = "A senha não pode ser nula.") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.") String senha) {
        this.senha = senha;
    }

    public @NotNull(message = "O telefone não pode ser nulo.") @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve ter o formato (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O telefone não pode ser nulo.") @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve ter o formato (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "O CEP não pode ser nulo.") @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ter o formato 00000-000.") String getCep() {
        return cep;
    }

    public void setCep(@NotNull(message = "O CEP não pode ser nulo.") @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ter o formato 00000-000.") String cep) {
        this.cep = cep;
    }

    public @NotNull(message = "O endereço não pode ser nulo.") @Size(min = 5, max = 200, message = "O endereço deve ter entre 5 e 200 caracteres.") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O endereço não pode ser nulo.") @Size(min = 5, max = 200, message = "O endereço deve ter entre 5 e 200 caracteres.") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O bairro não pode ser nulo.") String getBairro() {
        return bairro;
    }

    public void setBairro(@NotNull(message = "O bairro não pode ser nulo.") String bairro) {
        this.bairro = bairro;
    }

    public @NotNull(message = "A cidade não pode ser nulo.") @Size(min = 5, max = 200, message = "A cidade deve ter entre 5 e 200 caracteres.") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull(message = "A cidade não pode ser nulo.") @Size(min = 5, max = 200, message = "A cidade deve ter entre 5 e 200 caracteres.") String cidade) {
        this.cidade = cidade;
    }

    public @NotNull(message = "O estado não pode ser nulo.") @Size(min = 5, max = 200, message = "O estado deve ter entre 5 e 200 caracteres.") String getEstado() {
        return estado;
    }

    public void setEstado(@NotNull(message = "O estado não pode ser nulo.") @Size(min = 5, max = 200, message = "O estado deve ter entre 5 e 200 caracteres.") String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public @NotNull(message = "A data de nascimento não pode ser nula.") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "A data de nascimento não pode ser nula.") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
