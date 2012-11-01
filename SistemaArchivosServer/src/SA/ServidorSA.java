/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SA;
import SA.Libreria.EstructuraControlDisco;
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
    
    
    
    
    
    public String crearSA(String pnombrearchivo,long pnumerobloques,long ptamanobloque){
       
        try {
            _Disco= new File (pnombrearchivo+".txt");
          
            
            if(_Disco.createNewFile())
            {
                
               _escrituraDisco = new FileWriter(_Disco);
               _escrituraDisco.write(pnumerobloques+"-"+ptamanobloque+"-"+ pnumerobloques*ptamanobloque);
               System.out.println("Creado");
               System.out.println("SA: "+ pnombrearchivo);
               _fileDescriptor="SA:"+ pnombrearchivo;
               _escrituraDisco.close();
              
            }
            else{
            System.out.println("Disco ya existe, no se puede volver a crear");
            _fileDescriptor="Disco ya existe, no se puede volver a crear";
            
            }
            
        } catch (IOException ex) {
            System.out.println(ex);
            _fileDescriptor="Se produjo un error:" + ex;
        }
    return _fileDescriptor;
    }
    
    public void usarSA(String pnombrearchivo){
        _Disco = new File(pnombrearchivo+".txt");
        String _lectura;
        StringTokenizer _tokens;
      
        try {
             FileReader _lecturadisco = new FileReader(_Disco);
             _lecturaDisco = new BufferedReader(_lecturadisco);         
        
    
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
            _fileDescriptor="Se produjo un error:" + ex;
        }
        try {
            _lectura= _lecturaDisco.readLine();
            _tokens = new StringTokenizer(_lectura,";");
             if(_tokens.countTokens() >= 1){
            _tokens = new StringTokenizer(_tokens.nextToken(),"-");
            if(_tokens.countTokens() >= 3){
            
            //_estructuraDisco = _libreria.new EstructuraControlDisco();
            //_estructuraDisco._nombreArchivo =pnombrearchivo;
            //_estructuraDisco._numeroBytes = Float.parseFloat(_tokens.nextToken());
            //_estructuraDisco._tamañoByte = Float.parseFloat(_tokens.nextToken());
            //_estructuraDisco._tamañoDisco = Float.parseFloat(_tokens.nextToken());
            //_listaDiscos.add(_estructuraDisco);
            //_fileDescriptor = ""+ (_listaDiscos.size()-1);
            }}
          
        } catch (IOException ex) {
            _fileDescriptor="Se produjo un error:" + ex;
        }
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
