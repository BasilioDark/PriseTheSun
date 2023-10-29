package com.SunLovers.PriseTheSun.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SunLovers.PriseTheSun.model.Organizador;
import com.SunLovers.PriseTheSun.model.Usuario;
import com.SunLovers.PriseTheSun.service.OrganizadorService;
import com.SunLovers.PriseTheSun.service.UsuarioService;

@RestController
@RequestMapping("/api/organizador")
public class OrganizadorController {

    private final UsuarioService usuarioService;
    private final OrganizadorService organizadorService;

    public OrganizadorController(UsuarioService usuarioService, OrganizadorService organizadorService) {
        this.usuarioService = usuarioService;
        this.organizadorService = organizadorService;
    }

    @PostMapping("/{usuarioId}/tornar-organizador")
    public ResponseEntity<String> tornarUsuarioOrganizador(@PathVariable Long usuarioId) throws Exception {
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        Organizador organizador = new Organizador(usuario);
        if (organizadorService.TransformarEmOrganizador(organizador,usuario)){
        return ResponseEntity.status(HttpStatus.OK).body("Usuário transformado em Organizador com sucesso");
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já é organizador ou nao existe usuario");
    }
}