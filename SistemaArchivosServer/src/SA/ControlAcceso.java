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
    
    private int _asa;
    private String _nombreArch;
    private String _nombreUsuario;
    private int _posicionPuntero; //Donde se ubica el puntero dentro del archivo
    
    
    //Constructor
    public ControlAcceso(int pasa, String pnombreUsuario, String pnombreArch)
    {
        _asa = pasa;        
        _nombreUsuario = pnombreUsuario;
        _nombreArch = pnombreArch;
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

    /**
     * @return the _nombreArch
     */
    public String getNombreArch() {
        return _nombreArch;
    }

    /**
     * @param nombreArch the _nombreArch to set
     */
    public void setNombreArch(String nombreArch) {
        this._nombreArch = nombreArch;
    }

    /**
     * @return the _asa
     */
    public int getAsa() {
        return _asa;
    }

    /**
     * @param asa the _asa to set
     */
    public void setAsa(int asa) {
        this._asa = asa;
    }
    
}