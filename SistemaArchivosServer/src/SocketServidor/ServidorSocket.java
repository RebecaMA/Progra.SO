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
        while(true)
        {
            Socket clienteConexion;
            try
            {                
                clienteConexion = _server.accept();         
                System.out.println("Nueva Conexion");
                HandlerCliente client = new HandlerCliente(clienteConexion, getSa());
                Thread hiloCliente = new Thread(client);
                hiloCliente.start();
            }
            catch(IOException exeptionES)
            {                
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