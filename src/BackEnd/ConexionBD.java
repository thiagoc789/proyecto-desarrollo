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
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author zanti
 */
public class ConexionBD {

    Connection conexion;
    Statement stmt;

    String url = "jdbc:postgresql://ziggy.db.elephantsql.com:5432/hlucabdv";
    String user = "hlucabdv";
    String password = "uIhPd-sKJsprMUCLg3JOsqkqi1d7kSMJ";

    String sql = "";

    public Connection dbConecction() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Se ha conectado a la base de datos", "Sistematizacion De Procesos - Flash", JOptionPane.INFORMATION_MESSAGE);
            stmt = conexion.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS usuarios (cedula VARCHAR(50), nombre VARCHAR(50), telefono VARCHAR(50), contraseña VARCHAR(50), cargo VARCHAR(50), sede VARCHAR(50));";
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos", "Sistematizacion De Procesos - Flash", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conexion;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
