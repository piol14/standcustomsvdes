package com.ElenaOrtega.standcustom.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

 
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<StandEntity> stands;

    
   

    public CategoriaEntity()
    {
        stands = new ArrayList<StandEntity>();

    }

   
    public CategoriaEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

  
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
     public int getStands() {
    return stands.size();
     }

    
}
