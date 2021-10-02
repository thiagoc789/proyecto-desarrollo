/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.Administrativo;

import BackEnd.ConexionBD;
import FrontEnd.PantallaGerente;
import BackEnd.Sedes;
import BackEnd.Usuarios;
import FrontEnd.PantallaSecretaria;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.beans.Statement;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author alejandro
 */
public class ListarUsuariosTabulados extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarSede
     */
    public ListarUsuariosTabulados() {

        initComponents();
        
        listarPorSede.setBackground(Color.red);
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbl_usuarios = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jcbSedes = new javax.swing.JComboBox<>();
        bCargarSedes = new javax.swing.JButton();
        jbPrueba = new javax.swing.JButton();

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
        listarPorSede.setEnabled(false);
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

        jTbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cedula", "nombre", "telefono", "contraseña", "cargo", "sede", "estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTbl_usuarios);
        if (jTbl_usuarios.getColumnModel().getColumnCount() > 0) {
            jTbl_usuarios.getColumnModel().getColumn(0).setResizable(false);
            jTbl_usuarios.getColumnModel().getColumn(1).setResizable(false);
            jTbl_usuarios.getColumnModel().getColumn(2).setResizable(false);
            jTbl_usuarios.getColumnModel().getColumn(3).setResizable(false);
            jTbl_usuarios.getColumnModel().getColumn(4).setResizable(false);
            jTbl_usuarios.getColumnModel().getColumn(5).setResizable(false);
            jTbl_usuarios.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Ingresar ID");

        bCargarSedes.setText("Cargar sedes");
        bCargarSedes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCargarSedesMouseClicked(evt);
            }
        });

        jbPrueba.setText("Prueba");
        jbPrueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPruebaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listarPorSede, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jbPrueba)
                        .addGap(65, 65, 65)
                        .addComponent(jcbSedes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCargarSedes)
                        .addGap(88, 88, 88))))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(352, 352, 352)
                    .addComponent(jLabel15)
                    .addContainerGap(353, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listarPorSede, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listarTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCargarSedes)
                    .addComponent(jbPrueba))
                .addGap(50, 50, 50))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(253, 253, 253)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(254, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void listarTotalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarTotalesMouseClicked
        // TODO add your handling code here:
        //Usuarios listaUsuarios = new Usuarios();
        jTbl_usuarios.setModel(new DefaultTableModel());
        DefaultTableModel modelo;
        ConexionBD con = new ConexionBD();
        String sql = "";
        java.sql.Connection conexion = con.getConexion();
        java.sql.Statement stmt = con.getStm();

        try {
            conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuariosTabulados.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] nmClm = {"id", "nombre", "telefono", "contraseña", "cargo", "sede", "estado"};

        sql = "SELECT * FROM usuarios";

        modelo = (DefaultTableModel) jTbl_usuarios.getModel();

        modelo.setColumnIdentifiers(nmClm);

        jTbl_usuarios.setModel(modelo);

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
            jTbl_usuarios.setVisible(true);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuariosTabulados.class.getName()).log(Level.SEVERE, null, ex);
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

        jTbl_usuarios.setModel(new DefaultTableModel());

        DefaultTableModel modelo;
        ConexionBD con = new ConexionBD();
        String sql = "";
        java.sql.Connection conexion = con.getConexion();
        java.sql.Statement stmt = con.getStm();
        //String nombreSede = Jtxt_nmSede.getText();
        String nombreSede = jcbSedes.getItemAt(jcbSedes.getSelectedIndex());

        String[] nmClm = {"id", "nombre", "telefono", "contraseña", "cargo", "sede", "estado"};

        try {
            conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuariosTabulados.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "select * from usuarios where sede like '%" + nombreSede + "%'";

        modelo = (DefaultTableModel) jTbl_usuarios.getModel();

        modelo.setColumnIdentifiers(nmClm);

        jTbl_usuarios.setModel(modelo);

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
            jTbl_usuarios.setVisible(true);

            conexion.close();

            

        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuariosTabulados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarPorSedeMouseClicked

    private void listarPorSedeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarPorSedeMouseEntered
        // TODO add your handling code here:
        //listarPorSede.setForeground(Color.red);
    }//GEN-LAST:event_listarPorSedeMouseEntered


    private void listarPorSedeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarPorSedeMouseExited
        // TODO add your handling code here:
        //listarPorSede.setForeground(Color.white);
    }//GEN-LAST:event_listarPorSedeMouseExited

    private void bCargarSedesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCargarSedesMouseClicked
        Sedes sede = new Sedes();
        String listaDeNombres[] = sede.getNombreSedes().split(":");
        
        jcbSedes.removeAllItems();
        for(int i=0; i< listaDeNombres.length ;i++){
            jcbSedes.addItem( listaDeNombres[i] );
        }
        listarPorSede.setEnabled(true);
        listarPorSede.setBackground(new Color(0, 153, 102));
        
        //(0, 153, 102)
    }//GEN-LAST:event_bCargarSedesMouseClicked

    private void jbPruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPruebaMouseClicked
        Document documento = new Document();
        
        try{
            String ruta = System.getProperty("user.home");
            JOptionPane.showMessageDialog(null, "Ruta: " + ruta);
            //PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Prueba.pdf"));
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Reporte_Prueba.pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("Dirección");
            tabla.addCell("Teléfono");
            
            try{
                ConexionBD con = new ConexionBD();
                java.sql.Connection conexion = con.getConexion();
                java.sql.Statement stmt = con.getStm();
                conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
                
                stmt = conexion.createStatement();
                
                String sql = "SELECT * FROM sedes";

                ResultSet rstm = stmt.executeQuery(sql);

                while (rstm.next()) {
                    tabla.addCell( rstm.getString(1) );
                    //tabla.addCell( rstm.getString("id") );
                    
                    tabla.addCell( rstm.getString(2) );
                    //tabla.addCell( rstm.getString("nombre") );
                    
                    tabla.addCell( rstm.getString(3) );
                    //tabla.addCell( rstm.getString("direccion") );
                    
                    tabla.addCell( rstm.getString(4) );
                    //tabla.addCell( rstm.getString("telefono") );
                }
                Paragraph titulo = new Paragraph("Tabla sedes\n", FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLACK));
                
                String texto = "Señores: Cliente\n"
                        + "Les presentamos la lista de las sedes\n\n";
                Paragraph parrafo = new Paragraph(texto, FontFactory.getFont("arial",12,Font.BOLD,BaseColor.BLACK));
                
                documento.add(titulo);
                
                documento.add(parrafo);
                
                documento.add(tabla);
                
                conexion.close();
                

            } catch(DocumentException | SQLException e){
                JOptionPane.showMessageDialog(null, "Aquí 1");
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Creado PDF");
        } catch(DocumentException | HeadlessException | FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Aquí 2");
        }
        
        /*
        ConexionBD con = new ConexionBD();
        String sql = "";
        java.sql.Connection conexion = con.getConexion();
        java.sql.Statement stmt = con.getStm();

        try {
            conexion = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuariosTabulados.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] nmClm = {"id", "nombre", "telefono", "contraseña", "cargo", "sede", "estado"};

        sql = "SELECT * FROM usuarios";

        modelo = (DefaultTableModel) jTbl_usuarios.getModel();

        modelo.setColumnIdentifiers(nmClm);

        jTbl_usuarios.setModel(modelo);

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
            jTbl_usuarios.setVisible(true);

            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListarUsuariosTabulados.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_jbPruebaMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCargarSedes;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTbl_usuarios;
    private javax.swing.JButton jbPrueba;
    public javax.swing.JComboBox<String> jcbSedes;
    javax.swing.JLabel listarPorSede;
    javax.swing.JLabel listarTotales;
    // End of variables declaration//GEN-END:variables
  
}
