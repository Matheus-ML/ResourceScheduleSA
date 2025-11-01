package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecursoController {

    RecursoRepository recursoRepository;

    public RecursoRepository getRecursoRepository() {
        return recursoRepository;
    }

    @PostMapping("/recurso")
    public String cadastrar(@ModelAttribute ("recursoDto") RecursoDto recursoDto){

        return "redirect:/recursolista";

    }

    @PostMapping("/recurso/{id}")
    public String atualizar (@ModelAttribute ("recursoDto")RecursoDto recursoDto, @PathVariable Long id){
        return "redirect:/usuariolista";
    }

    @DeleteMapping("/recurso/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
      return   ResponseEntity.ok().body(true);
    }

}
