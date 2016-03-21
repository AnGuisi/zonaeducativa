/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Gustavo Gil
 */
public class modelSuperior {
   String nombres,lugars,codigoS, tituloS;
   String fechaDesdeS, años_cursadoss, aprobados;
   int ced;
    
   private conexionBD conexion;

    public modelSuperior(String nombres, String lugars, String codigoS, String tituloS, String fechaDesdeS, String años_cursadoss, String aprobados, int ced) {
        this.nombres = nombres;
        this.lugars = lugars;
        this.codigoS = codigoS;
        this.tituloS = tituloS;
        this.fechaDesdeS = fechaDesdeS;
        this.años_cursadoss = años_cursadoss;
        this.aprobados = aprobados;
        this.ced = ced;
    }


    public modelSuperior() {
        
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getLugars() {
        return lugars;
    }

    public void setLugars(String lugars) {
        this.lugars = lugars;
    }

    public String getCodigos() {
        return codigoS;
    }

    public void setCodigos(String codigoS) {
        this.codigoS = codigoS;
    }

    public String getFechaDesdeS() {
        return fechaDesdeS;
    }

    public void setFechaDesdeS(String fechaDesdeS) {
        this.fechaDesdeS = fechaDesdeS;
    }

    public String getAños_cursadoss() {
        return años_cursadoss;
    }

    public void setAños_cursadoss(String años_cursadoss) {
        this.años_cursadoss = años_cursadoss;
    }

    public String getAprobados() {
        return aprobados;
    }

    public void setAprobados(String aprobados) {
        this.aprobados = aprobados;
    }


    public int getCedula() {
        return ced;
    }

    public void setCedula(int cedula) {
        this.ced = cedula;
    }

    public conexionBD getConexion() {
        return conexion;
    }

    public void setConexion(conexionBD conexion) {
        this.conexion = conexion;
    }

    public String getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(String codigoS) {
        this.codigoS = codigoS;
    }

    public String getTituloS() {
        return tituloS;
    }

    public void setTituloS(String tituloS) {
        this.tituloS = tituloS;
    }
   
    public boolean registrarSuperior() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar(" INSERT INTO superior(\n" +
"            nombre, ced_personal, desde, lugar, titulo, \n" +
"            \"años_cursados\", codigo, graduado)\n" +
"    VALUES ('"+this.nombres+"','"+this.ced+"','"+this.fechaDesdeS+"','"+this.lugars+"','"+this.tituloS+"', \n" +
"           '"+this.años_cursadoss+"', '"+this.codigoS+"','"+this.aprobados+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
   
}
    
      public boolean consultarSuperior(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM superior WHERE ced_personal = '"+ced+"'");
 
 if (result != null) {
 result.next();
 
 this.setNombres(result.getString("nombre"));
 this.setTituloS(result.getString("titulo"));
 this.setFechaDesdeS(result.getString("desde"));
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }

}