package com.SunLovers.PriseTheSun.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.repository.EdicaoRepository;

import jakarta.validation.ConstraintViolationException;

import java.util.List;


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

    public Edicao buscarPorId(Long id) {
        return edicaoRepository.findById(id).orElse(null);
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
