/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.Dialog;
import models.modelUsuario;
import views.viewInicio;
import views.viewPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import views.viewDialogWithTime;
import views.viewVerificarSesion;

/**
 *
 * @author Gleycer
 */
public class controllerIniciarSesion implements ActionListener {
  viewInicio view;
  viewVerificarSesion viewVerificarSesion;
  viewDialogWithTime viewDialogWithTime;
  modelUsuario model;
  String strCaptcha;
  int numIntentos = 0;

    public void setStrCaptcha(String strCaptcha) {
        this.strCaptcha = strCaptcha;
    }

    public controllerIniciarSesion(viewVerificarSesion viewVerificarSesion) {
        this.viewVerificarSesion = viewVerificarSesion;
    }


    private viewPrincipal viewMenu;

    public controllerIniciarSesion(viewInicio view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
        if(view != null) {
		if (envDisparado.equals(view.getBtnIniciarSesion())) {
                    boolean validarCaptcha = false;
                    validarCaptcha = validarCaptcha();
                    if(validarCaptcha) {
            try {
                VerificarSesion(); 
            } catch (SQLException ex) {
                Logger.getLogger(controllerIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }           catch (Exception ex) {
                            Logger.getLogger(controllerIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                       }

        }
                        }
        if (viewVerificarSesion != null) {
            if(envDisparado.equals(viewVerificarSesion.getBtnVerificarSesion())) {
                try {
                    VerificarSesionInactiva();
                } catch (Exception ex) {
                    Logger.getLogger(controllerIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                                                                                 }
                                         }
                
  


}

  public boolean VerificarSesion() throws SQLException, Exception {
     
     String mensaje;
     this.model = new modelUsuario();
     String password = MD5(view.getTxtContraseña());
     boolean consulta = model.VerificarUsuario(view.getTxtUsuario(),password);
       if (consulta) {
    if (model.getVerificar_sesion() == 0) {
           viewMenu = new viewPrincipal();
           viewMenu.setUsuario(view.getTxtUsuario());
           viewMenu.getMenuTopUser().setText("Usuario: "+view.getTxtUsuario());
    model.cambiarEstatusSesion(view.getTxtUsuario());
  
    if(model.getDepartamento().equals("Recursos Humanos")) {
        if(model.getTipo_usuario() == 1) {
           viewMenu.getBtnPrincipalUsuarios().setEnabled(false);
           viewMenu.getBtnPrincipalConfiguraciones().setEnabled(false);
                                         }
        else if(model.getTipo_usuario() == 2){
           viewMenu.getBtnPrincipalConfiguraciones().setEnabled(false);
                                             }
                                                      }
  
    viewMenu.setVisible(true);
    
    view.dispose();
                                          }
    else {
    Mensaje("Ya se encuentra iniciada una sesión con este usuario","Sesión Iniciada",2);
         }
                   }
         else {
           numIntentos++;
           
      if (numIntentos == 3) {
          
      Mensaje("Por favor intentelo de nuevo en 60 segundos","Usuario Incorrecto",2);
      new viewDialogWithTime(new javax.swing.JFrame(),true, Dialog.ModalityType.APPLICATION_MODAL).setVisible(true);
      numIntentos = 0;
                             }
      else {
      Mensaje("Usuario Incorrecto","Usuario Incorrecto",2);
           }
              }
 
     return consulta;
                                                                   }
  
    public boolean VerificarSesionInactiva() throws SQLException, Exception {
     
     String mensaje;
     this.model = new modelUsuario();
     String password = MD5(viewVerificarSesion.getTxtContraseña());
     boolean consulta = model.VerificarUsuario(viewVerificarSesion.getTxtUsuario(),password);
       if (consulta) {
  
      viewVerificarSesion.dispose();
                   }
         else {
      
      Mensaje("Usuario Incorrecto","UsuarioIncorrecto",2);
              }
 
     return consulta;
                                                                   }
  
  private boolean validarCaptcha() {
  if (strCaptcha.equals(view.getTxtCaptcha())) {
  return true;
                                                    }
  else {
  Mensaje("Captcha Incorrecto","Captcha Incorrecto",2);
  return false;
       }
                                                       }
  
     public static String MD5(String texto) throws Exception {
      String a;
      String txtEncriptado = "";
      
      MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
      md.update(texto.getBytes());
      byte[] digest = md.digest();

      // Se escribe byte a byte en hexadecimal
      for (byte b : digest) {
         a = (Integer.toHexString(0xFF & b));
         txtEncriptado = txtEncriptado+a;
      }
      return txtEncriptado;

      // Se escribe codificado base 64. Se necesita la librería
      // commons-codec-x.x.x.jar de Apache
      /*byte[] encoded = Base64.encodeBase64(digest);
      System.out.println(new String(encoded));*/
   }
  
             private void Mensaje (String msj, String titulo, int tipo)
{  if (tipo == 1)
	JOptionPane.showMessageDialog( new JFrame(),msj,titulo,JOptionPane.INFORMATION_MESSAGE);
   else  
	if(tipo ==2)
	  JOptionPane.showMessageDialog( new JFrame(),msj,titulo,JOptionPane.ERROR_MESSAGE);
	else
	  if (tipo ==3)
		{}
} 
}
