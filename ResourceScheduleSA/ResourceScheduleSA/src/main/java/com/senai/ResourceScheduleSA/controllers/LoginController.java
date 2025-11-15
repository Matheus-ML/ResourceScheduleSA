package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String viewLogin(Model model) {

        UsuarioDto usuarioDto = new UsuarioDto();

        model.addAttribute("usuarioDto", usuarioDto);

        return "login";
    }


    @PostMapping("/login")
    public String autenticar(UsuarioDto usuarioDto, HttpSession session) {

        UsuarioModel usuarioModel = usuarioService.autenticar(usuarioDto.getEmail(), usuarioDto.getSenha());

        if (usuarioModel != null) {
            session.setAttribute("usuarioLogado", usuarioModel);
            return "redirect:/home"; // lança par ao home
        }

        return "redirect:/login?erro=true";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // encerra a sessão
        return "redirect:/login";
    }


}





