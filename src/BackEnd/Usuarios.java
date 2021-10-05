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
public class Usuarios {

    ConexionBD conexionExistente = new ConexionBD();
    String sql = "";
    Connection conexion;
    Statement stmt;
    
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

    public void registrarUsuarioNuevo(String cedula, String nombre, String telefono, String contraseña, String cargo, String sede, String estado) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "INSERT INTO usuarios(cedula, nombre, telefono, contraseña, cargo, sede, estado) VALUES("
                    + "\'" + cedula + "\',"
                    + "\'" + nombre + "\',"
                    + "\'" + telefono + "\',"
                    + "\'" + contraseña + "\',"
                    + "\'" + cargo + "\',"
                    + "\'" + sede + "\',"
                    + "\'" + estado + "\'"
                    + ");";
            stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }
    
    public String validarIngreso(String cedula, String contraseña) throws SQLException {
        String usuarioValido = "empty";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {            
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            
            sql = "SELECT * FROM usuarios "
                    + "WHERE cedula = \'" + cedula + "\'";
            
            ResultSet rs = stmt.executeQuery(sql);
            String clave = "";
            String cargo = "";
            String estado = "";
            
            while(rs.next()){
                clave = rs.getString("contraseña");
                cargo = rs.getString("cargo");
                estado = rs.getString("estado");
            }

            if( !(contraseña.compareTo(clave) == 0) )
                JOptionPane.showMessageDialog(null, "Cédula o contraseña invalida");
            else if( (estado.compareTo("Inactivo") == 0) )
                JOptionPane.showMessageDialog(null, "El usuario esta inactivo");
            else
                usuarioValido = cargo;
            
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
        
        return usuarioValido;
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
