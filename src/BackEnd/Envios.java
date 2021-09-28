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
public class Envios {

    ConexionBD conexionExistente = new ConexionBD();
    String sql = "";
    Connection conexion;
    Statement stmt;

    public void registrarEnvio(String metodoPago, int valorEnvios, int valorPaquetes, int valorImpuestos, int valorSeguros, int numeroEnvios) throws SQLException {
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
            sql = "CREATE TABLE IF NOT EXISTS envios (metodo_Pago VARCHAR(50), valor_Envios INT, valor_Paquetes INT, valor_Impuestos INT, valor_Seguros INT, numero_Envios int);";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO envios(metodo_Pago, valor_Envios, valor_Paquetes, valor_Impuestos, valor_Seguros, numero_Envios) VALUES("
                    + "\'" + metodoPago + "\',"
                    + "\'" + valorEnvios + "\',"
                    + "\'" + valorPaquetes + "\',"
                    + "\'" + valorImpuestos + "\',"
                    + "\'" + valorSeguros + "\',"
                    + "\'" + numeroEnvios + "\'"
                    + ");";
            stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }

}
