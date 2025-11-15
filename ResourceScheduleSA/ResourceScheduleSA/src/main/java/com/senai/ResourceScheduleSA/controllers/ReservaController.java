package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.ReservaDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.services.RecursoService;
import com.senai.ResourceScheduleSA.services.ReservaService;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

   private ReservaService reservaService;
   private RecursoService recursoService;
   private UsuarioService usuarioService;

    public ReservaController(ReservaService reservaService, RecursoService recursoService, UsuarioService usuarioService) {
        this.reservaService = reservaService;
        this.recursoService = recursoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/reserva")
    public String cadastrar(@ModelAttribute("reservaDto") ReservaDto dados, Model model){

        String a = reservaService.cadastrar(dados);

        if(a.equals("Reserva")){
            model.addAttribute("erroReserva", "Usuário já possui reserva para essa data.");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }
        if(a.equals("ErroHora")){
            model.addAttribute("erroHora", "A hora de reserva, tem que ser entre o horário permitido do recurso!");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }

        return "redirect:/reservalista";
    }


    @PostMapping("/reserva/{id}")
    public String atualizar(@ModelAttribute("reservaDto")ReservaDto dados, @PathVariable Long id){

        reservaService.atualizar(id, dados);

        return "redirect:/reservalista";
    }


    @PostMapping("/reservacancelar/{id}")
    public String cancelar(@PathVariable Long id, @ModelAttribute ReservaDto dados){

        reservaService.cancelarReserva(id, dados);

        return "redirect:/reservalista";
    }

}
