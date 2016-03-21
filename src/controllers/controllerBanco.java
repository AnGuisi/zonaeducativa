/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.sql.SQLException;
import java.util.List;
import models.modelBanco;

/**
 *
 * @author Gleycer
 */
public class controllerBanco {

        
           public static List cargarBanco() throws SQLException {
    
         modelBanco model = new  modelBanco();
        
         return model.cargarBancos(); 
}
           
    

    
}
