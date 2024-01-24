package com.ElenaOrtega.standcustom.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ataque_stand")
public class AtaqueStandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 @NotNull
    @Column(length = 1)
    private String velocidad;
    
   
  
    @NotNull
    @Column(length = 1)
    private String alcance;
    @NotNull
    @Column(length = 1)
    private String poder;
    @NotNull
    @Column(length = 1)
    private String aguante;
    @NotNull
    @Column(length = 1)
    private String acierto;


    @OneToMany( mappedBy = "ataque",fetch = jakarta.persistence.FetchType.LAZY)
    private List <StandEntity> stand;
    

    public AtaqueStandEntity() {
        stand = new ArrayList<StandEntity>();
        
    }

    // Constructores, getters y setters

    public AtaqueStandEntity(String velocidad, String alcance, String poder,
            String aguante, String acierto) {

        this.velocidad = velocidad;
       
        this.alcance = alcance;
        this.poder = poder;
        this.aguante = aguante;
        this.acierto = acierto;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getAguante() {
        return aguante;
    }

    public void setAguante(String aguante) {
        this.aguante = aguante;
    }

    public String getAcierto() {
        return acierto;
    }

    public void setAcierto(String acierto) {
        this.acierto = acierto;
    }

    public int  getStand() {
        return stand.size();
    }


}