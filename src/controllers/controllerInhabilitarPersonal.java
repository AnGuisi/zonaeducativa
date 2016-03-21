/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelDatosPersonales;
import views.viewConsultarDatosPersonal;

/**
 *
 * @author Gleycer
 */
public class controllerInhabilitarPersonal implements ActionListener{
private viewConsultarDatosPersonal view;
private modelDatosPersonales model;

    public controllerInhabilitarPersonal(viewConsultarDatosPersonal view) {
        this.view = view;
    }


    
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(view.getBtnInhabilitar())) {
   int seleccion = JOptionPane.showOptionDialog(
   null,
   "¿Está seguro de que desea inhabilitar el registro de esta persona?",
   "Inhabilitar Personal",
   JOptionPane.YES_NO_CANCEL_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,    // null para icono por defecto.
   null,   // null para YES, NO y CANCEL
   null);
            if (seleccion != -1)
    if(seleccion + 1 == 1) {
      inhabilitarPersonal(Integer.parseInt(view.getTxtCedula()));

                            } 
   if (seleccion + 1 == 2 || seleccion +1 == 3) {
       
                                                 }
                                                            }
    }
    
    private void inhabilitarPersonal(int ced) {

        String mensaje;
        this.model = new modelDatosPersonales();
        boolean inhabilitar = model.inhabilitarPersonal(ced);
        if (inhabilitar) {
                  mensaje = new String("Actualización realizada con éxito");
		  Mensaje(mensaje,"Registro Actualizado",1);
                  view.dispose();
                           }
        else {
        mensaje = new String("No se ha podido realizar la actualización");
		  Mensaje(mensaje,"ERROR",2);
            }
    
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
