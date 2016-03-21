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
public class modelCargoPropuesto {
    private conexionBD conexion;
    private String ccargo, dcargo, cdependencia, titulo, asignatura, tipo_nombr,codigo_nomina,grado,paso,sueldo,ddependencia;
    private int ha, hd, id_cargo_propuesto, cedula, turno;

    public modelCargoPropuesto(String ccargo, String dcargo, String cdependencia, String titulo, String asignatura, String tipo_nombr, String codigo_nomina, String grado, String paso, String sueldo, int ha, int hd, int cedula, int turno) {
        this.ccargo = ccargo;
        this.dcargo = dcargo;
        this.cdependencia = cdependencia;
        this.titulo = titulo;
        this.asignatura = asignatura;
        this.tipo_nombr = tipo_nombr;
        this.codigo_nomina = codigo_nomina;
        this.grado = grado;
        this.paso = paso;
        this.sueldo = sueldo;
        this.ha = ha;
        this.hd = hd;  
        this.cedula = cedula;
        this.turno = turno;
    }

    public modelCargoPropuesto() {
    }

    public String getDdependencia() {
        return ddependencia;
    }

    public void setDdependencia(String ddependencia) {
        this.ddependencia = ddependencia;
    }

    public String getCcargo() {
        return ccargo;
    }

    public void setCcargo(String ccargo) {
        this.ccargo = ccargo;
    }

    public String getDcargo() {
        return dcargo;
    }

    public void setDcargo(String dcargo) {
        this.dcargo = dcargo;
    }

    public String getCdependencia() {
        return cdependencia;
    }

    public void setCdependencia(String cdependencia) {
        this.cdependencia = cdependencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTipo_nombr() {
        return tipo_nombr;
    }

    public void setTipo_nombr(String tipo_nombr) {
        this.tipo_nombr = tipo_nombr;
    }

    public int getHa() {
        return ha;
    }

    public void setHa(int ha) {
        this.ha = ha;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getCodigo_nomina() {
        return codigo_nomina;
    }

    public void setCodigo_nomina(String codigo_nomina) {
        this.codigo_nomina = codigo_nomina;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public int getId_cargo_propuesto() {
        return id_cargo_propuesto;
    }

    public void setId_cargo_propuesto(int id_cargo_propuesto) {
        this.id_cargo_propuesto = id_cargo_propuesto;
    }
    
       public boolean consultarUltimoid () throws SQLException {
     boolean retorno = true;
     conexion = new conexionBD();
     conexion.conectar();
     ResultSet result = conexion.query("SELECT max( id_cargo_propuesto ) AS id_cargo_propuesto\n" +
"FROM cargo_propuesto");
     if (result != null) {
     result.next();
       
     this.setId_cargo_propuesto(result.getInt(1));
      
  
     retorno = true;
                         }
     else {
     retorno = false;
          }
     conexion.cerrar();
     return retorno;
                                                             }
    
    public boolean registrarCargo() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO cargo_propuesto(\n" +
"            ccargo, dcargo, cdependencia, titulo, asignatura, ha, hd, tipo_nombr, \n" +
"             cedula, turno, sueldo)\n" +
"    VALUES ('"+this.ccargo+"', '"+this.dcargo+"', '"+this.cdependencia+"', '"+this.titulo+"', '"+this.asignatura+"', '"+this.ha+"', '"+this.hd+"', '"+this.tipo_nombr+"', \n" +
"            '"+this.cedula+"', '"+this.turno+"','"+this.sueldo+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                     }
    
    
 public boolean consultarCargoPropuesto(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM personal as p INNER JOIN cargo_propuesto as c ON c.cedula = p.cedula INNER JOIN dependencia as d ON  c.cdependencia = d.cdependencia WHERE p.cedula = '"+ced+"'");
 if (result != null) {
 result.next();
 
 this.setCcargo(result.getString("ccargo"));
 this.setCdependencia(result.getString("cdependencia"));
 this.setDcargo(result.getString("dcargo"));
 this.setDdependencia(result.getString("ddependencia"));
 this.setHa(result.getInt("ha"));
 this.setHd(result.getInt("hd"));
 this.setSueldo(result.getString("sueldo"));
 this.setTitulo(result.getString("titulo"));
 this.setAsignatura(result.getString("asignatura"));
 this.setTipo_nombr(result.getString("tipo_nombr"));
 this.setCodigo_nomina(result.getString("codigo_nomina"));
 this.setGrado(result.getString("grado"));
 this.setPaso(result.getString("paso"));
 this.setSueldo(result.getString("sueldo"));
 this.setTurno(result.getInt("turno"));
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
    

      public boolean deshacerCambios(int ced) {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("DELETE FROM cargo_propuesto \n" +
"    \n" +
" WHERE cedula = '"+ced+"'");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }  

}
