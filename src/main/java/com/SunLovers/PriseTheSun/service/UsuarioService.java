package com.SunLovers.PriseTheSun.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SunLovers.PriseTheSun.Repository.UsuarioRepository;
import com.SunLovers.PriseTheSun.model.Usuario;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    // Método para cadastrar um novo usuário
    public Usuario cadastrarUsuario(Usuario usuario) {
        // Aqui você pode adicionar lógica de validação ou outras operações, se necessário,
        // antes de salvar o usuário no banco de dados.
        return usuarioRepository.save(usuario);
    }
    // verificar  se o usuario existe
    public boolean usuarioExiste(String cpf) {
        return usuarioRepository.existsByCpf(cpf);
    }
    //recuperar usuario
     public Optional<Usuario> getUsuario(long id) {
        return usuarioRepository.findById(id);
    }


}
