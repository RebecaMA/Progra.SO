/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServidor;

/**
 *
 * @author Meza Schmidt
 */
public class Mensaje {
    
    
    //Atributos
    private String _tipoMensaje;
    private String _mensaje;
    private String _usuario;   

    
    //Setters y Getters
    /**
     * @return the _tipoMensaje
     */
    public String getTipoMensaje() {
        return _tipoMensaje;
    }

    /**
     * @param tipoMensaje the _tipoMensaje to set
     */
    public void setTipoMensaje(String tipoMensaje) {
        this._tipoMensaje = tipoMensaje;
    }

    /**
     * @return the _mensaje
     */
    public String getMensaje() {
        return _mensaje;
    }

    /**
     * @param mensaje the _mensaje to set
     */
    public void setMensaje(String mensaje) {
        this._mensaje = mensaje;
    }

    /**
     * @return the _usuario
     */
    public String getUsuario() {
        return _usuario;
    }

    /**
     * @param usuario the _usuario to set
     */
    public void setUsuario(String usuario) {
        this._usuario = usuario;
    }
    
}
