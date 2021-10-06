/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.Auxiliar;

import BackEnd.ConexionBD;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luisg
 */
public class ListarEnvios extends javax.swing.JPanel {

    /**
     * Creates new form ListarEnvios
     */
    public ListarEnvios() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbl_enviosT = new javax.swing.JTable();
        btnFinalizarBusqueda = new javax.swing.JLabel();
        listarTotales = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(770, 520));

        jTbl_enviosT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTbl_enviosT);

        btnFinalizarBusqueda.setBackground(new java.awt.Color(0, 153, 102));
        btnFinalizarBusqueda.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnFinalizarBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFinalizarBusqueda.setText("Finalizar Entregas");
        btnFinalizarBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFinalizarBusqueda.setOpaque(true);
        btnFinalizarBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarBusquedaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinalizarBusquedaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinalizarBusquedaMouseExited(evt);
            }
        });

        listarTotales.setBackground(new java.awt.Color(0, 153, 102));
        listarTotales.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        listarTotales.setForeground(new java.awt.Color(255, 255, 255));
        listarTotales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listarTotales.setText("Consultar Envíos");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFinalizarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(386, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarBusquedaMouseClicked
        // TODO add your handling code here:
        //Usuarios listaUsuarios = new Usuarios();
       
    }//GEN-LAST:event_btnFinalizarBusquedaMouseClicked

    private void btnFinalizarBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarBusquedaMouseEntered
        // TODO add your handling code here:
        btnFinalizarBusqueda.setForeground(Color.red);
    }//GEN-LAST:event_btnFinalizarBusquedaMouseEntered

    private void btnFinalizarBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarBusquedaMouseExited
        // TODO add your handling code here:
        btnFinalizarBusqueda.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnFinalizarBusquedaMouseExited

    private void listarTotalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseClicked
        // TODO add your handling code here:
         jTbl_enviosT.setModel(new DefaultTableModel());
        DefaultTableModel modelo;
        ConexionBD con = new ConexionBD();
        String sql = "";
        java.sql.Connection conexion = con.getConexion();
        java.sql.Statement stmt = con.getStm();

        try {
            conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(ListarEnvios.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] nmClm = {"metodo de pago", "valor envios", "valor seguros", "numero envios", "estado", "direccion", "sede", "ID"};

        sql = "SELECT * FROM envios";

        modelo = (DefaultTableModel) jTbl_enviosT.getModel();

        modelo.setColumnIdentifiers(nmClm);

        jTbl_enviosT.setModel(modelo);

        String[] registro = new String[7];

        try {
            stmt = conexion.createStatement();

            ResultSet rstm = stmt.executeQuery(sql);

            while (rstm.next()) {
                registro[0] = rstm.getString(1);
                registro[1] = rstm.getString(2);
                registro[2] = rstm.getString(3);
                registro[3] = rstm.getString(4);
                registro[4] = rstm.getString(5);
                registro[5] = rstm.getString(6);
                registro[6] = rstm.getString(7);
                modelo.addRow(registro);
            }
            jTbl_enviosT.setVisible(true);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListarEnvios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarTotalesMouseClicked

    private void listarTotalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listarTotalesMouseEntered

    private void listarTotalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_listarTotalesMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel btnFinalizarBusqueda;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbl_enviosT;
    javax.swing.JLabel listarTotales;
    // End of variables declaration//GEN-END:variables
}
