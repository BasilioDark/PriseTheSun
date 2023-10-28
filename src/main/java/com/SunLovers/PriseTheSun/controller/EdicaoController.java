
package com.SunLovers.PriseTheSun.controller;

import java.net.URI;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.service.EdicaoService;
import com.SunLovers.PriseTheSun.service.EventoService;
import java.time.LocalDate;
import jakarta.persistence.NoResultException;

@RestController
@RequestMapping("/api/evento/{eventoId}/edicao")
public class EdicaoController {

    private final EdicaoService edicaoService;
    private final EventoService eventoService;

    public EdicaoController(EdicaoService edicaoService, EventoService eventoService) {
        this.edicaoService = edicaoService;
        this.eventoService = eventoService;
    }

    @PostMapping("/adicionarEdicao")
    public ResponseEntity<Edicao> criarEdicaoParaEvento(@RequestParam(required = true) String numero,
            @RequestParam(required = true) String ano,
            @RequestParam(required = true) LocalDate dataInicial,
            @RequestParam(required = true) LocalDate dataFinal,
            @RequestParam(required = true) String cidade,
            @RequestParam(required = true) int evento_id) {

        Optional<Evento> optionalEvento = eventoService.getEvento(evento_id);
        Evento evento = optionalEvento.orElseThrow(NoResultException::new);
         

        Edicao novaEdicao = new Edicao(evento_id, evento_id, dataInicial, dataFinal, cidade, evento);
        novaEdicao = edicaoService.salvarEdicao(novaEdicao);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaEdicao.getId())
                .toUri();
        return ResponseEntity.created(location).body(novaEdicao);
    }

    // Implemente outros métodos conforme necessário
}