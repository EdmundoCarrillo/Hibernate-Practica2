/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.practica2.dao;

import com.escom.practica2.modelo.Profesor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DARTH VADER
 */
public class ProfesorDao extends UnicastRemoteObject implements ProfesorInterfaz {

    public ProfesorDao() throws RemoteException {
        super();
    }

    @Override
    public List<Profesor> getAllProfesor() throws RemoteException {
       List<Profesor> materias = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            materias = session.createQuery("from Profesor").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {

            session.close();
        }
        return materias;
    }
}
