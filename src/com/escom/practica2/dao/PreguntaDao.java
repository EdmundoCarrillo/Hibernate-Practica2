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
    public List<Pregunta> getAllPreguntas() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pregunta getPreguntaById(int idPregunta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
