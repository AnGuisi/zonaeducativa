/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Gustavo Gil
 */
public class modelExtranjero {
    String titulo_Ex, pais, duracion_Ex, postgradoEx;
    int cedulaP;
    
    private conexionBD conexion;

    public modelExtranjero() {
    }

    public modelExtranjero(String titulo_Ex, String pais, String duracion_Ex, String postgradoEx, int cedulaP) {
        this.titulo_Ex = titulo_Ex;
        
        this.duracion_Ex = duracion_Ex;
        this.postgradoEx = postgradoEx;
        this.cedulaP = cedulaP;
        
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCedulaP() {
        return cedulaP;
    }

    public void setCedulaP(int cedulaP) {
        this.cedulaP = cedulaP;
    }

    public String getTitulo_Ex() {
        return titulo_Ex;
    }

    public void setTitulo_Ex(String titulo_Ex) {
        this.titulo_Ex = titulo_Ex;
    }

    public String getDuracion_Ex() {
        return duracion_Ex;
    }

    public void setDuracion_Ex(String duracion_Ex) {
        this.duracion_Ex = duracion_Ex;
    }

    public String getPostgradoEx() {
        return postgradoEx;
    }

    public void setPostgradoEx(String postgradoEx) {
        this.postgradoEx = postgradoEx;
    }

    public conexionBD getConexion() {
        return conexion;
    }

    public void setConexion(conexionBD conexion) {
        this.conexion = conexion;
    }
    
     public boolean registrarExtranjero() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert;
        insert = conexion.actualizar("')"+" INSERT INTO extranjero(\n" +
                "            titulo_ex, pais, duracion_ex, postgrado, cedulap)\n" +
                "    VALUES ('"+this.titulo_Ex+"','"+this.pais+"','"+this.duracion_Ex+"','"+this.postgradoEx+"','"+this.cedulaP+"');");

    if (insert != 0) {
    retorno = true;
                     }
    return retorno;
   
}

    
    
    
    
}
