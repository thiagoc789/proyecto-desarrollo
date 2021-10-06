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
import java.sql.ResultSet;

/**
 *
 * @author zanti
 */
public class Tarjetas {

    Connection conexion;
    Statement stmt;

    String url = "jdbc:postgresql://queenie.db.elephantsql.com:5432/uaojiigq";
    String user = "uaojiigq";
    String password = "cYZhBPK8Rlzyc7oLTJKJ9dJJ92kpHuJJ";

    String sql = "";
    
    public Connection getConexion(){
        return this.conexion;
    }
    
    public Statement getStm(){
        return this.stmt;
    }

    public Connection dbConecction() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Se ha conectado a la base de datos", "Sistematizacion De Procesos - Flash", JOptionPane.INFORMATION_MESSAGE);
            stmt = conexion.createStatement();

            sql = "CREATE TABLE IF NOT EXISTS tarjetas (numero VARCHAR(50), tipo VARCHAR(50), saldo INT);";
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos", "Sistematizacion De Procesos - Flash", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conexion;
    }
    
    public boolean tarjetaExiste(String numero){
        boolean tarjetaExiste = false;
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(url, user, password);
            stmt = conexion.createStatement();

            sql = "SELECT count(*) FROM tarjetas WHERE numero = \'" + numero +"\'";
            ResultSet rs = stmt.executeQuery(sql);
            
            String respuestaQuery = "";
            
            while(rs.next()){
                respuestaQuery = rs.getString("count");
            }
            
            if( respuestaQuery.compareTo("1") == 0 )
                tarjetaExiste = true;

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return tarjetaExiste;
    }
    
    public boolean descontarDeTarjeta(String numero, int costoTotal){
        boolean transaccionRealizada = false;
        int saldoTarjeta = 0;
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        
        try {
            conexion = DriverManager.getConnection(url, user, password);
            stmt = conexion.createStatement();

            //sql = "SELECT count(*) FROM tarjetas WHERE numero = \'" + numero +"\'";
            sql = "SELECT saldo FROM tarjetas WHERE numero = \'" + numero +"\'";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                saldoTarjeta = rs.getInt("saldo");
            }
            
            if( costoTotal > saldoTarjeta )
                JOptionPane.showMessageDialog(null, "La tarjeta no tiene saldo suficiente");
            else{
                transaccionRealizada = true;
                stmt = conexion.createStatement();

                sql = "UPDATE tarjetas SET saldo = " + (saldoTarjeta-costoTotal) + " WHERE numero = \'" + numero + "\';";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Se han descontado $" + costoTotal + " de la tarjeta");
            }

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return transaccionRealizada;
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
