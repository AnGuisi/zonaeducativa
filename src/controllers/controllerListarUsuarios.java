/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.modelUsuario;
import views.viewCatalagoUsuarios;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class controllerListarUsuarios {
    private modelUsuario model;
    private viewCatalagoUsuarios view;

    public controllerListarUsuarios(viewCatalagoUsuarios view) {
        this.view = view;
    }
    
    
    
     public void controllerListarSolicitantes(DefaultTableModel tablaModel){
            model = new modelUsuario();
            model.ListarUsuarios(tablaModel);
                                                                            }

    
}
