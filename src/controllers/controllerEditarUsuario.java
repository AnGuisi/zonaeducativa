/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.modelUsuario;
import views.viewCatalagoUsuarios;
import views.viewEditarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class controllerEditarUsuario implements ActionListener{
viewCatalagoUsuarios view;
viewEditarUsuario viewEditarUsuario;
modelUsuario model;

    public controllerEditarUsuario(viewCatalagoUsuarios view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
        if (envDisparado.equals(view.getBtnEditar())) {
        int filaSeleccionada=view.getTableUsuarios().getSelectedRow();
        
                    String usuario = view.getTableUsuarios().getValueAt(filaSeleccionada, 0).toString();
            try {                                           
                EnviarEditar(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(controllerEditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                                                      }
     
                                                      }
            
public void EnviarEditar(String usuario) throws SQLException {
this.model = new modelUsuario();
boolean consultar_usuario = model.ConsultarUsuario(usuario);
viewEditarUsuario = new viewEditarUsuario();
viewEditarUsuario.setTxtNombre(model.getNombre());
viewEditarUsuario.setTxtId(model.getUsuario());
viewEditarUsuario.setTxtCedula(model.getCedula());
viewEditarUsuario.getComboDepartamento().setSelectedItem(model.getDepartamento());
viewEditarUsuario.setVisible(true);
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