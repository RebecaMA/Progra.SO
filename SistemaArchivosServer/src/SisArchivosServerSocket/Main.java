/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SisArchivosServerSocket;

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
        System.out.println("Servidor Creado");
        newServer.crearServidor(12345, 100);
        newServer.ejecutarServidor();       
    }
}
