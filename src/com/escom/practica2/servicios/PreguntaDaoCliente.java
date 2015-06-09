/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.servicios;

import com.escom.practica2.dao.PreguntaInterfaz;
import com.escom.practica2.modelo.Pregunta;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public class PreguntaDaoCliente {

    public List<Pregunta> getAllPreguntas(int idExamen) throws RemoteException, NotBoundException, MalformedURLException {

    PreguntaInterfaz preguntaOp= (PreguntaInterfaz)Naming.lookup("Pregunta");
    return preguntaOp.getAllPreguntas(idExamen);
    
    }

}
