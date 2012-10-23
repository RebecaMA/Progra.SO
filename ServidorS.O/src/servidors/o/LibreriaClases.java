/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidors.o;

/**
 *
 * @author RebeMoreno
 */
public class LibreriaClases {
    
    public LibreriaClases(){}
    public class EstructuraControlDisco{           

        public EstructuraControlDisco() {
        }
    /*Area de control
     bloquesarchivo-tamañobloque-bloqueinicialdirectorio-tamañodirectoriobytes  
     */
        
        String _nombreArchivo;
        float _numeroBytes,_tamañoByte,_tamañoDisco;

        public void setTamañoDisco(float _tamañoDisco) {
            this._tamañoDisco = _tamañoDisco;
        }

        public float getTamañoDisco() {
            return _tamañoDisco;
        }

        public void setNombreArchivo(String _nombreArchivo) {
            this._nombreArchivo = _nombreArchivo;
        }

        public void setNumeroBytes(float _numeroBytes) {
            this._numeroBytes = _numeroBytes;
        }

        public void setTamañoByte(float _tamañoByte) {
            this._tamañoByte = _tamañoByte;
        }

        public String getNombreArchivo() {
            return _nombreArchivo;
        }

        public float getNumeroBytes() {
            return _numeroBytes;
        }
        
        public float getTamañoByte() {
            return _tamañoByte;
        }
    }
    
}
