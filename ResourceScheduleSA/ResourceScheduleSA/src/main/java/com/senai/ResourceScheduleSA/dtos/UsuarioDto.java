package com.senai.ResourceScheduleSA.dtos;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;

    private String nome;

    private String email;
        @Pattern(
                    regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$",
                    message = "A senha deve ter pelo menos 5 caracteres, sendo somente letras e numeros."
            )
    private String senha;

    private String matricula;

    @NotNull(message = "Informe uma data de nascimento válida.")
    @Past(message = "A data de nascimento deve ser menor que a data atual.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;
}
