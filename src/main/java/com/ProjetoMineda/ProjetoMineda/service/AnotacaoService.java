package com.ProjetoMineda.ProjetoMineda.service;

import com.ProjetoMineda.ProjetoMineda.entity.Anotacao;
import com.ProjetoMineda.ProjetoMineda.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Anotacao> todas(){
        return anotacaoRepository.findAll();
    }


    public Anotacao nova(Anotacao anotacao){
        if(anotacao == null ||
            anotacao.getTexto() == null ||
            anotacao.getTexto().isBlank() ||
            anotacao.getUsuario() == null ||
            anotacao.getUsuario().getId() == null
        ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Dados invalidos");
        }

        if (anotacao.getDataHora() == null){
            anotacao.setDataHora(LocalDateTime.now());
        }
        anotacao.setUsuario(usuarioService
                .buscarUsuario(anotacao.getUsuario().getId()));
        return anotacaoRepository.save(anotacao);



    }





}
