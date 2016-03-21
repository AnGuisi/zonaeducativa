/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelPlanteles {
    String nombre,lugar,codigo;
    int id_primaria;
    private conexionBD conexion;

    public modelPlanteles(String nombre, String lugar, String codigo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.codigo = codigo;
    }

    public modelPlanteles() {
       
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_primaria() {
        return id_primaria;
    }

    public void setId_primaria(int id_primaria) {
        this.id_primaria = id_primaria;
    }
   
    
    
    

        
 public void ListarPlanteles(DefaultTableModel tablaModel) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT * FROM dependencia";
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
         
        
    public boolean Registrar() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO primaria(\n" +
"            nombre, lugar, codigo)\n" +
"    VALUES ('"+this.nombre+"', '"+this.lugar+"', '"+this.codigo+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                     }
    
     public boolean VerificarPrimaria(String codigo) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM primaria WHERE (codigo = '"+codigo+"')");
 if (result != null) {
 result.next();
 
 
 this.setCodigo(result.getString("codigo"));
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                    }
}
