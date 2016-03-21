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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelBanco;
import models.modelCargo;
import models.modelCargoPropuesto;
import models.modelCargoReemplazo;
import models.modelDatosBancarios;
import models.modelDatosPersonales;
import models.modelDireccion;
import models.modelEstado;
import models.modelMunicipio;
import models.modelSector;
import models.modelSuperior;
import models.modelTramiteAdministrativo;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerTramitesAdministrativos implements ActionListener{
   viewTramitesAdministrativos viewTramites;
   modelDatosPersonales modelDatosPersonales;
    private modelEstado modelEstado;
    private modelMunicipio modelMunicipio;
    private modelSector modelSector;
    private modelDireccion modelDireccion;
    private modelCargo modelCargo;
    private modelDatosBancarios modelDatosBancarios;
    private modelBanco modelBanco;
    private modelTramiteAdministrativo modelTramiteAdministrativo;
    private modelCargoPropuesto modelCargoPropuesto;
    private modelCargoReemplazo modelCargoReemplazo;
    private modelSuperior modelSuperior;
    

    public controllerTramitesAdministrativos(viewTramitesAdministrativos viewTramites) {
        this.viewTramites = viewTramites;
    }

   
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(viewTramites.getBtnConsultar())) {
            boolean verificarPersonal = false;
            try {
                verificarPersonal = consultarTramiteExistente(viewTramites.getTxtDatos());
            } catch (SQLException ex) {
                Logger.getLogger(controllerTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (verificarPersonal) {
               viewTramites.reestablecerCampos();
            try {
                consultarDatosPersonal(viewTramites.getTxtDatos());
            } catch (SQLException ex) {
                Logger.getLogger(controllerTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                  } }
        else if (eventDisparado.equals(viewTramites.getBtnFinalizarTramite())) {
            try {
                registrarTramite();
            } catch (SQLException ex) {
                Logger.getLogger(controllerTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                               }
                else if (eventDisparado.equals(viewTramites.getBtnConsultarDatosFuncSaliente())) {
            try {
                consultarFuncSaliente(viewTramites.getTxtCedulaFuncSaliente());
            } catch (SQLException ex) {
                Logger.getLogger(controllerTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                               }
    }
    
    public boolean consultarDatosPersonal(String ced) throws SQLException {  
    String cedula=null;
    int cedula2 = 0;
    String mensaje;
    String direccion=null;   
    String estado = null,municipio = null,sector = null,estado2 = null,municipio2 = null,sector2 = null;
    String sueldo = null,carga_horaria = null,codCargo = null,denCargo = null,denPlantel = null;
    String numeroCuenta= null, nombreBanco= null;
    this.modelDatosPersonales = new modelDatosPersonales();
    this.modelEstado = new modelEstado();
    this.modelMunicipio = new modelMunicipio();
    this.modelSector = new modelSector();
    this.modelDireccion = new modelDireccion();
    this.modelCargo = new modelCargo();
    this.modelDatosBancarios = new modelDatosBancarios();
    this.modelBanco = new modelBanco();
    this.modelSuperior = new modelSuperior();


    int cedula1 = ced.indexOf(":");
    int inicio = cedula1+1;
    int fin = ced.length();
    cedula = ced.substring(inicio, fin);
       try{
     cedula2 = Integer.parseInt(cedula); 
    }catch(NumberFormatException ex){ // handle your exception
       
    }
    boolean consulta = modelDatosPersonales.ConsultarDatosPersonales(cedula2);
     
     if (consulta) {
         
             if(modelDatosPersonales.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
             else {
    Date date = modelDatosPersonales.getFecha_nac_salida();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
    String fecha_nac = sdf.format(date);
         boolean consulta_cargo = modelCargo.consultarCargoActual(Integer.parseInt(cedula));
          
         if(consulta_cargo) {            
                  DefaultTableModel tablaModel = new DefaultTableModel() {
 
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class,
            };
 
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };;
         modelCargo.listarCargosActuales(tablaModel,Integer.parseInt(cedula));
         if (tablaModel.getRowCount() != 0) {
         viewTramites.getTableCargoActual().setModel(tablaModel); 
                                            }
                            }  
         
         boolean consultaDatosBancarios = modelDatosBancarios.consultarDatosBancarios(Integer.parseInt(cedula));
         if (consultaDatosBancarios) {
         boolean consultaBanco = modelBanco.consutarBancoNombre(modelDatosBancarios.getId_banco());
         if(consultaBanco) {
         numeroCuenta = modelDatosBancarios.getNumero_cuenta();
         nombreBanco = modelBanco.getNombre();
                           }
                                      }

         boolean consulta_estado = modelEstado.ConsultarEstadoId(modelDatosPersonales.getEstado());
         if (consulta_estado) {
                estado = modelEstado.getNombre();
                         }
          boolean consulta_municipio = modelMunicipio.ConsultarMunicipioId(modelDatosPersonales.getMunicipio());
         if (consulta_municipio) {
                municipio = modelMunicipio.getNombre();
                         }
         boolean consulta_sector = modelSector.ConsultarSectorId(modelDatosPersonales.getSector());
         if (consulta_sector) {
                sector = modelSector.getNombre();
                         }
         boolean consulta_direccion = modelDireccion.ConsultarDireccionId(modelDatosPersonales.getDireccion());
         if (consulta_direccion) {
                direccion = modelDireccion.getDireccion();
                modelEstado.ConsultarEstadoId(modelDireccion.getEstado());
                estado2 = modelEstado.getNombre();
                modelMunicipio.ConsultarMunicipioId(modelDireccion.getMunicipio());
                municipio2 = modelMunicipio.getNombre();
                modelSector.ConsultarSectorId(modelDireccion.getSector());
                
                sector2 = modelSector.getNombre();
                                 }
          boolean consultarSuperior = modelSuperior.consultarSuperior(Integer.parseInt(cedula));
          if (consultarSuperior) {
                viewTramites.setTxtInstitucion(modelSuperior.getNombres());
                viewTramites.setTxtAñoInicio(modelSuperior.getFechaDesdeS());
                viewTramites.setTxtTitulo(modelSuperior.getTituloS());
                                 }
                  viewTramites.setTxtCedula(cedula);
		  viewTramites.setTxtTipoPersonal(modelDatosPersonales.getTipo_personal());
                  viewTramites.setTxtNombre(modelDatosPersonales.getNombres());
                  viewTramites.setTxtEstadoCivil(modelDatosPersonales.getEstado_civil());
                  viewTramites.setTxtApellidos(modelDatosPersonales.getApellidos());
                  viewTramites.setTxtNacionalidad(modelDatosPersonales.getNacionalidad());
                  viewTramites.setTxtFechaNac(fecha_nac);
                  viewTramites.setTxtNacionalizado(modelDatosPersonales.getNacionalizado());
                  viewTramites.setTxtEstado(estado);
                  viewTramites.setTxtMunicipio(municipio);
                  viewTramites.setTxtSector(sector);
                  viewTramites.setTxtDireccion(direccion);
                  viewTramites.setTxtEstado1(estado2);
                  viewTramites.setTxtMunicipio1(municipio2);
                  viewTramites.setTxtSector1(sector2);

                  viewTramites.setTxtNumeroCuenta(numeroCuenta);
                  viewTramites.getComboBanco().setSelectedItem(nombreBanco);
             }   
        
     }
     else {
      boolean consultaDatosBasicos = modelDatosPersonales.ConsultarDatosPersonalesBasicos(Integer.parseInt(cedula));
     
         
      if (consultaDatosBasicos) {
          
          if(modelDatosPersonales.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
          else {
         boolean consulta_cargo = modelCargo.consultarCargoActual(Integer.parseInt(cedula));
         
         if(consulta_cargo) {            
                  DefaultTableModel tablaModel = new DefaultTableModel() {
 
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,java.lang.Object.class, java.lang.Object.class,java.lang.Object.class, java.lang.Boolean.class,
            };
 
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };;
         modelCargo.listarCargosActuales(tablaModel,Integer.parseInt(cedula));
         if (tablaModel.getRowCount() != 0) {
         viewTramites.getTableCargoActual().setModel(tablaModel); 
                                            }
                            }
         boolean consultaDatosBancarios = modelDatosBancarios.consultarDatosBancarios(Integer.parseInt(cedula));
         if (consultaDatosBancarios) {
         boolean consultaBanco = modelBanco.consutarBancoNombre(modelDatosBancarios.getId_banco());
         if(consultaBanco) {
         numeroCuenta = modelDatosBancarios.getNumero_cuenta();
         nombreBanco = modelBanco.getNombre();
                           }
                                      }
                  viewTramites.setTxtCedula(cedula);
                  viewTramites.setTxtNombre(modelDatosPersonales.getNombres());
                  viewTramites.setTxtNacionalidad(modelDatosPersonales.getNacionalidad());
             
                  viewTramites.setTxtNumeroCuenta(numeroCuenta);
                  viewTramites.getComboBanco().setSelectedItem(nombreBanco);
          }
                                }
                else
  
     
	  {	  mensaje = new String("No se han encontrado resultados"); // else consulta
                  
		  Mensaje(mensaje,"No se han encontrado resultados",1); }
          }
             // }

     return consulta;
                    
                       }
    
    public void registrarTramite() throws SQLException {
    String mensaje;
    Calendar fechaActual = Calendar.getInstance();
    int idDia = fechaActual.get(Calendar.DAY_OF_MONTH);
    int idMes = fechaActual.get(Calendar.MONTH)+1;
    int numeroQuincena=0;
    if (idDia <=15) {
    numeroQuincena = idMes*2-1;
                    }
    else {
    numeroQuincena = idMes*2;
         }
    String fechaPreparacion = Integer.toString(fechaActual.get(Calendar.YEAR))+"-"+Integer.toString(idMes)+"-"+Integer.toString(idDia);  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date fechaEfectoC = viewTramites.getTxtFechaEfecto();
    String fechaEfecto = sdf.format(fechaEfectoC);
    String municipio = viewTramites.getComboMunicipio().getSelectedItem().toString();
    String motivo = viewTramites.getTxtMotivoTramite();
    this.modelMunicipio = new modelMunicipio();
    modelMunicipio.ConsultarMunicipioNombre(municipio);
    int id_municipio = modelMunicipio.getId();
    String numeroZonaEducativa = viewTramites.getTxtNumeroZonaEducativa();
    int cedula = Integer.parseInt(viewTramites.getTxtCedula());
    String cargoAdicional;
    if (viewTramites.getCheckCargoAdicional().isSelected()) {
    cargoAdicional = "Si";
                                                            }
    else {
    cargoAdicional = "No";
         }
    String tipoMovimiento = viewTramites.getComboTipoTramite().getSelectedItem().toString();
    this.modelTramiteAdministrativo = new modelTramiteAdministrativo (fechaPreparacion,fechaEfecto,id_municipio,numeroQuincena,cedula, tipoMovimiento, numeroZonaEducativa, cargoAdicional,motivo);
    boolean registrarTramite = modelTramiteAdministrativo.registrarTramiteAdministrativo();
    if(registrarTramite) {
    viewTramites.reestablecerFinalizarTramite();
    mensaje = new String("Registro realizado satisfactoriamente");
    Mensaje(mensaje,"Resgistro Realizado",1);  
                         }
    else {
    mensaje = new String("No se ha podido realizar el registro"); // else consulta
    Mensaje(mensaje,"No se ha podido realizar el registro",2);
         }
                                   }
    
    private boolean consultarTramiteExistente(String ced) throws SQLException {
    int cedula1 = ced.indexOf(":");
    int inicio = cedula1+1;
    int fin = ced.length();
    String cedula = ced.substring(inicio, fin);
    String mensaje;
    this.modelTramiteAdministrativo = new modelTramiteAdministrativo();
    boolean verificarPersonal = modelTramiteAdministrativo.consultarTramiteExistente(Integer.parseInt(cedula));
    if (verificarPersonal) {
    int seleccion = JOptionPane.showOptionDialog(
   null,
   "¡Ya existe un trámite registrado con esta cédula!, ¿desea visualizar los datos del mismo?",
   "Salir",
   JOptionPane.YES_NO_CANCEL_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,    // null para icono por defecto.
   null,   // null para YES, NO y CANCEL
   null);
 if (seleccion != -1)
    if(seleccion + 1 == 1) {
       controllerConsultarTramite c = new controllerConsultarTramite();
       c.verTramite(cedula);
       viewTramites.dispose();
       return false;
                            }
    else {
    viewTramites.setTxtDatos("");
    viewTramites.getDatos().requestFocus();
         }
                           }
       return true;
                                                    }

    
        public void deshacerCambios() throws SQLException {
            
        String mensaje;
        this.modelCargoPropuesto = new modelCargoPropuesto();
        this.modelDatosBancarios = new modelDatosBancarios();
        this.modelCargoReemplazo = new modelCargoReemplazo();

        String cedula = viewTramites.getTxtCedula();
        int ced = Integer.parseInt(cedula);
        modelCargoPropuesto.consultarCargoPropuesto(ced);
        int id_cargo_propuesto = modelCargoPropuesto.getId_cargo_propuesto();
        modelCargoReemplazo.deshacerCambios(id_cargo_propuesto);
        modelDatosBancarios.deshacerCambios(ced);
        modelCargoPropuesto.deshacerCambios(ced);


                                      }
        
    private boolean consultarFuncSaliente(String ced) throws SQLException {
        System.out.println(ced);
    int cedula1 = ced.indexOf(":");
    int inicio = cedula1+1;
    int fin = ced.length();
    String cedula = ced.substring(inicio, fin);
        System.out.println(cedula);
    String mensaje;
    this.modelDatosPersonales = new modelDatosPersonales();
    this.modelCargo = new modelCargo();
    boolean consultarDatosPersonales = modelDatosPersonales.ConsultarDatosPersonales(Integer.parseInt(cedula));
    if (consultarDatosPersonales) {
        System.out.println(consultarDatosPersonales);
     DefaultTableModel tablaModel = new DefaultTableModel();
    modelCargo.listarCargosActualesConsulta(tablaModel,Integer.parseInt(cedula));
    if (tablaModel.getRowCount() != 0) {
    viewTramites.getTableCargoFuncSaliente().setModel(tablaModel); 
                                       }
       viewTramites.setTxtApellidosNombreFuncSaliente(modelDatosPersonales.getNombres()+ ' '+modelDatosPersonales.getApellidos());
                           }
    else {
     boolean consultaDatosBasicos = modelDatosPersonales.ConsultarDatosPersonalesBasicos(Integer.parseInt(cedula));
     if (consultaDatosBasicos) {
          DefaultTableModel tablaModel = new DefaultTableModel();
    modelCargo.listarCargosActualesConsulta(tablaModel,Integer.parseInt(cedula));
    if (tablaModel.getRowCount() != 0) {
    viewTramites.getTableCargoFuncSaliente().setModel(tablaModel); 
                                       }
       viewTramites.setTxtApellidosNombreFuncSaliente(modelDatosPersonales.getNombres()+ ' '+modelDatosPersonales.getApellidos());
                               }
         }
       return true;
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
