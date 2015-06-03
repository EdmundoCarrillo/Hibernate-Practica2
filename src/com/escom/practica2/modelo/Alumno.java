package com.escom.practica2.modelo;
// Generated 3/06/2015 12:37:11 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Alumno generated by hbm2java
 */
public class Alumno  implements java.io.Serializable {


     private Integer matricula;
     private Carrera carrera;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String email;
     private Set calificacions = new HashSet(0);

    public Alumno() {
    }

	
    public Alumno(Carrera carrera, String nombre, String apellidoPaterno, String email) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.email = email;
    }
    public Alumno(Carrera carrera, String nombre, String apellidoPaterno, String apellidoMaterno, String email, Set calificacions) {
       this.carrera = carrera;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.email = email;
       this.calificacions = calificacions;
    }
   
    public Integer getMatricula() {
        return this.matricula;
    }
    
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
    public Carrera getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getCalificacions() {
        return this.calificacions;
    }
    
    public void setCalificacions(Set calificacions) {
        this.calificacions = calificacions;
    }




}

