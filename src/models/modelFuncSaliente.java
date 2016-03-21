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
public class modelFuncSaliente {
    private conexionBD conexion;
    private int id_func_saliente,cedula,cedula_p_tramite;
    private String observaciones,destino;

    public modelFuncSaliente() {
    }

    public modelFuncSaliente(int cedula, int cedula_p_tramite, String observaciones, String destino) {
        this.cedula = cedula;
        this.cedula_p_tramite = cedula_p_tramite;
        this.observaciones = observaciones;
        this.destino = destino;
    }

    public int getCedula_p_tramite() {
        return cedula_p_tramite;
    }

    public void setCedula_p_tramite(int cedula_p_tramite) {
        this.cedula_p_tramite = cedula_p_tramite;
    }



    public int getId_func_saliente() {
        return id_func_saliente;
    }

    public void setId_func_saliente(int id_func_saliente) {
        this.id_func_saliente = id_func_saliente;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
        public boolean registrarFuncSaliente() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO func_saliente(\n" +
"            cedula, destino, observaciones, cedula_p_tramite)\n" +
"    VALUES ('"+this.cedula+"', '"+this.destino+"', '"+this.observaciones+"', '"+this.cedula_p_tramite+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                     }
        
         public boolean consultarFuncSaliente(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM func_saliente AS fs WHERE fs.cedula_p_tramite = '"+ced+"'");
 if (result != null) {
 result.next();
 
this.setCedula(result.getInt("cedula"));
this.setCedula_p_tramite(result.getInt("cedula_p_tramite"));
this.setDestino(result.getString("destino"));
this.setObservaciones(result.getString("Observaciones"));

 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
    
}
