package com.escom.practica2.modelo;
// Generated 3/06/2015 12:37:11 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Centrotrabajo generated by hbm2java
 */
public class Centrotrabajo  implements java.io.Serializable {


     private Integer idcentroTrabajo;
     private String nombre;
     private Set carreras = new HashSet(0);

    public Centrotrabajo() {
    }

	
    public Centrotrabajo(String nombre) {
        this.nombre = nombre;
    }
    public Centrotrabajo(String nombre, Set carreras) {
       this.nombre = nombre;
       this.carreras = carreras;
    }
   
    public Integer getIdcentroTrabajo() {
        return this.idcentroTrabajo;
    }
    
    public void setIdcentroTrabajo(Integer idcentroTrabajo) {
        this.idcentroTrabajo = idcentroTrabajo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getCarreras() {
        return this.carreras;
    }
    
    public void setCarreras(Set carreras) {
        this.carreras = carreras;
    }




}


