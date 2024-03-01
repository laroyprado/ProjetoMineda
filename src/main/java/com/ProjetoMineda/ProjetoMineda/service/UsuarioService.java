package com.ProjetoMineda.ProjetoMineda.service;

import com.ProjetoMineda.ProjetoMineda.entity.Usuario;
import com.ProjetoMineda.ProjetoMineda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Usuario> buscarTodos(){
        return usuarioRepo.findAll();
    }

    public Usuario novo(Usuario usuario){
        // Verifica se o usuário ou a senha são nulos ou vazios
        if(usuario == null ||
                usuario.getNome() == null || usuario.getNome().isBlank() ||
                usuario.getSenha() == null || usuario.getSenha().isBlank()){
            throw new IllegalArgumentException("Usuário e senha são obrigatórios");
        }

        // Salva o usuário no banco de dados
        return usuarioRepo.save(usuario);
    }



    public Usuario buscarUsuario(Long id){
        Optional <Usuario> usuarioOp = usuarioRepo.findById(id);

        if(usuarioOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao existe");
        }
        return usuarioOp.get();
    }
}
