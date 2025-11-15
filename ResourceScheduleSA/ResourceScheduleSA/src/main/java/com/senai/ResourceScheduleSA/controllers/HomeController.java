package com.senai.ResourceScheduleSA.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session) {
        // VERIFICAÇÃO SIMPLES: Se não tem usuário na sessão, vai para login
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        return "home";
    }
}