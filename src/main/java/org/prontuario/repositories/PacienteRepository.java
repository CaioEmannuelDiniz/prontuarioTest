package org.prontuario.repositories;

import org.prontuario.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Boolean existsByCpf(String cpf);
    List<Paciente> findByNomeCompleto(String name);
    Optional<Paciente> findByCpf(String cpf);


}
