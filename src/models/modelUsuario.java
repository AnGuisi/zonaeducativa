/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelUsuario {
    String usuario,contraseña,nombre,cedula,departamento;
    int tipo_usuario,verificar_sesion;
    conexionBD conexion;

    public modelUsuario(String usuario, String contraseña, String nombre, String cedula, String departamento, int tipo_usuario) {
       
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo_usuario = tipo_usuario;
        
        this.nombre = nombre;
        this.cedula = cedula;
        this.departamento = departamento;
    }

    public int getVerificar_sesion() {
        return verificar_sesion;
    }

    public void setVerificar_sesion(int verificar_sesion) {
        this.verificar_sesion = verificar_sesion;
    }

    public modelUsuario() {
    }

    public modelUsuario(String usuario) {
        this.usuario = usuario;
    }
    
   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

   


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
      
         public boolean RegistrarUsuario() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO usuario (password,usuario,departamento,nombre,cedula,tipo_usuario,verificar_sesion)\n" +
"            values ('"+this.contraseña+"', '"+this.usuario+"',  '"+this.departamento+"', '"+this.nombre+"','"+this.cedula+"','"+this.tipo_usuario+"',0)");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                           }
        
         public boolean ConsultarUsuario(String usuario) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM usuario WHERE (usuario = '"+usuario+"')");
 if (result != null) {
 result.next();
 
 this.setNombre(result.getString("nombre"));
 this.setUsuario(result.getString("usuario"));
 this.setDepartamento(result.getString("departamento"));
 this.setCedula(result.getString("cedula"));
 this.setTipo_usuario(result.getInt("tipo_usuario"));
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
         
         
 public boolean VerificarUsuario(String usuario,String contraseña) throws SQLException { //Inicio metodo consultar
 boolean retorno;
 conexion = new conexionBD();
 Connection conn = conexion.conectar2();
 String query = "SELECT * FROM usuario WHERE usuario = ? AND password= ?";
     
PreparedStatement prepStmt = conn.prepareStatement(query);
prepStmt.setString(1, usuario);
prepStmt.setString(2, contraseña);
ResultSet result = prepStmt.executeQuery();
 if (result.next()) {
 this.setVerificar_sesion(result.getInt("verificar_sesion"));
 this.setUsuario(result.getString("usuario"));
 this.setDepartamento(result.getString("departamento"));
 this.setTipo_usuario(result.getInt("tipo_usuario"));
 retorno = true;
                     }
 else {
 retorno = false;
      }
 result.close();
 prepStmt.close();
 conexion.cerrar();
 return retorno;
                                                                       }
                  
                  public void ListarUsuarios(DefaultTableModel tablaModel) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT u.usuario as \"Usuario\", u.cedula as \"Cédula\", u.nombre as \"Nombre\", u.departamento as \"Departamento\", u.tipo_usuario \"Tipo de Usuario\"  FROM usuario as u";
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

                   
           public boolean EditarUsuario(){
                      
	   boolean sw=false;
	   conexion = new conexionBD();
	   conexion.conectar(); 
	   int m = conexion.actualizar("UPDATE usuario\n" +
"   SET password='"+this.contraseña+"',  cedula='"+this.cedula+"', \n" +
"       nombre='"+this.nombre+"', departamento='"+this.departamento+"', tipo_usuario='"+this.tipo_usuario+"'\n" +
" WHERE usuario = '"+this.usuario+"';");
	   if (m!=0)
		   sw = true;
	   conexion.cerrar();
	   return sw;
	                                  }
           
           public boolean cambiarEstatusSesion(String usuario) {
           boolean sw = false;
           conexion = new conexionBD();
           conexion.conectar();
           int m = conexion.actualizar("UPDATE usuario\n" +
"   SET  verificar_sesion=1\n" +
" WHERE usuario = '"+usuario+"';");
	   if (m!=0) {
		   sw = true;
                     }
	   conexion.cerrar();
	   return sw;
                                                 }
           
                      public boolean cerrarSesion(String usuario) {
           boolean sw = false;
           conexion = new conexionBD();
           conexion.conectar();
           int m = conexion.actualizar("UPDATE usuario\n" +
"   SET  verificar_sesion=0\n" +
" WHERE usuario = '"+usuario+"';");
	   if (m!=0) {
		   sw = true;
                     }
	   conexion.cerrar();
	   return sw;
                                                 }
    
}
