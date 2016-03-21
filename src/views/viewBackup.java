package views;


import java.awt.Dialog;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nestor
 */
public class viewBackup extends javax.swing.JDialog {

    Process p;
    ProcessBuilder pb;
    JFileChooser seleccion = new JFileChooser();
    //JButton btn; JComboBox cBFormato; static JTextArea progreso;
    //JTextField rutaArchivo, usuario, clave, bDatos, host, puerto;

    /**
     * Creates new form Respaldo
     */
    public viewBackup(java.awt.Frame parent, boolean modal, ModalityType modalityType) {
         super(parent,modal);
        initComponents();
//         colocarSkin();
        cBFormato.setSelectedItem("Custom");
        progreso.setEditable(false);
        rutaArchivo.setText(System.getProperty("user.dir") + "/SIFOJY_BD.txt");

        seleccion.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));

        //JScrollPane scroll = new JScrollPane(progreso);
        //scroll.setPreferredSize(new Dimension(400,200));
        //add(scroll, java.awt.BorderLayout.SOUTH);
    }

    public void colocarSkin() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void pgBackUp(String host, String puerto, String usuario, String clave, String bDatos, String format, String path) {
        try { /*
             C:/Program Files/PostgreSQL/9.1/bin\pg_dump.exe 
             --host localhost --port 5432 --username "postgres" --role "postgres"  
             --format custom --blobs --oids --inserts --column-inserts --no-privileges --no-tablespaces 
             --use-set-session-authorization --disable-dollar-quoting --verbose --quote-all-identifiers 
             --no-unlogged-table-data --file "path" "postgres" */

            if (!format.equalsIgnoreCase("")) {
                pb = new ProcessBuilder("C:/Archivos de programa/PostgreSQL/9.3/bin/pg_dump.exe", "--verbose", "--format", format, "-f", path);
            } else {
                pb = new ProcessBuilder("C:/Archivos de programa/PostgreSQL/9.3/bin/pg_dump.exe", "--verbose", "--inserts", "--column-inserts", "-f", path);
            }
            pb.environment().put("PGHOST", host);
            pb.environment().put("PGPORT", puerto);
            pb.environment().put("PGUSER", usuario);
            pb.environment().put("PGPASSWORD", clave);
            pb.environment().put("PGDATABASE", bDatos);
            pb.redirectErrorStream(true);
            p = pb.start();

            escribirProcess(p);
            System.out.print("terminado backup " + path + "\n");
        } catch (Exception e) {
            System.out.print("backup \n" + e.getMessage() + "\n");
        }
    }

    public void pgRestore(String host, String puerto, String usuario, String clave, String bDatos, String format, String path) {
        //String servidor, String puerto, String usuario, String password, String basedatos, String path

        try {/*
             C:/Program Files/PostgreSQL/9.1/bin\pg_restore.exe 
             --host localhost --port 5432 --username "postgres" --dbname "postgres" --role "postgres" 
             --no-password  --data-only --disable-triggers --create --clean --single-transaction 
             --no-data-for-failed-tables --use-set-session-authorization  
             --verbose "path" */

            pb = new ProcessBuilder("C:/Archivos de programa/PostgreSQL/9.3/bin/pg_restore", "-i", "-h", host, "-p", puerto, "-U", usuario, "-d", bDatos, "-v", path);
            pb.environment().put("PGPASSWORD", clave);
            pb.redirectErrorStream(true);

            p = pb.start();

            escribirProcess(p);
            System.out.print("terminado restore \n");
        } catch (Exception e) {
            System.out.print("restore \n" + e.getMessage() + "\n");
        }
    }

    static void escribirProcess(Process process) throws Exception {
        BufferedInputStream bufferIs = new BufferedInputStream(process.getInputStream());
        InputStreamReader isReader = new InputStreamReader(bufferIs);
        BufferedReader reader = new BufferedReader(isReader);
        String line = "";
        progreso.setText(line);
        while (true) {
            line = reader.readLine();
            if (line == null) {
                break;
            }
            progreso.setText(progreso.getText() + "\n" + line);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rutaArchivo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cBFormato = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        Puerto = new javax.swing.JLabel();
        puerto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        clave = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bDatos = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        progreso = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Nombre de Archivo");

        jButton1.setText(". . .");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Formato");

        cBFormato.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"","Custom","Tar","Plain", "Directoy"}));
        cBFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBFormatoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Host");

        host.setText("localhost");

        Puerto.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Puerto.setText("Puerto");

        puerto.setText("5432");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Usuario");

        usuario.setText("postgres");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Contraseña");

        clave.setText("12345");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("B. Dato");

        bDatos.setText("zonaeducativa");

        jButton2.setText("Respaldar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Restaurar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        progreso.setColumns(20);
        progreso.setRows(5);
        jScrollPane1.setViewportView(progreso);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/header_opt.png"))); // NOI18N
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(Puerto)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bDatos, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clave, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(puerto, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(host, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBFormato, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rutaArchivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cBFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Puerto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        setSize(new java.awt.Dimension(616, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (seleccion.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            rutaArchivo.setText(seleccion.getSelectedFile().getAbsolutePath());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cBFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBFormatoActionPerformed

        if (cBFormato.getSelectedIndex() == 0) {
            seleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            seleccion.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));
        } else {
            if (cBFormato.getSelectedIndex() == 1) {
                seleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                seleccion.setFileFilter(new FileNameExtensionFilter("Backup files (*.backup)", "backup"));
            } else {
                if (cBFormato.getSelectedIndex() == 2) {
                    seleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    seleccion.setFileFilter(new FileNameExtensionFilter("Backup files (*.backup)", "backup"));
                } else {
                    if (cBFormato.getSelectedIndex() == 3) {
                        seleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        seleccion.setFileFilter(new FileNameExtensionFilter("Query files (*.sql)", "sql"));
                    } else {
                        if (cBFormato.getSelectedIndex() == 4) {
                            seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                            seleccion.setFileFilter(new FileNameExtensionFilter("Directorys ", "txt", "backup", "sql"));
                        }
                    }
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cBFormatoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pgBackUp(host.getText(), puerto.getText(), usuario.getText(), clave.getText(),
                bDatos.getText(), cBFormato.getSelectedItem().toString(), rutaArchivo.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (cBFormato.getSelectedIndex() != 3 && cBFormato.getSelectedIndex() != 0) {
            pgRestore(host.getText(), puerto.getText(), usuario.getText(), clave.getText(),
                    bDatos.getText(), cBFormato.getSelectedItem().toString(), rutaArchivo.getText());
        } else {
            progreso.setText("-- no se puede restaurar el archivo --");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new viewBackup(new javax.swing.JFrame(), true, Dialog.ModalityType.DOCUMENT_MODAL).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Puerto;
    private javax.swing.JTextField bDatos;
    private javax.swing.JComboBox cBFormato;
    private javax.swing.JTextField clave;
    private javax.swing.JTextField host;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea progreso;
    private javax.swing.JTextField puerto;
    private javax.swing.JTextField rutaArchivo;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
