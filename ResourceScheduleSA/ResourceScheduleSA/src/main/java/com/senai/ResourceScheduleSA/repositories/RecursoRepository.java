package com.senai.ResourceScheduleSA.repositories;

import com.senai.ResourceScheduleSA.models.RecursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoModel, Long> {
    Optional<RecursoModel> findByTipo(String tipo);
}
