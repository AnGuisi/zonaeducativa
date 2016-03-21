/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelUsuario;
import views.viewPrincipal;

/**
 *
 * @author Gleycer
 */
public class controllerCerrarSesion {
    viewPrincipal view;
    modelUsuario model;

    public controllerCerrarSesion(viewPrincipal view) {
        this.view = view;
    }
    
    public void cerrarSesion(String usuario) {
    this.model = new modelUsuario();
    boolean cerrarSesion = model.cerrarSesion(usuario);
    if (cerrarSesion) {}
    else {
    mensaje("Error al cerrar sesión, contacte con el administrador","Error al cerrar sesión",2);
         }
                                             }
    
                 private void mensaje (String msj, String titulo, int tipo)
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
