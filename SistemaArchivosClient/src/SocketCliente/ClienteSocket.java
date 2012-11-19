/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import Libreria.Mensaje;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Meza Schmidt
 */
public class ClienteSocket {
    
    //Atributos
    private ObjectInputStream _entradaObj;
    private ObjectOutputStream _salidaObj;    
    private static Socket _clientConexion;    
    public String _ipServer;
    public int _portServer;
  
    
    
    //Metodos 
    
    public ClienteSocket()
    {
    }
    
    //Se hace la conexion con el servidor
    
    public Boolean conectarServidor(String pipHost, int pport) 
    {        
        try{            

            System.out.println("Creando Nueva Conexion");       
            _clientConexion = new Socket(InetAddress.getByName(pipHost), pport);                
            _ipServer = pipHost;
            _portServer = pport;
            establecerFlujos();
            return true;            
        }
        catch(IOException excepcionES)
        {
            System.out.println("Conectar catch: "+excepcionES.getMessage());            
            return false;
        }       
    }
    
     //Se establecen los flujos para la entrada y salida de datos
    private void establecerFlujos() throws IOException
    {
        _salidaObj = new ObjectOutputStream(_clientConexion.getOutputStream());
        _salidaObj.flush();        
        _entradaObj = new ObjectInputStream(_clientConexion.getInputStream());       
    }
    
    //Envio de datos al cliente
    public void enviarDatos(Mensaje pmensaje)
    {
        try
        {
            _salidaObj.writeObject(pmensaje);
            _salidaObj.flush();
        }
        catch(IOException exeptionES)
        {            
            System.out.println("Enviar catch: "+exeptionES.getMessage());
        }       
    }
    
    //Se reciben los datos que el cliente envio
    private String recibirDatos() throws IOException
    {
        String respuesta = "";
        try
        {
            Mensaje mensajeRecibido = (Mensaje) _entradaObj.readObject();            
            respuesta = mensajeRecibido.getMensaje();
        }
        catch(ClassNotFoundException exeptionNotClass)
        {
            System.out.println("RecibirDatos catch: "+exeptionNotClass.getMessage());
            System.out.println("Error parseando el mensaje");
        }      
        return respuesta;
    }    
        
    public String ejecutarCliente(Mensaje pmensaje)
    {
        String respuesta = "";
        try
        {
            enviarDatos(pmensaje);
            System.out.println("Mensaje Enviado");
            respuesta = recibirDatos();
        }
        catch(IOException exeptionES)
        {            
            System.out.println("Ejecutar cliente catch: "+exeptionES.getMessage()); 
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, exeptionES);
        }     
        return respuesta;
    }       
}
