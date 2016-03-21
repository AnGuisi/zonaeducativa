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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelDatosPersonales;
import models.modelDireccion;
import models.modelEstado;
import models.modelMunicipio;
import models.modelSector;
import views.viewEditarDatosPersonal;

/**
 *
 * @author Gleycer
 */
public class controllerEditarDatosPersonal implements ActionListener{
    private modelEstado modelEstado;
    private viewEditarDatosPersonal view;
    private modelMunicipio modelMunicipio;
    private modelSector modelSector;
    private modelDireccion modelDireccion;
    private modelDatosPersonales model;
    private controllerConsultarDatosPersonal controllerConsultarDatosPersonal;

    public controllerEditarDatosPersonal(viewEditarDatosPersonal view) {
        this.view = view;
    }
    
        public void actionPerformed(ActionEvent evenDisp) {
            
      Object envDisparado = evenDisp.getSource();
      boolean validar = false;
         if (envDisparado.equals(view.getBtnEditarDatos()))
		 	{
          try {
              validar =ValidarDatos();
          } catch (ParseException ex) {
              Logger.getLogger(controllerEditarDatosPersonal.class.getName()).log(Level.SEVERE, null, ex);
          }
          if (validar == true) {
            try {
                editarDatosPersonales();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                               }
                                                                                 
                           }

         if (envDisparado.equals(view.getComboNacionalidad()))
		 	{
           
            try {
                CargarComboEstado();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                                                                                 
                           }
                        
         
            if (view.getComboEstado().getSelectedIndex()>0) {
          if (envDisparado.equals(view.getComboEstado()))
		 	{
        
        try {
             
                CargarComboMunicipio(view.getComboEstado().getSelectedItem().toString(),view.getComboMunicipio(),view.getComboSector());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                        }
                                                                          }
            else {
                view.getComboMunicipio().removeAllItems();
                view.getComboMunicipio().addItem("Seleccione");
                  }
              
           if (view.getComboMunicipio().getSelectedIndex()>0) {
          if (envDisparado.equals(view.getComboMunicipio()))
		 	{
        
        try {
             
                CargarComboSector(view.getComboMunicipio().getSelectedItem().toString(),view.getComboSector());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                         }
                                                                             }
           else {
                view.getComboSector().removeAllItems();
                view.getComboSector().addItem("Seleccione...");
                     }
                                                                           
            
               if (view.getComboEstado2().getSelectedIndex()>0) {
          if (envDisparado.equals(view.getComboEstado2()))
		 	{
        
        try {
             
                CargarComboMunicipio(view.getComboEstado2().getSelectedItem().toString(),view.getComboMunicipio2(),view.getComboSector2());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                        }
                                                                               }
                else {
                view.getComboMunicipio2().removeAllItems();
                view.getComboMunicipio2().addItem("Seleccione...");
                     }
               
                if (view.getComboMunicipio2().getSelectedIndex()>0) {
          if (envDisparado.equals(view.getComboMunicipio2()))
		 	{
        
        try {
             
                CargarComboSector(view.getComboMunicipio2().getSelectedItem().toString(),view.getComboSector2());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                         }
                                                                             }
                 else {
                view.getComboSector2().removeAllItems();
                view.getComboSector2().addItem("Seleccione...");
                     }
            
    }
    
           private void CargarComboEstado() throws SQLException {
     
     this.modelEstado = new modelEstado();
     
     
     if (view.getComboNacionalidad().getSelectedIndex() == 1) {
    
     List ListItem = modelEstado.CargarEstados();
     int i;
    if (ListItem != null) {
      view.getComboEstado().removeAllItems();
      view.getComboEstado().addItem("Seleccione...");
      view.getComboMunicipio().removeAllItems();
      view.getComboMunicipio().addItem("Seleccione...");
      view.getComboSector().removeAllItems();
      view.getComboSector().addItem("Seleccione");
      
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
    view.getComboEstado().addItem(ListItem.get(i));
                                }
                          }
                                                                            }
     else {
      view.getComboEstado().removeAllItems();
      view.getComboEstado().addItem("Otro");
      view.getComboMunicipio().removeAllItems();
      view.getComboMunicipio().addItem("Otro");
      view.getComboSector().removeAllItems();
      view.getComboSector().addItem("Otro");
          }
                   }
         
       private boolean CargarComboMunicipio(String estado, JComboBox municipio,JComboBox sector) throws SQLException {
    
    String nombre = estado;
    
     
     this.modelMunicipio = new modelMunicipio();
    
     
     int id_estado;
     boolean consulta = modelEstado.ConsultarEstadoNombre(nombre);
      
   
     if (consulta) {
       
    id_estado = modelEstado.getId_estado();
     List ListItem = modelMunicipio.CargarMunicipios(id_estado);
     int i;
    if (ListItem != null) {
      municipio.removeAllItems();
      municipio.addItem("Seleccione...");
      
      
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
      municipio.addItem(ListItem.get(i));
                                }
                          }
                   }
      
     return consulta;
     }
       
          private boolean CargarComboSector(String municipio,JComboBox sector) throws SQLException {
    
    String nombre = municipio;
   
     
     this.modelSector = new modelSector();
     this.modelMunicipio = new modelMunicipio();
     
     int id_municipio;
     boolean consulta = modelMunicipio.ConsultarMunicipioNombre(nombre);
      
   
     if (consulta) {
       
    id_municipio = modelMunicipio.getId();
     List ListItem = modelSector.CargarSectores(id_municipio);
     int i;
    if (ListItem != null) {
      sector.removeAllItems();
      sector.addItem("Seleccione...");
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
      sector.addItem(ListItem.get(i));
                                }
                          }
                   }
     else {
     System.out.println("Ha ocurrido un error");
          }
     
     return consulta;
     }
          
     public void editarDatosPersonales() throws SQLException {
    
     this.modelEstado = new modelEstado();
     this.modelMunicipio = new modelMunicipio();
     this.modelSector = new modelSector();
     
     int estado = 0, municipio = 0 , sector = 0;
     int estado_dir = 0, municipio_dir = 0, sector_dir = 0;
     int id_direccion = view.getId_direccion();
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
     String estado_str = view.getComboEstado().getSelectedItem().toString();
     modelEstado.ConsultarEstadoNombre(estado_str);
     estado = modelEstado.getId_estado();
     
     String municipio_str = view.getComboMunicipio().getSelectedItem().toString();
     modelMunicipio.ConsultarMunicipioNombre(municipio_str);
     municipio = modelMunicipio.getId();
     
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
         System.out.println(id_direccion);
     boolean editar_dir;
     if (id_direccion != 0) {
      editar_dir = modelDireccion.editarDireccion(id_direccion);
                            }
     else {
      editar_dir = modelDireccion.RegistrarDireccion();
           }
     if (editar_dir == false) {
         
                  mensaje = new String("No se ha podido editar el registro");
		  Mensaje(mensaje,"ERROR",2);
                               }

     
     else {
     if(id_direccion == 0) {
     boolean consultar_id_direccion = modelDireccion.ConsultarUltimoid();
     if(consultar_id_direccion) {
     id_direccion = modelDireccion.getId_direccion();
                                }
                           }
     this.model = new modelDatosPersonales(apellidos, nombres, tipo_personal, nacionalidad, fecha_nac, estado_civil, ced, estado, municipio, sector, id_direccion); 
     boolean editarDatosPersonales = model.editarDatosPersonales();
     if (editarDatosPersonales) {
                  

                  mensaje = new String("Actualización realizada con éxito");
		  Mensaje(mensaje,"Registro Actualizado",1);
                  view.dispose();
                  controllerConsultarDatosPersonal  controller= new controllerConsultarDatosPersonal(this);
                  controller.mostrarDatos(cedula);
                  
                                   }
     else {
         System.out.println("Error editar datos P");
                  mensaje = new String("No se ha podido realizar la actualización");
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

