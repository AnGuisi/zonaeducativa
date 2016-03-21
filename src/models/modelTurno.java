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
public class modelTurno {
    private String dtitular, x_interino, w_interino, horas_variables, bono_bol, turno;
    private int  id_turno;
    private conexionBD conexion;

    public modelTurno(String dtitular, String x_interino, String w_interino, String horas_variables, String bono_bol, String turno) {
        this.dtitular = dtitular;
        this.x_interino = x_interino;
        this.w_interino = w_interino;
        this.horas_variables = horas_variables;
        this.bono_bol = bono_bol;
        this.turno = turno;
        
    }

    public modelTurno() {
    }

    public String getDtitular() {
        return dtitular;
    }

    public void setDtitular(String dtitular) {
        this.dtitular = dtitular;
    }

    public String getX_interino() {
        return x_interino;
    }

    public void setX_interino(String x_interino) {
        this.x_interino = x_interino;
    }

    public String getW_interino() {
        return w_interino;
    }

    public void setW_interino(String w_interino) {
        this.w_interino = w_interino;
    }

    public String getHoras_variables() {
        return horas_variables;
    }

    public void setHoras_variables(String horas_variables) {
        this.horas_variables = horas_variables;
    }

    public String getBono_bol() {
        return bono_bol;
    }

    public void setBono_bol(String bono_bol) {
        this.bono_bol = bono_bol;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }
    
    
    public boolean registrarTurno() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO turno(\n" +
"            dtitular, x_interino, w_interino, horas_variables, bono_bol, \n" +
"            turno)\n" +
"    VALUES ('"+this.dtitular+"', '"+this.x_interino+"', '"+this.w_interino+"', '"+this.horas_variables+"', '"+this.bono_bol+"', \n" +
"            '"+this.turno+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                     }
    
       public boolean consultarUltimoid () throws SQLException {
     boolean retorno = true;
     conexion = new conexionBD();
     conexion.conectar();
     ResultSet result = conexion.query("SELECT max( id_turno ) AS id_turno\n" +
"FROM turno");
     if (result != null) {
     result.next();
       
     this.setId_turno(result.getInt(1));
      
  
     retorno = true;
                         }
     else {
     retorno = false;
          }
     conexion.cerrar();
     return retorno;
                                                             }
       

       


     
      public boolean consultarTurno(int turno) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM turno WHERE id_turno = '"+turno+"'");
 if (result != null) {
 result.next();
 
     this.setBono_bol(result.getString("bono_bol"));
     this.setDtitular(result.getString("dtitular"));
     this.setHoras_variables(result.getString("horas_variables"));
     this.setTurno(result.getString("turno"));
     this.setW_interino(result.getString("w_interino"));
     this.setX_interino(result.getString("x_interino"));
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
}
