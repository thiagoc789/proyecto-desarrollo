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
import javax.swing.JOptionPane;

/**
 *
 * @author zanti
 */
public class Clientes {

    ConexionBD conexionExistente = new ConexionBD();
    String sql = "";
    Connection conexion;
    Statement stmt;
    private String cedula_cliente;
    private String nombre_cliente;
    private String direccion_cliente;
    private String comuna_cliente;
    
    
    public boolean cedulaExiste(String cedula){
        boolean cedulaExiste = false;
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT count(*) FROM usuarios WHERE cedula = \'" + cedula +"\'";
            ResultSet rs = stmt.executeQuery(sql);
            
            String respuestaQuery = "";
            
            while(rs.next()){
                respuestaQuery = rs.getString("count");
            }
            
            if( respuestaQuery.compareTo("1") == 0 )
                cedulaExiste = true;

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return cedulaExiste;
    }

    public void registrarClienteNuevo(int cedula, String nombre, String direccion, int id_comuna) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            //JOptionPane.showMessageDialog(null, "Connected to Database");
            //conexion.close();
            stmt = conexion.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS clientes (cedula INT, nombre VARCHAR(50), direccion VARCHAR(100), id_comuna INT);";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO clientes(cedula, nombre, direccion, id_comuna) VALUES("
                    + "\'" + cedula + "\',"
                    + "\'" + nombre + "\',"
                    + "\'" + direccion + "\',"
                    + "\'" + id_comuna + "\'"
                    + ");";
            stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }

    
    public String validarCliente(String cedula) throws SQLException {
        String usuarioValido = "empty";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {            
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            
            sql = "SELECT * FROM clientes "
                    + "WHERE cedula = \'" + cedula + "\'";
            
            ResultSet rs = stmt.executeQuery(sql);
            cedula_cliente = "";
            nombre_cliente = "";
            direccion_cliente = "";
            comuna_cliente = "";
            
            while(rs.next()){
                cedula_cliente = rs.getString("cedula");
                nombre_cliente = rs.getString("nombre");
                direccion_cliente = rs.getString("direccion");
                comuna_cliente = rs.getString("id_comuna");
            }
            
            if( !(cedula.compareTo(cedula_cliente) == 0) ){
                JOptionPane.showMessageDialog(null, "Cédula invalida");
                System.out.println("Cedula Invalida");
            }
                
            
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
        
        return usuarioValido;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getComuna_cliente() {
        return comuna_cliente;
    }

    public void setComuna_cliente(String comuna_cliente) {
        this.comuna_cliente = comuna_cliente;
    }
    
    public String listarUsuarios() throws SQLException {
        String usuarios = "";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {            
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            
            sql = "SELECT * FROM usuarios";
                    //+ "WHERE cedula = \'" + cedula + "\'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                usuarios = usuarios + rs.getString("cedula");
                usuarios = usuarios + "\t" + rs.getString("nombre");
                usuarios = usuarios + "\t" + rs.getString("telefono");
                usuarios = usuarios + "\t" + rs.getString("cargo");
                usuarios = usuarios + "\t" + rs.getString("sede") + "\n";
            }
            
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
        
        return usuarios;
    }
    
    public void modificarUsuario(String cedula, String nombre, String telefono, String correo, String cargo, String sede) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            //sql = "CREATE TABLE IF NOT EXISTS sedes (id VARCHAR(50), nombre VARCHAR(50), direccion VARCHAR(50), telefono VARCHAR(50));";
            //stmt.executeUpdate(sql);
            
            if( !(nombre.compareTo("")== 0) ){
                sql = "UPDATE usuarios "
                    + "SET nombre = \'" + nombre + "\' "
                    + "WHERE cedula = \'" + cedula + "\'";
                stmt.executeUpdate(sql);
            }
            if( !(telefono.compareTo("")== 0) ){
                sql = "UPDATE usuarios "
                    + "SET telefono = \'" + telefono + "\' "
                    + "WHERE cedula = \'" + cedula + "\'";
                stmt.executeUpdate(sql);
            }
//            if( !(correo.compareTo("")== 0) ){
//                sql = "UPDATE usuarios "
//                    + "SET correo = \'" + correo + "\' "
//                    + "WHERE cedula = \'" + cedula + "\'";
//                stmt.executeUpdate(sql);
//            }
            if( !(cargo.compareTo("")== 0) ){
                sql = "UPDATE usuarios "
                    + "SET cargo = \'" + cargo + "\' "
                    + "WHERE cedula = \'" + cedula + "\'";
                stmt.executeUpdate(sql);
            }
            if( !(sede.compareTo("")== 0) ){
                sql = "UPDATE usuarios "
                    + "SET sede = \'" + sede + "\' "
                    + "WHERE cedula = \'" + cedula + "\'";
                stmt.executeUpdate(sql);
            }
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void cambiarEstadoUsuario(String cedula, int estado) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            
            if( estado == 1 ){
                sql = "UPDATE usuarios "
                    + "SET estado = \'Activo' "
                    + "WHERE cedula = \'" + cedula + "\'";
                stmt.executeUpdate(sql);
            }else{
                sql = "UPDATE usuarios "
                    + "SET estado = \'Inactivo' "
                    + "WHERE cedula = \'" + cedula + "\'";
                stmt.executeUpdate(sql);
            }
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
