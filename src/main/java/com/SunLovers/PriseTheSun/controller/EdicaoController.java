
package com.SunLovers.PriseTheSun.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.service.EdicaoService;
import com.SunLovers.PriseTheSun.service.EventoService;
import java.time.LocalDate;

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
    public ResponseEntity<String> criarEdicaoParaEvento(
            @PathVariable int eventoId,
            @RequestParam(required = true) int numero,
            @RequestParam(required = true) int ano,
            @RequestParam(required = true) LocalDate dataInicial,
            @RequestParam(required = true) LocalDate dataFinal,
            @RequestParam(required = true) String cidade) {
        Optional<Evento> optionalEvento = eventoService.getEvento(eventoId);
        Evento evento = optionalEvento.orElseThrow(() -> new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Evento não encontrado com o ID: " + eventoId));
        if (edicaoService.verificarExistenciaEdicaoPorAnoEEvento(evento,ano)) {
            String errorMessage = "Edição já existe para esse evento e ano.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Edicao novaEdicao = new Edicao(numero, ano, dataInicial, dataFinal, cidade, evento);
        novaEdicao = edicaoService.salvarEdicao(novaEdicao);

        URI location = ServletUriComponentsBuilder
        .fromCurrentContextPath() // Use fromCurrentContextPath para obter o contexto da aplicação
        .path("/evento/{eventoId}/edicao/{edicaoId}") // Adicione o caminho do endpoint de detalhes da edição
        .buildAndExpand(eventoId, novaEdicao.getId()) // Passe os parâmetros necessários para o caminho
        .toUri();
            return ResponseEntity.created(location).body("Edição Cadastrada com Sucesso");
    }

    // Implemente outros métodos conforme necessário
}