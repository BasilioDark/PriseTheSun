package com.SunLovers.PriseTheSun.api;

import com.SunLovers.PriseTheSun.dto.AtividadeDTO;
import com.SunLovers.PriseTheSun.model.Atividade;
import com.SunLovers.PriseTheSun.service.AtividadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/atividades")
@Tag(name = "Atividades", description = "Operações relacionadas a atividades")
public class AtividadeAPI {

    private final AtividadeService atividadeService;

    public AtividadeAPI(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @GetMapping
    @Operation(summary = "Obter todas as atividades")
    public List<Atividade> getAllAtividades() {
        return atividadeService.getAllAtividades();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter uma atividade pelo ID")
    public Atividade getAtividadeById(@PathVariable Long id) {
        return atividadeService.getAtividadeById(id);
    }

    @GetMapping("/simplificada/{id}")
    @Operation(summary = "Obter uma atividade simplificada pelo ID")
    public AtividadeDTO getAtividadeSimplificadaById(@PathVariable Long id) {
        return atividadeService.getAtividadeSimplificadaById(id);
    }

    @PostMapping
    @Operation(summary = "Criar uma nova atividade")
    public Atividade createAtividade(@RequestBody Atividade atividade) {
        return atividadeService.saveAtividade(atividade);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma atividade pelo ID")
    public Atividade updateAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
        atividade.setId(id);
        return atividadeService.saveAtividade(atividade);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir uma atividade pelo ID")
    public void deleteAtividade(@PathVariable Long id) {
        atividadeService.deleteAtividade(id);
    }
}
