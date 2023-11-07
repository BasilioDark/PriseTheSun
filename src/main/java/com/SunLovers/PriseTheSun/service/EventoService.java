package com.SunLovers.PriseTheSun.service;

import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.SunLovers.PriseTheSun.dto.EventoDTO;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.repository.EventoRepository;



@Service
public class EventoService {
    
    private final EventoRepository eventoRepository;

    
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public boolean eventoExiste(String nome) {
        return eventoRepository.existsByNome(nome);
    }

     public Optional<Evento> getEvento(int id){
        return eventoRepository.findById((long)id);
    }
     public List<EventoDTO> listarEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        return eventos.stream()
                .map(evento -> new EventoDTO(evento.getNome(), evento.getSigla(), evento.getDescricao()))
                .collect(Collectors.toList());
    }
}
