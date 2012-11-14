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


/**
 *
 * @author Meza Schmidt
 */
public class ClienteSocket {
    
    //Atributos
    private ObjectInputStream _entradaObj;
    private ObjectOutputStream _salidaObj;    
    private static Socket _clientConexion;    
    public Boolean _sistemaMontado;
    public String _ipServer;
    public String _ipLocal;
    
    
    //Metodos 
    
    public ClienteSocket()
    {
        _sistemaMontado = false;
    }
    
    //Se hace la conexion con el servidor
    
    public String conectarServidor(String pipHost, int pport) 
    {        
        try{
            _ipLocal = InetAddress.getLocalHost().getHostAddress();
            if(_clientConexion == null || !_sistemaMontado)
            {
                System.out.println("Creando Nueva Conexion");       
                _clientConexion = new Socket(InetAddress.getByName(pipHost), pport);
                establecerFlujos();
                _ipServer = _clientConexion.getInetAddress().getHostName() + ' ' + _clientConexion.getInetAddress().getHostAddress();
                _sistemaMontado = true;                
                String mensaje = "Conexion establecida con: " + _ipServer;
                return mensaje;
            }
            else
            {
                String mensaje = "Conexion establecida con: " + _ipServer;
                return mensaje;
            }
        }
        catch(IOException excepcionES)
        {
            String mensaje = "Error al conectar con Host, verifique datos de entrada";
            return mensaje;
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
            System.out.println("mensaje enviado");
        }
        catch(IOException exeptionES)
        {            
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
            System.out.println("Error parseando el mensaje");
        }      
        return respuesta;
    }    
    
    //Cerrar la conexion existente
    public String closeConexion()
    {
        System.out.println("Cerrando conexion");
        try
        {
            String mensaje = "Conexion cerrada con: " + _ipServer;
            _sistemaMontado = false;
            //_salidaObj.close();
            //_entradaObj.close();
            _clientConexion.close();
            return mensaje;
        }
        catch(IOException exeptionES)
        {            
            return "Error de IO";
        }            
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
        }     
        return respuesta;
    }       
}
