/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.servicios;

import com.escom.practica2.dao.CentroTrabajoInterfaz;
import com.escom.practica2.modelo.Centrotrabajo;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public class CentroDaoCliente {

    public void addCentroTrabajo(Centrotrabajo centroTrabajo) throws RemoteException, NotBoundException, MalformedURLException {

        CentroTrabajoInterfaz centro = (CentroTrabajoInterfaz) Naming.lookup("Centro");
        centro.addCentroTrabajo(centroTrabajo);

    }

    public List<Centrotrabajo> getAllCentros() throws RemoteException, NotBoundException, MalformedURLException {
        CentroTrabajoInterfaz centro = (CentroTrabajoInterfaz) Naming.lookup("Centro");
        return centro.getAllCentros();
    }
}
