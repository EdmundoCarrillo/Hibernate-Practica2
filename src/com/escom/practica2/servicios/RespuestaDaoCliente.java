package com.escom.practica2.servicios;

/**
 *
 * @author DARTH VADER
 */
import com.escom.practica2.dao.RespuestaInterfaz;
import com.escom.practica2.modelo.Respuesta;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class RespuestaDaoCliente {

    public List<Respuesta> getAllRespuestas(int idPregunta) throws RemoteException, NotBoundException, MalformedURLException {

        RespuestaInterfaz respuestaOp = (RespuestaInterfaz) Naming.lookup("Respuesta");
        return respuestaOp.getAllRespuestas(idPregunta);

    }
    
    public void addRespuesta (Respuesta resp) throws RemoteException, NotBoundException, MalformedURLException {
    RespuestaInterfaz respuestaOp = (RespuestaInterfaz) Naming.lookup("Respuesta");
    respuestaOp.addRespuesta(resp);
    
    }
}
