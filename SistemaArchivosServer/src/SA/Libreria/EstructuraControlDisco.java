/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SA.Libreria;

import java.util.ArrayList;

/**
 *
 * @author Meza Schmidt
 */
public class EstructuraControlDisco {
    
    
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
}
