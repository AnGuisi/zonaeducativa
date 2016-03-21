/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.swing.table.DefaultTableModel;
import models.modelPlanteles;
import models.modelTramiteAdministrativo;
import views.viewCatalagoPlanteles;
import views.viewHistorialTramites;

/**
 *
 * @author Gleycer
 */
public class controllerListarHistorialTramites {
    private modelTramiteAdministrativo model;
    private viewHistorialTramites view;

    public controllerListarHistorialTramites(viewHistorialTramites view) {
        this.view = view;
    }

         public void controllerListarHistorialTramites(DefaultTableModel tablaModel){
            model = new modelTramiteAdministrativo();
            model.listarHistorialTramites(tablaModel);
                                                                            }
}
