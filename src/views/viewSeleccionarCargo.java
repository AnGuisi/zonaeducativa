/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.controllerSeleccionarCargo;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewSeleccionarCargo extends javax.swing.JDialog {
    private OSValidator validarOS;

    /**
     * Creates new form viewSeleccionarCargo
     */
    public viewSeleccionarCargo(viewTramitesAdministrativos tramites,viewRegistrarHojaServicio hojaServicio,viewRegistrarCargo cargo,java.awt.Dialog parent, boolean modal,ModalityType modalityType) throws SQLException {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        initComponents();
        this.setLocationRelativeTo(null);
        cargarComboDenCargo();
        inicializacionEventos(tramites,cargo,hojaServicio);
    }
    
    public void inicializacionEventos(viewTramitesAdministrativos tramites,viewRegistrarCargo cargo,viewRegistrarHojaServicio hojaServicio) {
        controllerSeleccionarCargo controller = new controllerSeleccionarCargo(this);
        controller.setViewTramites(tramites);
        controller.setViewRegistrarCargo(cargo);
        controller.setViewRegistrarHojaServicio(hojaServicio);
        btnAgregarCargo.addActionListener(controller);
                                                                }

    public String getTxtCodigoCargo() {
        return txtCodigoCargo.getText();
    }
    
    public JButton getBtnAgregarCargo() {
        return btnAgregarCargo;
    }

    public JComboBox getComboDenCargo() {
        return comboDenCargo;
    }

      private void cargarComboDenCargo () throws SQLException {
    List ListItem = controllerSeleccionarCargo.cargarDenCargo();
  
    int i;
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
    comboDenCargo.addItem(ListItem.get(i));
                                }
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

        jPanel1 = new javax.swing.JPanel();
        btnAgregarCargo = new javax.swing.JButton();
        btnRestablecerCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboDenCargo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        comboTipoPersonal = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboJerarquia = new javax.swing.JComboBox();
        txtNombrePlantel = new javax.swing.JLabel();
        comboNivel = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        comboCatAcademica = new javax.swing.JComboBox();
        txtCodigoPlantel = new javax.swing.JLabel();
        comboTurno = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        comboDedicacion = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoCargo = new javax.swing.JTextField();
        btnGenerarCodigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btnAgregarCargo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnAgregarCargo.setText("Agregar Cargo");
        btnAgregarCargo.setToolTipText("Buscar Evaluación Técnica");
        btnAgregarCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarCargo.setContentAreaFilled(false);
        btnAgregarCargo.setFocusable(false);
        btnAgregarCargo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarCargo.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnAgregarCargo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnAgregarCargo.setVerifyInputWhenFocusTarget(false);
        btnAgregarCargo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarCargo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCargoActionPerformed(evt);
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
        jPanel4.setLayout(new java.awt.GridLayout(8, 2, 0, 10));

        jLabel4.setText("Denominación de Cargo:");
        jPanel4.add(jLabel4);

        comboDenCargo.setEditable(true);
        comboDenCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        jPanel4.add(comboDenCargo);

        jLabel8.setText("Tipo de Personal:");
        jPanel4.add(jLabel8);

        comboTipoPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Profesor o Licenciado en Educación", "Técnico Superior en Educación", "Maestro o Bachiller Docente", "Docente NO Graduado", "Licenciado NO Docente", "TSU NO Docente", "Convenio Cuba-Venezuela" }));
        jPanel4.add(comboTipoPersonal);

        jLabel6.setText("Jerarquía:");
        jPanel4.add(jLabel6);

        comboJerarquia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Docente de Aula", "Docente Coordinador de Sección o Departamento", "Docente Coordinador de Laboratoio o Taller", "Docente Coordinador de Especialidad", "Docente Coordinador Orientador", "Docente Coordinador Res. Nocturno", "Docente Sub-Director", "Docente Director", "Docente Supervisor" }));
        jPanel4.add(comboJerarquia);

        txtNombrePlantel.setText("Nivel o Modalidad:");
        jPanel4.add(txtNombrePlantel);

        comboNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Preescolar", "Básica 1-6 Grado", "Básica 1-3 Grado", "Media Diversificada", "Media Profesional", "Especial Básica Adultos", "Capacitación Adultos", "Docente Supervisor", "Supervisores" }));
        jPanel4.add(comboNivel);

        jLabel5.setText("Categoria Académica:");
        jPanel4.add(jLabel5);

        comboCatAcademica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Docente NO Graduado", "Docente I", "Docente II", "Docente III", "Docente IV", "Docente V", "Docente VI", "Licenciado o Profesor", "TSU en Educación", "Bachiller Docente" }));
        jPanel4.add(comboCatAcademica);

        txtCodigoPlantel.setText("Turno y Tipo de Personal:");
        jPanel4.add(txtCodigoPlantel);

        comboTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Titular Diurno", "Interino Diurno (permiso del titular)", "Interino Diurno", "Interino Horas Variables", "Titular Nocturno", "Interino Nocturno (permiso del titular)", "Interino Nocturno", "Suplente Nacional Encargado", "Suplente Cuidador de Cargo Diurno", "Encargado de un cargo de mayor jerarquía", " " }));
        jPanel4.add(comboTurno);

        jLabel7.setText("Dedicación:");
        jPanel4.add(jLabel7);

        comboDedicacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Tiempo Completo", "Integral", "Convencional", "Medio Tiempo" }));
        jPanel4.add(comboDedicacion);

        jLabel11.setText("Código de Cargo:");
        jPanel4.add(jLabel11);

        txtCodigoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoCargoKeyTyped(evt);
            }
        });
        jPanel4.add(txtCodigoCargo);

        btnGenerarCodigo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGenerarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/generar_p.png"))); // NOI18N
        btnGenerarCodigo.setText("Generar Código");
        btnGenerarCodigo.setToolTipText("Buscar Evaluación Técnica");
        btnGenerarCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnGenerarCodigo.setContentAreaFilled(false);
        btnGenerarCodigo.setFocusable(false);
        btnGenerarCodigo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarCodigo.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnGenerarCodigo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/generar_g.png"))); // NOI18N
        btnGenerarCodigo.setVerifyInputWhenFocusTarget(false);
        btnGenerarCodigo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGenerarCodigo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(btnAgregarCargo)
                                .addGap(18, 18, 18)
                                .addComponent(btnRestablecerCampos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerarCodigo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRestablecerCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargoActionPerformed

    }//GEN-LAST:event_btnAgregarCargoActionPerformed

    private void btnRestablecerCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerCamposActionPerformed
        // RestablecerCampos();
    }//GEN-LAST:event_btnRestablecerCamposActionPerformed

    private void btnGenerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCodigoActionPerformed
String codigo = null;
       int comboPersonal,jerarquia,nivel,categoria,turno,dedicacion;
       comboPersonal = comboTipoPersonal.getSelectedIndex();
       jerarquia = comboJerarquia.getSelectedIndex();
       nivel = comboNivel.getSelectedIndex();
       categoria = comboCatAcademica.getSelectedIndex();
       turno = comboTurno.getSelectedIndex();
       dedicacion = comboDedicacion.getSelectedIndex();
       if (comboPersonal != 7) {
       codigo = Integer.toString(comboPersonal);
                               }
       else {
       codigo = "9";
            }
       
       codigo = codigo+Integer.toString(jerarquia);
       
       if (nivel != 10) {
       codigo = codigo+Integer.toString(nivel);
                        }
       else {
       codigo=codigo+"S";
            }
       

       if(categoria != 8 || categoria != 9 || categoria != 10) {
       codigo = codigo+(Integer.toString(categoria-1));
                                                                }
       else if(categoria == 8) {
       codigo = codigo+"A";
                               }
       else if(categoria == 9) {
       codigo = codigo+"B";
                               }
       else if(categoria == 10) {
       codigo = codigo+"C";
                               }
       
       switch(turno) {
           case 1: codigo = codigo+"D";
               break;
           case 2: codigo = codigo+"X";
               break;
           case 3: codigo = codigo+"W";
               break;
           case 4: codigo = codigo+"A";
               break;
           case 5: codigo = codigo+"N";
               break;
           case 6: codigo = codigo+"Y";
               break;
           case 7: codigo = codigo+"Z";
               break;
           case 8: codigo = codigo+"K";
               break;
           case 9: codigo = codigo+"X";
               break;
           case 10: codigo = codigo+"E";
                     }
       
              switch(dedicacion) {
           case 1: codigo = codigo+"C";
               break;
           case 2: codigo = codigo+"I";
               break;
           case 3: codigo = codigo+"H";
               break;
           case 4: codigo = codigo+"M";
           
                     }
       txtCodigoCargo.setText(codigo);        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarCodigoActionPerformed

    private void txtCodigoCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoCargoKeyTyped
       
    }//GEN-LAST:event_txtCodigoCargoKeyTyped

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
            java.util.logging.Logger.getLogger(viewSeleccionarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewSeleccionarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewSeleccionarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewSeleccionarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewSeleccionarCargo(null,null,null,new javax.swing.JDialog(), true, Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(viewSeleccionarCargo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCargo;
    private javax.swing.JButton btnGenerarCodigo;
    private javax.swing.JButton btnRestablecerCampos;
    private javax.swing.JComboBox comboCatAcademica;
    private javax.swing.JComboBox comboDedicacion;
    private javax.swing.JComboBox comboDenCargo;
    private javax.swing.JComboBox comboJerarquia;
    private javax.swing.JComboBox comboNivel;
    private javax.swing.JComboBox comboTipoPersonal;
    private javax.swing.JComboBox comboTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtCodigoCargo;
    private javax.swing.JLabel txtCodigoPlantel;
    private javax.swing.JLabel txtNombrePlantel;
    // End of variables declaration//GEN-END:variables
}
