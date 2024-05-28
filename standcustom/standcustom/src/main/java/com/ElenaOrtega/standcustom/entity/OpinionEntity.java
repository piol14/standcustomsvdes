package com.ElenaOrtega.standcustom.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "opinion")
public class OpinionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @NotNull
    private UserEntity usuario;

  
    @Size(max = 1000)
    private String descripcion;

   

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_stand")
    private StandEntity stand;

   
    public OpinionEntity() {
    }

    public OpinionEntity(UserEntity usuario, String descripcion) {
        this.usuario = usuario;
        this.descripcion = descripcion;
    
        
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  

    public StandEntity getStand() {
        return stand;
    }

    public void setStand(StandEntity stand) {
        this.stand = stand;
    }
}
