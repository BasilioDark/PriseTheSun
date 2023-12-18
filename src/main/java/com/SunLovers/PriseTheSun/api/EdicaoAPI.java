
package com.SunLovers.PriseTheSun.api;

import java.net.URI;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping("/eventos/{eventoId}/edicao")
@Tag(name = "Edições", description = "Operações relacionadas a edições")
public class EdicaoAPI {
    private final EdicaoService edicaoService;
    private final EventoService eventoService;

    public EdicaoAPI(EdicaoService edicaoService, EventoService eventoService) {
        this.edicaoService = edicaoService;
        this.eventoService = eventoService;
    }

    @PostMapping("/cadastrarEdicao")
    @Operation(summary = "Criar edição para um evento específico",
            description = "Cria uma nova edição para um evento existente. A URI da nova edição é gerada e retornada em caso de sucesso.")
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
                edicaoDTO.getDataFinal(),
                edicaoDTO.getCidade(),
                edicaoDTO.getChamadaTrabalhos(),
                edicaoDTO.getDataLimiteSubmissao(),
                edicaoDTO.getDataDivulgacaoTrabalhos(),
                edicaoDTO.getDataEntregaFinal(),
                edicaoDTO.getInformacoesInscricoes(),
                edicaoDTO.getPrecoLote1(),
                edicaoDTO.getPrecoLote2(),
                edicaoDTO.getLinkInscricoes(),
                evento);
        edicao = edicaoService.salvarEdicao(edicao);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath() // Use fromCurrentContextPath para obter o contexto da aplicação
                .path("/evento/{eventoId}/edicao/{edicaoId}") // Adicione o caminho do endpoint de detalhes da edição
                .buildAndExpand(eventoId, edicao.getId()) // Passe os parâmetros necessários para o caminho
                .toUri();
        return ResponseEntity.created(location).body("Edição Cadastrada com Sucesso");
    }

    @GetMapping("/{edicaoId}")
    @Operation(summary = "Obter detalhes de uma edição específica",
            description = "Retorna os detalhes da edição identificada pelo ID fornecido, associada ao evento especificado pelo eventoId.")
    @ApiResponse(responseCode = "200", description = "Detalhes da edição obtidos com sucesso",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"numero\": 1, \"ano\": 2021, \"dataInicial\": \"2021-01-01\", \"dataFinal\": \"2021-01-10\", \"cidade\": \"Cidade Exemplo\"}"),
                    schema = @Schema(implementation = EdicaoDTO.class)))
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
                edicao.getCidade(),
                edicao.getChamadaTrabalhos(),
                edicao.getDataLimiteSubmissao(),
                edicao.getDataDivulgacaoTrabalhos(),
                edicao.getDataEntregaFinal(),
                edicao.getInformacoesInscricoes(),
                edicao.getPrecoLote1(),
                edicao.getPrecoLote2(),
                edicao.getLinkInscricoes());

        return ResponseEntity.status(HttpStatus.OK).body(edicaoDTO);
    }

}