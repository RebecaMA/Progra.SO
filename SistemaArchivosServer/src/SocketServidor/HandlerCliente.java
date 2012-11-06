/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

import Libreria.Mensaje;
import SA.ServidorSA;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Meza Schmidt
 */
public class HandlerCliente implements Runnable{
    
     //Atributos
    
    private ObjectInputStream _entradaObj;
    private ObjectOutputStream _salidaObj;   
    private Socket _clientConexion;
    private ServidorSA _sa;
    
    public HandlerCliente(Socket psocket) 
    {
        _clientConexion = psocket;
        _entradaObj = null;
        _salidaObj = null;
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
    private void enviarDatos(Mensaje pobject)
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
    private Mensaje recibirDatos() throws IOException
    {
        Mensaje mensajeRecibido = new Mensaje();
        try
        {
            mensajeRecibido = (Mensaje) _entradaObj.readObject();    
        }
        catch(ClassNotFoundException exeptionNotClass)
        {   
            System.out.println("Error con Mensaje");
        }      
        return mensajeRecibido;
    }
    
    //Procesa cada una de las solicitudes que lleguen al socket
    private void procesarConexion() throws IOException
    {
        System.out.println("Procesando Conexion");
        Mensaje msgReceive;
        Mensaje msgSend = new Mensaje();
        try
        {
            msgReceive = recibirDatos();
            System.out.println("Mensaje recibido");
            
            if(msgReceive.getTipoMensaje().equals("df"))
            {
                System.out.println("df recibido");
                msgSend.setTipoMensaje("df");
                msgSend.setMensaje("Informacion del Sistema");                
                enviarDatos(msgSend);                
            }
            else if(msgReceive.getTipoMensaje().equals("mount"))
            {
                System.out.println("mount recibido");
                msgSend.setTipoMensaje("mount");
                msgSend.setMensaje("Sistema Conectado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("ls"))
            {
                System.out.println("ls recibido");
                msgSend.setTipoMensaje("ls");
                msgSend.setMensaje("Informacion del Archivo");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("rm"))
            {
                System.out.println("rm recibido");
                msgSend.setTipoMensaje("rm");
                msgSend.setMensaje("Archivo Borrado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("open"))
            {
                System.out.println("open recibido");
                msgSend.setTipoMensaje("open");
                String parametros[] = msgReceive.getMensaje().split(" ");
                int mensaje = _sa.abrirArchivo(parametros[0], parametros[1]);   
                msgSend.setMensaje(Integer.toString(mensaje));                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("read"))
            {
                System.out.println("read recibido");
                msgSend.setTipoMensaje("read");
                msgSend.setMensaje("Archivo leido");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("write"))
            {
                System.out.println("write recibido");
                msgSend.setTipoMensaje("write");
                msgSend.setMensaje("Archivo modificado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("repos"))
            {
                System.out.println("repos recibido");
                msgSend.setTipoMensaje("repos");
                msgSend.setMensaje("Archivo reposicionado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("close"))
            {
                System.out.println("close recibido");
                msgSend.setTipoMensaje("close");
                String parametros[] = msgReceive.getMensaje().split(" ");
                _sa.cerrarArchivo(Integer.parseInt(parametros[0]));   
                msgSend.setMensaje("Archivo Cerrado");  
                enviarDatos(msgSend);                
            }
            else if(msgReceive.getTipoMensaje().equals("cat"))
            {
                System.out.println("cat recibido");
                msgSend.setTipoMensaje("cat");
                msgSend.setMensaje("Archivo Desplegado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("importar"))
            {
                System.out.println("Importar recibido");
                msgSend.setTipoMensaje("Importar");
                msgSend.setMensaje("Archivo Importado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("exportar"))
            {
                System.out.println("Exportar recibido");
                msgSend.setTipoMensaje("Exportar");
                msgSend.setMensaje("Archivo Exportado");                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("terminar"))
            {
                System.out.println("terminar recibido");
                msgSend.setTipoMensaje("terminar");
                msgSend.setMensaje("Servidor cerrado");                
                enviarDatos(msgSend);
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

    @Override
    public void run() {
        
        while(true)
        {
            try
            {
                establecerFlujos();
                procesarConexion();
            }
             catch(IOException exeptionES)
            {            
            }           
        }       
    }   
}
