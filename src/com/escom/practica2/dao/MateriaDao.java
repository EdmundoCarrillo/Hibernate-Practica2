package com.escom.practica2.dao;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.modelo.Materia;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MateriaDao extends UnicastRemoteObject implements MateriaInterfaz {

    public MateriaDao() throws RemoteException {
        super();
    }

//    @Override
//    public void addMateria(Materia materia) throws RemoteException {
//         Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(materia);
//            session.getTransaction().commit();
//            System.out.println("Agregado Exitosamente");
//        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.println(e.toString());
//        } finally {
//            session.flush();
//            session.close();
//
//        }
//    }
//
//    @Override
//    public void deleteMateria(Materia materia) throws RemoteException {
//         Transaction tr = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            tr = session.beginTransaction();
//            session.delete(materia);
//            session.getTransaction().commit();
//            System.out.println("Agregado Exitosamente");
//        } catch (HibernateException e) {
//            if (tr != null) {
//                tr.rollback();
//            }
//            System.out.println(e.toString());
//        } finally {
//          
//            session.close();
//
//        }
//    }
//
//    @Override
//    public void uptadeMateria(Materia materia) throws RemoteException {
//          Transaction tr = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            tr = session.beginTransaction();
//            session.update(materia);
//            session.getTransaction().commit();
//            System.out.println("Agregado Exitosamente");
//        } catch (HibernateException e) {
//            if (tr != null) {
//                tr.rollback();
//            }
//            System.out.println(e.toString());
//        } finally {
//           
//            session.close();
//
//        }
//    }
//
    @Override
    public List<Materia> getAllMaterias() throws RemoteException {
        List<Materia> materias = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            materias = session.createQuery("from Materia").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {

            session.close();
        }
        return materias;

    }
//
//    @Override
//    public Materia getMateriaById(int idMateria) {
//          Materia materia = null;
//        Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            String queryString = "from Materia where id= :id";
//            Query query = session.createQuery(queryString);
//            query.setInteger("id", idMateria);
//            materia = (Materia) query.uniqueResult();
//        } catch (HibernateException e) {
//            System.out.println(e.toString());
//        } finally {
//            
//            session.close();
//        }
//        return materia;
//    }

    public static void main(String[] args) throws RemoteException {
        MateriaDao op  = new MateriaDao  ();
        List<Materia> lista  = op.getAllMaterias();
        System.out.println(lista.get(0).getNombre());
    }

}
