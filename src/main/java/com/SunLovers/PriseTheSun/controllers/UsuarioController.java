package com.SunLovers.PriseTheSun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SunLovers.PriseTheSun.model.Usuario;
import com.SunLovers.PriseTheSun.service.UsuarioService;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint para cadastrar um novo usuário comum
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(
            @RequestParam(required = true) String nome,
            @RequestParam(required = true) String senha,
            @RequestParam(required = true) String cpf,
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String filiacao) {
        // Verifica se o usuário já existe (pode ser feita uma lógica de verificação aqui)
        if (usuarioService.usuarioExiste(cpf)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        } else {
            Usuario usuario = new Usuario(nome,senha,cpf,email,filiacao);
            // Se o usuário não existe, cadastra o usuário
            usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
        }
    }
}
