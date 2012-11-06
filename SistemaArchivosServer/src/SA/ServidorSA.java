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
        
    //Inicialización de Servidor SA
    public ServidorSA()
    {
        _tamañoBloqueControl = 500;
        _numasa = 0;
        _estructuraControlAcceso= new ArrayList<ControlAcceso>(50);
    }
        
    // Crear Sistema de Archivos
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
    
    // Usar disco con el nombre.
    public String usarSA(String pnombre){
        setAccesoDatos(new AccesoDatos());
        setEstructuraDisco(getAccesoDatos().usarSA(pnombre));
        return  getEstructuraDisco().getNombre() + getEstructuraDisco().getNumBloques();
    
    }
    
    
    public String deshablilitarSA()
    {
       // Verificar que no hayan mas clientes
        // Hay q borrar lo q esta en control de acceso tambn
        getAccesoDatos().crearSA(getEstructuraDisco());
        setEstructuraDisco(null);
        getEstructuraControlAcceso().removeAll(getEstructuraControlAcceso());
        

        
        return "Mensaje";
    }
    
    
    // Crear un archivo
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
    
    // Abre un archivo
    public int abrirArchivo(String pnombreUsuario, String pnombreArch)
    {
        if(_estructuraDisco.findArchivo(pnombreArch))
        {
            System.out.println("Archivo Si existe");
            if(!findArchivoAbierto(pnombreUsuario, pnombreArch))
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
    
    
    // Cierra el archivo
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
    
    // Borra el archivo
    public int borrarArchivo(String pnombreArch)
    {
        if(_estructuraDisco.findArchivo(pnombreArch))
        {
            System.out.println("Archivo Si existe");
            if(!findArchivoAbierto(pnombreArch))
            {
                for(int i = 0; i < _estructuraDisco.getListaArchivos().size(); i++)
                {
                    if( _estructuraDisco.getListaArchivos().get(i).getNombre().equals(pnombreArch))
                    {
                        _estructuraDisco.setEspacioUsado(_estructuraDisco.getEspacioUsado() -_estructuraDisco.getListaArchivos().get(i).getNumBloques());
                        _estructuraDisco.setBloquesLibres(_estructuraDisco.getListaArchivos().get(i).getBloqueInicio(), _estructuraDisco.getListaArchivos().get(i).getNumBloques());
                        _estructuraDisco.getListaArchivos().remove(i);                
                        break;
                    }
                    
                }  
                return 1;
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
    
    //Lee el archivo
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
       Calendar fecha;
       
       index = buscarArchivo(pasa); 
       _controlAcceso = _estructuraControlAcceso.get(index);
       _archivo = _estructuraDisco.getListaArchivos().get(index);
       _accesoDatos = new AccesoDatos();
       fecha = new GregorianCalendar();       
       puntero = _controlAcceso.getPosicionPuntero()+ _archivo.getByteInicio();
       if((puntero +pdata.length()) > (_archivo.getByteInicio() + _archivo.getEspacioAsignado()))
       {
           retorno = 0;
       }
       else 
       {
           retorno = _accesoDatos.escribirArchivo(pdata, puntero,_estructuraDisco);
           _archivo.setFechaModificacion(fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/" + fecha.get(Calendar.YEAR));
           getEstructuraDisco().getListaArchivos().set(index, _archivo);
       }
        
        return retorno; //bytes realmente escritos
    }
    

    // Reposicionar Archivo
    public int reposicionarArchivo(String pasa,String pmodo,int pnumeroBytes)
    {
        int index,posicion;
        
        
        index = buscarArchivo(pasa);
        Archivo _archivo = _estructuraDisco.getListaArchivos().get(index);
        ControlAcceso _acceso = _estructuraControlAcceso.get(index);
        
        posicion = 0;
        
        if(pmodo.equals("act")){
            posicion = _acceso.getPosicionPuntero() + pnumeroBytes;
        }else if(pmodo.equals("ini")){
            posicion = pnumeroBytes;
        
        }else if(pmodo.equals("fin")){
            posicion = _archivo.getEspacioAsignado() - pnumeroBytes;
        } 
        
        if(posicion < 0) {
            posicion = 0;
        }else if(posicion > _archivo.getEspacioAsignado()){
            posicion = _archivo.getEspacioAsignado();
        }
        
        _acceso.setPosicionPuntero(posicion);
        getEstructuraControlAcceso().set(index, _acceso);
        return posicion;
    
    
    }

    // LS [Archivo]
    
    public String LSarchivo(String pnombrearchivo){
         int index;
         String retorno;
         index = buscarArchivo(pnombrearchivo);
         Archivo _archivo = _estructuraDisco.getListaArchivos().get(index);
         
         retorno = "Nombre Archivo: " + _archivo.getNombre() + "\n";
         retorno += "Tamaño en Bytes: " + _archivo.getEspacioAsignado() + "\n";
         retorno += "Bloque Inicial: " + _archivo.getBloqueInicio() +  "\n";
         retorno += "Longitud en bloques: " + _archivo.getNumBloques() + "\n";
         retorno += "Fecha Modificacion: " + _archivo.getFechaModificacion() + "\n";
         
         if(findArchivoAbierto(pnombrearchivo)){
        ControlAcceso _acceso = _estructuraControlAcceso.get(index);
           retorno += "Archivo Abierto por " +  _acceso.getNombreUsuario() + "\n";
         }  
        return retorno; 
    }
    
        // LS [Archivo]
    
    public String LS(){
         String retorno = "";
         ArrayList<Archivo> _lista = _estructuraDisco.getListaArchivos();
         for(int i=0;i<_lista.size();i++)
         {
         
         Archivo _archivo = _lista.get(i);
         retorno += "*** ***" + "\n";
         retorno += "Nombre Archivo: " + _archivo.getNombre() + "\n";
         retorno += "Tamaño en Bytes: " + _archivo.getEspacioAsignado() + "\n";
         retorno += "Bloque Inicial: " + _archivo.getBloqueInicio() +  "\n";
         retorno += "Longitud en bloques: " + _archivo.getNumBloques() + "\n";
         retorno += "Fecha Modificacion: " + _archivo.getFechaModificacion() + "\n";
         
         if(findArchivoAbierto(_archivo.getNombre())){
        ControlAcceso _acceso = getEstructuraControlAcceso().get(i);
           retorno += "Archivo Abierto por: " +  _acceso.getNombreUsuario() + "\n";
         }  
         }
        return retorno; 
    }

    
    
                    //Funcionalidades adicionales
    
    private boolean findArchivoAbierto(String pnombreUsuario, String pnombreArch)
    {
        boolean conflicto = false;
        for(int i = 0; i < _estructuraControlAcceso.size(); i++)
        {
            if(_estructuraControlAcceso.get(i).getNombreArch().equals(pnombreArch) && !_estructuraControlAcceso.get(i).getNombreUsuario().equals(pnombreUsuario))
            {                
                conflicto = true;
                break;
            }
        }        
        return conflicto;
    }
    

    
     private boolean findArchivoAbierto(String pnombreArch)
    {
        boolean conflicto = false;
        for(int i = 0; i < _estructuraControlAcceso.size(); i++)
        {
            if(_estructuraControlAcceso.get(i).getNombreArch().equals(pnombreArch))
            {                
                conflicto = true;
                break;
            }
        }        
        return conflicto;
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
     
     
     
     // Get y Setters
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

}