package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UsuarioListasController {

    private UsuarioService usuarioService;

    public UsuarioListasController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){

        List<UsuarioDto> listaDto = usuarioService.listaUsuarioDto();

        model.addAttribute("listaDto", listaDto);

        return "usuariolista";
    }

    @GetMapping("/usuario/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        UsuarioDto usuarioDto = usuarioService.listaUsuarioId(id);

        model.addAttribute("usuarioDto", usuarioDto);

        return "usuarioatualizar";
    }

    @GetMapping("/usuariocadastro")
    public String viewCadastrar(Model model){

        model.addAttribute("usuarioDto", new UsuarioDto());

        return "usuariocadastro";
    }

}
