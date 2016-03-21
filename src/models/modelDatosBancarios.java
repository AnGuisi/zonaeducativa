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
public class modelDatosBancarios {
    private String numero_cuenta,tipo_cuenta,retroactivo,codigo;
    private int id_banco,cedula;
    conexionBD conexion;

    public modelDatosBancarios() {
    }

    public modelDatosBancarios(String numero_cuenta, String tipo_cuenta, String retroactivo, String codigo, int id_banco, int cedula) {
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.retroactivo = retroactivo;
        this.codigo = codigo;
        this.id_banco = id_banco;
        this.cedula = cedula;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getRetroactivo() {
        return retroactivo;
    }

    public void setRetroactivo(String retroactivo) {
        this.retroactivo = retroactivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
        public boolean registrarDatosBancarios() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO datos_bancarios(\n" +
"            retroactivo, numero_cuenta, tipo_cuenta, codigo, id_banco, cedula \n" +
"            )\n" +
"    VALUES ('"+this.retroactivo+"', '"+this.numero_cuenta+"', '"+this.tipo_cuenta+"', '"+this.codigo+"', '"+this.id_banco+"', '"+this.cedula+"'\n" +
"            );");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
                                               }
        
                public boolean editarDatosBancarios() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("UPDATE datos_bancarios\n" +
"   SET retroactivo='"+this.retroactivo+"', numero_cuenta='"+this.numero_cuenta+"', tipo_cuenta='"+this.tipo_cuenta+"', codigo='"+this.codigo+"', id_banco='"+this.id_banco+"' \n" +
"    \n" +
" WHERE cedula = '"+this.cedula+"'");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }
        
 public boolean consultarDatosBancarios(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM datos_bancarios AS db INNER JOIN personal as p ON db.cedula = p.cedula WHERE p.cedula = '"+ced+"'");
 if (result != null) {
 result.next();
 
this.setCedula(result.getInt("cedula"));
this.setCodigo(result.getString("codigo"));
this.setId_banco(result.getInt("id_banco"));
this.setNumero_cuenta(result.getString("numero_cuenta"));
this.setRetroactivo(result.getString("retroactivo"));
this.setTipo_cuenta(result.getString("tipo_cuenta"));

 
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
    int insert = conexion.actualizar("DELETE FROM datos_bancarios \n" +
"    \n" +
" WHERE cedula = '"+ced+"'");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }
 
}
