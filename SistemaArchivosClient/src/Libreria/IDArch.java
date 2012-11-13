/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria;

/**
 *
 * @author Meza Schmidt
 */
public class IDArch {
    
    private String _id;
    private int _asa;
    
    public IDArch(String pid, int pasa)
    {
        _id = pid;
        _asa = pasa;
    }
    /**
     * @return the _id
     */
    public String getId() {
        return _id;
    }

    /**
     * @param id the _id to set
     */
    public void setId(String id) {
        this._id = id;
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
