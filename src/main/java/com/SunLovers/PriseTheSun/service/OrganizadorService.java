package com.SunLovers.PriseTheSun.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.SunLovers.PriseTheSun.Repository.OrganizadorRepository;
import com.SunLovers.PriseTheSun.Repository.UsuarioRepository;
import com.SunLovers.PriseTheSun.model.Organizador;
import com.SunLovers.PriseTheSun.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class OrganizadorService {

    private final OrganizadorRepository organizadorRepository;
    private final UsuarioRepository usuarioRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public OrganizadorService(OrganizadorRepository organizadorRepository,UsuarioRepository usuarioRepository) {
        this.organizadorRepository = organizadorRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public boolean TransformarEmOrganizador(Usuario usuario) {
        
        if(!usuarioRepository.existsById(usuario.getId()))
        {return false;}

        //EntityManager necessario para modificar especialidade de Usuario
            entityManager.createNativeQuery("INSERT INTO organizador (ID) VALUES (?)")
            .setParameter(1, usuario.getId())
            .executeUpdate();
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