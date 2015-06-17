/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.dao;

import com.escom.practica2.modelo.Profesor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public interface ProfesorInterfaz extends Remote {
    public List<Profesor> getAllProfesor()throws RemoteException;
}
