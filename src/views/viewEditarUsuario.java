/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.sun.awt.AWTUtilities;
import controllers.controllerVerificarEdicionUsuario;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewEditarUsuario extends javax.swing.JFrame {
boolean b = true;
int x,y;
    private OSValidator validarOS;
    /**
     * Creates new form viewEditarUsuario
     */
    public viewEditarUsuario() {
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Editar Usuario");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        InicializacionEventos();
                               }
    
              public void InicializacionEventos() {
controllerVerificarEdicionUsuario controlador = new controllerVerificarEdicionUsuario (this);
btnEditarUsuario.addActionListener(controlador);
                                  }

    public JComboBox getComboDepartamento() {
        return comboDepartamento;
    }


    public String getTxtConfirmContraseña() {
        return txtConfirmContraseña.getText();
    }


    public String getTxtContraseña() {
        return txtContraseña.getText();
    }


    public String getTxtId() {
        return txtId.getText();
    }


   public String getTxtNombre() {
        return txtNombre.getText();
    }

    
      public String getTxtCedula() {
        return txtCedula.getText();
    }

    public JButton getBtnEditarUsuario() {
        return btnEditarUsuario;
    }
    
       public void setComboDepartamento(JComboBox comboDepartamento) {
        this.comboDepartamento = comboDepartamento;
    }

  
   public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public void setTxtId(String Id) {
        txtId.setText(Id);
    }

    public void setTxtNombre(String Nombre) {
        txtNombre.setText(Nombre);
    }

    public JComboBox getComboTipoUsuario() {
        return comboTipoUsuario;
    }
  
     public void RestablecerCampos() {
     txtNombre.setText("");
     txtId.setText("");
     txtContraseña.setText("");
     txtConfirmContraseña.setText("");
     txtCedula.setText("");
     comboDepartamento.setSelectedIndex(0);
     
                                      }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelBarraHerramientas1 = new javax.swing.JPanel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabelMaximizar = new javax.swing.JLabel();
        jLabelCerrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEditarUsuario = new javax.swing.JButton();
        btnRestablecerCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtConfirmContraseña = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        comboTipoUsuario = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanelBarraHerramientas1.setBackground(new java.awt.Color(102, 102, 102));
        jPanelBarraHerramientas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBarraHerramientas1MousePressed(evt);
            }
        });
        jPanelBarraHerramientas1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelBarraHerramientas1MouseDragged(evt);
            }
        });
        jPanelBarraHerramientas1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/verde.png"))); // NOI18N
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseExited(evt);
            }
        });
        jPanelBarraHerramientas1.add(jLabelMinimizar);

        jLabelMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/amarillo.png"))); // NOI18N
        jLabelMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMaximizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMaximizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMaximizarMouseExited(evt);
            }
        });
        jPanelBarraHerramientas1.add(jLabelMaximizar);

        jLabelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rojo.png"))); // NOI18N
        jLabelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseExited(evt);
            }
        });
        jPanelBarraHerramientas1.add(jLabelCerrar);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        btnEditarUsuario.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus_16.png"))); // NOI18N
        btnEditarUsuario.setText("Editar Usuario");
        btnEditarUsuario.setToolTipText("Buscar Evaluación Técnica");
        btnEditarUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEditarUsuario.setContentAreaFilled(false);
        btnEditarUsuario.setFocusable(false);
        btnEditarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarUsuario.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnEditarUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus_32_opt.png"))); // NOI18N
        btnEditarUsuario.setVerifyInputWhenFocusTarget(false);
        btnEditarUsuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnRestablecerCampos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRestablecerCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash_16.png"))); // NOI18N
        btnRestablecerCampos.setText("Restablecer Campos");
        btnRestablecerCampos.setToolTipText("Buscar Evaluación Técnica");
        btnRestablecerCampos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRestablecerCampos.setContentAreaFilled(false);
        btnRestablecerCampos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRestablecerCampos.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnRestablecerCampos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash_32_opt.png"))); // NOI18N
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
        jLabel3.setText("Editar Usuario");

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

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(7, 2, 0, 2));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jLabel17.setText("Nombre:");
        jPanel8.add(jLabel17);

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.add(txtNombre);

        jPanel10.add(jPanel8);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel19.setText("Id:");
        jPanel7.add(jLabel19);

        txtId.setEditable(false);
        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.add(txtId);

        jPanel10.add(jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Cédula:");
        jPanel9.add(jLabel4);

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.add(txtCedula);

        jPanel10.add(jPanel9);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel20.setText("Contraseña:");
        jPanel6.add(jLabel20);
        jPanel6.add(txtContraseña);

        jPanel10.add(jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel21.setText("Repita Contraseña:");
        jPanel5.add(jLabel21);
        jPanel5.add(txtConfirmContraseña);

        jPanel10.add(jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setText("Departamento:");
        jPanel4.add(jLabel5);

        comboDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Recursos Humanos", "Informática" }));
        jPanel4.add(comboDepartamento);

        jPanel10.add(jPanel4);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        jLabel18.setText("Tipo Usuario:");
        jPanel11.add(jLabel18);

        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Usuario Común", "Administrador" }));
        jPanel11.add(comboTipoUsuario);

        jPanel10.add(jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnEditarUsuario)
                        .addGap(31, 31, 31)
                        .addComponent(btnRestablecerCampos)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRestablecerCampos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarraHerramientas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanelBarraHerramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);

        if(b == false){
            this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
            b = false;
        } else{

            b = true;
        }
    }//GEN-LAST:event_jLabelMinimizarMouseClicked

    private void jLabelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseEntered
        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/verde_c.png")));
    }//GEN-LAST:event_jLabelMinimizarMouseEntered

    private void jLabelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseExited
        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/verde.png")));
    }//GEN-LAST:event_jLabelMinimizarMouseExited

    private void jLabelMaximizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaximizarMouseClicked

    }//GEN-LAST:event_jLabelMaximizarMouseClicked

    private void jLabelMaximizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaximizarMouseEntered
        jLabelMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/amarillo_c.png")));
    }//GEN-LAST:event_jLabelMaximizarMouseEntered

    private void jLabelMaximizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaximizarMouseExited
        jLabelMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/amarillo.png")));
    }//GEN-LAST:event_jLabelMaximizarMouseExited

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabelCerrarMouseClicked

    private void jLabelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseEntered
        jLabelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rojo_c.png")));
    }//GEN-LAST:event_jLabelCerrarMouseEntered

    private void jLabelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseExited
        jLabelCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rojo.png")));
    }//GEN-LAST:event_jLabelCerrarMouseExited

    private void jPanelBarraHerramientas1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraHerramientas1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanelBarraHerramientas1MousePressed

    private void jPanelBarraHerramientas1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraHerramientas1MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(point.x-x,point.y-y);
    }//GEN-LAST:event_jPanelBarraHerramientas1MouseDragged

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed

    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnRestablecerCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerCamposActionPerformed

    }//GEN-LAST:event_btnRestablecerCamposActionPerformed

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
            java.util.logging.Logger.getLogger(viewEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewEditarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewEditarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnRestablecerCampos;
    private javax.swing.JComboBox comboDepartamento;
    private javax.swing.JComboBox comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCerrar;
    private javax.swing.JLabel jLabelMaximizar;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBarraHerramientas1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtConfirmContraseña;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
