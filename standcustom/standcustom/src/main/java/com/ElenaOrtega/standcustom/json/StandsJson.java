package com.ElenaOrtega.standcustom.json;

public class StandsJson {
    private String nombre;
    private String imagen;
    private String descripcion;
    private String velocidad;
    private String desarollo;
    private String alcance;
    private String poder;
    private String aguante;
    private String acierto;

    public StandsJson() {
        
    }

    public StandsJson(String nombre, String imagen, String descripcion, String velocidad, String desarollo, String alcance, String poder, String aguante, String acierto) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.desarollo = desarollo;
        this.alcance = alcance;
        this.poder = poder;
        this.aguante = aguante;
        this.acierto = acierto;
    }

  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}

