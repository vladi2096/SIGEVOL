/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Vladimir
 */
public class programa {
    
    int idPrograma;
    String nombre;

    public programa(int idPrograma, String nombre) {
        this.idPrograma = idPrograma;
        this.nombre = nombre;
    }
    
    public programa(){
        
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
