/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelCargo;
import models.modelDatosPersonales;
import models.modelDireccion;
import models.modelEstado;
import models.modelHojaServicio;
import models.modelMunicipio;
import models.modelPlanteles;
import models.modelSector;
import views.viewConsultarDatosPersonal;
import views.viewEditarDatosPersonal;
import views.viewFichaPersonal;

/**
 *
 * @author Gleycer
 */
public class controllerConsultarDatosPersonal implements ActionListener{
    
    
    private viewConsultarDatosPersonal viewConsultarDatosPersonal;
    private viewFichaPersonal viewFichaPersonal;
    private viewEditarDatosPersonal viewEditarDatosPersonal;
    private modelCargo modelCargoActual;
    private modelDireccion modelDireccion;
    private modelEstado modelEstado;
    private modelMunicipio modelMunicipio;
    private modelSector modelSector;
    private modelPlanteles modelPrimaria;
    private modelDatosPersonales model;
    private modelHojaServicio modelHojaServicio;
    private controllerEditarDatosPersonal controllerEditar;
    private controllerListarPersonal controllerListarPersonal;
    private java.awt.Frame parent;

    public controllerConsultarDatosPersonal(controllerEditarDatosPersonal controllerEditar) {
        this.controllerEditar = controllerEditar;
    }

    public controllerConsultarDatosPersonal(viewFichaPersonal viewFichaPersonal) {
        this.viewFichaPersonal = viewFichaPersonal;
    }

    public controllerConsultarDatosPersonal(viewEditarDatosPersonal viewEditarDatosPersonal) {
        this.viewEditarDatosPersonal = viewEditarDatosPersonal;
    }

    public controllerConsultarDatosPersonal(controllerListarPersonal controllerListarPersonal) {
        this.controllerListarPersonal = controllerListarPersonal;
    }
    

    public controllerConsultarDatosPersonal(viewConsultarDatosPersonal viewConsultarDatosPersonal) {
        this.viewConsultarDatosPersonal = viewConsultarDatosPersonal;
    }

    public void setParent(Frame parent) {
        this.parent = parent;
    }
    
    

    @Override
            public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
        boolean valida = false;
        if (envDisparado.equals(viewConsultarDatosPersonal.getBtnConsultar())) {
            try {
                valida = ValidarDatos();
            } catch (ParseException ex) {
                Logger.getLogger(controllerConsultarDatosPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (valida) {
                viewConsultarDatosPersonal.reestablecerCampos();
            try {
                ConsultarDatosPersonal(viewConsultarDatosPersonal.getTxtDatos());
            } catch (SQLException ex) {
                Logger.getLogger(controllerDatosPersonales.class.getName()).log(Level.SEVERE, null, ex);
            }
                        }
                                                                               }
        if (envDisparado.equals(viewConsultarDatosPersonal.getBtnEditar())) {
            
         int seleccion = JOptionPane.showOptionDialog(
   null,
   "¿Está seguro de proceder a la edición de datos?",
   "Aviso",
   JOptionPane.YES_NO_CANCEL_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,    // null para icono por defecto.
   null,   // null para YES, NO y CANCEL
   null);
 if (seleccion != -1)
   if(seleccion + 1 == 1) {
                         try {
                enviarEditar();
                             } catch (ParseException ex) {
                Logger.getLogger(controllerConsultarDatosPersonal.class.getName()).log(Level.SEVERE, null, ex);
                                                         } catch (SQLException ex) {
                 Logger.getLogger(controllerConsultarDatosPersonal.class.getName()).log(Level.SEVERE, null, ex);
             }
                          }
   if (seleccion + 1 == 2 || seleccion +1 == 3) {        
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
        
        public boolean verificarPersona(String ced) throws SQLException {
        this.model = new modelDatosPersonales();
        ced = ced.trim();
        if (!ced.equals("")) {
        boolean consulta = model.ConsultarDatosPersonales(Integer.parseInt(ced));
        if (consulta) {
         return true;
                      }
        else {
              boolean consultaDatosBasicos = model.ConsultarDatosPersonalesBasicos(Integer.parseInt(ced));
      if (consultaDatosBasicos) {
          
          return true;
          } 
              else {
        return false;
             }
             }
        }
              return false;                  

                                                                         }
        
        public void enviarEditar() throws ParseException, SQLException {
            System.out.println(viewConsultarDatosPersonal.getTxtFechaNac());
        viewConsultarDatosPersonal.dispose();
        viewEditarDatosPersonal view = new viewEditarDatosPersonal(parent,true);
        view.setTxtCedula(viewConsultarDatosPersonal.getTxtCedula());
        view.setTxtApellidos(viewConsultarDatosPersonal.getTxtApellidos());
        view.setTxtNombres(viewConsultarDatosPersonal.getTxtNombre());
        view.setTxtDireccion(viewConsultarDatosPersonal.getTxtDireccion());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        if (viewConsultarDatosPersonal.getTxtFechaNac() != "") {
        Date date = formatter.parse(viewConsultarDatosPersonal.getTxtFechaNac());
        view.setTxtFechaNac(date);
                                                                 }
        view.setTxtNacionalizado(viewConsultarDatosPersonal.getTxtNacionalizado());
        view.getComboEstadoCivil().setSelectedItem(viewConsultarDatosPersonal.getTxtEstadoCivil());
        view.getComboNacionalidad().setSelectedItem(viewConsultarDatosPersonal.getTxtNacionalidad());
        view.getComboTipoPersonal().setSelectedItem(viewConsultarDatosPersonal.getTxtTipoPersonal());
        view.getComboEstado().setSelectedItem(viewConsultarDatosPersonal.getTxtEstado());
        view.getComboMunicipio().setSelectedItem(viewConsultarDatosPersonal.getTxtMunicipio());
        view.getComboSector().setSelectedItem(viewConsultarDatosPersonal.getTxtSector());
        view.getComboEstado2().setSelectedItem(viewConsultarDatosPersonal.getTxtEstado1());
        view.getComboMunicipio2().setSelectedItem(viewConsultarDatosPersonal.getTxtMunicipio1());
        view.getComboSector2().setSelectedItem(viewConsultarDatosPersonal.getTxtSector1());
        view.setId_direccion(viewConsultarDatosPersonal.getId_direccion());
        
        view.setVisible(true);
        
                                                          }
        
        public boolean ConsultarDatosPersonal(String ced) throws SQLException {
            
    String cedula=null;
    String mensaje;
    String direccion=null;   
    String estado = null,municipio = null,sector = null,estado2 = null,municipio2 = null,sector2 = null;
    this.model = new modelDatosPersonales();
    this.modelEstado = new modelEstado();
    this.modelMunicipio = new modelMunicipio();
    this.modelSector = new modelSector();
    this.modelDireccion = new modelDireccion();
    this.modelCargoActual = new modelCargo();
    this.modelHojaServicio = new modelHojaServicio();
    this.modelPrimaria = new modelPlanteles();
           

    int cedula1 = ced.indexOf(":");
    int inicio = cedula1+1;
    int fin = ced.length();
    cedula = ced.substring(inicio, fin);
    DefaultTableModel tablaModel = new DefaultTableModel();
    modelCargoActual.listarCargosActualesConsulta(tablaModel,Integer.parseInt(cedula));
    if (tablaModel.getRowCount() != 0) {
    viewConsultarDatosPersonal.getTableCargoActual().setModel(tablaModel); 
                            }
    DefaultTableModel tablaModelHojaServicio = new DefaultTableModel();
    modelHojaServicio.listarHojaServicio(tablaModelHojaServicio,Integer.parseInt(cedula));
    if (tablaModelHojaServicio.getRowCount() != 0) {
    viewConsultarDatosPersonal.getTableHojaServicio().setModel(tablaModelHojaServicio); 
                            } 

     boolean consulta = model.ConsultarDatosPersonales(Integer.parseInt(cedula));
   
     if (consulta) {
         
             if(model.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
             else {
         
            Date date = model.getFecha_nac_salida();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            String fecha_nac = sdf.format(date);            
     
         boolean consulta_estado = modelEstado.ConsultarEstadoId(model.getEstado());
         if (consulta_estado) {
                estado = modelEstado.getNombre();
                         }
          boolean consulta_municipio = modelMunicipio.ConsultarMunicipioId(model.getMunicipio());
         if (consulta_municipio) {
                municipio = modelMunicipio.getNombre();
                         }
         boolean consulta_sector = modelSector.ConsultarSectorId(model.getSector());
         if (consulta_sector) {
                sector = modelSector.getNombre();
                         }
         boolean consulta_direccion = modelDireccion.ConsultarDireccionId(model.getDireccion());
         if (consulta_direccion) {
                direccion = modelDireccion.getDireccion();
                modelEstado.ConsultarEstadoId(modelDireccion.getEstado());
                estado2 = modelEstado.getNombre();
                modelMunicipio.ConsultarMunicipioId(modelDireccion.getMunicipio());
                municipio2 = modelMunicipio.getNombre();
                modelSector.ConsultarSectorId(modelDireccion.getSector());
                
                sector2 = modelSector.getNombre();
                                 }
                  
                  viewConsultarDatosPersonal.setTxtCedula(cedula);
		  viewConsultarDatosPersonal.setTxtTipoPersonal(model.getTipo_personal());
                  viewConsultarDatosPersonal.setTxtNombre(model.getNombres());
                  viewConsultarDatosPersonal.setTxtEstadoCivil(model.getEstado_civil());
                  viewConsultarDatosPersonal.setTxtApellidos(model.getApellidos());
                  viewConsultarDatosPersonal.setTxtNacionalidad(model.getNacionalidad());
                  viewConsultarDatosPersonal.setTxtFechaNac(fecha_nac);
                  viewConsultarDatosPersonal.setTxtNacionalizado(model.getNacionalizado());
                  viewConsultarDatosPersonal.setTxtEstado(estado);
                  viewConsultarDatosPersonal.setTxtMunicipio(municipio);
                  viewConsultarDatosPersonal.setTxtSector(sector);
                  viewConsultarDatosPersonal.setTxtDireccion(direccion);
                  viewConsultarDatosPersonal.setTxtEstado1(estado2);
                  viewConsultarDatosPersonal.setTxtMunicipio1(municipio2);
                  viewConsultarDatosPersonal.setTxtSector1(sector2);
                  viewConsultarDatosPersonal.setId_direccion(model.getDireccion());
             }   
        
     }
     else {
      boolean consultaDatosBasicos = model.ConsultarDatosPersonalesBasicos(Integer.parseInt(cedula));
         System.out.println(model.getNombres());
         
      if (consultaDatosBasicos) {
          
          if(model.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
          else {
                 viewConsultarDatosPersonal.setTxtCedula(cedula);
                  viewConsultarDatosPersonal.setTxtNombre(model.getNombres());
                  viewConsultarDatosPersonal.setTxtNacionalidad(model.getNacionalidad());
          }
                                }
                else
  
     
	  {	  mensaje = new String("No se han encontrado resultados"); // else consulta
                  
		  Mensaje(mensaje,"No se han encontrado resultados",1); }
          }
             // }

     return consulta;
                    
                       }
        
     public boolean mostrarDatos(String ced) throws SQLException {
    String cedula=null;
    String mensaje;
    String direccion=null;   
    String estado = null,municipio = null,sector = null,estado2 = null,municipio2 = null,sector2 = null;
    this.model = new modelDatosPersonales();
    this.modelEstado = new modelEstado();
    this.modelMunicipio = new modelMunicipio();
    this.modelSector = new modelSector();
    this.modelDireccion = new modelDireccion();
    this.modelCargoActual = new modelCargo();
    this.modelHojaServicio = new modelHojaServicio();
    this.modelPrimaria = new modelPlanteles();
    this.viewConsultarDatosPersonal = new viewConsultarDatosPersonal(null,true);

    
    int cedula1 = ced.indexOf(":");
    int inicio = cedula1+1;
    int fin = ced.length();
    cedula = ced.substring(inicio, fin);
    DefaultTableModel tablaModel = new DefaultTableModel();
    modelCargoActual.listarCargosActuales(tablaModel,Integer.parseInt(cedula));
    
    if (tablaModel.getRowCount() != 0) {
    
    viewConsultarDatosPersonal.getTableCargoActual().setModel(tablaModel); 
  
                                       }
        DefaultTableModel tablaModelHojaServicio = new DefaultTableModel();
    modelHojaServicio.listarHojaServicio(tablaModelHojaServicio,Integer.parseInt(cedula));
    if (tablaModelHojaServicio.getRowCount() != 0) {
    viewConsultarDatosPersonal.getTableHojaServicio().setModel(tablaModelHojaServicio); 
                            }
                                        

     boolean consulta = model.ConsultarDatosPersonales(Integer.parseInt(cedula));
   
     if (consulta) {
         
             if(model.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
             else {
         
                    
        Date date = model.getFecha_nac_salida();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        String fecha_nac = sdf.format(date);
         boolean consulta_estado = modelEstado.ConsultarEstadoId(model.getEstado());
         if (consulta_estado) {
                estado = modelEstado.getNombre();
                         }
          boolean consulta_municipio = modelMunicipio.ConsultarMunicipioId(model.getMunicipio());
         if (consulta_municipio) {
                municipio = modelMunicipio.getNombre();
                         }
         boolean consulta_sector = modelSector.ConsultarSectorId(model.getSector());
         if (consulta_sector) {
                sector = modelSector.getNombre();
                         }
         boolean consulta_direccion = modelDireccion.ConsultarDireccionId(model.getDireccion());
         if (consulta_direccion) {
                direccion = modelDireccion.getDireccion();
                modelEstado.ConsultarEstadoId(modelDireccion.getEstado());
                estado2 = modelEstado.getNombre();
                modelMunicipio.ConsultarMunicipioId(modelDireccion.getMunicipio());
                municipio2 = modelMunicipio.getNombre();
                modelSector.ConsultarSectorId(modelDireccion.getSector());
                
                sector2 = modelSector.getNombre();
                                 }

                  viewConsultarDatosPersonal.setTxtCedula(cedula);
		  viewConsultarDatosPersonal.setTxtTipoPersonal(model.getTipo_personal());
                  viewConsultarDatosPersonal.setTxtNombre(model.getNombres());
                  viewConsultarDatosPersonal.setTxtEstadoCivil(model.getEstado_civil());
                  viewConsultarDatosPersonal.setTxtApellidos(model.getApellidos());
                  viewConsultarDatosPersonal.setTxtNacionalidad(model.getNacionalidad());
                  viewConsultarDatosPersonal.setTxtFechaNac(fecha_nac);
                  viewConsultarDatosPersonal.setTxtNacionalizado(model.getNacionalizado());
                  viewConsultarDatosPersonal.setTxtEstado(estado);
                  viewConsultarDatosPersonal.setTxtMunicipio(municipio);
                  viewConsultarDatosPersonal.setTxtSector(sector);
                  viewConsultarDatosPersonal.setTxtDireccion(direccion);
                  viewConsultarDatosPersonal.setTxtEstado1(estado2);
                  viewConsultarDatosPersonal.setTxtMunicipio1(municipio2);
                  viewConsultarDatosPersonal.setTxtSector1(sector2);
                  viewConsultarDatosPersonal.setId_direccion(model.getDireccion());
                  viewConsultarDatosPersonal.setVisible(true);
             }   
        
     }
     else {
      boolean consultaDatosBasicos = model.ConsultarDatosPersonalesBasicos(Integer.parseInt(cedula));

      if (consultaDatosBasicos) {
          
          if(model.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
          else {
                 
                 viewConsultarDatosPersonal.setTxtCedula(cedula);
                  viewConsultarDatosPersonal.setTxtNombre(model.getNombres());
                  viewConsultarDatosPersonal.setTxtNacionalidad(model.getNacionalidad());
                  viewConsultarDatosPersonal.setVisible(true);
          }
                                }
                else
  
     
	  {	  mensaje = new String("No se han encontrado resultados"); // else consulta
                  
		  Mensaje(mensaje,"No se han encontrado resultados",1); }
          }
             // }

     return consulta;
                       }
                 
                 
       public boolean ValidarDatos() throws ParseException {
           
                boolean validar = true;
            if (viewConsultarDatosPersonal.getComboTipoBusqueda().getSelectedIndex() == 0) {
                Mensaje("Seleccione Tipo de Búsqueda", "¡ERROR!", 2);
                validar = false;
                                                                                           }
            if (viewConsultarDatosPersonal.getComboTipoBusqueda().getSelectedIndex() == 1) {
                if(viewConsultarDatosPersonal.getTxtDatos().length() < 6) {
                Mensaje("La cédula debe ser mayor a 6 dígitos", "¡ERROR!", 2);
                validar = false;
                                                                          }
                                                                                           }
            if (viewConsultarDatosPersonal.getComboTipoBusqueda().getSelectedIndex() == 2) {
                if(viewConsultarDatosPersonal.getTxtDatos().length() < 3) {
                Mensaje("El nombre debe poseer mas de 3 carácteres", "¡ERROR!", 2);
                validar = false;
                                                                          }
                                                                                           }
           
            
            else {
                validar = true;
                   }
         return validar;
   }
}
