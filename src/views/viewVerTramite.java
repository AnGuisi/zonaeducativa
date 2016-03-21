/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewVerTramite extends javax.swing.JDialog {
    private OSValidator validarOS;
    private int id_direccion = 0;
    

    /**
     * Creates new form viewConsultarDatosPersonal
     */
    public viewVerTramite(java.awt.Dialog parent, boolean modal,ModalityType modalityType) throws SQLException {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        initComponents();
        this.setTitle("Trámites Administrativos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InicializacionEventos();
       
      
                                        }

    
    private void InicializacionEventos() {

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
    txtCodigoCargo.setText("");
    txtPlantel.setText("");
    txtCargo.setText("");
    txtCargaHoraria.setText("");
    txtSueldo.setText("");
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
    public void setTxtCodCargoFuncSaliente(String CodCargoFuncSaliente) {
        txtCodCargoFuncSaliente.setText(CodCargoFuncSaliente);
    }

    public void setTxtDestinoFuncSaliente(String DestinoFuncSaliente) {
        txtDestinoFuncSaliente.setText(DestinoFuncSaliente);
    }

    public void setTxtObservacionesFuncSaliente(String ObservacionesFuncSaliente) {
        txtObservacionesFuncSaliente.setText(ObservacionesFuncSaliente);
    }

    public void setTxtCedulaFuncSaliente(String CedulaFuncSaliente) {
        txtCedulaFuncSaliente.setText(CedulaFuncSaliente);
    }

    public void setTxtCodDependenciaFuncSaliente(String CodDependenciaFuncSaliente) {
        txtCodDependenciaFuncSaliente.setText(CodDependenciaFuncSaliente);
    }

    public void setTxtNombresFuncSaliente(String NombresFuncSaliente) {
        txtNombresFuncSaliente.setText(NombresFuncSaliente);
    }


    public JButton getGenerarReporteObreroAdm() {
        return generarReporteObreroAdm;
    }

    public String getTxtTipoPersonal() {
        return txtTipoPersonal.getText();
    }

    public JTable getTableHistorialCambios() {
        return tableHistorialCambios;
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

    public void setTxtCargo(String Cargo) {
        txtCargo.setText(Cargo);
    }

    public void setTxtCodigoCargo(String CodigoCargo) {
        txtCodigoCargo.setText(CodigoCargo);
    }

    public void setTxtPlantel(String Plantel) {
        txtPlantel.setText(Plantel);
    }

    public void setTxtCargaHoraria(String CargaHoraria) {
        txtCargaHoraria.setText(CargaHoraria);
    }

    public void setTxtSueldo(String Sueldo) {
        txtSueldo.setText(Sueldo);
    }

    public String getTxtAsignatura() {
        return txtCodCargo.getText();
    }

    public String getTxtCodCargo() {
        return txtCodCargo.getText();
    }

    public void setTxtNombrePlantel(String NombrePlantel) {
        txtNombrePlantel.setText(NombrePlantel);
    }

    public void setTxtCodCargo(String CodCargo) {
        txtCodCargo.setText(CodCargo);
    }

    public void setTxtDenCargo(String DenCargo) {
        txtDenominacionCargo.setText(DenCargo);
    }


    public void setTxtCodigoBanc(String CodigoBanc) {
        txtCodigoBanc.setText(CodigoBanc);
    }

    public void setTxtNumeroCuenta(String NumeroCuenta) {
        txtNumeroCuenta.setText(NumeroCuenta);
    }

    public void setTxtEstadoZona(String EstadoZona) {
        txtEstadoZona.setText(EstadoZona);
    }

    public void setTxtFechaEfecto(Date FechaEfecto) {
        txtFechaEfecto.setDate(FechaEfecto);
    }

    public void setTxtNumeroZonaEducativa(String NumeroZonaEducativa) {
        txtNumeroZonaEducativa.setText(NumeroZonaEducativa);
    }

    public void setTxtTipoTramite(String TipoTramite) {
        txtTipoTramite.setText(TipoTramite);
    }

    public JCheckBox getCheckCargoAdicional() {
        return checkCargoAdicional;
    }

    public void setTxtCodigoDependencia(String CodigoDependencia) {
        txtCodigoDependencia.setText(CodigoDependencia);
    }

    public void setTxtDenominacionCargo(String DenominacionCargo) {
        txtDenominacionCargo.setText(DenominacionCargo);
    }

    public void setTxtTituloObtenido(String TituloObtenido) {
        txtTituloObtenido.setText(TituloObtenido);
    }

    public void setTxtAsignatura(String Asignatura) {
        txtAsignatura.setText(Asignatura);
    }

    public void setTxtHorasA(String HorasA) {
        txtHorasA.setText(HorasA);
    }

    public void setTxtHorasD(String HorasD) {
        txtHorasD.setText(HorasD);
    }

    public void setTxtTotalHoras(String TotalHoras) {
        txtTotalHoras.setText(TotalHoras);
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

    public void setTxtDTitular(String DTitular) {
        txtDTitular.setText(DTitular);
    }

    public void setTxtDTitularNoc(String DTitularNoc) {
        txtDTitularNoc.setText(DTitularNoc);
    }

    public void setTxtWInterino(String WInterino) {
        txtWInterino.setText(WInterino);
    }

    public void setTxtWInterinoNoc(String WInterinoNoc) {
        txtWInterinoNoc.setText(WInterinoNoc);
    }

    public void setTxtXInterino(String XInterino) {
        txtXInterino.setText(XInterino);
    }

    public void setTxtXInterinoNoc(String XInterinoNoc) {
        txtXInterinoNoc.setText(XInterinoNoc);
    }

    public void setTxtBonoBolivariano(String BonoBolivariano) {
        txtBonoBolivariano.setText(BonoBolivariano);
    }

    public void setTxtHorasVariables(String HorasVariables) {
        txtHorasVariables.setText(HorasVariables);
    }

    public void setTxtCodigoNomina(String CodigoNomina) {
        txtCodigoNomina.setText(CodigoNomina);
    }

    public void setTxtGrado(String Grado) {
        txtGrado.setText(Grado);
    }

    public void setTxtPaso(String Paso) {
        txtPaso.setText(Paso);
    }

    public void setTxtSueldoMensual(String SueldoMensual) {
        txtSueldoMensual.setText(SueldoMensual);
    }

    public void setTxtBanco(String Banco) {
        txtBanco.setText(Banco);
    }

    public void setTxtRetroactivo(String Retroactivo) {
        txtRetroactivo.setText(Retroactivo);
    }

    public JTextField getTxtWInterino() {
        return txtWInterino;
    }

    public JTextField getTxtWInterinoNoc() {
        return txtWInterinoNoc;
    }

    public JTextField getTxtXInterino() {
        return txtXInterino;
    }

    public JTextField getTxtXInterinoNoc() {
        return txtXInterinoNoc;
    }

    public JTextField getTxtBonoBolivariano() {
        return txtBonoBolivariano;
    }

    public JTextField getTxtDTitularNoc() {
        return txtDTitularNoc;
    }

    public JTextField getTxtHorasVariables() {
        return txtHorasVariables;
    }

    public JTextField getTxtDTitular() {
        return txtDTitular;
    }

    public void setTxtTipoCuenta(String TipoCuenta) {
        txtTipoCuenta.setText(TipoCuenta);
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
        jLabel2 = new javax.swing.JLabel();
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
        txtEstadoZona = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNumeroZonaEducativa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTipoTramite = new javax.swing.JTextField();
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
        jPanel50 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        txtCodigoCargo = new javax.swing.JLabel();
        txtPlantel = new javax.swing.JLabel();
        txtCargo = new javax.swing.JLabel();
        txtCargaHoraria = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        txtCodigoDependencia = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        txtNombrePlantel = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        txtCodCargo = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        txtDenominacionCargo = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        txtTituloObtenido = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        txtAsignatura = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        txtHorasA = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        txtHorasD = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        txtTotalHoras = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        radioBtnFijo = new javax.swing.JRadioButton();
        radioBtnInt = new javax.swing.JRadioButton();
        jPanel26 = new javax.swing.JPanel();
        panelDiurno = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        txtDTitular = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        txtXInterino = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        txtWInterino = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        txtHorasVariables = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        txtBonoBolivariano = new javax.swing.JTextField();
        labelDiurno = new javax.swing.JLabel();
        labelNocturno = new javax.swing.JLabel();
        panelNocturno = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        txtDTitularNoc = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        txtXInterinoNoc = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        txtWInterinoNoc = new javax.swing.JTextField();
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
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel70 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        txtNumeroCuenta = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        txtCodigoBanc = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        txtTipoCuenta = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRetroactivo = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel71 = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        txtCedulaFuncSaliente = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        txtNombresFuncSaliente = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txtCodDependenciaFuncSaliente = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        txtCodCargoFuncSaliente = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        txtDestinoFuncSaliente = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesFuncSaliente = new javax.swing.JTextArea();
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
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistorialCambios = new javax.swing.JTable();
        generarReporteObreroAdm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Trámites Administrativos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(jLabel2)
                .addGap(398, 398, 398))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txtFechaEfecto.setEnabled(false);
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

        txtEstadoZona.setEnabled(false);
        jPanel14.add(txtEstadoZona);

        jLabel15.setText("Zona Educativa Número:");
        jPanel14.add(jLabel15);

        txtNumeroZonaEducativa.setEnabled(false);
        jPanel14.add(txtNumeroZonaEducativa);

        jLabel10.setText("Tipo de Trámite:");
        jPanel14.add(jLabel10);

        txtTipoTramite.setEnabled(false);
        jPanel14.add(txtTipoTramite);

        checkCargoAdicional.setBackground(new java.awt.Color(255, 255, 255));
        checkCargoAdicional.setText("Cargo Adicional");
        checkCargoAdicional.setEnabled(false);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 830, Short.MAX_VALUE))
        );

        jScrollPane22.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        tabbedDocente.addTab("Datos Personales", jPanel25);

        jTabbedPane4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cargo Anterior"));

        jPanel53.setBackground(new java.awt.Color(204, 204, 204));
        jPanel53.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Código");
        jLabel11.setOpaque(true);
        jPanel53.add(jLabel11);

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Dependencia");
        jLabel25.setOpaque(true);
        jPanel53.add(jLabel25);

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Cargo");
        jLabel26.setOpaque(true);
        jPanel53.add(jLabel26);

        jLabel96.setBackground(new java.awt.Color(204, 204, 204));
        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Carga Horaria");
        jLabel96.setOpaque(true);
        jPanel53.add(jLabel96);

        jLabel97.setBackground(new java.awt.Color(204, 204, 204));
        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Salario");
        jLabel97.setOpaque(true);
        jPanel53.add(jLabel97);

        jPanel54.setBackground(new java.awt.Color(238, 238, 238));
        jPanel54.setLayout(new java.awt.GridLayout(1, 0));

        txtCodigoCargo.setBackground(new java.awt.Color(238, 238, 238));
        txtCodigoCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCodigoCargo.setOpaque(true);
        jPanel54.add(txtCodigoCargo);

        txtPlantel.setBackground(new java.awt.Color(238, 238, 238));
        txtPlantel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPlantel.setOpaque(true);
        jPanel54.add(txtPlantel);

        txtCargo.setBackground(new java.awt.Color(238, 238, 238));
        txtCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCargo.setOpaque(true);
        jPanel54.add(txtCargo);

        txtCargaHoraria.setBackground(new java.awt.Color(238, 238, 238));
        txtCargaHoraria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCargaHoraria.setOpaque(true);
        jPanel54.add(txtCargaHoraria);

        txtSueldo.setBackground(new java.awt.Color(238, 238, 238));
        txtSueldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSueldo.setOpaque(true);
        jPanel54.add(txtSueldo);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
            .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel52Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                        .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
            .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel52Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 319, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Datos del Cargo Anterior", jPanel51);

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setLayout(new java.awt.GridLayout(6, 2, 0, 8));

        jLabel98.setText("Código de Dependencia:");
        jPanel66.add(jLabel98);

        txtCodigoDependencia.setEnabled(false);
        jPanel66.add(txtCodigoDependencia);

        jLabel131.setText("Nombre del Plantel:");
        jPanel66.add(jLabel131);

        txtNombrePlantel.setEnabled(false);
        jPanel66.add(txtNombrePlantel);

        jLabel132.setText("Código de Cargo:");
        jPanel66.add(jLabel132);

        txtCodCargo.setEnabled(false);
        jPanel66.add(txtCodCargo);

        jLabel133.setText("Denominación del Cargo:");
        jPanel66.add(jLabel133);

        txtDenominacionCargo.setEnabled(false);
        jPanel66.add(txtDenominacionCargo);

        jLabel134.setText("Título Obtenido:");
        jPanel66.add(jLabel134);

        txtTituloObtenido.setEnabled(false);
        jPanel66.add(txtTituloObtenido);

        jLabel135.setText("Asignatura:");
        jPanel66.add(jLabel135);

        txtAsignatura.setEnabled(false);
        jPanel66.add(txtAsignatura);

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Dependencia", jPanel65);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setLayout(new java.awt.GridLayout(3, 2, 0, 8));

        jLabel136.setText("Horas Administrativas:");
        jPanel67.add(jLabel136);

        txtHorasA.setEnabled(false);
        jPanel67.add(txtHorasA);

        jLabel137.setText("Horas Académicas:");
        jPanel67.add(jLabel137);

        txtHorasD.setEnabled(false);
        jPanel67.add(txtHorasD);

        jLabel138.setText("Total:");
        jPanel67.add(jLabel138);
        jPanel67.add(txtTotalHoras);

        jLabel139.setText("Tipo Nombr:");

        radioBtnFijo.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnFijoInt.add(radioBtnFijo);
        radioBtnFijo.setText("Fijo");
        radioBtnFijo.setEnabled(false);

        radioBtnInt.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnFijoInt.add(radioBtnInt);
        radioBtnInt.setText("Int");
        radioBtnInt.setEnabled(false);

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
                .addContainerGap(401, Short.MAX_VALUE))
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

        jLabel140.setText("D Titular:");
        panelDiurno.add(jLabel140);

        txtDTitular.setEnabled(false);
        panelDiurno.add(txtDTitular);

        jLabel141.setText("X Interino (S/P)");
        panelDiurno.add(jLabel141);

        txtXInterino.setEnabled(false);
        panelDiurno.add(txtXInterino);

        jLabel142.setText("W Intr. (P/CONCUR)");
        panelDiurno.add(jLabel142);

        txtWInterino.setEnabled(false);
        panelDiurno.add(txtWInterino);

        jLabel143.setText("A horas variables:");
        panelDiurno.add(jLabel143);

        txtHorasVariables.setEnabled(false);
        panelDiurno.add(txtHorasVariables);

        jLabel144.setText("Bono Bolivariano:");
        panelDiurno.add(jLabel144);

        txtBonoBolivariano.setEnabled(false);
        panelDiurno.add(txtBonoBolivariano);

        labelDiurno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelDiurno.setText("Diurno:");
        labelDiurno.setEnabled(false);

        labelNocturno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNocturno.setText("Nocturno:");
        labelNocturno.setEnabled(false);

        panelNocturno.setBackground(new java.awt.Color(255, 255, 255));
        panelNocturno.setLayout(new java.awt.GridLayout(3, 2, 0, 8));

        jLabel145.setText("D Titular:");
        panelNocturno.add(jLabel145);

        txtDTitularNoc.setEnabled(false);
        panelNocturno.add(txtDTitularNoc);

        jLabel146.setText("Y Interino (S/P)");
        panelNocturno.add(jLabel146);

        txtXInterinoNoc.setEnabled(false);
        panelNocturno.add(txtXInterinoNoc);

        jLabel147.setText("X Inter. (P/CON)");
        panelNocturno.add(jLabel147);

        txtWInterinoNoc.setEnabled(false);
        panelNocturno.add(txtWInterinoNoc);

        jLabel12.setText("Turno:");

        radioBtnDiurno.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnTurno.add(radioBtnDiurno);
        radioBtnDiurno.setText("Diurno");
        radioBtnDiurno.setEnabled(false);
        radioBtnDiurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnDiurnoActionPerformed(evt);
            }
        });

        radioBtnNocturno.setBackground(new java.awt.Color(255, 255, 255));
        groupBtnTurno.add(radioBtnNocturno);
        radioBtnNocturno.setText("Nocturno");
        radioBtnNocturno.setEnabled(false);
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
                        .addComponent(radioBtnNocturno))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDiurno, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDiurno))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNocturno)
                            .addComponent(panelNocturno, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(radioBtnDiurno)
                    .addComponent(radioBtnNocturno))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDiurno)
                    .addComponent(labelNocturno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDiurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelNocturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane5.addTab("Turno", jPanel26);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelDiurno1.setBackground(new java.awt.Color(255, 255, 255));
        panelDiurno1.setLayout(new java.awt.GridLayout(5, 2, 0, 8));

        jLabel152.setText("Código Nómina:");
        panelDiurno1.add(jLabel152);

        txtCodigoNomina.setEnabled(false);
        panelDiurno1.add(txtCodigoNomina);

        jLabel153.setText("Grado:");
        panelDiurno1.add(jLabel153);

        txtGrado.setEnabled(false);
        panelDiurno1.add(txtGrado);

        jLabel154.setText("Paso:");
        panelDiurno1.add(jLabel154);

        txtPaso.setEnabled(false);
        panelDiurno1.add(txtPaso);

        jLabel155.setText("Sueldo Mensual:");
        panelDiurno1.add(jLabel155);

        txtSueldoMensual.setEnabled(false);
        panelDiurno1.add(txtSueldoMensual);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDiurno1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDiurno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Otros Datos", jPanel1);

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 250, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Datos del Cargo Propuesto", jPanel59);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        tabbedDocente.addTab("Datos de Cargos", jPanel50);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new java.awt.GridLayout(4, 2, 0, 8));

        jLabel80.setText("Nº Cuenta Bancaria:");
        jPanel36.add(jLabel80);

        txtNumeroCuenta.setEnabled(false);
        jPanel36.add(txtNumeroCuenta);

        jLabel99.setText("Código:");
        jPanel36.add(jLabel99);

        txtCodigoBanc.setEnabled(false);
        jPanel36.add(txtCodigoBanc);

        jLabel110.setText("Banco:");
        jPanel36.add(jLabel110);

        txtBanco.setEnabled(false);
        jPanel36.add(txtBanco);

        jLabel111.setText("Tipo de Cuenta:");
        jPanel36.add(jLabel111);

        txtTipoCuenta.setEnabled(false);
        jPanel36.add(txtTipoCuenta);

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
        txtRetroactivo.setEnabled(false);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 625, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 242, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Datos Bancarios", jPanel6);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setLayout(new java.awt.GridLayout(5, 2, 0, 8));

        jLabel112.setText("Cédula de Identidad:");
        jPanel72.add(jLabel112);

        txtCedulaFuncSaliente.setEnabled(false);
        jPanel72.add(txtCedulaFuncSaliente);

        jLabel118.setText("Apellidos y Nombres:");
        jPanel72.add(jLabel118);

        txtNombresFuncSaliente.setEnabled(false);
        jPanel72.add(txtNombresFuncSaliente);

        jLabel113.setText("Dependencia:");
        jPanel72.add(jLabel113);

        txtCodDependenciaFuncSaliente.setEnabled(false);
        jPanel72.add(txtCodDependenciaFuncSaliente);

        jLabel114.setText("Código Cargo:");
        jPanel72.add(jLabel114);

        txtCodCargoFuncSaliente.setEnabled(false);
        jPanel72.add(txtCodCargoFuncSaliente);

        jLabel119.setText("Destino del Funcionario Saliente:");
        jPanel72.add(jLabel119);

        txtDestinoFuncSaliente.setEnabled(false);
        jPanel72.add(txtDestinoFuncSaliente);

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(602, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Datos Personales", jPanel71);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        txtObservacionesFuncSaliente.setColumns(20);
        txtObservacionesFuncSaliente.setRows(5);
        txtObservacionesFuncSaliente.setEnabled(false);
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
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Observaciones", jPanel27);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
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
                .addContainerGap(651, Short.MAX_VALUE))
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

        javax.swing.GroupLayout panelEstudiosRealizadosLayout = new javax.swing.GroupLayout(panelEstudiosRealizados);
        panelEstudiosRealizados.setLayout(panelEstudiosRealizadosLayout);
        panelEstudiosRealizadosLayout.setHorizontalGroup(
            panelEstudiosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEstudiosRealizadosTabbed)
        );
        panelEstudiosRealizadosLayout.setVerticalGroup(
            panelEstudiosRealizadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstudiosRealizadosLayout.createSequentialGroup()
                .addComponent(panelEstudiosRealizadosTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 234, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Estudios Realizados del Empleado", panelEstudiosRealizados);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        tableHistorialCambios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableHistorialCambios);

        generarReporteObreroAdm.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        generarReporteObreroAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_p.png"))); // NOI18N
        generarReporteObreroAdm.setText("Generar Reporte");
        generarReporteObreroAdm.setToolTipText("Seleccionar");
        generarReporteObreroAdm.setAlignmentY(0.0F);
        generarReporteObreroAdm.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        generarReporteObreroAdm.setContentAreaFilled(false);
        generarReporteObreroAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generarReporteObreroAdm.setIconTextGap(0);
        generarReporteObreroAdm.setMargin(new java.awt.Insets(10, 14, 2, 14));
        generarReporteObreroAdm.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_g.png"))); // NOI18N
        generarReporteObreroAdm.setVerifyInputWhenFocusTarget(false);
        generarReporteObreroAdm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        generarReporteObreroAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteObreroAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 276, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generarReporteObreroAdm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generarReporteObreroAdm)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        tabbedDocente.addTab("Historial de Cambios", jPanel15);

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

    private void radioBtnDiurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnDiurnoActionPerformed
        if(radioBtnDiurno.isSelected()==true) {
        labelDiurno.setEnabled(true);
        txtDTitular.setEnabled(true);
        txtXInterino.setEnabled(true);
        txtWInterino.setEnabled(true);
        txtBonoBolivariano.setEnabled(true);
        txtHorasVariables.setEnabled(true);
        labelNocturno.setEnabled(false);
        txtDTitularNoc.setEnabled(false);
        txtXInterinoNoc.setEnabled(false);
        txtWInterinoNoc.setEnabled(false);
        
        
                                              }
    }//GEN-LAST:event_radioBtnDiurnoActionPerformed

    private void radioBtnNocturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnNocturnoActionPerformed
        if(radioBtnNocturno.isSelected()==true) {
        labelDiurno.setEnabled(false);
        txtDTitular.setEnabled(false);
        txtXInterino.setEnabled(false);
        txtWInterino.setEnabled(false);
        txtBonoBolivariano.setEnabled(false);
        txtHorasVariables.setEnabled(false);
        labelNocturno.setEnabled(true);
        txtDTitularNoc.setEnabled(true);
        txtXInterinoNoc.setEnabled(true);
        txtWInterinoNoc.setEnabled(true);
        
                                              }
    }//GEN-LAST:event_radioBtnNocturnoActionPerformed

    private void txtFechaEfectoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaEfectoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEfectoFocusGained

    private void txtFechaEfectoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaEfectoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEfectoFocusLost

    private void generarReporteObreroAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteObreroAdmActionPerformed
      
    }//GEN-LAST:event_generarReporteObreroAdmActionPerformed

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
            java.util.logging.Logger.getLogger(viewVerTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewVerTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewVerTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewVerTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewVerTramite(new javax.swing.JDialog(), true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(viewVerTramite.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatosBancarios;
    private javax.swing.JButton btnDatosCargos;
    private javax.swing.JButton btnDatosFuncSaliente;
    private javax.swing.JButton btnDatosLaborales;
    private javax.swing.JButton btnEstudiosReal;
    private javax.swing.JCheckBox checkCargoAdicional;
    private javax.swing.JButton generarReporteObreroAdm;
    private javax.swing.ButtonGroup groupBtnFijoInt;
    private javax.swing.ButtonGroup groupBtnTurno;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
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
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
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
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel59;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane22;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
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
    private javax.swing.JTabbedPane tabbedDocente;
    private javax.swing.JTable tableHistorialCambios;
    private javax.swing.JLabel txtApellidos;
    private javax.swing.JTextField txtAsignatura;
    private javax.swing.JTextField txtAñoInicio;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtBonoBolivariano;
    private javax.swing.JLabel txtCargaHoraria;
    private javax.swing.JLabel txtCargo;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JTextField txtCedulaFuncSaliente;
    private javax.swing.JTextField txtCodCargo;
    private javax.swing.JTextField txtCodCargoFuncSaliente;
    private javax.swing.JTextField txtCodDependenciaFuncSaliente;
    private javax.swing.JTextField txtCodigoBanc;
    private javax.swing.JLabel txtCodigoCargo;
    private javax.swing.JTextField txtCodigoDependencia;
    private javax.swing.JTextField txtCodigoNomina;
    private javax.swing.JTextField txtDTitular;
    private javax.swing.JTextField txtDTitularNoc;
    private javax.swing.JTextField txtDenominacionCargo;
    private javax.swing.JTextField txtDestinoFuncSaliente;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtEstado1;
    private javax.swing.JLabel txtEstadoCivil;
    private javax.swing.JTextField txtEstadoZona;
    private com.toedter.calendar.JDateChooser txtFechaEfecto;
    private javax.swing.JLabel txtFechaNac;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHorasA;
    private javax.swing.JTextField txtHorasD;
    private javax.swing.JTextField txtHorasVariables;
    private javax.swing.JTextField txtInstitucion;
    private javax.swing.JLabel txtMunicipio;
    private javax.swing.JLabel txtMunicipio1;
    private javax.swing.JLabel txtNacionalidad;
    private javax.swing.JLabel txtNacionalizado;
    private javax.swing.JTextField txtNombrePlantel;
    private javax.swing.JLabel txtNombres;
    private javax.swing.JTextField txtNombresFuncSaliente;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtNumeroZonaEducativa;
    private javax.swing.JTextArea txtObservacionesFuncSaliente;
    private javax.swing.JTextField txtPaso;
    private javax.swing.JLabel txtPlantel;
    private javax.swing.JTextArea txtRetroactivo;
    private javax.swing.JLabel txtSector;
    private javax.swing.JLabel txtSector1;
    private javax.swing.JLabel txtSueldo;
    private javax.swing.JTextField txtSueldoMensual;
    private javax.swing.JTextField txtTipoCuenta;
    private javax.swing.JLabel txtTipoPersonal;
    private javax.swing.JTextField txtTipoTramite;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTituloObtenido;
    private javax.swing.JLabel txtTotalHoras;
    private javax.swing.JTextField txtWInterino;
    private javax.swing.JTextField txtWInterinoNoc;
    private javax.swing.JTextField txtXInterino;
    private javax.swing.JTextField txtXInterinoNoc;
    // End of variables declaration//GEN-END:variables
}
