package org.prontuario.repositories;

import org.prontuario.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Boolean existsByCrm(String crm);
}
