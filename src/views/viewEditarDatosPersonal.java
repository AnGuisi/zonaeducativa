/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import controllers.controllerConsultarDatosPersonal;
import controllers.controllerEditarDatosPersonal;
import controllers.controllerEstado;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utilities.OSValidator;

/**
 *
 * @author Gleycer
 */
public class viewEditarDatosPersonal extends javax.swing.JDialog {
    private OSValidator validarOS;
    private int id_direccion = 0;
    /**
     * Creates new form viewEditarDatosPersonal
     */
    public viewEditarDatosPersonal(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent,modal);
        this.validarOS = new OSValidator();
        validarOS.validarOS();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Editar Datos Personles");
        CargarComboEstado();
        inicializacionEventos();
        txtFechaNac.setDate(java.sql.Date.valueOf("1950-01-01"));
    }
    
        private void inicializacionEventos() {
    controllerEditarDatosPersonal controlador = new controllerEditarDatosPersonal (this);
    
    
    comboNacionalidad.addActionListener(controlador);
    comboEstado.addActionListener(controlador);
    comboMunicipio.addActionListener(controlador);
    comboEstado2.addActionListener(controlador);
    comboMunicipio2.addActionListener(controlador);
    btnEditarDatos.addActionListener(controlador);
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

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public JButton getBtnEditarDatos() {
        return btnEditarDatos;
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
    
    ////////////////////////////////////////////////////////////////
    public void setComboEstado2(JComboBox comboEstado2) {
        this.comboEstado2 = comboEstado2;
    }

    public void setComboEstadoCivil(JComboBox comboEstadoCivil) {
        this.comboEstadoCivil = comboEstadoCivil;
    }

    public void setComboMunicipio2(JComboBox comboMunicipio2) {
        this.comboMunicipio2 = comboMunicipio2;
    }

    public void setComboSector(JComboBox comboSector) {
        this.comboSector = comboSector;
    }

    public void setComboSector2(JComboBox comboSector2) {
        this.comboSector2 = comboSector2;
    }

    public void setComboTipoPersonal(JComboBox comboTipoPersonal) {
        this.comboTipoPersonal = comboTipoPersonal;
    }

    public void setTxtApellidos(String Apellidos) {
        txtApellidos.setText(Apellidos);
    }

    public void setTxtCedula(String Cedula) {
        txtCedula.setText(Cedula);
    }

    public void setTxtDireccion(String Direccion) {
        txtDireccion.setText(Direccion);
    }

    public void setTxtFechaNac(Date FechaNac) {
        txtFechaNac.setDate(FechaNac);
    }

    public void setTxtNacionalizado(String Nacionalizado) {
        txtNacionalizado.setText(Nacionalizado);
    }

    public void setTxtNombres(String Nombres) {
        txtNombres.setText(Nombres);
    }

    public JDateChooser getFechaNac() {
        return txtFechaNac;
    }

    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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
        btnEditarDatos = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Editar Datos Personales");
        jPanel8.add(jLabel2);

        jPanel10.add(jPanel8);

        jPanel3.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(4, 2, 0, 15));

        jLabel4.setText("Cédula de Identidad Nº:");
        jPanel4.add(jLabel4);

        txtCedula.setEditable(false);
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

            btnEditarDatos.setBackground(new java.awt.Color(255, 255, 255));
            btnEditarDatos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
            btnEditarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_p.png"))); // NOI18N
            btnEditarDatos.setText("Editar Registro");
            btnEditarDatos.setToolTipText("Examinar...");
            btnEditarDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            btnEditarDatos.setContentAreaFilled(false);
            btnEditarDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnEditarDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_app/agregar_g.png"))); // NOI18N
            btnEditarDatos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            btnEditarDatos.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnEditarDatosActionPerformed(evt);
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
                        .addComponent(btnEditarDatos)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNacionalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
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
                            .addGap(56, 56, 56)
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
                    .addComponent(btnEditarDatos)
                    .addContainerGap(91, Short.MAX_VALUE))
            );

            jScrollPane22.setViewportView(jPanel2);

            javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
            jPanel25.setLayout(jPanel25Layout);
            jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
            );
            jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            );

            jTabbedPane1.addTab("Datos Personales", jPanel25);

            jPanel1.add(jTabbedPane1);

            jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
   
    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        if(txtApellidos.getText().length()<=3) {
            //JOptionPane.showMessageDialog( new JDialog(),"El campo (Apellidos) debe poseer mas de 3 carácteres","ERROR",JOptionPane.INFORMATION_MESSAGE);

            validaApellidos.setText("*Apellidos Incorrecto");
        }
        else {
            validaApellidos.setText("");

        }
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        String apellidos = txtApellidos.getText().toUpperCase();
        txtApellidos.setText(apellidos);
    }//GEN-LAST:event_txtApellidosKeyReleased

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

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        if(txtNombres.getText().length()<=3) {
            //JOptionPane.showMessageDialog( new JDialog(),"El campo (Nombres) debe poseer mas de 3 carácteres","ERROR",JOptionPane.INFORMATION_MESSAGE);

            validaNombres.setText("*Nombres Incorrecto");
        }
        else {
            validaNombres.setText("");

        }
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
        String nombres = txtNombres.getText().toUpperCase();
        txtNombres.setText(nombres);
    }//GEN-LAST:event_txtNombresKeyReleased

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

    private void comboSectorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSectorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSectorFocusLost

    private void comboEstadoCivilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboEstadoCivilFocusLost
        if(comboEstadoCivil.getSelectedIndex() == 0) {

            validaEstadoCivil.setText("*Estado Civil Incorrecto");
        }
        else {
            validaEstadoCivil.setText("");

        }
    }//GEN-LAST:event_comboEstadoCivilFocusLost

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

    private void btnEditarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDatosActionPerformed

    }//GEN-LAST:event_btnEditarDatosActionPerformed

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost

        if(txtDireccion.getText().length()<=3) {

            validaDireccion.setText("*Dirección Incorrecta");
        }
        else {
            validaDireccion.setText("");

        }
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if(txtDireccion.getText().length()>60) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

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
            java.util.logging.Logger.getLogger(viewEditarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewEditarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewEditarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewEditarDatosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewEditarDatosPersonal(new javax.swing.JFrame(), true).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(viewEditarDatosPersonal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarDatos;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JComboBox comboEstado2;
    private javax.swing.JComboBox comboEstadoCivil;
    private javax.swing.JComboBox comboMunicipio;
    private javax.swing.JComboBox comboMunicipio2;
    private javax.swing.JComboBox comboNacionalidad;
    private javax.swing.JComboBox comboSector;
    private javax.swing.JComboBox comboSector2;
    private javax.swing.JComboBox comboTipoPersonal;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private com.toedter.calendar.JDateChooser txtFechaNac;
    private javax.swing.JTextField txtNacionalizado;
    private javax.swing.JTextField txtNombres;
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
}
