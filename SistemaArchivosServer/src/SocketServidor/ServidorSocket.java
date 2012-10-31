/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

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
    
    private ObjectInputStream _entradaObj;
    private ObjectOutputStream _salidaObj;
    
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
        }   
    }
    
    
    //Esperar a que llegue una conexion
    
    private void esperarConexion()throws IOException
    {
        _clientConexion = _server.accept();
        System.out.println(_clientConexion.getInetAddress().getHostName());                      
    }
    
    //Se establecen los flujos para la entrada y salida de datos
    private void establecerFlujos() throws IOException
    {
        _salidaObj = new ObjectOutputStream(_clientConexion.getOutputStream());
        _salidaObj.flush();        
        _entradaObj = new ObjectInputStream(_clientConexion.getInputStream()); 
         System.out.println("Flujos establecidos"); 
    }
    
    //Envio de datos al cliente
    private void enviarDatos(Object pobject)
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
            
            if(msgReceive.equals("Sumar"))
            {
                System.out.println("Sumar");
                enviarDatos("Sumando");                
            }
            else if(msgReceive.equals("Restar"))
            {
                System.out.println("Restar");
                enviarDatos("Restando");
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
    
    public void ejecutarServidor()
    {
        while(true)
        {
            try
            {
                esperarConexion();
                establecerFlujos();
                procesarConexion();
            }
            catch(IOException exeptionES)
            {                
            }                          
        }            
    }
}