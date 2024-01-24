package com.ElenaOrtega.standcustom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "partida")
public class PartidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @NotNull
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity ganador;

    // Constructores, getters y setters

    public PartidaEntity() {
    }

    public PartidaEntity(String fecha, UserEntity ganador) {
        this.fecha = fecha;
        this.ganador = ganador;
    }

    // Getters y setters

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

    public UserEntity getGanador() {
        return ganador;
    }

    public void setGanador(UserEntity ganador) {
        this.ganador = ganador;
    }
}
