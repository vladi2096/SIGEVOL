/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import entidades.contactoEmergencia;
import entidades.desafiliado;
import entidades.persona;
import entidades.traslado;
import entidades.sancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 *
 * @author Vladimir
 */
public class consultaBase {
   
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

    
    
    public boolean trasladarPersona(int cedula, traslado info){
        
        String sql = "insert into trasladado(cedula,codVoluntario,nombre,genero,telefono,celular,\n" +
                    "fechaNacimiento,edad,correo,fechaIngreso,idComite)\n" +
                    "select * from persona where cedula = ? ;";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cedula);
            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        String sql2 = "update trasladado set fechaTraslado = ?, numBoleta = ?, estructura = ?, comiteNuevo = ?, motivo = ? where cedula = ?;";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
 
            // set the corresponding param
            pstmt.setString(1, info.getFecha());
            pstmt.setInt(2, info.getNumBoleta());
            pstmt.setString(3, info.getEstructura());
            pstmt.setInt(4, info.getComite());
            pstmt.setString(5, info.getMotivo());
            pstmt.setInt(6, cedula);
            // update 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public void actualizarComite(int cedula, int comite) {
        String sql = "UPDATE persona SET idComite = ? WHERE cedula = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, comite);
            pstmt.setInt(2, cedula);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean agregarSancion(sancion infoSancion){
        String sql = "INSERT INTO sancion(fecha, descripcion, duracion, cedula) VALUES(?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, infoSancion.getFecha());
            pstmt.setString(2, infoSancion.getDescripcion());
            pstmt.setString(3, infoSancion.getDuracion());
            pstmt.setInt(4, infoSancion.getCedula());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    

    public traslado obtenerPersonaTraslado(int cedula, String nombre){
        String sql = "Select count(*) as cont, codVoluntario, cedula, trasladado.nombre,genero, fechaNacimiento, edad, "
                + "telefono, celular, correo, fechaIngreso, fechaTraslado, numBoleta,  estructura, comiteNuevo ,  motivo, "
                + "comite.nombre as comite, region.nombre as region\n"
                + "From trasladado, comite, region\n" 
                + "Where (trasladado.cedula = "+cedula+" or trasladado.nombre = '"+nombre+"') "
                + "and trasladado.idComite = comite.idComite and comite.idRegion = region.idRegion;";
        traslado traslado = new traslado();
        persona person = new persona();
        int num = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
         
            ResultSet rs  = pstmt.executeQuery();
            person.setIdPersona(rs.getInt("cont"));
            person.setCodigoVoluntario(rs.getString("codVoluntario"));
            person.setCedula(rs.getInt("cedula"));
            person.setNombre(rs.getString("nombre"));
            person.setGenero(rs.getString("genero"));
            person.setFechaNacimiento(rs.getString("fechaNacimiento"));
            person.setEdad((rs.getInt("edad")));
            person.setTelefono(rs.getInt("telefono"));
            person.setCelular(rs.getInt("celular"));
            person.setCorreo(rs.getString("correo"));
            person.setFechaIngreso(rs.getString("fechaIngreso"));
            traslado.setFecha(rs.getString("fechaTraslado"));
            traslado.setNumBoleta(rs.getInt("numBoleta"));
            num = rs.getInt("comiteNuevo");
            traslado.setEstructura(rs.getString("estructura"));
            traslado.setMotivo(rs.getString("motivo"));
            person.setComite(rs.getString("comite"));
            person.setRegion(rs.getString("region"));
            
            traslado.setPersona(person);
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.print(num);
        String sql1 = "Select comite.nombre as comiteN, region.nombre as regionN "
                + "from comite inner join region on comite.idRegion = region.idRegion where idComite = "+num+";";
       
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql1)){
         
            ResultSet rs  = pstmt.executeQuery();
            traslado.setComiteN(rs.getString("comiteN"));
            traslado.setRegionN(rs.getString("regionN"));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return traslado;
    }
    
    public ArrayList<String> obtenerNombreTrasladoBuscar(String nombre){
        String sql = "Select cedula, nombre From trasladado Where nombre like '%"+nombre+"%'";
        ArrayList<String> lista = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
         
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
    
    public ArrayList<String> obtenerNombresTraslado( String filtro ){
        String sql = "Select cedula, t.nombre, c.nombre as comiteV, t.estructura, comiteN\n" +
                        "From trasladado t\n" +
                        "inner join comite c on t.idComite = c.idComite\n" +
                        "inner join region r on c.idRegion = r.idRegion\n" +
                        "left join( Select c.nombre as comiteN, t.cedula as ced\n" +
                        "From trasladado t\n" +
                        "inner join comite c on t.comiteNuevo = c.idComite) where ced = cedula " + filtro;
        ArrayList<String> lista = new ArrayList<>();
        String nombre;
        String cedula;
        String comiteV;
        String comiteN;
        String estructura;
        String union;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
         
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                
                nombre = rs.getString("nombre");
                cedula = rs.getString("cedula");
                comiteV = rs.getString("comiteV");
                comiteN = rs.getString("comiteN");
                estructura = rs.getString("estructura");
                union = nombre + " / " + comiteV + " (Juventud)  ->  " + comiteN + " (" + estructura + ")";
                lista.add(union);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public void filtar( String query ){
        String sql = "Select p.nombre, p.cedula, p.edad, p.genero, p.fechaIngreso, p.idComite, c.nombre, r.nombre, ca.nombre, \n" +
                        "i.espanol, i.ingles, i.portugues, i.aleman, i.frances, i.mandarin\n" +
                        "from persona p\n" +
                        "inner join comite c on p.idComite = c.idComite\n" +
                        "inner join region r on c.idRegion = r.idRegion\n" +
                        "inner join cargo ca on p.idCargo = ca.idCargo\n" +
                        "inner join idioma i on p.cedula = i.cedula\n" +
                        "where ";
        
        sql += query;
        sql += "\nOrder by p.idComite";
        System.out.println(sql);
    }

    public void prueba(){
        ArrayList<Boolean> idioma = new ArrayList<>();
        idioma.add(false);
        idioma.add(Boolean.TRUE);
        idioma.add(false);
        idioma.add(Boolean.TRUE);
        idioma.add(false);
        idioma.add(true);
        idioma.add(false);
        
        for(int i = 0;i<idioma.size();i++){
            System.out.println("Indice "+(i+1)+": "+idioma.get(i));
        }
    }
     
    public static void main(String[] args) {
        consultaBase nu = new consultaBase();
        Connection cone = nu.connect();
        //nu.obtenerTiempo("1996-10-2");
        //person = nu.obtenerPersonaDesafiliado(20990999);
    }
}
