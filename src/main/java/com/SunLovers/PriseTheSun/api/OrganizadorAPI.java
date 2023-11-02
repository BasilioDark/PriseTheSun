package com.SunLovers.PriseTheSun.api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SunLovers.PriseTheSun.model.Edicao;
import com.SunLovers.PriseTheSun.model.Organizador;
import com.SunLovers.PriseTheSun.service.EdicaoService;
import com.SunLovers.PriseTheSun.service.OrganizadorService;
import com.SunLovers.PriseTheSun.service.UsuarioService;

@RestController
@RequestMapping("/api/organizador")
public class OrganizadorAPI {

    private final UsuarioService usuarioService;
    private final OrganizadorService organizadorService;
    private final EdicaoService edicaoService;


    public OrganizadorAPI(UsuarioService usuarioService,
                          OrganizadorService organizadorService,
                          EdicaoService edicaoService) {
        this.usuarioService = usuarioService;
        this.organizadorService = organizadorService;
        this.edicaoService = edicaoService;
    }

    @PostMapping("/{usuarioID}/atribuirEdicao")
    public ResponseEntity<String> atribuirEdicao(@PathVariable("usuarioID") Long usuarioID,@RequestParam("Edicao_Id") long edicaoID) {
        Organizador organizador = organizadorService.getOrganizador(usuarioID);
        if (usuarioService.getUsuario(usuarioID) == null) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");}
        if (organizador !=null && organizador.getEdicao() !=null) {return ResponseEntity.status(HttpStatus.FOUND).body("Usuario Já É organizador, Remova o Evento do Organizador antes de chamar essa API");}
        Edicao edicao = edicaoService.buscarPorId(edicaoID);
        if (edicao == null) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edicao não encontrado");}
        if (edicao.getOrganizador() !=null) {return ResponseEntity.status(HttpStatus.CONFLICT).body("Evento Já Existe um Organizador");}
        if ((organizador !=null || organizadorService.TransformarEmOrganizador(usuarioID,edicaoID))){
            // System.out.println("passei por aqui");
            return ResponseEntity.status(HttpStatus.OK).body("Evento atribuído ao organizador com sucesso");
       }
       else{return ResponseEntity.status(HttpStatus.CONFLICT).body("falhou em converter");}
        
    }
     @GetMapping("/{organizadorID}")
    public ResponseEntity<?> getOrganizadorById(@PathVariable("organizadorID") Long organizadorID) {
        Organizador organizador = organizadorService.getOrganizador(organizadorID);
        if (organizador == null) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizador não encontrado");}
        return ResponseEntity.status(HttpStatus.OK).body(organizador);
    }
}
