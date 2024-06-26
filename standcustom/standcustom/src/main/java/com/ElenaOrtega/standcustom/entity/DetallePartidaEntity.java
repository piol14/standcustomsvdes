package com.ElenaOrtega.standcustom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_partida")
public class DetallePartidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_usuario")
    private UserEntity usuario;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_stand")
    private StandEntity stand;
 @ManyToOne
    @NotNull
    @JoinColumn(name = "id_partida")
    private PartidaEntity partida;

    
   



 

    public DetallePartidaEntity() {
    }

    public DetallePartidaEntity(UserEntity usuario, StandEntity stand, PartidaEntity partida) {
        this.usuario = usuario;
        this.stand = stand;
         this.partida = partida;
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

    public StandEntity getStand() {
        return stand;
    }

    public void setStand(StandEntity stand) {
        this.stand = stand;
    }
       public PartidaEntity getPartida() {
    return partida;
}

public void setPartida(PartidaEntity partida) {
    this.partida = partida;
}
}
