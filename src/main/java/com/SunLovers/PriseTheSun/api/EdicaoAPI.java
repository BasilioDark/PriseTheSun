
package com.SunLovers.PriseTheSun.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SunLovers.PriseTheSun.dto.EdicaoDTO;
import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.service.EdicaoService;
import com.SunLovers.PriseTheSun.service.EventoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/evento/{eventoId}/edicao")
@Tag(name = "Edições", description = "Operações relacionadas a edições")
public class EdicaoAPI {
    private final EdicaoService edicaoService;
    private final EventoService eventoService;

    public EdicaoAPI(EdicaoService edicaoService, EventoService eventoService) {
        this.edicaoService = edicaoService;
        this.eventoService = eventoService;
    }

    @PostMapping("/cadastrarEdicao")
    public ResponseEntity<String> criarEdicaoParaEvento(
            @PathVariable int eventoId,
            @RequestBody EdicaoDTO edicaoDTO) {
        Optional<Evento> optionalEvento = eventoService.getEvento(eventoId);
        Evento evento = optionalEvento.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Evento não encontrado com o ID: " + eventoId));
        if (edicaoService.verificarExistenciaEdicaoPorAnoEEvento(evento, edicaoDTO.getAno())) {
            String errorMessage = "Edição já existe para esse evento e ano.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Edicao edicao = new Edicao(
                edicaoDTO.getNumero(),
                edicaoDTO.getAno(),
                edicaoDTO.getDataInicial(),
                edicaoDTO.getDataFinal(), edicaoDTO.getCidade(), evento);
        edicao = edicaoService.salvarEdicao(edicao);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath() // Use fromCurrentContextPath para obter o contexto da aplicação
                .path("/evento/{eventoId}/edicao/{edicaoId}") // Adicione o caminho do endpoint de detalhes da edição
                .buildAndExpand(eventoId, edicao.getId()) // Passe os parâmetros necessários para o caminho
                .toUri();
        return ResponseEntity.created(location).body("Edição Cadastrada com Sucesso");
    }

    @GetMapping("/{edicaoId}")
    public ResponseEntity<EdicaoDTO> obterDetalhesEdicao(
            @PathVariable long eventoId,
            @PathVariable long edicaoId) {
        Edicao edicao = edicaoService.buscarPorId(edicaoId);
        if (edicao == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Edição não encontrada com o ID: " + edicaoId);
        }
        EdicaoDTO edicaoDTO = new EdicaoDTO(
                edicao.getNumero(),
                edicao.getAno(),
                edicao.getDataInicial(),
                edicao.getDataFinal(),
                edicao.getCidade());

        return ResponseEntity.status(HttpStatus.OK).body(edicaoDTO);
    }

    // Implemente outros métodos conforme necessário
}