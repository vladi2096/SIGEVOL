/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import conexion.ConexionBase;
import entidades.contactoEmergencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vladimir
 */
public class ContactoEmergenciaConsulta {
    
    ConexionBase conexion = new ConexionBase();
    
    public void agregarContactoEmergencia( contactoEmergencia contacto, int cedula ){
        String sql = "INSERT INTO contacto_emergencia(nombre, parentesco, numero, cedula) VALUES(?,?,?,?)";
        Connection conexion = null;
        PreparedStatement pstmt = null;
        try 
        {
            conexion = this.conexion.connect();
            conexion.setAutoCommit(false);
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getParentesco());
            pstmt.setInt(3, contacto.getNumero());
            pstmt.setInt(4, cedula);  
            pstmt.executeUpdate();
            conexion.commit();
        } 
        catch (SQLException e) 
        {
            try {
                System.out.println(e.getMessage());
                conexion.rollback();
            } 
            catch (SQLException e1) {
                System.out.println("No se puedo realizar el rollback " + e1.getMessage());
            }
        }
        finally 
        {
            if (conexion != null) {
                try {
                    conexion.close();
                } 
                catch ( SQLException ex ) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public contactoEmergencia obtenerContactoEmergencia(int cedula){
        String sql = "select * from contacto_emergencia where cedula = "+cedula+";";
        contactoEmergencia contacto = new contactoEmergencia();
        Connection conexion = null;
        Statement stmt  = null;
        ResultSet rs = null;
        
        try 
        {
            conexion = this.conexion.connect();
            stmt  = conexion.createStatement();
            rs  = stmt.executeQuery(sql);
            contacto.setIdContacto(rs.getInt("idContacto"));
            contacto.setNombre(rs.getString("nombre"));
            contacto.setParentesco(rs.getString("parentesco"));
            contacto.setNumero(rs.getInt("numero")); 
            contacto.setCedula(rs.getInt("cedula"));
        }
        catch (SQLException e) 
        {
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
        return contacto;
    }

    public int actulizarContactoEmergencia(contactoEmergencia contacto, int cedula) {
        String sql = "UPDATE contacto_emergencia SET nombre = ? , "
                + "parentesco = ? , "
                + "numero = ? "
                + "WHERE cedula = ?";
        int valor = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try 
        {
            conn = this.conexion.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getParentesco());
            pstmt.setInt(3, contacto.getNumero());
            pstmt.setInt(4, cedula);
            // update 
            pstmt.executeUpdate();
            valor = 1;
            
        } 
        catch ( SQLException e ) 
        {
            System.out.println(e.getMessage());
        }
        finally 
        {
            if (conn != null) {
                try {
                    conn.close();
                } 
                catch ( SQLException ex ) {
                    Logger.getLogger(PersonaConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valor;
    }
 
}
