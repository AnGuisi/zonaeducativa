/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Gustavo Gil
 */
public class modelMedia {
    String nombre,lugar,codigo;
   String fechaDesde, fechaHasta, años_cursados, aprobado;
   Date fechaDesdeSal, fechaHastaSal;
   int cedula;
    
   public modelMedia(String nombre, String lugar, String codigo, String fechaDesde, String fechaHasta, String años_cursados, String aprobados, int cedula) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.codigo = codigo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.cedula = cedula;
        this.años_cursados = años_cursados;
        this.aprobado = aprobados;
    }
   private conexionBD conexion;

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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public conexionBD getConexion() {
        return conexion;
    }

    public void setConexion(conexionBD conexion) {
        this.conexion = conexion;
    }

    public String getAños_cursados() {
        return años_cursados;
    }

    public void setAños_cursados(String años_cursados) {
        this.años_cursados = años_cursados;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }
   
    
    
    
   public boolean registrarDatosPersonales() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("    INSERT INTO media(\n" +
"            nombre, lugar, codigo, desde, hasta, años_cursados, graduado, cedula)\n" +
"    VALUES ('"+this.nombre+"', '"+this.lugar+"', '"+this.codigo+"', '"+this.fechaDesde+"', '"+this.fechaHasta+"', '"+this.años_cursados+"', '"+this.aprobado+"', '"+this.cedula+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
   
   
   
}
}