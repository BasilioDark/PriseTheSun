
package com.SunLovers.PriseTheSun.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SunLovers.PriseTheSun.dto.EventoDTO;
import com.SunLovers.PriseTheSun.model.Evento;
import com.SunLovers.PriseTheSun.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoAPI {
    private final EventoService eventoService;

 
    public EventoAPI(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    @PostMapping("/cadastrarEvento")
    public ResponseEntity<String> cadastrarEvento(@RequestBody EventoDTO eventoDTO) {
            // Verifica se o usuário já existe (pode ser feita uma lógica de verificação aqui)
            if (eventoService.eventoExiste(eventoDTO.getNome())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Evento Já existe!");
                
            } else {
                Evento evento = new Evento(eventoDTO.getNome(),eventoDTO.getSigla(),eventoDTO.getDescricao());
                // Se o usuário não existe, cadastra o usuário
                eventoService.criarEvento(evento);
                return ResponseEntity.status(HttpStatus.CREATED).body("Evento Cadastrado com Sucesso");
            }
        }
}

