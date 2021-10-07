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
public class Envios {

    ConexionBD conexionExistente = new ConexionBD();
    String sql = "";
    Connection conexion;
    Statement stmt;

    public void registrarEnvio(int cedula_cliente, String metodoPago, int valorEnvios, int valorPaquetes, int valorImpuestos, int valorSeguros, int numeroEnvios) throws SQLException {
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
            sql = "CREATE TABLE IF NOT EXISTS envios (id_envio SERIAL, cedula_cliente INT, metodo_Pago VARCHAR(50), valor_Envios INT, valor_Paquetes INT, valor_Impuestos INT, valor_Seguros INT, numero_Envios int, estado VARCHAR(15));";
            stmt.executeUpdate(sql);
            
            // SQL PARA SELECCIONAR UNA CÉDULA DE UN AUXILIAR ADECUADO
            
            // TENGO
            // cédula del cliente
            
            sql = "SELECT cedula FROM usuarios\n" +
                    "WHERE sede = (SELECT nombre FROM sedes\n" +
                    "WHERE id = (SELECT sede_asignada FROM clientes\n" +
                    "WHERE (cedula = \'" + cedula_cliente + "\') AND (cargo = 'Auxiliar') ))\n" +
                    "ORDER BY RANDOM() LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);
            String cedulaAuxiliar = "";
            while(rs.next()){
                cedulaAuxiliar = rs.getString("cedula");
            }

            sql = "INSERT INTO envios(cedula_cliente, metodo_Pago, valor_Envios, valor_Paquetes, valor_Impuestos, valor_Seguros, numero_Envios, estado, id_auxiliare) VALUES("
                    + "\'" + cedula_cliente + "\',"
                    + "\'" + metodoPago + "\',"
                    + "\'" + valorEnvios + "\',"
                    + "\'" + valorPaquetes + "\',"
                    + "\'" + valorImpuestos + "\',"
                    + "\'" + valorSeguros + "\',"
                    + "\'" + numeroEnvios + "\',"
                    + "\'pendiente\',"
                    + "\'" + cedulaAuxiliar + "\'"
                    + ");";
            stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }

    public String envioRecienteRegistrado(){
        String idEnvioRegistrado = "";
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();

            sql = "SELECT MAX(id_envio) FROM envios";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                idEnvioRegistrado = rs.getString("max");
            }

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return idEnvioRegistrado;
    }
}
