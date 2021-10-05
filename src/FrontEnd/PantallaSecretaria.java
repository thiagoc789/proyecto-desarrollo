package FrontEnd;

import FrontEnd.Administrativo.*;
import FrontEnd.Operador.RegistrarEnvio;
import FrontEnd.Secretaria.Funcion1Secretaria;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

public class PantallaSecretaria extends javax.swing.JFrame {

    private int x;
    private int y;
    
    String idUsuario;
    
    ListarUsuariosTabulados panelListarUsuarios = new ListarUsuariosTabulados();


    
     public PantallaSecretaria(String idUsuario) {
        initComponents();
        contenedor.setVisible(false);
        this.idUsuario = idUsuario;
    }
    
    public void cambioVisualizacion(){
        label2.setEnabled(true);
        lListarUsuarios.setEnabled(true);
        label3.setEnabled(true);

        panelListarUsuarios.setVisible(false);
    }
    
    public void visualizacionActual(String panel){
        
        if(panel.compareTo("listarUsuarios") == 0){
            panelListarUsuarios.setVisible(true);
            contenedor.add( panelListarUsuarios );
            lListarUsuarios.setEnabled(false);
        }else if(panel.compareTo("actualizarSede") == 0){
//            actualizarSede.setVisible(true);
//            contenedor.add(actualizarSede);
//            label2.setEnabled(false);
        }else if(panel.compareTo("nuevoUsuario") == 0){
//            nuevoUsuario.setVisible(true);
//            contenedor.add(nuevoUsuario);
//            label3.setEnabled(false);
        }
        
        contenedor.validate();
        contenedor.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel lCerrarSesion = new javax.swing.JLabel();
        javax.swing.JLabel jlBloquear = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        label3 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        lListarUsuarios = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistematización De Procesos - Empresa Flash");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/negative.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sistematización De Procesos - Empresa Flash");

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Pantalla General Secretaria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(246, 246, 246))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));

        lCerrarSesion.setBackground(new java.awt.Color(0, 153, 102));
        lCerrarSesion.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCerrarSesion.setText("Cerrar Sesión");
        lCerrarSesion.setOpaque(true);
        lCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCerrarSesionMouseClicked(evt);
            }
        });

        jlBloquear.setBackground(new java.awt.Color(0, 153, 102));
        jlBloquear.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jlBloquear.setForeground(new java.awt.Color(255, 255, 255));
        jlBloquear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlBloquear.setText("Bloquear");
        jlBloquear.setOpaque(true);
        jlBloquear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlBloquearMouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Login");
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));

        label3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(102, 102, 102));
        label3.setText("-Funcion 3");
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });

        label2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(102, 102, 102));
        label2.setText("-Función2");
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });

        lListarUsuarios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lListarUsuarios.setForeground(new java.awt.Color(102, 102, 102));
        lListarUsuarios.setText("-Listar Usuarios");
        lListarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lListarUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lListarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 520));

        contenedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));
        contenedor.setLayout(new java.awt.BorderLayout());
        getContentPane().add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 770, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x = evt.getX();

        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {//1
            setExtendedState(MAXIMIZED_BOTH);//2
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        cambioVisualizacion();
        visualizacionActual("otraFuncion1");
    }//GEN-LAST:event_label2MouseClicked

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
        cambioVisualizacion();
        visualizacionActual("otraFuncion2");
    }//GEN-LAST:event_label3MouseClicked

    private void lListarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lListarUsuariosMouseClicked
        cambioVisualizacion();
        visualizacionActual("listarUsuarios");
    }//GEN-LAST:event_lListarUsuariosMouseClicked

    private void lCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCerrarSesionMouseClicked
        new IngresoUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lCerrarSesionMouseClicked

    private void jlBloquearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlBloquearMouseClicked
        new SesionBloqueada( idUsuario ).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jlBloquearMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel contenedor;
    public javax.swing.JLabel lListarUsuarios;
    public javax.swing.JLabel label2;
    public javax.swing.JLabel label3;
    // End of variables declaration//GEN-END:variables
}
