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
public class contactoEmergencia {
    
    int idContacto;
    String nombre;
    String parentesco;
    int numero;
    int cedula;

    public contactoEmergencia(int idContacto, String nombre, String parentesco, int numero, int cedula) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.numero = numero;
        this.cedula = cedula;
    }
    
    public contactoEmergencia(){
        
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    
}
