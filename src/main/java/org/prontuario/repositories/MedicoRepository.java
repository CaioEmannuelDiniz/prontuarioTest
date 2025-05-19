package org.prontuario.repositories;

import org.prontuario.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Boolean existsByCrm(String crm);

    Optional<Medico> findByCrm(String crm);
}
