package com.SunLovers.PriseTheSun.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.SunLovers.PriseTheSun.Repository.EventoRepository;
import com.SunLovers.PriseTheSun.model.Evento;

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
}
