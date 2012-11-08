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
import Libreria.Mensaje;


/**
 *
 * @author Meza Schmidt
 */
public class ClienteSocket {
    
    //Atributos
    private ObjectInputStream _entradaObj;
    private ObjectOutputStream _salidaObj;    
    private Socket _clientConexion;    
    public Boolean _sistemaMontado;
    public String _ip;
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
        }      
        return respuesta;
    }
    
    //Procesa cada una de las solicitudes que lleguen al socket
    /*private String procesarConexion() throws IOException
    {
        Mensaje msgReceive;        
        try
        {
            msgReceive = recibirDatos();
            
            if(msgReceive.getTipoMensaje().equals("df"))
            {
                System.out.println(msgReceive.getMensaje());                
            }
            else if(msgReceive.getTipoMensaje().equals("mount"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("ls"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("rm"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("open"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("read"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("write"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("repos"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("close"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("cat"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("importar"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("exportar"))
            {
                System.out.println(msgReceive.getMensaje());
            }
            else if(msgReceive.getTipoMensaje().equals("salir"))
            {
                System.out.println(msgReceive.getMensaje());
            } 
            else if(msgReceive.getTipoMensaje().equals("terminar"))
            {
                System.out.println(msgReceive.getMensaje());
            } 
        }
        catch(IOException exeptionES)
        {            
        }  
    }
    */
            
    
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
