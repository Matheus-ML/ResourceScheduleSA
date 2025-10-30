package com.senai.ResourceScheduleSA.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String matricula;

    private LocalDate data;
}
