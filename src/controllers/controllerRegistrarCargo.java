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
import models.modelCargo;
import models.modelHojaServicio;
import models.modelPlanteles;
import views.viewConsultarDatosPersonal;
import views.viewFichaPersonal;
import views.viewRegistrarCargo;

/**
 *
 * @author Gleycer
 */
public class controllerRegistrarCargo implements ActionListener{
    private viewRegistrarCargo view;
    private modelCargo modelCargo;
    private modelHojaServicio modelHojaServicio;
    private viewFichaPersonal viewFicha;
    private viewConsultarDatosPersonal viewConsulta;
    private modelPlanteles modelPlanteles;

    public void setViewConsulta(viewConsultarDatosPersonal viewConsulta) {
        this.viewConsulta = viewConsulta;
    }

    public controllerRegistrarCargo(viewRegistrarCargo view) {
        this.view = view;
    }
   
    public void setViewFicha(viewFichaPersonal viewFicha) {
        this.viewFicha = viewFicha;
    }

    
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(view.getBtnRegistrarCargo())) {
            try {
                registrarCargo();
            } catch (SQLException ex) {
                Logger.getLogger(controllerRegistrarCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                               }
    }
    
         public void registrarCargo() throws SQLException {
            
     String mensaje;
     int cedula = Integer.parseInt(view.getTxtCedula());
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Crea formato compatible con la base de datos
     String fecha_ingreso = sdf.format(view.getTxtFechaIngreso());
     String codDependencia = view.getTxtCodigoPlantel();
              
     String denCargo = view.getTxtDenominacionCargo();
             
     String codCargo = view.getTxtCodigoCargo();
     int horasD = Integer.parseInt(view.getTxtHorasD());
     int horasA = Integer.parseInt(view.getTxtHorasA());
     int sueldo = Integer.parseInt(view.getTxtSueldo());
     String asignaturas = view.getTxtAsignaturas();
     String turno = view.getComboTurno().getSelectedItem().toString();
     String compensacion = view.getTxtCompensacion();
     String asignaturas_p = view.getTxtAsignaturasP();
     String causaRetiro = "";
     String fechaTermino = "";
     this.modelPlanteles = new modelPlanteles();
     this.modelHojaServicio = new modelHojaServicio(fecha_ingreso, denCargo, codDependencia, fechaTermino,causaRetiro, compensacion,sueldo, cedula); 
     this.modelCargo = new modelCargo(denCargo,fecha_ingreso,codDependencia, codCargo, horasD, horasA, sueldo, asignaturas,turno,compensacion, asignaturas_p, cedula); 
     boolean registrarCargo = modelCargo.registrarCargo();
     if (registrarCargo) {
                  mensaje = new String("Registro Satisfactorio");
		  Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
                  modelHojaServicio.registrarHojaServicioC();
                  DefaultTableModel tablaModel = new DefaultTableModel();
                  DefaultTableModel tablaModelHojaServicio = new DefaultTableModel();
                  modelHojaServicio.listarHojaServicio(tablaModelHojaServicio, cedula);
                  modelCargo.listarCargosActualesConsulta(tablaModel,cedula);
                  if (viewFicha != null) {
                  viewFicha.getTableCargoActual().setModel(tablaModel);
                  viewFicha.getTableHojaServicio().setModel(tablaModelHojaServicio);
                                          }
                  else if (viewConsulta != null) {
                  viewConsulta.getTableCargoActual().setModel(tablaModel);
                  viewConsulta.getTableHojaServicio().setModel(tablaModelHojaServicio);
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
