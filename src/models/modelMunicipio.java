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
public class modelMunicipio {
    private String nombre;
    private int id,id_estado;
    private conexionBD conexion;

    public modelMunicipio(String nombre, int id_estado) {
        this.nombre = nombre;
        this.id_estado = id_estado;
    }

    public modelMunicipio() {
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

        public List CargarMunicipios(int id_estado) throws SQLException {
   
    List ListItem = new ArrayList();
    conexion = new conexionBD();
    conexion.conectar();
    ResultSet result = conexion.query("SELECT * FROM municipio WHERE (id_estado = '"+id_estado+"')");
    if (result != null) {
    while(result.next()) {
    
    ListItem.add(result.getString("nombre"));
                         }
       
   
                        }

    conexion.cerrar();
    
    return ListItem;
   
 
                                      }
        
            public boolean ConsultarMunicipioNombre(String nombre) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT id_municipio FROM municipio WHERE (nombre = '"+nombre+"')");
 if (result != null) {
     result.next();
 this.setId(result.getInt("id_municipio"));
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 conexion.cerrar();
 return retorno;
                                                                     }
  
        public boolean ConsultarMunicipioId(int id) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT nombre FROM municipio WHERE (id_municipio = '"+id+"')");
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
        
     /*          public boolean RegistrarMunicipio() {
    boolean retorno = true;
   
    conexion = new conexionBD();
    conexion.conectar();
    conexion.actualizar("INSERT INTO municipio (nombre,id_estado)\n" +
"            values ('"+this.nombre+"','"+this.id_estado+"')");
    conexion.cerrar();        
    return retorno;
 
                                                    } */
}
