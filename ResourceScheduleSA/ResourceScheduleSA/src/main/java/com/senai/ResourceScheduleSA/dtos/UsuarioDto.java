package com.senai.ResourceScheduleSA.dtos;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
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

    @Past(message = "A data de nascimento deve ser menor que a data atual.")
    private LocalDate data;
}
