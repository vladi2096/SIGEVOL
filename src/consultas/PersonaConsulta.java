/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import conexion.ConexionBase;
import entidades.persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vladimir
 */
public class PersonaConsulta {
    
    ConexionBase conexion = new ConexionBase();
    
    public void agregarPersona(persona person) throws SQLException 
    {
        String sql = "INSERT INTO persona(codVoluntario,cedula,estado,nombre,genero,telefono,celular,fechaNacimiento,edad,correo,"
                + "oficio,fechaIngreso,anosCR,esAsociado,idCargo,idGrado,idPrograma, idComite) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try 
        {   
            conexion = this.conexion.connect();
            conexion.setAutoCommit(false);
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, person.getCodigoVoluntario());
            pstmt.setInt(2, person.getCedula());
            pstmt.setString(3, person.getEstado());
            pstmt.setString(4, person.getNombre());
            pstmt.setString(5, person.getGenero());
            if(person.getTelefono() == 0){
                pstmt.setString(6, null);
            }
            else{
                 pstmt.setInt(6, person.getTelefono());
            }
            if(person.getCelular() == 0){
                pstmt.setString(7, null);
            }
            else{
                pstmt.setInt(7, person.getCelular());
            }
            
            pstmt.setString(8, person.getFechaNacimiento()); ///hay que cambiarla
            pstmt.setInt(9, this.obtenerTiempo(person.getFechaNacimiento()));
            
            
            if(person.getCorreo().equals("false")){
                pstmt.setString(10, null);
            }
            else{
                pstmt.setString(10, person.getCorreo());
            }
            
            if(person.getOficio().equals("false")){
                pstmt.setString(11, null);
            }
            else{
               pstmt.setString(11, person.getOficio());
            }
            
            pstmt.setString(12, person.getFechaIngreso());
            pstmt.setInt(13, this.obtenerTiempo(person.getFechaIngreso()));
            
            pstmt.setString(14, person.getEsAsociado());
            pstmt.setInt(15, person.getIdCargo());
            pstmt.setInt(16, person.getIdGrado());
            pstmt.setInt(17, person.getIdPrograma());
            pstmt.setInt(18, person.getIdComite());
            pstmt.executeUpdate();
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Se agrego la persona correctamente");
        } 
        catch (SQLException e) 
        {
            try {
                System.out.println(e.getMessage());
                conexion.rollback();
            } 
            catch (SQLException e1) {
                System.out.println("No se pudo realizar el rollback " + e1.getMessage());
            }
        }
        finally 
        {
            if (conexion != null) {
                try {
                    conexion.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public persona obtenerPersona(String nombre, int cedula, String estado){
        String sql = "Select cedula, codVoluntario, persona.nombre,genero,telefono,celular,fechaNacimiento, edad, correo, \n" +
                    "oficio,fechaIngreso, anosCR,esAsociado, cargo.nombre as cargo, grado_academico.nombre as grado, \n" +
                    "programa.nombre as programa, comite.nombre as comite, region.nombre as region\n" +
                    "from persona, cargo, grado_academico, programa, comite, region\n" +
                    "Where (persona.nombre = '"+nombre+"' or cedula = "+cedula+") \n" +
                    "and persona.estado = '"+estado+"' \n" +
                    "and persona.idCargo = cargo.idCargo\n" +
                    "and persona.idGrado = grado_academico.idGrado\n" +
                    "and persona.idPrograma = programa.idPrograma\n" +
                    "and persona.idComite = comite.idComite \n" +
                    "and comite.idRegion = region.idRegion;";
        persona person = new persona();
        Connection conexion = null;
        PreparedStatement pstmt = null;
        ResultSet rs  = null;
        
        try {
            conexion = this.conexion.connect();
            pstmt = conexion.prepareStatement(sql);
            rs = pstmt.executeQuery();
            person.setCedula(rs.getInt("cedula"));
            person.setCodigoVoluntario(rs.getString("codVoluntario"));
            person.setNombre(rs.getString("nombre"));
            person.setGenero(rs.getString("genero"));
            person.setTelefono(rs.getInt("telefono"));
            person.setCelular(rs.getInt("celular"));
            person.setFechaNacimiento(rs.getString("fechaNacimiento"));
            person.setEdad((rs.getInt("edad")));
            person.setCorreo(rs.getString("correo"));
            person.setOficio(rs.getString("oficio"));
            person.setFechaIngreso(rs.getString("fechaIngreso"));
            person.setAnosCR(rs.getInt("anosCR"));
            person.setEsAsociado(rs.getString("esAsociado"));
            person.setCargo(rs.getString("cargo"));
            person.setGrado(rs.getString("grado"));
            person.setPrograma(rs.getString("programa"));
            person.setComite(rs.getString("comite"));
            person.setRegion(rs.getString("region"));
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally 
        {
            if (conexion != null) {
                try {
                    conexion.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return person;
    }
    
    
    public void actulizarPersona(persona person, int cedula) {
        String sql = "UPDATE persona SET codVoluntario = ? , nombre = ? , genero = ? , telefono = ? , celular = ? , "
                + "fechaNacimiento = ? , correo = ? , oficio = ? , fechaIngreso = ? , esAsociado = ? , idCargo = ? , idGrado = ? , idComite = ? "
                + "WHERE cedula = ?";
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try{
            conexion = this.conexion.connect();
            pstmt = conexion.prepareStatement(sql);
            conexion.setAutoCommit(false);
            // set the corresponding param
            pstmt.setString(1, person.getCodigoVoluntario());
            pstmt.setString(2, person.getNombre());
            pstmt.setString(3, person.getGenero());
            pstmt.setInt(4, person.getTelefono());
            pstmt.setInt(5, person.getCelular());
            pstmt.setString(6, person.getFechaNacimiento());
            pstmt.setString(7, person.getCorreo());
            pstmt.setString(8, person.getOficio());
            pstmt.setString(9, person.getFechaIngreso());
            pstmt.setString(10, person.getEsAsociado());
            pstmt.setInt(11, person.getIdCargo());
            pstmt.setInt(12, person.getIdGrado());
            pstmt.setInt(13, person.getIdComite());
            pstmt.setInt(14, cedula);
            // update 
            pstmt.executeUpdate();
            conexion.commit();
            this.actualizarEdad(cedula);
            this.actualizarAnosCR(cedula);
        }
        catch (SQLException e) 
        {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } 
            catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } 
            catch (SQLException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }
    
    
    public int obtenerTiempo( String fecha ){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }
    
    public boolean verificarCedula(int cedula){
        String sql = "Select count(*) as cont from persona where cedula = "+cedula+" and estado = 'Activo'";
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        try 
        {
            conn = this.conexion.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);       
            if(rs.getInt("cont") == 1)
            {
                return true;
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally 
        {
            if (conn != null) {
                try {
                    conn.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    public void actualizarEdad(int cedula){
        String sql = "Update persona set edad = cast(strftime('%Y.%m%d', 'now') - strftime('%Y.%m%d', fechaNacimiento) as int) where cedula = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try 
        {
            conn = this.conexion.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cedula);  
            pstmt.executeUpdate();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        finally 
        {
            if (conn != null) {
                try {
                    conn.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void actualizarAnosCR(int cedula){
        String sql = "Update persona set anosCR = cast(strftime('%Y.%m%d', 'now') - strftime('%Y.%m%d', fechaIngreso) as int) where cedula = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try 
        {
            conn = this.conexion.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cedula);  
            pstmt.executeUpdate();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        finally 
        {
            if (conn != null) {
                try {
                    conn.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<String> obtenerNombreBuscar(String nombre){
        String sql = "Select cedula, nombre From persona Where nombre like '%"+nombre+"%' and estado = 'Activo'";
        ArrayList<String> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        try 
        {
            conn = this.conexion.connect();
            pstmt = conn.prepareStatement(sql);
            rs  = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally 
        {
            if (conn != null) {
                try {
                    conn.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }
    
    
    public void borrarPersona(int cedula) {
        String sql = "DELETE FROM persona WHERE cedula = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = this.conexion.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
 
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sql1 = "DELETE FROM contacto_emergencia WHERE cedula = ?";
 
        try {
            pstmt = conn.prepareStatement(sql1);
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
 
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        String sql2 = "DELETE FROM idioma WHERE cedula = ?";
 
        try {
            
            pstmt = conn.prepareStatement(sql2);
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        String sql3 = "DELETE FROM persona_curso WHERE cedula = ?";
 
        try{
            pstmt = conn.prepareStatement(sql3);
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
 
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
    }
}
