/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Vladimir
 */
public class ConexionBase {
    
    public static void connectResponse() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/sipaju.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("La conexion fue correcta");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/sipaju.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connectResponse();
    }
}
