package com.ProjetoMineda.ProjetoMineda.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "aut_autorizacao")
@NoArgsConstructor
@AllArgsConstructor
public class Autorizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;


    @Column(name = "aut_nome")
    private String nome;


    @ManyToMany(mappedBy = "autorizacoes")
    @JsonIgnore
    private Set<Usuario> usuarios;

}
