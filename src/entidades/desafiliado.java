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
public class desafiliado {
    
    int idDesafiliado;
    String fechaDesafiliacion;
    String motivo;
    persona persona;

    public desafiliado(int idDesafiliado, String fechaDesafiliacion, String motivo, persona persona) {
        this.idDesafiliado = idDesafiliado;
        this.fechaDesafiliacion = fechaDesafiliacion;
        this.motivo = motivo;
        this.persona = persona;
    }

    public desafiliado() {
    }

    public int getIdDesafiliado() {
        return idDesafiliado;
    }

    public void setIdDesafiliado(int idDesafiliado) {
        this.idDesafiliado = idDesafiliado;
    }

    public String getFechaDesafiliacion() {
        return fechaDesafiliacion;
    }

    public void setFechaDesafiliacion(String fechaDesafiliacion) {
        this.fechaDesafiliacion = fechaDesafiliacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public persona getPersona() {
        return persona;
    }

    public void setPersona(persona persona) {
        this.persona = persona;
    }
    
    

   
}
