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

/**
 *
 * @author Vladimir
 */
public class EstadisticaConsulta {
    
    ConexionBase conexionBase = new ConexionBase();
    
    public ArrayList<Integer> obtenerPersonalRegion(){
        
        ArrayList<Integer> cantidad = new ArrayList<>();
        String sql = "Select region.idRegion from persona, comite, region\n" +
                        "where persona.idComite = comite.idComite \n" +
                        "and comite.idRegion = region.idRegion;";
        
        Connection conexion = null;
        Statement stmt  = null;
        ResultSet rs = null;
        for(int i = 0; i < 9; i++){
            cantidad.add(0);
        }
        try {
            conexion = this.conexionBase.connect();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);      
            while (rs.next()) {
                int region = rs.getInt("idRegion");
                switch (region) {
                    case 1:  cantidad.set(0, cantidad.get(0)+1);
                             break;
                    case 2:  cantidad.set(1, cantidad.get(1)+1);
                             break;
                    case 3:  cantidad.set(2, cantidad.get(2)+1);
                             break;
                    case 4:  cantidad.set(3, cantidad.get(3)+1);
                             break;
                    case 5:  cantidad.set(4, cantidad.get(4)+1);
                             break;
                    case 6:  cantidad.set(5, cantidad.get(5)+1);
                             break;
                    case 7:  cantidad.set(6, cantidad.get(6)+1);
                             break;
                    case 8:  cantidad.set(7, cantidad.get(7)+1);
                             break;
                    case 9:  cantidad.set(8, cantidad.get(8)+1);
                             break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cantidad; 
    }
    
    public ArrayList<Integer> obtenerEstadisticas(){
        
        ArrayList<Integer> cantidad = new ArrayList<>();
        String sql = "SELECT count() FROM persona where genero = 'Masculino'\n" +
                        "UNION ALL  SELECT count() FROM persona where genero = 'Femenino'\n" +
                        "UNION ALL  select avg(edad) fROm persona;";
        Connection conexion = null;
        Statement stmt  = null;
        ResultSet rs = null;
        try {
            conexion = this.conexionBase.connect();
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);  
            while (rs.next()) {
                cantidad.add(rs.getInt("count()"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cantidad; 
    }
    
    public ArrayList<Integer> obtenerEstadisticasCursos(){
        ArrayList<Integer> cantidad = new ArrayList<>();
        Connection conexion = this.conexionBase.connect();
        Statement stmt  = null;
        ResultSet rs = null;
        for(int i = 0; i<21; i++){
            String sql = "SELECT count() FROM persona_curso WHERE idCurso = "+(i+1)+";";
            try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);  
                cantidad.add(rs.getInt("count()"));
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        String sql = "SELECT count() FROM persona;";

            try {
                stmt = conexion.createStatement();
                rs = stmt.executeQuery(sql); 
                cantidad.add(rs.getInt("count()"));
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return cantidad; 
    }
}
