package com.senai.ResourceScheduleSA.controllers;

import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Método que envia os dados para o service fazer o cadastro e faz o redirecionamento para a tela de lista do usuario.
    @PostMapping("/usuario")
    public String cadastrar(@Valid @ModelAttribute("usuarioDto") UsuarioDto dados, BindingResult result, Model model) {

        // Verifica duplicidade de e-mail
        if (usuarioService.emailExiste(dados.getEmail())) {
            result.rejectValue("email","email.duplicado","O e-mail informado já está cadastrado. Tente outro!");
        }

        // Verificação caso o usuario tenha inserido uma data de mais de 500 anos atras.
        if (dados.getData() != null) {
            LocalDate hoje = LocalDate.now();
            LocalDate limiteAntigo = hoje.minusYears(500);

            if (dados.getData().isBefore(limiteAntigo)) {
                result.rejectValue("data","data.500","A data de nascimento não pode ter mais de 500 anos.");
            }
        }

        // Verificação padrão do Spring (senha, data futura, campos obrigatórios)
        if (result.hasErrors()) {
            return "usuariocadastro";
        }

        usuarioService.cadastrarUsuario(dados);
        return "redirect:/usuariolista";
    }

    //Método que envia os dados para o service fazer a atualização e faz o redirecionamento para a tela de lista do usuario.
    @PostMapping("/usuario/{id}")
    public String atualizar(@Valid @ModelAttribute("usuarioDto")UsuarioDto dados, @PathVariable Long id){

        usuarioService.atualizar(id, dados);

        return "redirect:/usuariolista";
    }

    //Método que o id ao service para fazer a exclusão e retorna OK, para o cliente
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){

        usuarioService.excluir(id);

        return ResponseEntity.ok().body(true);
    }



}
