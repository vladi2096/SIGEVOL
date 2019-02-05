/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Vladimir
 */
public class persona {
    
    int idPersona;
    String codigoVoluntario;
    int cedula;
    String estado;
    String nombre;
    String genero;
    int telefono;
    int celular;
    String fechaNacimiento;
    int edad;
    String correo;
    String oficio;
    String fechaIngreso;
    int anosCR;
    String esAsociado;
    int idCargo;
    int idGrado;
    int idPrograma;
    int idComite;
    String cargo;
    String grado;
    String programa;
    String comite;
    String region;
    ArrayList<Boolean> idioma = new ArrayList<>();
    ArrayList<Boolean> cursos = new ArrayList<>();
    
    public persona(){
        
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCodigoVoluntario() {
        return codigoVoluntario;
    }

    public void setCodigoVoluntario(String codigoVoluntario) {
        this.codigoVoluntario = codigoVoluntario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
        
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fachaNacimiento) {
        this.fechaNacimiento = fachaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getAnosCR() {
        return anosCR;
    }

    public void setAnosCR(int anosCR) {
        this.anosCR = anosCR;
    }

    
    public String getEsAsociado() {
        return esAsociado;
    }

    public void setEsAsociado(String esAsociado) {
        this.esAsociado = esAsociado;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public int getIdComite() {
        return idComite;
    }

    public void setIdComite(int idComite) {
        this.idComite = idComite;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getComite() {
        return comite;
    }

    public void setComite(String comite) {
        this.comite = comite;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<Boolean> getIdioma() {
        return idioma;
    }

    public void setIdioma(ArrayList<Boolean> idioma) {
        this.idioma = idioma;
    }

    public ArrayList<Boolean> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Boolean> cursos) {
        this.cursos = cursos;
    }
    
    
}
