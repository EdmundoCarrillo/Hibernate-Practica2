package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Examen;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExamenDao {

    public void addExamen(Examen examen) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(examen);
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

    public void daleteExamen(Examen examen) {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.delete(examen);
            session.getTransaction().commit();
            System.out.println("Agregado Exitosamente");
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();

        }
    }

    public void updateExamen(Examen examen) {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.update(examen);
            session.getTransaction().commit();
            System.out.println("Agregado Exitosamente");
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();

        }
    }

    public List<Examen> getAllExamenes() {
        List<Examen> examenes = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            examenes = session.createQuery("from examen").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return examenes;
    }

    public Examen getExamenById(int idExamen) {
        Examen examen = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Examen where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idExamen);
            examen = (Examen) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return examen;
    }

}
