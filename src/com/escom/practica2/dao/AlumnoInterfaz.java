

package com.escom.practica2.dao;

import com.escom.practica2.modelo.Alumno;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface AlumnoInterfaz extends Remote {
    

public void addAlumno(Alumno alumno)throws RemoteException; 
public void deleteAlumno(Alumno alumno)throws RemoteException;
public void uptadeAlumno(Alumno alumno)throws RemoteException;
public List<Alumno> getAllAlumnos()throws RemoteException;
public Alumno getAlumnoById(int idAlumno ,String email)throws RemoteException;
public Alumno getAlumnoByMatricula(int idAlumno)throws RemoteException;



}
