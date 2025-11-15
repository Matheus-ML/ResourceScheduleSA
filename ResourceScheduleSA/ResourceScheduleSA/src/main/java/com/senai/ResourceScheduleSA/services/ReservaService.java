package com.senai.ResourceScheduleSA.services;

import com.senai.ResourceScheduleSA.dtos.RecursoDto;
import com.senai.ResourceScheduleSA.dtos.ReservaDto;
import com.senai.ResourceScheduleSA.dtos.UsuarioDto;
import com.senai.ResourceScheduleSA.models.RecursoModel;
import com.senai.ResourceScheduleSA.models.ReservaModel;
import com.senai.ResourceScheduleSA.models.UsuarioModel;
import com.senai.ResourceScheduleSA.repositories.RecursoRepository;
import com.senai.ResourceScheduleSA.repositories.ReservaRepository;
import com.senai.ResourceScheduleSA.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;
    private UsuarioRepository usuarioRepository;
    private RecursoRepository recursoRepository;

    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, RecursoRepository recursoRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.recursoRepository = recursoRepository;
    }

    //Criar
    public String cadastrar (ReservaDto dados){
        Optional<UsuarioModel> usuarioOP = usuarioRepository.findById(dados.getUsuarioModel().getId());
        Optional<RecursoModel> recursoOP = recursoRepository.findById(dados.getRecursoModel().getId());

        Optional<ReservaModel> reservaOP = reservaRepository.findByUsuarioModelIdAndDataReserva(dados.getUsuarioModel().getId(), dados.getDataReserva());
        if (reservaOP.isPresent()){
            return "Reserva";
        }

        if (usuarioOP.isPresent() && recursoOP.isPresent()){
            ReservaModel reservaModel = new ReservaModel();
            reservaModel.setRecursoModel(recursoOP.get());
            reservaModel.setUsuarioModel(usuarioOP.get());
            reservaModel.setHoraInicio(dados.getHoraInicio());
            reservaModel.setHoraFinal(dados.getHoraFinal());
            reservaModel.setDataReserva(dados.getDataReserva());
            reservaRepository.save(reservaModel);
            return "Ok";
        }


        return "Erro";
    }

    //Listar
    public List<ReservaDto> listar(){
        List<ReservaModel> listaModel = reservaRepository.findAll();

        List<ReservaDto> listaDto = new ArrayList<>();

        for (ReservaModel reserva : listaModel){
            ReservaDto reservaDto = new ReservaDto();

            reservaDto.setObservacao(reserva.getObservacao());
            reservaDto.setRecursoModel(reserva.getRecursoModel());
            reservaDto.setRecursoTipo(reserva.getRecursoModel().getTipo());
            reservaDto.setUsuarioModel(reserva.getUsuarioModel());
            reservaDto.setUsuarioNome(reserva.getUsuarioModel().getNome());
            reservaDto.setHoraInicio(reserva.getHoraInicio());
            reservaDto.setHoraFinal(reserva.getHoraFinal());
            reservaDto.setDataCancelamento(reserva.getDataCancelamento());
            reservaDto.setDataReserva(reserva.getDataReserva());
            reservaDto.setId(reserva.getId());

            listaDto.add(reservaDto);
        }
        return listaDto;
    }

    //Atualizar
    public Boolean atualizar(Long id, ReservaDto reservaDto){

        Optional<ReservaModel> reservaOP = reservaRepository.findById(id);

        if (reservaOP.isPresent()){
            ReservaModel reserva = new ReservaModel();

            reserva.setId(reservaOP.get().getId());
            reserva.setUsuarioModel(reservaDto.getUsuarioModel());
            reserva.setRecursoModel(reservaDto.getRecursoModel());
            reserva.setHoraInicio(reservaDto.getHoraInicio());
            reserva.setHoraFinal(reservaDto.getHoraFinal());
            reserva.setDataReserva(reservaDto.getDataReserva());

            reservaRepository.save(reserva);
            return true;
        }
        return false;
    }

    public ReservaDto listaPorId(Long id){
        Optional<ReservaModel> reservaOP = reservaRepository.findById(id);

        ReservaDto reservaDto = new ReservaDto();
        if (reservaOP.isPresent()){
            reservaDto.setObservacao(reservaOP.get().getObservacao());
            reservaDto.setRecursoModel(reservaOP.get().getRecursoModel());
            reservaDto.setRecursoTipo(reservaOP.get().getRecursoModel().getTipo());
            reservaDto.setUsuarioModel(reservaOP.get().getUsuarioModel());
            reservaDto.setUsuarioNome(reservaOP.get().getUsuarioModel().getNome());
            reservaDto.setHoraInicio(reservaOP.get().getHoraInicio());
            reservaDto.setHoraFinal(reservaOP.get().getHoraFinal());
            reservaDto.setDataCancelamento(reservaOP.get().getDataCancelamento());
            reservaDto.setDataReserva(reservaOP.get().getDataReserva());
            reservaDto.setId(reservaOP.get().getId());

        }
        return reservaDto;
    }

    public Boolean cancelarReserva(Long id, ReservaDto dados) {

        Optional<ReservaModel> reservaOP = reservaRepository.findById(id);

        if (reservaOP.isPresent()){
            ReservaModel reserva = reservaOP.get();

            long distanciaTempo = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getDataReserva());
            System.out.println("Distancia entre hoje e a data: "+distanciaTempo);

            if (distanciaTempo >= 1){
                reserva.setDataCancelamento(LocalDate.now());
                reserva.setObservacao(dados.getObservacao());
                reservaRepository.save(reserva);
            }

            return true;
        }

        return false;
    }

}
