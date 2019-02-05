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
public class traslado {
    
    int idTraslado;
    String fecha;
    int numBoleta;
    String estructura;
    int comite;
    String motivo;
    String comiteN;
    String regionN;
    persona persona;

    public traslado(int idTraslado, String fecha, int numBoleta, String estructura, int comite, String motivo, String comiteN, String regionN, persona persona) {
        this.idTraslado = idTraslado;
        this.fecha = fecha;
        this.numBoleta = numBoleta;
        this.estructura = estructura;
        this.comite = comite;
        this.motivo = motivo;
        this.comiteN = comiteN;
        this.regionN = regionN;
        this.persona = persona;
    }
    
    public traslado(String fecha, int numBoleta, String estructura, int comite, String motivo) {
        this.fecha = fecha;
        this.numBoleta = numBoleta;
        this.estructura = estructura;
        this.comite = comite;
        this.motivo = motivo;
    }

    public traslado() {
    }

    public int getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(int idTraslado) {
        this.idTraslado = idTraslado;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumBoleta() {
        return numBoleta;
    }

    public void setNumBoleta(int numBoleta) {
        this.numBoleta = numBoleta;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public int getComite() {
        return comite;
    }

    public void setComite(int comite) {
        this.comite = comite;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getComiteN() {
        return comiteN;
    }

    public void setComiteN(String comiteN) {
        this.comiteN = comiteN;
    }
    
    public persona getPersona() {
        return persona;
    }

    public void setPersona(persona persona) {
        this.persona = persona;
    }

    public String getRegionN() {
        return regionN;
    }

    public void setRegionN(String regionN) {
        this.regionN = regionN;
    }
    
    
}
