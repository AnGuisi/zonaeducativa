/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelHojaServicio {
    String fechaIngreso, cargo,plantel,lugar,fechaTerminoServicio,causaRetiro,prima;
    int sueldo,cedula;
    private conexionBD conexion;

    public modelHojaServicio() {
    }

    public modelHojaServicio(String fechaIngreso, String cargo, String plantel, String lugar, String terminoServicio, String causaRetiro, String prima, int sueldo, int cedula) {
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.plantel = plantel;
        this.lugar = lugar;
        this.fechaTerminoServicio = terminoServicio;
        this.causaRetiro = causaRetiro;
        this.prima = prima;
        this.sueldo = sueldo;
        this.cedula = cedula;
    }
    
        public modelHojaServicio(String fechaIngreso, String cargo, String plantel, String terminoServicio, String causaRetiro, String prima, int sueldo, int cedula) {
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.plantel = plantel;
        this.fechaTerminoServicio = terminoServicio;
        this.causaRetiro = causaRetiro;
        this.prima = prima;
        this.sueldo = sueldo;
        this.cedula = cedula;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFechaTerminoServicio() {
        return fechaTerminoServicio;
    }

    public void setFechaTerminoServicio(String fechaTerminoServicio) {
        this.fechaTerminoServicio = fechaTerminoServicio;
    }

    public String getCausaRetiro() {
        return causaRetiro;
    }

    public void setCausaRetiro(String causaRetiro) {
        this.causaRetiro = causaRetiro;
    }

    public String getPrima() {
        return prima;
    }

    public void setPrima(String prima) {
        this.prima = prima;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
        public boolean registrarHojaServicio() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO hoja_servicio(\n" +
"            fecha_ingreso, cargo, plantel,fecha_termino, causa_retiro, \n" +
"            prima, sueldo,cedula)\n" +
"    VALUES ('"+this.fechaIngreso+"', '"+this.cargo+"', '"+this.plantel+"','"+this.fechaTerminoServicio+"', '"+this.causaRetiro+"', \n" +
"            '"+this.prima+"', '"+this.sueldo+"','"+this.cedula+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                                    }
        
              public boolean registrarHojaServicioC() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO hoja_servicio(\n" +
"            fecha_ingreso, cargo, plantel,causa_retiro, \n" +
"            prima, sueldo,cedula)\n" +
"    VALUES ('"+this.fechaIngreso+"', '"+this.cargo+"', '"+this.plantel+"','"+this.causaRetiro+"', \n" +
"            '"+this.prima+"', '"+this.sueldo+"','"+this.cedula+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                                    }
        
         public void listarHojaServicio(DefaultTableModel tablaModel, int ced) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT h.fecha_ingreso as \"Fecha Ingreso\", h.cargo as \"Cargo\", h.plantel as \"Plantel\", h.lugar as \"Lugar\", h.causa_retiro as \"Causa de Retiro\", h.fecha_termino as \"Fecha Término de Servicio\", h.sueldo as \"Sueldo\", h.prima as \"Prima\" FROM hoja_servicio as h INNER JOIN personal as p ON h.cedula = p.cedula WHERE p.cedula = '"+ced+"' ORDER BY h.fecha_termino ASC";
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
