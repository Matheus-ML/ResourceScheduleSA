package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.ReservaDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.services.ReservaService;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

   private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/reserva")
    public String cadastrar(@ModelAttribute("reservaDto") ReservaDto dados){

        return "redirect:/reservalista";
    }


    @PostMapping("/reserva/{id}")
    public String atualizar(@ModelAttribute("reservaDto")ReservaDto dados, @PathVariable Long id){

        return "redirect:/reservalista";
    }


    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){

        return ResponseEntity.ok().body(true);
    }

}
