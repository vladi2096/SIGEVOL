/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import conexion.ConexionBase;
import entidades.desafiliado;
import entidades.persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Vladimir
 */
public class DesafiliacionConsulta {
    
    ConexionBase conexionBase = new ConexionBase();
    
    public boolean desafiliarPersona(int cedula, String fecha, String motivo){
        
        String sql = "Update persona set estado = 'Desafiliado' where cedula = ?;";
        String sql2 = "INSERT INTO desafiliado(fechaDesafiliacion, motivo, cedula) VALUES(?,?,?);";
        Connection conexion = this.conexionBase.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql);
            conexion.setAutoCommit(false);
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
            
            pstmt = conexion.prepareStatement(sql2);
            pstmt.setString(1, fecha);
            pstmt.setString(2, motivo);
            pstmt.setInt(3, cedula);
            pstmt.executeUpdate();
            conexion.commit();
            return true;
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
        return false;
    }
    
    
    
    public desafiliado obtenerPersonaDesafiliada(int cedula){
        String sql = "Select fechaDesafiliacion, motivo\n" +
                        "From desafiliado\n" +
                        "Where cedula = "+cedula+";";
        desafiliado person = new desafiliado();
        Connection conn = this.conexionBase.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt  = conn.prepareStatement(sql);
            ResultSet rs  = pstmt.executeQuery();
            person.setFechaDesafiliacion(rs.getString("fechaDesafiliacion"));
            person.setMotivo(rs.getString("motivo"));
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return person;
    }
    
    public ArrayList<String> obtenerNombresDesafiliado(String filtro){
        String sql = "Select d.cedula, p.nombre, fechaDesafiliacion, c.nombre, r.nombre\n" +
                    "From desafiliado d\n" +
                    "inner join persona p on d.cedula = p.cedula and  p.estado = 'Desafiliado'\n" +
                    "inner join comite c on p.idComite = c.idComite\n" +
                    "inner join region r on c.idRegion = r.idRegion\n" + filtro + "\n";
        System.out.println(sql);
        ArrayList<String> lista = new ArrayList<>();
        String nombre;
        String cedula;
        String fecha;
        String union;
        Connection conn = this.conexionBase.connect();
        PreparedStatement pstmt = null;
        
        try {
            pstmt  = conn.prepareStatement(sql);
            ResultSet rs  = pstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                
                nombre = rs.getString("nombre");
                cedula = rs.getString("cedula");
                
                StringTokenizer tokensNacimiento = new StringTokenizer(rs.getString("fechaDesafiliacion"), "-");
                String ano1 = tokensNacimiento.nextToken();
                String mes1 = tokensNacimiento.nextToken();
                String dia1 = tokensNacimiento.nextToken();
                fecha= dia1+"/"+mes1+"/"+ano1;
                
                union = nombre + " - " + cedula + " - " + fecha;
                lista.add(union);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<String> obtenerNombreDesafiliadoBuscar(String nombre){
        String sql = "Select cedula, nombre From desafiliado Where nombre like '%"+nombre+"%'";
        ArrayList<String> lista = new ArrayList<>();
        Connection conn = this.conexionBase.connect();
        PreparedStatement pstmt = null;
        
        try {
            pstmt  = conn.prepareStatement(sql);
            ResultSet rs  = pstmt.executeQuery();           
            // loop through the result set
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
