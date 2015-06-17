/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escom.practica2.dao;

import java.rmi.Remote;
import com.escom.practica2.modelo.Pregunta;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author DARTH VADER
 */
public interface PreguntaInterfaz extends Remote {

public void addPregunta(Pregunta pregunta)throws RemoteException; 
public void deletePregunta(Pregunta pregunta)throws RemoteException;
public void uptadePregunta(Pregunta pregunta)throws RemoteException;
public List<Pregunta> getAllPreguntas(int idExmamen)throws RemoteException;
public Pregunta getPreguntaById(int idPregunta)throws RemoteException;
public List<Pregunta> getAll()throws RemoteException;
}
