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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelCargo {
    private conexionBD conexion;
    private String codDependencia, codCargo, denCargo,asignaturas,turno,compensacion,asignaturas_p,fecha_ingreso,denPlantel;
    
    private int cedula, horas_d, horas_a,sueldo;

    public modelCargo(String denCargo,String fecha_ingreso,String codDependencia, String codCargo, int horas_d, int horas_a, int sueldo, String asignaturas, String turno, String compensacion, String asignaturas_p, int cedula) {
        this.denCargo = denCargo;
        this.fecha_ingreso = fecha_ingreso;
        this.codDependencia = codDependencia;
        this.codCargo = codCargo;
        this.denCargo = denCargo;
        this.horas_d = horas_d;
        this.horas_a = horas_a;
        this.sueldo = sueldo;
        this.asignaturas = asignaturas;
        this.turno = turno;
        this.compensacion = compensacion;
        this.asignaturas_p = asignaturas_p;
        this.cedula = cedula;
    }

    
    public modelCargo() {
    }

    public String getDenPlantel() {
        return denPlantel;
    }

    public void setDenPlantel(String denPlantel) {
        this.denPlantel = denPlantel;
    }

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }

    public String getDenCargo() {
        return denCargo;
    }

    public void setDenCargo(String denCargo) {
        this.denCargo = denCargo;
    }

    public int getHoras_d() {
        return horas_d;
    }

    public void setHoras_d(int horas_d) {
        this.horas_d = horas_d;
    }

    public int getHoras_a() {
        return horas_a;
    }

    public void setHoras_a(int horas_a) {
        this.horas_a = horas_a;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
 public void listarCargosActuales(DefaultTableModel tablaModel, int ced) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT c.id_cargo as \"ID Cargo\" ,p.cedula as \"Cédula\", d.cdependencia as \"Cód. Dependencia\", d.ddependencia as \"Dependencia\", c.codigo as \"Cód. Cargo\", c.dcargo as \"Cargo\" FROM personal as p INNER JOIN cargo as c ON c.cedula = p.cedula INNER JOIN dependencia as d ON  c.cdependencia = d.cdependencia WHERE p.cedula = '"+ced+"'";
 ResultSet result = conexion.query(sentencia);
 if (result != null) {
     try {
         ResultSetMetaData resultMD = result.getMetaData();
         
         int cantidadColumnas = resultMD.getColumnCount();
          for (int i = 1; i <= cantidadColumnas; i++) {
                         tablaModel.addColumn(resultMD.getColumnLabel(i));
                                                      }
          tablaModel.addColumn("Seleccionar");
          while (result.next()) {
          Object[] fila = new Object[cantidadColumnas+1];
          for (int i = 0; i<cantidadColumnas;i++) {
        
          fila[i]= result.getObject(i+1);
              
                                                  }
          fila[6] = false;
         
          tablaModel.addRow(fila);
         
                                }
     } catch (Exception e) {
     }
     conexion.cerrar();
   
                     }
                                                                                              }
 
  public void listarCargosActualesConsulta(DefaultTableModel tablaModel, int ced) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT p.cedula as \"Cédula\", d.cdependencia as \"Cód. Dependencia\", d.ddependencia as \"Dependencia\", c.codigo as \"Cód. Cargo\", c.dcargo as \"Cargo\" FROM personal as p INNER JOIN cargo as c ON c.cedula = p.cedula INNER JOIN dependencia as d ON  c.cdependencia = d.cdependencia WHERE p.cedula = '"+ced+"'";
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
                      
    public List cargarDenCargo() throws SQLException {
   
    List ListItem = new ArrayList();
    conexion = new conexionBD();
    conexion.conectar();
    ResultSet result = conexion.query("SELECT DISTINCT dcargo FROM cargo ORDER BY dcargo ASC");
    if (result != null) {
    while(result.next()) {
    
    ListItem.add(result.getString("dcargo"));
                         }
       
   
                        }

    conexion.cerrar();
    
    return ListItem;
   
 
                                                      }
    
    public boolean registrarCargo() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO cargo(\n" +
"            fecha_ingreso, compensacion, codigo, asignaturas, turno, asig_posibles, \n" +
"            dcargo, cedula, cdependencia, hd, ha, sueldo)\n" +
"    VALUES ('"+this.fecha_ingreso+"', '"+this.compensacion+"',  '"+this.codCargo+"', '"+this.asignaturas+"', '"+this.turno+"', '"+this.asignaturas_p+"', \n" +
"            '"+this.denCargo+"', '"+this.cedula+"', '"+this.codDependencia+"', '"+this.horas_d+"', '"+this.horas_a+"', '"+this.sueldo+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                     }
    
      public boolean consultarCargoActual(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM personal as p INNER JOIN cargo as c ON c.cedula = p.cedula INNER JOIN dependencia as d ON  c.cdependencia = d.cdependencia WHERE p.cedula = '"+ced+"'");
 if (result != null) {
 result.next();
     System.out.println("hola");
 this.setCodCargo(result.getString("codigo"));
 this.setDenCargo(result.getString("dcargo"));
 this.setDenPlantel(result.getString("ddependencia"));
 this.setHoras_a(result.getInt("ha"));
 this.setHoras_d(result.getInt("hd"));
 this.setSueldo(result.getInt("sueldo"));
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       } 
      
    public boolean eliminarCargo(Vector id_cargo) {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
        int i;
           for (i=0;i<id_cargo.size();i++) {
            
	   int m = conexion.actualizar("DELETE FROM cargo \n" +
"    WHERE id_cargo =  '"+id_cargo.get(i)+"'");
        boolean sw;
	   if (m!=0) {
		   retorno = true;
           }
        
    
                                         }
    conexion.cerrar(); 
   
    return retorno;
                                     }
    

}
