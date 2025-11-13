package com.senai.ResourceScheduleSA.services;

import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import com.senai.ResourceScheduleSA.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Criar
    public Boolean cadastrarUsuario(UsuarioDto usuarioDto){

        Optional<UsuarioModel> usuarioOP = usuarioRepository.findByEmail(usuarioDto.getEmail());

            UsuarioModel usuarioModel = new UsuarioModel();
            usuarioModel.setNome(usuarioDto.getNome());
            usuarioModel.setSenha(usuarioDto.getSenha());
            usuarioModel.setEmail(usuarioDto.getEmail());
            usuarioModel.setMatricula(usuarioDto.getMatricula());
            usuarioModel.setData(usuarioDto.getData());

            usuarioRepository.save(usuarioModel);
            return true;

    }
    //Listar
        public List<UsuarioDto> listaUsuarioDto(){

            List<UsuarioDto> listaUsuarioDto = new ArrayList<>();

            List<UsuarioModel> listaUsuarioModel = usuarioRepository.findAll();




            for (UsuarioModel usuario : listaUsuarioModel){


                UsuarioDto usuarioDto = new UsuarioDto();
                //--Converter os dados do usuarioModel para usuarioDto

                usuarioDto.setId(usuario.getId());
                usuarioDto.setNome(usuario.getNome());
                usuarioDto.setSenha(usuario.getSenha());
                usuarioDto.setEmail(usuario.getEmail());
                usuarioDto.setData(usuario.getData());
                usuarioDto.setMatricula(usuario.getMatricula());

                //--adicionar o usuarioDTO na lista de usuarioDTO
                listaUsuarioDto.add(usuarioDto);
            }
            //--retornar a lista de usuarioDTO
            return listaUsuarioDto;
        }
    //Atualizar
    public Boolean atualizar(Long id, UsuarioDto usuarioDto){
            Optional<UsuarioModel> usuarioOP = usuarioRepository.findById(id);

            if (usuarioOP.isPresent()){

                Optional<UsuarioModel> usuarioVerificaEmail = usuarioRepository.findByEmail(usuarioDto.getEmail());

                if (usuarioVerificaEmail.isPresent()){
                    return false;
                }

                UsuarioModel usuario = usuarioOP.get();

                usuario.setNome(usuarioDto.getNome());
                usuario.setSenha(usuarioDto.getSenha());
                usuario.setEmail(usuarioDto.getEmail());
                usuario.setData(usuarioDto.getData());
                usuario.setMatricula(usuarioDto.getMatricula());

                usuarioRepository.save(usuario);
                return true;
            }else{
                //Ver retorno ao dar errada o método
                return false;
            }
    }

    //Excluir
    public Boolean excluir(Long id){

            Optional<UsuarioModel> usuarioOP = usuarioRepository.findById(id);

            if (usuarioOP.isPresent()){
                //--Significa que encontro o usuário pelo ID
                usuarioRepository.delete(usuarioOP.get());
                return true;
            } else{
            return false;
        }

    }

    public UsuarioDto listaUsuarioId(Long id){

        Optional<UsuarioModel> usuarioOP = usuarioRepository.findById(id);

        if (usuarioOP.isPresent()){
            UsuarioDto usuarioDto = new UsuarioDto();

            usuarioDto.setId(usuarioOP.get().getId());
            usuarioDto.setNome(usuarioOP.get().getNome());
            usuarioDto.setEmail(usuarioOP.get().getEmail());
            usuarioDto.setSenha(usuarioOP.get().getSenha());
            usuarioDto.setMatricula(usuarioOP.get().getMatricula());
            usuarioDto.setData(usuarioOP.get().getData());

            return usuarioDto;
        }
        return null;
    }

    public boolean emailExiste(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }


    public boolean emailExisteParaOutroUsuario(String email, Long idAtual) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);
        return usuario.isPresent() && !usuario.get().getId().equals(idAtual);
    }

    public boolean validarSenha(String senhaInvalida) {
        return senhaInvalida.matches("[a-zA-Z0-9]+");
    }
}
