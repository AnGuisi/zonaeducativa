package models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Administrador
 */
public class modelSector {
private String nombre;
private int id,id_municipio;
private conexionBD conexion;


    public modelSector() {
    }

    public modelSector(String nombre, int id_municipio) {
        this.nombre = nombre;
        this.id_municipio = id_municipio;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }
    
    
    
    public List CargarSectores(int id_municipio) throws SQLException {
   
    List ListItem = new ArrayList();
    conexion = new conexionBD();
    conexion.conectar();
    ResultSet result = conexion.query("SELECT * FROM sector WHERE (id_municipio = '"+id_municipio+"')");
    if (result != null) {
    while(result.next()) {
    
    ListItem.add(result.getString("nombre"));
                         }
       
   
                        }

    conexion.cerrar();
    
    return ListItem;
   
 
                                      }
    
    public boolean ConsultarSectorNombre(String nombre) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT id_sector FROM sector WHERE (nombre = '"+nombre+"')");
 if (result != null) {
     result.next();
 this.setId(result.getInt("id_sector"));
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 conexion.cerrar();
 return retorno;
                                                                     }
  
    
         public boolean ConsultarSectorId(int id) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT nombre FROM sector WHERE (id_sector = '"+id+"')");
 if (result != null) {
     result.next();
 this.setNombre(result.getString("nombre"));
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 conexion.cerrar();
 return retorno;
                                                                     } 
         
         
          public boolean RegistrarSector(String nombre, int id_municipio) {
    boolean retorno = true;
   
    conexion = new conexionBD();
    conexion.conectar();
    conexion.actualizar("INSERT INTO sector (nombre,id_municipio)\n" +
"            values ('"+nombre+"','"+id_municipio+"')");
    conexion.cerrar();        
    return retorno;
 
                                                    }
}
