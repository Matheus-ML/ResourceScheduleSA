package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.DiaDisponivel;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import com.senai.ResourceScheduleSA.services.RecursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RecursoListasController {

    RecursoService recursoService;

    public RecursoListasController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping("/recursolista")
    public String viewRecursoLista(Model model){

        List<RecursoDto> listaDto = recursoService.listaRecurso();

        model.addAttribute("listaDto", listaDto);

        return "recursolista";
    }

    @GetMapping("/recurso/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        RecursoDto recursoDto = recursoService.listarRecursoId(id);

        model.addAttribute("recursoDto", recursoDto);

        return "recursoatualizar";
    }

    @GetMapping("/recursocadastro")
    public String viewCadastrar (Model model){

        model.addAttribute("recursoDto", new RecursoDto());

        return "recursocadastro";
    }


}
