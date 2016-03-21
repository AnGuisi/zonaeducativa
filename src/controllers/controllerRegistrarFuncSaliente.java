/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelBanco;
import models.modelDatosBancarios;
import models.modelFuncSaliente;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerRegistrarFuncSaliente implements ActionListener{
    viewTramitesAdministrativos view;
    modelFuncSaliente model;
    
    

    public controllerRegistrarFuncSaliente(viewTramitesAdministrativos view) {
        this.view = view;
    }

    
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        if(eventDisparado.equals(view.getBtnFuncSaliente())) {
            try {
                registrarDatosFuncSaliente();
            } catch (SQLException ex) {
                Logger.getLogger(controllerRegistrarFuncSaliente.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                
          public void registrarDatosFuncSaliente() throws SQLException {
          String mensaje = null; 
          String ced =  view.getTxtCedulaFuncSaliente();
          int cedula1 = ced.indexOf(":");
          int inicio = cedula1+1;
          int fin = ced.length();
          int cedula = Integer.parseInt(ced.substring(inicio, fin));
          int cedula_p_tramite = Integer.parseInt(view.getTxtCedula());
          String destino = view.getTxtDestinoFuncSaliente();
          String observaciones = view.getTxtObservacionesFuncSaliente();
          
          this.model = new modelFuncSaliente(cedula, cedula_p_tramite, observaciones, destino);
          boolean registrarFuncSaliente = model.registrarFuncSaliente();
          
          if(registrarFuncSaliente) {
          mensaje = new String("Registro Satisfactorio");
          Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
          view.getTabbedDocente().setSelectedIndex(4);
                                       }
          else {
          mensaje = new String("No se ha podido realizar el registro");
	  Mensaje(mensaje,"ERROR",2);
               }


                                                                        }


}
