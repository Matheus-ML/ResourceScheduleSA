package com.senai.ResourceScheduleSA.dtos;


import com.senai.ResourceScheduleSA.models.DiaDisponivel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDto {

    private Long id;

    private String descricao;

    private String tipo;

    private DiaDisponivel diaDisponivel;

    //retorna a lista de palavras do ENUM ou seja os dias disponíveis
    public DiaDisponivel[] getDiaDisponivelLista(){
        return DiaDisponivel.values();
    }

    private LocalDate dataInicio;

    private LocalDate dataFinal;

    private LocalTime horaInicio;

    private LocalTime horaFinal;

}
