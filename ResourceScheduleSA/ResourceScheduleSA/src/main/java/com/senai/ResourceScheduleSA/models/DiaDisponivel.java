package com.senai.ResourceScheduleSA.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiaDisponivel {

    SEGUNDA_FEIRA(1),
    TERCA_FEIRA(2),
    QUARTA_FEIRA(3),
    QUINTA_FEIRA(4),
    SEXTA_FEIRA(5),
    SABADO(6),
    DOMINGO(7);

    private final int codigo;

}
