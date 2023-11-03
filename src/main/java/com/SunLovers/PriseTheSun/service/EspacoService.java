package com.SunLovers.PriseTheSun.service;

import com.SunLovers.PriseTheSun.model.Espaco;
import com.SunLovers.PriseTheSun.repository.EspacoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacoService {

    private final EspacoRepository espacoRepository;

    public EspacoService(EspacoRepository espacoRepository) {
        this.espacoRepository = espacoRepository;
    }

    public List<Espaco> getAllEspacos() {
        return espacoRepository.findAll();
    }

    public Optional<Espaco> getEspacoById(Long id) {
        return espacoRepository.findById(id);
    }

    public Espaco saveEspaco(Espaco espaco) {
        return espacoRepository.save(espaco);
    }

    public void deleteEspaco(Long id) {
        espacoRepository.deleteById(id);
    }
}
