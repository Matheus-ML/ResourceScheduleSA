package com.senai.ResourceScheduleSA.dtos;


import com.senai.ResourceScheduleSA.models.DiaDisponivel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDto {

    private Long id;

    private String descricao;

    private String tipo;

    private List<DiaDisponivel> diaDisponivel;

    //retorna a lista de palavras do ENUM ou seja os dias disponíveis
    public DiaDisponivel[] getDiaDisponivelLista(){
        return DiaDisponivel.values();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaInicio;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaFinal;

}
