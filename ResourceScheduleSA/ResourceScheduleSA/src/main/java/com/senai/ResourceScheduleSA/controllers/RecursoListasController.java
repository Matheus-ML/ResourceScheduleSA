package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecursoListasController {

    RecursoRepository recursoRepository;

    public RecursoRepository getRecursoRepository() {
        return recursoRepository;
    }

    @GetMapping("/recursolista")
    public String viewRecursoLista(Model model){

        return "recursolista";
    }

    @GetMapping("/recurso/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        return "recursoatualizar";
    }

    @GetMapping("/recurso")
    public String viewCadastrar (Model model){

        return "recursocadastro";
    }


}
