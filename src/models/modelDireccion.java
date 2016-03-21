/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gleycer
 */
public class modelDireccion {
    String direccion;
    int estado,municipio,sector,id_direccion;
    conexionBD conexion;

    public modelDireccion() {
    }

    public modelDireccion(String direccion, int estado, int municipio, int sector) {
        this.direccion = direccion;
        this.estado = estado;
        this.municipio = municipio;
        this.sector = sector;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    
    public boolean RegistrarDireccion() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO direccion(\n" +
"            direccion, estado, municipio, sector)\n" +
"    VALUES ('"+this.direccion+"','"+this.estado+"','"+this.municipio+"', '"+this.sector+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                         }
    
     public boolean ConsultarUltimoid () throws SQLException {
     boolean retorno = true;
     conexion = new conexionBD();
     conexion.conectar();
     ResultSet result = conexion.query("SELECT max( id_direccion ) AS id_direccion\n" +
"FROM direccion");
     if (result != null) {
     result.next();
       
     this.setId_direccion(result.getInt(1));
      
  
     retorno = true;
                         }
     else {
     retorno = false;
          }
     conexion.cerrar();
     return retorno;
                                                             }
     
             public boolean ConsultarDireccionId(int id) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM direccion WHERE (id_direccion = '"+id+"')");
 if (result != null) {
     result.next();
 this.setDireccion(result.getString("direccion"));
 this.setEstado(result.getInt("estado"));
 this.setMunicipio(result.getInt("municipio"));
 this.setSector(result.getInt("sector"));
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 conexion.cerrar();
 return retorno;
                                                                     }
             
                     public boolean editarDireccion(int id_direccion) {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("UPDATE direccion\n" +
"   SET direccion='"+this.direccion+"', estado='"+this.estado+"', municipio='"+this.municipio+"', sector='"+this.sector+"'\n" +
" WHERE id_direccion = '"+id_direccion+"';");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }
   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

}
