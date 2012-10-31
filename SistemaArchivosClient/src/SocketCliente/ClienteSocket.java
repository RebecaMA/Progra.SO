/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;



/**
 *
 * @author Meza Schmidt
 */
public class ClienteSocket {
    
    //Atributos
    private ObjectInputStream _entradaObj;
    private ObjectOutputStream _salidaObj;    
    private Socket _clientConexion;    
        
    //Metodos 
    
    
    //Se hace la conexion con el servidor
    
    public void conectarServidor(String pipHost, int pport) 
    {
        try{
            _clientConexion = new Socket(InetAddress.getByName(pipHost), pport);
            establecerFlujos();
            System.out.println(_clientConexion.getInetAddress().getHostName());       
        }
        catch(IOException excepcionES)
        {            
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
    public void enviarDatos(Object pobject)
    {
        try
        {
            _salidaObj.writeObject(pobject);
            _salidaObj.flush();
            System.out.println("mensaje enviado");
        }
        catch(IOException exeptionES)
        {            
        }       
    }
    
    //Se reciben los datos que el cliente envio
    private Object recibirDatos() throws IOException
    {
        Object objetoRecibido = new Object();
        try
        {
            objetoRecibido = _entradaObj.readObject();            
        }
        catch(ClassNotFoundException exeptionNotClass)
        {            
        }      
        return objetoRecibido;
    }
    
    //Procesa cada una de las solicitudes que lleguen al socket
    private void procesarConexion() throws IOException
    {
        String msgReceive;
        try
        {
            msgReceive = (String) recibirDatos();
            
            if(msgReceive.equals("Sumando"))
            {
                System.out.println("Sumando");                            
            }
            else if(msgReceive.equals("Restando"))
            {
                System.out.println("Restando");                
            }
        }
        catch(IOException exeptionES)
        {            
        }  
    }
            
    
    //Cerrar la conexion existente
    public void closeConexion()
    {
        System.out.println("Cerrando conexion");
        try
        {
            _salidaObj.close();
            _entradaObj.close();
            _clientConexion.close();
        }
        catch(IOException exeptionES)
        {            
        }            
    }
    
    public void ejecutarCliente()
    {
       
        try
        {            
            //establecerFlujos();
            procesarConexion();
        }
        catch(IOException exeptionES)
        {                
        }                
    }    
}
