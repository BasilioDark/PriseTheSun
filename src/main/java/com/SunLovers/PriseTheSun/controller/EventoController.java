package com.SunLovers.PriseTheSun.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final EventoService eventoService;

 
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    @PostMapping("/cadastrarEvento")
    public ResponseEntity<String> cadastrarEvento(
                @RequestParam(required = true) String nome,
                @RequestParam(required = true) String sigla,
                @RequestParam(required = true) String descricao) {
            // Verifica se o usuário já existe (pode ser feita uma lógica de verificação aqui)
            if (eventoService.eventoExiste(nome)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Evento Já existe!");
            } else {
                Evento evento = new Evento(nome,sigla,descricao);
                // Se o usuário não existe, cadastra o usuário
                eventoService.criarEvento(evento);
                return ResponseEntity.status(HttpStatus.CREATED).body("Evento Cadastrado com Sucesso");
            }
        }
}

