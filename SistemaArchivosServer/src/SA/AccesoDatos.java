/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SA;

import Libreria.EstructuraControlDisco;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rebeca
 */
public class AccesoDatos {
    
    private File _Disco;
    private File _Archivo;
    private ServidorSA _servidorSA;
    private EstructuraControlDisco _estructura;

    public void setServidorSA(ServidorSA _servidorSA) {
        this._servidorSA = _servidorSA;
    }

    public EstructuraControlDisco getEstructura() {
        return _estructura;
    }
    
    public AccesoDatos()
    {
        _estructura = new EstructuraControlDisco();    
    }
    
    public String crearSA(EstructuraControlDisco pdisco){
        String _fileDescriptor = "Se creo el disco con exito";
        
        try {
            FileOutputStream fileOut =  new FileOutputStream(pdisco.getNombre());
            ObjectOutputStream out =  new ObjectOutputStream(fileOut);
            out.writeObject(pdisco);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            _fileDescriptor="Se produjo un error:" + ex;
        }
    return _fileDescriptor;
   }

    public boolean usarSA(String pnombre)
    {
       boolean retorno = true;
         try
         {
            FileInputStream fileIn =  new FileInputStream(pnombre);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            _estructura = (EstructuraControlDisco) in.readObject();
            in.close();
            fileIn.close();
            retorno = true;
        }catch(IOException i)
        {
           retorno = false;
   
        }catch(ClassNotFoundException c)
        {
          retorno = false;
        }
         
         return retorno;
      
    }
 
    
   
    // Para leer en un archivo, no en el archivo de disco sino uno  dentro del disco
    public String leerArchivo(int pinicio, int plongitud,EstructuraControlDisco _estructura)
    {
        String _archivosleidos = null;
        byte[] _a = new byte[plongitud];
        try {

           // RandomAccessFile _lectura = new RandomAccessFile(_servidorSA._estructuraDisco.getNombre(), "r");
              //RandomAccessFile _lectura = new RandomAccessFile("prueba.txt","rw");

            RandomAccessFile _lectura = new RandomAccessFile(_estructura.getNombre(), "r");

            try {
                _lectura.seek(pinicio);
                _lectura.read(_a);
                _archivosleidos = new String (_a);
                _lectura.close();
               
            } catch (IOException ex) {
                 _archivosleidos = ex.toString();
            }
             
        } catch (FileNotFoundException ex) {
            _archivosleidos = ex.toString();
        }        
        return _archivosleidos;
    }
    
    // Este sirve para escribir en el archivo, lo hace sobre el disco seleccionado
    // Retorna -1 si algo no salio bien 
    public int escribirArchivo(String pescribir, int pinicio,EstructuraControlDisco _estructura)   
    {
        int _situacion = 0;
        try {

          //  RandomAccessFile _escritura = new RandomAccessFile(_servidorSA._estructuraDisco.getNombre(),"rw");
            //RandomAccessFile _escritura = new RandomAccessFile("prueba.txt","rw");

            RandomAccessFile _escritura = new RandomAccessFile(_estructura.getNombre(),"rw");

            try {
                _escritura.seek(pinicio);
                _escritura.writeBytes(pescribir);
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

    