package com.ProjetoMineda.ProjetoMineda.entity;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ant_anotacao")
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private Long id;

    @Column(name = "ant_texto")
    private String texto;

    @Column(name = "ant_data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ant_usr_id")
    private Usuario usuario;


}
