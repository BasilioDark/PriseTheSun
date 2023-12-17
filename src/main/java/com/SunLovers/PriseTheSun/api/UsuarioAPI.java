package com.SunLovers.PriseTheSun.api;

import java.util.List;

import com.SunLovers.PriseTheSun.model.Atividade;
import com.SunLovers.PriseTheSun.model.Favorite;
import com.SunLovers.PriseTheSun.service.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SunLovers.PriseTheSun.dto.UsuarioDTO;
import com.SunLovers.PriseTheSun.model.Usuario;
import com.SunLovers.PriseTheSun.service.UsuarioService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuarios", description = "Operações relacionadas aos usuarios")
public class UsuarioAPI {

    private final UsuarioService usuarioService;
    private final FavoriteService favoriteService;

    public UsuarioAPI(UsuarioService usuarioService, FavoriteService favoriteService) {
        this.usuarioService = usuarioService;
        this.favoriteService = favoriteService;
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

    @PostMapping("/{usuarioId}/favorite/{atividadeId}")
    @Operation(summary = "Usuário favorita uma Atividade")
    public ResponseEntity<String> favoriteAtividade(@PathVariable Long usuarioId, @PathVariable Long atividadeId) {
        try {
            Favorite favorite = favoriteService.addFavorite(usuarioId, atividadeId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Atividade favoritada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao favoritar atividade: " + e.getMessage());
        }
    }

    @DeleteMapping("/{usuarioId}/favorite/{atividadeId}")
    @Operation(summary = "Usuário desfavorita uma Atividade")
    public ResponseEntity<String> unfavoriteAtividade(@PathVariable Long usuarioId, @PathVariable Long atividadeId) {
        try {
            favoriteService.removeFavorite(usuarioId, atividadeId);
            return ResponseEntity.status(HttpStatus.OK).body("Atividade desfavoritada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao desfavoritar atividade: " + e.getMessage());
        }
    }

    @GetMapping("/{usuarioId}/favorites")
    @Operation(summary = "Lista todas as Atividades favoritas")
    public ResponseEntity<?> listFavorites(@PathVariable Long usuarioId) {
        try {
            List<Atividade> favorites = favoriteService.listFavorites(usuarioId);
            if (favorites.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(favorites);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao listar as atividades favoritas. Por favor, tente novamente mais tarde.");
        }
    }


}
