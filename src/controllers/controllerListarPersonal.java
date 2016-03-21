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
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import models.modelDatosPersonales;
import views.viewCatalagoPersonal;
import views.viewConsultarDatosPersonal;
import views.viewHistorialTramites;
import views.viewTramitesAdministrativos;

/**
 *
 * @author Gleycer
 */
public class controllerListarPersonal implements ActionListener {
    private modelDatosPersonales model;
    private viewCatalagoPersonal view;
    private viewConsultarDatosPersonal viewConsultar;
    private viewHistorialTramites viewHistorialTramites;
    private viewTramitesAdministrativos viewTramites;
    private JButton btnFuncSaliente;
    private JButton btnConsultarPersonal;

    public void setBtnConsultarPersonal(JButton btnConsultarPersonal) {
        this.btnConsultarPersonal = btnConsultarPersonal;
    }

    public void setBtnFuncSaliente(JButton btnFuncSaliente) {
        this.btnFuncSaliente = btnFuncSaliente;
    }

    public void setViewTramites(viewTramitesAdministrativos viewTramites) {
        this.viewTramites = viewTramites;
    }

    public void setViewHistorialTramites(viewHistorialTramites viewHistorialTramites) {
        this.viewHistorialTramites = viewHistorialTramites;
    }

    public controllerListarPersonal(viewCatalagoPersonal view) {
        this.view = view;
    }

    public void setViewConsultar(viewConsultarDatosPersonal viewConsultar) {
        this.viewConsultar = viewConsultar;
    }
    
         public void controllerListarPersonal(DefaultTableModel tablaModel){
            model = new modelDatosPersonales();
            model.ListarPersonal(tablaModel);
                                                                            }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventDisparado = e.getSource();
        
        if (eventDisparado.equals(view.getBtnSeleccionar())) {
            
        int filaSeleccionada=view.getTablePersonal().getSelectedRow();
        String ced = view.getTablePersonal().getValueAt(filaSeleccionada, 0).toString();
        
        if (viewConsultar != null) {
        viewConsultar.getComboTipoBusqueda().setSelectedIndex(1);
        viewConsultar.setTxtDatos(ced);
        viewConsultar.getDatos().setEditable(true);
        view.dispose();
                                   }
        else if (viewHistorialTramites != null) {
        viewHistorialTramites.getComboTipoBusqueda().setSelectedIndex(1);
        viewHistorialTramites.setTxtDatos(ced);
        viewHistorialTramites.getDatos().setEditable(true);
        view.dispose();
                                   }
        else  if (viewTramites != null) {
         if (btnFuncSaliente != null) {
         viewTramites.setTxtCedulaFuncSaliente(ced);
         view.dispose();
         }
         else if (btnConsultarPersonal != null) {
        viewTramites.getComboTipoBusqueda().setSelectedIndex(1);
        viewTramites.setTxtDatos(ced);
        viewTramites.getDatos().setEditable(true);
        view.dispose();
              }
                                        }
                                                              } 
    }
}
