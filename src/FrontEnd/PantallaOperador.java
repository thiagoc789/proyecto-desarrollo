package FrontEnd;

import FrontEnd.Administrativo.*;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

public class PantallaGerente extends javax.swing.JFrame {

    private int x;
    private int y;
    
    ListarUsuarios listaUsuarios = new ListarUsuarios();
    RegistrarSede nuevaSede = new RegistrarSede();
    ModificarSede actualizarSede = new ModificarSede();
    RegistrarUsuario nuevoUsuario = new RegistrarUsuario();
    ModificarUsuario modificarUsuario = new ModificarUsuario();
    EstadoUsuario estadoUsuario = new EstadoUsuario();

    public PantallaGerente() {
        initComponents();
        
        contenedor.setVisible(false);

    }
    
    public void cambioVisualizacion(){
        lInactivarUsuario.setEnabled(true);
        lListarUsuarios.setEnabled(true);
        lModificarSede.setEnabled(true);
        lModificarUsuario.setEnabled(true);
        lRegistrarSede.setEnabled(true);
        lRegistrarUsuario.setEnabled(true);

        actualizarSede.setVisible(false);
        estadoUsuario.setVisible(false);
        listaUsuarios.setVisible(false);
        modificarUsuario.setVisible(false);
        nuevoUsuario.setVisible(false);
        nuevaSede.setVisible(false);
    }
    
    public void visualizacionActual(String panel){
        
        if(panel.compareTo("registrarSede") == 0){
            nuevaSede.setVisible(true);
            contenedor.add(nuevaSede);
            lRegistrarSede.setEnabled(false);
        }else if(panel.compareTo("listarUsuarios") == 0){
            listaUsuarios.setVisible(true);
            contenedor.add(listaUsuarios);
            lListarUsuarios.setEnabled(false);
        }else if(panel.compareTo("actualizarSede") == 0){
            actualizarSede.setVisible(true);
            contenedor.add(actualizarSede);
            lModificarSede.setEnabled(false);
        }else if(panel.compareTo("nuevoUsuario") == 0){
            nuevoUsuario.setVisible(true);
            contenedor.add(nuevoUsuario);
            lRegistrarUsuario.setEnabled(false);
        }else if(panel.compareTo("modificarUsuario") == 0){
            modificarUsuario.setVisible(true);
            contenedor.add(modificarUsuario);
            lModificarUsuario.setEnabled(false);
        }else if(panel.compareTo("estadoUsuario") == 0){
            estadoUsuario.setVisible(true);
            contenedor.add(estadoUsuario);
            lInactivarUsuario.setEnabled(false);
        }
        
        //estadoUsuario
        
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
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        lRegistrarUsuario = new javax.swing.JLabel();
        lRegistrarSede = new javax.swing.JLabel();
        lModificarUsuario = new javax.swing.JLabel();
        lModificarSede = new javax.swing.JLabel();
        lInactivarUsuario = new javax.swing.JLabel();
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
        jLabel12.setText("Pantalla General Gerente");

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

        jLabel4.setBackground(new java.awt.Color(0, 153, 102));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cerrar Sesión");
        jLabel4.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(0, 153, 102));
        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bloquear");
        jLabel6.setOpaque(true);

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
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 950, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));

        lRegistrarUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lRegistrarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lRegistrarUsuario.setText("-Registrar Usuario");
        lRegistrarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lRegistrarUsuarioMouseClicked(evt);
            }
        });

        lRegistrarSede.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lRegistrarSede.setForeground(new java.awt.Color(102, 102, 102));
        lRegistrarSede.setText("-Registrar Nueva Sede");
        lRegistrarSede.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lRegistrarSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lRegistrarSedeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lRegistrarSedeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lRegistrarSedeMouseExited(evt);
            }
        });

        lModificarUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lModificarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lModificarUsuario.setText("-Modificar Usuario");
        lModificarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModificarUsuarioMouseClicked(evt);
            }
        });

        lModificarSede.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lModificarSede.setForeground(new java.awt.Color(102, 102, 102));
        lModificarSede.setText("-Modificar Sede");
        lModificarSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModificarSedeMouseClicked(evt);
            }
        });

        lInactivarUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lInactivarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lInactivarUsuario.setText("-Inactivar Usuario");
        lInactivarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lInactivarUsuarioMouseClicked(evt);
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
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lRegistrarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lModificarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lListarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lModificarSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lInactivarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(lRegistrarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lModificarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lInactivarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lRegistrarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(455, Short.MAX_VALUE)))
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

    private void lRegistrarSedeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRegistrarSedeMouseClicked
        // TODO add your handling code here:
        cambioVisualizacion();
        visualizacionActual("registrarSede");
    }//GEN-LAST:event_lRegistrarSedeMouseClicked

    private void lRegistrarSedeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRegistrarSedeMouseEntered

    }//GEN-LAST:event_lRegistrarSedeMouseEntered

    private void lRegistrarSedeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRegistrarSedeMouseExited

    }//GEN-LAST:event_lRegistrarSedeMouseExited

    private void lListarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lListarUsuariosMouseClicked
        cambioVisualizacion();
        visualizacionActual("listarUsuarios");
    }//GEN-LAST:event_lListarUsuariosMouseClicked

    private void lModificarSedeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModificarSedeMouseClicked
        cambioVisualizacion();
        visualizacionActual("actualizarSede");
    }//GEN-LAST:event_lModificarSedeMouseClicked

    private void lRegistrarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lRegistrarUsuarioMouseClicked
        cambioVisualizacion();
        visualizacionActual("nuevoUsuario");
    }//GEN-LAST:event_lRegistrarUsuarioMouseClicked

    private void lModificarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModificarUsuarioMouseClicked
        cambioVisualizacion();
        visualizacionActual("modificarUsuario");
    }//GEN-LAST:event_lModificarUsuarioMouseClicked

    private void lInactivarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lInactivarUsuarioMouseClicked
        cambioVisualizacion();
        visualizacionActual("estadoUsuario");
    }//GEN-LAST:event_lInactivarUsuarioMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel contenedor;
    public javax.swing.JLabel lInactivarUsuario;
    public javax.swing.JLabel lListarUsuarios;
    public javax.swing.JLabel lModificarSede;
    public javax.swing.JLabel lModificarUsuario;
    public javax.swing.JLabel lRegistrarSede;
    public javax.swing.JLabel lRegistrarUsuario;
    // End of variables declaration//GEN-END:variables
}
