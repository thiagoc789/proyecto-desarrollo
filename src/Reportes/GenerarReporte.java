/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
import BackEnd.ConexionBD;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zeus
 */
public class GenerarReporte {
    public void crearJasperReport() {
		ConexionBD con = new ConexionBD();
                java.sql.Connection conexion = con.getConexion();
                try {
                    conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
                } catch (SQLException ex) {
                    Logger.getLogger(GenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
		
		try {
			JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/Reportes/reportePrueba.jasper"));
			JasperPrint jp = JasperFillManager.fillReport(reporte, new HashMap<>(), conexion);
			JasperViewer view = new JasperViewer(jp, false);
			view.setVisible(true);
		} 	catch(Exception e) {
                    e.printStackTrace();
	  }
    }
}
