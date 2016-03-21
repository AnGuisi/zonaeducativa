/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelCargoPropuesto;
import models.modelCargoReemplazo;
import models.modelTurno;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerCargoPropuesto implements ActionListener{
    viewTramitesAdministrativos view;
    modelCargoPropuesto modelCargoPropuesto;
    modelTurno modelTurno;
    private modelCargoReemplazo modelCargoReemplazo;

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(view.getBtnCargoPropuesto())) {
           Vector<Integer> id_cargo=new Vector<Integer>();
            boolean validar = false;
            validar = validarDatos();
            if (validar == true) {
                int cantidadFilas = view.getTableCargoActual().getRowCount(); // Cantidad total de filas
                System.out.println(cantidadFilas);
                for (int i = 0; i<cantidadFilas;i++) { // Recorremos las filas para verificar cual en cuales de ellas el check está TRUE
                    System.out.println(i);
                    boolean check = (Boolean) view.getTableCargoActual().getValueAt(i, 6);
                    System.out.println(check);

               if (check == true) {
                    id_cargo.add(Integer.parseInt(view.getTableCargoActual().getValueAt(i,0).toString()));  // Si el check esta TRUE agregamos al array el id del cargo
                    
                                   }
                        
                                                    }
            try {
                registrarCargoPropuesto(id_cargo);
            } catch (SQLException ex) {
                Logger.getLogger(controllerCargoPropuesto.class.getName()).log(Level.SEVERE, null, ex);
            }
                                 }
                                                               }
    }

    public controllerCargoPropuesto(viewTramitesAdministrativos view) {
        this.view = view;
    }
    
              public void registrarCargoPropuesto(Vector id_cargo) throws SQLException {
          String mensaje = null; 
          String ccargo=view.getTxtCodCargo(), dcargo=view.getTxtDenCargo(), cdependencia=view.getTxtCodPlantel(), titulo=view.getTxtTituloObtenido(), asignatura=view.getTxtAsignatura(), tipo_nombr=null;
          int ha=Integer.parseInt(view.getTxtHorasA()), hd=Integer.parseInt(view.getTxtHorasD()),cedula=Integer.parseInt(view.getTxtCedula()), turno;
          String dtitular=null, x_interino=null, w_interino=null, horas_variables=null, bono_bol=null, nturno=null;
          String codigo_nomina = view.getTxtCodigoNomina(), grado = view.getTxtGrado(), paso = view.getTxtPaso(), sueldo = view.getTxtSueldoMensual();
          
          if(view.getRadioBtnDiurno().isSelected()==true) {
            if (view.getCheckDTitular().isSelected()) {
            dtitular = "Si";
                                                    }
            else if (view.getCheckXInterino().isSelected()) {
            x_interino = "Si";
                                                          }
            else if (view.getCheckWInterino().isSelected()){
            w_interino = "Si";
                                                         }
            else if (view.getCheckHorasVariables().isSelected()){
            horas_variables= "Si";
                                                               }
            else if (view.getCheckBonoBolivariano().isSelected()){
            bono_bol= "Si";
                                                               }

            nturno = "Diurno";
                                                          }
          else if (view.getRadioBtnNocturno().isSelected()==true) {
             if(view.getCheckDTitularNoc().isSelected()){
             dtitular = "Si";
                                                        }
             else if(view.getCheckXInterino().isSelected()){
             x_interino = "Si";
                                                           }
             else if(view.getCheckWInterino().isSelected()){
             w_interino = "Si";
                                                           }
             nturno = "Nocturno";
                                                                   }
          
          this.modelTurno = new modelTurno(dtitular,x_interino,w_interino,horas_variables,bono_bol,nturno);
          boolean registrarTurno = modelTurno.registrarTurno();
          if (registrarTurno) {
          boolean consultaIdTurno = modelTurno.consultarUltimoid();
          turno = modelTurno.getId_turno();

          this.modelCargoPropuesto= new modelCargoPropuesto(ccargo, dcargo, cdependencia, titulo, asignatura, tipo_nombr, codigo_nomina, grado, paso, sueldo, ha, hd, cedula, turno);
          boolean registrarCargoPropuesto = modelCargoPropuesto.registrarCargo();
          if(registrarCargoPropuesto) {
          modelCargoPropuesto.consultarUltimoid();
          this.modelCargoReemplazo = new modelCargoReemplazo();
          modelCargoReemplazo.registrarCargoReemplazo(id_cargo, modelCargoPropuesto.getId_cargo_propuesto());
          mensaje = new String("Registro Satisfactorio");
          Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
          view.getTabbedDocente().setSelectedIndex(2);
          view.reestablecerCargoPropuesto();
                  }
                              }
          else {
              mensaje = new String("No se ha podido realizar el registro");
	      Mensaje(mensaje,"ERROR",2);
               }
          
          
          
                                                 }
    
             public boolean validarDatos() {
             boolean validar = true;
      
             if (view.getTabbedCargo().isEnabledAt(1) == false) {
               view.getTabbedDocente().setSelectedIndex(2);
               validar = true;
                                                                }
             else {
       String codDependencia = view.getTxtCodPlantel().trim();
       String nombrePlantel = view.getTxtNombrePlantel().trim();
       String codCargo = view.getTxtCodCargo().trim();
       String denCargo = view.getTxtDenCargo().trim();
       String tituloObt = view.getTxtTituloObtenido().trim();
       String asig = view.getTxtAsignatura().trim();
       String horasD = view.getTxtHorasD().trim();
       String horasA = view.getTxtHorasA().trim();
       String codNomina = view.getTxtCodigoNomina().trim();
       String grado = view.getTxtGrado().trim();
       String paso = view.getTxtPaso().trim();
       String sueldoMensual = view.getTxtSueldoMensual().trim();
       int totalHoras = 0;
       if (view.getTxtTotalHoras().trim() != "") {
       totalHoras = Integer.parseInt(view.getTxtTotalHoras());
                                                 }
       
            if (codDependencia.equals("")) {
                Mensaje("Seleccione una Dependencia", "¡ERROR!", 2);
                validar = false;
                                           }
            else if (codCargo.equals("")) {
                 Mensaje("Seleccione un Cargo", "¡ERROR!", 2);
                validar = false;
                                           }
                        else if (tituloObt.equals("")) {
                 Mensaje("Ingrese Título Obtenido o Profesión", "¡ERROR!", 2);
                validar = false;
                                           }
                        else if (asig.equals("")) {
                 Mensaje("Ingrese Asignatura(s)", "¡ERROR!", 2);
                validar = false;
                                           }
                        else if (horasD.equals("")) {
                 Mensaje("Ingrese Horas Docentes", "¡ERROR!", 2);
                validar = false;
                                           }
                        else if (horasA.equals("")) {
                 Mensaje("Ingrese Horas Administrativas", "¡ERROR!", 2);
                validar = false;
                                           }
                        else if (totalHoras > 36 || totalHoras == 0) {
                 Mensaje("El total de horas no puede ser mayor a 36 o igual a 0", "¡ERROR!", 2);
                validar = false;
                                           }
                        else if (view.getRadioBtnFijo().isSelected() == false && view.getRadioBtnInt().isSelected() == false) {
                 Mensaje("Seleccione Tipo Nombr", "¡ERROR!", 2);
                validar = false;
                                           }
                                    else if (view.getRadioBtnDiurno().isSelected() == false && view.getRadioBtnNocturno().isSelected() == false) {
                 Mensaje("Seleccione Turno", "¡ERROR!", 2);
                validar = false;
                                           }
                  else if (view.getTxtTipoPersonal().equals("Docente") == false) {
                   if (codNomina.equals("")) {
                 Mensaje("Ingrese Código de Nómina", "¡ERROR!", 2);
                validar = false;
                                             }
                  if (grado.equals("")) {
                 Mensaje("Ingrese Grado", "¡ERROR!", 2);
                validar = false;
                                             }
                  else if (paso.equals("")) {
                 Mensaje("Ingrese Paso", "¡ERROR!", 2);
                validar = false;
                                             }
                  else if (sueldoMensual.equals("")) {
                 Mensaje("Ingrese Sueldo Mensual", "¡ERROR!", 2);
                validar = false;
                                             }
                                                                                 }
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
