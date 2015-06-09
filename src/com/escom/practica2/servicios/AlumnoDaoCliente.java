package com.escom.practica2.servicios;

import com.escom.practica2.dao.AlumnoInterfaz;
import com.escom.practica2.modelo.Alumno;
import com.escom.practica2.modelo.Carrera;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AlumnoDaoCliente {

    public void addAlumno(Alumno alumno) throws RemoteException, NotBoundException, MalformedURLException {

        AlumnoInterfaz alumnoOp = (AlumnoInterfaz) Naming.lookup("ServidorDaoAlumno");
        alumnoOp.addAlumno(alumno);

    }

    public Alumno getAlumnoById(int idAlumno, String alumnoEmail) throws RemoteException, NotBoundException, MalformedURLException {

        AlumnoInterfaz alumnoOp = (AlumnoInterfaz) Naming.lookup("ServidorDaoAlumno");
        return alumnoOp.getAlumnoById(idAlumno, alumnoEmail);

    }

    public Alumno getAlumnoMatricula(int idAlumno) throws RemoteException, NotBoundException, MalformedURLException {

        AlumnoInterfaz alumnoOp = (AlumnoInterfaz) Naming.lookup("ServidorDaoAlumno");
        return alumnoOp.getAlumnoByMatricula(idAlumno);

    }

    public void uptadeAlumno(Alumno alumno) throws RemoteException, NotBoundException, MalformedURLException {

        AlumnoInterfaz alumnoOp = (AlumnoInterfaz) Naming.lookup("ServidorDaoAlumno");
        alumnoOp.uptadeAlumno(alumno);
    }
//    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
//        Carrera car = new Carrera ();
//        car.setIdcarrera(1);
//        Alumno alumno  = new Alumno ();
//        alumno.setNombre("Brenda");
//        alumno.setApellidoPaterno("Fuentes");
//        alumno.setApellidoPaterno("Hernadez");
//        alumno.setMatricula(2012630068);
//        alumno.setEmail("brenda@gmail.com");
//        alumno.setCarrera(car);
//        AlumnoDaoCliente  op = new AlumnoDaoCliente();
//       op.addAlumno(alumno);
//    }
}
