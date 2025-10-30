package com.senai.ResourceScheduleSA.dtos;

import com.senai.ResourceScheduleSA.models.RecursoModel;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto {
    private Long id;

    private UsuarioModel usuarioModel;

    private RecursoModel recursoModel;

    private LocalDate dataReserva;

    private LocalTime horaInicio;

    private LocalTime horaFinal;

    private LocalDate dataCancelamento;

    private String observacao;
}
