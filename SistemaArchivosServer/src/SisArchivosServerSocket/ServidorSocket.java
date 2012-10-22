/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SisArchivosServerSocket;

//Imports

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author Meza Schmidt
 */
public class ServidorSocket {
    
    //Atributos
    
    private ObjectOutputStream _entradaObj;
    private ObjectInputStream _salidaObj;
    
    private ServerSocket _server;
    private Socket _clientConexion;
    
    
                 //Metodos
    
    //Crear el servidor
    
    public void crearServidor(int pport, int pnumConexiones)
    {
        try 
        {
            _server = new ServerSocket(pport, pnumConexiones);
            
        }
        catch(IOException exeptionES)
        {
            exeptionES.printStackTrace();            
        }       
    }
    
    
    //Esperar a que llegue una conexion
    
    private String esperarConexion()throws IOException
    {
        _clientConexion = _server.accept();
        return _clientConexion.getInetAddress().getHostName();                      
    }
    
    //Se establecen los flujos para la entrada y salida de datos
    private void establecerFlujos()
    {
        
    }
    
    public void ejectuarServidor()
    {
        while (true)
        {
        }
            
    }
}
