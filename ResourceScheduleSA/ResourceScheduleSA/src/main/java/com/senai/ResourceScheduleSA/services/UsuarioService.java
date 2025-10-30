package com.senai.ResourceScheduleSA.services;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import com.senai.ResourceScheduleSA.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Criar
    public boolean cadastrarUsuario(UsuarioDto usuarioDto){

        UsuarioModel usuarioModel = new UsuarioModel();



    }

    //Listar

    //Atualizar

    //Excluir
}
