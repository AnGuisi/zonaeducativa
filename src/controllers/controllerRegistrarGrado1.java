/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.modelExtranjero;
import models.modelMedia;
import models.modelPrimaria;
import models.modelSuperior;
import views.viewFichaPersonal;

/**
 *
 * @author Gleycer
 */
public class controllerRegistrarGrado1 implements ActionListener{
    viewFichaPersonal viewFicha;
    modelPrimaria  modelP;
    private modelMedia modelM;
    private modelSuperior modelS;
    private modelExtranjero modelE;


    public controllerRegistrarGrado1(viewFichaPersonal viewFicha) {
        this.viewFicha = viewFicha;
    }
    

    @Override
    public void actionPerformed(ActionEvent evenDisp) {
        Object eventDisparado = evenDisp.getSource();
        
         if(eventDisparado.equals(viewFicha.getBtnRegistrarGrado1())) {
            boolean validar = false;
            try {
                validar = validarDatos();
            } catch (ParseException ex) {
                Logger.getLogger(controllerRegistrarGrado1.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (validar) {
        registrarGrado1();
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
            
         public void registrarGrado1() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Crea formato compatible con la base de datos
            String mensaje;
            String cedula = viewFicha.getTxtCedula();
            
            // PRIMARIA
            int ced = Integer.parseInt(cedula);
            String nombreP = viewFicha.getTxtNombrePrimaria();
            String lugarP = viewFicha.getTxtLugarPrimaria();
            String codigoP = viewFicha.getTxtCodigoPrimaria();   
            String fechaDesdeP = sdf.format(viewFicha.getTxtFechaDesdeP());
            String fechaHastaP = sdf.format(viewFicha.getTxtFechaHastaP());
            this.modelP = new modelPrimaria(nombreP, lugarP,  codigoP, fechaDesdeP,fechaHastaP, ced);
            boolean registrarPrimaria = modelP.registrarPrimaria();
            if (registrarPrimaria) {
            // SECUNDARIA
            
            String nombreM = viewFicha.getTxtNombreMedia();
            String lugarM = viewFicha.getTxtLugarMedia();
            String codigoM = viewFicha.getTxtCodigoMedia();   
            String fechaDesdeM = sdf.format(viewFicha.getTxtFechaDesdeM());
            String fechaHastaM = sdf.format(viewFicha.getTxtFechaHastaM());

            String añosCursadosM = viewFicha.getComboAñosCursadosM().getSelectedItem().toString();
            String aprobadosM = viewFicha.getComboAñosGraduadosM().getSelectedItem().toString();
            
            this.modelM = new modelMedia(nombreM, lugarM, codigoM, fechaDesdeM, fechaHastaM, añosCursadosM, aprobadosM, ced);
            boolean registrarMedia = modelM.registrarDatosPersonales();
            if (registrarMedia) {
             // SUPERIOR
            
            String codigoS = viewFicha.getTxtCodigoSuperior();
            String nombreS = viewFicha.getTxtNombreSuperior();
            String lugarS = viewFicha.getTxtLugarSuperior();
            String tituloS = viewFicha.getTxtTituloSuperior();
            String fechaDesdeS;
            fechaDesdeS = sdf.format(viewFicha.getTxtFechaDesdeS());
            String graduado = viewFicha.getComboGraduadoS().getSelectedItem().toString();
            String anosCursados = viewFicha.getComboAñosCursadosS().getSelectedItem().toString();
            
            this.modelS = new modelSuperior(nombreS, fechaDesdeS, lugarS, tituloS, anosCursados, codigoS, graduado,ced);
            boolean registrarSuperior = modelS.registrarSuperior(); 
            if (registrarSuperior) {
             // Extranjero
            if(viewFicha.getCheckGraduadoEx().isSelected()) {  
            String titulo_ex = viewFicha.getTxtTituloEx();
            String pais = viewFicha.getComboPaisInstruccionEx().getSelectedItem().toString();
            String duracion_ex = viewFicha.getTxtDuracionEx();
            String postgradoex = viewFicha.getTxtPostGrado();
                        
            this.modelE = new modelExtranjero(titulo_ex,pais, duracion_ex,  postgradoex, ced);
            boolean registrarExtranjero = modelE.registrarExtranjero();
            if (registrarExtranjero) {
            mensaje = new String("Registro Satisfactorio");
            Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
            //viewFicha.reestablecerCamposGrado1();
                                    }
            else {
             mensaje = new String("No se ha podido realizar el registro");
             Mensaje(mensaje,"ERROR",2);
            
            //Fin Extranjero
         }
                                                            }
            else {
            mensaje = new String("Registro Satisfactorio");
            Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
                  }
                                    }
            else {
             mensaje = new String("No se ha podido realizar el registro");
             Mensaje(mensaje,"ERROR",2);
                 }
            //Fin Superior
                                    }
            else {
             mensaje = new String("No se ha podido realizar el registro");
             Mensaje(mensaje,"ERROR",2);
                 }
            //FIN MEDIA
                                    }
            else {
             mensaje = new String("No se ha podido realizar el registro");
             Mensaje(mensaje,"ERROR",2);
                 }
            
            // FIN PRIMARIA

           }
         
                public boolean validarDatos() throws ParseException {
       boolean validar = true;
       
       
       
       
       Date fechaActual = new Date(); // Fecha actual del sistema 
       Date fechaDesdeP = viewFicha.getTxtFechaDesdeP();
       Date fechaHastaP = viewFicha.getTxtFechaHastaP();
       Date fechaDesdeM = viewFicha.getTxtFechaDesdeM();
       Date fechaHastaM = viewFicha.getTxtFechaHastaM();
       Date fechaDesdeS = viewFicha.getTxtFechaDesdeS();
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       
      
            if (viewFicha.getTxtFechaDesdeP()==null) {
                Mensaje("Ingrese Fecha desde Primaria", "¡ERROR!", 2);
                validar = false;
                                                                         }
            else if (viewFicha.getTxtFechaHastaP()==null) {
                Mensaje("Ingrese Fecha hasta Primaria", "¡ERROR!", 2);
                validar = false;
                                                                         }
            else if (viewFicha.getTxtFechaDesdeM()==null) {
                Mensaje("Ingrese Fecha desde Secundaria", "¡ERROR!", 2);
                validar = false;
                                                                         }
            else if (viewFicha.getTxtFechaHastaM()==null) {
                Mensaje("Ingrese Fecha hasta Secundaria", "¡ERROR!", 2);
                validar = false;
                                                                         }
            else if (viewFicha.getTxtFechaDesdeS()==null) {
                Mensaje("Ingrese Fecha Inicio Superior", "¡ERROR!", 2);
                validar = false;
                                                                         }
            else if(viewFicha.getFechaDesdeP().getCalendar().get(Calendar.YEAR)<1900) {
                Mensaje("Fecha desde Primaria Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                                              }
            else if(viewFicha.getFechaHastaP().getCalendar().get(Calendar.YEAR)<1900) {
                Mensaje("Fecha desde Hasta Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                                              }
            else if(viewFicha.getFechaDesdeM().getCalendar().get(Calendar.YEAR)<1900) {
                Mensaje("Fecha desde Media Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                                              }
            else if(viewFicha.getFechaHastaM().getCalendar().get(Calendar.YEAR)<1900) {
                Mensaje("Fecha hasta Media Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                                              }
            else if(viewFicha.getFechaDesdeS().getCalendar().get(Calendar.YEAR)<1900) {
                Mensaje("Fecha Inicio Superior Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                                              }
           
            else if (fechaActual.before(fechaDesdeP)) {
                Mensaje("Fecha desde Primaria Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                    }
            else if (fechaActual.before(fechaHastaP)) {
                Mensaje("Fecha hasta Primaria Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                    }
            else if (fechaActual.before(fechaDesdeM)) {
                Mensaje("Fecha desde Secundaria Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                    }
            else if (fechaActual.before(fechaHastaM)) {
                Mensaje("Fecha hasta Secundaria Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                    }
            else if (fechaActual.before(fechaDesdeS)) {
                Mensaje("Fecha Inicio Superior Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                    }
          
           
            
            else {
                validar = true;
                   }
         return validar;
   }
         
}

