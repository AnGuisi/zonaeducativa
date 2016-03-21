/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import controllers.controllerBanco;
import controllers.controllerCargoPropuesto;
import controllers.controllerDatosPersonales;
import controllers.controllerMunicipio;
import controllers.controllerRegistrarDatosBancarios;
import controllers.controllerRegistrarFuncSaliente;
import controllers.controllerTramitesAdministrativos;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewTramitesAdministrativos extends javax.swing.JDialog {
    private OSValidator validarOS;
    private int id_direccion = 0;
    

    /**
     * Creates new form viewConsultarDatosPersonal
     */
    public viewTramitesAdministrativos(java.awt.Frame parent, boolean modal,ModalityType modalityType) throws SQLException {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        initComponents();
        this.setTitle("Trámites Administrativos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InicializacionEventos();
        autoCompletado();
        autoCompletadoFuncSaliente();
        enabledTabbed(false);
        cargarComboBanco();
        cargarComboMunicipio();
      
                                        }
    
    private void cargarComboBanco() throws SQLException {
    List ListItem = controllerBanco.cargarBanco();
    int i;
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
    comboBanco.addItem(ListItem.get(i));
                                }
                          }
                                                         }
    
    public void enabledTabbed(boolean enabled) {
    for (int i=1;i<=5;i++) {
    tabbedDocente.setEnabledAt(i, enabled);
                            }
                                               }
    
    private void autoCompletado() {
        
 TextAutoCompleter textAutoCompleter = null;

textAutoCompleter = new TextAutoCompleter(txtDatos, new AutoCompleterCallback() {

@Override

public void callback(Object selectedItem) {
}

});
    textAutoCompleter.setMode(0);
       List ListItem = null;
        try {
            ListItem = controllerDatosPersonales.CargarPersonal();
        } catch (SQLException ex) {
            Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
     
              int i;
        
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
     textAutoCompleter.addItem(ListItem.get(i));
                                }
                     }
                          }
    
        private void autoCompletadoFuncSaliente() {
        
 TextAutoCompleter textAutoCompleter = null;

textAutoCompleter = new TextAutoCompleter(txtCedulaFuncSaliente, new AutoCompleterCallback() {

@Override

public void callback(Object selectedItem) {
}

});
    textAutoCompleter.setMode(0);
       List ListItem = null;
        try {
            ListItem = controllerDatosPersonales.CargarPersonal();
        } catch (SQLException ex) {
            Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
        }
     
              int i;
        
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
     textAutoCompleter.addItem(ListItem.get(i));
                                }
                     }
                          }
    
    private void InicializacionEventos() {
    controllerTramitesAdministrativos controller = new controllerTramitesAdministrativos(this);
    controllerCargoPropuesto controllerCargoPropuesto = new controllerCargoPropuesto(this);
    controllerRegistrarDatosBancarios controllerDatosBancarios = new controllerRegistrarDatosBancarios(this);
    controllerRegistrarFuncSaliente controllerFuncSaliente = new controllerRegistrarFuncSaliente(this);
    btnConsultar.addActionListener(controller);
    btnCargoPropuesto.addActionListener(controllerCargoPropuesto);
    btnUpDatosBancarios.addActionListener(controllerDatosBancarios);
    btnConsultarDatosFuncSaliente.addActionListener(controller);
    btnFuncSaliente.addActionListener(controllerFuncSaliente);
    btnFinalizarTramite.addActionListener(controller);
                                         }
    
    public void cargarComboMunicipio() throws SQLException {
    List ListItem = controllerMunicipio.CargarMunicipios();
    int i;
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
    comboMunicipio.addItem(ListItem.get(i));
                                }
                          }
                                                        }

    
    public void reestablecerCampos() {
    txtCedula.setText("");
    txtNombres.setText("");
    txtApellidos.setText("");
    txtTipoPersonal.setText("");
    txtFechaNac.setText("");
    txtEstadoCivil.setText("");
    txtNacionalidad.setText("");
    txtEstado.setText("");
    txtMunicipio.setText("");
    txtSector.setText("");
    txtNacionalizado.setText("");
    txtDireccion.setText("");
    txtEstado1.setText("");
    txtMunicipio1.setText("");
    txtSector1.setText("");
    
                                     }

    public JComboBox getComboMunicipio() {
        return comboMunicipio;
    }

    public void setTxtAñoInicio(String AñoInicio) {
       txtAñoInicio.setText(AñoInicio);
    }

    public void setTxtInstitucion(String Institucion) {
        txtInstitucion.setText(Institucion);
    }

    public void setTxtTitulo(String Titulo) {
        txtTitulo.setText(Titulo);
    }

    public JButton getBtnFuncSaliente() {
        return btnFuncSaliente;
    }


    public void setTxtCedulaFuncSaliente(String CedulaFuncSaliente) {
        txtCedulaFuncSaliente.setText(CedulaFuncSaliente);
    }

    public String getTxtCedulaFuncSaliente() {
        return txtCedulaFuncSaliente.getText();
    }

    public JButton getBtnConsultarDatosFuncSaliente() {
        return btnConsultarDatosFuncSaliente;
    }

    public JTable getTableCargoFuncSaliente() {
        return tableCargoFuncSaliente;
    }

    public String getTxtDestinoFuncSaliente() {
        return txtDestinoFuncSaliente.getText();
    }

    public void setTxtApellidosNombreFuncSaliente(String ApellidosNombreFuncSaliente) {
        txtApellidosNombreFuncSaliente.setText(ApellidosNombreFuncSaliente);
    }


    public String getTxtObservacionesFuncSaliente() {
        return txtObservacionesFuncSaliente.getText();
    }

    public JTable getTableCargoActual() {
        return tableCargoActual;
    }

    public String getTxtMotivoTramite() {
        return txtMotivoTramite.getText();
    }

    public JTextField getDatos() {
        return txtDatos;
    }

    public void setTxtDatos(String Datos) {
        txtDatos.setText(Datos);
    }

    public JButton getBtnFinalizarTramite() {
        return btnFinalizarTramite;
    }


    public JButton getBtnUpDatosBancarios() {
        return btnUpDatosBancarios;
    }

    public String getTxtRetroactivo() {
        return txtRetroactivo.getText();
    }
    
    public JButton getBtnCargoPropuesto() {
        return btnCargoPropuesto;
    }

    public JTabbedPane getTabbedDocente() {
        return tabbedDocente;
    }

    public String getTxtDatos() {
        return txtDatos.getText();
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setTxtApellidos(String Apellidos) {
        txtApellidos.setText(Apellidos);
    }

    public void setTxtDireccion(String Direccion) {
        txtDireccion.setText(Direccion);
    }

    public void setTxtEstado(String Estado) {
        txtEstado.setText(Estado);
    }

    public void setTxtEstadoCivil(String EstadoCivil) {
        txtEstadoCivil.setText(EstadoCivil);
    }

    public void setTxtFechaNac(String FechaNac) {
        txtFechaNac.setText(FechaNac);
    }

    public void setTxtMunicipio(String Municipio) {
        txtMunicipio.setText(Municipio);
    }

    public void setTxtNacionalizado(String Nacionalizado) {
        txtNacionalizado.setText(Nacionalizado);
    }

    public void setTxtNombre(String Nombre) {
        txtNombres.setText(Nombre);
    }

    public void setTxtTipoPersonal(String TipoPersonal) {
        txtTipoPersonal.setText(TipoPersonal);
    }

    public void setTxtEstado1(String Estado1) {
        txtEstado1.setText(Estado1);
    }

    public void setTxtMunicipio1(String Municipio1) {
        txtMunicipio1.setText(Municipio1);
    }

    public void setTxtSector(String Sector) {
        txtSector.setText(Sector);
    }

    public void setTxtSector1(String Sector1) {
        txtSector1.setText(Sector1);
    }

    public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public void setTxtNacionalidad(String Nacionalidad) {
        txtNacionalidad.setText(Nacionalidad);
    }

    public String getTxtAsignatura() {
        return txtAsignatura.getText();
    }

    public String getTxtCodCargo() {
        return txtCodCargo.getText();
    }

    public String getTxtDenCargo() {
        return txtDenCargo.getText();
    }

    public String getTxtTituloObtenido() {
        return txtTituloObtenido.getText();
    }

    public JRadioButton getRadioBtnDiurno() {
        return radioBtnDiurno;
    }

    public JRadioButton getRadioBtnFijo() {
        return radioBtnFijo;
    }

    public JRadioButton getRadioBtnInt() {
        return radioBtnInt;
    }

    public JRadioButton getRadioBtnNocturno() {
        return radioBtnNocturno;
    }

    public String getTxtHorasA() {
        return txtHorasA.getText();
    }

    public String getTxtHorasD() {
        return txtHorasD.getText();
    }


    public String getTxtCodPlantel() {
        return txtCodPlantel.getText();
    }

    public String getTxtCedula() {
        return txtCedula.getText();
    }


    public void setTxtCodPlantel(String CodPlantel) {
        txtCodPlantel.setText(CodPlantel);
    }

    public void setTxtNombrePlantel(String NombrePlantel) {
        txtNombrePlantel.setText(NombrePlantel);
    }

    public void setTxtCodCargo(String CodCargo) {
        txtCodCargo.setText(CodCargo);
    }

    public void setTxtDenCargo(String DenCargo) {
        txtDenCargo.setText(DenCargo);
    }

    public JComboBox getComboBanco() {
        return comboBanco;
    }

    public void setComboBanco(JComboBox comboBanco) {
        this.comboBanco = comboBanco;
    }

    public JComboBox getComboTipoCuenta() {
        return comboTipoCuenta;
    }

    public void setComboTipoCuenta(JComboBox comboTipoCuenta) {
        this.comboTipoCuenta = comboTipoCuenta;
    }

    public String getTxtCodigoBanc() {
        return txtCodigoBanc.getText();
    }

    public void setTxtCodigoBanc(String CodigoBanc) {
        txtCodigoBanc.setText(CodigoBanc);
    }

    public String getTxtNumeroCuenta() {
        return txtNumeroCuenta.getText();
    }

    public void setTxtNumeroCuenta(String NumeroCuenta) {
        txtNumeroCuenta.setText(NumeroCuenta);
    }

    public String getTxtCodigoNomina() {
        return txtCodigoNomina.getText();
    }

    public String getTxtGrado() {
        return txtGrado.getText();
    }

    public String getTxtPaso() {
        return txtPaso.getText();
    }

    public String getTxtSueldoMensual() {
        return txtSueldoMensual.getText();
    }

    public Date getTxtFechaEfecto() {
        return txtFechaEfecto.getDate();
    }

    public JComboBox getComboEstado() {
        return comboMunicipio;
    }

    public String getTxtNumeroZonaEducativa() {
        return txtNumeroZonaEducativa.getText();
    }

    public JComboBox getComboTipoTramite() {
        return comboTipoTramite;
    }

    public JCheckBox getCheckCargoAdicional() {
        return checkCargoAdicional;
    }

    public JRadioButton getCheckBonoBolivariano() {
        return checkBonoBolivariano;
    }

    public JRadioButton getCheckDTitular() {
        return checkDTitular;
    }

    public JRadioButton getCheckDTitularNoc() {
        return checkDTitularNoc;
    }

    public JRadioButton getCheckHorasVariables() {
        return checkHorasVariables;
    }

    public JRadioButton getCheckWInterino() {
        return checkWInterino;
    }

    public JRadioButton getCheckWInterinoNoc() {
        return checkWInterinoNoc;
    }

    public JRadioButton getCheckXInterino() {
        return checkXInterino;
    }

    public JRadioButton getCheckXInterinoNoc() {
        return checkXInterinoNoc;
    }

    public JTabbedPane getTabbedCargo() {
        return tabbedCargo;
    }

    public String getTxtNombrePlantel() {
        return txtNombrePlantel.getText();
    }

    public String getTxtTotalHoras() {
        return txtTotalHoras.getText();
    }

    public String getTxtTipoPersonal() {
        return txtTipoPersonal.getText();
    }

    public JComboBox getComboTipoBusqueda() {
        return comboTipoBusqueda;
    }
    


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBtnFijoInt = new javax.swing.ButtonGroup();
        groupBtnTurno = new javax.swing.ButtonGroup();
        groupBtnDiurno = new javax.swing.ButtonGroup();
        groupBtnNoc = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        btnDatosCargos = new javax.swing.JButton();
        btnDatosBancarios = new javax.swing.JButton();
        btnDatosFuncSaliente = new javax.swing.JButton();
        btnDatosLaborales = new javax.swing.JButton();
        btnEstudiosReal = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        txtDatos = new javax.swing.JTextField();
        comboTipoBusqueda = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton("Consultar");
        btnListadoPersonal = new javax.swing.JButton("Consultar");
        jPanel12 = new javax.swing.JPanel();
        tabbedDocente = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel39 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JLabel();
        txtNombres = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JLabel();
        txtTipoPersonal = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JLabel();
        txtEstadoCivil = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaEfecto = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        comboMunicipio = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtNumeroZonaEducativa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboTipoTramite = new javax.swing.JComboBox();
        checkCargoAdicional = new javax.swing.JCheckBox();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        txtNacionalidad = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JLabel();
        txtSector = new javax.swing.JLabel();
        txtNacionalizado = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JLabel();
        txtEstado1 = new javax.swing.JLabel();
        txtMunicipio1 = new javax.swing.JLabel();
        txtSector1 = new javax.swing.JLabel();
        btnContinuarTramite = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        tabbedCargo = new javax.swing.JTabbedPane();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableCargoActual = new javax.swing.JTable();
        tabbedCargoPropuesto = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        txtCodPlantel = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        txtNombrePlantel = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        txtCodCargo = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        txtDenCargo = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        txtTituloObtenido = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        btnSeleccionarPlantel = new javax.swing.JButton();
        btnAgregarEmpresa4 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        txtHorasD = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        txtHorasA = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        txtTotalHoras = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        radioBtnFijo = new javax.swing.JRadioButton();
        radioBtnInt = new javax.swing.JRadioButton();
        jPanel26 = new javax.swing.JPanel();
        panelDiurno = new javax.swing.JPanel();
        checkDTitular = new javax.swing.JRadioButton();
        checkXInterino = new javax.swing.JRadioButton();
        checkWInterino = new javax.swing.JRadioButton();
        checkBonoBolivariano = new javax.swing.JRadioButton();
        checkHorasVariables = new javax.swing.JRadioButton();
        labelDiurno = new javax.swing.JLabel();
        labelNocturno = new javax.swing.JLabel();
        panelNocturno = new javax.swing.JPanel();
        checkDTitularNoc = new javax.swing.JRadioButton();
        checkXInterinoNoc = new javax.swing.JRadioButton();
        checkWInterinoNoc = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        radioBtnDiurno = new javax.swing.JRadioButton();
        radioBtnNocturno = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        panelDiurno1 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        txtCodigoNomina = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        txtPaso = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        txtSueldoMensual = new javax.swing.JTextField();
        btnCargoPropuesto = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel70 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        txtNumeroCuenta = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        txtCodigoBanc = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        comboBanco = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        comboTipoCuenta = new javax.swing.JComboBox();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRetroactivo = new javax.swing.JTextArea();
        btnUpDatosBancarios = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel71 = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        txtCedulaFuncSaliente = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        txtApellidosNombreFuncSaliente = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        txtDestinoFuncSaliente = new javax.swing.JTextField();
        btnConsultarDatosFuncSaliente = new javax.swing.JButton("Consultar");
        btnListadoPersonalFuncSaliente = new javax.swing.JButton("Consultar");
        Cargo = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCargoFuncSaliente = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesFuncSaliente = new javax.swing.JTextArea();
        btnFuncSaliente = new javax.swing.JButton();
        panelEstudiosRealizados = new javax.swing.JPanel();
        panelEstudiosRealizadosTabbed = new javax.swing.JTabbedPane();
        jTabbedPane22 = new javax.swing.JTabbedPane();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        txtInstitucion = new javax.swing.JTextField();
        jLabel204 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel205 = new javax.swing.JLabel();
        txtAñoInicio = new javax.swing.JTextField();
        jLabel207 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnEstudiosRealizados = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnFinalizarTramite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivoTramite = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.Y_AXIS));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_16.png"))); // NOI18N
        jButton7.setText("<html><center>Datos<br> Personales</center></html>");
        jButton7.setToolTipText("Datos Personales");
        jButton7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton7.setBorderPainted(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setIconTextGap(0);
        jButton7.setPreferredSize(new java.awt.Dimension(80, 60));
        jButton7.setVerifyInputWhenFocusTarget(false);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7);

        btnDatosCargos.setBackground(new java.awt.Color(255, 255, 255));
        btnDatosCargos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnDatosCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder_16.png"))); // NOI18N
        btnDatosCargos.setText("<html><center>Datos<br> de Cargos</center></html>");
        btnDatosCargos.setToolTipText("Datos del Cargo Anterior");
        btnDatosCargos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDatosCargos.setBorderPainted(false);
        btnDatosCargos.setEnabled(false);
        btnDatosCargos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatosCargos.setIconTextGap(0);
        btnDatosCargos.setPreferredSize(new java.awt.Dimension(80, 60));
        btnDatosCargos.setVerifyInputWhenFocusTarget(false);
        btnDatosCargos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatosCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosCargosActionPerformed(evt);
            }
        });
        jPanel13.add(btnDatosCargos);

        btnDatosBancarios.setBackground(new java.awt.Color(255, 255, 255));
        btnDatosBancarios.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnDatosBancarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home_16.png"))); // NOI18N
        btnDatosBancarios.setText("<html><center>Datos<br>Bancarios</center></html>");
        btnDatosBancarios.setToolTipText("Datos Bancarios");
        btnDatosBancarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDatosBancarios.setBorderPainted(false);
        btnDatosBancarios.setEnabled(false);
        btnDatosBancarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatosBancarios.setIconTextGap(0);
        btnDatosBancarios.setPreferredSize(new java.awt.Dimension(80, 60));
        btnDatosBancarios.setVerifyInputWhenFocusTarget(false);
        btnDatosBancarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatosBancarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosBancariosActionPerformed(evt);
            }
        });
        jPanel13.add(btnDatosBancarios);

        btnDatosFuncSaliente.setBackground(new java.awt.Color(255, 255, 255));
        btnDatosFuncSaliente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnDatosFuncSaliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/right_16.png"))); // NOI18N
        btnDatosFuncSaliente.setText("<html><center>Datos del <br>Funcionario Saliente</center></html>");
        btnDatosFuncSaliente.setToolTipText("Datos del Cargo Anterior");
        btnDatosFuncSaliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDatosFuncSaliente.setBorderPainted(false);
        btnDatosFuncSaliente.setEnabled(false);
        btnDatosFuncSaliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatosFuncSaliente.setIconTextGap(0);
        btnDatosFuncSaliente.setMargin(new java.awt.Insets(2, 10, 2, 14));
        btnDatosFuncSaliente.setPreferredSize(new java.awt.Dimension(80, 60));
        btnDatosFuncSaliente.setVerifyInputWhenFocusTarget(false);
        btnDatosFuncSaliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatosFuncSaliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosFuncSalienteActionPerformed(evt);
            }
        });
        jPanel13.add(btnDatosFuncSaliente);

        btnDatosLaborales.setBackground(new java.awt.Color(255, 255, 255));
        btnDatosLaborales.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnDatosLaborales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document_16.png"))); // NOI18N
        btnDatosLaborales.setText("<html><center>Datos Laborales <br>del Empleado</center></html>");
        btnDatosLaborales.setToolTipText("Datos Laborales del Empleado");
        btnDatosLaborales.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDatosLaborales.setBorderPainted(false);
        btnDatosLaborales.setEnabled(false);
        btnDatosLaborales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatosLaborales.setIconTextGap(0);
        btnDatosLaborales.setMargin(new java.awt.Insets(2, 10, 2, 14));
        btnDatosLaborales.setPreferredSize(new java.awt.Dimension(80, 60));
        btnDatosLaborales.setVerifyInputWhenFocusTarget(false);
        btnDatosLaborales.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatosLaborales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosLaboralesActionPerformed(evt);
            }
        });
        jPanel13.add(btnDatosLaborales);

        btnEstudiosReal.setBackground(new java.awt.Color(255, 255, 255));
        btnEstudiosReal.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEstudiosReal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipboard_16.png"))); // NOI18N
        btnEstudiosReal.setText("<html><center>Estudios Realizados<br>del Empleado</center></html>");
        btnEstudiosReal.setToolTipText("Estudios Realizados del Empleado");
        btnEstudiosReal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEstudiosReal.setBorderPainted(false);
        btnEstudiosReal.setEnabled(false);
        btnEstudiosReal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstudiosReal.setIconTextGap(0);
        btnEstudiosReal.setMargin(new java.awt.Insets(2, 10, 2, 14));
        btnEstudiosReal.setPreferredSize(new java.awt.Dimension(80, 60));
        btnEstudiosReal.setVerifyInputWhenFocusTarget(false);
        btnEstudiosReal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstudiosReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudiosRealActionPerformed(evt);
            }
        });
        jPanel13.add(btnEstudiosReal);

        jPanel3.add(jPanel13, java.awt.BorderLayout.LINE_START);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jPanel9.setLayout(flowLayout1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/header.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(jLabel1);

        jPanel10.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jLabel84.setText("Introduzca Datos:");

        txtDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtDatos.setEnabled(false);
        txtDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatosActionPerformed(evt);
            }
        });
        txtDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDatosKeyTyped(evt);
            }
        });

        comboTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..", "Buscar por Cédula", "Buscar por Nombre" }));
        comboTipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addGap(18, 18, 18)
                .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Trámites Administrativos");

        btnConsultar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Prueba/paste_64px_opt.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setToolTipText("Consultar Datos de Personal");
        btnConsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar.setIconTextGap(5);
        btnConsultar.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnConsultar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Prueba/paste_64px_opt(1).png"))); // NOI18N
        btnConsultar.setVerifyInputWhenFocusTarget(false);
        btnConsultar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnListadoPersonal.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnListadoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/listado_p.png"))); // NOI18N
        btnListadoPersonal.setText("Ver Listado de Personal");
        btnListadoPersonal.setToolTipText("Consultar Datos de Personal");
        btnListadoPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnListadoPersonal.setContentAreaFilled(false);
        btnListadoPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListadoPersonal.setIconTextGap(5);
        btnListadoPersonal.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnListadoPersonal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/listado_g.png"))); // NOI18N
        btnListadoPersonal.setVerifyInputWhenFocusTarget(false);
        btnListadoPersonal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnListadoPersonal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListadoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(jLabel2)
                .addGap(398, 398, 398))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addComponent(btnListadoPersonal)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultar)
                            .addComponent(btnListadoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        jPanel10.add(jPanel8);

        jPanel3.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        tabbedDocente.setBackground(new java.awt.Color(255, 255, 255));
        tabbedDocente.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1000, 400));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cédula");
        jLabel5.setOpaque(true);
        jPanel4.add(jLabel5);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombres");
        jLabel3.setOpaque(true);
        jPanel4.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellidos");
        jLabel4.setOpaque(true);
        jPanel4.add(jLabel4);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tipo de Personal");
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fecha de Nacimiento");
        jLabel7.setOpaque(true);
        jPanel4.add(jLabel7);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Estado Civil");
        jLabel8.setOpaque(true);
        jPanel4.add(jLabel8);

        jPanel7.setBackground(new java.awt.Color(238, 238, 238));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        txtCedula.setBackground(new java.awt.Color(238, 238, 238));
        txtCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCedula.setOpaque(true);
        jPanel7.add(txtCedula);

        txtNombres.setBackground(new java.awt.Color(238, 238, 238));
        txtNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombres.setOpaque(true);
        jPanel7.add(txtNombres);

        txtApellidos.setBackground(new java.awt.Color(238, 238, 238));
        txtApellidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtApellidos.setOpaque(true);
        jPanel7.add(txtApellidos);

        txtTipoPersonal.setBackground(new java.awt.Color(238, 238, 238));
        txtTipoPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTipoPersonal.setOpaque(true);
        jPanel7.add(txtTipoPersonal);

        txtFechaNac.setBackground(new java.awt.Color(238, 238, 238));
        txtFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFechaNac.setOpaque(true);
        jPanel7.add(txtFechaNac);

        txtEstadoCivil.setBackground(new java.awt.Color(238, 238, 238));
        txtEstadoCivil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstadoCivil.setOpaque(true);
        jPanel7.add(txtEstadoCivil);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.GridLayout(5, 0, 7, 7));

        jLabel9.setText("Fecha Efecto:");
        jPanel14.add(jLabel9);

        txtFechaEfecto.setPreferredSize(new java.awt.Dimension(93, 20));
        txtFechaEfecto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaEfectoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaEfectoFocusLost(evt);
            }
        });
        jPanel14.add(txtFechaEfecto);

        jLabel14.setText("Municipio:");
        jPanel14.add(jLabel14);

        comboMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        jPanel14.add(comboMunicipio);

        jLabel15.setText("Zona Educativa Número:");
        jPanel14.add(jLabel15);

        txtNumeroZonaEducativa.setText("20");
        txtNumeroZonaEducativa.setEnabled(false);
        jPanel14.add(txtNumeroZonaEducativa);

        jLabel10.setText("Tipo de Trámite:");
        jPanel14.add(jLabel10);

        comboTipoTramite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..", "Ingreso", "Reactivación", "Traslado", "Ascenso", "Clasificación", "Liberación de Cargo", "Suspensión", "Modificación de Horas", "Egresos", "Modificación de Cargo", "Modificación de Datos Personales" }));
        comboTipoTramite.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoTramiteItemStateChanged(evt);
            }
        });
        jPanel14.add(comboTipoTramite);

        checkCargoAdicional.setBackground(new java.awt.Color(255, 255, 255));
        checkCargoAdicional.setText("Cargo Adicional");
        jPanel14.add(checkCargoAdicional);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 121, Short.MAX_VALUE))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );

        jTabbedPane2.addTab("Datos Básicos", jPanel39);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Lugar de Nacimiento"));

        jPanel42.setBackground(new java.awt.Color(204, 204, 204));
        jPanel42.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel85.setBackground(new java.awt.Color(204, 204, 204));
        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Nacionalidad");
        jLabel85.setOpaque(true);
        jPanel42.add(jLabel85);

        jLabel86.setBackground(new java.awt.Color(204, 204, 204));
        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Estado");
        jLabel86.setOpaque(true);
        jPanel42.add(jLabel86);

        jLabel87.setBackground(new java.awt.Color(204, 204, 204));
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Municipio");
        jLabel87.setOpaque(true);
        jPanel42.add(jLabel87);

        jLabel88.setBackground(new java.awt.Color(204, 204, 204));
        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Sector");
        jLabel88.setOpaque(true);
        jPanel42.add(jLabel88);

        jLabel89.setBackground(new java.awt.Color(204, 204, 204));
        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Nacionalizado");
        jLabel89.setOpaque(true);
        jPanel42.add(jLabel89);

        jPanel43.setBackground(new java.awt.Color(238, 238, 238));
        jPanel43.setLayout(new java.awt.GridLayout(1, 0));

        txtNacionalidad.setBackground(new java.awt.Color(238, 238, 238));
        txtNacionalidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNacionalidad.setOpaque(true);
        jPanel43.add(txtNacionalidad);

        txtEstado.setBackground(new java.awt.Color(238, 238, 238));
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado.setOpaque(true);
        jPanel43.add(txtEstado);

        txtMunicipio.setBackground(new java.awt.Color(238, 238, 238));
        txtMunicipio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMunicipio.setOpaque(true);
        jPanel43.add(txtMunicipio);

        txtSector.setBackground(new java.awt.Color(238, 238, 238));
        txtSector.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSector.setOpaque(true);
        jPanel43.add(txtSector);

        txtNacionalizado.setBackground(new java.awt.Color(238, 238, 238));
        txtNacionalizado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNacionalizado.setOpaque(true);
        jPanel43.add(txtNacionalizado);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel41Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                        .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel41Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 259, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 194, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Lugar de Nacimiento", jPanel40);

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección"));

        jPanel46.setBackground(new java.awt.Color(204, 204, 204));
        jPanel46.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel90.setBackground(new java.awt.Color(204, 204, 204));
        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Dirección");
        jLabel90.setOpaque(true);
        jPanel46.add(jLabel90);

        jLabel91.setBackground(new java.awt.Color(204, 204, 204));
        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Estado");
        jLabel91.setOpaque(true);
        jPanel46.add(jLabel91);

        jLabel92.setBackground(new java.awt.Color(204, 204, 204));
        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Municipio");
        jLabel92.setOpaque(true);
        jPanel46.add(jLabel92);

        jLabel93.setBackground(new java.awt.Color(204, 204, 204));
        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Sector");
        jLabel93.setOpaque(true);
        jPanel46.add(jLabel93);

        jPanel47.setBackground(new java.awt.Color(238, 238, 238));
        jPanel47.setLayout(new java.awt.GridLayout(1, 0));

        txtDireccion.setBackground(new java.awt.Color(238, 238, 238));
        txtDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDireccion.setOpaque(true);
        jPanel47.add(txtDireccion);

        txtEstado1.setBackground(new java.awt.Color(238, 238, 238));
        txtEstado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado1.setOpaque(true);
        jPanel47.add(txtEstado1);

        txtMunicipio1.setBackground(new java.awt.Color(238, 238, 238));
        txtMunicipio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMunicipio1.setOpaque(true);
        jPanel47.add(txtMunicipio1);

        txtSector1.setBackground(new java.awt.Color(238, 238, 238));
        txtSector1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSector1.setOpaque(true);
        jPanel47.add(txtSector1);

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                        .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel45Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 259, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 194, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dirección", jPanel44);

        btnContinuarTramite.setBackground(new java.awt.Color(255, 255, 255));
        btnContinuarTramite.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnContinuarTramite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnContinuarTramite.setText("Continuar Trámite");
        btnContinuarTramite.setToolTipText("Examinar...");
        btnContinuarTramite.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnContinuarTramite.setContentAreaFilled(false);
        btnContinuarTramite.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContinuarTramite.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnContinuarTramite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnContinuarTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarTramiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnContinuarTramite)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContinuarTramite)
                .addGap(0, 769, Short.MAX_VALUE))
        );

        jScrollPane22.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        tabbedDocente.addTab("Datos Personales", jPanel25);

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));

        tabbedCargo.setBackground(new java.awt.Color(255, 255, 255));
        tabbedCargo.setOpaque(true);

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        tableCargoActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(tableCargoActual);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedCargo.addTab("Datos del Cargo Anterior", jPanel51);

        tabbedCargoPropuesto.setBackground(new java.awt.Color(255, 255, 255));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setLayout(new java.awt.GridLayout(6, 2, 0, 8));

        jLabel98.setText("Código de Dependencia:");
        jPanel66.add(jLabel98);
        jPanel66.add(txtCodPlantel);

        jLabel131.setText("Nombre del Plantel:");
        jPanel66.add(jLabel131);
        jPanel66.add(txtNombrePlantel);

        jLabel132.setText("Código de Cargo:");
        jPanel66.add(jLabel132);
        jPanel66.add(txtCodCargo);

        jLabel133.setText("Denominación del Cargo:");
        jPanel66.add(jLabel133);
        jPanel66.add(txtDenCargo);

        jLabel134.setText("Título Obtenido:");
        jPanel66.add(jLabel134);
        jPanel66.add(txtTituloObtenido);

        jLabel135.setText("Asignatura:");
        jPanel66.add(jLabel135);
        jPanel66.add(txtAsignatura);

        btnSeleccionarPlantel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSeleccionarPlantel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_p.png"))); // NOI18N
        btnSeleccionarPlantel.setText("<html><center>Seleccionar<br>Dependencia</center></html>");
        btnSeleccionarPlantel.setToolTipText("Seleccionar");
        btnSeleccionarPlantel.setAlignmentY(0.0F);
        btnSeleccionarPlantel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSeleccionarPlantel.setContentAreaFilled(false);
        btnSeleccionarPlantel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeleccionarPlantel.setIconTextGap(0);
        btnSeleccionarPlantel.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnSeleccionarPlantel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_g.png"))); // NOI18N
        btnSeleccionarPlantel.setVerifyInputWhenFocusTarget(false);
        btnSeleccionarPlantel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSeleccionarPlantel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPlantelActionPerformed(evt);
            }
        });

        btnAgregarEmpresa4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarEmpresa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionarCargo_p.png"))); // NOI18N
        btnAgregarEmpresa4.setText("<html><center>Seleccionar<br>Cargo</center></html>");
        btnAgregarEmpresa4.setToolTipText("Seleccionar");
        btnAgregarEmpresa4.setAlignmentY(0.0F);
        btnAgregarEmpresa4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarEmpresa4.setContentAreaFilled(false);
        btnAgregarEmpresa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarEmpresa4.setIconTextGap(0);
        btnAgregarEmpresa4.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnAgregarEmpresa4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionarCargo_g.png"))); // NOI18N
        btnAgregarEmpresa4.setVerifyInputWhenFocusTarget(false);
        btnAgregarEmpresa4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarEmpresa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpresa4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionarPlantel)
                    .addComponent(btnAgregarEmpresa4))
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarEmpresa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Dependencia", jPanel65);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setLayout(new java.awt.GridLayout(3, 2, 0, 8));

        jLabel136.setText("Horas Administrativas:");
        jPanel67.add(jLabel136);

        txtHorasD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHorasDFocusLost(evt);
            }
        });
        jPanel67.add(txtHorasD);

        jLabel137.setText("Horas Académicas:");
        jPanel67.add(jLabel137);

        txtHorasA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHorasAFocusLost(evt);
            }
        });
        jPanel67.add(txtHorasA);

        jLabel138.setText("Total:");
        jPanel67.add(jLabel138);
        jPanel67.add(txtTotalHoras);

        jLabel139.setText("Tipo Nombr:");

        radioBtnFijo.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnFijoInt.add(radioBtnFijo);
        radioBtnFijo.setText("Fijo");

        radioBtnInt.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnFijoInt.add(radioBtnInt);
        radioBtnInt.setText("Int");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnFijo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnInt)
                        .addGap(92, 92, 92))
                    .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioBtnFijo)
                    .addComponent(radioBtnInt))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Carga Horaria", jPanel24);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        panelDiurno.setBackground(new java.awt.Color(255, 255, 255));
        panelDiurno.setLayout(new java.awt.GridLayout(5, 2, 0, 8));

        checkDTitular.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnDiurno.add(checkDTitular);
        checkDTitular.setText("D Titular");
        checkDTitular.setEnabled(false);
        panelDiurno.add(checkDTitular);

        checkXInterino.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnDiurno.add(checkXInterino);
        checkXInterino.setText("X Interino (S/P)");
        checkXInterino.setEnabled(false);
        checkXInterino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkXInterinoActionPerformed(evt);
            }
        });
        panelDiurno.add(checkXInterino);

        checkWInterino.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnDiurno.add(checkWInterino);
        checkWInterino.setText("W Intr(P/CONCUR)");
        checkWInterino.setEnabled(false);
        panelDiurno.add(checkWInterino);

        checkBonoBolivariano.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnDiurno.add(checkBonoBolivariano);
        checkBonoBolivariano.setText("Bono Bolivariano");
        checkBonoBolivariano.setEnabled(false);
        panelDiurno.add(checkBonoBolivariano);

        checkHorasVariables.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnDiurno.add(checkHorasVariables);
        checkHorasVariables.setText("A Horas Variables");
        checkHorasVariables.setEnabled(false);
        panelDiurno.add(checkHorasVariables);

        labelDiurno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelDiurno.setText("Diurno:");
        labelDiurno.setEnabled(false);

        labelNocturno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNocturno.setText("Nocturno:");
        labelNocturno.setEnabled(false);

        panelNocturno.setBackground(new java.awt.Color(255, 255, 255));
        panelNocturno.setLayout(new java.awt.GridLayout(3, 2, 0, 8));

        checkDTitularNoc.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnNoc.add(checkDTitularNoc);
        checkDTitularNoc.setText("D Titular");
        checkDTitularNoc.setEnabled(false);
        panelNocturno.add(checkDTitularNoc);

        checkXInterinoNoc.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnNoc.add(checkXInterinoNoc);
        checkXInterinoNoc.setText("Y Interino (S/P)");
        checkXInterinoNoc.setEnabled(false);
        panelNocturno.add(checkXInterinoNoc);

        checkWInterinoNoc.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnNoc.add(checkWInterinoNoc);
        checkWInterinoNoc.setText("X Inter. (P/CON)");
        checkWInterinoNoc.setEnabled(false);
        panelNocturno.add(checkWInterinoNoc);

        jLabel12.setText("Turno:");

        radioBtnDiurno.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnTurno.add(radioBtnDiurno);
        radioBtnDiurno.setText("Diurno");
        radioBtnDiurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnDiurnoActionPerformed(evt);
            }
        });

        radioBtnNocturno.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnTurno.add(radioBtnNocturno);
        radioBtnNocturno.setText("Nocturno");
        radioBtnNocturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnNocturnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtnDiurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBtnNocturno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDiurno)
                            .addComponent(panelDiurno, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNocturno)
                            .addComponent(panelNocturno, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(523, 523, 523))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(radioBtnDiurno)
                    .addComponent(radioBtnNocturno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(labelDiurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDiurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(labelNocturno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelNocturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jTabbedPane5.addTab("Turno", jPanel26);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelDiurno1.setBackground(new java.awt.Color(255, 255, 255));
        panelDiurno1.setLayout(new java.awt.GridLayout(5, 2, 0, 8));

        jLabel152.setText("Código Nómina:");
        panelDiurno1.add(jLabel152);
        panelDiurno1.add(txtCodigoNomina);

        jLabel153.setText("Grado:");
        panelDiurno1.add(jLabel153);
        panelDiurno1.add(txtGrado);

        jLabel154.setText("Paso:");
        panelDiurno1.add(jLabel154);
        panelDiurno1.add(txtPaso);

        jLabel155.setText("Sueldo Mensual:");
        panelDiurno1.add(jLabel155);
        panelDiurno1.add(txtSueldoMensual);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDiurno1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDiurno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Otros Datos", jPanel1);

        javax.swing.GroupLayout tabbedCargoPropuestoLayout = new javax.swing.GroupLayout(tabbedCargoPropuesto);
        tabbedCargoPropuesto.setLayout(tabbedCargoPropuestoLayout);
        tabbedCargoPropuestoLayout.setHorizontalGroup(
            tabbedCargoPropuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedCargoPropuestoLayout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 112, Short.MAX_VALUE))
        );
        tabbedCargoPropuestoLayout.setVerticalGroup(
            tabbedCargoPropuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedCargoPropuestoLayout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabbedCargo.addTab("Datos del Cargo Propuesto", tabbedCargoPropuesto);

        btnCargoPropuesto.setBackground(new java.awt.Color(255, 255, 255));
        btnCargoPropuesto.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnCargoPropuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnCargoPropuesto.setText("Continuar Trámite");
        btnCargoPropuesto.setToolTipText("Examinar...");
        btnCargoPropuesto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCargoPropuesto.setContentAreaFilled(false);
        btnCargoPropuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargoPropuesto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnCargoPropuesto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedCargo)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCargoPropuesto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(tabbedCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargoPropuesto)
                .addGap(0, 93, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Datos de Cargos", jPanel50);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new java.awt.GridLayout(4, 2, 0, 8));

        jLabel80.setText("Nº Cuenta Bancaria:");
        jPanel36.add(jLabel80);
        jPanel36.add(txtNumeroCuenta);

        jLabel99.setText("Código:");
        jPanel36.add(jLabel99);
        jPanel36.add(txtCodigoBanc);

        jLabel110.setText("Banco:");
        jPanel36.add(jLabel110);

        comboBanco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        jPanel36.add(comboBanco);

        jLabel111.setText("Tipo de Cuenta:");
        jPanel36.add(jLabel111);

        comboTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Ahorra", "Corriente" }));
        jPanel36.add(comboTipoCuenta);

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Datos Bancarios", jPanel70);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        txtRetroactivo.setColumns(20);
        txtRetroactivo.setRows(5);
        jScrollPane2.setViewportView(txtRetroactivo);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Retroactivo", jPanel22);

        btnUpDatosBancarios.setBackground(new java.awt.Color(255, 255, 255));
        btnUpDatosBancarios.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnUpDatosBancarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnUpDatosBancarios.setText("Continuar Trámite");
        btnUpDatosBancarios.setToolTipText("Examinar...");
        btnUpDatosBancarios.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnUpDatosBancarios.setContentAreaFilled(false);
        btnUpDatosBancarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpDatosBancarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnUpDatosBancarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpDatosBancarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpDatosBancariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 618, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpDatosBancarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpDatosBancarios)
                .addGap(0, 158, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Datos Bancarios", jPanel6);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setLayout(new java.awt.GridLayout(5, 2, 0, 8));

        jLabel112.setText("Cédula de Identidad:");
        jPanel72.add(jLabel112);
        jPanel72.add(txtCedulaFuncSaliente);

        jLabel118.setText("Apellidos y Nombres:");
        jPanel72.add(jLabel118);
        jPanel72.add(txtApellidosNombreFuncSaliente);

        jLabel119.setText("Destino del Funcionario Saliente:");
        jPanel72.add(jLabel119);
        jPanel72.add(txtDestinoFuncSaliente);

        btnConsultarDatosFuncSaliente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnConsultarDatosFuncSaliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Prueba/paste_64px_opt.png"))); // NOI18N
        btnConsultarDatosFuncSaliente.setText("Consultar");
        btnConsultarDatosFuncSaliente.setToolTipText("Consultar Datos de Personal");
        btnConsultarDatosFuncSaliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnConsultarDatosFuncSaliente.setContentAreaFilled(false);
        btnConsultarDatosFuncSaliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarDatosFuncSaliente.setIconTextGap(5);
        btnConsultarDatosFuncSaliente.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnConsultarDatosFuncSaliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Prueba/paste_64px_opt(1).png"))); // NOI18N
        btnConsultarDatosFuncSaliente.setVerifyInputWhenFocusTarget(false);
        btnConsultarDatosFuncSaliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultarDatosFuncSaliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultarDatosFuncSaliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDatosFuncSalienteActionPerformed(evt);
            }
        });

        btnListadoPersonalFuncSaliente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnListadoPersonalFuncSaliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/listado_p.png"))); // NOI18N
        btnListadoPersonalFuncSaliente.setText("Ver Listado de Personal");
        btnListadoPersonalFuncSaliente.setToolTipText("Consultar Datos de Personal");
        btnListadoPersonalFuncSaliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnListadoPersonalFuncSaliente.setContentAreaFilled(false);
        btnListadoPersonalFuncSaliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListadoPersonalFuncSaliente.setIconTextGap(5);
        btnListadoPersonalFuncSaliente.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnListadoPersonalFuncSaliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/listado_g.png"))); // NOI18N
        btnListadoPersonalFuncSaliente.setVerifyInputWhenFocusTarget(false);
        btnListadoPersonalFuncSaliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnListadoPersonalFuncSaliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListadoPersonalFuncSaliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoPersonalFuncSalienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarDatosFuncSaliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListadoPersonalFuncSaliente)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListadoPersonalFuncSaliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarDatosFuncSaliente)
                    .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Datos Personales", jPanel71);

        tableCargoFuncSaliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableCargoFuncSaliente);

        javax.swing.GroupLayout CargoLayout = new javax.swing.GroupLayout(Cargo);
        Cargo.setLayout(CargoLayout);
        CargoLayout.setHorizontalGroup(
            CargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        CargoLayout.setVerticalGroup(
            CargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CargoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane8.addTab("Datos de Cargo", Cargo);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        txtObservacionesFuncSaliente.setColumns(20);
        txtObservacionesFuncSaliente.setRows(5);
        jScrollPane3.setViewportView(txtObservacionesFuncSaliente);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(595, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Observaciones", jPanel27);

        btnFuncSaliente.setBackground(new java.awt.Color(255, 255, 255));
        btnFuncSaliente.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnFuncSaliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnFuncSaliente.setText("Continuar Trámite");
        btnFuncSaliente.setToolTipText("Examinar...");
        btnFuncSaliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnFuncSaliente.setContentAreaFilled(false);
        btnFuncSaliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncSaliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnFuncSaliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFuncSaliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncSalienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFuncSaliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFuncSaliente)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Datos del Funcionario Saliente", jPanel11);

        panelEstudiosRealizados.setBackground(new java.awt.Color(255, 255, 255));

        panelEstudiosRealizadosTabbed.setBackground(new java.awt.Color(255, 255, 255));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));
        jPanel64.setLayout(new java.awt.GridLayout(6, 2, 0, 15));

        jLabel203.setText("Institución:");
        jPanel64.add(jLabel203);
        jPanel64.add(txtInstitucion);

        jLabel204.setText("Lugar:");
        jPanel64.add(jLabel204);
        jPanel64.add(jTextField5);

        jLabel205.setText("Año Inicio:");
        jPanel64.add(jLabel205);

        txtAñoInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoInicioActionPerformed(evt);
            }
        });
        jPanel64.add(txtAñoInicio);

        jLabel207.setText("Título Obtenido:");
        jPanel64.add(jLabel207);
        jPanel64.add(txtTitulo);

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(644, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane22.addTab("Institución:", jPanel63);

        panelEstudiosRealizadosTabbed.addTab("Estudios Realizados del Empelado", jTabbedPane22);

        btnEstudiosRealizados.setBackground(new java.awt.Color(255, 255, 255));
        btnEstudiosRealizados.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnEstudiosRealizados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnEstudiosRealizados.setText("Continuar Trámite");
        btnEstudiosRealizados.setToolTipText("Examinar...");
        btnEstudiosRealizados.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEstudiosRealizados.setContentAreaFilled(false);
        btnEstudiosRealizados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstudiosRealizados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnEstudiosRealizados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstudiosRealizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudiosRealizadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEstudiosRealizadosLayout = new javax.swing.GroupLayout(panelEstudiosRealizados);
        panelEstudiosRealizados.setLayout(panelEstudiosRealizadosLayout);
        panelEstudiosRealizadosLayout.setHorizontalGroup(
            panelEstudiosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEstudiosRealizadosTabbed)
            .addGroup(panelEstudiosRealizadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEstudiosRealizados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEstudiosRealizadosLayout.setVerticalGroup(
            panelEstudiosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstudiosRealizadosLayout.createSequentialGroup()
                .addComponent(panelEstudiosRealizadosTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstudiosRealizados)
                .addGap(0, 157, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Estudios Realizados del Empleado", panelEstudiosRealizados);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Ingrese el motivo por el cual realiza el trámite:");

        btnFinalizarTramite.setBackground(new java.awt.Color(255, 255, 255));
        btnFinalizarTramite.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnFinalizarTramite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
        btnFinalizarTramite.setText("Finalizar Trámite");
        btnFinalizarTramite.setToolTipText("Examinar...");
        btnFinalizarTramite.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnFinalizarTramite.setContentAreaFilled(false);
        btnFinalizarTramite.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinalizarTramite.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
        btnFinalizarTramite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinalizarTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarTramiteActionPerformed(evt);
            }
        });

        txtMotivoTramite.setColumns(20);
        txtMotivoTramite.setRows(5);
        jScrollPane1.setViewportView(txtMotivoTramite);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(btnFinalizarTramite)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(641, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizarTramite)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Motivo ", jPanel15);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedDocente)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedDocente, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3.add(jPanel12, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatosKeyTyped
    if (comboTipoBusqueda.getSelectedIndex()== 1) {
            if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
            {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            }
                                                  }
    }//GEN-LAST:event_txtDatosKeyTyped

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void comboTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoBusquedaActionPerformed
    txtDatos.setText("");
    if (comboTipoBusqueda.getSelectedIndex() != 0) {
    txtDatos.setEnabled(true);
                                                   }
    else {
    txtDatos.setEnabled(false);
         }
    }//GEN-LAST:event_comboTipoBusquedaActionPerformed

    private void txtDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatosActionPerformed

    }//GEN-LAST:event_txtDatosActionPerformed

    private void btnListadoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoPersonalActionPerformed
    new viewCatalagoPersonal(btnListadoPersonal,null,this,null,null,this,true,Dialog.ModalityType.MODELESS).setVisible(true);   
    }//GEN-LAST:event_btnListadoPersonalActionPerformed

    private void btnEstudiosRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudiosRealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstudiosRealActionPerformed

    private void btnDatosLaboralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosLaboralesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosLaboralesActionPerformed

    private void btnDatosBancariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosBancariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosBancariosActionPerformed

    private void btnDatosFuncSalienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosFuncSalienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosFuncSalienteActionPerformed

    private void btnDatosCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosCargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosCargosActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed
    
    public void reestablecerCargoPropuesto() {
    txtTituloObtenido.setEnabled(false);
    txtAsignatura.setEnabled(false);
    txtHorasD.setEnabled(false);
    txtHorasA.setEnabled(false);
    radioBtnFijo.setEnabled(false);
    radioBtnInt.setEnabled(false);
    panelDiurno.setEnabled(false);
    panelNocturno.setEnabled(false);
    radioBtnDiurno.setEnabled(false);
    radioBtnNocturno.setEnabled(false);
    txtCodigoNomina.setEnabled(false);
    txtGrado.setEnabled(false);
    txtPaso.setEnabled(false);
    txtSueldoMensual.setEnabled(false);
    btnCargoPropuesto.setEnabled(false);
    checkDTitular.setEnabled(false);
    checkXInterino.setEnabled(false);
    checkWInterino.setEnabled(false);
    checkBonoBolivariano.setEnabled(false);
    checkHorasVariables.setEnabled(false);
    checkDTitularNoc.setEnabled(false);
    checkXInterinoNoc.setEnabled(false);
    checkWInterinoNoc.setEnabled(false);
    btnSeleccionarPlantel.setEnabled(false);
    btnAgregarEmpresa4.setEnabled(false);
    }
    
    public void reestablecerDatosBancarios() {
    txtNumeroCuenta.setEnabled(false);
    txtAsignatura.setEnabled(false);
    txtCodigoBanc.setEnabled(false);
    comboBanco.setEnabled(false);
    comboTipoCuenta.setEnabled(false);
    txtRetroactivo.setEnabled(false);
    btnUpDatosBancarios.setEnabled(false);
    }
    
        
    public void reestablecerFuncSaliente() {
    txtCedulaFuncSaliente.setEnabled(false);
    txtDestinoFuncSaliente.setEnabled(false);
    txtObservacionesFuncSaliente.setEnabled(false);
    }
    
    public void reestablecerFinalizarTramite() {
    btnFinalizarTramite.setEnabled(false);
    txtMotivoTramite.setEnabled(false);
    }
    
    private void btnContinuarTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarTramiteActionPerformed
    if(txtCedula.getText().equals("") == false) {
    enabledTabbed(true);
    tabbedDocente.setSelectedIndex(1);
    btnDatosCargos.setEnabled(true);
    btnDatosBancarios.setEnabled(true);
    btnDatosFuncSaliente.setEnabled(true);
    btnDatosLaborales.setEnabled(true);
    btnEstudiosReal.setEnabled(true);
                                      }
    else {
	JOptionPane.showMessageDialog( new JDialog(),"Debe Consultar Datos de Personal","Mensaje de Información",JOptionPane.INFORMATION_MESSAGE);
         }
    if (comboTipoTramite.getSelectedItem().toString().equals("Suspensión")) {
    tabbedCargo.setEnabledAt(1, false);
                                                                            }
    else {
    tabbedCargo.setEnabledAt(1,true);
         }
    }//GEN-LAST:event_btnContinuarTramiteActionPerformed

    private void btnSeleccionarPlantelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPlantelActionPerformed
        new viewCatalagoPlanteles(this,null,null,null,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
    }//GEN-LAST:event_btnSeleccionarPlantelActionPerformed

    private void btnAgregarEmpresa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa4ActionPerformed
        try {
            new viewSeleccionarCargo(this,null,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(viewRegistrarCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarEmpresa4ActionPerformed

    private void radioBtnDiurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnDiurnoActionPerformed
        if(radioBtnDiurno.isSelected()==true) {
        labelDiurno.setEnabled(true);
        checkDTitular.setEnabled(true);
        checkXInterino.setEnabled(true);
        checkWInterino.setEnabled(true);
        checkBonoBolivariano.setEnabled(true);
        checkHorasVariables.setEnabled(true);
        labelNocturno.setEnabled(false);
        checkDTitularNoc.setEnabled(false);
        checkXInterinoNoc.setEnabled(false);
        checkWInterinoNoc.setEnabled(false);
        
        
                                              }
    }//GEN-LAST:event_radioBtnDiurnoActionPerformed

    private void radioBtnNocturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnNocturnoActionPerformed
        if(radioBtnNocturno.isSelected()==true) {
        labelDiurno.setEnabled(false);
        checkDTitular.setEnabled(false);
        checkXInterino.setEnabled(false);
        checkWInterino.setEnabled(false);
        checkBonoBolivariano.setEnabled(false);
        checkHorasVariables.setEnabled(false);
        labelNocturno.setEnabled(true);
        checkDTitularNoc.setEnabled(true);
        checkXInterinoNoc.setEnabled(true);
        checkWInterinoNoc.setEnabled(true);
        
                                              }
    }//GEN-LAST:event_radioBtnNocturnoActionPerformed

    private void btnUpDatosBancariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDatosBancariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpDatosBancariosActionPerformed

    private void txtFechaEfectoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaEfectoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEfectoFocusGained

    private void txtFechaEfectoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaEfectoFocusLost
        // TODO add yourf handling code here:
    }//GEN-LAST:event_txtFechaEfectoFocusLost

    private void btnEstudiosRealizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudiosRealizadosActionPerformed

    }//GEN-LAST:event_btnEstudiosRealizadosActionPerformed

    private void checkXInterinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkXInterinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkXInterinoActionPerformed

    private void comboTipoTramiteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoTramiteItemStateChanged

    }//GEN-LAST:event_comboTipoTramiteItemStateChanged

    private void txtHorasDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasDFocusLost
     int horasD = 0;
     int horasA = 0;
     int totalHoras = 0;
     

    try{
       
     horasD = Integer.parseInt(txtHorasD.getText());
     horasA = Integer.parseInt(txtHorasA.getText());
    }catch(NumberFormatException ex){ // handle your exception
       
    }

     totalHoras = horasD+horasA;
     txtTotalHoras.setText(Integer.toString(totalHoras));
    }//GEN-LAST:event_txtHorasDFocusLost

    private void txtHorasAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorasAFocusLost
     int horasD = 0;
     int horasA = 0;
     int totalHoras = 0;
       try{
       
     horasD = Integer.parseInt(txtHorasD.getText());
     horasA = Integer.parseInt(txtHorasA.getText());
    }catch(NumberFormatException ex){ // handle your exception
       
    }
     totalHoras = horasD+horasA;
     txtTotalHoras.setText(Integer.toString(totalHoras));
    }//GEN-LAST:event_txtHorasAFocusLost

    private void btnFuncSalienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncSalienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFuncSalienteActionPerformed

    private void btnFinalizarTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarTramiteActionPerformed
     
    }//GEN-LAST:event_btnFinalizarTramiteActionPerformed

    private void btnConsultarDatosFuncSalienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDatosFuncSalienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarDatosFuncSalienteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      if (btnFinalizarTramite.isEnabled() == true) {
      
                                                 
        int seleccion = JOptionPane.showOptionDialog(
            null,
            "No ha finalizado el trámite y se perderá la información introducida hasta el momento. ¿Está seguro de que desea salir? ",
            "Salir",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,    // null para icono por defecto.
            null,   // null para YES, NO y CANCEL
            null);

        if (seleccion != -1)
            
        if(seleccion == 0) {
        controllerTramitesAdministrativos controller = new controllerTramitesAdministrativos(this);
            try {
                controller.deshacerCambios();
            } catch (SQLException ex) {
                Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.dispose();    
           
        }
        else {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
             }
                                                       }
      else {this.dispose();}
    }//GEN-LAST:event_formWindowClosing

    private void btnListadoPersonalFuncSalienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoPersonalFuncSalienteActionPerformed
    new viewCatalagoPersonal(null,btnListadoPersonalFuncSaliente,this,null,null,this,true,Dialog.ModalityType.MODELESS).setVisible(true);
    }//GEN-LAST:event_btnListadoPersonalFuncSalienteActionPerformed

    private void txtAñoInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoInicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewTramitesAdministrativos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewTramitesAdministrativos(new javax.swing.JFrame(), true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
                } catch (SQLException ex) {
                    
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cargo;
    private javax.swing.JButton btnAgregarEmpresa4;
    private javax.swing.JButton btnCargoPropuesto;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarDatosFuncSaliente;
    private javax.swing.JButton btnContinuarTramite;
    private javax.swing.JButton btnDatosBancarios;
    private javax.swing.JButton btnDatosCargos;
    private javax.swing.JButton btnDatosFuncSaliente;
    private javax.swing.JButton btnDatosLaborales;
    private javax.swing.JButton btnEstudiosReal;
    private javax.swing.JButton btnEstudiosRealizados;
    private javax.swing.JButton btnFinalizarTramite;
    private javax.swing.JButton btnFuncSaliente;
    private javax.swing.JButton btnListadoPersonal;
    private javax.swing.JButton btnListadoPersonalFuncSaliente;
    private javax.swing.JButton btnSeleccionarPlantel;
    private javax.swing.JButton btnUpDatosBancarios;
    private javax.swing.JRadioButton checkBonoBolivariano;
    private javax.swing.JCheckBox checkCargoAdicional;
    private javax.swing.JRadioButton checkDTitular;
    private javax.swing.JRadioButton checkDTitularNoc;
    private javax.swing.JRadioButton checkHorasVariables;
    private javax.swing.JRadioButton checkWInterino;
    private javax.swing.JRadioButton checkWInterinoNoc;
    private javax.swing.JRadioButton checkXInterino;
    private javax.swing.JRadioButton checkXInterinoNoc;
    private javax.swing.JComboBox comboBanco;
    private javax.swing.JComboBox comboMunicipio;
    private javax.swing.JComboBox comboTipoBusqueda;
    private javax.swing.JComboBox comboTipoCuenta;
    private javax.swing.JComboBox comboTipoTramite;
    private javax.swing.ButtonGroup groupBtnDiurno;
    private javax.swing.ButtonGroup groupBtnFijoInt;
    private javax.swing.ButtonGroup groupBtnNoc;
    private javax.swing.ButtonGroup groupBtnTurno;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane22;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel labelDiurno;
    private javax.swing.JLabel labelNocturno;
    private javax.swing.JPanel panelDiurno;
    private javax.swing.JPanel panelDiurno1;
    private javax.swing.JPanel panelEstudiosRealizados;
    private javax.swing.JTabbedPane panelEstudiosRealizadosTabbed;
    private javax.swing.JPanel panelNocturno;
    private javax.swing.JRadioButton radioBtnDiurno;
    private javax.swing.JRadioButton radioBtnFijo;
    private javax.swing.JRadioButton radioBtnInt;
    private javax.swing.JRadioButton radioBtnNocturno;
    private javax.swing.JTabbedPane tabbedCargo;
    private javax.swing.JPanel tabbedCargoPropuesto;
    private javax.swing.JTabbedPane tabbedDocente;
    public javax.swing.JTable tableCargoActual;
    private javax.swing.JTable tableCargoFuncSaliente;
    private javax.swing.JLabel txtApellidos;
    private javax.swing.JLabel txtApellidosNombreFuncSaliente;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtAñoInicio;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JTextField txtCedulaFuncSaliente;
    private javax.swing.JLabel txtCodCargo;
    private javax.swing.JLabel txtCodPlantel;
    private javax.swing.JTextField txtCodigoBanc;
    private javax.swing.JTextField txtCodigoNomina;
    private javax.swing.JTextField txtDatos;
    private javax.swing.JLabel txtDenCargo;
    private javax.swing.JTextField txtDestinoFuncSaliente;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtEstado1;
    private javax.swing.JLabel txtEstadoCivil;
    private com.toedter.calendar.JDateChooser txtFechaEfecto;
    private javax.swing.JLabel txtFechaNac;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHorasA;
    private javax.swing.JTextField txtHorasD;
    private javax.swing.JTextField txtInstitucion;
    private javax.swing.JTextArea txtMotivoTramite;
    private javax.swing.JLabel txtMunicipio;
    private javax.swing.JLabel txtMunicipio1;
    private javax.swing.JLabel txtNacionalidad;
    private javax.swing.JLabel txtNacionalizado;
    private javax.swing.JLabel txtNombrePlantel;
    private javax.swing.JLabel txtNombres;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtNumeroZonaEducativa;
    private javax.swing.JTextArea txtObservacionesFuncSaliente;
    private javax.swing.JTextField txtPaso;
    private javax.swing.JTextArea txtRetroactivo;
    private javax.swing.JLabel txtSector;
    private javax.swing.JLabel txtSector1;
    private javax.swing.JTextField txtSueldoMensual;
    private javax.swing.JLabel txtTipoPersonal;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTituloObtenido;
    private javax.swing.JLabel txtTotalHoras;
    // End of variables declaration//GEN-END:variables
}
