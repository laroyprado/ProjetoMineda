package com.ProjetoMineda.ProjetoMineda.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "usr_name")
    private String nome;

    @Column(name = "usr_senha")
    private String senha;


}
