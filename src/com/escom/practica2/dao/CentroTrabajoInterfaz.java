/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.dao;

import com.escom.practica2.modelo.Centrotrabajo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public interface CentroTrabajoInterfaz extends Remote {
    public void addCentroTrabajo(Centrotrabajo centro)throws RemoteException;
    public List<Centrotrabajo> getAllCentros()throws RemoteException;
}
