/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.Operador;

import BackEnd.Clientes;
import BackEnd.ConexionBD;
import BackEnd.Envios;
import FrontEnd.PantallaGerente;
import BackEnd.Sedes;
import BackEnd.Tarjetas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class RegistrarEnvio extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarSede
     */
    int valorSuma = 0;
    int valorPaqueteSuma = 0;
    int valorImpuestoSuma = 0;
    int valorSeguroSuma = 0;
    int conteoPaquetes = 0;
    int id_envio = 0;
    
    int costoTotal = 0;
    
    private String cedula_cliente = "";
    private String nombre_cliente = "";
    private String direccion_cliente = "";
    private String comuna_cliente = "";
    private String descripcion_paquete = "";
    private String sedeAsignadaCliente = "";
    
    Clientes cliente = new Clientes();

    public RegistrarEnvio() {
        initComponents();
        panelTarjeta.setVisible(false);

    }

    public boolean validador(String opcionValidacion) {
        boolean validacion = true;
        String respuesta = "Por favor verifique:";

        //JOptionPane.showMessageDialog(null, "_" + jcbSede.getItemAt(jcbSede.getSelectedIndex()) + "_");
        
        if( opcionValidacion.compareTo("paquete") == 0 ){
            if (jtfCedula.getText().length() < 1 || !(jtfCedula.getText().matches("[+-]?\\d*(\\.\\d+)?"))) {
                respuesta = respuesta + "\n   - Verificar la cédula";
                jtfCedula.setText("");
                validacion = false;
            }
            if (jtfValorEnvio.getText().length() < 1 || !(jtfValorEnvio.getText().matches("[+-]?\\d*(\\.\\d+)?"))) {
                respuesta = respuesta + "\n   - Verificar el valor del envío";
                jtfValorEnvio.setText("");
                validacion = false;
            }
            if (jtfValorPaquete.getText().length() < 1 || !(jtfValorPaquete.getText().matches("[+-]?\\d*(\\.\\d+)?"))) {
                respuesta = respuesta + "\n   - Verificar el valor del paquete";
                jtfValorPaquete.setText("");
                validacion = false;
            }
            if (jtfValorImpuesto.getText().length() < 1 || !(jtfValorImpuesto.getText().matches("[+-]?\\d*(\\.\\d+)?"))) {
                respuesta = respuesta + "\n   - Verificar el valor del impuesto";
                jtfValorImpuesto.setText("");
                validacion = false;
            }
            if (jtfValorSeguro.getText().length()>0 && !(jtfValorSeguro.getText().matches("[+-]?\\d*(\\.\\d+)?"))) {
                respuesta = respuesta + "\n   - Verificar el valor del seguro";
                jtfValorSeguro.setText("");
                validacion = false;
            }
            if ( jtfDescripcion.getText().length()<1 ) {
                respuesta = respuesta + "\n   - Debe ingresar una breve descripción";
                validacion = false;
            }
        }
        if( opcionValidacion.compareTo("registro") == 0 ){
            if (metodoDePago.getSelectedIndex()>0 ) {
                if( jtfTarjeta.getText().length() < 1 || !(jtfTarjeta.getText().matches("[+-]?\\d*(\\.\\d+)?")) ){
                    respuesta = respuesta + "\n   - Verificar el número de tarjeta";
                    jtfTarjeta.setText("");
                    validacion = false;
                }else{
                    Tarjetas unaTarjeta = new Tarjetas();

                    if( unaTarjeta.tarjetaExiste( jtfTarjeta.getText() ) ){
                        if( !unaTarjeta.descontarDeTarjeta(jtfTarjeta.getText(), costoTotal) ){
                            validacion = false;
                        }
                    }
                    else{
                        respuesta = respuesta + "\n   - La tarjeta no existe";
                        validacion = false;
                    }
                }
            }
        }
        
        if (!validacion) {
            JOptionPane.showMessageDialog(null, respuesta);
        }
        return validacion;
    }
    
    
    
    public void cargarDatosCliente(){
        //JOptionPane.showMessageDialog(null, "método agregarUnPaquete()");
        //Clientes cliente = new Clientes();
        try {
            //JOptionPane.showMessageDialog(null, "método agregarUnPaquete() dentro del try");
                cliente.traerDatosCliente(jtfCedula.getText());

                cedula_cliente = cliente.getCedula_cliente();
                nombre_cliente = cliente.getNombre_cliente();
                direccion_cliente = cliente.getDireccion_cliente();
                comuna_cliente = cliente.getComuna_cliente();
                sedeAsignadaCliente = cliente.getSede_asignada();

                labelCedula.setText(cedula_cliente);
                labelNombre.setText(nombre_cliente);
                labelDireccion.setText(direccion_cliente);
                labelSedeAsignada.setText("Sede asignada: " + sedeAsignadaCliente);
                labelComuna.setText("Comuna " + comuna_cliente);

                jtfCedula.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarEnvio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reiniciarVariables(){
        jtfCedula.setEnabled(true);
        jtfCedula.setText("");
        
        valorSuma = 0;
        valorPaqueteSuma = 0;
        valorImpuestoSuma = 0;
        valorSeguroSuma = 0;
        conteoPaquetes = 0;
        id_envio = 0;
        cedula_cliente = "";
        nombre_cliente = "";
        direccion_cliente = "";
        comuna_cliente = "";
        descripcion_paquete = "";
        sedeAsignadaCliente = "";
        
        labelCedula.setText("Cédula");
        labelNombre.setText("Nombre");
        labelDireccion.setText("Dirección");
        labelSedeAsignada.setText("Sede asignada");
        labelComuna.setText("Comuna");
        metodoPagoResumen.setText("Efectivo");

        totalResumen.setText("0");
        numeroPaquetesResumen.setText("0");
        valorSeguroResumen.setText("0");
        valorImpuestoResumen.setText("0");
        valorPaqueteResumen.setText("0");
        valorEnvioResumen.setText("0");
        
        metodoDePago.setSelectedIndex(0);
        
        costoTotal = 0;
    }
    
    public void agregarUnPaquete(){
        //JOptionPane.showMessageDialog(null, "metodo agregarUnPaquete()");
        //Metodo De Pago
            conteoPaquetes++;
            numeroPaquetesResumen.setText(Integer.toString(conteoPaquetes));
            int auxiliar = metodoDePago.getSelectedIndex();
            String auxiliar2 = metodoDePago.getItemAt(auxiliar);
            metodoPagoResumen.setText(auxiliar2);

            //Valor Del Envio
            int valorInicialEnvio = Integer.parseInt(jtfValorEnvio.getText());
            valorSuma = valorSuma + valorInicialEnvio;
            valorEnvioResumen.setText(Integer.toString(valorSuma));

            //Valor Paquete
            int auxiliarPaquete = Integer.parseInt(jtfValorPaquete.getText());
            valorPaqueteSuma = valorPaqueteSuma + auxiliarPaquete;
            valorPaqueteResumen.setText(Integer.toString(valorPaqueteSuma));

            //Valor Impuesto
            int auxiliarImpuesto = Integer.parseInt(jtfValorImpuesto.getText());
            valorImpuestoSuma = valorImpuestoSuma + auxiliarImpuesto;
            valorImpuestoResumen.setText(Integer.toString(valorImpuestoSuma));

            //Valor Seguro
            int auxiliarSeguro = 0;
            if(jtfValorSeguro.getText().length() >0)
                auxiliarSeguro = Integer.parseInt(jtfValorSeguro.getText());
            valorSeguroSuma = valorSeguroSuma + auxiliarSeguro;
            valorSeguroResumen.setText(Integer.toString(valorSeguroSuma));

            //Total
            int auxiliarTotal = valorSuma + valorPaqueteSuma + valorImpuestoSuma + valorSeguroSuma;
            totalResumen.setText(Integer.toString(auxiliarTotal));
            costoTotal = auxiliarTotal;
        
            descripcion_paquete = descripcion_paquete + "\n  -  " + jtfDescripcion.getText();
            
            jtfValorEnvio.setText("");
            jtfValorPaquete.setText("");
            jtfValorImpuesto.setText("");
            jtfValorSeguro.setText("");
            jtfDescripcion.setText("");
    }

    public void generarRecibo(){
        //GENERAR RECIBO
        int auxiliar = campoRecibo.getSelectedIndex();
        String recibo = campoRecibo.getItemAt(auxiliar);

        if (recibo.equals("Si")) {

            Document documento = new Document();

            String rutaCompleta = "";

            try {
                String ruta = System.getProperty("user.home");
                //JOptionPane.showMessageDialog(null, "Ruta: " + ruta);
                try {
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Recibo_"+id_envio+".pdf"));
                    rutaCompleta = ruta + "/Desktop/Recibo_"+id_envio+".pdf";
                } catch (DocumentException | FileNotFoundException ex1) {
                    try {
                        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Escritorio/Recibo_"+id_envio+".pdf"));
                        rutaCompleta = ruta + "/Escritorio/Recibo_"+id_envio+".pdf";
                    } catch (DocumentException | FileNotFoundException ex2) {
                        try {
                            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Recibo_"+id_envio+".pdf"));
                            rutaCompleta = ruta + "/Recibo_" + id_envio+".pdf";
                        } catch (DocumentException | FileNotFoundException ex3) {
                        }
                    }
                }

                //PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Reporte_Prueba.pdf"));
                documento.open();

                Paragraph titulo = new Paragraph("Recibo Envio # " + id_envio + "\n\n", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.RED));
                Paragraph total = new Paragraph("Total A Pagar: $" + totalResumen.getText() + "\n\n\n", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.GREEN));
                Paragraph titulo2 = new Paragraph("Datos Del Cliente\n", FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));

                String texto = "Cedula: " + cedula_cliente + "\n"
                        + "Nombre: " + nombre_cliente + "\n"
                        + "Direccion: " + direccion_cliente + "\n"
                        + "Comuna: " + comuna_cliente + "\n";
                Paragraph parrafo = new Paragraph(texto, FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.GRAY));

                Paragraph titulo3 = new Paragraph("Datos Del Envio\n", FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));

                String texto2 = "Metodo De Pago: " + metodoPagoResumen.getText() + "\n"
                        + "Valor Envios: $" + valorEnvioResumen.getText() + "\n"
                        + "Valor Paquetes: $" + valorPaqueteResumen.getText() + "\n"
                        + "Valor Impuestos: $" + valorImpuestoResumen.getText() + "\n"
                        + "Valor Seguros: $" + valorSeguroResumen.getText() + "\n"
                        + "Numero De Paquetes: " + numeroPaquetesResumen.getText() + "\n"
                        + "Descripción de los paquetes (aportada por el cliente):" + descripcion_paquete + "\n";
                
                        //descripcion_paquete
                Paragraph parrafo2 = new Paragraph(texto2, FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.GRAY));
                Paragraph parrafo3 = new Paragraph("Empresa De Servicios Flash", FontFactory.getFont("Segoe Script", 12, Font.BOLD, BaseColor.LIGHT_GRAY));

                documento.add(titulo);
                documento.add(titulo2);
                documento.add(parrafo);
                documento.add(titulo3);
                documento.add(parrafo2);
                documento.add(total);
                documento.add(parrafo3);

                documento.close();
                JOptionPane.showMessageDialog(null, "Recibo #" + id_envio + " creado. Se guardó en:\n" + rutaCompleta);
            } catch (HeadlessException ex) {
                //JOptionPane.showMessageDialog(null, "Aquí 2");
            } catch (DocumentException ex) {
                Logger.getLogger(RegistrarEnvio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEnvio = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Registrar = new javax.swing.JLabel();
        Cancelar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtfValorEnvio = new javax.swing.JTextField();
        jtfValorImpuesto = new javax.swing.JTextField();
        jtfValorPaquete = new javax.swing.JTextField();
        jtfValorSeguro = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jtfDescripcion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        metodoPagoResumen = new javax.swing.JLabel();
        valorEnvioResumen = new javax.swing.JLabel();
        valorPaqueteResumen = new javax.swing.JLabel();
        valorImpuestoResumen = new javax.swing.JLabel();
        valorSeguroResumen = new javax.swing.JLabel();
        numeroPaquetesResumen = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        totalResumen = new javax.swing.JLabel();
        labelCedula = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelComuna = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelSedeAsignada = new javax.swing.JLabel();
        botonAgregarPaquete = new javax.swing.JButton();
        metodoDePago = new javax.swing.JComboBox<>();
        campoRecibo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jtfCedula = new javax.swing.JTextField();
        panelTarjeta = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jtfTarjeta = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(770, 520));

        jpEnvio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, null, null));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Generar Recibo");

        Registrar.setBackground(new java.awt.Color(0, 153, 102));
        Registrar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Registrar.setForeground(new java.awt.Color(255, 255, 255));
        Registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Registrar.setText("Registrar");
        Registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Registrar.setEnabled(false);
        Registrar.setOpaque(true);
        Registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarMouseExited(evt);
            }
        });

        Cancelar.setBackground(new java.awt.Color(0, 153, 102));
        Cancelar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cancelar.setText("Cancelar");
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cancelar.setOpaque(true);
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelarMouseExited(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("Valor Envio");

        jLabel14.setText("Valor Impuesto");

        jLabel16.setText("Valor Paquete");

        jLabel18.setText("Valor Seguro");

        jtfValorEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfValorEnvioActionPerformed(evt);
            }
        });

        jLabel28.setText("Breve descripción");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfValorEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfValorImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jtfValorSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfValorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jtfValorEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfValorPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtfValorImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jtfValorSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Resumen:");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setText("Metodo De Pago:");

        jLabel21.setText("Valor Envios:");

        jLabel22.setText("Valor Paquetes:");

        jLabel23.setText("Valor Impuestos:");

        jLabel24.setText("Valor Seguros:");

        jLabel25.setText("Numero De Paquetes:");

        metodoPagoResumen.setText("Efectivo");

        valorEnvioResumen.setText("0");

        valorPaqueteResumen.setText("0");

        valorImpuestoResumen.setText("0");

        valorSeguroResumen.setText("0");

        numeroPaquetesResumen.setText("0");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("TOTAL: ");

        totalResumen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalResumen.setText("0");

        labelCedula.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelCedula.setText("Cédula");

        labelNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelNombre.setText("Nombre");

        labelComuna.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelComuna.setText("Comuna");

        labelDireccion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelDireccion.setText("Dirección");

        labelSedeAsignada.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        labelSedeAsignada.setText("Sede asignada");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSedeAsignada, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(valorImpuestoResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(valorSeguroResumen, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(valorPaqueteResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valorEnvioResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(numeroPaquetesResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metodoPagoResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSedeAsignada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(metodoPagoResumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(valorEnvioResumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(valorPaqueteResumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorImpuestoResumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorSeguroResumen)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(numeroPaquetesResumen))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalResumen)
                            .addComponent(jLabel26))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAgregarPaquete.setBackground(new java.awt.Color(102, 102, 102));
        botonAgregarPaquete.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botonAgregarPaquete.setText("Agregar Paquete");
        botonAgregarPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgregarPaqueteMouseClicked(evt);
            }
        });
        botonAgregarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPaqueteActionPerformed(evt);
            }
        });

        metodoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta De Credito", "Tarjeta Debito" }));
        metodoDePago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                metodoDePagoItemStateChanged(evt);
            }
        });

        campoRecibo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Cedula Del Cliente");

        jtfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCedulaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Numero De Tarjeta");

        jtfTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTarjetaLayout = new javax.swing.GroupLayout(panelTarjeta);
        panelTarjeta.setLayout(panelTarjetaLayout);
        panelTarjetaLayout.setHorizontalGroup(
            panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarjetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelTarjetaLayout.setVerticalGroup(
            panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jtfTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Metodo De Pago");

        javax.swing.GroupLayout jpEnvioLayout = new javax.swing.GroupLayout(jpEnvio);
        jpEnvio.setLayout(jpEnvioLayout);
        jpEnvioLayout.setHorizontalGroup(
            jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnvioLayout.createSequentialGroup()
                .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnvioLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEnvioLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpEnvioLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(metodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnvioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEnvioLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnvioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(botonAgregarPaquete))
                            .addGroup(jpEnvioLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jpEnvioLayout.setVerticalGroup(
            jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnvioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnvioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(metodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpEnvioLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(botonAgregarPaquete)))
                .addGap(12, 12, 12)
                .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        // TODO add your handling code here:
        //new PantallaGeneralGerente().setVisible(true);
        //this.setVisible(false);
    }//GEN-LAST:event_CancelarMouseClicked

    private void CancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseEntered
        // TODO add your handling code here:
        Cancelar.setForeground(Color.red);
    }//GEN-LAST:event_CancelarMouseEntered

    private void CancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseExited
        // TODO add your handling code here:
        Cancelar.setForeground(Color.white);
    }//GEN-LAST:event_CancelarMouseExited

    private void jtfValorEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfValorEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorEnvioActionPerformed

    private void botonAgregarPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarPaqueteMouseClicked

        if( validador("paquete") ){
            if( cliente.cedulaExiste( jtfCedula.getText() ) ){
                //JOptionPane.showMessageDialog(null, "Cliente si existe");
                if( cedula_cliente.length() == 0 )
                    cargarDatosCliente();
            
                agregarUnPaquete();
                Registrar.setEnabled(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Cédula no existe en la base de clientes");
        }
    }//GEN-LAST:event_botonAgregarPaqueteMouseClicked

    private void botonAgregarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPaqueteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgregarPaqueteActionPerformed

    private void RegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarMouseExited
        // TODO add your handling code here:
        Registrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_RegistrarMouseExited

    private void RegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarMouseEntered
        // TODO add your handling code here:
        Registrar.setForeground(Color.red);
    }//GEN-LAST:event_RegistrarMouseEntered

    private void RegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarMouseClicked
        // TODO add your handling code here:
        // AQUI SE REGISTRA EL ENVIO
        
        try {
            if (validador("registro") && conteoPaquetes>0 ) {
                Envios envio = new Envios();
                
                envio.registrarEnvio(Integer.parseInt(cedula_cliente), metodoPagoResumen.getText(), valorSuma, valorPaqueteSuma, valorImpuestoSuma, valorSeguroSuma, conteoPaquetes);
                id_envio = Integer.parseInt( envio.envioRecienteRegistrado() );
                JOptionPane.showMessageDialog(null, "Envio #  " +id_envio+ " registrado exitosamente", "Sistematizacion De Procesos - Flash", JOptionPane.INFORMATION_MESSAGE);
                
                generarRecibo();
                reiniciarVariables();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarEnvio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RegistrarMouseClicked

    private void jtfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCedulaActionPerformed

    private void metodoDePagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_metodoDePagoItemStateChanged

        int auxiliar = metodoDePago.getSelectedIndex();
        String auxiliar2 = metodoDePago.getItemAt(auxiliar);
        if (auxiliar2.equals("Efectivo")) {
            jtfTarjeta.setText("");
            panelTarjeta.setVisible(false);
        } else {
            panelTarjeta.setVisible(true);
        }

    }//GEN-LAST:event_metodoDePagoItemStateChanged

    private void jtfTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTarjetaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel Cancelar;
    javax.swing.JLabel Registrar;
    javax.swing.JButton botonAgregarPaquete;
    private javax.swing.JComboBox<String> campoRecibo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jpEnvio;
    javax.swing.JTextField jtfCedula;
    javax.swing.JTextField jtfDescripcion;
    javax.swing.JTextField jtfTarjeta;
    javax.swing.JTextField jtfValorEnvio;
    javax.swing.JTextField jtfValorImpuesto;
    javax.swing.JTextField jtfValorPaquete;
    javax.swing.JTextField jtfValorSeguro;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelComuna;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSedeAsignada;
    javax.swing.JComboBox<String> metodoDePago;
    javax.swing.JLabel metodoPagoResumen;
    javax.swing.JLabel numeroPaquetesResumen;
    private javax.swing.JPanel panelTarjeta;
    javax.swing.JLabel totalResumen;
    javax.swing.JLabel valorEnvioResumen;
    javax.swing.JLabel valorImpuestoResumen;
    javax.swing.JLabel valorPaqueteResumen;
    javax.swing.JLabel valorSeguroResumen;
    // End of variables declaration//GEN-END:variables
}
