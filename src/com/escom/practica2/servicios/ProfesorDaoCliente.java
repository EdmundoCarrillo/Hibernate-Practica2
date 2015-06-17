/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.servicios;

import com.escom.practica2.dao.ProfesorInterfaz;
import com.escom.practica2.modelo.Profesor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public class ProfesorDaoCliente {

    public List<Profesor> getAllCarrera() throws RemoteException, NotBoundException, MalformedURLException {

        ProfesorInterfaz materiaOp = (ProfesorInterfaz) Naming.lookup("Profesor");
        return materiaOp.getAllProfesor();
    }

}
