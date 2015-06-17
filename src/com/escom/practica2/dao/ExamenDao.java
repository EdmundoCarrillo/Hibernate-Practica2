package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Examen;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExamenDao extends UnicastRemoteObject implements ExamenInterfaz {

    public ExamenDao() throws RemoteException {
        super();

    }

    @Override
    public List<Examen> getAllExamenes(int idMateria) throws RemoteException {
        List<Examen> examenes = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String q = "from Examen where idmateria= :idMateria";
            Query query = session.createQuery(q);
            query.setInteger("idMateria", idMateria);
            examenes = query.list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {

            session.close();
        }
        return examenes;
    }

    @Override
    public void addExamen(Examen examen) throws RemoteException {
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

            session.close();

        }
    }

    @Override
    public List<Examen> getAll() throws RemoteException {
        List<Examen> materias = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            materias = session.createQuery("from Examen").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {

            session.close();
        }
        return materias;

    }
//    public static void main(String[] args) throws RemoteException {
//        ExamenDao op  =new  ExamenDao();
//        List<Examen> lista  = op.getAllExamenes(1);
//        System.out.println(lista.get(1).getIdexamen());
//    }
}
