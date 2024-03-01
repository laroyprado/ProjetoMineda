package com.ProjetoMineda.ProjetoMineda.controller;


import com.ProjetoMineda.ProjetoMineda.entity.Usuario;
import com.ProjetoMineda.ProjetoMineda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {


    @Autowired
    private UsuarioService service;


    @GetMapping
    public List<Usuario> buscarTodos(){
        return service.buscarTodos();
    }

    @PostMapping
    public Usuario novo(@RequestBody Usuario usuario){
        return service.novo(usuario);
    }


    @GetMapping(value = "/{id}")
    public Usuario buscarId(@PathVariable("id") Long id){
        return service.buscarUsuario(id);
    }


}
