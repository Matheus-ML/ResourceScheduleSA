package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.dtos.ReservaDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.repositories.ReservaRepository;
import com.senai.ResourceScheduleSA.services.RecursoService;
import com.senai.ResourceScheduleSA.services.ReservaService;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReservaListasController {

    private ReservaService reservaService;
    private UsuarioService usuarioService;
    private RecursoService recursoService;

    public ReservaListasController(ReservaService reservaService, UsuarioService usuarioService, RecursoService recursoService) {
        this.reservaService = reservaService;
        this.usuarioService = usuarioService;
        this.recursoService = recursoService;
    }

    @GetMapping("/reservalista")
    public String viewReservaLista(Model model){

        List<ReservaDto> reservaDto = reservaService.listar();

        model.addAttribute("reservaDto", reservaDto);

        return "reservalista";
    }

    @GetMapping("/reserva/{id}")
    public String viewVisualizar(@PathVariable Long id, Model model){

        ReservaDto reservaDto = reservaService.listaPorId(id);
        model.addAttribute("reservaDto", reservaDto);

        return "reservaatualizar";
    }

    @GetMapping("/reservacadastro")
    public String viewCadastrar (Model model){

        List<UsuarioDto> usuarioDtoLista = usuarioService.listaUsuarioDto();
        List<RecursoDto> recursoDtoLista = recursoService.listaRecurso();

        model.addAttribute("usuarioDtoLista", usuarioDtoLista);
        model.addAttribute("recursoDtoLista", recursoDtoLista);
        model.addAttribute("reservaDto", new ReservaDto());

        return "reservacadastro";
    }

    @GetMapping("/reservacancelar/{id}")
    public String viewCancelar(Model model, @PathVariable Long id){

        ReservaDto reservaDto = reservaService.listaPorId(id);

        model.addAttribute("reservaDto", reservaDto);

        return "reservacancelar";
    }

}
