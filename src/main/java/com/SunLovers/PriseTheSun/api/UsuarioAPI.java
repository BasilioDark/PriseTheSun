
package com.SunLovers.PriseTheSun.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SunLovers.PriseTheSun.dto.UsuarioDTO;
import com.SunLovers.PriseTheSun.model.Usuario;
import com.SunLovers.PriseTheSun.service.UsuarioService;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioAPI {

    private final UsuarioService usuarioService;

    
    public UsuarioAPI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint para cadastrar um novo usuário comum
    
    @PostMapping("/cadastrar")
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        
        try {
            Usuario usuario = new Usuario();
            System.out.println("INIIIIIIIIIICIO DEBUG");
            System.err.println(usuarioDTO.toString());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setFiliacao(usuarioDTO.getFiliacao());
            usuario.setSenha(usuarioDTO.getSenha());

            Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso! ID: " + usuarioCadastrado.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/todosUsuarios")
    public ResponseEntity<List<Usuario>> obterTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.obterTodosUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarios);
        }
    }

    
}
