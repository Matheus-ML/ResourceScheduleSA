package com.senai.ResourceScheduleSA.services;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.models.RecursoModel;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import org.springframework.stereotype.Service;

@Service
public class RecursoService {

    RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    //Criar

    //Listar

    //Atualizar

    //Excluir
}
