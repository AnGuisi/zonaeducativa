/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.toedter.calendar.JDateChooser;
import controllers.controllerRegistrarCargo;
import controllers.controllerRegistrarHojaServicio;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewRegistrarHojaServicio extends javax.swing.JDialog {
    private OSValidator validarOS;
    int cedula;

    /**
     * Creates new form viewRegistrarCargo
     */
    public viewRegistrarHojaServicio(viewConsultarDatosPersonal viewConsultar, viewFichaPersonal ficha,java.awt.Dialog parent, boolean modal, ModalityType modalityType) {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        initComponents();
        this.setTitle("Registrar Cargo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        inicializarEventos(viewConsultar,ficha);
                                                                                                                                }
    
    public void inicializarEventos(viewConsultarDatosPersonal viewConsultar, viewFichaPersonal ficha) {
    controllerRegistrarHojaServicio controller = new controllerRegistrarHojaServicio(this);
    controller.setViewFicha(ficha);
    controller.setViewConsultarDatosPersonal(viewConsultar);
    btnRegistrarHojaServicio.addActionListener(controller);
                                                            }

    public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public JButton getBtnRegistrarHojaServicio() {
        return btnRegistrarHojaServicio;
    }

    public String getTxtCedula() {
        return txtCedula.getText();
    }

    public void setTxtCodigoPlantel(String CodigoPlantel) {
        txtCodigoPlantel.setText(CodigoPlantel);
    }

    public String getTxtPlantel() {
        return txtPlantel.getText();
    }

    public void setTxtNombrePlantel(String NombrePlantel) {
        txtPlantel.setText(NombrePlantel);
    }

    public void setTxtCodigoCargo(String CodigoCargo) {
        txtCodigoCargo.setText(CodigoCargo);
    }

    public String getTxtCargo() {
        return txtCargo.getText();
    }

    public void setTxtDenominacionCargo(String DenominacionCargo) {
        txtCargo.setText(DenominacionCargo);
    }

    public String getTxtSueldo() {
        return txtSueldo.getText();
    }


    public Date getTxtFechaIngreso() {
        return txtFechaIngreso.getDate();
    }

    public String getTxtCausaRetiro() {
        return txtCausaRetiro.getText();
    }

    public String getTxtLugar() {
        return txtLugar.getText();
    }

    public String getTxtPrima() {
        return txtPrima.getText();
    }

    public int getCedula() {
        return cedula;
    }

    public Date getTxtFechaTermino() {
        return txtFechaTermino.getDate();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrarHojaServicio = new javax.swing.JButton();
        btnRestablecerCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtFechaTermino = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtPlantel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoPlantel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCodigoCargo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCausaRetiro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrima = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        btnSeleccionarPlantel = new javax.swing.JButton();
        btnAgregarEmpresa4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btnRegistrarHojaServicio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRegistrarHojaServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnRegistrarHojaServicio.setText("Registrar Servicio");
        btnRegistrarHojaServicio.setToolTipText("Buscar Evaluación Técnica");
        btnRegistrarHojaServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRegistrarHojaServicio.setContentAreaFilled(false);
        btnRegistrarHojaServicio.setFocusable(false);
        btnRegistrarHojaServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarHojaServicio.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnRegistrarHojaServicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnRegistrarHojaServicio.setVerifyInputWhenFocusTarget(false);
        btnRegistrarHojaServicio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarHojaServicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarHojaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarHojaServicioActionPerformed(evt);
            }
        });

        btnRestablecerCampos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRestablecerCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/reestablecer_p.png"))); // NOI18N
        btnRestablecerCampos.setText("Restablecer Campos");
        btnRestablecerCampos.setToolTipText("Buscar Evaluación Técnica");
        btnRestablecerCampos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRestablecerCampos.setContentAreaFilled(false);
        btnRestablecerCampos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRestablecerCampos.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnRestablecerCampos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/reestablecer_g.png"))); // NOI18N
        btnRestablecerCampos.setVerifyInputWhenFocusTarget(false);
        btnRestablecerCampos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRestablecerCampos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRestablecerCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerCamposActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/header_opt.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Cargo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(11, 2, 0, 10));

        jLabel15.setText("Cédula:");
        jPanel4.add(jLabel15);

        txtCedula.setEditable(false);
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel4.add(txtCedula);

        jLabel4.setText("Fecha de Ingreso:");
        jPanel4.add(jLabel4);

        txtFechaIngreso.setPreferredSize(new java.awt.Dimension(93, 20));
        txtFechaIngreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaIngresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaIngresoFocusLost(evt);
            }
        });
        jPanel4.add(txtFechaIngreso);

        jLabel12.setText("Fecha de Término de Servicio:");
        jPanel4.add(jLabel12);

        txtFechaTermino.setPreferredSize(new java.awt.Dimension(93, 20));
        txtFechaTermino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaTerminoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaTerminoFocusLost(evt);
            }
        });
        jPanel4.add(txtFechaTermino);

        jLabel6.setText("Plantel o Dependencia:");
        jPanel4.add(jLabel6);
        jPanel4.add(txtPlantel);

        jLabel5.setText("Código Dependencia:");
        jPanel4.add(jLabel5);
        jPanel4.add(txtCodigoPlantel);

        jLabel7.setText("Denominación de Cargo:");
        jPanel4.add(jLabel7);
        jPanel4.add(txtCargo);

        jLabel16.setText("Código de Cargo:");
        jPanel4.add(jLabel16);
        jPanel4.add(txtCodigoCargo);

        jLabel8.setText("Lugar:");
        jPanel4.add(jLabel8);

        txtLugar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLugarFocusLost(evt);
            }
        });
        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLugarKeyTyped(evt);
            }
        });
        jPanel4.add(txtLugar);

        jLabel9.setText("Causa de Retiro:");
        jPanel4.add(jLabel9);

        txtCausaRetiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCausaRetiroFocusLost(evt);
            }
        });
        txtCausaRetiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCausaRetiroKeyTyped(evt);
            }
        });
        jPanel4.add(txtCausaRetiro);

        jLabel10.setText("Prima:");
        jPanel4.add(jLabel10);

        txtPrima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrimaFocusLost(evt);
            }
        });
        txtPrima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimaKeyTyped(evt);
            }
        });
        jPanel4.add(txtPrima);

        jLabel11.setText("Sueldo:");
        jPanel4.add(jLabel11);

        txtSueldo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSueldoFocusLost(evt);
            }
        });
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });
        jPanel4.add(txtSueldo);

        btnSeleccionarPlantel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSeleccionarPlantel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_p.png"))); // NOI18N
        btnSeleccionarPlantel.setText("<html><center>Seleccionar<br>Dependencia</center></html>");
        btnSeleccionarPlantel.setToolTipText("Seleccionar");
        btnSeleccionarPlantel.setAlignmentY(0.0F);
        btnSeleccionarPlantel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSeleccionarPlantel.setContentAreaFilled(false);
        btnSeleccionarPlantel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeleccionarPlantel.setIconTextGap(0);
        btnSeleccionarPlantel.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnSeleccionarPlantel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_g.png"))); // NOI18N
        btnSeleccionarPlantel.setVerifyInputWhenFocusTarget(false);
        btnSeleccionarPlantel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSeleccionarPlantel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPlantelActionPerformed(evt);
            }
        });

        btnAgregarEmpresa4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarEmpresa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionarCargo_p.png"))); // NOI18N
        btnAgregarEmpresa4.setText("<html><center>Seleccionar<br>Cargo</center></html>");
        btnAgregarEmpresa4.setToolTipText("Seleccionar");
        btnAgregarEmpresa4.setAlignmentY(0.0F);
        btnAgregarEmpresa4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarEmpresa4.setContentAreaFilled(false);
        btnAgregarEmpresa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarEmpresa4.setIconTextGap(0);
        btnAgregarEmpresa4.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnAgregarEmpresa4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionarCargo_g.png"))); // NOI18N
        btnAgregarEmpresa4.setVerifyInputWhenFocusTarget(false);
        btnAgregarEmpresa4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarEmpresa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpresa4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSeleccionarPlantel)
                                .addComponent(btnAgregarEmpresa4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnRegistrarHojaServicio)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestablecerCampos)))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarEmpresa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarHojaServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRestablecerCampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarHojaServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHojaServicioActionPerformed

    }//GEN-LAST:event_btnRegistrarHojaServicioActionPerformed

    private void btnRestablecerCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerCamposActionPerformed
       // RestablecerCampos();
    }//GEN-LAST:event_btnRestablecerCamposActionPerformed

    private void txtLugarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLugarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarFocusLost

    private void txtLugarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarKeyTyped

    private void txtCausaRetiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCausaRetiroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCausaRetiroFocusLost

    private void txtCausaRetiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCausaRetiroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCausaRetiroKeyTyped

    private void txtPrimaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrimaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimaFocusLost

    private void txtPrimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimaKeyTyped

    private void txtSueldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSueldoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoFocusLost

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtSueldoKeyTyped

    private void btnSeleccionarPlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPlantelActionPerformed
     new viewCatalagoPlanteles(null,this,null,null,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);  
    }//GEN-LAST:event_btnSeleccionarPlantelActionPerformed

    private void btnAgregarEmpresa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa4ActionPerformed
        try {
            new viewSeleccionarCargo(null,this,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(viewRegistrarHojaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_btnAgregarEmpresa4ActionPerformed

    private void txtFechaIngresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaIngresoFocusGained

    }//GEN-LAST:event_txtFechaIngresoFocusGained

    private void txtFechaIngresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaIngresoFocusLost

    }//GEN-LAST:event_txtFechaIngresoFocusLost

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtFechaTerminoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaTerminoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaTerminoFocusGained

    private void txtFechaTerminoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaTerminoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaTerminoFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(viewRegistrarHojaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarHojaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarHojaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarHojaServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewRegistrarHojaServicio(null,null,new javax.swing.JDialog(), true, Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEmpresa4;
    private javax.swing.JButton btnRegistrarHojaServicio;
    private javax.swing.JButton btnRestablecerCampos;
    private javax.swing.JButton btnSeleccionarPlantel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel txtCargo;
    private javax.swing.JTextField txtCausaRetiro;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JLabel txtCodigoCargo;
    private javax.swing.JLabel txtCodigoPlantel;
    private com.toedter.calendar.JDateChooser txtFechaIngreso;
    private com.toedter.calendar.JDateChooser txtFechaTermino;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JLabel txtPlantel;
    private javax.swing.JTextField txtPrima;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
