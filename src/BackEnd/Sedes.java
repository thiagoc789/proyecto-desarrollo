/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author zanti
 */
public class Sedes {

    ConexionBD conexionExistente = new ConexionBD();
    String sql = "";
    Connection conexion;
    Statement stmt;
    String sedesActivasSoloId = "";
    
    public boolean idExiste(String id){
        boolean existeId = false;
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT count(*) FROM sedes WHERE id = \'" + id +"\'";
            ResultSet rs = stmt.executeQuery(sql);
            
            String texto = "";
            
            while(rs.next()){
                texto = rs.getString("count");
            }
            
            if( texto.compareTo("1") == 0 )
                existeId = true;

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return existeId;
    }

    public void registrarSedeNueva(String id, String nombre, String direccion, String telefono, String comuna) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS sedes (id VARCHAR(50), nombre VARCHAR(50), direccion VARCHAR(50), telefono VARCHAR(50), comuna VARCHAR(10));";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO sedes(id, nombre, direccion, telefono, comuna) VALUES("
                    + "\'" + id + "\',"
                    + "\'" + nombre + "\',"
                    + "\'" + direccion + "\',"
                    + "\'" + telefono + "\',"
                    + "\'" + comuna + "\'"
                    + ");";
            stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }
    
    public void modificarSede(String id, String nombre, String direccion, String telefono, String comuna) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS sedes (id VARCHAR(50), nombre VARCHAR(50), direccion VARCHAR(50), telefono VARCHAR(50), comuna VARCHAR(10));";
            stmt.executeUpdate(sql);
            
            if( !(nombre.compareTo("")== 0) ){
                sql = "UPDATE sedes "
                    + "SET nombre = \'" + nombre + "\' "
                    + "WHERE id = \'" + id + "\'";
                stmt.executeUpdate(sql);
            }
            if( !(direccion.compareTo("")== 0) ){
                sql = "UPDATE sedes "
                    + "SET direccion = \'" + direccion + "\' "
                    + "WHERE id = \'" + id + "\'";
                stmt.executeUpdate(sql);
            }
            if( !(telefono.compareTo("")== 0) ){
                sql = "UPDATE sedes "
                    + "SET telefono = \'" + telefono + "\' "
                    + "WHERE id = \'" + id + "\'";
                stmt.executeUpdate(sql);
            }
            if( !(comuna.compareTo("")== 0) ){
                sql = "UPDATE sedes "
                    + "SET comuna = \'" + comuna + "\' "
                    + "WHERE id = \'" + id + "\'";
                stmt.executeUpdate(sql);
            }
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }
    
    public String listarSedes(){
        String sedesActivasCompleto = "";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT * FROM sedes";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                sedesActivasCompleto = sedesActivasCompleto + rs.getString("id");
                sedesActivasCompleto = sedesActivasCompleto + "\t" + rs.getString("nombre");
                sedesActivasCompleto = sedesActivasCompleto + "\t" + rs.getString("direccion");
                sedesActivasCompleto = sedesActivasCompleto + "\t" + rs.getString("telefono") + "\n";
            }            
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return sedesActivasCompleto;
    }
    
    public String getNombreSedes(){
        String nombreSedes = "";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT * FROM sedes";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                nombreSedes = nombreSedes + rs.getString("nombre") + ":";
            } 
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión con base de datos");
        }
        return nombreSedes;
    }
    
    public String getIdSedes(){
        String idSedes = "";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT * FROM sedes";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                idSedes = idSedes + rs.getString("id") + ":";
            } 
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión con base de datos");
        }
        return idSedes;
    }
    
    public String getIdYComunaSedes(){
        String idYComunaSedes = "";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT * FROM sedes";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                idYComunaSedes = idYComunaSedes + rs.getString("comuna") + ":";
                idYComunaSedes = idYComunaSedes + rs.getString("id") + ":";
            } 
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión con base de datos");
        }
        return idYComunaSedes;
    }
}
