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
public class gradoAcademico {
    
    int idGrado;
    String nombre;

    public gradoAcademico(int idGrado, String nombre) {
        this.idGrado = idGrado;
        this.nombre = nombre;
    }
    
    public gradoAcademico(){
        
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
