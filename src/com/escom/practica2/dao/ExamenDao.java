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
//    public static void main(String[] args) throws RemoteException {
//        ExamenDao op  =new  ExamenDao();
//        List<Examen> lista  = op.getAllExamenes(1);
//        System.out.println(lista.get(1).getIdexamen());
//    }
}
