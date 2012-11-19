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
    private int _numasa;
        
    //Inicialización de Servidor SA
    public ServidorSA()
    {        
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
        _estructura.setTamanoAreaControl(2000);
        _estructura.setListaBloquesLibres(pnumerobloques);
        
        getAccesoDatos().crearSA(_estructura);
       
        return _retorno;
    }
    
    // Usar disco con el nombre.
    public boolean usarSA(String pnombre){
        setAccesoDatos(new AccesoDatos());
        boolean retorno = getAccesoDatos().usarSA(pnombre);
        setEstructuraDisco(getAccesoDatos().getEstructura());
        return retorno;
       
    
    }
    
    
    public String deshablilitarSA()
    {
        getAccesoDatos().DesabilitarSA(getEstructuraDisco());
        //setEstructuraDisco(null);
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
    public String borrarArchivo(String pnombreArch)
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
                return "Archivo Borrado";
            }
            else 
            {
                return "Error de borrado archivo";
            }           
        }
        else
        {
            return "Error de borrado archivo";
        }       
    }
    
    //Lee el archivo
    public String leerArchivo(String pasa, int pnumBytes)
    { 
        String retorno;
        int indexcontrolacceso,indexcontroldisco,finalizacionArchivo,puntero;
        ControlAcceso  _controlAcceso;
        Archivo _archivo;
        
         indexcontrolacceso = buscarArchivoControlAcceso(pasa); 
         indexcontroldisco = buscarArchivoEstructuraDisco(_estructuraControlAcceso.get(indexcontrolacceso).getNombreArch());
       _controlAcceso = _estructuraControlAcceso.get(indexcontrolacceso);
       _archivo = _estructuraDisco.getListaArchivos().get(indexcontroldisco);
       _accesoDatos = new AccesoDatos();
       
       finalizacionArchivo = _archivo.getBloqueInicio() * _estructuraDisco.getTamanoBloque() + _archivo.getEspacioAsignado() + _estructuraDisco.getTamanoAreaControl();
       puntero = _controlAcceso.getPosicionPuntero()+ _archivo.getByteInicio();
       if((puntero + pnumBytes) > finalizacionArchivo)
       {
            retorno = "Indices fuera del archivo";
       }
       else 
       {
          retorno = _accesoDatos.leerArchivo(puntero, pnumBytes,_estructuraDisco);
          _estructuraControlAcceso.get(indexcontrolacceso).setPosicionPuntero(_controlAcceso.getPosicionPuntero() +retorno.length());
         
          
       }
        return retorno;
    }
    
    // Escribe el archivo, retorno el numero de bytes escritos
    public int escribirArchivo(String pasa, String pdata)
    {        
       int indexcontrolacceso,indexcontroldisco, retorno,puntero;
       ControlAcceso  _controlAcceso;
       Archivo _archivo;
       Calendar fecha;
       
       indexcontrolacceso = buscarArchivoControlAcceso(pasa);
       indexcontroldisco = buscarArchivoEstructuraDisco(_estructuraControlAcceso.get(indexcontrolacceso).getNombreArch());
       _controlAcceso = _estructuraControlAcceso.get(indexcontrolacceso);
       _archivo = _estructuraDisco.getListaArchivos().get(indexcontroldisco);
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
           getEstructuraDisco().getListaArchivos().set(indexcontroldisco, _archivo);
          _controlAcceso.setPosicionPuntero(_controlAcceso.getPosicionPuntero() +retorno);
          _estructuraControlAcceso.set(indexcontrolacceso, _controlAcceso);
          
       }
        
        return retorno; //bytes realmente escritos
    }
    

    // Reposicionar Archivo
    public int reposicionarArchivo(String pasa,String pmodo,int pnumeroBytes)
    {
        int indexcontrolacceso,indexcontroldisco,posicion;
        
        
        indexcontrolacceso = buscarArchivoControlAcceso(pasa);
        indexcontroldisco = buscarArchivoEstructuraDisco(_estructuraControlAcceso.get(indexcontrolacceso).getNombreArch());
        Archivo _archivo = _estructuraDisco.getListaArchivos().get(indexcontroldisco);
        ControlAcceso _acceso = _estructuraControlAcceso.get(indexcontrolacceso);
        
        posicion = 0;
        
        if(pmodo.equals("act")){
            posicion = _acceso.getPosicionPuntero() + pnumeroBytes;
        }else if(pmodo.equals("ini")){
            posicion = pnumeroBytes;
        
        }else if(pmodo.equals("fin")){
            posicion = _archivo.getEspacioAsignado() - pnumeroBytes -1;
        } 
        
        if(posicion < 0) {
            posicion = 0;
        }else if(posicion > _archivo.getEspacioAsignado()){
            posicion = _archivo.getEspacioAsignado();
        }
        
        _acceso.setPosicionPuntero(posicion);
        getEstructuraControlAcceso().set(indexcontrolacceso, _acceso);
        return posicion;
    
    
    }

    // LS [Archivo]
    
    public String LS(String pnombrearchivo){
         int indexcontroldisco;
         String retorno;
         if(!buscarArchivo(pnombrearchivo))
         {
             retorno = "El archivo especificado no existe";
         }
         else{
         indexcontroldisco = buscarArchivoEstructuraDisco(pnombrearchivo);
         Archivo _archivo = _estructuraDisco.getListaArchivos().get(indexcontroldisco);
         
         retorno = "Nombre Archivo: " + _archivo.getNombre() + "\n";
         retorno += "Tamaño en Bytes: " + _archivo.getEspacioAsignado() + "\n";
         retorno += "Bloque Inicial: " + _archivo.getBloqueInicio() +  "\n";
         retorno += "Longitud en bloques: " + _archivo.getNumBloques() + "\n";
         retorno += "Fecha Modificacion: " + _archivo.getFechaModificacion() + "\n";
         
         if(findArchivoAbierto(pnombrearchivo)){
        ControlAcceso _acceso = _estructuraControlAcceso.get(indexcontroldisco);
           retorno += "Archivo Abierto por " +  _acceso.getNombreUsuario() + "\n";
         }  }
        return retorno; 
    }
    
        // LS DISCO
    
    public String LS(){
         String retorno = "";
         ArrayList<Archivo> _lista = _estructuraDisco.getListaArchivos();
         if(_lista.isEmpty())
         {
             retorno = "Disco no contiene archivos";
         }
         else{
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
             int index = buscarIndice(_archivo.getNombre());
         ControlAcceso _acceso = getEstructuraControlAcceso().get(index);
           retorno += "Archivo Abierto por: " +  _acceso.getNombreUsuario() + "\n";
         }  
         }}
        return retorno; 
    }

    /// Importar Archivo
    
    public String importarArchivo(String pusuario, String pnombreArchivo, String pdatos){
        int _asa = crearArchivo(pusuario, pnombreArchivo, pdatos.length());
        if(_asa == -2)
        {
            return "Nombres de archivos en conflicto";
        }
        else if(_asa == -1)
        {
            return "El archivo esta siendo usado por otro usuario";
        }
        else
        {
            escribirArchivo(_asa+"", pdatos);
            reposicionarArchivo(_asa+"","ini",0);
            cerrarArchivo(_asa);   
            return "Archivo importado con exito";
        }        
    }
    
    /// Exportar Archivo
    
    public String exportarArchivo(String pnombreArchivo){
        String mensajeRetorno;
        setAccesoDatos(_accesoDatos);
        int indexcontroldisco = buscarArchivoEstructuraDisco(pnombreArchivo);
        Archivo _archivo = _estructuraDisco.getListaArchivos().get(indexcontroldisco);
        mensajeRetorno = _accesoDatos.leerArchivo(_archivo.getByteInicio(),_archivo.getEspacioAsignado(), _estructuraDisco);    
        return mensajeRetorno;
    }
    
    //Cat Archivo
    
    public String catArchivo(String pnombreArchivo){
        String mensajeRetorno;
        int asa = abrirArchivo(null, pnombreArchivo);
        mensajeRetorno = exportarArchivo(pnombreArchivo);
        cerrarArchivo(asa);
        
        return mensajeRetorno;
    
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
     
     
         
    public int buscarArchivoEstructuraDisco(String pasa)
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
     
    
           
    public int buscarArchivoControlAcceso(String pasa)
    {
        int _contador = 0;
        Boolean _boolean = true;
        int index = Integer.parseInt(pasa);
     
       
        while(_estructuraControlAcceso.size() > _contador && _boolean)
        {
            if(_estructuraControlAcceso.get(_contador).getAsa() == index)
            {
             _boolean = false;
            }
            else {
                _contador++;
            }      
        }
        
        return _contador;
    }
    
    
       public boolean buscarArchivo(String pasa)
    {
        int _contador = 0;
       Boolean _boolean = true;
       Boolean _retorno = false;
       
     
       
        while(_estructuraDisco.getListaArchivos().size() > _contador && _boolean)
        {
            if(_estructuraDisco.getListaArchivos().get(_contador).getNombre().equals(pasa))
            {
             _boolean = false;
             _retorno = true;
            }
            else {
                _contador++;
            }      
        }
        
        return _retorno;
    }
       
       public int buscarIndice(String pnombre)
       {
       int _contador = 0;
        Boolean _boolean = true;

     
       
        while(_estructuraControlAcceso.size() > _contador && _boolean)
        {
            if(_estructuraControlAcceso.get(_contador).getNombreArch().equals(pnombre))
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
    
    public void salir(String pusuario)
      {
          int _contador=0;
          int _asa;
          ControlAcceso _acceso;
          for(_contador = 0;_contador < _estructuraControlAcceso.size(); _contador++)
          {
              _acceso = _estructuraControlAcceso.get(_contador);
              if(_acceso.getNombreUsuario().equals(pusuario))
              {
                  _asa = _acceso.getAsa();
                  cerrarArchivo(_asa);
              }
          }
      }
}