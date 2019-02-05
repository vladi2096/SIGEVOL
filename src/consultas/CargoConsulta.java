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
public class CargoConsulta 
{
    
    ConexionBase conexion = new ConexionBase();
    
    public ArrayList<String> obtenerCargo()
    {
        String sql = "SELECT nombre FROM cargo;";
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
    
    public int obtenerCargoId(String nombre){
        String sql = "SELECT idCargo FROM cargo where nombre = " + "'" +nombre+"'"+ ";";
        Connection conexion = null;
        Statement stmt  = null;
        ResultSet rs = null;
        try 
        {        
            conexion = this.conexion.connect();
            stmt  = conexion.createStatement();
            rs  = stmt.executeQuery(sql);
            return rs.getInt("idCargo");   
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
