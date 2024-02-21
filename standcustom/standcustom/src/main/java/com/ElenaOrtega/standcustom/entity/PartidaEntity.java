package com.ElenaOrtega.standcustom.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.event.spi.LockEventListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "partida")
public class PartidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity ganador;
 

 @OneToMany(mappedBy = "partida", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<DetallePartidaEntity> partidas;
    
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
