package com.senai.ResourceScheduleSA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recurso")
public class RecursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tipo")
    private String tipo;

    @Column(name ="diaDisponivel")
    private DiaDisponivel diaDisponivel;

    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    @Column(name = "dataFinal")
    private LocalDate dataFinal;

    @Column(name = "horaInicio")
    private LocalTime horaInicio;

    @Column(name = "horaFinal")
    private LocalTime horaFinal;

}
