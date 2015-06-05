/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escom.practica2.servicios;

import com.escom.practica2.dao.ExamenInterfaz;
import com.escom.practica2.dao.MateriaInterfaz;
import com.escom.practica2.modelo.Examen;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public class ExamenDaoCliente {
   
    public List<Examen> getAllExamenes(int idMateria) throws RemoteException, NotBoundException, MalformedURLException {

        ExamenInterfaz examenOp = (ExamenInterfaz) Naming.lookup("Examen");
        return examenOp.getAllExamenes(idMateria);
    }
}
