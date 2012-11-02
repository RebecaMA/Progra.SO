/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

import SA.ServidorSA;

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
//        
        
//           ServidorSA _s = new ServidorSA();
////        _s.crearSA("prueba.txt",3, 100);
//           System.out.println(_s.usarSA("prueba.txt"));

        
    }
}
