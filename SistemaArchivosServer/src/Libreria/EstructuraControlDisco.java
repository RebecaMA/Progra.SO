/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Meza Schmidt
 */
public class EstructuraControlDisco implements Serializable {
    
    
    //Atributos
    
    private String _nombre;    
    private String _rutaDirectorio;
    private int _tamanoAreaControl;
    private int _numBloques;
    private int _tamanoBloque;
    private int _bloqueInicio; //Del directorio    
    private int _espacioUsado; //En bloques
    
    private ArrayList<Archivo> _listaArchivos;    
    private ArrayList<Boolean> _listaBloquesLibres;

    
    public EstructuraControlDisco()
    {
        _listaArchivos = new ArrayList<Archivo>();
         _listaBloquesLibres = new ArrayList<Boolean>();
    }
    //Setters y Getters

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param nombre the _nombre to set
     */
    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    /**
     * @return the _rutaDirectorio
     */
    public String getRutaDirectorio() {
        return _rutaDirectorio;
    }

    /**
     * @param rutaDirectorio the _rutaDirectorio to set
     */
    public void setRutaDirectorio(String rutaDirectorio) {
        this._rutaDirectorio = rutaDirectorio;
    }

    /**
     * @return the _tamanoAreaControl
     */
    public int getTamanoAreaControl() {
        return _tamanoAreaControl;
    }

    /**
     * @param tamanoAreaControl the _tamanoAreaControl to set
     */
    public void setTamanoAreaControl(int tamanoAreaControl) {
        this._tamanoAreaControl = tamanoAreaControl;
    }

    /**
     * @return the _numBloques
     */
    public int getNumBloques() {
        return _numBloques;
    }

    /**
     * @param numBloques the _numBloques to set
     */
    public void setNumBloques(int numBloques) {
        this._numBloques = numBloques;
    }

    /**
     * @return the _tamanoBloque
     */
    public int getTamanoBloque() {
        return _tamanoBloque;
    }

    /**
     * @param tamanoBloque the _tamanoBloque to set
     */
    public void setTamanoBloque(int tamanoBloque) {
        this._tamanoBloque = tamanoBloque;
    }

    /**
     * @return the _bloqueInicio
     */
    public int getBloqueInicio() {
        return _bloqueInicio;
    }

    /**
     * @param bloqueInicio the _bloqueInicio to set
     */
    public void setBloqueInicio(int bloqueInicio) {
        this._bloqueInicio = bloqueInicio;
    }

    /**
     * @return the _espacioUsado
     */
    public int getEspacioUsado() {
        return _espacioUsado;
    }

    /**
     * @param espacioUsado the _espacioUsado to set
     */
    public void setEspacioUsado(int espacioUsado) {
        this._espacioUsado = espacioUsado;
    }

    /**
     * @return the _listaArchivos
     */
    public ArrayList<Archivo> getListaArchivos() {
        return _listaArchivos;
    }

    /**
     * @return the _listaBloquesLibres
     */
    public ArrayList<Boolean> getListaBloquesLibres() {
        return _listaBloquesLibres;
    }    
    
    public void setListaArchivos() {
        this._listaArchivos = new ArrayList<Archivo>();
    }

    public void setListaBloquesLibres(int pnumBloques) {
        _listaBloquesLibres = new ArrayList<Boolean>();
        for(int i = 0; i < pnumBloques; i++)
        {
            _listaBloquesLibres.add(true);
        }
        
    }
    
                                //Funcionalidades
    
    
    
    public boolean crearEstructuraArchivo(String pnombre, int pespacioBytes)
    {
        //numero de bloques q se le asignaron        
        int numBloques = (int) Math.ceil((double)pespacioBytes / (double)_tamanoBloque);
        int bloqueInicioArch = findBloqueInicio(numBloques);
        if(bloqueInicioArch != -1)
        {            
            Archivo estructuraArch = new Archivo(pnombre, pespacioBytes, bloqueInicioArch, numBloques,  getDate()); 
            estructuraArch.setByteInicio((bloqueInicioArch * _tamanoBloque) + _tamanoAreaControl);
            _listaArchivos.add(estructuraArch);            
            setBloquesOcupados(bloqueInicioArch, numBloques);
            _espacioUsado = _espacioUsado + numBloques;      
            return true;            
        }
        else
        {
            return false;
            //No hay espacio para guardar el archivo            
        }
    }
                                    
                            //Funcionalidades adicionales
    
    private String getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
    
    
    //Encuentra el blque de inicio para un determinado numero de bloques a asignar
    //Se debe recorrer toda la lista de bloques
    private int findBloqueInicio(int pnumBloques)
    {
        int bloqueInicio = -1;        
        for(int i = _bloqueInicio; i < _listaBloquesLibres.size(); i++)
        {
            if(_listaBloquesLibres.get(i) == true)
            {
                boolean hayEspacio = true;
                for(int j = 1; j < pnumBloques; j++)
                {
                    if((j + i) >= _listaBloquesLibres.size())
                    {
                        hayEspacio = false;
                        break;                                                                        
                    }
                    else if( _listaBloquesLibres.get(j + i) == false)
                    {
                        hayEspacio = false;
                        break;                                                                        
                    }
                }
                if(hayEspacio)
                {
                    bloqueInicio = i;
                    break;
                }                
            }
        }
        return bloqueInicio;    
    }
    
    //Cambia el estado de los bloques a ocupados, desd el bloque de inicio hasta pnumBloques - 1
    private void setBloquesOcupados(int pbloqueInicio, int pnumBloques)
    {
        for(int i = 0; i < pnumBloques; i++)
        {
            _listaBloquesLibres.set(pbloqueInicio + i, false);            
        }
    }
    
    //Cambia el estado de los bloques a ocupados, desd el bloque de inicio hasta pnumBloques - 1
    public void setBloquesLibres(int pbloqueInicio, int pnumBloques)
    {
        for(int i = 0; i < pnumBloques; i++)
        {
            _listaBloquesLibres.set(pbloqueInicio + i, true);            
        }
    }
    
    //Buscar nombres en conflicto
    public boolean findArchivo(String pnombre)
    {
        boolean conflicto = false;
        for(int i = 0; i < _listaArchivos.size(); i++)
        {
            if(_listaArchivos.get(i).getNombre().equals(pnombre))
            {                
                conflicto = true;
                break;
            }
        }        
        return conflicto;
    }
    
    public int getTamanoBytes()
    {
        return (_tamanoAreaControl + _numBloques) * _tamanoBloque;
    }
    
    public int getEspacioUsadoBytes()
    {
        return _espacioUsado * _tamanoBloque;
    }
    
    public int getEspacioLibreBytes()
    {
        return ((_tamanoAreaControl + _numBloques) -_espacioUsado) * _tamanoBloque;
    }
    
    public double getPorcentajeUso()
    {
        double porcentaje = _espacioUsado * 100 / (_tamanoAreaControl + _numBloques);
        return  porcentaje;
    }    
}
