/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelBanco;
import models.modelDatosBancarios;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerRegistrarDatosBancarios implements ActionListener{
    viewTramitesAdministrativos view;
    modelDatosBancarios model;
    modelBanco modelBanco;

    public controllerRegistrarDatosBancarios(viewTramitesAdministrativos view) {
        this.view = view;
    }

    
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        if(eventDisparado.equals(view.getBtnUpDatosBancarios())) {
            try {
                registrarDatosBancarios();
            } catch (SQLException ex) {
                Logger.getLogger(controllerRegistrarDatosBancarios.class.getName()).log(Level.SEVERE, null, ex);
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
                
          public void registrarDatosBancarios() throws SQLException {
          String mensaje = null; 
          String numeroCuenta= null, nombreBanco= null,codigo=null,tipoCuenta=null,retroactivo=null;
          int cedula=0, id_banco=0;
          
          numeroCuenta = view.getTxtNumeroCuenta();
          nombreBanco = view.getComboBanco().getSelectedItem().toString();
          codigo = view.getTxtCodigoBanc();
          tipoCuenta = view.getComboTipoCuenta().getSelectedItem().toString();
          retroactivo = view.getTxtRetroactivo();
          cedula = Integer.parseInt(view.getTxtCedula());
          
          this.modelBanco = new modelBanco();
          boolean consultaIdBanco = modelBanco.consutarBancoId(nombreBanco);
          if(consultaIdBanco) {
          id_banco = modelBanco.getId_banco();
                              }
          this.model = new modelDatosBancarios(numeroCuenta, tipoCuenta, retroactivo, codigo, id_banco, cedula);
          if(model.consultarDatosBancarios(cedula) == false) {
          boolean registrarDatosBancarios = model.registrarDatosBancarios();
          if (registrarDatosBancarios) {
          mensaje = new String("Registro Satisfactorio");
          Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
          view.getTabbedDocente().setSelectedIndex(3);
          view.reestablecerDatosBancarios();
                                       }
          else {
          mensaje = new String("No se ha podido realizar el registro");
	  Mensaje(mensaje,"ERROR",2);
               }
                                                             }
          else {
          boolean editarDatosBancarios = model.editarDatosBancarios();
          if(editarDatosBancarios) {
          mensaje = new String("Registro Satisfactorio");
          Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
          view.getTabbedDocente().setSelectedIndex(3);
          view.reestablecerDatosBancarios();
                                   }
          else {
          mensaje = new String("No se ha podido realizar el registro");
	  Mensaje(mensaje,"ERROR",2);
               }
               }

                                                                        }


}
