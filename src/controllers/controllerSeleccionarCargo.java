/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelCargo;
import views.viewRegistrarCargo;
import views.viewRegistrarHojaServicio;
import views.viewSeleccionarCargo;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerSeleccionarCargo implements ActionListener {
private viewSeleccionarCargo viewSeleccionarCargo;
private viewRegistrarCargo viewRegistrarCargo;
private viewRegistrarHojaServicio viewRegistrarHojaServicio;
private viewTramitesAdministrativos viewTramites;

    private modelCargo modelCargo;

    public void setViewTramites(viewTramitesAdministrativos viewTramites) {
        this.viewTramites = viewTramites;
    }

    public controllerSeleccionarCargo(viewSeleccionarCargo viewSeleccionarCargo) {
        this.viewSeleccionarCargo = viewSeleccionarCargo;
    }

    public void setViewRegistrarCargo(viewRegistrarCargo viewRegistrarCargo) {
        this.viewRegistrarCargo = viewRegistrarCargo;
    }

    public void setViewRegistrarHojaServicio(viewRegistrarHojaServicio viewRegistrarHojaServicio) {
        this.viewRegistrarHojaServicio = viewRegistrarHojaServicio;
    }

    
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        boolean valida = false;
    try {
        valida= validarDatos();
    } catch (ParseException ex) {
        Logger.getLogger(controllerSeleccionarCargo.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(valida == true) {
        
        if(eventDisparado.equals(viewSeleccionarCargo.getBtnAgregarCargo())) {
           if(viewRegistrarCargo != null) {
           viewRegistrarCargo.setTxtCodigoCargo(viewSeleccionarCargo.getTxtCodigoCargo());
           viewRegistrarCargo.setTxtDenominacionCargo(viewSeleccionarCargo.getComboDenCargo().getSelectedItem().toString());
           viewSeleccionarCargo.dispose();
                                          }
           else if(viewRegistrarHojaServicio != null) {
           viewRegistrarHojaServicio.setTxtCodigoCargo(viewSeleccionarCargo.getTxtCodigoCargo());
           viewRegistrarHojaServicio.setTxtDenominacionCargo(viewSeleccionarCargo.getComboDenCargo().getSelectedItem().toString());
           viewSeleccionarCargo.dispose();
                                          }
           else  if(viewTramites != null) {
           viewTramites.setTxtCodCargo(viewSeleccionarCargo.getTxtCodigoCargo());
           viewTramites.setTxtDenCargo(viewSeleccionarCargo.getComboDenCargo().getSelectedItem().toString());
           viewSeleccionarCargo.dispose();
                                          }
                                                                              }
                            }
        
                                               }
    

    
     public static List cargarDenCargo() throws SQLException {
    
         modelCargo model = new modelCargo();
         
    return model.cargarDenCargo();
    
                                                              }
     
            public boolean validarDatos() throws ParseException {
             boolean validar = true;
             String codCargo = viewSeleccionarCargo.getTxtCodigoCargo();
             int length = codCargo.length();
             char[ ] c = new char[length];
             
             for (int i=0;i<length;i++) {
             c[i] = codCargo.charAt(i);
                 
                                          }


            if (viewSeleccionarCargo.getComboDenCargo().getSelectedIndex() == 0) {
                Mensaje("Seleccione o Ingrese Denominación de Cargo", "¡ERROR!", 2);
                validar = false;
                                                                                 }
            else if(viewSeleccionarCargo.getComboDenCargo().getEditor().getItem()==null) {
                Mensaje("Seleccione o Ingrese Denominación de Cargo", "¡ERROR!", 2);
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
