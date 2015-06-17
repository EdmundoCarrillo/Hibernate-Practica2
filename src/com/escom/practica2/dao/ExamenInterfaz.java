/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escom.practica2.dao;

import com.escom.practica2.modelo.Examen;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public interface ExamenInterfaz extends Remote {
    
public void addExamen(Examen examen)throws RemoteException; 
//public void deleteAlumno(Alumno alumno)throws RemoteException;
//public void uptadeAlumno(Alumno alumno)throws RemoteException;
public List<Examen> getAllExamenes(int idMateria)throws RemoteException;
public List<Examen> getAll()throws RemoteException;
//public Alumno getAlumnoById(int idAlumno)throws RemoteException;



}
