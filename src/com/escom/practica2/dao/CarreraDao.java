package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Carrera;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarreraDao extends UnicastRemoteObject implements CarreraInterfaz {

    public CarreraDao() throws RemoteException {
        super();
    }

    public void addCarrera(Carrera carrera) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(carrera);
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
    public List<Carrera> getAllCarrera() throws RemoteException {
        List<Carrera> alumnos = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            alumnos = session.createQuery("from Carrera").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            
            session.close();
        }
        return alumnos;
    }

}
