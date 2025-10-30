package com.senai.ResourceScheduleSA.repositories;

import com.senai.ResourceScheduleSA.models.RecursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoModel, Long> {
}
