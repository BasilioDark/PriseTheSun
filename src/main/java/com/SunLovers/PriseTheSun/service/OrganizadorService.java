package com.SunLovers.PriseTheSun.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.SunLovers.PriseTheSun.Repository.OrganizadorRepository;
import com.SunLovers.PriseTheSun.model.Organizador; 
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class OrganizadorService {

    private final OrganizadorRepository organizadorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public OrganizadorService(OrganizadorRepository organizadorRepository) {
        this.organizadorRepository = organizadorRepository;
    }
    @Transactional
    public boolean TransformarEmOrganizador(long id) {
        try {
        System.out.println("teste");
            entityManager.createNativeQuery("INSERT INTO organizador (ID) VALUES (?)")
            .setParameter(1, id)
            .executeUpdate();
            Thread.sleep(3000);
        }
         catch (Exception e) {
            return false;
         }
        
        return true;
    }

    public Organizador getOrganizador(Long id) {
        return organizadorRepository.findById(id).orElse(null);
    }

    public List<Organizador> encontrarTodosOrganizadores() {
        return organizadorRepository.findAll();
    }

    public void deletarOrganizador(Long id) {
        organizadorRepository.deleteById(id);
    }
    public Organizador atualizarOrganizador(Organizador organizador) {
        return organizadorRepository.save(organizador);
    }


    // Adicione outros métodos específicos de Organizador, se necessário
}