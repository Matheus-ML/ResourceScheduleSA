package com.senai.ResourceScheduleSA.services;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.RecursoModel;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import com.senai.ResourceScheduleSA.repositories.UsuarioRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {


    private RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository, UsuarioRepository usuarioRepository) {
        this.recursoRepository = recursoRepository;
    }

    //Criar
   public Boolean cadastrarRecurso (RecursoDto recursoDto){

         RecursoModel recursoModel = new RecursoModel();

         recursoModel.setTipo(recursoDto.getTipo());
         recursoModel.setDescricao(recursoDto.getDescricao());
         recursoModel.setDataInicio(recursoDto.getDataInicio());
         recursoModel.setDataFinal(recursoDto.getDataFinal());
         recursoModel.setHoraInicio(recursoDto.getHoraInicio());
         recursoModel.setHoraFinal(recursoDto.getHoraFinal());
         recursoModel.setDiaDisponivel(recursoDto.getDiaDisponivel());
         recursoRepository.save(recursoModel);
         return true;
   }
    //Listar
    public List<RecursoDto> listaRecurso(){

        List<RecursoDto> listaRecursoDto = new ArrayList<>();

        List<RecursoModel> listaRecursoModel = recursoRepository.findAll();

        for (RecursoModel recurso : listaRecursoModel){

            RecursoDto recursoDto = new RecursoDto();
            //--Converter os dados do usuarioModel para usuarioDto

            recursoDto.setTipo(recursoDto.getTipo());
            recursoDto.setDescricao(recursoDto.getDescricao());
            recursoDto.setDataInicio(recursoDto.getDataInicio());
            recursoDto.setDataFinal(recursoDto.getDataFinal());
            recursoDto.setHoraInicio(recursoDto.getHoraInicio());
            recursoDto.setHoraFinal(recursoDto.getHoraFinal());
            recursoDto.setDiaDisponivel(recursoDto.getDiaDisponivel());

            //--adicionar o usuarioDTO na lista de usuarioDTO
            listaRecursoDto.add(recursoDto);
        }
        //--retornar a lista de usuarioDTO
        return  listaRecursoDto;
    }
    //Atualizar
    public Boolean atualizar (RecursoDto recursoDto, Long id){
        Optional<RecursoModel> recursoModel = recursoRepository.findById(id);
        if (recursoModel.isPresent()){

            RecursoModel recursoModelAtualizado = new RecursoModel();

            recursoModelAtualizado.setTipo(recursoDto.getTipo());
            recursoModelAtualizado.setDescricao(recursoDto.getDescricao());
            recursoModelAtualizado.setDataInicio(recursoDto.getDataInicio());
            recursoModelAtualizado.setDataFinal(recursoDto.getDataFinal());
            recursoModelAtualizado.setHoraInicio(recursoDto.getHoraInicio());
            recursoModelAtualizado.setHoraFinal(recursoDto.getHoraFinal());
            recursoModelAtualizado.setDiaDisponivel(recursoDto.getDiaDisponivel());

            recursoRepository.save(recursoModelAtualizado);
            return true;
        }else{
            return false;
        }

    }
    //Excluir
    public Boolean excluir(Long id){
        Optional<RecursoModel> recursoModel = recursoRepository.findById(id);
        if (recursoModel.isPresent()){
            //--Significa que encontro o usuário pelo ID
            recursoRepository.delete(recursoModel.get());
            return true;
            } else{
            return false;
        }
    }

}
