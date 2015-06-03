
package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */

import com.escom.practica2.modelo.Carrera;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarreraDao {
    
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
            session.flush();
            session.close();

        }
    }
    
}
