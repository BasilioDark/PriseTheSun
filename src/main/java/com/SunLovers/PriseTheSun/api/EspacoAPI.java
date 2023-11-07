package com.SunLovers.PriseTheSun.api;

import com.SunLovers.PriseTheSun.model.Espaco;
import com.SunLovers.PriseTheSun.service.EspacoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/espacos")
@Tag(name = "Espaços", description = "Operações relacionadas aos espaços")
public class EspacoAPI {

    private final EspacoService espacoService;

    public EspacoAPI(EspacoService espacoService) {
        this.espacoService = espacoService;
    }

    @Operation(summary = "Obter todos os espaços")
    @GetMapping
    public List<Espaco> getAllEspacos() {
        return espacoService.getAllEspacos();
    }

    @Operation(summary = "Obter espaço por ID")
    @GetMapping("/{id}")
    public Optional<Espaco> getEspacoById(@Parameter(description = "ID do espaço a ser obtido") @PathVariable Long id) {
        return espacoService.getEspacoById(id);
    }

    @Operation(summary = "Salvar um novo espaço")
    @PostMapping
    public Espaco saveEspaco(@Parameter(description = "Espaço a ser salvo") @RequestBody Espaco espaco) {
        return espacoService.saveEspaco(espaco);
    }
}
