package com.SunLovers.PriseTheSun.api;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SunLovers.PriseTheSun.dto.UsuarioDTO;
import com.SunLovers.PriseTheSun.model.Usuario;
import com.SunLovers.PriseTheSun.service.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuarios", description = "Operações relacionadas aos usuarios")
public class UsuarioAPI {

    private final UsuarioService usuarioService;

    
    public UsuarioAPI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar usuário na plataforma.",
            description = "Cadastra um novo usuário comum na plataforma. Recebe um objeto UsuarioDTO contendo informações do usuário.")

    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        
        try {
            Usuario usuario = new Usuario();
            usuario.atualizarUsuario(
                usuarioDTO.getNome(),
                usuarioDTO.getSenha(),
                usuarioDTO.getCpf(),
                usuarioDTO.getEmail(),
                usuarioDTO.getFiliacao());
            Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso! ID: " + usuarioCadastrado.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/todosUsuarios")
    @Operation(summary = "Obter lista com todos os usuários na plataforma.",
            description = "Retorna uma lista contendo todos os usuários cadastrados na plataforma.")
    public ResponseEntity<List<Usuario>> obterTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.obterTodosUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarios);
        }
    }

    @GetMapping("/validarUsuario")
    @Operation(summary = "Validar login do usuário na plataforma",
            description = "Valida as credenciais do usuário (CPF e senha) para login na plataforma.")
    @Parameter(description = "CPF do usuário", required = true)
    @Parameter(description = "Senha do usuário", required = true)
    public ResponseEntity<String> validarUsuario(@RequestParam String cpf,@RequestParam String senha) {
    boolean resposta = usuarioService.ValidarUsuario(cpf, senha);
    if (resposta == true) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("login validado com sucesso");
    }
    else{ return ResponseEntity.status(HttpStatus.NOT_FOUND).body("login invalido");}
        
    }
}
