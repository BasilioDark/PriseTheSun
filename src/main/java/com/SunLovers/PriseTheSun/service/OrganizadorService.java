package com.SunLovers.PriseTheSun.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SunLovers.PriseTheSun.Repository.OrganizadorRepository;
import com.SunLovers.PriseTheSun.Repository.UsuarioRepository;
import com.SunLovers.PriseTheSun.model.Organizador;
import com.SunLovers.PriseTheSun.model.Usuario;

@Service
public class OrganizadorService {

    private final OrganizadorRepository organizadorRepository;
    private final UsuarioRepository usuarioRepository;

    public OrganizadorService(OrganizadorRepository organizadorRepository,UsuarioRepository usuarioRepository) {
        this.organizadorRepository = organizadorRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
    public boolean TransformarEmOrganizador(Organizador organizador,Usuario usuario) throws Exception {
        if(organizadorRepository.existsById(usuario.getId())&&!usuarioRepository.existsById(usuario.getId()))
        {return false;}
            organizadorRepository.inserirOrganizador(usuario.getId());
        return true;
    }

    public Organizador encontrarPorId(Long id) {
        return organizadorRepository.getReferenceById(id);
    }

    public List<Organizador> encontrarTodosOrganizadores() {
        return organizadorRepository.findAll();
    }

    public void deletarOrganizador(Long id) {
        organizadorRepository.deleteById(id);
    }

    // Adicione outros métodos específicos de Organizador, se necessário
}