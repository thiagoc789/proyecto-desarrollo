package FrontEnd;

import BackEnd.Usuarios;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SesionBloqueada extends javax.swing.JFrame {

    private int x;
    private int y;
    
    String idUsuario;

//    public SesionBloqueada() {
//        initComponents();
//    }
    
    public SesionBloqueada(String idUsuario) {
        initComponents();
        jtfCedula.setText(idUsuario);
        this.idUsuario = idUsuario;
    }
    
    public boolean validador(){
        boolean validacion = true;
        String respuesta = "Por favor verifique:";

        if( jtfClave.getText().length()<1 ){
            respuesta = respuesta + "\n   - Debe ingresar una contraseña";
            validacion = false;
        }
        if( jtfCedula.getText().length()<1 || !(jtfCedula.getText().matches("[+-]?\\d*(\\.\\d+)?")) ){
            respuesta = respuesta + "\n   - Cédula ingresada, deben ser solo números";
            jtfCedula.setText("");
            validacion = false;
        }
        
        if( !validacion )
            JOptionPane.showMessageDialog(null, respuesta);
        
        return validacion;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        lCancelar = new javax.swing.JLabel();
        lEntrar = new javax.swing.JLabel();
        jtfCedula = new javax.swing.JFormattedTextField();
        jtfClave = new javax.swing.JPasswordField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        lEntrar1 = new javax.swing.JLabel();

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

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sesión bloqueada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
                .addGap(151, 151, 151)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(253, 253, 253))
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
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Por favor ingrese su su contraseña");

        lCancelar.setBackground(new java.awt.Color(0, 153, 102));
        lCancelar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lCancelar.setForeground(new java.awt.Color(255, 255, 255));
        lCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCancelar.setText("CANCELAR");
        lCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lCancelar.setOpaque(true);
        lCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lCancelarMouseExited(evt);
            }
        });

        lEntrar.setBackground(new java.awt.Color(0, 153, 102));
        lEntrar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lEntrar.setForeground(new java.awt.Color(255, 255, 255));
        lEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lEntrar.setText("ENTRAR");
        lEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lEntrar.setOpaque(true);
        lEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lEntrarMouseExited(evt);
            }
        });

        jtfCedula.setForeground(new java.awt.Color(153, 153, 153));
        jtfCedula.setEnabled(false);
        jtfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCedulaActionPerformed(evt);
            }
        });

        jtfClave.setForeground(new java.awt.Color(153, 153, 153));
        jtfClave.setHighlighter(null);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("para desbloquear la sesión");

        jLabel1.setText("Cédula");

        jLabel4.setText("Clave");

        lEntrar1.setBackground(new java.awt.Color(0, 153, 102));
        lEntrar1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lEntrar1.setForeground(new java.awt.Color(255, 255, 255));
        lEntrar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lEntrar1.setText("CERRAR SESIÓN");
        lEntrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lEntrar1.setOpaque(true);
        lEntrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEntrar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lEntrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lEntrar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfClave, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(266, 266, 266))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(lCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(lEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfClave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 44, 820, 660));

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

    private void jtfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCedulaActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {//1
            setExtendedState(MAXIMIZED_BOTH);//2
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void lEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEntrarMouseClicked
        Usuarios unUsuario = new Usuarios();
        String usuariValido = "";
        try {
            if( validador() )
                usuariValido = unUsuario.validarIngreso(idUsuario, jtfClave.getText());
        } catch (SQLException ex) {
            Logger.getLogger(SesionBloqueada.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( usuariValido.compareTo("Gerente") == 0 ){
            new PantallaGerente( idUsuario ).setVisible(true);
            this.setVisible(false);
        }else if( usuariValido.compareTo("Operador") == 0 ){
            new PantallaOperador().setVisible(true);
            this.setVisible(false);
        }else if( usuariValido.compareTo("Secretaria") == 0 ){
            new PantallaSecretaria().setVisible(true);
            this.setVisible(false);
        }else if( usuariValido.compareTo("Auxiliar") == 0 ){
            new PantallaAuxiliar().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_lEntrarMouseClicked

    private void lCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCancelarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lCancelarMouseClicked

    private void lEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEntrarMouseEntered
        // TODO add your handling code here:
        lEntrar.setForeground(Color.red);


    }//GEN-LAST:event_lEntrarMouseEntered

    private void lEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEntrarMouseExited
        // TODO add your handling code here:
        lEntrar.setForeground(Color.white);
    }//GEN-LAST:event_lEntrarMouseExited

    private void lCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCancelarMouseEntered
        // TODO add your handling code here:
        lCancelar.setForeground(Color.red);
    }//GEN-LAST:event_lCancelarMouseEntered

    private void lCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCancelarMouseExited
        // TODO add your handling code here:
        lCancelar.setForeground(Color.white);
    }//GEN-LAST:event_lCancelarMouseExited

    private void lEntrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEntrar1MouseClicked
        new IngresoUsuario().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lEntrar1MouseClicked

    private void lEntrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEntrar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lEntrar1MouseEntered

    private void lEntrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEntrar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lEntrar1MouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JFormattedTextField jtfCedula;
    javax.swing.JPasswordField jtfClave;
    javax.swing.JLabel lCancelar;
    javax.swing.JLabel lEntrar;
    javax.swing.JLabel lEntrar1;
    // End of variables declaration//GEN-END:variables
}
