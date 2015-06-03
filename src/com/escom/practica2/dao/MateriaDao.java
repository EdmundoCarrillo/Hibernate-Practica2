package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Materia;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MateriaDao {
    
     public void addMateria(Materia materia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(materia);
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

    public void daleteMateria(Materia materia) {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.delete(materia);
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

    public void updateMateria(Materia materia) {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.update(materia);
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

    public List<Materia> getAllMaterias() {
        List<Materia> materias = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            materias = session.createQuery("from materia").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return materias;
    }

    public Materia getMateriaById(int idMateria) {
        Materia materia = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Materia where id= :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idMateria);
            materia = (Materia) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return materia;
    }
    
//    public static void main(String[] args) {
//        MateriaDao op = new MateriaDao ();
//        Materia materia = new Materia();
//        materia.setNombre("Sistemas Distribuidos");
//        materia.setCreditos(5);
//        op.addMateria(materia);
//        
//        Materia mat  = new Materia();
//        mat =op.getMateriaById(1);
//        System.out.println(mat.getNombre());
//    }

}
