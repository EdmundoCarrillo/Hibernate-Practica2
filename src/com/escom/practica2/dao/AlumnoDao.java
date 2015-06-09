package com.escom.practica2.dao;

import com.escom.practica2.modelo.Alumno;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.rmi.server.UnicastRemoteObject;

public class AlumnoDao extends UnicastRemoteObject implements AlumnoInterfaz {

    public AlumnoDao() throws RemoteException {
        super();
    }

    @Override
    public void addAlumno(Alumno alumno) throws RemoteException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(alumno);
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
    public void deleteAlumno(Alumno alumno) throws RemoteException {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.delete(alumno);
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

    @Override
    public void uptadeAlumno(Alumno alumno) throws RemoteException {
        Transaction tr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tr = session.beginTransaction();
            session.update(alumno);
            session.getTransaction().commit();
          
        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback();
            }
            System.out.println(e.toString());
        } finally {
           
            session.close();

        }
    }

    @Override
    public List<Alumno> getAllAlumnos() throws RemoteException {
        List<Alumno> alumnos = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            alumnos = session.createQuery("from alumno").list();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            session.flush();
            session.close();
        }
        return alumnos;
    }

    @Override
    public Alumno getAlumnoById(int idAlumno , String alumnoEmail) throws RemoteException {
        Alumno alumno = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Alumno where matricula= :id and email=:alumnoEmail";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idAlumno);
            query.setString("alumnoEmail",alumnoEmail);
            alumno = (Alumno) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            
            session.close();
        }
        return alumno;
    }
    
     @Override
    public Alumno getAlumnoByMatricula(int idAlumno ) throws RemoteException {
        Alumno alumno = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Alumno where matricula= :id ";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idAlumno);
            alumno = (Alumno) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.toString());
        } finally {
            
            session.close();
        }
        return alumno;
    }
//    public static void main(String[] args) throws RemoteException {
//        Alumno alumno  = new Alumno ();
//        AlumnoDao op = new AlumnoDao ();
//        alumno = op.getAlumnoByMatricula(2012630068);
//        System.out.println(alumno.getNombre());
//       
//    }
}
