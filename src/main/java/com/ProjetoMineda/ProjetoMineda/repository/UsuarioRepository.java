package com.ProjetoMineda.ProjetoMineda.repository;

import com.ProjetoMineda.ProjetoMineda.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long > {
}
