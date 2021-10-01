/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author zanti
 */
public class RegistrarUsuario {

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
            //JOptionPane.showMessageDialog(null, "Connected to Database");
            //conexion.close();
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

}
