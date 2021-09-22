/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void registrarSedeNueva(String id, String nombre, String direccion, String telefono) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            //JOptionPane.showMessageDialog(null, "Connected to Database");
            //conexion.close();
            sql = "INSERT INTO sedes(id, nombre, direccion, telefono) VALUES(?, ?, ?, ?);";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, direccion);
            stmt.setString(4, telefono);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sede " + id + " Registrada Con Exitooo", "Sistematizacion De Procesos - Flash", JOptionPane.INFORMATION_MESSAGE);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
        }
    }
    
    public void modificarSede(String id, String nombre, String direccion, String telefono) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            conexion = DriverManager.getConnection(conexionExistente.getUrl(), conexionExistente.getUser(), conexionExistente.getPassword());
            stmt = conexion.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS sedes (id VARCHAR(50), nombre VARCHAR(50), direccion VARCHAR(50), telefono VARCHAR(50));";
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
            //stmt.executeUpdate(sql);

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Connected");
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public String listarSedes(){
        String sedesActivas = "";
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
                sedesActivas = sedesActivas + rs.getString("id");
                sedesActivas = sedesActivas + "\t" + rs.getString("nombre");
                sedesActivas = sedesActivas + "\t" + rs.getString("direccion");
                sedesActivas = sedesActivas + "\t" + rs.getString("telefono") + "\n";
            }
            
//            if( sedesActivas.compareTo("") == 0 ){
//                //sedesActivas = true;
//                JOptionPane.showMessageDialog(null, "Pues sí");
//            }
            
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de coneción con base de datos");
        }
        return sedesActivas;
    }

}
