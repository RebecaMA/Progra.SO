/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SA;
import Libreria.*;
import Libreria.Archivo;
import java.io.*;
import java.util.*;

/**
 *
 * @author Meza Schmidt
 */
public class ServidorSA {
    
    //Atributos
    
  
    public EstructuraControlDisco _estructuraDisco;
    private ArrayList<ControlAcceso> _estructuraControlAcceso;
    private AccesoDatos _accesoDatos;
    int _tamañoBloqueControl; // Tiene el tamaño del bloque de inicio pongamoslo de 500 para empezar
    
    public ServidorSA()
    {
        _tamañoBloqueControl = 500;
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
        _estructuraDisco.crearEstructuraArchivo(pnombreArch, ptamanoBytes);
        return 1;
    }
    
    public void cerrarArchivo(String pnombreArch)
    {
        
    }
    
    public String leerArchivo(String pasa, int pnumBytes)
    { 
        String retorno;
        int index,finalizacionArchivo;
        ControlAcceso  _controlAcceso;
        Archivo _archivo;;
        
         index = buscarArchivo(pasa); 
       _controlAcceso = _estructuraControlAcceso.get(index);
       _archivo = _estructuraDisco.getListaArchivos().get(index);
       _accesoDatos = new AccesoDatos();
       
       finalizacionArchivo = _archivo.getBloqueInicio() * _estructuraDisco.getTamanoBloque() + _archivo.getEspacioAsignado() + _tamañoBloqueControl;
       
       if((_controlAcceso.getPosicionPuntero() + pnumBytes) > finalizacionArchivo)
       {
            retorno = "Indices fuera del archivo";
       }
       else 
       {
          retorno = _accesoDatos.leerArchivo(_controlAcceso.getPosicionPuntero(), pnumBytes);
       }
        return retorno;
    }
    
    // Escribe el archivo, retorno el numero de bytes escritos
    public int escribirArchivo(String pasa, String pdata)
    {        
       int index, retorno,bytesInicio;
       ControlAcceso  _controlAcceso;
       Archivo _archivo;
       Date fecha;
       
       index = buscarArchivo(pasa); 
       _controlAcceso = _estructuraControlAcceso.get(index);
       _archivo = _estructuraDisco.getListaArchivos().get(index);
       _accesoDatos = new AccesoDatos();
       fecha = new Date();
       
       // Aqui supongo q espacio asignado es el numero total de bytes
       // Nc si ese esenUso es solo para que el usuario lo use o yo tambien lo tengo q ver aqui
       bytesInicio = _archivo.getBloqueInicio() * _estructuraDisco.getTamanoBloque() + _tamañoBloqueControl;
       if((_controlAcceso.getPosicionPuntero()+pdata.length()) > (bytesInicio + _archivo.getEspacioAsignado()))
       {
           retorno = 0;
       }
       else 
       {
           retorno = _accesoDatos.escribirArchivo(pdata, _controlAcceso.getPosicionPuntero());
           _archivo.setFechaModificacion(fecha.getDay()+"/"+fecha.getMonth()+"/" + fecha.getYear());
           _estructuraDisco.getListaArchivos().set(index, _archivo);
       }
        
        return retorno; //bytes realmente escritos
    }   
    
    
    public int buscarArchivo(String pasa)
    {
        int _contador = 0;
       Boolean _boolean = true;
       
        while(_estructuraDisco.getListaArchivos().size() > _contador && _boolean)
        {
            if(_estructuraDisco.getListaArchivos().get(_contador).getNombre().equals(pasa))
            {
             _boolean = false;
            }
            else {
                _contador++;
            }      
        }
        
        return _contador;
    }
}
