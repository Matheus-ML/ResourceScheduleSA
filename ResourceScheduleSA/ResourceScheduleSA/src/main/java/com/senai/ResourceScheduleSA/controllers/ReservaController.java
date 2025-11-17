package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.ReservaDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.services.RecursoService;
import com.senai.ResourceScheduleSA.services.ReservaService;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String cadastrar(@ModelAttribute("reservaDto") ReservaDto dados, Model model, BindingResult result){

        if(reservaService.verificaUsuarioReservas(dados)){
            result.rejectValue("dataReserva", "data.erro", "O usuário já tem uma reserva para esse dia, escolha outro!");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }

        if (reservaService.verificaRecursoReservas(dados)){
            result.rejectValue("dataReserva", "data.erro", "Esse recurso já está reservado para esse dia!");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }

        if (!reservaService.verificaDataRecurso(dados)){
            result.rejectValue("dataReserva", "recurso.erro","A data de reserva não pode ser anterior a data inicial ou posterior a data final do recurso!");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }

        if(!reservaService.verificaHorasRecurso(dados)){
            result.rejectValue("horaInicio", "hora.erro", "As horas selecionadas, precisam estar entre as horas do tipo selecionado!");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }

        if (!reservaService.verificaHoraReserva(dados)){
            result.rejectValue("horaFinal", "hora.erro","A hora inicial não pode ser igual ou após a hora final!");
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }

        if (!reservaService.verificaDiasDisponiveis(dados)){
            String diasDisponiveis = reservaService.devolveDias(dados);
            result.rejectValue("recursoModel", "recurso.erro","Essa data, corresponde a um dia indisponível para agendar esse recurso!\n"+"Os dias disponíveis do recurso: "+diasDisponiveis);
            model.addAttribute("usuarioDtoLista", usuarioService.listaUsuarioDto());
            model.addAttribute("recursoDtoLista", recursoService.listaRecurso());
            return "reservacadastro";
        }



        if(result.hasErrors()){
            return "reservacadastro";
        }

        String a = reservaService.cadastrar(dados);

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
