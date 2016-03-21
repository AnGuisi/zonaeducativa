/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.modelUsuario;
import views.viewEditarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gleycer
 */
public class controllerVerificarEdicionUsuario implements ActionListener {
 viewEditarUsuario viewEditarUsuario;
modelUsuario model;   

    public controllerVerificarEdicionUsuario(viewEditarUsuario viewEditarUsuario) {
        this.viewEditarUsuario = viewEditarUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent evenDisp) {
       Object envDisparado = evenDisp.getSource();
       boolean valida = false;
       
       if (envDisparado.equals(viewEditarUsuario.getBtnEditarUsuario())) {
           try {
               valida = ValidarDatos();
           } catch (ParseException ex) {
               Logger.getLogger(controllerVerificarEdicionUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
           if (valida == true) {
        EditarUsuario();
                               }
                                                                          }
    }
    
    public boolean EditarUsuario() {
    String mensaje = null;
String nombre = viewEditarUsuario.getTxtNombre();
String contraseña = viewEditarUsuario.getTxtContraseña();
String cedula = viewEditarUsuario.getTxtCedula();
String departamento = viewEditarUsuario.getComboDepartamento().getSelectedItem().toString();
String usuario = viewEditarUsuario.getTxtId();
int tipo_usuario = viewEditarUsuario.getComboTipoUsuario().getSelectedIndex();
this.model = new modelUsuario(usuario,contraseña,nombre,cedula,departamento,tipo_usuario);
boolean editar_usuario = model.EditarUsuario();
 if (editar_usuario) {
                  mensaje = new String("Los datos del usuario fueron editados correctamente");
		  Mensaje(mensaje,"Los datos del usuario fueron editados correctamente",1);
                  
                    }
     else
		{ mensaje = new String("No se han podido editar los datos, consulte con su administrador");
		  Mensaje(mensaje,"ERROR",2);
		}
 return editar_usuario;
                               }
    
          public boolean ValidarDatos() throws ParseException {
       boolean validar = true;
       String cedula = viewEditarUsuario.getTxtCedula().trim();
       String nombre = viewEditarUsuario.getTxtNombre().trim();
       String id = viewEditarUsuario.getTxtId().trim();
       String contraseña = viewEditarUsuario.getTxtContraseña().trim();
       String repcontraseña = viewEditarUsuario.getTxtConfirmContraseña().trim();
       
  
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
            } else if (viewEditarUsuario.getTxtCedula().length() < 6) {
                Mensaje("Cédula Incorrecta", "¡ERROR!", 2);
                validar = false;
            } else if (viewEditarUsuario.getTxtCedula().length() > 8) {
                Mensaje("Cédula Incorrecta", "¡ERROR!", 2);
                validar = false;
            }
            else if (contraseña.equals("")) {
                Mensaje("Ingrese Contraseña", "¡ERROR!", 2);
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
            else if (viewEditarUsuario.getComboDepartamento().getSelectedIndex() == 0) {
                Mensaje("Seleccione Municipio", "¡ERROR!", 2);
                validar = false;
                                                                                           }
        

            else {
                validar = true;
                   }
         return validar;
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
}

