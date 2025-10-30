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
@Table(name = "reserva")
public class ReservaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UsuarioModel usuarioModel;

    @OneToOne
    private RecursoModel recursoModel;

    @Column(name = "dataReserva")
    private LocalDate dataReserva;

    @Column(name = "horaInicio")
    private LocalTime horaInicio;

    @Column(name = "horaFinal")
    private LocalTime horaFinal;

    @Column(name = "dataCancelamento")
    private LocalDate dataCancelamento;

    @Column(name = "observacao")
    private String observacao;


}
