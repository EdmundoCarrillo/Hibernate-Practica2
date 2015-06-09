package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Pregunta;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PreguntaDao extends UnicastRemoteObject implements PreguntaInterfaz {

    public PreguntaDao() throws RemoteException {
        super();
    }

    @Override
    public void addPregunta(Pregunta pregunta) throws RemoteException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(pregunta);
            session.getTransaction().commit();
            System.out.println("Agregado Exitosamente");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();

        }
    }

    @Override
    public void deletePregunta(Pregunta pregunta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void uptadePregunta(Pregunta pregunta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pregunta> getAllPreguntas(int idExamen) throws RemoteException {
         List<Pregunta> preguntas = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String q = "from Pregunta where idexamen= :idExamen";
            Query query = session.createQuery(q);
            query.setInteger("idExamen", idExamen);
            preguntas = query.list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {

            session.close();
        }
        return preguntas;
    }

    @Override
    public Pregunta getPreguntaById(int idPregunta) throws RemoteException {
           Pregunta pregunta = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Pregunta where id= :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idPregunta);
            pregunta = (Pregunta) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            
            session.close();
        }
        return pregunta;
    }
    
//    public static void main(String[] args) throws RemoteException {
//            public static void main(String[] args) throws RemoteException {
//        PreguntaDao op  =new  PreguntaDao();
//        Pregunta pre  = op.getPreguntaById(1);
//        System.out.println(pre.getRespuestaCorrecta());
//    }
//    }

}
