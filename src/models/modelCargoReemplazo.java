/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Gleycer
 */
public class modelCargoReemplazo {
    private conexionBD conexion;
    private Vector<Integer> id_cargo = new Vector<Integer>();

    public Vector<Integer> getId_cargo() {
        return id_cargo;
    }


    

    public modelCargoReemplazo() {
    }
    
        public boolean registrarCargoReemplazo(Vector id_cargo,int id_cargo_propuesto){
	   boolean sw=false;
	   conexion = new conexionBD();
	   conexion.conectar(); 
           int i;       
           for (i=0;i<id_cargo.size();i++) {
               
	   int m = conexion.actualizar("INSERT INTO cargo_reemplazo(\n" +
"            id_cargo, id_cargo_propuesto)\n" +
"    VALUES ('"+id_cargo.get(i)+"', '"+id_cargo_propuesto+"');");
	   if (m!=0)
		   sw = true;
        
    
                                         }
           conexion.cerrar();
                                            return sw;      
                                                                       }
        
               public boolean consultarCargoReemplazo (int id_cargo_propuesto) throws SQLException {
     boolean retorno = true;
     conexion = new conexionBD();
     conexion.conectar();
     ResultSet result = conexion.query("SELECT * \n" +
"FROM cargo_reemplazo WHERE id_cargo_propuesto = '"+id_cargo_propuesto+"'");
     if (result != null) {

    while (result.next()) {
    id_cargo.add(result.getInt(1));
                          }
       
         
                          
  
     retorno = true;
                         }
     else {
     retorno = false;
          }
     conexion.cerrar();
     return retorno;
                                                             }
        
              public boolean deshacerCambios(int id_cargo_propuesto) {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("DELETE FROM cargo_reemplazo \n" +
"    \n" +
" WHERE id_cargo_propuesto = '"+id_cargo_propuesto+"'");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               } 
}
