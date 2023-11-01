package com.SunLovers.PriseTheSun.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.SunLovers.PriseTheSun.Repository.EdicaoRepository;
import com.SunLovers.PriseTheSun.Repository.OrganizadorRepository;
import com.SunLovers.PriseTheSun.model.Organizador; 


@Service
public class OrganizadorService {

    private final OrganizadorRepository organizadorRepository;
    private final EdicaoRepository edicaoRepository;


    public OrganizadorService(OrganizadorRepository organizadorRepository,EdicaoRepository eventoRepository) {
        this.organizadorRepository = organizadorRepository;
        this.edicaoRepository = eventoRepository;
    }
    @Transactional
    public boolean TransformarEmOrganizador(long idOrganizador, long idEdicao) {
        try {
            organizadorRepository.TransformarEmOrganizador(idOrganizador);
            edicaoRepository.AtribuirEdicao(idOrganizador,idEdicao);
            return true;
           
        }
         catch (Exception e) {
            return false;
         }
        
        
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