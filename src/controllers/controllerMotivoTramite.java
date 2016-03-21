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
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelCargo;
import models.modelCargoPropuesto;
import models.modelCargoReemplazo;
import models.modelMotivoTramite;
import models.modelTramiteAdministrativo;
import models.modelTurno;
import views.viewCambiarStatus;
import views.viewHistorialTramites;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerMotivoTramite implements ActionListener{
    viewCambiarStatus viewCambiarEstatus;
    viewTramitesAdministrativos viewRegistrarTramite;
    viewHistorialTramites historialTramites;
    modelMotivoTramite model;
    modelTramiteAdministrativo modelTramiteAdministrativo;
    private int id_tramite;
    private modelCargo modelCargo;
    private modelCargoPropuesto modelCargoPropuesto;
    private modelTurno modelTurno;
    private modelCargoReemplazo modelCargoReemplazo;

    public void setId_tramite(int id_tramite) {
        this.id_tramite = id_tramite;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        
        Object eventDisparado = e.getSource();
        if (viewCambiarEstatus != null) {
            if(eventDisparado.equals(viewCambiarEstatus.getBtnCambiarEstatus())) {
                boolean validar = validarDatos();
                if (validar) {
                try {
                    registrarMotivoTramite();
                } catch (SQLException ex) {
                    Logger.getLogger(controllerMotivoTramite.class.getName()).log(Level.SEVERE, null, ex);
                }
                             }
                                                                                 }
                                        }

                                                }

    public void setHistorialTramites(viewHistorialTramites historialTramites) {
        this.historialTramites = historialTramites;
    }

    public controllerMotivoTramite(viewCambiarStatus viewCambiarStatus) {
        this.viewCambiarEstatus = viewCambiarStatus;
    }

    public controllerMotivoTramite(viewTramitesAdministrativos viewRegistrarTramite) {
        this.viewRegistrarTramite = viewRegistrarTramite;
    }

          public void registrarMotivoTramite() throws SQLException {
          String mensaje = null; 
          String descripcion = "";
          String estatus = "";
          String tipo_motivo = "";
          Calendar fechaActual = Calendar.getInstance();
          String fecha = Integer.toString(fechaActual.get(Calendar.YEAR))+"/"+Integer.toString(fechaActual.get(Calendar.MONTH)+1)+"/"+Integer.toString(fechaActual.get(Calendar.DATE));  
          descripcion = viewCambiarEstatus.getTxtMotivoEstatus();
          estatus = viewCambiarEstatus.getComboEstatus().getSelectedItem().toString();
          tipo_motivo = "Cambio de Estatus";
                                           
          
          this.model = new modelMotivoTramite(id_tramite, fecha, descripcion, tipo_motivo,estatus);
          this.modelTramiteAdministrativo = new modelTramiteAdministrativo();
          boolean editarEstatus = modelTramiteAdministrativo.editarEstatusTramite(estatus,id_tramite);
          boolean registrarMotivo = model.registrarMotivoTramite();
          if(registrarMotivo && editarEstatus) {
          
          if (estatus.equals("Procesado")) {
          boolean consultarTramite = modelTramiteAdministrativo.consultarTramiteId(id_tramite);
          if (consultarTramite) {
          switch (modelTramiteAdministrativo.getTipoMovimiento()) {
              case "Traslado":
                  Calendar fecha_ingr = Calendar.getInstance();
                  String fecha_ingreso = Integer.toString(fechaActual.get(Calendar.YEAR))+"-"+Integer.toString(Calendar.MONTH)+"-"+Integer.toString(Calendar.DAY_OF_MONTH);
                  int idCargoPropuesto = modelTramiteAdministrativo.getId_cargo_propuesto();
                  this.modelCargoReemplazo = new modelCargoReemplazo();
                  boolean consultarCargosaReemplazar = modelCargoReemplazo.consultarCargoReemplazo(idCargoPropuesto);
                  Vector<Integer> id_cargo = new Vector<Integer>();
                  id_cargo = modelCargoReemplazo.getId_cargo();
                  System.out.println(id_cargo);
                  this.modelCargoPropuesto = new modelCargoPropuesto();
                  boolean consultarCargoPropuesto = modelCargoPropuesto.consultarCargoPropuesto(modelTramiteAdministrativo.getCedula());
                  String denCargo = modelCargoPropuesto.getDcargo();
                  String codDependencia = modelCargoPropuesto.getCdependencia();
                  String codCargo = modelCargoPropuesto.getCcargo();
                  int horasD = modelCargoPropuesto.getHd();
                  int horasA = modelCargoPropuesto.getHa();
                  
                  int sueldo = Integer.parseInt(modelCargoPropuesto.getSueldo());
                  String asignaturas = modelCargoPropuesto.getAsignatura();
                  int id_turno = modelCargoPropuesto.getTurno();
                  this.modelTurno = new modelTurno();
                  modelTurno.consultarTurno(id_turno);
                  String turno = modelTurno.getTurno();
                  String asignaturas_p = "";
                  String compensacion = "";
                  int cedula = modelTramiteAdministrativo.getCedula();
                  this.modelCargo = new modelCargo(denCargo,fecha_ingreso,codDependencia, codCargo, horasD, horasA, sueldo, asignaturas,turno,compensacion, asignaturas_p, cedula);
                  
                  boolean eliminarCargo = modelCargo.eliminarCargo(id_cargo);
                  if (eliminarCargo) {
                  boolean registrarCargo =  modelCargo.registrarCargo();
                  if(registrarCargo) {
                  mensaje = new String("Datos de trámite modificados satisfactoriamente");
                  Mensaje(mensaje,"Datos de trámite modificados",1);
                                     }
                                      }
                  break;
          
                                                                  }
                                }
                                      }    

          mensaje = new String("Registro Satisfactorio");
          Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
          viewCambiarEstatus.dispose();
          historialTramites.dispose();
          new viewHistorialTramites(new javax.swing.JFrame(), true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
                                      }
                              
          else {
              mensaje = new String("No se ha podido realizar el registro");
	      Mensaje(mensaje,"ERROR",2);
               }
          
          
          
                                                 }
    
             public boolean validarDatos() {
             boolean validar = true; 
             String motivo = viewCambiarEstatus.getTxtMotivoEstatus().trim();
 
             if (motivo.equals("")) {
             Mensaje("Ingrese Motivo", "¡ERROR!", 2);
             validar = false;
                                    }
             else if (viewCambiarEstatus.getComboEstatus().getSelectedIndex() == 0) {
             Mensaje("Seleccione Estatus", "¡ERROR!", 2);
             validar = false;
                                   
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
            
            private void modificarDatos() {
            
                                          }

}
