/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

//Imports

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
    
    public void ejecutarServidor()
    {
        while(true)
        {
            Socket clienteConexion;
            try
            {
                clienteConexion = _server.accept();                
                HandlerCliente client = new HandlerCliente(clienteConexion);
                Thread hiloCliente = new Thread(client);
                hiloCliente.start();
            }
            catch(IOException exeptionES)
            {                
            }                          
        }            
    }
}