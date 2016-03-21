/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.modelPlanteles;
import views.viewCatalagoPlanteles;
import views.viewFichaPersonal;
import views.viewRegistrarInstitutoPrimaria;

/**
 *
 * @author Gleycer
 */
public class controllerRegistrarPrimaria implements ActionListener{
    private modelPlanteles model;
    private viewRegistrarInstitutoPrimaria viewRegistrarPrimaria;
    private viewCatalagoPlanteles viewCatalagoPrimaria;

    public void setViewCatalagoPrimaria(viewCatalagoPlanteles viewCatalagoPrimaria) {
        this.viewCatalagoPrimaria = viewCatalagoPrimaria;
    }
    

    public controllerRegistrarPrimaria(viewRegistrarInstitutoPrimaria viewRegistrarPrimaria) {
        this.viewRegistrarPrimaria = viewRegistrarPrimaria;
    }

        public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();
       
       
        if (envDisparado.equals(viewRegistrarPrimaria.getBtnRegistrarPrimaria()))
	{	
      
            try {
			Registrar();
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        }

            
              
                                                           }

             public void Registrar()  throws SQLException {
        
   String mensaje;
   
   this.model = new modelPlanteles(viewRegistrarPrimaria.getTxtNombre(),viewRegistrarPrimaria.getTxtLugar(),viewRegistrarPrimaria.getTxtCodigo());
   boolean inclusion = model.Registrar();

   if (inclusion) {
                  
                  
                  mensaje = new String("Registro Satisfactorio");
		  Mensaje(mensaje,"Registro realizado satisfactoriamente",1);
                  viewRegistrarPrimaria.dispose();
                  viewCatalagoPrimaria.cargarTablePlanteles();
                  
                    }
     else
		{ mensaje = new String("No se ha podido realizar el registro");
		  Mensaje(mensaje,"ERROR",2);
		}

   
   
                                                               }
             
        public boolean verificarPrimaria(String codigo) throws SQLException {
        this.model = new modelPlanteles();
        boolean consulta = model.VerificarPrimaria(codigo);
        if (consulta) {
         return true;
                      }
        else {
        return false;
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
              
}