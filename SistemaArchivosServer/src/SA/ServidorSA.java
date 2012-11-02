/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SA;
import SA.Libreria.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Meza Schmidt
 */
public class ServidorSA {
    
    //Atributos
    
    private File _Disco;
    private FileWriter _escrituraDisco;   
    private BufferedReader _lecturaDisco;
    private String _fileDescriptor;
    public EstructuraControlDisco _estructuraDisco;
    private ArrayList<ControlAcceso> estructuraControlAcceso;
    private AccesoDatos _accesoDatos;
    
    public ServidorSA()
    {
        
    }
    
    
    
    
    public String crearSA(String pnombrearchivo,int pnumerobloques,int ptamanobloque){
        EstructuraControlDisco _estructura = new EstructuraControlDisco();
        _accesoDatos = new AccesoDatos();
        String _retorno = null;
        _estructura.setNombre(pnombrearchivo);
        _estructura.setNumBloques(pnumerobloques);
        _estructura.setTamanoBloque(ptamanobloque);
        _estructura.setTamanoAreaControl(ptamanobloque*pnumerobloques);
        
        _accesoDatos.crearSA(_estructura);
       
        return _retorno;
    }
    
    public String usarSA(String pnombre){
        _accesoDatos = new AccesoDatos();
        _estructuraDisco = _accesoDatos.usarSA(pnombre);
        return  _estructuraDisco.getNombre() + _estructuraDisco.getNumBloques();
    
    }
    
    
    public String deshablilitarSA()
    {
        return "Mensaje";
    }
    
    public int crearArchivo(String pnombreArch, int ptamanoBytes)
    {
        return 1;
    }
    
    public void cerrarArchivo(String pnombreArch)
    {
        
    }
    
    public String leerArchivo(String pasa, int pnumBytes)
    {
        return "mensaje";
    }
    
    public int escribirArchivo(String pasa, String pdata)
    {
        return 1; //bytes realmente escritos
    }   
}
