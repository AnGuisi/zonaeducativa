/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.modelUsuario;
import views.viewRegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;


/**
 *
 * @author Gleycer
 */
public class controllerRegistrarUsuario implements ActionListener{
    viewRegistrarUsuario view;
    modelUsuario model;

    public controllerRegistrarUsuario(viewRegistrarUsuario view) {
        this.view = view;
    }
 
    
    
    public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
       
        boolean valida = false;
     
		if (envDisparado.equals(view.getBtnRegistrarUsuario()))
                    
                        
                           try {
                        valida = ValidarDatos();
                        } catch (ParseException ex) {
                        Logger.getLogger(controllerRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (valida == true) {
                        {
                            try {
                        
                        Registrar();
                        } catch (SQLException e) {
                        e.printStackTrace();
                                                 } catch (Exception ex) {
                                Logger.getLogger(controllerRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                                             }
   
         /*   try {
                valida = ValidarDatos();
        } catch (ParseException ex) {
            Logger.getLogger(controllerRegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
             if (valida == true) {
                 {try {
             
                    Registrar();
            } catch (SQLException e) {
               e.printStackTrace();
            }
                                  }
                }
*/
        }
    
        public void Mensaje (String msj, String titulo, int tipo)
{  if (tipo == 1)
	JOptionPane.showMessageDialog( new JFrame(),msj,titulo,JOptionPane.INFORMATION_MESSAGE);
   else  
	if(tipo ==2)
	  JOptionPane.showMessageDialog( new JFrame(),msj,titulo,JOptionPane.ERROR_MESSAGE);
	else
	  if (tipo ==3)
		{}
}
    
      public boolean ValidarDatos() throws ParseException {
       boolean validar = true;
       String cedula = view.getTxtCedula().trim();
       String nombre = view.getTxtNombre().trim();
       String id = view.getTxtId().trim();
       String contraseña = view.getTxtContraseña().trim();
       String repcontraseña = view.getTxtConfirmContraseña().trim();
       
       
  
            if (nombre.equals("")) {
                Mensaje("Ingrese Nombre", "¡ERROR!", 2);
                validar = false;
                                        }
            else if (id.equals("")) {
                Mensaje("Ingrese Id de Usuario", "¡ERROR!", 2);
                validar = false;
                                                                           }
             else if (cedula.equals("")) {
                Mensaje("Ingrese Cédula", "¡ERROR!", 2);
                validar = false;
            } else if (view.getTxtCedula().length() < 6) {
                Mensaje("Cédula Incorrecta", "¡ERROR!", 2);
                validar = false;
            } else if (view.getTxtCedula().length() > 8) {
                Mensaje("Cédula Incorrecta", "¡ERROR!", 2);
                validar = false;
            }
            else if (contraseña.equals("")) {
                Mensaje("Ingrese Contraseña", "¡ERROR!", 2);
                validar = false;
                                           }
             else if (contraseña.length() < 6) {
                Mensaje("Contraseña Incorrecta", "¡ERROR!", 2);
                validar = false;
                                               }
            
            else if (repcontraseña.equals("")) {
                Mensaje("Repita Contraseña", "¡ERROR!", 2);
                validar = false;
                                           }
            else if (repcontraseña.equals(contraseña)== false) {
             Mensaje("Las contraseñas no coinciden", "¡ERROR!", 2);
                validar = false;
                                                  }
            else if (view.getComboDepartamento().getSelectedIndex() == 0) {
                Mensaje("Seleccione Municipio", "¡ERROR!", 2);
                validar = false;
                                                                          }
        

            else {
                validar = true;
                   }
         return validar;
   }
      
    public void Registrar() throws SQLException, Exception {
    
     this.model = new modelUsuario();
     
     String id_usuario = view.getTxtId();
     this.model = new modelUsuario(id_usuario);
     boolean buscar = model.ConsultarUsuario(id_usuario);
     if (buscar) {
     Mensaje("Usuario Existente, por favor utilize otro ID", "¡Aviso!", 1);
                 }
     else {
     
     String mensaje;
     int tipo_usuario = view.getComboTipoUsuario().getSelectedIndex();
     String departamento = view.getComboDepartamento().getSelectedItem().toString();
     String password = MD5(view.getTxtContraseña());
     this.model = new modelUsuario(view.getTxtId(),password,view.getTxtNombre(),view.getTxtCedula(),departamento,tipo_usuario);
     boolean inclusion = model.RegistrarUsuario();
     if (inclusion) {
         
                  mensaje = new String("Registro Satisfactorio");
		  Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
                    }
     else
		{ mensaje = new String("No se ha podido realizar el registro");
		  Mensaje(mensaje,"ERROR",2);
		}
     
     view.RestablecerCampos();
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
}

