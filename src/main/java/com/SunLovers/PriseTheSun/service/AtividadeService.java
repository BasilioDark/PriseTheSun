package com.SunLovers.PriseTheSun.service;

import com.SunLovers.PriseTheSun.model.Atividade;
import com.SunLovers.PriseTheSun.repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public List<Atividade> getAllAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade getAtividadeById(Long id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public Atividade saveAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public void deleteAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
}
