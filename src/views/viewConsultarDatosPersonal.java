/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import controllers.controllerConsultarDatosPersonal;
import controllers.controllerDatosPersonales;
import controllers.controllerInhabilitarPersonal;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewConsultarDatosPersonal extends javax.swing.JDialog {
    private OSValidator validarOS;
    private int id_direccion = 0;
    

    /**
     * Creates new form viewConsultarDatosPersonal
     */
    public viewConsultarDatosPersonal(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
         
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        initComponents();
       
        this.setTitle("Consultar Datos de Personal");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InicializacionEventos(parent);
        autoCompletado();
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
            Logger.getLogger(viewConsultarDatosPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
              int i;
        
    if (ListItem != null) {
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
     textAutoCompleter.addItem(ListItem.get(i));
                                }
       
                          }
             }
    public void reestablecerCampos() {
    txtCedula.setText("");
    txtNombre.setText("");
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
    private void InicializacionEventos(java.awt.Frame parent) {
    
    controllerConsultarDatosPersonal controlador = new controllerConsultarDatosPersonal(this);
    controllerInhabilitarPersonal controllerInhabilitar = new controllerInhabilitarPersonal(this);
    btnConsultar.addActionListener(controlador);
    btnEditar.addActionListener(controlador);
    btnInhabilitar.addActionListener(controllerInhabilitar);
                                         }

    public JTable getTableHojaServicio() {
        return tableHojaServicio;
    }

    public void setTableHojaServicio(JTable tableHojaServicio) {
        this.tableHojaServicio = tableHojaServicio;
    }

    public JTextField getDatos() {
        return txtDatos;
    }

    public void setTxtDatos(String Datos) {
        txtDatos.setText(Datos);
    }

    public JTable getTableCargoActual() {
        return tableCargoActual;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnInhabilitar() {
        return btnInhabilitar;
    }
    
    public String getTxtDatos() {
        return txtDatos.getText();
    }

    public void setTxtApellidos(String Apellidos) {
        txtApellidos.setText(Apellidos);
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public String getTxtCedula() {
        return txtCedula.getText();
    }

    public void setTxtDireccion(String Direccion) {
        txtDireccion.setText(Direccion);
    }

    public void setTxtEstado(String Estado) {
       txtEstado.setText(Estado);
    }

    public void setTxtEstado1(String Estado1) {
        txtEstado1.setText(Estado1);
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

    public void setTxtMunicipio1(String Municipio1) {
       txtMunicipio1.setText(Municipio1);
    }

    public void setTxtNacionalidad(String Nacionalidad) {
       txtNacionalidad.setText(Nacionalidad);
    }

    public void setTxtNacionalizado(String Nacionalizado) {
        txtNacionalizado.setText(Nacionalizado);
    }

    public void setTxtNombre(String Nombre) {
        txtNombre.setText(Nombre);
    }

    public void setTxtSector(String Sector) {
        txtSector.setText(Sector);
    }

    public void setTxtSector1(String Sector1) {
        txtSector1.setText(Sector1);
    }

    public void setTxtTipoPersonal(String TipoPersonal) {
        txtTipoPersonal.setText(TipoPersonal);
    }

    public JComboBox getComboTipoBusqueda() {
        return comboTipoBusqueda;
    }

    public String getTxtApellidos() {
        return txtApellidos.getText();
    }

    public String getTxtDireccion() {
        return txtDireccion.getText();
    }

    public String getTxtEstado() {
        return txtEstado.getText();
    }

    public String getTxtEstado1() {
        return txtEstado1.getText();
    }

    public String getTxtEstadoCivil() {
        return txtEstadoCivil.getText();
    }

    public String getTxtFechaNac() {
        return txtFechaNac.getText();
    }

    public String getTxtMunicipio() {
        return txtMunicipio.getText();
    }

    public String getTxtMunicipio1() {
        return txtMunicipio1.getText();
    }

    public String getTxtNacionalidad() {
        return txtNacionalidad.getText();
    }

    public String getTxtNacionalizado() {
        return txtNacionalizado.getText();
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtSector() {
        return txtSector.getText();
    }

    public String getTxtSector1() {
        return txtSector1.getText();
    }

    public String getTxtTipoPersonal() {
        return txtTipoPersonal.getText();
    }
    
    

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
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        btnConsultar1 = new javax.swing.JButton("Consultar");
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        txtNombre = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JLabel();
        txtTipoPersonal = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JLabel();
        txtEstadoCivil = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnInhabilitar = new javax.swing.JButton();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
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
        btnAgregarCargo1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        btnAgregarEmpresa18 = new javax.swing.JButton();
        btnContinuarRegistro7 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
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

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up_16.png"))); // NOI18N
        jButton9.setText("<html><center>Grado de<br> Instrucción</center></html>");
        jButton9.setToolTipText("Grado de Instrucción");
        jButton9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton9.setBorderPainted(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setIconTextGap(0);
        jButton9.setPreferredSize(new java.awt.Dimension(80, 60));
        jButton9.setVerifyInputWhenFocusTarget(false);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton9);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/situacion_familiar_opt (2).png"))); // NOI18N
        jButton10.setText("<html><center>Situación<br> Familiar</center></html>");
        jButton10.setToolTipText("Situación Familiar");
        jButton10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton10.setBorderPainted(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setIconTextGap(0);
        jButton10.setPreferredSize(new java.awt.Dimension(80, 60));
        jButton10.setVerifyInputWhenFocusTarget(false);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton10);

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clock_16.png"))); // NOI18N
        jButton11.setText("<html><center>Hoja de<br> Servicio</center></html>");
        jButton11.setToolTipText("Hoja de Servicio");
        jButton11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton11.setBorderPainted(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setIconTextGap(0);
        jButton11.setPreferredSize(new java.awt.Dimension(80, 60));
        jButton11.setVerifyInputWhenFocusTarget(false);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_16.png"))); // NOI18N
        jButton1.setText("<html><center>Control de<br> Inasistencias</center></html>");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warning_16.png"))); // NOI18N
        jButton2.setText("<html><center>Control de<br>Amonestaciones</center></html>");
        jButton2.setToolTipText("Control de Amonestaciones");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.setBorderPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/flag_16.png"))); // NOI18N
        jButton3.setText("<html><center>Control de<br>Licencias</center></html>");
        jButton3.setToolTipText("Control de Licencias");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.setBorderPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_16.png"))); // NOI18N
        jButton4.setText("<html><center>Obervaciones<br> &nbsp</center></html>");
        jButton4.setToolTipText("Control de Licencias");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.setBorderPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton4);

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
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84)
                .addGap(18, 18, 18)
                .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(txtDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Ficha Personal");

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

        btnConsultar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnConsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/listado_p.png"))); // NOI18N
        btnConsultar1.setText("Ver Listado de Personal");
        btnConsultar1.setToolTipText("Consultar Datos de Personal");
        btnConsultar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnConsultar1.setContentAreaFilled(false);
        btnConsultar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar1.setIconTextGap(5);
        btnConsultar1.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnConsultar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/listado_g.png"))); // NOI18N
        btnConsultar1.setVerifyInputWhenFocusTarget(false);
        btnConsultar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
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
                .addComponent(btnConsultar1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );

        jPanel10.add(jPanel8);

        jPanel3.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);

        jScrollPane22.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        txtNombre.setBackground(new java.awt.Color(238, 238, 238));
        txtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombre.setOpaque(true);
        jPanel7.add(txtNombre);

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
            .addGap(0, 849, Short.MAX_VALUE)
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

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/editar_p.png"))); // NOI18N
        btnEditar.setText("Editar Datos");
        btnEditar.setToolTipText("Editar Datos");
        btnEditar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEditar.setContentAreaFilled(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/editar_g.png"))); // NOI18N
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnInhabilitar.setBackground(new java.awt.Color(255, 255, 255));
        btnInhabilitar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnInhabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/inhabilitar_p.png"))); // NOI18N
        btnInhabilitar.setText("Inhabilitar");
        btnInhabilitar.setToolTipText("Examinar...");
        btnInhabilitar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnInhabilitar.setContentAreaFilled(false);
        btnInhabilitar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInhabilitar.setPreferredSize(new java.awt.Dimension(81, 55));
        btnInhabilitar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/inhabilitar_g.png"))); // NOI18N
        btnInhabilitar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInhabilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 474, Short.MAX_VALUE))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInhabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar)
                    .addComponent(btnInhabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 907, Short.MAX_VALUE))
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
                .addGap(0, 586, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 980, Short.MAX_VALUE))
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
                .addGap(0, 586, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 980, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dirección", jPanel44);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
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
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jScrollPane22)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Personales", jPanel25);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Primaria"));

        jPanel20.setBackground(new java.awt.Color(204, 204, 204));
        jPanel20.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Instituto");
        jLabel12.setOpaque(true);
        jPanel20.add(jLabel12);

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Lugar");
        jLabel13.setOpaque(true);
        jPanel20.add(jLabel13);

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Desde");
        jLabel15.setOpaque(true);
        jPanel20.add(jLabel15);

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Hasta");
        jLabel19.setOpaque(true);
        jPanel20.add(jLabel19);

        jPanel22.setBackground(new java.awt.Color(238, 238, 238));
        jPanel22.setToolTipText("");
        jPanel22.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel27.setBackground(new java.awt.Color(238, 238, 238));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setOpaque(true);
        jPanel22.add(jLabel27);

        jLabel28.setBackground(new java.awt.Color(238, 238, 238));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setOpaque(true);
        jPanel22.add(jLabel28);

        jLabel29.setBackground(new java.awt.Color(238, 238, 238));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setOpaque(true);
        jPanel22.add(jLabel29);

        jLabel33.setBackground(new java.awt.Color(238, 238, 238));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setOpaque(true);
        jPanel22.add(jLabel33);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Media"));

        jPanel24.setBackground(new java.awt.Color(204, 204, 204));
        jPanel24.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Instituto");
        jLabel20.setOpaque(true);
        jPanel24.add(jLabel20);

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Lugar");
        jLabel21.setOpaque(true);
        jPanel24.add(jLabel21);

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Desde");
        jLabel22.setOpaque(true);
        jPanel24.add(jLabel22);

        jLabel23.setBackground(new java.awt.Color(204, 204, 204));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Hasta");
        jLabel23.setOpaque(true);
        jPanel24.add(jLabel23);

        jPanel31.setBackground(new java.awt.Color(238, 238, 238));
        jPanel31.setToolTipText("");
        jPanel31.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel34.setBackground(new java.awt.Color(238, 238, 238));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setOpaque(true);
        jPanel31.add(jLabel34);

        jLabel35.setBackground(new java.awt.Color(238, 238, 238));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setOpaque(true);
        jPanel31.add(jLabel35);

        jLabel52.setBackground(new java.awt.Color(238, 238, 238));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setOpaque(true);
        jPanel31.add(jLabel52);

        jLabel53.setBackground(new java.awt.Color(238, 238, 238));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setOpaque(true);
        jPanel31.add(jLabel53);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Superior"));

        jPanel33.setBackground(new java.awt.Color(204, 204, 204));
        jPanel33.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel24.setBackground(new java.awt.Color(204, 204, 204));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Instituto");
        jLabel24.setOpaque(true);
        jPanel33.add(jLabel24);

        jLabel54.setBackground(new java.awt.Color(204, 204, 204));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Lugar");
        jLabel54.setOpaque(true);
        jPanel33.add(jLabel54);

        jLabel55.setBackground(new java.awt.Color(204, 204, 204));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Desde");
        jLabel55.setOpaque(true);
        jPanel33.add(jLabel55);

        jLabel56.setBackground(new java.awt.Color(204, 204, 204));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Hasta");
        jLabel56.setOpaque(true);
        jPanel33.add(jLabel56);

        jPanel34.setBackground(new java.awt.Color(238, 238, 238));
        jPanel34.setToolTipText("");
        jPanel34.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel57.setBackground(new java.awt.Color(238, 238, 238));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setOpaque(true);
        jPanel34.add(jLabel57);

        jLabel58.setBackground(new java.awt.Color(238, 238, 238));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setOpaque(true);
        jPanel34.add(jLabel58);

        jLabel59.setBackground(new java.awt.Color(238, 238, 238));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setOpaque(true);
        jPanel34.add(jLabel59);

        jLabel60.setBackground(new java.awt.Color(238, 238, 238));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setOpaque(true);
        jPanel34.add(jLabel60);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Otros Estudios"));

        jPanel36.setBackground(new java.awt.Color(204, 204, 204));
        jPanel36.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Instituto");
        jLabel61.setOpaque(true);
        jPanel36.add(jLabel61);

        jLabel62.setBackground(new java.awt.Color(204, 204, 204));
        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Lugar");
        jLabel62.setOpaque(true);
        jPanel36.add(jLabel62);

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Desde");
        jLabel63.setOpaque(true);
        jPanel36.add(jLabel63);

        jLabel64.setBackground(new java.awt.Color(204, 204, 204));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Hasta");
        jLabel64.setOpaque(true);
        jPanel36.add(jLabel64);

        jPanel37.setBackground(new java.awt.Color(238, 238, 238));
        jPanel37.setToolTipText("");
        jPanel37.setLayout(new java.awt.GridLayout(1, 10, 5, 0));

        jLabel65.setBackground(new java.awt.Color(238, 238, 238));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setOpaque(true);
        jPanel37.add(jLabel65);

        jLabel66.setBackground(new java.awt.Color(238, 238, 238));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setOpaque(true);
        jPanel37.add(jLabel66);

        jLabel67.setBackground(new java.awt.Color(238, 238, 238));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setOpaque(true);
        jPanel37.add(jLabel67);

        jLabel83.setBackground(new java.awt.Color(238, 238, 238));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setOpaque(true);
        jPanel37.add(jLabel83);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 503, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel12);

        jTabbedPane1.addTab("Grado de Instrucción I", jScrollPane2);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(1200, 1200));

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
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarCargo))
                    .addComponent(jLabel37))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCargo))
                .addContainerGap(243, Short.MAX_VALUE))
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
                .addContainerGap(956, Short.MAX_VALUE))
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
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Otros Datos", jPanel49);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 496, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel17);

        jTabbedPane1.addTab("Cargo(s) Actual(es)", jScrollPane8);

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
                    .addComponent(jLabel39)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarCargo1))
                    .addComponent(jLabel40))
                .addContainerGap(186, Short.MAX_VALUE))
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
                .addContainerGap(755, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel23);

        jTabbedPane1.addTab("Hoja de Servicio", jScrollPane4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Inasistencias:");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(jTable8);

        btnAgregarEmpresa18.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        btnAgregarEmpresa18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus_16.png"))); // NOI18N
        btnAgregarEmpresa18.setText("Añadir Fila");
        btnAgregarEmpresa18.setToolTipText("Agregar Nueva");
        btnAgregarEmpresa18.setAlignmentY(0.0F);
        btnAgregarEmpresa18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarEmpresa18.setContentAreaFilled(false);
        btnAgregarEmpresa18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarEmpresa18.setIconTextGap(0);
        btnAgregarEmpresa18.setMargin(new java.awt.Insets(10, 14, 2, 14));
        btnAgregarEmpresa18.setVerifyInputWhenFocusTarget(false);
        btnAgregarEmpresa18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarEmpresa18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpresa18ActionPerformed(evt);
            }
        });

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
                        .addComponent(btnAgregarEmpresa18))
                    .addComponent(jLabel42))
                .addContainerGap(671, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarEmpresa18))
                .addGap(29, 29, 29)
                .addComponent(btnContinuarRegistro7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(671, Short.MAX_VALUE))
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
                .addContainerGap(671, Short.MAX_VALUE))
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
                .addContainerGap(837, Short.MAX_VALUE))
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

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAgregarEmpresa18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpresa18ActionPerformed

    private void btnContinuarRegistro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro7ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnContinuarRegistro7ActionPerformed

    private void btnAgregarEmpresa19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpresa19ActionPerformed

    private void btnContinuarRegistro8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro8ActionPerformed
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnContinuarRegistro8ActionPerformed

    private void btnAgregarEmpresa20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresa20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpresa20ActionPerformed

    private void btnContinuarRegistro9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro9ActionPerformed
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_btnContinuarRegistro9ActionPerformed

    private void btnContinuarRegistro10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarRegistro10ActionPerformed

    }//GEN-LAST:event_btnContinuarRegistro10ActionPerformed

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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
     
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInhabilitarActionPerformed

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed
      new viewCatalagoPersonal(null,null,null,null,this,this,true,Dialog.ModalityType.MODELESS).setVisible(true);
    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void btnAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargoActionPerformed
    if (txtCedula.getText().equals("") == false) {
    viewRegistrarCargo view = new viewRegistrarCargo(this,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL);
    view.setTxtCedula(txtCedula.getText());
    view.setVisible(true);

                                             }
    }//GEN-LAST:event_btnAgregarCargoActionPerformed

    private void btnAgregarCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargo1ActionPerformed
        if (txtCedula.getText().equals("") == false) {
            viewRegistrarHojaServicio view = new viewRegistrarHojaServicio(this,null,this,true,Dialog.ModalityType.DOCUMENT_MODAL);
            view.setTxtCedula(txtCedula.getText());
            view.setVisible(true);

        }
        else {
            JOptionPane.showMessageDialog( new JFrame(),"Debe introducir datos en el campo (Cédula) de la pestaña (Datos Personales)","Mensaje de Información",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCargo1ActionPerformed

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
            java.util.logging.Logger.getLogger(viewConsultarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewConsultarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewConsultarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewConsultarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewConsultarDatosPersonal(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCargo;
    private javax.swing.JButton btnAgregarCargo1;
    private javax.swing.JButton btnAgregarEmpresa18;
    private javax.swing.JButton btnAgregarEmpresa19;
    private javax.swing.JButton btnAgregarEmpresa20;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton btnContinuarRegistro10;
    private javax.swing.JButton btnContinuarRegistro7;
    private javax.swing.JButton btnContinuarRegistro8;
    private javax.swing.JButton btnContinuarRegistro9;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInhabilitar;
    private javax.swing.JComboBox comboTipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
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
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
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
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
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
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    public javax.swing.JTable tableCargoActual;
    private javax.swing.JTable tableHojaServicio;
    private javax.swing.JLabel txtApellidos;
    private javax.swing.JLabel txtCedula;
    private javax.swing.JTextField txtDatos;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtEstado1;
    private javax.swing.JLabel txtEstadoCivil;
    private javax.swing.JLabel txtFechaNac;
    private javax.swing.JLabel txtMunicipio;
    private javax.swing.JLabel txtMunicipio1;
    private javax.swing.JLabel txtNacionalidad;
    private javax.swing.JLabel txtNacionalizado;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtSector;
    private javax.swing.JLabel txtSector1;
    private javax.swing.JLabel txtTipoPersonal;
    // End of variables declaration//GEN-END:variables
}
