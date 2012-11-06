/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SA;

/**
 *
 * @author Meza Schmidt
 */
public class ControlAcceso {
    
    //Atributos
    
    private String _nombreUsuario;
    private boolean _enUso;
    private int _posicionPuntero; //Donde se ubica el puntero dentro del archivo
    
    
    //Constructor
    public ControlAcceso(String pnombreUsuario, boolean penUso)
    {
        _nombreUsuario = pnombreUsuario;
        _enUso = penUso;
        _posicionPuntero = 0;
    }
    

            

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return _nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this._nombreUsuario = nombreUsuario;
    }

    /**
     * @return the enUso
     */
    public boolean isEnUso() {
        return _enUso;
    }

    /**
     * @param enUso the enUso to set
     */
    public void setEnUso(boolean enUso) {
        this._enUso = enUso;
    }

    /**
     * @return the _posicionPuntero
     */
    public int getPosicionPuntero() {
        return _posicionPuntero;
    }

    /**
     * @param posicionPuntero the _posicionPuntero to set
     */
    public void setPosicionPuntero(int posicionPuntero) {
        this._posicionPuntero = posicionPuntero;
    }
    
}