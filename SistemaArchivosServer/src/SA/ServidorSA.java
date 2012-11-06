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
    private int _numasa;
        
    public ServidorSA()
    {
        _tamañoBloqueControl = 500;
        _numasa = 0;
        _estructuraControlAcceso= new ArrayList<ControlAcceso>(50);
    }
        
    public String crearSA(String pnombrearchivo,int pnumerobloques,int ptamanobloque){
        EstructuraControlDisco _estructura = new EstructuraControlDisco();
        setAccesoDatos(new AccesoDatos());
        String _retorno = null;
        _estructura.setNombre(pnombrearchivo);
        _estructura.setNumBloques(pnumerobloques);
        _estructura.setTamanoBloque(ptamanobloque);
        _estructura.setTamanoAreaControl(ptamanobloque*pnumerobloques);
        _estructura.setListaBloquesLibres(pnumerobloques);
        
        getAccesoDatos().crearSA(_estructura);
       
        return _retorno;
    }
    
    public String usarSA(String pnombre){
        setAccesoDatos(new AccesoDatos());
        setEstructuraDisco(getAccesoDatos().usarSA(pnombre));
        return  getEstructuraDisco().getNombre() + getEstructuraDisco().getNumBloques();
    
    }
    
    
    public String deshablilitarSA()
    {
        return "Mensaje";
    }
    
    public int crearArchivo(String pnombreUsuario, String pnombreArch, int ptamanoBytes)
    {
        if(!_estructuraDisco.findArchivo(pnombreArch))
        {
            System.out.println("No hay Conflicto con Nombres");
            if(getEstructuraDisco().crearEstructuraArchivo(pnombreArch, ptamanoBytes))
            {
                System.out.println("Estructura Creada");
                _numasa = _numasa + 1;
                ControlAcceso archivo = new ControlAcceso(_numasa, pnombreUsuario, pnombreArch);
                getEstructuraControlAcceso().add(archivo);
                return _numasa;                 
            }
            else 
            {
                return -2;
            }           
        }
        else
        {
            return -1;
        }        
    }
    
    public int abrirArchivo(String pnombreUsuario, String pnombreArch)
    {
        if(_estructuraDisco.findArchivo(pnombreArch))
        {
            System.out.println("Archivo Si existe");
            if(!findArchivoAbierto(pnombreArch))
            {
                _numasa = _numasa + 1;
                ControlAcceso archivo = new ControlAcceso(_numasa, pnombreUsuario, pnombreArch);
                getEstructuraControlAcceso().add(archivo);
                return _numasa;                
            }
            else 
            {
                return -2;
            }           
        }
        else
        {
            return -1;
        }        
    }
    
    
    
    public void cerrarArchivo(int pasa)
    {        
        for(int i = 0; i < _estructuraControlAcceso.size(); i++)
        {
            if(_estructuraControlAcceso.get(i).getAsa() == pasa)
            {
                _estructuraControlAcceso.remove(i);                
                break;
            }
        }               
    }
    
    public String leerArchivo(String pasa, int pnumBytes)
    { 
        String retorno;
        int index,finalizacionArchivo,puntero;
        ControlAcceso  _controlAcceso;
        Archivo _archivo;
        
         index = buscarArchivo(pasa); 
       _controlAcceso = _estructuraControlAcceso.get(index);
       _archivo = _estructuraDisco.getListaArchivos().get(index);
       _accesoDatos = new AccesoDatos();
       
       finalizacionArchivo = _archivo.getBloqueInicio() * _estructuraDisco.getTamanoBloque() + _archivo.getEspacioAsignado() + _tamañoBloqueControl;
       puntero = _controlAcceso.getPosicionPuntero()+ _archivo.getByteInicio();
       if((puntero + pnumBytes) > finalizacionArchivo)
       {
            retorno = "Indices fuera del archivo";
       }
       else 
       {
          retorno = _accesoDatos.leerArchivo(puntero, pnumBytes,_estructuraDisco);
       }
        return retorno;
    }
    
    // Escribe el archivo, retorno el numero de bytes escritos
    public int escribirArchivo(String pasa, String pdata)
    {        
       int index, retorno,puntero;
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
       
       puntero = _controlAcceso.getPosicionPuntero()+ _archivo.getByteInicio();
       if((puntero +pdata.length()) > (_archivo.getByteInicio() + _archivo.getEspacioAsignado()))
       {
           retorno = 0;
       }
       else 
       {
           retorno = _accesoDatos.escribirArchivo(pdata, puntero,_estructuraDisco);
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

    /**
     * @return the _estructuraControlAcceso
     */
    public ArrayList<ControlAcceso> getEstructuraControlAcceso() {
        return _estructuraControlAcceso;
    }

    /**
     * @param estructuraControlAcceso the _estructuraControlAcceso to set
     */
    public void setEstructuraControlAcceso(ArrayList<ControlAcceso> estructuraControlAcceso) {
        this.setEstructuraControlAcceso(estructuraControlAcceso);
    }

    /**
     * @return the _accesoDatos
     */
    public AccesoDatos getAccesoDatos() {
        return _accesoDatos;
    }

    /**
     * @param accesoDatos the _accesoDatos to set
     */
    public void setAccesoDatos(AccesoDatos accesoDatos) {
        this._accesoDatos = accesoDatos;
    }

    /**
     * @return the _estructuraDisco
     */
    public EstructuraControlDisco getEstructuraDisco() {
        return _estructuraDisco;
    }

    /**
     * @param estructuraDisco the _estructuraDisco to set
     */
    public void setEstructuraDisco(EstructuraControlDisco estructuraDisco) {
        this._estructuraDisco = estructuraDisco;
    }
    
    
                    //Funcionalidades adicionales
    
    private boolean findArchivoAbierto(String pnombre)
    {
        boolean conflicto = false;
        for(int i = 0; i < _estructuraControlAcceso.size(); i++)
        {
            if(_estructuraControlAcceso.get(i).getNombreArch().equals(pnombre))
            {                
                conflicto = true;
                break;
            }
        }        
        return conflicto;
    }

}
