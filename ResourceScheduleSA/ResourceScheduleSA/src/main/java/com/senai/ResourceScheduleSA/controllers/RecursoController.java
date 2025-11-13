package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import com.senai.ResourceScheduleSA.services.RecursoService;
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
    public String cadastrar(@ModelAttribute ("recursoDto") RecursoDto recursoDto, BindingResult result){

        if (!recursoService.verificaDatas(recursoDto)){
            result.rejectValue("dataFinal","data.erro","A data inicial tem que ser após a data final!");
        }

        recursoService.cadastrarRecurso(recursoDto);

        return "redirect:/recursolista";
    }

    @PostMapping("/recurso/{id}")
    public String atualizar (@ModelAttribute ("recursoDto")RecursoDto recursoDto, @PathVariable Long id){
        return "redirect:/usuariolista";
    }

    @DeleteMapping("/recurso/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){

        recursoService.excluir(id);

      return   ResponseEntity.ok().body(true);
    }

}
