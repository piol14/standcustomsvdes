package com.ElenaOrtega.standcustom.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
 
  
    @NotNull
    private String imagen;
   

    @Size(max = 1000)
    private String descripcion;
   

    @NotNull
    @Column(length = 1)
    private String velocidad;
     
    @Column(length = 1)
    private String potencial_de_desarollo;
   
  
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
    @JoinColumn(name = "id_usuario") // Cambia esto según la columna de la clave foránea en tu tabla usuario
    private UserEntity usuario;
  
    // Constructor, getters y setters


   

  

    public StandEntity(Long id,   String nombre, String descripcion,
            String velocidad, String potencial_de_desarollo, String alcance,
             String poder, String aguante,  String acierto, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.potencial_de_desarollo = potencial_de_desarollo;
        this.alcance = alcance;
        this.poder = poder;
        this.aguante = aguante;
        this.acierto = acierto;
        this.imagen = imagen;
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
}