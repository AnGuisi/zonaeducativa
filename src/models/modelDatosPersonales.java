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
public class modelDatosPersonales {
   String apellidos,nombres,tipo_personal,nacionalidad,fecha_nac,estado_civil,nacionalizado,status;
   int cedula,estado,municipio,sector,direccion;
   Date fecha_nac_salida;
   conexionBD conexion;

    public modelDatosPersonales(String apellidos, String nombres, String tipo_personal, String nacionalidad, String fecha_nac, String estado_civil, int cedula, int estado, int municipio, int sector, int direccion) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.tipo_personal = tipo_personal;
        this.nacionalidad = nacionalidad;
        this.fecha_nac = fecha_nac;
        this.estado_civil = estado_civil;
        this.cedula = cedula;
        this.estado = estado;
        this.municipio = municipio;
        this.sector = sector;
        this.direccion = direccion;
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public modelDatosPersonales() {
        
    }

    public String getNacionalizado() {
        return nacionalizado;
    }

    public void setNacionalizado(String nacionalizado) {
        this.nacionalizado = nacionalizado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFecha_nac_salida() {
        return fecha_nac_salida;
    }

    public void setFecha_nac_salida(Date fecha_nac_salida) {
        this.fecha_nac_salida = fecha_nac_salida;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipo_personal() {
        return tipo_personal;
    }

    public void setTipo_personal(String tipo_personal) {
        this.tipo_personal = tipo_personal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
   
    public boolean RegistrarDatosPersonales() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO personal(\n" +
"            cedula, apellidos, nombres, nacionalidad, estado, municipio, \n" +
"            sector, fecha_nac, estado_civil, direccion,tipo,status)\n" +
"    VALUES ('"+this.cedula+"', '"+this.apellidos+"', '"+this.nombres+"', '"+this.nacionalidad+"', '"+this.estado+"', '"+this.municipio+"', \n" +
"            '"+this.sector+"', '"+this.fecha_nac+"', '"+this.estado_civil+"', '"+this.direccion+"', '"+this.tipo_personal+"','null');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
                                               }
    
  public boolean ConsultarDatosPersonales(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT p.status, p.tipo,p.nombres,p.apellidos,p.cedula,p.nacionalidad,p.fecha_nac,p.estado_civil,p.tipo,p.nacionalizado,d.id_direccion,m.id_municipio as \"municipio_nombre\",e.id_estado as \"estado_nombre\",s.id_sector as \"sector_nombre\" FROM personal as p INNER JOIN estado AS e ON p.estado = e.id_estado INNER JOIN municipio as m ON p.municipio = m.id_municipio INNER JOIN sector as s ON p.sector = s.id_sector INNER JOIN direccion as d ON p.direccion = d.id_direccion WHERE cedula = '"+ced+"'");
 if (result != null) {
 result.next();
     System.out.println(result.getDate("fecha_nac"));
 this.setNombres(result.getString("nombres"));
 this.setApellidos(result.getString("apellidos"));
 this.setTipo_personal(result.getString("tipo"));
 this.setEstado_civil(result.getString("estado_civil"));
 this.setNacionalidad(result.getString("nacionalidad"));
 this.setFecha_nac_salida(result.getDate("fecha_nac"));
 this.setEstado(result.getInt("estado_nombre"));
 this.setMunicipio(result.getInt("municipio_nombre"));
 this.setSector(result.getInt("sector_nombre"));
 this.setDireccion(result.getInt("id_direccion"));
 this.setNacionalizado(result.getString("nacionalizado"));
 this.setStatus(result.getString("status"));
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       } 
  
    public boolean ConsultarDatosPersonalesBasicos(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT  * FROM personal WHERE cedula = '"+ced+"'");
 if (result != null) {
 result.next();
 
 this.setNombres(result.getString("nombres"));
 this.setNacionalidad(result.getString("nacionalidad"));
 this.setStatus(result.getString("status"));

 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       } 
    
 public boolean VerificarPersona(String ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM personal WHERE (cedula = '"+ced+"')");
 if (result != null) {
 result.next();
 
 
 this.setCedula(result.getInt("cedula"));
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                    }
 
    public List CargarPersonal() throws SQLException {
   
    List ListItem = new ArrayList();
    conexion = new conexionBD();
    conexion.conectar();
    ResultSet result = conexion.query("SELECT nombres,apellidos,cedula FROM personal");
   
    if (result != null) {
        
    while(result.next()) {
    String nombres = result.getString("nombres");
    String apellidos = result.getString("apellidos");
    int cedula = result.getInt("cedula");
    String nombre_completo = nombres+" "+apellidos+" - Cédula de Identidad:"+cedula;
    ListItem.add(nombre_completo);
    
                         }
       
   
                        }

    conexion.cerrar();
    
    return ListItem;
 
                                      }
    
        public boolean editarDatosPersonales() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("UPDATE personal\n" +
"   SET apellidos='"+this.apellidos+"', nombres='"+this.nombres+"', nacionalidad='"+this.nacionalidad+"', estado='"+this.estado+"', municipio='"+this.municipio+"', \n" +
"       sector='"+this.sector+"', fecha_nac='"+this.fecha_nac+"', estado_civil='"+this.estado_civil+"', direccion='"+this.direccion+"', tipo='"+this.tipo_personal+"', nacionalizado='"+this.nacionalizado+"'\n" +
" WHERE cedula = '"+this.cedula+"';");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }
        
                public boolean inhabilitarPersonal(int ced) {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("UPDATE personal\n" +
"   SET status='Inhabilitado'\n" +
" WHERE cedula = '"+ced+"';");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }
        
         public void ListarPersonal(DefaultTableModel tablaModel) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT cedula as \"Cédula\", nombres as \"Nombres\", apellidos as \"Apellidos\" FROM personal";
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
