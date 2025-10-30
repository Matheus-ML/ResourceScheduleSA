package com.senai.ResourceScheduleSA.repositories;

import com.senai.ResourceScheduleSA.models.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, Long> {
}
