package com.ElenaOrtega.standcustom.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

   
     @Min(value = 1, message = "El número de estrellas debe ser como mínimo 1.")
    @Max(value = 5, message = "El número de estrellas debe ser como máximo 5.")
    @NotNull
    private int numero_estrellas;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_stand")
    private StandEntity stand;

    // Constructores, getters y setters

    public OpinionEntity() {
    }

    public OpinionEntity(UserEntity usuario, String descripcion, int numeroEstrellas) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.numero_estrellas = numeroEstrellas;
        
    }

    // Getters y setters

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

    public int getNumero_estrellas() {
        return numero_estrellas;
    }

    public void setNumero_estrellas(int numeroEstrellas) {
        this.numero_estrellas = numeroEstrellas;
    }

    public StandEntity getStand() {
        return stand;
    }

    public void setStand(StandEntity stand) {
        this.stand = stand;
    }
}
