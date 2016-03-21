/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import controllers.controllerConsultarDatosPersonal;
import controllers.controllerDatosPersonales;
import controllers.controllerEstado;
import controllers.controllerFichaPersonal;
import controllers.controllerRegistrarGrado1;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utilities.OSValidator;


/**
 *
 * @author Gleycer
 */
public class viewFichaPersonal extends javax.swing.JDialog {
    private OSValidator validarOS;
    private controllerDatosPersonales controllerDatosPersonales;

    /**
     * Creates new form ViewFichaPersonal2
     */
    public viewFichaPersonal(java.awt.Frame parent, boolean modal, ModalityType modalityType) throws SQLException {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        initComponents();
        this.setTitle("Ficha Personal");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        CargarComboEstado();
        InicializacionEventos();
        txtFechaNac.setDate(java.sql.Date.valueOf("1950-01-01"));
                                                                                                                  }

    
    private void InicializacionEventos() {
    controllerFichaPersonal controlador = new controllerFichaPersonal (this);
    controllerDatosPersonales controllerDatosPersonales = new controllerDatosPersonales(this);
    controllerRegistrarGrado1 controllerRegistrarGrado1 = new controllerRegistrarGrado1(this);
    
    comboNacionalidad.addActionListener(controlador);
    comboEstado.addActionListener(controlador);
    comboMunicipio.addActionListener(controlador);
    comboEstado2.addActionListener(controlador);
    comboMunicipio2.addActionListener(controlador);
    btnDatosPersonales.addActionListener(controllerDatosPersonales);
    btnRegistrarGrado1.addActionListener(controllerRegistrarGrado1);
                                         }

    public void CargarComboEstado() throws SQLException {
    List ListItem = controllerEstado.CargarEstados();
    int i;
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
    comboEstado2.addItem(ListItem.get(i));
                                }
                          }
                                                        }

    public JButton getBtnRegistrarGrado1() {
        return btnRegistrarGrado1;
    }

    public Date getTxtFechaDesdeP() {
        return txtFechaDesdeP.getDate();
    }

    public Date getTxtFechaHastaP() {
        return txtFechaHastaP.getDate();
    }

    public String getTxtCodigoPrimaria() {
        return txtCodigoPrimaria.getText();
    }

    public String getTxtLugarPrimaria() {
        return txtLugarPrimaria.getText();
    }

    public String getTxtNombrePrimaria() {
        return txtNombrePrimaria.getText();
    }

    public String getTxtCodigoSuperior() {
        return txtCodigoSuperior.getText();
    }

    public void setTxtCodigoSuperior(String CodigoSuperior) {
        txtCodigoSuperior.setText(CodigoSuperior);
    }

    public String getTxtLugarSuperior() {
        return txtLugarSuperior.getText();
    }

    public void setTxtLugarSuperior(String LugarSuperior) {
        txtLugarSuperior.setText(LugarSuperior);
    }

    public String getTxtNombreSuperior() {
        return txtNombreSuperior.getText();
    }

    public void setTxtNombreSuperior(String NombreSuperior) {
        txtNombreSuperior.setText(NombreSuperior);
    }

    public JTable getTableInasistencias() {
        return tableInasistencias;
    }

    public JTable getTableHojaServicio() {
        return tableHojaServicio;
    }

    public JTable getTableCargoActual() {
        return tableCargoActual;
    }
    
    public void setTxtNombrePrimaria(String NombrePrimaria) {
        txtNombrePrimaria.setText(NombrePrimaria);
    }

    public void setTxtLugarPrimaria(String LugarPrimaria) {
       txtLugarPrimaria.setText(LugarPrimaria);
    }

    public JButton getBtnDatosPersonales() {
        return btnDatosPersonales;
    }

    public JComboBox getComboEstado() {
        return comboEstado;
    }

    public JComboBox getComboEstado2() {
        return comboEstado2;
    }

    public JComboBox getComboMunicipio2() {
        return comboMunicipio2;
    }

    public JComboBox getComboSector2() {
        return comboSector2;
    }

    public void setComboEstado(JComboBox comboEstado) {
        this.comboEstado = comboEstado;
    }

    public JComboBox getComboMunicipio() {
        return comboMunicipio;
    }

    public void setComboMunicipio(JComboBox comboMunicipio) {
        this.comboMunicipio = comboMunicipio;
    }

    public JComboBox getComboNacionalidad() {
        return comboNacionalidad;
    }

    public void setComboNacionalidad(JComboBox comboNacionalidad) {
        this.comboNacionalidad = comboNacionalidad;
    }

    public JComboBox getComboSector() {
        return comboSector;
    }

    public JComboBox getComboTipoPersonal() {
        return comboTipoPersonal;
    }

    public String getTxtApellidos() {
        return txtApellidos.getText();
    }

    public String getTxtCedula() {
        return txtCedula.getText();
    }

    public String getTxtNombres() {
        return txtNombres.getText();
    }

    public JComboBox getComboEstadoCivil() {
        return comboEstadoCivil;
    }

    public String getTxtDireccion() {
        return txtDireccion.getText();
    }

    public Date getTxtFechaNac() {
        return txtFechaNac.getDate();
    }

    public String getTxtNombreMedia() {
        return txtNombreMedia.getText();
    }

    public void setTxtNombreMedia(String InstitutoMedia) {
        txtNombreMedia.setText(InstitutoMedia);
    }

    public String getTxtLugarMedia() {
        return txtLugarMedia.getText();
    }

    public void setTxtLugarMedia(String LugarMedia) {
        txtLugarMedia.setText(LugarMedia);
    }

    public String getTxtCodigoMedia() {
        return txtCodigoMedia.getText();
    }

    public void setTxtCodigoMedia(String CodigoMedia) {
        txtCodigoMedia.setText(CodigoMedia);
    }

    public void setTxtCodigoPrimaria(String CodigoPrimaria) {
        txtCodigoPrimaria.setText(CodigoPrimaria);
    }

    public JDateChooser getFechaNac() {
        return txtFechaNac;
    }

    public void setLabelApellido(String Apellido) {
        labelApellido.setText(Apellido);
    }

    public void setLabelCedula(String Cedula) {
        labelCedula.setText(Cedula);
    }

    public void setLabelNombre(String Nombre) {
        labelNombre.setText(Nombre);
    }

    public JComboBox getComboAñosGraduadosM() {
        return comboAñosGraduadosM;
    }

    public void setComboAñosGraduadosM(JComboBox comboAñosGraduadosM) {
        this.comboAñosGraduadosM = comboAñosGraduadosM;
    }

    public JComboBox getComboAñosCursadosM() {
        return comboAñosCursadosM;
    }

    public void setComboAñosCursadosM(JComboBox comboAñosCursadosM) {
        this.comboAñosCursadosM = comboAñosCursadosM;
    }

    public Date getTxtFechaDesdeM() {
        return txtFechaDesdeM.getDate();
    }

    public Date getTxtFechaHastaM() {
        return txtFechaHastaM.getDate();
    }

    public JCheckBox getCheckGraduadoEx() {
        return checkGraduadoEx;
    }

    public void setCheckGraduadoEx(JCheckBox checkGraduadoEx) {
        this.checkGraduadoEx = checkGraduadoEx;
    }

    public JComboBox getComboPaisInstruccionEx() {
        return comboPaisInstruccionEx;
    }

    public void setComboGradoInstruccionEx(JComboBox comboGradoInstruccionEx) {
        this.comboPaisInstruccionEx = comboGradoInstruccionEx;
    }

    public JComboBox getComboGraduadoS() {
        return comboGraduadoS;
    }

    public void setComboGraduadoS(JComboBox comboGraduadoS) {
        this.comboGraduadoS = comboGraduadoS;
    }

    public String getTxtDuracionEx() {
        return txtDuracionEx.getText();
    }

    public void setTxtDuracionEx(JTextField txtDuracionEx) {
        this.txtDuracionEx = txtDuracionEx;
    }

    public String getTxtPostGrado() {
        return txtPostGrado.getText();
    }

    public void setTxtPostGrado(JTextArea txtPostGrado) {
        this.txtPostGrado = txtPostGrado;
    }

    public String getTxtTituloEx() {
        return txtTituloEx.getText();
    }

    public void setTxtTituloEx(JTextField txtTituloEx) {
        this.txtTituloEx = txtTituloEx;
    }

    public String getTxtTituloSuperior() {
        return txtTituloSuperior.getText();
    }

    public void setTxtTituloSuperior(JTextField txtTituloSuperior) {
        this.txtTituloSuperior = txtTituloSuperior;
    }

    public Date getTxtFechaDesdeS() {
        return txtFechaDesdeS.getDate();
    }

    public JComboBox getComboAñosCursadosS() {
        return comboAñosCursadosS;
    }

    public JDateChooser getFechaDesdeM() {
        return txtFechaDesdeM;
    }

    public JDateChooser getFechaDesdeP() {
        return txtFechaDesdeP;
    }

    public JDateChooser getFechaDesdeS() {
        return txtFechaDesdeS;
    }

    public JDateChooser getFechaHastaM() {
        return txtFechaHastaM;
    }

    public JDateChooser getFechaHastaP() {
        return txtFechaHastaP;
    }

    
    
    public void reestablecerCampos() {
       txtCedula.setEnabled(false);
       txtApellidos.setEnabled(false);
       txtNombres.setEnabled(false);
       comboTipoPersonal.setEnabled(false);
       comboNacionalidad.setEnabled(false);
       comboEstado.setEnabled(false);
       comboMunicipio.setEnabled(false);
       comboSector.setEnabled(false);
       txtNacionalizado.setEnabled(false);
       txtFechaNac.setEnabled(false);
       comboEstadoCivil.setEnabled(false);
       txtDireccion.setEnabled(false);
       comboEstado2.setEnabled(false);
       comboMunicipio2.setEnabled(false);
       comboSector2.setEnabled(false);
       btnGradoInstruccion.setEnabled(true);
       
       btnHojaServicio.setEnabled(true);
       btnControlInasistencias.setEnabled(true);
       btnControlAmonestaciones.setEnabled(true);
       btnControlLicencias.setEnabled(true);
       btnObservaciones.setEnabled(true);
      for(int i=1;i<=7;i++) {
      jTabbedPane1.setEnabledAt(i, true);
                            }
                                     }
    
     /*   public void reestablecerCamposGrado1() {
       txtCedula.setEnabled(false);
       
                                     } Desactivar campos*/ 

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        btnGradoInstruccion = new javax.swing.JButton();
        btnHojaServicio = new javax.swing.JButton();
        btnControlInasistencias = new javax.swing.JButton();
        btnControlAmonestaciones = new javax.swing.JButton();
        btnControlLicencias = new javax.swing.JButton();
        btnObservaciones = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        labelCedula = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboTipoPersonal = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboNacionalidad = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        comboMunicipio = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboSector = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        comboEstadoCivil = new javax.swing.JComboBox();
        txtNacionalizado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnDatosPersonales = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        comboEstado2 = new javax.swing.JComboBox();
        jLabel87 = new javax.swing.JLabel();
        comboMunicipio2 = new javax.swing.JComboBox();
        jLabel86 = new javax.swing.JLabel();
        comboSector2 = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        validaCedula = new javax.swing.JLabel();
        validaApellidos = new javax.swing.JLabel();
        validaNombres = new javax.swing.JLabel();
        validaTipo = new javax.swing.JLabel();
        validaNacionalidad = new javax.swing.JLabel();
        validaEstado = new javax.swing.JLabel();
        validaMunicipio = new javax.swing.JLabel();
        validaSector = new javax.swing.JLabel();
        validaFecha = new javax.swing.JLabel();
        validaEstadoCivil = new javax.swing.JLabel();
        validaDireccion = new javax.swing.JLabel();
        validaEstado2 = new javax.swing.JLabel();
        validaMunicipio2 = new javax.swing.JLabel();
        validaSector2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtCodigoPrimaria = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        txtNombrePrimaria = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtLugarPrimaria = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtFechaDesdeP = new com.toedter.calendar.JDateChooser();
        jLabel84 = new javax.swing.JLabel();
        txtFechaHastaP = new com.toedter.calendar.JDateChooser();
        btnPrimaria = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        txtCodigoMedia = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtNombreMedia = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtLugarMedia = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtFechaDesdeM = new com.toedter.calendar.JDateChooser();
        jLabel89 = new javax.swing.JLabel();
        txtFechaHastaM = new com.toedter.calendar.JDateChooser();
        jLabel56 = new javax.swing.JLabel();
        comboAñosCursadosM = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        comboAñosGraduadosM = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        txtCodigoSuperior = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtNombreSuperior = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        txtLugarSuperior = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtTituloSuperior = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtFechaDesdeS = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        comboAñosCursadosS = new javax.swing.JComboBox();
        jLabel63 = new javax.swing.JLabel();
        comboGraduadoS = new javax.swing.JComboBox();
        jPanel22 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        checkGraduadoEx = new javax.swing.JCheckBox();
        jLabel65 = new javax.swing.JLabel();
        txtTituloEx = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        comboPaisInstruccionEx = new javax.swing.JComboBox();
        jLabel67 = new javax.swing.JLabel();
        txtDuracionEx = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPostGrado = new javax.swing.JTextArea();
        btnMedia = new javax.swing.JButton();
        btnAgregarEmpresa7 = new javax.swing.JButton();
        btnRegistrarGrado1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableCargoActual = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        btnAgregarCargo = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tableHojaServicio = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        btnContinuarRegistro6 = new javax.swing.JButton();
        btnAgregarCargo1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tableInasistencias = new javax.swing.JTable();
        btnContinuarRegistro7 = new javax.swing.JButton();
        btnAgregarCargo2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        btnAgregarEmpresa19 = new javax.swing.JButton();
        btnContinuarRegistro8 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        btnAgregarEmpresa20 = new javax.swing.JButton();
        btnContinuarRegistro9 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        btnContinuarRegistro10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
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

        btnGradoInstruccion.setBackground(new java.awt.Color(255, 255, 255));
        btnGradoInstruccion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGradoInstruccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up_16.png"))); // NOI18N
        btnGradoInstruccion.setText("<html><center>Grado de<br> Instrucción</center></html>");
        btnGradoInstruccion.setToolTipText("Grado de Instrucción");
        btnGradoInstruccion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnGradoInstruccion.setBorderPainted(false);
        btnGradoInstruccion.setEnabled(false);
        btnGradoInstruccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGradoInstruccion.setIconTextGap(0);
        btnGradoInstruccion.setPreferredSize(new java.awt.Dimension(80, 60));
        btnGradoInstruccion.setVerifyInputWhenFocusTarget(false);
        btnGradoInstruccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGradoInstruccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradoInstruccionActionPerformed(evt);
            }
        });
        jPanel13.add(btnGradoInstruccion);

        btnHojaServicio.setBackground(new java.awt.Color(255, 255, 255));
        btnHojaServicio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnHojaServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clock_16.png"))); // NOI18N
        btnHojaServicio.setText("<html><center>Hoja de<br> Servicio</center></html>");
        btnHojaServicio.setToolTipText("Hoja de Servicio");
        btnHojaServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnHojaServicio.setBorderPainted(false);
        btnHojaServicio.setEnabled(false);
        btnHojaServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHojaServicio.setIconTextGap(0);
        btnHojaServicio.setPreferredSize(new java.awt.Dimension(80, 60));
        btnHojaServicio.setVerifyInputWhenFocusTarget(false);
        btnHojaServicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHojaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHojaServicioActionPerformed(evt);
            }
        });
        jPanel13.add(btnHojaServicio);

        btnControlInasistencias.setBackground(new java.awt.Color(255, 255, 255));
        btnControlInasistencias.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnControlInasistencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_16.png"))); // NOI18N
        btnControlInasistencias.setText("<html><center>Control de<br> Inasistencias</center></html>");
        btnControlInasistencias.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnControlInasistencias.setBorderPainted(false);
        btnControlInasistencias.setEnabled(false);
        btnControlInasistencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnControlInasistencias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnControlInasistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlInasistenciasActionPerformed(evt);
            }
        });
        jPanel13.add(btnControlInasistencias);

        btnControlAmonestaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnControlAmonestaciones.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnControlAmonestaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warning_16.png"))); // NOI18N
        btnControlAmonestaciones.setText("<html><center>Control de<br>Amonestaciones</center></html>");
        btnControlAmonestaciones.setToolTipText("Control de Amonestaciones");
        btnControlAmonestaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnControlAmonestaciones.setBorderPainted(false);
        btnControlAmonestaciones.setEnabled(false);
        btnControlAmonestaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnControlAmonestaciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnControlAmonestaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlAmonestacionesActionPerformed(evt);
            }
        });
        jPanel13.add(btnControlAmonestaciones);

        btnControlLicencias.setBackground(new java.awt.Color(255, 255, 255));
        btnControlLicencias.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnControlLicencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/flag_16.png"))); // NOI18N
        btnControlLicencias.setText("<html><center>Control de<br>Licencias</center></html>");
        btnControlLicencias.setToolTipText("Control de Licencias");
        btnControlLicencias.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnControlLicencias.setBorderPainted(false);
        btnControlLicencias.setEnabled(false);
        btnControlLicencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnControlLicencias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnControlLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlLicenciasActionPerformed(evt);
            }
        });
        jPanel13.add(btnControlLicencias);

        btnObservaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnObservaciones.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnObservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_16.png"))); // NOI18N
        btnObservaciones.setText("<html><center>Obervaciones<br> &nbsp</center></html>");
        btnObservaciones.setToolTipText("Control de Licencias");
        btnObservaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnObservaciones.setBorderPainted(false);
        btnObservaciones.setEnabled(false);
        btnObservaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnObservaciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionesActionPerformed(evt);
            }
        });
        jPanel13.add(btnObservaciones);

        jPanel3.add(jPanel13, java.awt.BorderLayout.LINE_START);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout();
        flowLayout2.setAlignOnBaseline(true);
        jPanel9.setLayout(flowLayout2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/header.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(jLabel1);

        jPanel10.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ficha Personal");
        jPanel8.add(jLabel2);

        jPanel10.add(jPanel8);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 100, 0));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Básicos de Personal"));
        jPanel31.setLayout(new java.awt.GridLayout(3, 2));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Nombre:");
        jPanel31.add(jLabel21);
        jPanel31.add(labelNombre);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Apellidos:");
        jPanel31.add(jLabel23);
        jPanel31.add(labelApellido);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Cédula:");
        jPanel31.add(jLabel25);
        jPanel31.add(labelCedula);

        jPanel32.add(jPanel31);

        jPanel10.add(jPanel32);

        jPanel3.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(4, 2, 0, 15));

        jLabel4.setText("Cédula de Identidad Nº:");
        jPanel4.add(jLabel4);

        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel4.add(txtCedula);

        jLabel6.setText("Apellidos:");
        jPanel4.add(jLabel6);

        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        jPanel4.add(txtApellidos);

        jLabel5.setText("Nombres:");
        jPanel4.add(jLabel5);

        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel4.add(txtNombres);

        jLabel3.setText("Tipo:");
        jPanel4.add(jLabel3);

        comboTipoPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Docente", "Administrativo", "Obrero" }));
        comboTipoPersonal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboTipoPersonalFocusLost(evt);
            }
        });
        jPanel4.add(comboTipoPersonal);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Datos Personales:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(4, 2, 0, 15));

        jLabel7.setText("Nacionalidad:");
        jPanel5.add(jLabel7);

        comboNacionalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Venezolano(a)", "Extranjero(a)" }));
        comboNacionalidad.setToolTipText("");
        comboNacionalidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboNacionalidadFocusLost(evt);
            }
        });
        comboNacionalidad.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboNacionalidadPropertyChange(evt);
            }
        });
        jPanel5.add(comboNacionalidad);

        jLabel11.setText("Estado:");
        jPanel5.add(jLabel11);

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        comboEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboEstadoFocusLost(evt);
            }
        });
        jPanel5.add(comboEstado);

        jLabel10.setText("Municipio:");
        jPanel5.add(jLabel10);

        comboMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        comboMunicipio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboMunicipioFocusLost(evt);
            }
        });
        jPanel5.add(comboMunicipio);

        jLabel9.setText("Sector:");
        jPanel5.add(jLabel9);

        comboSector.setEditable(true);
        comboSector.setKeySelectionManager(null);
        comboSector.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    getToolkit().beep();
                    evt.consume();
                }

            }

        });
        comboSector.getEditor().getEditorComponent().addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(comboSector.isEnabled()) {
                    if (comboSector.getEditor().getItem().toString().trim().equals("")) {
                        validaSector.setText("*Debe Seleccionar o Agregar Sector");
                    }
                    else if (comboSector.getSelectedItem().equals("Seleccione...")) {
                        validaSector.setText("*Debe Seleccionar o Agregar Sector");
                    }
                    else {
                        validaSector.setText("");
                    }
                    if(comboSector.getEditor().getItem().toString().trim() != null) {
                        String cadena = comboSector.getEditor().getItem().toString().toUpperCase();
                        comboSector.getEditor().setItem(cadena);
                    }
                }
            }
        });
        comboSector.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboSectorFocusLost(evt);
            }
        });
        jPanel5.add(comboSector);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Lugar de Nacimiento:");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(2, 2, 0, 15));

        jLabel19.setText("Fecha de Nacimiento:");
        jPanel7.add(jLabel19);

        IDateEditor editor = txtFechaNac.getDateEditor();
        editor.setEnabled(false);

        editor.addPropertyChangeListener(
            new PropertyChangeListener() {

                public void propertyChange(PropertyChangeEvent e) {

                    Date fechaDate1 = new Date();
                    if(txtFechaNac.getDate()==null){

                    }
                    else
                    if (fechaDate1.before(txtFechaNac.getDate())){

                        validaFecha.setText("*Fecha de Nacimiento Incorrecta");
                    }

                    else if(txtFechaNac.getCalendar().get(Calendar.YEAR)<1900) {
                        validaFecha.setText("*Fecha de Nacimiento Incorrecta");

                    }
                    else {
                        validaFecha.setText("");
                    }
                }
            });
            txtFechaNac.setPreferredSize(new java.awt.Dimension(93, 20));
            jPanel7.add(txtFechaNac);

            jLabel20.setText("Estado Civil:");
            jPanel7.add(jLabel20);

            comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)", "Otro" }));
            comboEstadoCivil.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    comboEstadoCivilFocusLost(evt);
                }
            });
            jPanel7.add(comboEstadoCivil);

            txtNacionalizado.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtNacionalizadoKeyTyped(evt);
                }
            });

            jLabel12.setText("<html>Si es nacionalizado, indique número <br> de Gaceta Oficial y Nacionalización:</html>");

            btnDatosPersonales.setBackground(new java.awt.Color(255, 255, 255));
            btnDatosPersonales.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
            btnDatosPersonales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
            btnDatosPersonales.setText("Continuar Registro");
            btnDatosPersonales.setToolTipText("Examinar...");
            btnDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnDatosPersonales.setContentAreaFilled(false);
            btnDatosPersonales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnDatosPersonales.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
            btnDatosPersonales.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnDatosPersonales.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnDatosPersonalesActionPerformed(evt);
                }
            });

            jPanel24.setBackground(new java.awt.Color(255, 255, 255));
            jPanel24.setLayout(new java.awt.GridLayout(4, 2, 0, 15));

            jLabel85.setText("Dirección:");
            jPanel24.add(jLabel85);

            txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    txtDireccionFocusLost(evt);
                }
            });
            txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtDireccionKeyTyped(evt);
                }
            });
            jPanel24.add(txtDireccion);

            jLabel88.setText("Estado:");
            jPanel24.add(jLabel88);

            comboEstado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
            comboEstado2.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    comboEstado2FocusLost(evt);
                }
            });
            jPanel24.add(comboEstado2);

            jLabel87.setText("Municipio:");
            jPanel24.add(jLabel87);

            comboMunicipio2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
            comboMunicipio2.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    comboMunicipio2FocusLost(evt);
                }
            });
            jPanel24.add(comboMunicipio2);

            jLabel86.setText("Sector:");
            jPanel24.add(jLabel86);

            comboSector2.setEditable(true);
            comboSector2.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    char c = evt.getKeyChar();
                    if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        getToolkit().beep();
                        evt.consume();
                    }

                }
            });
            comboSector2.getEditor().getEditorComponent().addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusLost(java.awt.event.FocusEvent evt) {
                    if (comboSector2.getEditor().getItem().toString().trim().equals("")) {
                        validaSector2.setText("*Debe Seleccionar o Agregar Sector");
                    }
                    else if (comboSector2.getSelectedItem().equals("Seleccione...")) {
                        validaSector2.setText("*Debe Seleccionar o Agregar Sector");
                    }
                    else {
                        validaSector2.setText("");
                    }
                    if(comboSector2.getEditor().getItem().toString().trim() != null) {
                        String cadena = comboSector2.getEditor().getItem().toString().toUpperCase();
                        comboSector2.getEditor().setItem(cadena);
                    }
                }
            });
            jPanel24.add(comboSector2);

            jLabel83.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel83.setText("Dirección:");

            jPanel17.setBackground(new java.awt.Color(255, 255, 255));
            jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Realice las siguientes correciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 0, 0)));
            jPanel17.setLayout(new java.awt.GridLayout(14, 0));

            validaCedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaCedula.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaCedula);

            validaApellidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaApellidos.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaApellidos);

            validaNombres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaNombres.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaNombres);

            validaTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaTipo.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaTipo);

            validaNacionalidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaNacionalidad.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaNacionalidad);

            validaEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaEstado.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaEstado);

            validaMunicipio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaMunicipio.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaMunicipio);

            validaSector.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaSector.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaSector);

            validaFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaFecha.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaFecha);

            validaEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaEstadoCivil.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaEstadoCivil);

            validaDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaDireccion.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaDireccion);

            validaEstado2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaEstado2.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaEstado2);

            validaMunicipio2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaMunicipio2.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaMunicipio2);

            validaSector2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            validaSector2.setForeground(new java.awt.Color(255, 0, 0));
            jPanel17.add(validaSector2);

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDatosPersonales)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNacionalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 977, Short.MAX_VALUE)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(171, 171, 171))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel83)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(206, 206, 206)
                                    .addComponent(jLabel83))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNacionalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(39, 39, 39)
                    .addComponent(btnDatosPersonales)
                    .addContainerGap(715, Short.MAX_VALUE))
            );

            jScrollPane22.setViewportView(jPanel2);

            javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
            jPanel25.setLayout(jPanel25Layout);
            jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane22)
            );
            jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane22)
            );

            jTabbedPane1.addTab("Datos Personales", jPanel25);

            jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            jPanel12.setBackground(new java.awt.Color(255, 255, 255));
            jPanel12.setEnabled(false);
            jPanel12.setPreferredSize(new java.awt.Dimension(1200, 1200));

            jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel27.setText("Primaria:");

            jPanel19.setBackground(new java.awt.Color(255, 255, 255));
            jPanel19.setLayout(new java.awt.GridLayout(5, 2, 0, 15));

            jLabel33.setText("Código:");
            jPanel19.add(jLabel33);
            jPanel19.add(txtCodigoPrimaria);

            jLabel90.setText("Instituto:");
            jPanel19.add(jLabel90);
            jPanel19.add(txtNombrePrimaria);

            jLabel34.setText("Lugar:");
            jPanel19.add(jLabel34);
            jPanel19.add(txtLugarPrimaria);

            jLabel35.setText("Desde:");
            jPanel19.add(jLabel35);

            txtFechaDesdeP.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    txtFechaDesdePFocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    txtFechaDesdePFocusLost(evt);
                }
            });
            jPanel19.add(txtFechaDesdeP);

            jLabel84.setText("Hasta:");
            jPanel19.add(jLabel84);

            txtFechaHastaP.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    txtFechaHastaPFocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    txtFechaHastaPFocusLost(evt);
                }
            });
            jPanel19.add(txtFechaHastaP);

            btnPrimaria.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
            btnPrimaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_p.png"))); // NOI18N
            btnPrimaria.setText("Seleccionar");
            btnPrimaria.setToolTipText("Seleccionar");
            btnPrimaria.setAlignmentY(0.0F);
            btnPrimaria.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnPrimaria.setContentAreaFilled(false);
            btnPrimaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnPrimaria.setIconTextGap(0);
            btnPrimaria.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnPrimaria.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_g.png"))); // NOI18N
            btnPrimaria.setVerifyInputWhenFocusTarget(false);
            btnPrimaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnPrimaria.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPrimariaActionPerformed(evt);
                }
            });

            jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel28.setText("Media:");

            jPanel20.setBackground(new java.awt.Color(255, 255, 255));
            jPanel20.setLayout(new java.awt.GridLayout(8, 2, 0, 15));

            jLabel91.setText("Código:");
            jPanel20.add(jLabel91);
            jPanel20.add(txtCodigoMedia);

            jLabel53.setText("Instituto:");
            jPanel20.add(jLabel53);
            jPanel20.add(txtNombreMedia);

            jLabel54.setText("Lugar:");
            jPanel20.add(jLabel54);
            jPanel20.add(txtLugarMedia);

            jLabel55.setText("Desde:");
            jPanel20.add(jLabel55);

            txtFechaDesdeM.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    txtFechaDesdeMFocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    txtFechaDesdeMFocusLost(evt);
                }
            });
            jPanel20.add(txtFechaDesdeM);

            jLabel89.setText("Hasta:");
            jPanel20.add(jLabel89);

            txtFechaHastaM.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    txtFechaHastaMFocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    txtFechaHastaMFocusLost(evt);
                }
            });
            jPanel20.add(txtFechaHastaM);

            jLabel56.setText("Años Cursados:");
            jPanel20.add(jLabel56);

            comboAñosCursadosM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "1", "2", "3", "4", "5" }));
            jPanel20.add(comboAñosCursadosM);

            jLabel57.setText("Graduado:");
            jPanel20.add(jLabel57);

            comboAñosGraduadosM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Si", "No" }));
            comboAñosGraduadosM.setSelectedIndex(1);
            jPanel20.add(comboAñosGraduadosM);

            jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel29.setText("Superior:");

            jPanel21.setBackground(new java.awt.Color(255, 255, 255));
            jPanel21.setLayout(new java.awt.GridLayout(7, 2, 0, 15));

            jLabel58.setText("Código:");
            jPanel21.add(jLabel58);
            jPanel21.add(txtCodigoSuperior);

            jLabel59.setText("Instituto:");
            jPanel21.add(jLabel59);
            jPanel21.add(txtNombreSuperior);

            jLabel92.setText("Lugar:");
            jPanel21.add(jLabel92);
            jPanel21.add(txtLugarSuperior);

            jLabel60.setText("Título Espec.");
            jPanel21.add(jLabel60);
            jPanel21.add(txtTituloSuperior);

            jLabel61.setText("Fecha de Inicio:");
            jPanel21.add(jLabel61);

            txtFechaDesdeS.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    txtFechaDesdeSFocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    txtFechaDesdeSFocusLost(evt);
                }
            });
            jPanel21.add(txtFechaDesdeS);

            jLabel62.setText("Años Cursados:");
            jPanel21.add(jLabel62);

            comboAñosCursadosS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "1", "2", "3", "4", "5" }));
            jPanel21.add(comboAñosCursadosS);

            jLabel63.setText("Graduado:");
            jPanel21.add(jLabel63);

            comboGraduadoS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Si", "No" }));
            comboGraduadoS.setSelectedIndex(1);
            jPanel21.add(comboGraduadoS);

            jPanel22.setBackground(new java.awt.Color(255, 255, 255));
            jPanel22.setLayout(new java.awt.GridLayout(4, 2, 0, 15));

            jLabel64.setText("Graduado en el Exterior:");
            jPanel22.add(jLabel64);

            checkGraduadoEx.setBackground(new java.awt.Color(255, 255, 255));
            jPanel22.add(checkGraduadoEx);

            jLabel65.setText("Título Obtenido:");
            jPanel22.add(jLabel65);
            jPanel22.add(txtTituloEx);

            jLabel66.setText("País:");
            jPanel22.add(jLabel66);

            comboPaisInstruccionEx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)", "Otro" }));
            jPanel22.add(comboPaisInstruccionEx);

            jLabel67.setText("Duración:");
            jPanel22.add(jLabel67);
            jPanel22.add(txtDuracionEx);

            jLabel15.setText("Si ha hecho estudios de post-grado, indique:");

            txtPostGrado.setColumns(20);
            txtPostGrado.setRows(5);
            jScrollPane3.setViewportView(txtPostGrado);

            btnMedia.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
            btnMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_p.png"))); // NOI18N
            btnMedia.setText("Seleccionar");
            btnMedia.setToolTipText("Seleccionar");
            btnMedia.setAlignmentY(0.0F);
            btnMedia.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnMedia.setContentAreaFilled(false);
            btnMedia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnMedia.setIconTextGap(0);
            btnMedia.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnMedia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_g.png"))); // NOI18N
            btnMedia.setVerifyInputWhenFocusTarget(false);
            btnMedia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnMedia.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnMediaActionPerformed(evt);
                }
            });

            btnAgregarEmpresa7.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
            btnAgregarEmpresa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_p.png"))); // NOI18N
            btnAgregarEmpresa7.setText("Seleccionar");
            btnAgregarEmpresa7.setToolTipText("Seleccionar");
            btnAgregarEmpresa7.setAlignmentY(0.0F);
            btnAgregarEmpresa7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnAgregarEmpresa7.setContentAreaFilled(false);
            btnAgregarEmpresa7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnAgregarEmpresa7.setIconTextGap(0);
            btnAgregarEmpresa7.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnAgregarEmpresa7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/seleccionar_g.png"))); // NOI18N
            btnAgregarEmpresa7.setVerifyInputWhenFocusTarget(false);
            btnAgregarEmpresa7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnAgregarEmpresa7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarEmpresa7ActionPerformed(evt);
                }
            });

            btnRegistrarGrado1.setBackground(new java.awt.Color(255, 255, 255));
            btnRegistrarGrado1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
            btnRegistrarGrado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
            btnRegistrarGrado1.setText("Continuar Registro");
            btnRegistrarGrado1.setToolTipText("Examinar...");
            btnRegistrarGrado1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnRegistrarGrado1.setContentAreaFilled(false);
            btnRegistrarGrado1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnRegistrarGrado1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
            btnRegistrarGrado1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnRegistrarGrado1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnRegistrarGrado1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
            jPanel12.setLayout(jPanel12Layout);
            jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMedia)
                                .addComponent(btnPrimaria))))
                    .addGap(50, 50, 50)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(63, 63, 63)
                    .addComponent(btnAgregarEmpresa7)
                    .addGap(137, 137, 137))
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(btnRegistrarGrado1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrimaria, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarEmpresa7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addComponent(jLabel28)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(36, 36, 36)
                    .addComponent(btnRegistrarGrado1)
                    .addContainerGap(491, Short.MAX_VALUE))
            );

            jScrollPane2.setViewportView(jPanel12);

            jTabbedPane1.addTab("Grado de Instrucción I", jScrollPane2);

            jPanel48.setBackground(new java.awt.Color(255, 255, 255));

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

            jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel37.setText("Cargo(s) Actual(es):");

            btnAgregarCargo.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
            btnAgregarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_p.png"))); // NOI18N
            btnAgregarCargo.setText("Agregar Cargo");
            btnAgregarCargo.setToolTipText("Agregar Cago");
            btnAgregarCargo.setAlignmentY(0.0F);
            btnAgregarCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnAgregarCargo.setContentAreaFilled(false);
            btnAgregarCargo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnAgregarCargo.setIconTextGap(0);
            btnAgregarCargo.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnAgregarCargo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_g.png"))); // NOI18N
            btnAgregarCargo.setVerifyInputWhenFocusTarget(false);
            btnAgregarCargo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnAgregarCargo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarCargoActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
            jPanel48.setLayout(jPanel48Layout);
            jPanel48Layout.setHorizontalGroup(
                jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel48Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel48Layout.createSequentialGroup()
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btnAgregarCargo))
                        .addComponent(jLabel37))
                    .addContainerGap(961, Short.MAX_VALUE))
            );
            jPanel48Layout.setVerticalGroup(
                jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel48Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel37)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(739, Short.MAX_VALUE))
            );

            jTabbedPane3.addTab("Cargo(s) Actual(es)", jPanel48);

            jPanel49.setBackground(new java.awt.Color(255, 255, 255));

            jPanel30.setBackground(new java.awt.Color(255, 255, 255));
            jPanel30.setLayout(new java.awt.GridLayout(3, 2, 0, 15));

            jLabel69.setText("Tiempo de Servicio en M.E");
            jPanel30.add(jLabel69);
            jPanel30.add(jTextField23);

            jLabel70.setText("Años:");
            jPanel30.add(jLabel70);
            jPanel30.add(jTextField27);

            jLabel71.setText("Meses:");
            jPanel30.add(jLabel71);
            jPanel30.add(jTextField28);

            jLabel94.setText("Otras asignaturas en las que podría trabajar:");

            jTextArea8.setColumns(20);
            jTextArea8.setRows(5);
            jScrollPane21.setViewportView(jTextArea8);

            jLabel95.setText("Actividades que asesora:");

            jTextArea9.setColumns(20);
            jTextArea9.setRows(5);
            jScrollPane23.setViewportView(jTextArea9);

            javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
            jPanel49.setLayout(jPanel49Layout);
            jPanel49Layout.setHorizontalGroup(
                jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel49Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel95)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(1627, Short.MAX_VALUE))
            );
            jPanel49Layout.setVerticalGroup(
                jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel49Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)
                    .addComponent(jLabel94)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addComponent(jLabel95)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(732, Short.MAX_VALUE))
            );

            jTabbedPane3.addTab("Otros Datos", jPanel49);

            jScrollPane8.setViewportView(jTabbedPane3);

            jTabbedPane1.addTab("Cargos(s) Actual(es)", jScrollPane8);

            jPanel23.setBackground(new java.awt.Color(255, 255, 255));
            jPanel23.setPreferredSize(new java.awt.Dimension(1200, 1200));

            jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel39.setText("Hoja de Servicio:");

            tableHojaServicio.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            jScrollPane15.setViewportView(tableHojaServicio);

            jLabel40.setText("Anótese, en estricto orden cronológico, los cargos que ha desempeñado, las dependencias o planteles donde ha prestado sus servicios, sueldos, primas y otros:");

            jLabel73.setText("Aspiraciones Profesionales Inmediatas:");

            jLabel41.setText("Observaciones:");

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane9.setViewportView(jTextArea1);

            jTextArea4.setColumns(20);
            jTextArea4.setRows(5);
            jScrollPane16.setViewportView(jTextArea4);

            btnContinuarRegistro6.setBackground(new java.awt.Color(255, 255, 255));
            btnContinuarRegistro6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
            btnContinuarRegistro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_16.png"))); // NOI18N
            btnContinuarRegistro6.setText("Continuar Registro");
            btnContinuarRegistro6.setToolTipText("Examinar...");
            btnContinuarRegistro6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnContinuarRegistro6.setContentAreaFilled(false);
            btnContinuarRegistro6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnContinuarRegistro6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_18.png"))); // NOI18N
            btnContinuarRegistro6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnContinuarRegistro6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnContinuarRegistro6ActionPerformed(evt);
                }
            });

            btnAgregarCargo1.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
            btnAgregarCargo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_p.png"))); // NOI18N
            btnAgregarCargo1.setText("Agregar Cargo");
            btnAgregarCargo1.setToolTipText("Agregar Cago");
            btnAgregarCargo1.setAlignmentY(0.0F);
            btnAgregarCargo1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnAgregarCargo1.setContentAreaFilled(false);
            btnAgregarCargo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnAgregarCargo1.setIconTextGap(0);
            btnAgregarCargo1.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnAgregarCargo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_g.png"))); // NOI18N
            btnAgregarCargo1.setVerifyInputWhenFocusTarget(false);
            btnAgregarCargo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnAgregarCargo1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarCargo1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
            jPanel23.setLayout(jPanel23Layout);
            jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnContinuarRegistro6)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel39)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(btnAgregarCargo1))
                        .addComponent(jLabel40)
                        .addComponent(jLabel73)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(857, Short.MAX_VALUE))
            );
            jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jLabel39)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel40)
                    .addGap(15, 15, 15)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarCargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addComponent(jLabel73)
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel41)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnContinuarRegistro6)
                    .addContainerGap(401, Short.MAX_VALUE))
            );

            jScrollPane4.setViewportView(jPanel23);

            jTabbedPane1.addTab("Hoja de Servicio", jScrollPane4);

            jPanel6.setBackground(new java.awt.Color(255, 255, 255));

            jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel42.setText("Inasistencias:");

            tableInasistencias.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String [] {
                    "Número", "Fecha", "Causa", "J", "I", "%Acumulado"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, true, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane17.setViewportView(tableInasistencias);
            if (tableInasistencias.getColumnModel().getColumnCount() > 0) {
                tableInasistencias.getColumnModel().getColumn(0).setHeaderValue("Número");
                tableInasistencias.getColumnModel().getColumn(3).setHeaderValue("J");
                tableInasistencias.getColumnModel().getColumn(4).setHeaderValue("I");
                tableInasistencias.getColumnModel().getColumn(5).setHeaderValue("%Acumulado");
            }

            btnContinuarRegistro7.setBackground(new java.awt.Color(255, 255, 255));
            btnContinuarRegistro7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
            btnContinuarRegistro7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_16.png"))); // NOI18N
            btnContinuarRegistro7.setText("Continuar Registro");
            btnContinuarRegistro7.setToolTipText("Examinar...");
            btnContinuarRegistro7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnContinuarRegistro7.setContentAreaFilled(false);
            btnContinuarRegistro7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnContinuarRegistro7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_18.png"))); // NOI18N
            btnContinuarRegistro7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnContinuarRegistro7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnContinuarRegistro7ActionPerformed(evt);
                }
            });

            btnAgregarCargo2.setFont(new java.awt.Font("Aharoni", 1, 11)); // NOI18N
            btnAgregarCargo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_p.png"))); // NOI18N
            btnAgregarCargo2.setText("Agregar");
            btnAgregarCargo2.setToolTipText("Agregar Cago");
            btnAgregarCargo2.setAlignmentY(0.0F);
            btnAgregarCargo2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnAgregarCargo2.setContentAreaFilled(false);
            btnAgregarCargo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnAgregarCargo2.setIconTextGap(0);
            btnAgregarCargo2.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnAgregarCargo2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar2_g.png"))); // NOI18N
            btnAgregarCargo2.setVerifyInputWhenFocusTarget(false);
            btnAgregarCargo2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnAgregarCargo2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarCargo2ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnContinuarRegistro7)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAgregarCargo2))
                        .addComponent(jLabel42))
                    .addContainerGap(1334, Short.MAX_VALUE))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel42)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarCargo2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addComponent(btnContinuarRegistro7)
                    .addContainerGap(728, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Inasistencias", jPanel6);

            jPanel11.setBackground(new java.awt.Color(255, 255, 255));

            jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel80.setText("Amonestaciones:");

            jTable9.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {
                    "Fecha", "Causa"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane18.setViewportView(jTable9);

            btnAgregarEmpresa19.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
            btnAgregarEmpresa19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus_16.png"))); // NOI18N
            btnAgregarEmpresa19.setText("Añadir Fila");
            btnAgregarEmpresa19.setToolTipText("Agregar Nueva");
            btnAgregarEmpresa19.setAlignmentY(0.0F);
            btnAgregarEmpresa19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnAgregarEmpresa19.setContentAreaFilled(false);
            btnAgregarEmpresa19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnAgregarEmpresa19.setIconTextGap(0);
            btnAgregarEmpresa19.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnAgregarEmpresa19.setVerifyInputWhenFocusTarget(false);
            btnAgregarEmpresa19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnAgregarEmpresa19.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarEmpresa19ActionPerformed(evt);
                }
            });

            btnContinuarRegistro8.setBackground(new java.awt.Color(255, 255, 255));
            btnContinuarRegistro8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
            btnContinuarRegistro8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_16.png"))); // NOI18N
            btnContinuarRegistro8.setText("Continuar Registro");
            btnContinuarRegistro8.setToolTipText("Examinar...");
            btnContinuarRegistro8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnContinuarRegistro8.setContentAreaFilled(false);
            btnContinuarRegistro8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnContinuarRegistro8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_18.png"))); // NOI18N
            btnContinuarRegistro8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnContinuarRegistro8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnContinuarRegistro8ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
            jPanel11.setLayout(jPanel11Layout);
            jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnContinuarRegistro8)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAgregarEmpresa19))
                        .addComponent(jLabel80))
                    .addContainerGap(1342, Short.MAX_VALUE))
            );
            jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel80)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarEmpresa19))
                    .addGap(30, 30, 30)
                    .addComponent(btnContinuarRegistro8)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Amonestaciones", jPanel11);

            jPanel14.setBackground(new java.awt.Color(255, 255, 255));

            jLabel81.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel81.setText("Licencias:");

            jTable10.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "Número", "Fecha", "Desde", "Hasta", "Motivo"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, true, true, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane19.setViewportView(jTable10);

            btnAgregarEmpresa20.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
            btnAgregarEmpresa20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus_16.png"))); // NOI18N
            btnAgregarEmpresa20.setText("Añadir Fila");
            btnAgregarEmpresa20.setToolTipText("Agregar Nueva");
            btnAgregarEmpresa20.setAlignmentY(0.0F);
            btnAgregarEmpresa20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnAgregarEmpresa20.setContentAreaFilled(false);
            btnAgregarEmpresa20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnAgregarEmpresa20.setIconTextGap(0);
            btnAgregarEmpresa20.setMargin(new java.awt.Insets(10, 14, 2, 14));
            btnAgregarEmpresa20.setVerifyInputWhenFocusTarget(false);
            btnAgregarEmpresa20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnAgregarEmpresa20.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAgregarEmpresa20ActionPerformed(evt);
                }
            });

            btnContinuarRegistro9.setBackground(new java.awt.Color(255, 255, 255));
            btnContinuarRegistro9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
            btnContinuarRegistro9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_16.png"))); // NOI18N
            btnContinuarRegistro9.setText("Continuar Registro");
            btnContinuarRegistro9.setToolTipText("Examinar...");
            btnContinuarRegistro9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnContinuarRegistro9.setContentAreaFilled(false);
            btnContinuarRegistro9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnContinuarRegistro9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_18.png"))); // NOI18N
            btnContinuarRegistro9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnContinuarRegistro9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnContinuarRegistro9ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
            jPanel14.setLayout(jPanel14Layout);
            jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnContinuarRegistro9)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAgregarEmpresa20))
                        .addComponent(jLabel81))
                    .addContainerGap(1342, Short.MAX_VALUE))
            );
            jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel81)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarEmpresa20))
                    .addGap(18, 18, 18)
                    .addComponent(btnContinuarRegistro9)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Licencias", jPanel14);

            jPanel16.setBackground(new java.awt.Color(255, 255, 255));

            jLabel82.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel82.setText("Observaciones:");

            jTextArea7.setColumns(20);
            jTextArea7.setRows(5);
            jScrollPane20.setViewportView(jTextArea7);

            btnContinuarRegistro10.setBackground(new java.awt.Color(255, 255, 255));
            btnContinuarRegistro10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
            btnContinuarRegistro10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_16.png"))); // NOI18N
            btnContinuarRegistro10.setText("Finalizar Registro");
            btnContinuarRegistro10.setToolTipText("Examinar...");
            btnContinuarRegistro10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnContinuarRegistro10.setContentAreaFilled(false);
            btnContinuarRegistro10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnContinuarRegistro10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil_18.png"))); // NOI18N
            btnContinuarRegistro10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnContinuarRegistro10.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnContinuarRegistro10ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
            jPanel16.setLayout(jPanel16Layout);
            jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnContinuarRegistro10)
                        .addComponent(jLabel82)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(1508, Short.MAX_VALUE))
            );
            jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel82)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(btnContinuarRegistro10)
                    .addContainerGap(958, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Observaciones", jPanel16);

            jPanel1.add(jTabbedPane1);
            /*for(int i=1;i<=9;i++) {
                jTabbedPane1.setEnabledAt(i, false);
            } */

            jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnGradoInstruccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradoInstruccionActionPerformed
      jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnGradoInstruccionActionPerformed

    private void btnHojaServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHojaServicioActionPerformed
       jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnHojaServicioActionPerformed

    private void txtFechaDesdeSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdeSFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeSFocusLost

    private void txtFechaDesdeSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdeSFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeSFocusGained

    private void txtFechaDesdeMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdeMFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeMFocusLost

    private void txtFechaDesdeMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdeMFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeMFocusGained

    private void btnPrimariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimariaActionPerformed
      new viewCatalagoPlanteles(null,null,null,this,"Primaria",this,true,Dialog.ModalityType.MODELESS).setVisible(true);
    }//GEN-LAST:event_btnPrimariaActionPerformed

    private void txtFechaDesdePFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdePFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdePFocusLost

    private void txtFechaDesdePFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdePFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdePFocusGained

    private void btnAgregarEmpresa19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpresa19ActionPerformed

    private void btnAgregarEmpresa20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpresa20ActionPerformed

    private void btnDatosPersonalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosPersonalesActionPerformed
  
    }//GEN-LAST:event_btnDatosPersonalesActionPerformed

    private void btnContinuarRegistro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro6ActionPerformed
      jTabbedPane1.setSelectedIndex(6);  
    }//GEN-LAST:event_btnContinuarRegistro6ActionPerformed

    private void btnContinuarRegistro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro7ActionPerformed
      jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnContinuarRegistro7ActionPerformed

    private void btnContinuarRegistro8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro8ActionPerformed
     jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnContinuarRegistro8ActionPerformed

    private void btnContinuarRegistro9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro9ActionPerformed
     jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_btnContinuarRegistro9ActionPerformed

    private void btnContinuarRegistro10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro10ActionPerformed
     
    }//GEN-LAST:event_btnContinuarRegistro10ActionPerformed

    private void txtFechaHastaPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaHastaPFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHastaPFocusGained

    private void txtFechaHastaPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaHastaPFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHastaPFocusLost

    private void txtFechaHastaMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaHastaMFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHastaMFocusGained

    private void txtFechaHastaMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaHastaMFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaHastaMFocusLost

    private void btnControlInasistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlInasistenciasActionPerformed
       jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnControlInasistenciasActionPerformed

    private void btnControlAmonestacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlAmonestacionesActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnControlAmonestacionesActionPerformed

    private void btnControlLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlLicenciasActionPerformed
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnControlLicenciasActionPerformed

    private void btnObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionesActionPerformed
    jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_btnObservacionesActionPerformed

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
     if(txtCedula.getText().length()<6 || txtCedula.getText().length()>8) {
      // JOptionPane.showMessageDialog( new JDialog(),"El campo (Cédula) debe poseer mas de 3 dígitos","ERROR",JOptionPane.INFORMATION_MESSAGE);
      validaCedula.setText("*Cédula Incorrecta");
      
                                             }
          else {
        
        validaCedula.setText("");  
        controllerConsultarDatosPersonal c = new controllerConsultarDatosPersonal(this);
    
       boolean consulta;
    try {
        consulta = c.verificarPersona(this.getTxtCedula());
              if  (consulta == true) {
         int seleccion = JOptionPane.showOptionDialog(
   null,
   "¡Ya existe un registro con esta cédula!, ¿desea visualizar los datos del mismo?",
   "Salir",
   JOptionPane.YES_NO_CANCEL_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,    // null para icono por defecto.
   null,   // null para YES, NO y CANCEL
   null);
 if (seleccion != -1)
    if(seleccion + 1 == 1) {
       this.dispose();
       c.mostrarDatos(this.getTxtCedula());

                            } 
   if (seleccion + 1 == 2 || seleccion +1 == 3) {
       txtCedula.setText("");
       txtCedula.requestFocus();
                                                 }
                               }
             
    } catch (SQLException ex) {
        Logger.getLogger(viewFichaPersonal.class.getName()).log(Level.SEVERE, null, ex);
    }
          } 
    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        
        if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
     char c = evt.getKeyChar();
     if(txtCedula.getText().length()>7) {
     getToolkit().beep();
     evt.consume(); 
                                          }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
    }//GEN-LAST:event_formWindowClosed

    private void btnMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediaActionPerformed
      new viewCatalagoPlanteles(null,null,null,this,"Media",this,true,Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
    }//GEN-LAST:event_btnMediaActionPerformed

    private void btnAgregarEmpresa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa7ActionPerformed
     new viewCatalagoPlanteles(null,null,null,this,"Superior",this,true,Dialog.ModalityType.MODELESS).setVisible(true);
    }//GEN-LAST:event_btnAgregarEmpresa7ActionPerformed

    private void btnAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargoActionPerformed
if (txtCedula.getText().equals("") == false) {
    viewRegistrarCargo view = new viewRegistrarCargo(null,this,this,true,Dialog.ModalityType.DOCUMENT_MODAL);
    view.setTxtCedula(txtCedula.getText());
    view.setVisible(true);
        
        
                                             }
else {
        JOptionPane.showMessageDialog( new JFrame(),"Debe introducir datos en el campo (Cédula) de la pestaña (Datos Personales)","Mensaje de Información",JOptionPane.INFORMATION_MESSAGE);
     }  
    }//GEN-LAST:event_btnAgregarCargoActionPerformed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped

        char c = evt.getKeyChar();
     if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
     getToolkit().beep();
     evt.consume(); 
                              }
     
     if(txtApellidos.getText().length()>45) {
     getToolkit().beep();
     evt.consume(); 
                                          }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
      char c = evt.getKeyChar();
     if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
     getToolkit().beep();
     evt.consume(); 
                              }
          if(txtNombres.getText().length()>45) {
     getToolkit().beep();
     evt.consume(); 
                                          }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtNacionalizadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalizadoKeyTyped
              if(!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar()))
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
                   if(txtNacionalizado.getText().length()>7) {
     getToolkit().beep();
                       
     evt.consume(); 
                                          }
    }//GEN-LAST:event_txtNacionalizadoKeyTyped

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
      if(txtApellidos.getText().length()<=3) {
      //JOptionPane.showMessageDialog( new JDialog(),"El campo (Apellidos) debe poseer mas de 3 carácteres","ERROR",JOptionPane.INFORMATION_MESSAGE);
      
      validaApellidos.setText("*Apellidos Incorrecto");
                                             }
      else {
      validaApellidos.setText("");
      
            }
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
      if(txtNombres.getText().length()<=3) {
      //JOptionPane.showMessageDialog( new JDialog(),"El campo (Nombres) debe poseer mas de 3 carácteres","ERROR",JOptionPane.INFORMATION_MESSAGE);
      
      validaNombres.setText("*Nombres Incorrecto");
                                           }
      else {
      validaNombres.setText("");
      
           }
    }//GEN-LAST:event_txtNombresFocusLost

    private void comboTipoPersonalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboTipoPersonalFocusLost
      if(comboTipoPersonal.getSelectedIndex() == 0) {     
      
      validaTipo.setText("*Debe Seleccionar Tipo de Personal");
                                                    }
      else {
      validaTipo.setText("");
      
           }
    }//GEN-LAST:event_comboTipoPersonalFocusLost

    private void comboNacionalidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboNacionalidadFocusLost
            if(comboNacionalidad.getSelectedIndex() == 0) {     
      
      validaNacionalidad.setText("*Debe Seleccionar Nacionalidad");
                                                    }
            else {
        validaNacionalidad.setText("");
            
            }
    }//GEN-LAST:event_comboNacionalidadFocusLost

    private void comboEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboEstadoFocusLost
      if(comboEstado.getSelectedIndex() == 0) {     
      
      validaEstado.setText("*Debe Seleccionar Estado");
                                                    }
      else {
      
      validaEstado.setText("");
           }
    }//GEN-LAST:event_comboEstadoFocusLost

    private void comboMunicipioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboMunicipioFocusLost
      if(comboMunicipio.getSelectedIndex() == 0) {     
      
      validaMunicipio.setText("*Debe Seleccionar Municipio");
                                                    }
      else {
      validaMunicipio.setText("");
      
           }
    }//GEN-LAST:event_comboMunicipioFocusLost

    private void comboEstadoCivilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboEstadoCivilFocusLost
      if(comboEstadoCivil.getSelectedIndex() == 0) { 
      
      validaEstadoCivil.setText("*Estado Civil Incorrecto");
                                                   }
      else {
      validaEstadoCivil.setText("");
      
           }
    }//GEN-LAST:event_comboEstadoCivilFocusLost

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost

       if(txtDireccion.getText().length()<=3) { 
      
      validaDireccion.setText("*Dirección Incorrecta");
                                             }
      else {
      validaDireccion.setText("");
      
           }
    }//GEN-LAST:event_txtDireccionFocusLost

    private void comboEstado2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboEstado2FocusLost
      if(comboEstado2.getSelectedIndex() == 0) { 
      
      validaEstado2.setText("*Debe Seleccionar Estado");
                                                   }
      else {
      validaEstado2.setText("");
       
           }
    }//GEN-LAST:event_comboEstado2FocusLost

    private void comboMunicipio2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboMunicipio2FocusLost
      if(comboMunicipio2.getSelectedIndex() == 0) { 
      
      validaMunicipio2.setText("*Debe Seleccionar Municipio");
                                                   }
      else {
      validaMunicipio2.setText("");
      
           }
    }//GEN-LAST:event_comboMunicipio2FocusLost

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
     if(txtDireccion.getText().length()>60) {
     getToolkit().beep();
     evt.consume(); 
                                            }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void comboSectorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSectorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSectorFocusLost

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
       String apellidos = txtApellidos.getText().toUpperCase();
       txtApellidos.setText(apellidos);
    }//GEN-LAST:event_txtApellidosKeyReleased

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
       String nombres = txtNombres.getText().toUpperCase();
       txtNombres.setText(nombres);
    }//GEN-LAST:event_txtNombresKeyReleased

    private void comboNacionalidadPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboNacionalidadPropertyChange
      if(comboNacionalidad.getSelectedIndex()==2) {
         comboEstado.setEnabled(false);
         comboMunicipio.setEnabled(false);
         comboSector.setEnabled(false);
         comboEstado.setSelectedIndex(0);
         comboMunicipio.setSelectedIndex(0);
         
                                                  }
      else {
         comboEstado.setEnabled(true);
         comboMunicipio.setEnabled(true);
         comboSector.setEnabled(true);
           }
    }//GEN-LAST:event_comboNacionalidadPropertyChange

    private void btnAgregarCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargo1ActionPerformed
      if (txtCedula.getText().equals("") == false) {
    viewRegistrarHojaServicio view = new viewRegistrarHojaServicio(null,this,this,true,Dialog.ModalityType.DOCUMENT_MODAL);
    view.setTxtCedula(txtCedula.getText());
    view.setVisible(true);
        
        
                                             }
else {
        JOptionPane.showMessageDialog( new JFrame(),"Debe introducir datos en el campo (Cédula) de la pestaña (Datos Personales)","Mensaje de Información",JOptionPane.INFORMATION_MESSAGE);
     }  
    }//GEN-LAST:event_btnAgregarCargo1ActionPerformed

    private void btnAgregarCargo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargo2ActionPerformed
     if (txtCedula.getText().equals("") == false) {
    viewRegistrarInasistencia view = new viewRegistrarInasistencia(this,this,true,Dialog.ModalityType.DOCUMENT_MODAL);
    view.setTxtCedula(txtCedula.getText());
    view.setVisible(true);
                                                  }
    }//GEN-LAST:event_btnAgregarCargo2ActionPerformed

    private void btnRegistrarGrado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGrado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarGrado1ActionPerformed

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
            java.util.logging.Logger.getLogger(viewFichaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewFichaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewFichaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewFichaPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewFichaPersonal(new javax.swing.JFrame(), true, Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(viewFichaPersonal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCargo;
    private javax.swing.JButton btnAgregarCargo1;
    private javax.swing.JButton btnAgregarCargo2;
    private javax.swing.JButton btnAgregarEmpresa19;
    private javax.swing.JButton btnAgregarEmpresa20;
    private javax.swing.JButton btnAgregarEmpresa7;
    private javax.swing.JButton btnContinuarRegistro10;
    private javax.swing.JButton btnContinuarRegistro6;
    private javax.swing.JButton btnContinuarRegistro7;
    private javax.swing.JButton btnContinuarRegistro8;
    private javax.swing.JButton btnContinuarRegistro9;
    private javax.swing.JButton btnControlAmonestaciones;
    private javax.swing.JButton btnControlInasistencias;
    private javax.swing.JButton btnControlLicencias;
    private javax.swing.JButton btnDatosPersonales;
    private javax.swing.JButton btnGradoInstruccion;
    private javax.swing.JButton btnHojaServicio;
    private javax.swing.JButton btnMedia;
    private javax.swing.JButton btnObservaciones;
    private javax.swing.JButton btnPrimaria;
    private javax.swing.JButton btnRegistrarGrado1;
    private javax.swing.JCheckBox checkGraduadoEx;
    private javax.swing.JComboBox comboAñosCursadosM;
    private javax.swing.JComboBox comboAñosCursadosS;
    private javax.swing.JComboBox comboAñosGraduadosM;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JComboBox comboEstado2;
    private javax.swing.JComboBox comboEstadoCivil;
    private javax.swing.JComboBox comboGraduadoS;
    private javax.swing.JComboBox comboMunicipio;
    private javax.swing.JComboBox comboMunicipio2;
    private javax.swing.JComboBox comboNacionalidad;
    private javax.swing.JComboBox comboPaisInstruccionEx;
    private javax.swing.JComboBox comboSector;
    private javax.swing.JComboBox comboSector2;
    private javax.swing.JComboBox comboTipoPersonal;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
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
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelNombre;
    public javax.swing.JTable tableCargoActual;
    private javax.swing.JTable tableHojaServicio;
    private javax.swing.JTable tableInasistencias;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JLabel txtCodigoMedia;
    private javax.swing.JLabel txtCodigoPrimaria;
    private javax.swing.JTextField txtCodigoSuperior;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDuracionEx;
    private com.toedter.calendar.JDateChooser txtFechaDesdeM;
    private com.toedter.calendar.JDateChooser txtFechaDesdeP;
    private com.toedter.calendar.JDateChooser txtFechaDesdeS;
    private com.toedter.calendar.JDateChooser txtFechaHastaM;
    private com.toedter.calendar.JDateChooser txtFechaHastaP;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private javax.swing.JLabel txtLugarMedia;
    private javax.swing.JLabel txtLugarPrimaria;
    private javax.swing.JTextField txtLugarSuperior;
    private javax.swing.JTextField txtNacionalizado;
    private javax.swing.JLabel txtNombreMedia;
    private javax.swing.JLabel txtNombrePrimaria;
    private javax.swing.JTextField txtNombreSuperior;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextArea txtPostGrado;
    private javax.swing.JTextField txtTituloEx;
    private javax.swing.JTextField txtTituloSuperior;
    private javax.swing.JLabel validaApellidos;
    private javax.swing.JLabel validaCedula;
    private javax.swing.JLabel validaDireccion;
    private javax.swing.JLabel validaEstado;
    private javax.swing.JLabel validaEstado2;
    private javax.swing.JLabel validaEstadoCivil;
    private javax.swing.JLabel validaFecha;
    private javax.swing.JLabel validaMunicipio;
    private javax.swing.JLabel validaMunicipio2;
    private javax.swing.JLabel validaNacionalidad;
    private javax.swing.JLabel validaNombres;
    private javax.swing.JLabel validaSector;
    private javax.swing.JLabel validaSector2;
    private javax.swing.JLabel validaTipo;
    // End of variables declaration//GEN-END:variables

    public Object getComboAñosGraduadosS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
