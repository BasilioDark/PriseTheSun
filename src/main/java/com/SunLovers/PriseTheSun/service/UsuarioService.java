package com.SunLovers.PriseTheSun.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SunLovers.PriseTheSun.model.Usuario;
import com.SunLovers.PriseTheSun.repository.UsuarioRepository;


@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    // Método para cadastrar um novo usuário
    public Usuario cadastrarUsuario(Usuario usuario) {
        // Implemente a lógica de validação ou criptografia da senha, se necessário
        // Exemplo de validação de CPF duplicado:
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new RuntimeException("CPF já está em uso!");
        }
        
        return usuarioRepository.save(usuario);
    }
    // verificar  se o usuario existe
    public boolean usuarioExiste(String cpf) {
        return usuarioRepository.existsByCpf(cpf);
    }
    //recuperar usuario
     public Usuario getUsuario(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public List<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Boolean ValidarUsuario(String cpf,String senha) {
        
        if (usuarioExiste(cpf) &&usuarioRepository.findByCpf(cpf).validarSenha(senha)) {
                return true;
            }
        else {
                return false;}
    }


}
