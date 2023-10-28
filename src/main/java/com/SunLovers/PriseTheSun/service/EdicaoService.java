package com.SunLovers.PriseTheSun.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.SunLovers.PriseTheSun.Repository.EdicaoRepository;
import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Evento;

import jakarta.validation.ConstraintViolationException;

import java.util.List;
import java.util.Optional;

@Service
public class EdicaoService {

    private final EdicaoRepository edicaoRepository;
    public EdicaoService(EdicaoRepository edicaoRepository) {
        this.edicaoRepository = edicaoRepository;
    }

    public Edicao salvarEdicao(Edicao edicao) {
        try {
            return edicaoRepository.save(edicao);
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new RuntimeException("Erro: A combinação de ano e evento já existe.");
            }
            throw e;
        }
    }

    public Optional<Edicao> buscarPorId(Long id) {
        return edicaoRepository.findById(id);
    }

    public List<Edicao> listarTodasEdicoes() {
        return edicaoRepository.findAll();
    }

    public void deletarEdicao(Long id) {
        edicaoRepository.deleteById(id);
    }
    public boolean verificarExistenciaEdicaoPorAnoEEvento(Evento evento, int ano) {
        return edicaoRepository.existsByEventoAndAno(evento, ano);
    }
    public List<Edicao> listarEdicoesDeEvento(Evento evento) {
        return edicaoRepository.findByEvento(evento);
    }
}
