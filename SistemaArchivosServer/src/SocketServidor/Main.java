/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

import Libreria.EstructuraControlDisco;
import SA.ControlAcceso;
import SA.ServidorSA;
import java.util.ArrayList;

/**
 *
 * @author Meza Schmidt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ServidorSocket newServer = new ServidorSocket();        
        newServer.crearServidor(12345, 100);
        System.out.println("Servidor Creado");
        newServer.ejecutarServidor();   
        */
       
//           ServidorSA _s = new ServidorSA();
////        _s.crearSA("prueba.txt",3, 100);
//           System.out.println(_s.usarSA("prueba.txt"));
        ServidorSA server = new ServidorSA();        
        //server.setEstructuraControlAcceso(listaAcceso);
        server.setEstructuraDisco(new EstructuraControlDisco());
        server.getEstructuraDisco().setNumBloques(10);
        server.getEstructuraDisco().setBloqueInicio(5);
        server.getEstructuraDisco().setTamanoBloque(32);
        server.getEstructuraDisco().setListaArchivos();
        server.getEstructuraDisco().setListaBloquesLibres(10);
        System.out.println(server.crearArchivo("Javi", "Test.txt", 64));
        System.out.println(server.crearArchivo("Javi", "Test2.txt", 64));
        System.out.println(server.crearArchivo("Javi", "Test3.txt", 32));
        server.cerrarArchivo(1);        
        System.out.println(server.abrirArchivo("Javi", "Test.txt"));
        //System.out.println(server.crearArchivo("Javi", "Test.txt", 64));
        //double numBloques =  Math.ceil(9.0 / 4.0);
        //System.out.println(numBloques);
        
    }
}
