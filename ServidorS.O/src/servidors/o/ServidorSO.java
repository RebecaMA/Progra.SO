/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidors.o;

import java.io.FileNotFoundException;

/**
 *
 * @author RebeMoreno
 */
public class ServidorSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       ServidorLogica _servidor = new ServidorLogica();
       
       _servidor.crearSA("archivo",2, 1);
       _servidor.usarSA("archivo");
        
    }
}
