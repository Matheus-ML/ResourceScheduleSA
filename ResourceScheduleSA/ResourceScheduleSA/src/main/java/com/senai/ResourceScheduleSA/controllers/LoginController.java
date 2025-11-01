package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String viewLogin(Model model){

        UsuarioDto usuarioDto = new UsuarioDto();

        model.addAttribute("usuarioDto", usuarioDto);

        return "login";
    }
}
