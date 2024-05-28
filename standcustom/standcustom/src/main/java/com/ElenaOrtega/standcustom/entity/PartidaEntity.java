package com.ElenaOrtega.standcustom.entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


@Entity
@Table(name = "partida")
public class PartidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String fecha;

 

 @OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<DetallePartidaEntity> partidas;
    
   

    public PartidaEntity() {
    }

    public PartidaEntity(String fecha) {
        this.fecha = fecha;
    
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
