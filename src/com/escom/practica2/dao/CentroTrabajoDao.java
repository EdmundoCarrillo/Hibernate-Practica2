package com.escom.practica2.dao;

import com.escom.practica2.modelo.Alumno;
import com.escom.practica2.modelo.Centrotrabajo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CentroTrabajoDao extends UnicastRemoteObject implements CentroTrabajoInterfaz {

    public CentroTrabajoDao() throws RemoteException {
        super();
    }

    public void addCentroTrabajo(Centrotrabajo centroTrabajo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(centroTrabajo);
            session.getTransaction().commit();
            System.out.println("Agregado Exitosamente");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.toString());
        } finally {

            session.close();

        }
    }
    
      @Override
    public List<Centrotrabajo> getAllCentros() throws RemoteException {
        List<Centrotrabajo> alumnos = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            alumnos = session.createQuery("from Centrotrabajo").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return alumnos;
    }

//    public static void main(String[] args) {
//
//        Centrotrabajo es  = new Centrotrabajo();
//        es.setNombre("ESCOM");
//        CentroTrabajoDao escuela  = new CentroTrabajoDao();
//        escuela.addCentroTrabajo(es);
//
//
//
//    }
}
