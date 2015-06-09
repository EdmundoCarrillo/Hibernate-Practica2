/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.dao;

import com.escom.practica2.modelo.Pregunta;
import com.escom.practica2.modelo.Respuesta;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DARTH VADER
 */
public class RespuestaDao extends UnicastRemoteObject implements RespuestaInterfaz {

    public RespuestaDao() throws RemoteException {
        super();
    }

    @Override
    public void addRespuesta(Respuesta respuesta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRespuesta(Respuesta respuesta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void uptadeRespuesta(Respuesta respuesta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Respuesta> getAllRespuestas(int idPregunta) throws RemoteException {
        PreguntaDao op = new PreguntaDao();
        Pregunta pre = op.getPreguntaById(idPregunta);
        Respuesta correcta = new Respuesta();
        correcta.setPregunta(pre);
        correcta.setRespuesta(pre.getRespuestaCorrecta());
        List<Respuesta> respuestas = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String q = "from Respuesta where idpregunta= :idPregunta";
            Query query = session.createQuery(q);
            query.setInteger("idPregunta", idPregunta);
            respuestas = query.list();
            respuestas.add(correcta);
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {

            session.close();
        }
        return respuestas;
    }

    @Override
    public Respuesta getRespuestaById(int idRespuesta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public static void main(String[] args) throws RemoteException {
//        RespuestaDao op = new RespuestaDao();
//        List<Respuesta> lista = op.getAllRespuestas(1);
//        System.out.println(lista.get(3).getRespuesta());
//        System.out.println(lista.size());
//    }

}
