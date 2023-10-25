package com.SunLovers.PriseTheSun.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SunLovers.PriseTheSun.Repository.UsuarioRepository;
import com.SunLovers.PriseTheSun.model.Usuario;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para cadastrar um novo usuário
    public Usuario cadastrarUsuario(Usuario usuario) {
        // Aqui você pode adicionar lógica de validação ou outras operações, se necessário,
        // antes de salvar o usuário no banco de dados.
        return usuarioRepository.save(usuario);
    }


}
