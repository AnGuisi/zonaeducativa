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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelDatosPersonales;
import models.modelDireccion;
import models.modelEstado;
import models.modelMunicipio;
import models.modelSector;
import views.viewConsultarDatosPersonal;
import views.viewFichaPersonal;

/**
 *
 * @author Gleycer
 */
public class controllerDatosPersonales implements ActionListener{
    viewFichaPersonal view;
    viewConsultarDatosPersonal viewConsultarDatosPersonal;
    modelDatosPersonales model;
    private modelDireccion modelDireccion;
    private modelEstado modelEstado;
    private modelMunicipio modelMunicipio;
    private modelSector modelSector;

    public controllerDatosPersonales(viewFichaPersonal view) {
        this.view = view;
    }
    
    
        public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
        
        if (envDisparado.equals(view.getBtnDatosPersonales())) {
            boolean valida = false;
            try {
                valida = ValidarDatos();
            } catch (ParseException ex) {
                Logger.getLogger(controllerDatosPersonales.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (valida) {
            try {
                RegistrarDatosPersonales();
            } catch (SQLException ex) {
                Logger.getLogger(controllerDatosPersonales.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        
     public void RegistrarDatosPersonales() throws SQLException {
     
     this.modelEstado = new modelEstado();
     this.modelMunicipio = new modelMunicipio();
     this.modelSector = new modelSector();
     
     int estado = 0, municipio = 0 , sector = 0, id_direccion = 0;
     int estado_dir = 0, municipio_dir = 0, sector_dir = 0;
     String mensaje;
     String direccion = view.getTxtDireccion();
     String nacionalidad = view.getComboNacionalidad().getSelectedItem().toString();
     String apellidos = view.getTxtApellidos();
     String nombres = view.getTxtNombres();
     String tipo_personal = view.getComboTipoPersonal().getSelectedItem().toString();
     String estado_civil = view.getComboEstadoCivil().getSelectedItem().toString();
     String cedula = view.getTxtCedula();
     int ced = Integer.parseInt(cedula);
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Crea formato compatible con la base de datos
     String fecha_nac = sdf.format(view.getTxtFechaNac());
     if(view.getComboEstado().getSelectedIndex()>0) {
     String estado_str = view.getComboEstado().getSelectedItem().toString();
     modelEstado.ConsultarEstadoNombre(estado_str);
     estado = modelEstado.getId_estado();
                                                     }
     if(view.getComboMunicipio().getSelectedIndex()>0){
     String municipio_str = view.getComboMunicipio().getSelectedItem().toString();
     modelMunicipio.ConsultarMunicipioNombre(municipio_str);
     municipio = modelMunicipio.getId();
                                                      }
     
     if (view.getComboSector().getEditor().getItem().toString().equals("") != false) {
                                                                              } else {
         String sector_str = view.getComboSector().getSelectedItem().toString();
         boolean consultarSect = modelSector.ConsultarSectorNombre(sector_str);
         if (consultarSect) {
             sector = modelSector.getId();
         }
         else { // Si no encuentra id_sector asignado al sector seleccionado o introducido procede a realizar el registro de un nuevo sector
             String nuevo_sect = view.getComboSector().getEditor().getItem().toString(); // Obtiene lo ingresado en el ComboBox editable
             
             modelSector.RegistrarSector(nuevo_sect,municipio);
             boolean consulta_nuevo_sect = modelSector.ConsultarSectorNombre(nuevo_sect);
             if (consulta_nuevo_sect) {
                 
                 sector = modelSector.getId();
                 
             }
         }
        }
     
     String estado_str_dir = view.getComboEstado2().getSelectedItem().toString();
     modelEstado.ConsultarEstadoNombre(estado_str_dir);
     estado_dir = modelEstado.getId_estado();
     
     String municipio_str_dir = view.getComboMunicipio2().getSelectedItem().toString();
     modelMunicipio.ConsultarMunicipioNombre(municipio_str_dir);
     municipio_dir = modelMunicipio.getId();
     
     String sector_str_dir = view.getComboSector2().getSelectedItem().toString();
     boolean consultarSector = modelSector.ConsultarSectorNombre(sector_str_dir);
     if (consultarSector) {
     sector_dir = modelSector.getId();
                          }
          else { // Si no encuentra id_sector asignado al sector seleccionado o introducido procede a realizar el registro de un nuevo sector
     String nuevo_sector = view.getComboSector2().getEditor().getItem().toString(); // Obtiene lo ingresado en el ComboBox editable
     
     modelSector.RegistrarSector(nuevo_sector,municipio_dir);
     boolean consulta_nuevo_sector = modelSector.ConsultarSectorNombre(nuevo_sector);
       if (consulta_nuevo_sector) {
     sector_dir = modelSector.getId();
    
                          } 
          }
     
     this.modelDireccion = new modelDireccion(direccion,estado_dir,municipio_dir,sector_dir);
     boolean registrar_dir = modelDireccion.RegistrarDireccion();
     if (registrar_dir == false) {
                  mensaje = new String("No se ha podido realizar el registro");
		  Mensaje(mensaje,"ERROR",2);
                                 }
     else {
     modelDireccion.ConsultarUltimoid();
     id_direccion = modelDireccion.getId_direccion();
     
     this.model = new modelDatosPersonales(apellidos, nombres, tipo_personal, nacionalidad, fecha_nac, estado_civil, ced, estado, municipio, sector, id_direccion); 
     boolean registrarDatosPersonales = model.RegistrarDatosPersonales();
     if (registrarDatosPersonales) {
                  mensaje = new String("Registro Satisfactorio");
		  Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
                  view.reestablecerCampos();
                  view.setLabelNombre(nombres);
                  view.setLabelApellido(apellidos);
                  view.setLabelCedula(cedula);
                                   }
     else {
                  mensaje = new String("No se ha podido realizar el registro");
		  Mensaje(mensaje,"ERROR",2);
          }
           }
                                                 }
     
       public boolean ValidarDatos() throws ParseException {
       boolean validar = true;
       String cedula = view.getTxtCedula().trim();
       String nombre = view.getTxtNombres().trim();
       String apellido = view.getTxtApellidos().trim();
       String direccion = view.getTxtDireccion().trim();
       Date fechaDate1 = new Date(); // Fecha actual del sistema 
       Date fechaDate2 = view.getTxtFechaNac(); // Fecha del formulario
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       String fechaForm = formato.format(fechaDate2);
       int edad = edad(fechaForm);
         
            if (cedula.equals("")) {
                Mensaje("Ingrese Cédula", "¡ERROR!", 2);
                validar = false;
            } else if (view.getTxtCedula().length() < 6) {
                Mensaje("Cédula Incorrecta", "¡ERROR!", 2);
                validar = false;
            } else if (view.getTxtCedula().length() > 8) {
                Mensaje("Cédula Incorrecta", "¡ERROR!", 2);
                validar = false;
            }
            else if (nombre.length() <= 3) {
                Mensaje("El campo (Nombres) debe poseer mas de 3 carácteres", "¡ERROR!", 2);
                validar = false;
                                          }
            else if (nombre.equals("")) {
                Mensaje("Ingrese Nombres", "¡ERROR!", 2);
                validar = false;
                                        }
            else if (apellido.length() <= 3) {
                Mensaje("El campo (Apellidos) debe poseer mas de 3 carácteres", "¡ERROR!", 2);
                validar = false;
                                          }
            else if (apellido.equals("")) {
                Mensaje("Ingrese Apellidos", "¡ERROR!", 2);
                validar = false;
                                          }
            else if (view.getComboTipoPersonal().getSelectedIndex() == 0) {
                Mensaje("Seleccione Tipo de Personal", "¡ERROR!", 2);
                validar = false;
                                                                          }

            else if (view.getComboNacionalidad().getSelectedIndex() == 0) {
                Mensaje("Seleccione Nacionalidad", "¡ERROR!", 2);
                validar = false;
                                                                                           }
            else if (view.getComboNacionalidad().getSelectedIndex() != 2) {
            if (view.getComboEstado().getSelectedIndex() == 0) {
                Mensaje("Seleccione Estado", "¡ERROR!", 2);
                validar = false;
                                                                                           }
            else if (view.getComboMunicipio().getSelectedIndex() == 0) {
                Mensaje("Seleccione Municipio", "¡ERROR!", 2);
                validar = false;
                                                                                         }
            else if (view.getComboSector().getSelectedItem().equals("")) {
                Mensaje("Seleccione o Ingrese Sector", "¡ERROR!", 2);
                validar = false;
                                                                         }
             else if (view.getComboSector().getSelectedItem().equals("Seleccione...")) {
                Mensaje("Seleccione o Ingrese Sector", "¡ERROR!", 2);
                validar = false;
                                                                         }
             else if (view.getComboSector().getSelectedItem().toString().length()>45) {
                Mensaje("Sector Incorrecto", "¡ERROR!", 2);
                validar = false;
                                                                                      }
            }
            if (view.getTxtFechaNac()==null) {
                Mensaje("Ingrese Fecha de Nacimiento", "¡ERROR!", 2);
                validar = false;
                                                                         }
            else if(view.getFechaNac().getCalendar().get(Calendar.YEAR)<1900) {
                Mensaje("Fecha de Nacimiento Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                                              }
           
            else if (fechaDate1.before(fechaDate2)) {
                Mensaje("Fecha de Nacimiento Incorrecta", "¡ERROR!", 2);
                validar = false;
                                                    }
            else if (edad <18) {
                Mensaje("Debe ser mayor de edad (+18)", "¡ERROR!", 2);
                validar = false;
                               }
                 else if (view.getComboEstadoCivil().getSelectedIndex() == 0) {
                Mensaje("Seleccione Estado Civil", "¡ERROR!", 2);
                validar = false;
                                                                                            }
                else if (direccion.equals("")) {
                Mensaje("Ingrese Dirección", "¡ERROR!", 2);
                validar = false;
                                           }
             else if (view.getComboEstado2().getSelectedIndex() == 0) {
                Mensaje("Seleccione Estado", "¡ERROR!", 2);
                validar = false;
                                                                                           }
            else if (view.getComboMunicipio2().getSelectedIndex() == 0) {
                Mensaje("Seleccione Municipio", "¡ERROR!", 2);
                validar = false;
                                                                                         }
            else if (view.getComboSector2().getSelectedItem().equals("")) {
                Mensaje("Seleccione o Ingrese Sector", "¡ERROR!", 2);
                validar = false;
                                                                                            }
                        else if (view.getComboSector2().getSelectedItem().equals("Seleccione...")) {
                Mensaje("Seleccione o Ingrese Sector", "¡ERROR!", 2);
                validar = false;
                                                                                            }
                                     else if (view.getComboSector2().getSelectedItem().toString().length()>45) {
                Mensaje("Sector Incorrecto", "¡ERROR!", 2);
                validar = false;
                                                                                      }
           
            
            else {
                validar = true;
                   }
         return validar;
   }
       
       public int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
   
    Date fechaActual = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String hoy = formato.format(fechaActual);
    String[] dat1 = fecha_nac.split("/");
    String[] dat2 = hoy.split("/");
    int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
    if (mes < 0) {
      anos = anos - 1;
    } else if (mes == 0) {
      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
      if (dia > 0) {
        anos = anos - 1;
      }
    }
    return anos;
  }

             
                public static List CargarPersonal() throws SQLException {
    
         modelDatosPersonales model = new modelDatosPersonales();
         
         return model.CargarPersonal();
}

}