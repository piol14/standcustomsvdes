package com.ElenaOrtega.standcustom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "stand")
public class StandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Va a ser el nombre de la imagen 
    private Long id;

    
    @Size(max = 255)
    @NotNull
    private String nombre;

   
    @Size(max = 1000)
    private String descripcion;
    @ManyToOne
    
    @JoinColumn(name = "id_ataque_stand")
    @NotNull
    private AtaqueStandEntity ataque;
    
    // Constructor, getters y setters


    public StandEntity(@Size(max = 255) String nombre, @Size(max = 1000) String descripcion, AtaqueStandEntity ataque) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ataque = ataque;
    }

    public StandEntity() {
    }

   
    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
    public AtaqueStandEntity getAtaque() {
        return ataque;
    }

    public void setAtaque(AtaqueStandEntity ataque) {
        this.ataque = ataque;
    }
}