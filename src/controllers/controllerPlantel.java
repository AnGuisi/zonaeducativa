/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelPlanteles;
import views.viewCatalagoPlanteles;
import views.viewFichaPersonal;
import views.viewRegistrarCargo;
import views.viewRegistrarHojaServicio;
import views.viewRegistrarInstitutoPrimaria;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerPlantel implements ActionListener{
    private modelPlanteles model;
    private viewFichaPersonal view;
    private viewRegistrarCargo viewCargo;
    private viewRegistrarInstitutoPrimaria viewRegistrarPrimaria;
    private viewRegistrarHojaServicio viewRegistrarHojaServicio;
    private viewTramitesAdministrativos viewTramitesAdministrativos;
    private viewCatalagoPlanteles viewCatalagoPlanteles;
    private String fNombre;

    public void setViewTramitesAdministrativos(viewTramitesAdministrativos viewTramitesAdministrativos) {
        this.viewTramitesAdministrativos = viewTramitesAdministrativos;
    }

    public controllerPlantel(viewCatalagoPlanteles viewCatalagoPlanteles, String fNombre) {
        this.viewCatalagoPlanteles = viewCatalagoPlanteles;
        this.fNombre = fNombre;
    }

    public void setViewRegistrarHojaServicio(viewRegistrarHojaServicio viewRegistrarHojaServicio) {
        this.viewRegistrarHojaServicio = viewRegistrarHojaServicio;
    }


    public controllerPlantel(viewCatalagoPlanteles viewCatalagoPlanteles) {
        this.viewCatalagoPlanteles = viewCatalagoPlanteles;
    }

    public controllerPlantel(viewFichaPersonal view) {
        this.view = view;
    }

    public void setView(viewFichaPersonal view) {
        this.view = view;
    }

    public void setViewCargo(viewRegistrarCargo viewCargo) {
        this.viewCargo = viewCargo;
    }
    
    

        public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
       
       
       
        if (envDisparado.equals(viewCatalagoPlanteles.getBtnSeleccionar())) {
        
        int filaSeleccionada=viewCatalagoPlanteles.getTablePrimarias().getSelectedRow();
        String codigo = viewCatalagoPlanteles.getTablePrimarias().getValueAt(filaSeleccionada, 0).toString();
        String nombre = viewCatalagoPlanteles.getTablePrimarias().getValueAt(filaSeleccionada, 1).toString();
           if (view != null) {
            if(fNombre.equals("Primaria")) {
            view.setTxtCodigoPrimaria(codigo);
            view.setTxtNombrePrimaria(nombre);
            viewCatalagoPlanteles.setVisible(false);
                                           }
            if(fNombre.equals("Media")){
            view.setTxtCodigoMedia(codigo);
            view.setTxtNombreMedia(nombre);
            viewCatalagoPlanteles.setVisible(false);
                                            }
            if(fNombre.equals("Superior")){
            view.setTxtCodigoSuperior(codigo);
            view.setTxtNombreSuperior(nombre);
            viewCatalagoPlanteles.setVisible(false);
                                            }
                            }
        else if(viewCargo != null) {
             viewCargo.setTxtCodigoPlantel(codigo);
             viewCargo.setTxtNombrePlantel(nombre);
             viewCatalagoPlanteles.setVisible(false);
                                   }
        else if(viewRegistrarHojaServicio != null) {
             viewRegistrarHojaServicio.setTxtCodigoPlantel(codigo);
             viewRegistrarHojaServicio.setTxtNombrePlantel(nombre);
             viewCatalagoPlanteles.setVisible(false);
                                                   }
        else if(viewTramitesAdministrativos != null) {
             viewTramitesAdministrativos.setTxtCodPlantel(codigo);
             viewTramitesAdministrativos.setTxtNombrePlantel(nombre);
             viewCatalagoPlanteles.setVisible(false);
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
              
}
