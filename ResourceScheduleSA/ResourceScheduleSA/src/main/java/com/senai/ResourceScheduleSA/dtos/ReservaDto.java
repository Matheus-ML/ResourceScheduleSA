package com.senai.ResourceScheduleSA.dtos;

import com.senai.ResourceScheduleSA.models.RecursoModel;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto {
    private Long id;

    private UsuarioModel usuarioModel;

    private RecursoModel recursoModel;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataReserva;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaInicio;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaFinal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCancelamento;

    private String observacao;
}
