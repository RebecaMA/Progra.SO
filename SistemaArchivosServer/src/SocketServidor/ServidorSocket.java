/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

//Imports

import SA.ServidorSA;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 *
 * @author Meza Schmidt
 */
public class ServidorSocket {
    
            //Atributos
    private ServerSocket _server; 
    private ServidorSA _sa;
        
            //Metodos
    
    //Crear el servidor
    
    public void crearServidor(int pport, int pnumConexiones)
    {
        try 
        {
            _server = new ServerSocket(pport, pnumConexiones);             
            setSa(new ServidorSA());
        }
        catch(IOException exeptionES)
        {           
        }   
    }
       
    public void ejecutarServidor()
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        while(true)
        {            
            try
            {
                Socket clienteConexion = _server.accept();                 
                System.out.println("Nueva Conexion");
                executor.execute(new HandlerCliente(clienteConexion, getSa()));
                //HandlerCliente client = new HandlerCliente(clienteConexion, getSa());
                //Thread hiloCliente = new Thread(client);
                //hiloCliente.start();
            }
            catch(IOException exeptionES)
            {       
                 System.out.println("Server catch: "+exeptionES.getMessage());
            }                          
        }            
    }

    /**
     * @return the _sa
     */
    public ServidorSA getSa() {
        return _sa;
    }

    /**
     * @param sa the _sa to set
     */
    public void setSa(ServidorSA sa) {
        this._sa = sa;
    }
}