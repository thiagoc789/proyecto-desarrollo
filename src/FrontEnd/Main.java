/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

// v0.2.0
//
//Se separan el frontEnd y el backEnd
//BackEnd
//-Conexion a la base de datos
//-Se pueden registrar sedes
//-Se pueden registrar usuarios
//
//FrontEnd
//-Vista principal usuario nuevo(primer ingreso al sistema)
//-Vista para registrar sede
//-Vista general del gerente
//
//Se completan los requerimientos del sprint 1
//Sprint1
//-Un usuario desea iniciar sesión con rol de gerente
//-El gerente desea poder registrar una nueva sede de la empresa

import BackEnd.ConexionBD;
import BackEnd.RegistrarUsuario;
import java.sql.SQLException;

/**
 *
 * @author zanti
 */
public class Main {

    public static void main(String args[]) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        conexion.dbConecction();

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioNuevo().setVisible(true);
            }
        });
    }

}
