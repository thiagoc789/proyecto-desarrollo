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

    public void registrarUsuarioNuevo(String cedula, String nombre, String telefono, String contraseña, String cargo, String sede) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "INSERT INTO usuarios(cedula, nombre, telefono, contraseña, cargo, sede) VALUES("
                    + "\'" + cedula + "\',"
                    + "\'" + nombre + "\',"
                    + "\'" + telefono + "\',"
                    + "\'" + contraseña + "\',"
                    + "\'" + cargo + "\',"
                    + "\'" + sede + "\'"
                    + ");";
            stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }
    
    public boolean validarUsuario(String cedula, String contraseña) throws SQLException {
        boolean usuarioValido = false;
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
            String texto = " ";
            
            while(rs.next()){
                texto = rs.getString("contraseña");
            }

            if( !(contraseña.compareTo(texto) == 0) )
                JOptionPane.showMessageDialog(null, "Cédula o contraseña invalida");
            else
                usuarioValido = true;

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
}
