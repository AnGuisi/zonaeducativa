/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.sql.SQLException;
import java.util.List;
import models.modelEstado;

/**
 *
 * @author Gleycer
 */
public class controllerEstado {

        
           public static List CargarEstados() throws SQLException {
    
         modelEstado model = new  modelEstado();
        
         return model.CargarEstados(); 
}
           
    

    
}
