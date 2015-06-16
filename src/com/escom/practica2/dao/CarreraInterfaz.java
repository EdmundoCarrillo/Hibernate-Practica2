/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.dao;

import com.escom.practica2.modelo.Carrera;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DARTH VADER
 */
public interface CarreraInterfaz extends Remote{
    public void addCarrera(Carrera carrera) throws  RemoteException; 
}
