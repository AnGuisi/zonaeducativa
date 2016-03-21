/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelInasistencia {
    int cedula,id_inasistencia;
    String acumulado,motivo,justificacion,fecha;
    Date fechaSalida;
    private conexionBD conexion;

    public modelInasistencia() {
    }

    public modelInasistencia(int cedula, String motivo, String justificacion, String fecha) {
        this.cedula = cedula;
        this.acumulado = acumulado;
        this.motivo = motivo;
        this.justificacion = justificacion;
        this.fecha = fecha;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getId_inasistencia() {
        return id_inasistencia;
    }

    public void setId_inasistencia(int id_inasistencia) {
        this.id_inasistencia = id_inasistencia;
    }

    public String getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(String acumulado) {
        this.acumulado = acumulado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public boolean registrarInasistencia() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO inasistencia(\n" +
"            cedula,motivo, justificacion, fecha)\n" +
"    VALUES ('"+this.cedula+"', '"+this.motivo+"', '"+this.justificacion+"', '"+this.fecha+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
                                             }
    
         public void listarInasistencias(DefaultTableModel tablaModel, int ced) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT\n" +
"COUNT(*) as \"Número\",\n" +
"i.fecha as \"Fecha\",\n" +
"i.motivo as \"Motivo\",\n" +
"i.justificacion as \"Justificación\"\n" +
"FROM inasistencia AS i\n" +
"INNER JOIN personal as p ON i.cedula = p.cedula \n" +
"WHERE p.cedula ='"+ced+"' \n" +
"GROUP BY i.cedula,i.fecha,i.motivo,i.justificacion";
 ResultSet result = conexion.query(sentencia);
 if (result != null) {
     try {
         ResultSetMetaData resultMD = result.getMetaData();
         
         int cantidadColumnas = resultMD.getColumnCount();
          for (int i = 1; i <= cantidadColumnas; i++) {
                         tablaModel.addColumn(resultMD.getColumnLabel(i));
                                                      }
          while (result.next()) {
          Object[] fila = new Object[cantidadColumnas];
          for (int i = 0; i<cantidadColumnas;i++) {
          fila[i]= result.getObject(i+1);
                                                  }
          tablaModel.addRow(fila);
         
                                }
     } catch (Exception e) {
     }
     conexion.cerrar();
   
                     }
                                                                                              }
    

}
