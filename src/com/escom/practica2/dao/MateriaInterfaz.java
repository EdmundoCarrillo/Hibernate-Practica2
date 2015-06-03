/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escom.practica2.dao;

import com.escom.practica2.modelo.Materia;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface MateriaInterfaz extends Remote {
    
public void addMateria(Materia materia)throws RemoteException; 
public void deleteMateria(Materia materia)throws RemoteException;
public void uptadeMateria(Materia materia)throws RemoteException;
public List<Materia> getAllMaterias()throws RemoteException;
public Materia getMateriaById(int idMateria);


}
