/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import conexion.ConexionBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vladimir
 */
public class CursoConsulta {
    
    ConexionBase conexionBase = new ConexionBase();
    Connection conexion;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void agregarCursoPersona(int cedula, int numCurso){
        String sql = "INSERT INTO persona_curso(cedula, idCurso) VALUES(?,?)";
        conexion = null;
        pstmt = null;
        try 
        {
            conexion = this.conexionBase.connect();
            conexion.setAutoCommit(false);
            pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, cedula);
            pstmt.setInt(2, numCurso);
            pstmt.executeUpdate();
            conexion.commit();
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
    
    public ArrayList<Boolean> obtenerCurso(int cedula){
        String sql = "Select idCurso from persona_curso where cedula = 207550471";
        
        ArrayList<Boolean> curso = new ArrayList<>();
        curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);
        curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);
        curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);curso.add(false);
        conexion = null;
        stmt  = null;
        rs = null;
        
        try {
            conexion = this.conexionBase.connect();
            stmt  = conexion.createStatement();
            rs  = stmt.executeQuery(sql);
            // loop through the result set
            while(rs.next()){
                for(int i=0; i<21; i++){
                    if(rs.getInt("idCurso") == i+1 || curso.get(i).equals(true)){
                        curso.set(i, true);       
                    }
                    else{
                        curso.set(i, false);
                    }   
                }
            }
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
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } 
            catch (SQLException e3) {
                System.out.println(e3.getMessage());
            }
        }
        return curso;
    }
    
    public void borrarCursos(int cedula){
        String sql3 = "DELETE FROM persona_curso WHERE cedula = ?";
        conexion = null;
        pstmt = null;
        try 
        {
            conexion = this.conexionBase.connect();
            conexion.setAutoCommit(false);
            pstmt = conexion.prepareStatement(sql3);
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
            conexion.commit();
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
}
