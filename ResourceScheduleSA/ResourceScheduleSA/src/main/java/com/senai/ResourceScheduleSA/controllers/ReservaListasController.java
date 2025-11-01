package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.repositories.ReservaRepository;
import com.senai.ResourceScheduleSA.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReservaListasController {

    ReservaService reservaService;

    public ReservaListasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/reservalista")
    public String viewReservaLista(Model model){

        return "reservalista";
    }

    @GetMapping("/reserva/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        return "reservaatualizar";
    }

    @GetMapping("/reserva")
    public String viewCadastrar (Model model){

        return "reservacadastro";
    }

}
