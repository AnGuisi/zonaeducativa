/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.sql.SQLException;
import java.util.List;
import models.modelMunicipio;

/**
 *
 * @author Gleycer
 */
public class controllerMunicipio {
    
               public static List CargarMunicipios() throws SQLException {
    
         modelMunicipio model = new  modelMunicipio();
        
         return model.CargarMunicipios(22); 
}
  
    
}
