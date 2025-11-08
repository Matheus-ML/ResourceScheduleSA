package com.senai.ResourceScheduleSA.repositories;

import com.senai.ResourceScheduleSA.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByNome(String nome);
    Optional<UsuarioModel> findByEmail(String email);
}
