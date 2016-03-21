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
public class modelBanco {
    private String nombre;
    private int id_banco;
    private conexionBD conexion;

    public modelBanco() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }
    
        public boolean consutarBancoNombre(int id_banco) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM banco WHERE id_banco = '"+id_banco+"'");
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
        
                public boolean consutarBancoId(String nombre) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM banco WHERE nombre = '"+nombre+"'");
 if (result != null) {
 result.next();
 
 this.setId_banco(result.getInt("id_banco"));

 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
                
            public List cargarBancos() throws SQLException {
   
    List ListItem = new ArrayList();
    conexion = new conexionBD();
    conexion.conectar();
    ResultSet result = conexion.query("SELECT * FROM banco");
    if (result != null) {
    while(result.next()) {
    
    ListItem.add(result.getString("nombre"));
                         }
       
   
                        }

    conexion.cerrar();
    
    return ListItem;
   
 
                                      }
    
}
