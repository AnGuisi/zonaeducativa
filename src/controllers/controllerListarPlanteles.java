/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.swing.table.DefaultTableModel;
import models.modelPlanteles;
import models.modelUsuario;
import views.viewCatalagoPlanteles;

/**
 *
 * @author Gleycer
 */
public class controllerListarPlanteles {
    private modelPlanteles model;
    private viewCatalagoPlanteles view;

    public controllerListarPlanteles(viewCatalagoPlanteles view) {
        this.view = view;
    }
    
         public void controllerListarPlanteles(DefaultTableModel tablaModel){
            model = new modelPlanteles();
            model.ListarPlanteles(tablaModel);
                                                                            }
}
