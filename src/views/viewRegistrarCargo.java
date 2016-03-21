/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.controllerRegistrarCargo;
import java.awt.Dialog;
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
public class viewRegistrarCargo extends javax.swing.JDialog {
    private OSValidator validarOS;
    int cedula;


    public viewRegistrarCargo(viewConsultarDatosPersonal viewConsulta, viewFichaPersonal ficha, java.awt.Dialog parent, boolean modal, ModalityType modalityType) {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        initComponents();
        this.setTitle("Registrar Cargo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        inicializarEventos(ficha,viewConsulta);
    }
    
    public void inicializarEventos(viewFichaPersonal ficha, viewConsultarDatosPersonal viewConsulta) {
    controllerRegistrarCargo controller = new controllerRegistrarCargo(this);
    controller.setViewConsulta(viewConsulta);
    controller.setViewFicha(ficha);
    btnRegistrarCargo.addActionListener(controller);
                                                            }

    public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public JButton getBtnRegistrarCargo() {
        return btnRegistrarCargo;
    }

    public String getTxtCedula() {
        return txtCedula.getText();
    }

    public String getTxtCodigoPlantel() {
        return txtCodigoPlantel.getText();
    }

    public void setTxtCodigoPlantel(String CodigoPlantel) {
        txtCodigoPlantel.setText(CodigoPlantel);
    }

    public String getTxtNombrePlantel() {
        return txtNombrePlantel.getText();
    }

    public void setTxtNombrePlantel(String NombrePlantel) {
        txtNombrePlantel.setText(NombrePlantel);
    }

    public String getTxtCodigoCargo() {
        return txtCodigoCargo.getText();
    }

    public void setTxtCodigoCargo(String CodigoCargo) {
        txtCodigoCargo.setText(CodigoCargo);
    }

    public String getTxtDenominacionCargo() {
        return txtDenominacionCargo.getText();
    }

    public void setTxtDenominacionCargo(String DenominacionCargo) {
        txtDenominacionCargo.setText(DenominacionCargo);
    }

    public String getTxtAsignaturas() {
        return txtAsignaturas.getText();
    }

    public String getTxtAsignaturasP() {
        return txtAsignaturasP.getText();
    }

    public String getTxtCompensacion() {
        return txtCompensacion.getText();
    }

    public Date getTxtFechaIngreso() {
        return txtFechaIngreso.getDate();
    }

    public String getTxtHorasA() {
        return txtHorasA.getText();
    }

    public String getTxtHorasD() {
        return txtHorasD.getText();
    }

    public String getTxtSueldo() {
        return txtSueldo.getText();
    }

    public int getCedula() {
        return cedula;
    }

    public JComboBox getComboTurno() {
        return comboTurno;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrarCargo = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        txtNombrePlantel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoPlantel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDenominacionCargo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCodigoCargo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHorasD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHorasA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAsignaturas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboTurno = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtCompensacion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAsignaturasP = new javax.swing.JTextField();
        btnSeleccionarPlantel = new javax.swing.JButton();
        btnAgregarEmpresa4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btnRegistrarCargo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRegistrarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnRegistrarCargo.setText("Registrar Cargo");
        btnRegistrarCargo.setToolTipText("Buscar Evaluación Técnica");
        btnRegistrarCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRegistrarCargo.setContentAreaFilled(false);
        btnRegistrarCargo.setFocusable(false);
        btnRegistrarCargo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCargo.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnRegistrarCargo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnRegistrarCargo.setVerifyInputWhenFocusTarget(false);
        btnRegistrarCargo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCargo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCargoActionPerformed(evt);
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
        jPanel4.setLayout(new java.awt.GridLayout(13, 2, 0, 10));

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

        jLabel6.setText("Plantel o Dependencia:");
        jPanel4.add(jLabel6);
        jPanel4.add(txtNombrePlantel);

        jLabel5.setText("Código Dependencia:");
        jPanel4.add(jLabel5);
        jPanel4.add(txtCodigoPlantel);

        jLabel7.setText("Denominación de Cargo:");
        jPanel4.add(jLabel7);
        jPanel4.add(txtDenominacionCargo);

        jLabel16.setText("Código de Cargo:");
        jPanel4.add(jLabel16);
        jPanel4.add(txtCodigoCargo);

        jLabel8.setText("Horas Docente:");
        jPanel4.add(jLabel8);

        txtHorasD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHorasDFocusLost(evt);
            }
        });
        txtHorasD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasDKeyTyped(evt);
            }
        });
        jPanel4.add(txtHorasD);

        jLabel9.setText("Horas Administrativas:");
        jPanel4.add(jLabel9);

        txtHorasA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHorasAFocusLost(evt);
            }
        });
        txtHorasA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasAKeyTyped(evt);
            }
        });
        jPanel4.add(txtHorasA);

        jLabel10.setText("Sueldo:");
        jPanel4.add(jLabel10);

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

        jLabel11.setText("Asignaturas:");
        jPanel4.add(jLabel11);

        txtAsignaturas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAsignaturasFocusLost(evt);
            }
        });
        txtAsignaturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAsignaturasKeyTyped(evt);
            }
        });
        jPanel4.add(txtAsignaturas);

        jLabel12.setText("Turno:");
        jPanel4.add(jLabel12);

        comboTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Diurno", "Nocturno" }));
        jPanel4.add(comboTurno);

        jLabel13.setText("Compensación:");
        jPanel4.add(jLabel13);

        txtCompensacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompensacionFocusLost(evt);
            }
        });
        txtCompensacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompensacionKeyTyped(evt);
            }
        });
        jPanel4.add(txtCompensacion);

        jLabel14.setText("Asignaturas Posibles:");
        jPanel4.add(jLabel14);

        txtAsignaturasP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAsignaturasPFocusLost(evt);
            }
        });
        txtAsignaturasP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAsignaturasPKeyTyped(evt);
            }
        });
        jPanel4.add(txtAsignaturasP);

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
                        .addComponent(btnRegistrarCargo)
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
                        .addComponent(btnAgregarEmpresa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 240, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnRegistrarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCargoActionPerformed

    }//GEN-LAST:event_btnRegistrarCargoActionPerformed

    private void btnRestablecerCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerCamposActionPerformed
       // RestablecerCampos();
    }//GEN-LAST:event_btnRestablecerCamposActionPerformed

    private void txtHorasDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasDFocusLost

    private void txtHorasDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasDKeyTyped

    private void txtHorasAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasAFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasAFocusLost

    private void txtHorasAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasAKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasAKeyTyped

    private void txtSueldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSueldoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoFocusLost

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoKeyTyped

    private void txtAsignaturasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAsignaturasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturasFocusLost

    private void txtAsignaturasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsignaturasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturasKeyTyped

    private void txtCompensacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompensacionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompensacionFocusLost

    private void txtCompensacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompensacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompensacionKeyTyped

    private void txtAsignaturasPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAsignaturasPFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturasPFocusLost

    private void txtAsignaturasPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsignaturasPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturasPKeyTyped

    private void btnSeleccionarPlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPlantelActionPerformed
     new viewCatalagoPlanteles(null,null,this,null,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);  
    }//GEN-LAST:event_btnSeleccionarPlantelActionPerformed

    private void btnAgregarEmpresa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa4ActionPerformed
        try {
            new viewSeleccionarCargo(null,null,this,this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(viewRegistrarCargo.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(viewRegistrarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewRegistrarCargo(null, null,new javax.swing.JDialog(), true, Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEmpresa4;
    private javax.swing.JButton btnRegistrarCargo;
    private javax.swing.JButton btnRestablecerCampos;
    private javax.swing.JButton btnSeleccionarPlantel;
    private javax.swing.JComboBox comboTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField txtAsignaturas;
    private javax.swing.JTextField txtAsignaturasP;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JLabel txtCodigoCargo;
    private javax.swing.JLabel txtCodigoPlantel;
    private javax.swing.JTextField txtCompensacion;
    private javax.swing.JLabel txtDenominacionCargo;
    private com.toedter.calendar.JDateChooser txtFechaIngreso;
    private javax.swing.JTextField txtHorasA;
    private javax.swing.JTextField txtHorasD;
    private javax.swing.JLabel txtNombrePlantel;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
