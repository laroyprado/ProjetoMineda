package com.ProjetoMineda.ProjetoMineda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usr_usuario")
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usr_id" )
    private Long id;

    @Column(name = "usr_nome") 
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private Set<Anotacao> anotacoes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "uau_usuario_autorizacao",
            joinColumns = {@JoinColumn(name="usr_id")},
            inverseJoinColumns = {@JoinColumn(name = "aut_id")})
    private Set<Autorizacao> autorizacoes;

}
