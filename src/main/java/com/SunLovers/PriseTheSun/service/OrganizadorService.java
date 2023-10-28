package com.SunLovers.PriseTheSun.service;
import com.SunLovers.PriseTheSun.Repository.OrganizadorRepository;
import com.SunLovers.PriseTheSun.Repository.UsuarioRepository;
import com.SunLovers.PriseTheSun.model.Organizador;
import com.SunLovers.PriseTheSun.model.Usuario;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizadorService {

    private final OrganizadorRepository organizadorRepository;
    private final UsuarioRepository usuarioRepository;

    public OrganizadorService(OrganizadorRepository organizadorRepository,UsuarioRepository usuarioRepository) {
        this.organizadorRepository = organizadorRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Organizador salvarOrganizador(Organizador organizador,Usuario usuario) {
        usuarioRepository.delete(usuario);
        return organizadorRepository.save(organizador);
    }

    public Optional<Organizador> encontrarPorId(Long id) {
        return organizadorRepository.findById(id);
    }

    public List<Organizador> encontrarTodosOrganizadores() {
        return organizadorRepository.findAll();
    }

    public void deletarOrganizador(Long id) {
        organizadorRepository.deleteById(id);
    }

    // Adicione outros métodos específicos de Organizador, se necessário
}