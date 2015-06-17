/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.servicios;

import com.escom.practica2.dao.CarreraInterfaz;
import com.escom.practica2.modelo.Carrera;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public class CarreraDaoCliente {

    public void addCarrera(Carrera carrera) throws RemoteException, NotBoundException, MalformedURLException {

        CarreraInterfaz op = (CarreraInterfaz) Naming.lookup("Carrera");
        op.addCarrera(carrera);

    }

    public List<Carrera> getAllCarrera() throws RemoteException, NotBoundException, MalformedURLException {

        CarreraInterfaz materiaOp = (CarreraInterfaz) Naming.lookup("Carrera");
        return materiaOp.getAllCarrera();
    }
//  

}
