
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
    public HandlerCliente(Socket psocket, ServidorSA psa) 
    {
        _clientConexion = psocket;        
        try
        {    
            establecerFlujos();
        }
        catch(IOException exeptionES)
        {
            System.out.println("Crear thread catch: "+exeptionES.getMessage()); 
            Logger.getLogger(HandlerCliente.class.getName()).log(Level.SEVERE, null, exeptionES);
        }
        _sa = psa;
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
            System.out.println("Enviar catch: " + exeptionES.getMessage()); 
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
                msgSend.setMensaje("IP: " + _clientConexion.getInetAddress().getHostAddress() + "\n" +
                                    "Puerto: " + _clientConexion.getLocalPort() + "\n" +
                                    "Tamano en bytes: " + _sa.getEstructuraDisco().getTamanoBytes() + "\n" +
                                    "Espacio usado: " + _sa.getEstructuraDisco().getEspacioUsadoBytes() + "\n" +
                                    "Espacio libre: " + _sa.getEstructuraDisco().getEspacioLibreBytes() + "\n" +
                                    "Porcentaje de uso: " + _sa.getEstructuraDisco().getPorcentajeUso()                  
                                  );                
                enviarDatos(msgSend);                
            }
            else if(msgReceive.getTipoMensaje().equals("unmount"))
            {
                System.out.println("unmount recibido");
                msgSend.setTipoMensaje("unmount");
                String parametros[] = msgReceive.getMensaje().split("/");
                _sa.deshablilitarSA(parametros[0]);                     
                msgSend.setMensaje("Desconectando");                
                enviarDatos(msgSend); 
            }            
            else if(msgReceive.getTipoMensaje().equals("ls"))
            {
                System.out.println("ls recibido");
                msgSend.setTipoMensaje("ls");                             
                
                if(msgReceive.getMensaje().isEmpty())
                {
                    msgSend.setMensaje(_sa.LS());
                    
                }
                else
                {
                    msgSend.setMensaje(_sa.LS(msgReceive.getMensaje()));
                }
                enviarDatos(msgSend);                
            }
            else if(msgReceive.getTipoMensaje().equals("rm"))
            {
                System.out.println("rm recibido");
                msgSend.setTipoMensaje("rm");
                String parametros[] = msgReceive.getMensaje().split("/");
                msgSend.setMensaje( _sa.borrarArchivo(parametros[0]));           
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("open"))
            {
                System.out.println("open recibido");
                msgSend.setTipoMensaje("open");
                String parametros[] = msgReceive.getMensaje().split("/");
                int mensaje = _sa.abrirArchivo(parametros[0], parametros[1]);   
                msgSend.setMensaje(Integer.toString(mensaje));                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("read"))
            {
                System.out.println("read recibido");
                msgSend.setTipoMensaje("read");
                String parametros[] = msgReceive.getMensaje().split("/");
                msgSend.setMensaje(_sa.leerArchivo(parametros[0], Integer.parseInt(parametros[1])));                
                enviarDatos(msgSend);
            
            }
            else if(msgReceive.getTipoMensaje().equals("write"))
            {
                System.out.println("write recibido");
                msgSend.setTipoMensaje("write");
                String parametros[] = msgReceive.getMensaje().split("/");
                msgSend.setMensaje(_sa.escribirArchivo(parametros[0], parametros[1]) + "");                
                enviarDatos(msgSend);                
            }
            else if(msgReceive.getTipoMensaje().equals("repos"))
            {
                System.out.println("repos recibido");
                msgSend.setTipoMensaje("repos");
                String parametros[] = msgReceive.getMensaje().split("/");
                msgSend.setMensaje(_sa.reposicionarArchivo(parametros[0], parametros[1],Integer.parseInt(parametros[2]))+"");               
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("close"))
            {
                System.out.println("close recibido");
                msgSend.setTipoMensaje("close");
                String parametro = msgReceive.getMensaje();
                _sa.cerrarArchivo(Integer.parseInt(parametro));   
                msgSend.setMensaje("Archivo Cerrado");  
                enviarDatos(msgSend);                
            }
            else if(msgReceive.getTipoMensaje().equals("cat"))
            {
                System.out.println("cat recibido");
                msgSend.setTipoMensaje("cat");
                String parametro = msgReceive.getMensaje();
                msgSend.setMensaje(_sa.catArchivo(parametro));                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("importar"))
            {
                System.out.println("Importar recibido");
                msgSend.setTipoMensaje("Importar");
                String parametros[] = msgReceive.getMensaje().split("/");
                _sa.importarArchivo(parametros[0], parametros[1], parametros[2]);
                msgSend.setMensaje("Archivo importado");
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("exportar"))
            {
                System.out.println("Exportar recibido");
                msgSend.setTipoMensaje("Exportar");
                 String parametros[] = msgReceive.getMensaje().split("/");
                msgSend.setMensaje(_sa.exportarArchivo(parametros[0]));;                
                enviarDatos(msgSend);
            }
            else if(msgReceive.getTipoMensaje().equals("salir"))
            {
                
                System.out.println("salir recibido");  
                String parametros[] = msgReceive.getMensaje().split("/");
                _sa.deshablilitarSA(parametros[0]);  
                
            }         
            else if(msgReceive.getTipoMensaje().equals("terminar"))
            {
                
                System.out.println("terminar recibido"); 
                String parametros[] = msgReceive.getMensaje().split("/");
                _sa.deshablilitarSA(parametros[0]);                   
                System.exit(0);
            }          
            else
            {
                System.out.println("Funcion no reconocida: "+ msgReceive.getTipoMensaje()); 
            }
        }
        catch(IOException exeptionES)
        {
            System.out.println("Procesar Conexion catch: "+exeptionES.getMessage()); 
            Logger.getLogger(HandlerCliente.class.getName()).log(Level.SEVERE, null, exeptionES);
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
                procesarConexion();
            }
             catch(IOException exeptionES)
            {            
                System.out.println("Run thread catch: "+exeptionES.getMessage()); 
                Logger.getLogger(HandlerCliente.class.getName()).log(Level.SEVERE, null, exeptionES);
            }           
        }       
    }   
}