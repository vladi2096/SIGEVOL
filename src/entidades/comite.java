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
public class comite {
    
    int idComite;
    String nombre;
    int codigo;
    int idRegion;

    public comite(int idComite, String nombre, int codigo, int idRegion) {
        this.idComite = idComite;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idRegion = idRegion;
    }
   
    public comite(){
        
    }

    public int getIdComite() {
        return idComite;
    }

    public void setIdComite(int idComite) {
        this.idComite = idComite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }
    
    
}
