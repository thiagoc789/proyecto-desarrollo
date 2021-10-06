/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.Auxiliar;

import BackEnd.ConexionBD;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author luisg
 */
public class ListarEnvios extends javax.swing.JPanel {

    String id_usuarioAux;

    /**
     * Creates new form ListarEnvios
     */
    public ListarEnvios(String id_usuario) {
        initComponents();
        id_usuarioAux = id_usuario;

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
        btn_rpts_aux = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(770, 520));

        jTbl_enviosT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_auxiliare", "id_envio", "direccion", "cedula_cliente", "estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        btn_rpts_aux.setBackground(new java.awt.Color(255, 255, 255));
        btn_rpts_aux.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_rpts_aux.setForeground(new java.awt.Color(0, 153, 102));
        btn_rpts_aux.setText("Generar PDF ");
        btn_rpts_aux.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rpts_auxMouseClicked(evt);
            }
        });
        btn_rpts_aux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rpts_auxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Reporte de los envios pendientes:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listarTotales, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(btnFinalizarBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_rpts_aux)
                                .addGap(233, 233, 233))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                .addComponent(btnFinalizarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rpts_aux)
                .addContainerGap())
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
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarBusquedaMouseClicked
        ConexionBD con = new ConexionBD();
        String sql = "";
        java.sql.Connection conexion = con.getConexion();
        Statement stmt;

        try {
            conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());

            stmt = conexion.createStatement();
            sql = "UPDATE envios e SET estado = 'entregado' "
                    + "WHERE e.id_auxiliare like \'" + id_usuarioAux + "\'";

            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ya ha realizado sus entregas");
        }

        jTbl_enviosT.setModel(new DefaultTableModel());
        JOptionPane.showMessageDialog(null, "Inventario Actualizado");


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

        String[] nmClm = {"id_auxiliare", "id_envio", "direccion", "cedula_cliente", "estado"};

        sql = "SELECT id_auxiliare, id_envio, direccion, cedula_cliente, estado FROM envios, clientes WHERE \'" + id_usuarioAux + "\' like id_auxiliare "
                + "and estado = 'pendiente' and cedula_cliente like cedula;";

        modelo = (DefaultTableModel) jTbl_enviosT.getModel();

        modelo.setColumnIdentifiers(nmClm);

        String[] registro = new String[5];

        try {
            stmt = conexion.createStatement();

            ResultSet rstm = stmt.executeQuery(sql);

            while (rstm.next()) {
                registro[0] = rstm.getString(1);
                registro[1] = rstm.getString(2);
                registro[2] = rstm.getString(3);
                registro[3] = rstm.getString(4);
                registro[4] = rstm.getString(5);

                modelo.addRow(registro);

            }

            jTbl_enviosT.setModel(modelo);

            jTbl_enviosT.setVisible(true);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListarEnvios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarTotalesMouseClicked

    private void listarTotalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseEntered
        listarTotales.setForeground(Color.red);
    }//GEN-LAST:event_listarTotalesMouseEntered

    private void listarTotalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseExited
        listarTotales.setForeground(Color.white);
    }//GEN-LAST:event_listarTotalesMouseExited

    private void btn_rpts_auxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rpts_auxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rpts_auxActionPerformed

    private void btn_rpts_auxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rpts_auxMouseClicked
        Document documento = new Document();

        String rutaCompleta = "";

        try {
            String ruta = System.getProperty("user.home");
            //JOptionPane.showMessageDialog(null, "Ruta: " + ruta);
            try {
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_PruebaAux.pdf"));
                rutaCompleta = ruta + "/Desktop/Reporte_PruebaAux.pdf";
            } catch (DocumentException | FileNotFoundException ex1) {
                try {
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Escritorio/Reporte_PruebaAux.pdf"));
                    rutaCompleta = ruta + "/Escritorio/Reporte_PruebaAux.pdf";
                } catch (DocumentException | FileNotFoundException ex2) {
                    try {
                        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Escritorio/Reporte_PruebaAux.pdf"));
                        rutaCompleta = ruta + "/Escritorio/Reporte_PruebaAux.pdf";
                    } catch (DocumentException | FileNotFoundException ex3) {
                    }
                }
            }

            //PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Reporte_Prueba.pdf"));
            documento.open();

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Id del Auxiliar");
            tabla.addCell("Id del envio ");
            tabla.addCell("Dirección del cliente");
            tabla.addCell("Cedula del cliente");
            tabla.addCell("Estado del envio");

            try {
                ConexionBD con = new ConexionBD();
                java.sql.Connection conexion = con.getConexion();
                java.sql.Statement stmt = con.getStm();
                conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());

                stmt = conexion.createStatement();

                String sql = "SELECT id_auxiliare, id_envio, direccion, cedula_cliente, estado FROM envios, clientes WHERE \'" + id_usuarioAux + "\' like id_auxiliare and estado = 'pendiente' and cedula_cliente like cedula;";

                ResultSet rstm = stmt.executeQuery(sql);

                while (rstm.next()) {
                    tabla.addCell(rstm.getString("id_auxiliare"));
                    tabla.addCell(rstm.getString("id_envio"));
                    tabla.addCell(rstm.getString("direccion"));
                    tabla.addCell(rstm.getString("cedula_cliente"));
                    tabla.addCell(rstm.getString("estado"));
                }
                Paragraph titulo = new Paragraph("Tabla Entregas\n", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK));

                String texto = "Señor(a): Auxiliar\n"
                        + "Les presentamos la lista de los envíos\n\n";
                Paragraph parrafo = new Paragraph(texto, FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK));

                documento.add(titulo);

                documento.add(parrafo);

                documento.add(tabla);

                conexion.close();

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "PDF Creado. Se guardó en " + rutaCompleta);
        } catch (HeadlessException ex) {

        }
    }//GEN-LAST:event_btn_rpts_auxMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel btnFinalizarBusqueda;
    private javax.swing.JButton btn_rpts_aux;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbl_enviosT;
    javax.swing.JLabel listarTotales;
    // End of variables declaration//GEN-END:variables
}
