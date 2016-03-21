/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.toedter.calendar.JDateChooser;
import controllers.controllerInasistencias;
import controllers.controllerRegistrarCargo;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewRegistrarInasistencia extends javax.swing.JDialog {
    private OSValidator validarOS;
    int cedula;

    /**
     * Creates new form viewRegistrarCargo
     */
    public viewRegistrarInasistencia(viewFichaPersonal ficha,java.awt.Dialog parent, boolean modal, ModalityType modalityType) {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        initComponents();
        this.setTitle("Registrar Cargo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        inicializarEventos(ficha);
    }
    
    public void inicializarEventos(viewFichaPersonal ficha) {
    controllerInasistencias controller = new controllerInasistencias(this);
    controller.setViewFichaPersonal(ficha);
    btnRegistrarInasistencia.addActionListener(controller);
                                                            }

    public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public JButton getBtnRegistrarCargo() {
        return btnRegistrarInasistencia;
    }

    public String getTxtCedula() {
        return txtCedula.getText();
    }

    public Date getTxtFecha() {
        return txtFecha.getDate();
    }
 
    public int getCedula() {
        return cedula;
    }

    public JButton getBtnRegistrarInasistencia() {
        return btnRegistrarInasistencia;
    }

    public JRadioButton getRadioBtnInjustificada() {
        return radioBtnInjustificada;
    }

    public JRadioButton getRadioBtnJustificada() {
        return radioBtnJustificada;
    }

    public String getTxtCausaMotivo() {
        return txtCausaMotivo.getText();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupJustificacion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrarInasistencia = new javax.swing.JButton();
        btnRestablecerCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCausaMotivo = new javax.swing.JTextArea();
        radioBtnJustificada = new javax.swing.JRadioButton();
        radioBtnInjustificada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btnRegistrarInasistencia.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRegistrarInasistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnRegistrarInasistencia.setText("Registrar Inasistencia");
        btnRegistrarInasistencia.setToolTipText("Buscar Evaluación Técnica");
        btnRegistrarInasistencia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRegistrarInasistencia.setContentAreaFilled(false);
        btnRegistrarInasistencia.setFocusable(false);
        btnRegistrarInasistencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarInasistencia.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnRegistrarInasistencia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnRegistrarInasistencia.setVerifyInputWhenFocusTarget(false);
        btnRegistrarInasistencia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarInasistencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarInasistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInasistenciaActionPerformed(evt);
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
        jLabel3.setText("Registrar Inasistencia");

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
        jPanel4.setLayout(new java.awt.GridLayout(2, 2, 0, 5));

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

        jLabel4.setText("Fecha:");
        jPanel4.add(jLabel4);

        txtFecha.setPreferredSize(new java.awt.Dimension(93, 20));
        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFocusLost(evt);
            }
        });
        jPanel4.add(txtFecha);

        jLabel6.setText("Causa o Motivo:");

        txtCausaMotivo.setColumns(20);
        txtCausaMotivo.setLineWrap(true);
        txtCausaMotivo.setRows(5);
        jScrollPane1.setViewportView(txtCausaMotivo);

        radioBtnJustificada.setBackground(new java.awt.Color(255, 255, 255));
        groupJustificacion.add(radioBtnJustificada);
        radioBtnJustificada.setText("Justificada");

        radioBtnInjustificada.setBackground(new java.awt.Color(255, 255, 255));
        groupJustificacion.add(radioBtnInjustificada);
        radioBtnInjustificada.setText("Injustificada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnRegistrarInasistencia)
                                .addGap(18, 18, 18)
                                .addComponent(btnRestablecerCampos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(radioBtnJustificada)
                                .addGap(18, 18, 18)
                                .addComponent(radioBtnInjustificada)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBtnJustificada)
                    .addComponent(radioBtnInjustificada))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarInasistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRestablecerCampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarInasistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInasistenciaActionPerformed

    }//GEN-LAST:event_btnRegistrarInasistenciaActionPerformed

    private void btnRestablecerCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerCamposActionPerformed
       // RestablecerCampos();
    }//GEN-LAST:event_btnRestablecerCamposActionPerformed

    private void txtFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusGained

    }//GEN-LAST:event_txtFechaFocusGained

    private void txtFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusLost

    }//GEN-LAST:event_txtFechaFocusLost

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
            java.util.logging.Logger.getLogger(viewRegistrarInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewRegistrarInasistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewRegistrarInasistencia(null,new javax.swing.JDialog(), true, Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarInasistencia;
    private javax.swing.JButton btnRestablecerCampos;
    private javax.swing.ButtonGroup groupJustificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioBtnInjustificada;
    private javax.swing.JRadioButton radioBtnJustificada;
    private javax.swing.JTextArea txtCausaMotivo;
    private javax.swing.JTextField txtCedula;
    private com.toedter.calendar.JDateChooser txtFecha;
    // End of variables declaration//GEN-END:variables
}
