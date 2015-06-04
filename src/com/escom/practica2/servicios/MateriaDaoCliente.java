/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.servicios;

import com.escom.practica2.dao.MateriaInterfaz;
import com.escom.practica2.modelo.Materia;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public class MateriaDaoCliente {

    public List<Materia> getAllMaterias() throws RemoteException, NotBoundException, MalformedURLException {

        MateriaInterfaz materiaOp = (MateriaInterfaz) Naming.lookup("Materia");
        return materiaOp.getAllMaterias();
    }
//    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
//        MateriaDaoCliente op  = new MateriaDaoCliente();
//        List<Materia> lista  = op.getAllMaterias();
//        System.out.println(lista.get(0).toString());
//    }

}
