package com.senai.ResourceScheduleSA.services;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.DiaDisponivel;
import com.senai.ResourceScheduleSA.models.RecursoModel;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import com.senai.ResourceScheduleSA.repositories.UsuarioRepository;
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
    public Boolean cadastrarRecurso(RecursoDto recursoDto) {

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
    public List<RecursoDto> listaRecurso() {

        List<RecursoDto> listaRecursoDto = new ArrayList<>();

        List<RecursoModel> listaRecursoModel = recursoRepository.findAll();

        for (RecursoModel recurso : listaRecursoModel) {

            RecursoDto recursoDto = new RecursoDto();
            //--Converter os dados do usuarioModel para usuarioDto

            recursoDto.setId(recurso.getId());
            recursoDto.setTipo(recurso.getTipo());
            recursoDto.setDescricao(recurso.getDescricao());
            recursoDto.setDataInicio(recurso.getDataInicio());
            recursoDto.setDataFinal(recurso.getDataFinal());
            recursoDto.setHoraInicio(recurso.getHoraInicio());
            recursoDto.setHoraFinal(recurso.getHoraFinal());
            recursoDto.setDiaDisponivelTexto(converteDiaDisponivel(recurso.getDiaDisponivel()));

            //--adicionar o usuarioDTO na lista de usuarioDTO
            listaRecursoDto.add(recursoDto);
        }
        //--retornar a lista de usuarioDTO
        return listaRecursoDto;
    }

    //Atualizar
    public Boolean atualizar(RecursoDto recursoDto, Long id) {
        Optional<RecursoModel> recursoModel = recursoRepository.findById(id);
        if (recursoModel.isPresent()) {

            RecursoModel recursoModelAtualizado = new RecursoModel();

            recursoModelAtualizado.setId(recursoModel.get().getId());
            recursoModelAtualizado.setTipo(recursoDto.getTipo());
            recursoModelAtualizado.setDescricao(recursoDto.getDescricao());
            recursoModelAtualizado.setDataInicio(recursoDto.getDataInicio());
            recursoModelAtualizado.setDataFinal(recursoDto.getDataFinal());
            recursoModelAtualizado.setHoraInicio(recursoDto.getHoraInicio());
            recursoModelAtualizado.setHoraFinal(recursoDto.getHoraFinal());
            recursoModelAtualizado.setDiaDisponivel(recursoDto.getDiaDisponivel());

            recursoRepository.save(recursoModelAtualizado);
            return true;
        } else {
            return false;
        }

    }

    //Excluir
    public Boolean excluir(Long id) {
        Optional<RecursoModel> recursoModel = recursoRepository.findById(id);

        if (recursoModel.isPresent()) {
            //--Significa que encontro o usuário pelo ID
            recursoRepository.delete(recursoModel.get());
            return true;
        } else {
            return false;
        }
    }

    //Listar por ID
    public RecursoDto listarRecursoId(Long id) {

        Optional<RecursoModel> recursoOP = recursoRepository.findById(id);
        RecursoDto recursoDto = new RecursoDto();

        if (recursoOP.isPresent()) {
            recursoDto.setId(recursoOP.get().getId());
            recursoDto.setDescricao(recursoOP.get().getDescricao());
            recursoDto.setTipo(recursoOP.get().getTipo());
            recursoDto.setDataInicio(recursoOP.get().getDataInicio());
            recursoDto.setDataFinal(recursoOP.get().getDataFinal());
            recursoDto.setHoraInicio(recursoOP.get().getHoraInicio());
            recursoDto.setHoraFinal(recursoOP.get().getHoraFinal());
            recursoDto.setDiaDisponivel(recursoOP.get().getDiaDisponivel());
        }

        return recursoDto;
    }

    public boolean verificaDatas(RecursoDto dados){
        if (dados.getDataInicio().isAfter(dados.getDataFinal()) || dados.getDataInicio().equals(dados.getDataFinal())){
            return true;
        }
        return false;
    }

    public boolean verificaHoras(RecursoDto dados){
        if (dados.getHoraInicio().isAfter(dados.getHoraFinal()) || dados.getHoraInicio().equals(dados.getHoraFinal())){
            return true;
        }
        return false;
    }

    public String converteDiaDisponivel(List<DiaDisponivel> diaDisponiveis){

        if (diaDisponiveis == null || diaDisponiveis.isEmpty()){
            return "";
        }

        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < diaDisponiveis.size(); i++) {
            texto.append(diaDisponiveis.get(i).getDescricao());
            if (i < diaDisponiveis.size() - 1) {
                texto.append(", ");
            }
        }
        return texto.toString();
        }
}
