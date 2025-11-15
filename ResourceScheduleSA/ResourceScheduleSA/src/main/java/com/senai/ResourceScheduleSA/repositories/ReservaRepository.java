package com.senai.ResourceScheduleSA.repositories;

import com.senai.ResourceScheduleSA.models.ReservaModel;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel, Long> {
    Optional<ReservaModel> findByUsuarioModelIdAndDataReserva(Long usuarioId, LocalDate dataReserva);
}
