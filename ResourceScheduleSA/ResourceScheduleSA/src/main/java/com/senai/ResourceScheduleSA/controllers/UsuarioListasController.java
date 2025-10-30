package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioListasController {

    private UsuarioService usuarioService;

    public UsuarioListasController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){
        
        return "usuariolista";
    }

    @GetMapping("/usuario/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        return "usuarioatualizar";
    }

    @GetMapping("/usuario")
    public String viewCadastrar(Model model){

        return "usuariocadastro";
    }

}
