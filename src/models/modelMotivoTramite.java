/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelMotivoTramite {
    int id_motivo_tramite,id_tramite;
    String fecha,descripcion,tipo_motivo,estatus;
    Date fecha_salida;
    private conexionBD conexion;

    public modelMotivoTramite(int id_tramite, String fecha, String descripcion, String tipo_motivo,String estatus) {
        this.id_tramite = id_tramite;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo_motivo = tipo_motivo;
        this.estatus = estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public modelMotivoTramite() {
    }

    public int getId_motivo_tramite() {
        return id_motivo_tramite;
    }

    public void setId_motivo_tramite(int id_motivo_tramite) {
        this.id_motivo_tramite = id_motivo_tramite;
    }

    public int getId_tramite() {
        return id_tramite;
    }

    public void setId_tramite(int id_tramite) {
        this.id_tramite = id_tramite;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_motivo() {
        return tipo_motivo;
    }

    public void setTipo_motivo(String tipo_motivo) {
        this.tipo_motivo = tipo_motivo;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
        public boolean registrarMotivoTramite() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO \"motivo_tramite\"(\n" +
"            fecha, descripcion, id_tramite, tipo_motivo,estatus)\n" +
"    VALUES ('"+this.fecha+"', '"+this.descripcion+"', '"+this.id_tramite+"', '"+this.tipo_motivo+"', '"+this.estatus+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
                                                 }
        
 public void listarHistorialTramites(DefaultTableModel tablaModel, int ced) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT \n" +
"mt.fecha as \"Fecha\",\n" +
"mt.tipo_motivo as \"Tipo\",\n" +
"mt.descripcion as \"Motivo\",\n" +
"mt.estatus as \"Estatus\"\n" +
"FROM tramite_administrativo AS ta \n" +
"INNER JOIN personal as p ON ta.cedula = p.cedula \n" +
"INNER JOIN motivo_tramite as mt ON ta.id_tramite = mt.id_tramite WHERE ta.cedula = '"+ced+"'";
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
