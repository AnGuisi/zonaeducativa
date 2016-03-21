/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gleycer
 */
public class modelEstado {
private String nombre;
private int id_estado;
private conexionBD conexion; 

    public modelEstado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public List CargarEstados() throws SQLException {
   
    List ListItem = new ArrayList();
    conexion = new conexionBD();
    conexion.conectar();
    ResultSet result = conexion.query("SELECT * FROM estado WHERE id_estado != 0");
    if (result != null) {
    while(result.next()) {
    
    ListItem.add(result.getString("nombre"));
                         }
       
   
                        }

    conexion.cerrar();
    
    return ListItem;
   
 
                                      }
    
 public boolean ConsultarEstadoNombre(String nombre) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT id_estado FROM estado WHERE (nombre = '"+nombre+"')");
 if (result != null) {
     result.next();
 this.setId_estado(result.getInt("id_estado"));
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 conexion.cerrar();
 return retorno;
                                                                            }
  
        public boolean ConsultarEstadoId(int id) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT nombre FROM estado WHERE (id_estado = '"+id+"')");
 if (result != null) {
     result.next();
 this.setNombre(result.getString("nombre"));
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 conexion.cerrar();
 return retorno;
                                                                     }
    
}
