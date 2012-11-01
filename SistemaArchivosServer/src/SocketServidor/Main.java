/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

import SA.AccesoDatos;

/**
 *
 * @author Meza Schmidt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServidorSocket newServer = new ServidorSocket();        
        newServer.crearServidor(12345, 100);
        System.out.println("Servidor Creado");
        newServer.ejecutarServidor();       
        

        
    }
}
