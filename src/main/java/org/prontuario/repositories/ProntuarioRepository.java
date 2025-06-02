package org.prontuario.repositories;

import org.prontuario.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

    Optional<Prontuario> findByCodigoProntuario(Long codigoProntuario);
}
