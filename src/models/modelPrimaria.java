/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.Date;

/**
 *
 * @author Gleycer
 */
public class modelPrimaria {
   String nombre,lugar,codigo;
   String fechaDesde, fechaHasta;
   Date fechaDesdeSal, fechaHastaSal;
   int cedula;

    public modelPrimaria(String nombre, String lugar, String codigo, String fechaDesde, String fechaHasta, int cedula) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.codigo = codigo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.cedula = cedula;
    }
   
    private conexionBD conexion;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Date getFechaDesdeSal() {
        return fechaDesdeSal;
    }

    public void setFechaDesdeSal(Date fechaDesdeSal) {
        this.fechaDesdeSal = fechaDesdeSal;
    }

    public Date getFechaHastaSal() {
        return fechaHastaSal;
    }

    public void setFechaHastaSal(Date fechaHastaSal) {
        this.fechaHastaSal = fechaHastaSal;
    }
    
    

    public boolean registrarPrimaria() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO primaria(\n" +
"            nombre, lugar, codigo, ced_personal, desde, \n" +
"            hasta) \n" +
"    VALUES ('"+this.nombre+"', '"+this.lugar+"', '"+this.codigo+"', '"+this.cedula+"', '"+this.fechaDesde+"', '"+this.fechaHasta+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
                                               }
    
    
    
}
