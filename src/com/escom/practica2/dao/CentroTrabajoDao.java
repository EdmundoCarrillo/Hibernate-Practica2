package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Centrotrabajo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CentroTrabajoDao {

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
            session.flush();
            session.close();

        }
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
