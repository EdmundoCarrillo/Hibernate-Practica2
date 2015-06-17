
package com.escom.practica2.servicios;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.escom.practica2.dao.*;
/**
 *
 * @author Clemente
 */
public class Servidor {
 
    
    public static void main(String args[]){
       
        try{
        LocateRegistry.createRegistry(1099);
        AlumnoDao alumnoDao= new AlumnoDao();
        MateriaDao materiaDao = new MateriaDao();
        ExamenDao examenDao  = new ExamenDao();
        PreguntaDao preguntaDao = new PreguntaDao();
        RespuestaDao respuestaDao = new RespuestaDao();
        CentroTrabajoDao centroDao  = new CentroTrabajoDao();
        CarreraDao carreraDao = new CarreraDao();
        ProfesorDao profesorDao  = new ProfesorDao();
        Naming.rebind("ServidorDaoAlumno",alumnoDao);
        Naming.rebind("Materia",materiaDao);
        Naming.rebind("Examen",examenDao);
        Naming.rebind("Pregunta",preguntaDao);
        Naming.rebind("Respuesta",respuestaDao);
        Naming.rebind("Centro",centroDao);
        Naming.rebind("Carrera",carreraDao);
        Naming.rebind("Profesor",profesorDao);
         System.out.println("servidor corriendo");
        }catch(RemoteException | MalformedURLException e){}
    }
}
