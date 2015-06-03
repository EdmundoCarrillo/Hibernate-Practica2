package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Pregunta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PreguntaDao {

    public void addPregunta(Pregunta pregunta) {
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

    public void daletePregunta(Pregunta pregunta) {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.delete(pregunta);
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

    public void updatePregunta(Pregunta pregunta) {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.update(pregunta);
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

    public List<Pregunta> getAllPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            preguntas = session.createQuery("from materia").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return preguntas;
    }

    public Pregunta getMateriaById(int idPregunta) {
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
            session.flush();
            session.close();
        }
        return pregunta;
    }

}
