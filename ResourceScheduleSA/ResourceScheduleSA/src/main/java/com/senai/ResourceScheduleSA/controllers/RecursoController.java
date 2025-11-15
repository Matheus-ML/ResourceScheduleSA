package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import com.senai.ResourceScheduleSA.services.RecursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecursoController {

    RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @PostMapping("/recurso")
    public String cadastrar(@Valid @ModelAttribute ("recursoDto") RecursoDto recursoDto, BindingResult result){

        if (result.hasErrors()){
            return "recursocadastro";
        }

        recursoService.cadastrarRecurso(recursoDto);

        return "redirect:/recursolista";
    }

    @PostMapping("/recurso/{id}")
    public String atualizar (@Valid @ModelAttribute ("recursoDto")RecursoDto recursoDto,BindingResult result, @PathVariable Long id){

        if (result.hasErrors()){
            return "recursoatualizar";
        }

        recursoService.atualizar(recursoDto, id);

        return "redirect:/recursolista";
    }

    @DeleteMapping("/recurso/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){

        recursoService.excluir(id);

      return   ResponseEntity.ok().body(true);
    }

}
