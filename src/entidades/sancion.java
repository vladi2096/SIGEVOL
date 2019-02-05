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
public class sancion {
    
    int idSancion;
    String fecha;
    String descripcion;
    String duracion;
    int cedula;

    public sancion(String fecha, String descripcion, String duracion, int cedula) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.cedula = cedula;
    }

    public sancion() {
    }

    public int getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(int idSancion) {
        this.idSancion = idSancion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    
    
    
    
}
