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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelBanco;
import models.modelCargo;
import models.modelCargoPropuesto;
import models.modelDatosBancarios;
import models.modelDatosPersonales;
import models.modelDireccion;
import models.modelEstado;
import models.modelFuncSaliente;
import models.modelMotivoTramite;
import models.modelMunicipio;
import models.modelSector;
import models.modelSuperior;
import models.modelTramiteAdministrativo;
import models.modelTurno;
import views.viewHistorialTramites;
import views.viewVerTramite;

/**
 *
 * @author Gleycer
 */
public class controllerConsultarTramite implements ActionListener{
    viewHistorialTramites viewTramites;
    viewVerTramite viewVerTramite;
    modelDatosPersonales modelDatosPersonales;
    private modelEstado modelEstado;
    private modelTramiteAdministrativo modelTramiteAdministrativo;
    private modelMunicipio modelMunicipio;
    private modelSector modelSector;
    private modelDireccion modelDireccion;
    private modelCargo modelCargoActual;
    private modelCargoPropuesto modelCargoPropuesto;
    private modelTurno modelTurno;
    private modelDatosBancarios modelDatosBancarios;
    private modelBanco modelBanco;
    private modelMotivoTramite modelMotivoTramite;
    private modelFuncSaliente modelFuncSaliente;
    private modelSuperior modelSuperior;

    public controllerConsultarTramite(viewHistorialTramites viewTramites) {
        this.viewTramites = viewTramites;
    }

    controllerConsultarTramite() {
        
    }

    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        
        if(eventDisparado.equals(viewTramites.getBtnConsultar())) {
            viewTramites.reestablecerTable();
            try {
                consultarTramite(viewTramites.getTxtDatos());
            } catch (SQLException ex) {
                Logger.getLogger(controllerConsultarTramite.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                   }
        if(eventDisparado.equals(viewTramites.getBtnSeleccionar())) {
            int filaSeleccionada=viewTramites.getTableHistorialTramites().getSelectedRow();
            String cedula = viewTramites.getTableHistorialTramites().getValueAt(filaSeleccionada, 2).toString();
            try {
                verTramite(cedula);
            } catch (SQLException ex) {
                Logger.getLogger(controllerConsultarTramite.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                    }

    }
    
    public boolean consultarTramite(String ced) throws SQLException {
    String cedula=null;
    String mensaje;
    String nombreBanco= null;
    this.modelDatosPersonales = new modelDatosPersonales();
    int cedula1 = ced.indexOf(":");
    int inicio = cedula1+1;
    int fin = ced.length();
    cedula = ced.substring(inicio, fin);

     boolean consulta = modelDatosPersonales.ConsultarDatosPersonales(Integer.parseInt(cedula));
     
     if (consulta) {
         
             if(modelDatosPersonales.getStatus().equals("Inhabilitado")) {
                 mensaje = new String("Registro inhabilitado");
		 Mensaje(mensaje,"Resgistro Inhabilitado",2);  
                                                       }
             else {
                 this.modelTramiteAdministrativo = new modelTramiteAdministrativo();
                 viewTramites.reestablecerTable();
                 DefaultTableModel tableModel = new DefaultTableModel();
                 modelTramiteAdministrativo.consultarTramite(tableModel, Integer.parseInt(cedula));
                 viewTramites.getTableHistorialTramites().setModel(tableModel);

                 
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
        
                  this.modelTramiteAdministrativo = new modelTramiteAdministrativo();
                 viewTramites.reestablecerTable();
                 DefaultTableModel tableModel = new DefaultTableModel();
                 modelTramiteAdministrativo.consultarTramite(tableModel, Integer.parseInt(cedula));
                 viewTramites.getTableHistorialTramites().setModel(tableModel);
          }
                                }
                else
  
     
	  {	  mensaje = new String("No se han encontrado resultados"); // else consulta
                  
		  Mensaje(mensaje,"No se han encontrado resultados",1); }
          }
             // }

     return consulta;
                    
                       }
    
    public boolean verTramite(String ced) throws SQLException {  
    
    String mensaje;
    String direccion=null; 
    String estado = null,municipio = null,sector = null,estado2 = null,municipio2 = null,sector2 = null,estadoZona=null;
    int idBanco = 0;
    
    this.modelEstado = new modelEstado();
    this.modelMunicipio = new modelMunicipio();
    this.modelSector = new modelSector();
    this.modelDireccion = new modelDireccion();
    this.modelCargoActual = new modelCargo();
    this.modelCargoPropuesto = new modelCargoPropuesto();
    this.modelTramiteAdministrativo = new modelTramiteAdministrativo();
    this.modelTurno = new modelTurno();
    this.modelDatosBancarios = new modelDatosBancarios();
    this.modelBanco = new modelBanco();
    this.modelMotivoTramite = new modelMotivoTramite();
    this.modelFuncSaliente = new modelFuncSaliente();
    this.modelSuperior = new modelSuperior();
    
    int cedula = Integer.parseInt(ced);
     boolean consulta = modelTramiteAdministrativo.verTramite(cedula);
     
     if (consulta) {
         
    Date date = modelTramiteAdministrativo.getFecha_nac_salida();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
    String fecha_nac = sdf.format(date); 
     boolean consulta_estado = modelEstado.ConsultarEstadoId(modelTramiteAdministrativo.getEstado());
         if (consulta_estado) {
                estado = modelEstado.getNombre();
                         }
          boolean consulta_municipio = modelMunicipio.ConsultarMunicipioId(modelTramiteAdministrativo.getMunicipio());
         if (consulta_municipio) {
                municipio = modelMunicipio.getNombre();
                         }
         boolean consulta_sector = modelSector.ConsultarSectorId(modelTramiteAdministrativo.getSector());
         if (consulta_sector) {
                sector = modelSector.getNombre();
                         }
         boolean consulta_direccion = modelDireccion.ConsultarDireccionId(modelTramiteAdministrativo.getId_direccion());
         if (consulta_direccion) {
                direccion = modelDireccion.getDireccion();
                modelEstado.ConsultarEstadoId(modelDireccion.getEstado());
                estado2 = modelEstado.getNombre();
                modelMunicipio.ConsultarMunicipioId(modelDireccion.getMunicipio());
                municipio2 = modelMunicipio.getNombre();
                modelSector.ConsultarSectorId(modelDireccion.getSector());
                
                sector2 = modelSector.getNombre();
                                 }
         boolean consultaEstadoZona = modelMunicipio.ConsultarMunicipioId(modelTramiteAdministrativo.getEstado());
         if (consultaEstadoZona){
                estadoZona = modelMunicipio.getNombre();
                                }

         
                  this.viewVerTramite= new viewVerTramite(viewTramites,true,Dialog.ModalityType.DOCUMENT_MODAL);
                  viewVerTramite.setTxtCedula(ced);
		  viewVerTramite.setTxtTipoPersonal(modelTramiteAdministrativo.getTipo_personal());
                  viewVerTramite.setTxtNombre(modelTramiteAdministrativo.getNombres());
                  viewVerTramite.setTxtEstadoCivil(modelTramiteAdministrativo.getEstado_civil());
                  viewVerTramite.setTxtApellidos(modelTramiteAdministrativo.getApellidos());
                  viewVerTramite.setTxtNacionalidad(modelTramiteAdministrativo.getNacionalidad());
                  viewVerTramite.setTxtFechaNac(fecha_nac);
                  viewVerTramite.setTxtEstado(estado);
                  viewVerTramite.setTxtMunicipio(municipio);
                  viewVerTramite.setTxtSector(sector);
                  viewVerTramite.setTxtDireccion(direccion);
                  viewVerTramite.setTxtEstado1(estado2);
                  viewVerTramite.setTxtMunicipio1(municipio2);
                  viewVerTramite.setTxtSector1(sector2);
                  viewVerTramite.setTxtFechaEfecto(modelTramiteAdministrativo.getFechaEfectos());
                  viewVerTramite.setTxtNumeroZonaEducativa(modelTramiteAdministrativo.getNumeroZonaEducativa());
                  viewVerTramite.setTxtTipoTramite(modelTramiteAdministrativo.getTipoMovimiento());
                  viewVerTramite.setTxtEstadoZona(estadoZona);
                  viewVerTramite.setTxtNumeroCuenta(modelTramiteAdministrativo.getNumero_cuenta());
                  viewVerTramite.setTxtCodigoBanc(modelTramiteAdministrativo.getCodigo());
                  viewVerTramite.setTxtTipoCuenta(modelTramiteAdministrativo.getTipo_cuenta());
                  viewVerTramite.setTxtRetroactivo(modelTramiteAdministrativo.getRetroactivo());
                  idBanco = modelTramiteAdministrativo.getId_banco();
                  if (idBanco != 0) {
                  boolean consultaBanco = modelBanco.consutarBancoNombre(idBanco);
                  if (consultaBanco){
                  viewVerTramite.setTxtBanco(modelBanco.getNombre());
                                    }
                                    }
                  if(modelTramiteAdministrativo.getCargoAdicional().equals("Si")){
                  viewVerTramite.getCheckCargoAdicional().setSelected(true);
                  }
                  boolean consultaCargoAnterior = modelCargoActual.consultarCargoActual(cedula);
                  if(consultaCargoAnterior) {
                  viewVerTramite.setTxtCodigoCargo(modelCargoActual.getCodCargo());
                  viewVerTramite.setTxtPlantel(modelCargoActual.getDenPlantel());
                  viewVerTramite.setTxtCargo(modelCargoActual.getDenCargo());
                  int horasA = modelCargoActual.getHoras_a();
                  int horasD = modelCargoActual.getHoras_d();
                  int cargaHoraria = horasA+horasD;
                  viewVerTramite.setTxtCargaHoraria(Integer.toString(cargaHoraria));
                  viewVerTramite.setTxtSueldo(Integer.toString(modelCargoActual.getSueldo()));
                                            }
                  boolean consultaCargoPropuesto = modelCargoPropuesto.consultarCargoPropuesto(cedula);
                  if(consultaCargoPropuesto){
                  viewVerTramite.setTxtCodigoDependencia(modelCargoPropuesto.getCdependencia());
                  viewVerTramite.setTxtNombrePlantel(modelCargoPropuesto.getDdependencia());
                  viewVerTramite.setTxtCodCargo(modelCargoPropuesto.getCcargo());
                  viewVerTramite.setTxtDenominacionCargo(modelCargoPropuesto.getDcargo());
                  viewVerTramite.setTxtTituloObtenido(modelCargoPropuesto.getTitulo());
                  viewVerTramite.setTxtAsignatura(modelCargoPropuesto.getAsignatura());
                  int horasca = modelCargoPropuesto.getHa();
                  int horascd = modelCargoPropuesto.getHd();
                  viewVerTramite.setTxtHorasA(Integer.toString(horasca));
                  viewVerTramite.setTxtHorasD(Integer.toString(horascd));
                  viewVerTramite.setTxtTotalHoras(Integer.toString(horasca+horascd));
                  if(modelCargoPropuesto.getTipo_nombr().equals("Fijo")) {
                  viewVerTramite.getRadioBtnFijo().setSelected(true);
                                                                          }
                  else if (modelCargoPropuesto.getTipo_nombr().equals("Int")) {
                  viewVerTramite.getRadioBtnInt().setSelected(true);
                                                                              }
                  viewVerTramite.setTxtCodigoNomina(modelCargoPropuesto.getCodigo_nomina());
                  viewVerTramite.setTxtGrado(modelCargoPropuesto.getGrado());
                  viewVerTramite.setTxtPaso(modelCargoPropuesto.getPaso());
                  viewVerTramite.setTxtSueldoMensual(modelCargoPropuesto.getSueldo());
                  int id_turno = modelCargoPropuesto.getTurno();
                  boolean consultaTurno = modelTurno.consultarTurno(id_turno);
                  if(consultaTurno){
                  if (modelTurno.getTurno().equals("Diurno")){
                  viewVerTramite.getRadioBtnDiurno().setSelected(true);
                  viewVerTramite.setTxtDTitular(modelTurno.getDtitular());
                  viewVerTramite.setTxtWInterino(modelTurno.getW_interino());
                  viewVerTramite.setTxtXInterino(modelTurno.getX_interino());
                  viewVerTramite.setTxtHorasVariables(modelTurno.getHoras_variables());
                  viewVerTramite.setTxtBonoBolivariano(modelTurno.getBono_bol());
                                                             }
                  if(modelTurno.getTurno().equals("Nocturno")) {
                  viewVerTramite.getRadioBtnNocturno().setSelected(true);
                  viewVerTramite.setTxtDTitularNoc(modelTurno.getDtitular());
                  viewVerTramite.setTxtWInterinoNoc(modelTurno.getW_interino());
                  viewVerTramite.setTxtXInterinoNoc(modelTurno.getX_interino());

                                                               }
                                    }
                //  boolean consultaDatosBancarios = modelDatosBancarios.consultarDatosBancarios(cedula);
                  
                  //if(consultaDatosBancarios) {
                  
                  
                                            // }
                  DefaultTableModel tableModel = new DefaultTableModel();
                  modelMotivoTramite.listarHistorialTramites(tableModel,Integer.parseInt(ced));
                  if (tableModel != null) {
                  viewVerTramite.getTableHistorialCambios().setModel(tableModel);
                                          }
                                            }
                  
                  boolean consultarFuncSaliente = modelFuncSaliente.consultarFuncSaliente(cedula);
                 
                  if (consultarFuncSaliente) {
                  this.modelDatosPersonales = new modelDatosPersonales();
                  viewVerTramite.setTxtCedulaFuncSaliente(Integer.toString(modelFuncSaliente.getCedula()));
                  boolean consultarDatosPersonalesFuncSaliente = modelDatosPersonales.ConsultarDatosPersonales(modelFuncSaliente.getCedula());
                  if(consultarDatosPersonalesFuncSaliente) {
                  viewVerTramite.setTxtNombresFuncSaliente(modelDatosPersonales.getNombres()+' '+modelDatosPersonales.getApellidos());
                                                           }
                  else {
                  boolean consultarDatosPersonalesBasicosFuncSaliente = modelDatosPersonales.ConsultarDatosPersonalesBasicos(modelFuncSaliente.getCedula());
                  if (consultarDatosPersonalesBasicosFuncSaliente) {
                  viewVerTramite.setTxtNombresFuncSaliente(modelDatosPersonales.getNombres()+' '+modelDatosPersonales.getApellidos());
                                                                   }
                       }
                  boolean consultarCargoFuncSaliente = modelCargoActual.consultarCargoActual(modelFuncSaliente.getCedula());
                  if (consultarCargoFuncSaliente) {
                  viewVerTramite.setTxtCodDependenciaFuncSaliente(modelCargoActual.getDenPlantel());
                  viewVerTramite.setTxtCodCargoFuncSaliente(modelCargoActual.getCodCargo());
                                                   }
                  
                  viewVerTramite.setTxtDestinoFuncSaliente(modelFuncSaliente.getDestino());
                  viewVerTramite.setTxtObservacionesFuncSaliente(modelFuncSaliente.getObservaciones());
                                              }

                            boolean consultarSuperior = modelSuperior.consultarSuperior(cedula);
          if (consultarSuperior) {
                viewVerTramite.setTxtInstitucion(modelSuperior.getNombres());
                viewVerTramite.setTxtAñoInicio(modelSuperior.getFechaDesdeS());
                viewVerTramite.setTxtTitulo(modelSuperior.getTituloS());
                                 }
                  viewVerTramite.setVisible(true);
                  
                   }   
     else {
	  mensaje = new String("No se han encontrado resultados"); // else consulta
                  
		  Mensaje(mensaje,"No se han encontrado resultados",1); 
          }
    return consulta;
                    
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
