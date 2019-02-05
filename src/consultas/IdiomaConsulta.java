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
import java.util.ArrayList;

/**
 *
 * @author Vladimir
 */
public class IdiomaConsulta {
    
    ConexionBase conexionBase = new ConexionBase();
    Connection conexion;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void agregarIdiomaPersona( int cedula, ArrayList<Boolean> idioma )
    {
        String sql = "INSERT INTO idioma(cedula, espanol, ingles, portugues, aleman, frances, mandarin) VALUES(?,?,?,?,?,?,?)";
        conexion = null;
        pstmt = null;
        try 
        {
            conexion = this.conexionBase.connect();
            conexion.setAutoCommit(false);
            pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, cedula);
            pstmt.setBoolean(2, idioma.get(0) );
            pstmt.setBoolean(3, idioma.get(1));
            pstmt.setBoolean(4, idioma.get(2));
            pstmt.setBoolean(5, idioma.get(3));
            pstmt.setBoolean(6, idioma.get(4));
            pstmt.setBoolean(7, idioma.get(5));
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

    public ArrayList<Boolean> obtenerIdioma( int cedula )
    {
        String sql = "Select * from idioma where cedula = "+cedula+";";
        ArrayList<Boolean> idioma = new ArrayList<>();
        for(int i = 0; i<6; i++){
            idioma.add(Boolean.FALSE);
        }
        conexion = null;
        stmt  = null;
        rs = null;
        try 
        { 
            conexion = this.conexionBase.connect();
            stmt  = conexion.createStatement();
            rs  = stmt.executeQuery(sql);
            // loop through the result set
            while(rs.next())
            {
                idioma.set(0, rs.getInt( "espanol" ) == 1 ); 
                idioma.set(1, rs.getInt( "ingles" ) == 1 ); 
                idioma.set(2, rs.getInt( "portugues" ) == 1 ); 
                idioma.set(3, rs.getInt( "aleman" ) == 1 ); 
                idioma.set(4, rs.getInt( "frances" ) == 1 ); 
                idioma.set(5, rs.getInt( "mandarin" ) == 1 );  
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
        return idioma;
    }
    
    public void actulizarPersona(ArrayList<Boolean> idiomas, int cedula) {
        String sql = "UPDATE idioma SET espanol = ? , ingles = ? , portugues = ? , aleman = ? , frances = ? , "
                + "mandarin = ? "
                + "WHERE cedula = ?";
        conexion = null;
        pstmt = null;

        try{
            conexion = this.conexionBase.connect();
            pstmt = conexion.prepareStatement(sql);
            conexion.setAutoCommit(false);
            // set the corresponding param
            pstmt.setBoolean(1, idiomas.get(0));
            pstmt.setBoolean(2, idiomas.get(1));
            pstmt.setBoolean(3, idiomas.get(2));
            pstmt.setBoolean(4, idiomas.get(3));
            pstmt.setBoolean(5, idiomas.get(4));
            pstmt.setBoolean(6, idiomas.get(5));
            pstmt.setInt(7, cedula);
            // update 
            pstmt.executeUpdate();
            conexion.commit();
            //this.agregarEdad(cedula);
            //this.agregarAnosCR(cedula);
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
