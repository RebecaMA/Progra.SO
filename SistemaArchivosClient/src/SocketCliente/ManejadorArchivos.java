/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rebeca
 */
public class ManejadorArchivos {
    
    public ManejadorArchivos(){}
    
    
    /**
     *
     * @param pfile
     * @return
     */
    public String _leerArchivo(File pfile){
        String _archivosleidos = null;
        byte[] _a;
        try {   
            RandomAccessFile _lectura = new RandomAccessFile(pfile, "r");
            try {
                Long largo =  _lectura.length();
                _a = new byte[largo.intValue()];
                _lectura.read(_a);
                _archivosleidos = new String (_a);
                _lectura.close();
            } catch (IOException ex) {
                Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return _archivosleidos;   
    }
    
    
     public int _escribirArchivo(File pfile, String _mensaje)   
    {
        int _situacion = 0;
        try {
            RandomAccessFile _escritura = new RandomAccessFile(pfile,"rw");

            try {
                _escritura.writeBytes(_mensaje);
                _situacion = _mensaje.length();
                _escritura.close();
            } catch (IOException ex) {
                _situacion = -1;
            }
            
        } catch (FileNotFoundException ex) {
            _situacion = -1;
        }
        return _situacion;
    }
    
}
