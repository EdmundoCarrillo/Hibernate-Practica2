/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escom.practica2.dao;

import com.escom.practica2.modelo.Calificacion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public interface CalificacionInterfaz extends Remote {
    
   public void addCalificacion(Calificacion calificacion)throws RemoteException; 
public void deleteAlumno(Calificacion alumno)throws RemoteException;
public void uptadeAlumno(Calificacion alumno)throws RemoteException;
public List<Calificacion> getAllCalificaciones()throws RemoteException;
public Calificacion getCalificacionById(int idCalificacion)throws RemoteException;
    
}
