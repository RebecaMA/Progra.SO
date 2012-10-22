package servidors.o;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author RebeMoreno
 */
public class ServidorLogica {
    private File _Disco;
    private FileWriter _escrituraDisco;
    private FileReader _lecturaDisco;
    private String _fileDescriptor;
 
   
    public ServidorLogica(){
    }
    
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
        try {
            _lecturaDisco = new FileReader(_Disco);
            _lecturaDisco.
        
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
            _fileDescriptor="Se produjo un error:" + ex;
        }
    }
    
}
