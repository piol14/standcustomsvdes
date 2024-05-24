package com.ElenaOrtega.standcustom.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "stand")
public class StandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    
    @Size(max = 255)
    @NotNull
    private String nombre;
 
  
    @NotNull
    private String imagen;
   

    @Size(max = 1000)
    private String descripcion;
   

    @NotNull
    @Column(length = 1)
    private String velocidad;
     
    @Column(length = 1)
    private String desarollo;
   
  
 


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

    
    
   
    @ManyToOne
    @JoinColumn(name = "id_usuario") 
    private UserEntity usuario;

  
    @ManyToOne
    
    @JoinColumn(name = "id_categoria") 
    private CategoriaEntity categoria;
@OneToMany(mappedBy = "stand", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<OpinionEntity> opiniones;
@OneToMany(mappedBy = "stand", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<DetallePartidaEntity> detallepartida;
@OneToMany(mappedBy = "stand", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
private List<FavoritoEntity> favoritos;

   

    



  


    public StandEntity(Long id,   String nombre, String descripcion,
            String velocidad, String desarollo, String alcance,
             String poder, String aguante,  String acierto, String imagen) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.desarollo = desarollo;
        this.alcance = alcance;
        this.poder = poder;
        this.aguante = aguante;
        this.acierto = acierto;
        this.imagen = imagen;
        this.categoria = categoria;
    }


    public StandEntity() {
        opiniones = new ArrayList<OpinionEntity>();
        detallepartida = new ArrayList<DetallePartidaEntity>();
        favoritos = new ArrayList<FavoritoEntity>();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
  

  

     public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

     public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
   public String getDesarollo() {
        return desarollo;
    }


    public void setDesarollo(String desarollo) {
        this.desarollo = desarollo;
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
    public String getImagen() {
        return imagen;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

}