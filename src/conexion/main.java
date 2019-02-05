/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import consultas.PersonaConsulta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Vladimir
 */
public class main {
 
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void creacionBase(String fileName) {
 
        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void creacionTablas() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/sipaju.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS persona (\n" +
                        " cedula INTEGER PRIMARY KEY,\n" +
                        " codVoluntario INTEGER NOT NULL,\n" +
                        " estado TEXT NOT NULL,\n" +
                        " nombre TEXT NOT NULL,\n" +
                        " genero TEXT NOT NULL,\n" +
                        " telefono INTEGER,\n" +
                        " celular INTEGER,\n" +
                        " fechaNacimiento TEXT NOT NULL,\n" +
                        " edad INTEGER, \n" +
                        " correo TEXT,\n" +
                        " oficio TEXT,\n" +
                        " fechaIngreso TEXT NOT NULL,\n" +
                        " anosCR INTEGER,\n" +
                        " esAsociado TEXT NOT NULL,\n" +
                        " idCargo INTEGER,\n" +
                        " idGrado INTEGER,\n" +
                        " idPrograma INTEGER,\n" +
                        " idComite INTEGER,\n" +
                        " FOREIGN KEY (idCargo) REFERENCES cargo (idCargo) ON DELETE CASCADE,\n" +
                        " FOREIGN KEY (idGrado) REFERENCES grado_academico (idGrado) ON DELETE CASCADE,\n" +
                        " FOREIGN KEY (idPrograma) REFERENCES programa (idPrograma) ON DELETE CASCADE,\n" +
                        " FOREIGN KEY (idComite) REFERENCES comite (idComite) ON DELETE CASCADE \n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS region (\n" +
                        " idRegion INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS comite (\n" +
                        " idComite INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL,\n" +
                        " codigo TEXT NOT NULL,\n" +
                        " idRegion INTEGER, \n" +
                        " FOREIGN KEY (idRegion) REFERENCES region (idRegion) ON DELETE CASCADE \n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS cargo (\n" +
                        " idCargo INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL\n" +
                        ");\n" +
                        "\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS contacto_emergencia (\n" +
                        " idContacto INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL,\n" +
                        " parentesco TEXT NOT NULL,\n" +
                        " numero INTEGER NOT NULL,\n" +
                        " cedula INTEGER,\n" +
                        " FOREIGN KEY (cedula) REFERENCES persona (cedula) ON DELETE CASCADE \n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS curso (\n" +
                        " idCurso INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL, \n" +
                        " abreviatura TEXT NOT NULL\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS desafiliado ( \n" +
                        "	idDesafiliacion INTEGER PRIMARY KEY,\n" +
                        "	fechaDesafiliacion TEXT, \n" +
                        "	motivo TEXT,\n" +
                        "	cedula INTEGER,\n" +
                        "	FOREIGN KEY (cedula) REFERENCES persona (cedula) ON DELETE CASCADE\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS grado_academico (\n" +
                        " idGrado INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS idioma (\n" +
                        " cedula INTEGER PRIMARY KEY,\n" +
                        " espanol INTEGER NOT NULL,\n" +
                        " ingles INTEGER NOT NULL,\n" +
                        " portugues INTEGER NOT NULL,\n" +
                        " aleman INTEGER NOT NULL,\n" +
                        " frances INTEGER NOT NULL,\n" +
                        " mandarin INTEGER NOT NULL,\n" +
                        " FOREIGN KEY (cedula) REFERENCES persona (cedula) ON DELETE CASCADE \n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS persona_curso (\n" +
                        " idPersona INTEGER PRIMARY KEY,\n" +
                        " cedula INTEGER,\n" +
                        " idCurso INTEGER,\n" +
                        " FOREIGN KEY (cedula) REFERENCES persona (cedula) ON DELETE CASCADE\n" +
                        " FOREIGN KEY (idCurso) REFERENCES curso (idCurso) ON DELETE CASCADE\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS sancion (\n" +
                        " idSancion INTEGER PRIMARY KEY,\n" +
                        " fecha TEXT NOT NULL,\n" +
                        " descripcion TEXT NOT NULL,\n" +
                        " duracion TEXT NOT NULL,\n" +
                        " cedula INTEGER,\n" +
                        " FOREIGN KEY (cedula) REFERENCES persona (cedula) ON DELETE CASCADE \n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS programa (\n" +
                        " idPrograma INTEGER PRIMARY KEY,\n" +
                        " nombre TEXT NOT NULL\n" +
                        ");\n" +
                        "\n" +
                        "CREATE TABLE IF NOT EXISTS traslado ( \n" +
                        "	idTraslado INTEGER PRIMARY KEY,\n" +
                        "	fechaTraslado TEXT, \n" +
                        "	numBoleta INTEGER,\n" +
                        "	estructuraOrigen TEXT,\n" +
                        "	estructuraDestino TEXT,\n" +
                        "	comiteOrigen INTEGER,\n" +
                        "	comiteDestino INTEGER,\n" +
                        "	motivo TEXT,\n" +
                        "	FOREIGN KEY (comiteOrigen) REFERENCES comite (idComite) ON DELETE CASCADE,\n" +
                        "	FOREIGN KEY (comiteDestino) REFERENCES comite (idComite) ON DELETE CASCADE \n" +
                        ");\n" +
                        "\n" +
                        "\n" +
                        "";
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("The tables has been created.");
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
 
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        creacionBase("sipaju.db");
        //creacionTablas();
    }
}