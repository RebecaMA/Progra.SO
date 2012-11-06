/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria;

/**
 *
 * @author Meza Schmidt
 */
public class Archivo {    
    
    private String _nombre;
    private int _espacioAsignado; //Tamano en Bytes    
    private int _bloqueInicio;
    private int _numBloques;
    private String _fechaModificacion; //DD/MM/AA
      
    
    public Archivo(String pnombre, int pespacioAsignado, int pbloqueInicio, int pnumBloques, String pfechaModificacion)
    {        
        _nombre = pnombre;
        _espacioAsignado = pespacioAsignado;
        _bloqueInicio = pbloqueInicio;
        _numBloques = pnumBloques;
        _fechaModificacion = pfechaModificacion;
        
    }
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    /**
     * @return the espacioAsignado
     */
    public int getEspacioAsignado() {
        return _espacioAsignado;
    }

    /**
     * @param espacioAsignado the espacioAsignado to set
     */
    public void setEspacioAsignado(int espacioAsignado) {
        this._espacioAsignado = espacioAsignado;
    }

    /**
     * @return the bloqueInicio
     */
    public int getBloqueInicio() {
        return _bloqueInicio;
    }

    /**
     * @param bloqueInicio the bloqueInicio to set
     */
    public void setBloqueInicio(int bloqueInicio) {
        this._bloqueInicio = bloqueInicio;
    }

    /**
     * @return the numBloques
     */
    public int getNumBloques() {
        return _numBloques;
    }

    /**
     * @param numBloques the numBloques to set
     */
    public void setNumBloques(int numBloques) {
        this._numBloques = numBloques;
    }

    /**
     * @return the fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }

    /**
     * @param fechaModificacion the fechaModificacion to set
     */
    public void setFechaModificacion(String fechaModificacion) {
        this._fechaModificacion = fechaModificacion;
    }
    
}
