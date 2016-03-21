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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelCargoPropuesto;
import models.modelInasistencia;
import models.modelTurno;
import views.viewFichaPersonal;
import views.viewRegistrarInasistencia;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerInasistencias implements ActionListener{
    viewRegistrarInasistencia viewRegistrarInasistencia;
    viewFichaPersonal viewFichaPersonal;
    modelInasistencia model;

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(viewRegistrarInasistencia.getBtnRegistrarInasistencia())) {
            try {
                registrarInasistencia();
            } catch (SQLException ex) {
                Logger.getLogger(controllerInasistencias.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                            }
    }

    public void setViewFichaPersonal(viewFichaPersonal viewFichaPersonal) {
        this.viewFichaPersonal = viewFichaPersonal;
    }

    public controllerInasistencias(viewRegistrarInasistencia viewRegistrarInasistencia) {
        this.viewRegistrarInasistencia = viewRegistrarInasistencia;
    }

    
          public void registrarInasistencia() throws SQLException {
          
          String mensaje = null; 
          int ced = Integer.parseInt(viewRegistrarInasistencia.getTxtCedula());
          String motivo = viewRegistrarInasistencia.getTxtCausaMotivo();
          Date fechaD = viewRegistrarInasistencia.getTxtFecha();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Crea formato compatible con la base de datos
          String fecha = sdf.format(fechaD);
          
          String justificacion ="";
          if(viewRegistrarInasistencia.getRadioBtnInjustificada().isSelected()) {
          justificacion = "Injustificada";
                                                                                }
          else if (viewRegistrarInasistencia.getRadioBtnJustificada().isSelected()) {
          justificacion = "Justificada";
                                                                                    }
          this.model = new modelInasistencia(ced, motivo, justificacion, fecha);
          boolean registrarInasistencia = model.registrarInasistencia();
                   if(registrarInasistencia) {
          mensaje = new String("Registro Satisfactorio");
          Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
          DefaultTableModel tableModel = new DefaultTableModel();
          model.listarInasistencias(tableModel, ced);
          viewFichaPersonal.getTableInasistencias().setModel(tableModel);
          viewRegistrarInasistencia.dispose();
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
