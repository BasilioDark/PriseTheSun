package com.SunLovers.PriseTheSun.controller;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> tornarUsuarioOrganizador(@PathVariable Long usuarioId) {
        System.err.println("Ocontrol 1");
        Optional<Usuario> optionalUsuario = usuarioService.getUsuario(usuarioId);
        System.err.println("Ocontrol 2");
        Usuario usuario = optionalUsuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado, id: " + usuarioId));
        System.err.println("Ocontrol 3");
        Organizador organizador = new Organizador(usuario);
        System.err.println("Ocontrol 4");
        organizadorService.salvarOrganizador(organizador,usuario);
System.err.println("Ocontrol 5");
        return ResponseEntity.status(HttpStatus.OK).body("Usuário transformado em Organizador com sucesso");
    }
}