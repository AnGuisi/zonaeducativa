/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelHojaServicio;
import views.viewConsultarDatosPersonal;
import views.viewFichaPersonal;
import views.viewRegistrarHojaServicio;

/**
 *
 * @author Gleycer
 */
public class controllerRegistrarHojaServicio implements ActionListener{
    viewRegistrarHojaServicio view;
    viewFichaPersonal viewFicha;
    viewConsultarDatosPersonal viewConsultarDatosPersonal;
    modelHojaServicio model;

    public void setViewConsultarDatosPersonal(viewConsultarDatosPersonal viewConsultarDatosPersonal) {
        this.viewConsultarDatosPersonal = viewConsultarDatosPersonal;
    }

    public controllerRegistrarHojaServicio(viewRegistrarHojaServicio view) {
        this.view = view;
    }

    public void setViewFicha(viewFichaPersonal viewFicha) {
        this.viewFicha = viewFicha;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(view.getBtnRegistrarHojaServicio())) {
            try {
                registrarHojaServicio();
            } catch (SQLException ex) {
                Logger.getLogger(controllerRegistrarHojaServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                      }
    }
    
             public void registrarHojaServicio() throws SQLException {
            
     String mensaje;
     int cedula = Integer.parseInt(view.getTxtCedula());
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Crea formato compatible con la base de datos
     String fechaIngreso = sdf.format(view.getTxtFechaIngreso());
     String fechaTermino = sdf.format(view.getTxtFechaTermino());
     String plantel = view.getTxtPlantel();
     String cargo = view.getTxtCargo();
     String lugar = view.getTxtLugar();
     String causaRetiro = view.getTxtCausaRetiro();
     String prima = view.getTxtPrima();
     int sueldo = Integer.parseInt(view.getTxtSueldo());
     
     this.model = new modelHojaServicio(fechaIngreso, cargo, plantel, lugar,  fechaTermino, causaRetiro, prima,sueldo, cedula); 
     boolean registrarCargo = model.registrarHojaServicio();
     if (registrarCargo) {
                  mensaje = new String("Registro Satisfactorio");
		  Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
                  DefaultTableModel tablaModel = new DefaultTableModel();
                  model.listarHojaServicio(tablaModel, cedula);
                  if (viewFicha != null) {
                  viewFicha.getTableHojaServicio().setModel(tablaModel);
                                         }
                  else if (viewConsultarDatosPersonal != null) {
                  viewConsultarDatosPersonal.getTableHojaServicio().setModel(tablaModel);
                                                               }
                  view.dispose();
                          }
     else {
                  mensaje = new String("No se ha podido realizar el registro");
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
