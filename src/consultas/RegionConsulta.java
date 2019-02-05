/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import conexion.ConexionBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladimir
 */
public class RegionConsulta {
    
    ConexionBase conexion = new ConexionBase();
    
    //Se obtiene una lista de los nombres de la regiones
    public ArrayList<String> obtenerTodasRegion(){
        String sql = "SELECT nombre FROM region;";
        ArrayList<String> lista = new ArrayList<>();
        Connection conexion = null;
        Statement stmt  = null;
        ResultSet rs = null;
        try
        {
            conexion = this.conexion.connect();
            stmt  = conexion.createStatement();
            rs  = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
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
        return lista;
    }
    
    //Se obtiene el numero de una region X.
    public int obtenerRegionId( String nombre ){
        String sql = "SELECT idRegion FROM region where nombre = '"+nombre+"';";
        Connection conexion = null;
        Statement stmt  = null;
        ResultSet rs = null;
        try
        {        
            conexion = this.conexion.connect();
            stmt  = conexion.createStatement();
            rs  = stmt.executeQuery(sql);
            return rs.getInt("idRegion");   
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
        return 0;
    }
}
