package com.escom.practica2.dao;

import com.escom.practica2.modelo.Respuesta;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RespuestaInterfaz extends Remote {

    public void addRespuesta(Respuesta respuesta) throws RemoteException;

    public void deleteRespuesta(Respuesta respuesta) throws RemoteException;

    public void uptadeRespuesta(Respuesta respuesta) throws RemoteException;

    public List<Respuesta> getAllRespuestas(int idPregunta) throws RemoteException;

    public Respuesta getRespuestaById(int idRespuesta) throws RemoteException;
}
