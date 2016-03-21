/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import models.modelEstado;
import models.modelMunicipio;
import models.modelPlanteles;
import models.modelSector;
import views.viewFichaPersonal;

/**
 *
 * @author Gleycer
 */
public class controllerFichaPersonal implements ActionListener{
    private viewFichaPersonal viewFichaPersonal;
    private modelEstado modelEstado;
    private modelMunicipio modelMunicipio;
    private modelSector modelSector;
    private modelPlanteles modelPrimaria;

    //private modelMunicipio modelMunicipio;
    //private modelSector modelSector;
    public controllerFichaPersonal(viewFichaPersonal viewFichaPersonal) {
        this.viewFichaPersonal = viewFichaPersonal;
    }
    
        public void actionPerformed(ActionEvent evenDisp) {
        Object envDisparado = evenDisp.getSource();


         if (envDisparado.equals(viewFichaPersonal.getComboNacionalidad()))
		 	{
           
            try {
                CargarComboEstado();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                                                                                 
                           }
                        
         
            if (viewFichaPersonal.getComboEstado().getSelectedIndex()>0) {
          if (envDisparado.equals(viewFichaPersonal.getComboEstado()))
		 	{
        
        try {
             
                CargarComboMunicipio(viewFichaPersonal.getComboEstado().getSelectedItem().toString(),viewFichaPersonal.getComboMunicipio(),viewFichaPersonal.getComboSector());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                        }
                                                                          }

              
           if (viewFichaPersonal.getComboMunicipio().getSelectedIndex()>0) {
          if (envDisparado.equals(viewFichaPersonal.getComboMunicipio()))
		 	{
        
        try {
             
                CargarComboSector(viewFichaPersonal.getComboMunicipio().getSelectedItem().toString(),viewFichaPersonal.getComboSector());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                         }
                                                                             }
           else {
                viewFichaPersonal.getComboSector().removeAllItems();
                
                     }
                                                                           
            
               if (viewFichaPersonal.getComboEstado2().getSelectedIndex()>0) {
          if (envDisparado.equals(viewFichaPersonal.getComboEstado2()))
		 	{
        
        try {
             
                CargarComboMunicipio(viewFichaPersonal.getComboEstado2().getSelectedItem().toString(),viewFichaPersonal.getComboMunicipio2(),viewFichaPersonal.getComboSector2());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                        }
                                                                               }
                else {
                viewFichaPersonal.getComboMunicipio2().removeAllItems();
                viewFichaPersonal.getComboMunicipio2().addItem("Seleccione...");
                     }
               
                if (viewFichaPersonal.getComboMunicipio2().getSelectedIndex()>0) {
          if (envDisparado.equals(viewFichaPersonal.getComboMunicipio2()))
		 	{
        
        try {
             
                CargarComboSector(viewFichaPersonal.getComboMunicipio2().getSelectedItem().toString(),viewFichaPersonal.getComboSector2());
            } catch (SQLException e) {
                e.printStackTrace();
                                     }
                         }
                                                                             }
                 else {
                viewFichaPersonal.getComboSector2().removeAllItems();
                
                     }
            

         
          
         
    
                       } // Fin actionPerformed
    
       private void CargarComboEstado() throws SQLException {
     
     this.modelEstado = new modelEstado();
     
     
     if (viewFichaPersonal.getComboNacionalidad().getSelectedIndex() == 1) {
    
     List ListItem = modelEstado.CargarEstados();
     int i;
    if (ListItem != null) {
      viewFichaPersonal.getComboEstado().removeAllItems();
      viewFichaPersonal.getComboEstado().addItem("Seleccione...");
      viewFichaPersonal.getComboMunicipio().removeAllItems();
      viewFichaPersonal.getComboMunicipio().addItem("Seleccione...");
      viewFichaPersonal.getComboSector().removeAllItems();
      viewFichaPersonal.getComboSector().addItem("Seleccione");
      
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
    viewFichaPersonal.getComboEstado().addItem(ListItem.get(i));
                                }
                          }
                                                                            }

                   }
         
       private boolean CargarComboMunicipio(String estado, JComboBox municipio,JComboBox sector) throws SQLException {
    
    String nombre = estado;
    
     
     this.modelMunicipio = new modelMunicipio();
    
     
     int id_estado;
     boolean consulta = modelEstado.ConsultarEstadoNombre(nombre);
      
   
     if (consulta) {
       
    id_estado = modelEstado.getId_estado();
     List ListItem = modelMunicipio.CargarMunicipios(id_estado);
     int i;
    if (ListItem != null) {
      municipio.removeAllItems();
      municipio.addItem("Seleccione...");
      
      
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
      municipio.addItem(ListItem.get(i));
                                }
                          }
                   }
      
     return consulta;
     }
       
          private boolean CargarComboSector(String municipio,JComboBox sector) throws SQLException {
    
    String nombre = municipio;
   
     
     this.modelSector = new modelSector();
     this.modelMunicipio = new modelMunicipio();
     
     int id_municipio;
     boolean consulta = modelMunicipio.ConsultarMunicipioNombre(nombre);
      
   
     if (consulta) {
       
    id_municipio = modelMunicipio.getId();
     List ListItem = modelSector.CargarSectores(id_municipio);
     int i;
    if (ListItem != null) {
      sector.removeAllItems();
      sector.addItem("Seleccione...");
    int size = ListItem.size();
    for (i=0;i<size;i++)        {
      sector.addItem(ListItem.get(i));
                                }
                          }
                   }
     else {
     System.out.println("Ha ocurrido un error");
          }
     
     return consulta;
     }
          

                                                               }
    
    
    
    

