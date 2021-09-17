/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.Gerente;

import FrontEnd.PantallaGeneralGerente;
import BackEnd.Sedes;
import BackEnd.Usuarios;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author alejandro
 */
public class ListarUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarSede
     */
    public ListarUsuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        listarTotales = new javax.swing.JLabel();
        listarPorSede = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));

        listarTotales.setBackground(new java.awt.Color(0, 153, 102));
        listarTotales.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        listarTotales.setForeground(new java.awt.Color(255, 255, 255));
        listarTotales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listarTotales.setText("Usuarios totales");
        listarTotales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listarTotales.setOpaque(true);
        listarTotales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarTotalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listarTotalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listarTotalesMouseExited(evt);
            }
        });

        listarPorSede.setBackground(new java.awt.Color(0, 153, 102));
        listarPorSede.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        listarPorSede.setForeground(new java.awt.Color(255, 255, 255));
        listarPorSede.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listarPorSede.setText("Usuarios por sede");
        listarPorSede.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listarPorSede.setOpaque(true);
        listarPorSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarPorSedeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listarPorSedeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listarPorSedeMouseExited(evt);
            }
        });

        area.setEditable(false);
        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(listarPorSede, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listarPorSede, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listarTotalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseClicked
        // TODO add your handling code here:
        Usuarios listaUsuarios = new Usuarios();
        try {
            area.setText( listaUsuarios.listarUsuarios() );
//            registrar.registrarSedeNueva(Id.getText(), Nombre.getText(), Dirección.getText(), Telefono.getText());
//            JOptionPane.showMessageDialog(null, "Sede " + Id.getText() + " Registrada Con Exito", "Sistematizacion De Procesos - Flash", JOptionPane.INFORMATION_MESSAGE);
//            Id.setText("");
//            Nombre.setText("");
//            Dirección.setText("");
//            Telefono.setText("");
//
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarSedeViejo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarTotalesMouseClicked

    private void listarTotalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseEntered
        // TODO add your handling code here:
        listarTotales.setForeground(Color.red);
    }//GEN-LAST:event_listarTotalesMouseEntered

    private void listarTotalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseExited
        // TODO add your handling code here:
        listarTotales.setForeground(Color.WHITE);
    }//GEN-LAST:event_listarTotalesMouseExited

    private void listarPorSedeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarPorSedeMouseClicked
        // TODO add your handling code here:
        //new PantallaGeneralGerente().setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_listarPorSedeMouseClicked

    private void listarPorSedeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarPorSedeMouseEntered
        // TODO add your handling code here:
        //listarPorSede.setForeground(Color.red);
    }//GEN-LAST:event_listarPorSedeMouseEntered

    private void listarPorSedeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarPorSedeMouseExited
        // TODO add your handling code here:
        //listarPorSede.setForeground(Color.white);
    }//GEN-LAST:event_listarPorSedeMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea area;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JLabel listarPorSede;
    javax.swing.JLabel listarTotales;
    // End of variables declaration//GEN-END:variables
}
