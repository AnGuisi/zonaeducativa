/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gleycer
 */
public class modelTramiteAdministrativo {
    private conexionBD conexion;
    private String fechaPreparacion, fechaEfecto;
    private int estado,numeroQuincena,cedula,horasA,horasD,sueldo,id_banco;
    private String tipoMovimiento,numeroZonaEducativa,cargoAdicional;
    private String nombres,apellidos,tipo_personal,estado_civil,nacionalidad;
    private Date fecha_nac_salida,fechaPreparacions, fechaEfectos;
    private String direccion;
    private String codCargoA,depA,denCargoA,cargaHoraria,salario;
    private String codDependencia,nombrePlantel,codCargo,denCargo,tituloObtenido,asignatura,totalHoras,tipoNombr;
    private String dtitular, x_interino, w_interino, horas_variables, bono_bol, turno;
    private String codigo_nomina,grado,paso;
    private String numero_cuenta,tipo_cuenta,retroactivo,codigo;
    private String banco;
    private String status;
    private String motivo_tramite;
    private int estado0,municipio,sector,estado1,municipio1,sector1,id_direccion,id_cargo_propuesto,id_cargo;

    public modelTramiteAdministrativo(String fechaPreparacion, String fechaEfecto, int estado, int numeroQuincena, int cedula, String tipoMovimiento, String numeroZonaEducativa, String cargoAdicional, String motivoTramite) {
        this.fechaPreparacion = fechaPreparacion;
        this.fechaEfecto = fechaEfecto;
        this.estado = estado;
        this.numeroQuincena = numeroQuincena;
        this.cedula = cedula;
        this.tipoMovimiento = tipoMovimiento;
        this.numeroZonaEducativa = numeroZonaEducativa;
        this.cargoAdicional = cargoAdicional;
        this.motivo_tramite = motivoTramite;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getMotivo_tramite() {
        return motivo_tramite;
    }

    public void setMotivo_tramite(String motivo_tramite) {
        this.motivo_tramite = motivo_tramite;
    }

    public int getId_cargo_propuesto() {
        return id_cargo_propuesto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_cargo_propuesto(int id_cargo_propuesto) {
        this.id_cargo_propuesto = id_cargo_propuesto;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public Date getFechaPreparacions() {
        return fechaPreparacions;
    }

    public void setFechaPreparacions(Date fechaPreparacions) {
        this.fechaPreparacions = fechaPreparacions;
    }

    public Date getFechaEfectos() {
        return fechaEfectos;
    }

    public void setFechaEfectos(Date fechaEfectos) {
        this.fechaEfectos = fechaEfectos;
    }

    public Date getFecha_nac_salida() {
        return fecha_nac_salida;
    }

    public void setFecha_nac_salida(Date fecha_nac_salida) {
        this.fecha_nac_salida = fecha_nac_salida;
    }

    public modelTramiteAdministrativo() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_personal() {
        return tipo_personal;
    }

    public void setTipo_personal(String tipo_personal) {
        this.tipo_personal = tipo_personal;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac_salida = fecha_nac;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodCargoA() {
        return codCargoA;
    }

    public void setCodCargoA(String codCargoA) {
        this.codCargoA = codCargoA;
    }

    public String getDepA() {
        return depA;
    }

    public void setDepA(String depA) {
        this.depA = depA;
    }

    public String getDenCargoA() {
        return denCargoA;
    }

    public void setDenCargoA(String denCargoA) {
        this.denCargoA = denCargoA;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCodDependencia() {
        return codDependencia;
    }

    public void setCodDependencia(String codDependencia) {
        this.codDependencia = codDependencia;
    }

    public String getNombrePlantel() {
        return nombrePlantel;
    }

    public void setNombrePlantel(String nombrePlantel) {
        this.nombrePlantel = nombrePlantel;
    }

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }

    public String getDenCargo() {
        return denCargo;
    }

    public void setDenCargo(String denCargo) {
        this.denCargo = denCargo;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getHorasA() {
        return horasA;
    }

    public void setHorasA(int horasA) {
        this.horasA = horasA;
    }

    public int getHorasD() {
        return horasD;
    }

    public void setHorasD(int horasD) {
        this.horasD = horasD;
    }


    public String getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getTipoNombr() {
        return tipoNombr;
    }

    public void setTipoNombr(String tipoNombr) {
        this.tipoNombr = tipoNombr;
    }

    public String getDtitular() {
        return dtitular;
    }

    public void setDtitular(String dtitular) {
        this.dtitular = dtitular;
    }

    public String getX_interino() {
        return x_interino;
    }

    public void setX_interino(String x_interino) {
        this.x_interino = x_interino;
    }

    public String getW_interino() {
        return w_interino;
    }

    public void setW_interino(String w_interino) {
        this.w_interino = w_interino;
    }

    public String getHoras_variables() {
        return horas_variables;
    }

    public void setHoras_variables(String horas_variables) {
        this.horas_variables = horas_variables;
    }

    public String getBono_bol() {
        return bono_bol;
    }

    public void setBono_bol(String bono_bol) {
        this.bono_bol = bono_bol;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getFechaPreparacion() {
        return fechaPreparacion;
    }

    public void setFechaPreparacion(String fechaPreparacion) {
        this.fechaPreparacion = fechaPreparacion;
    }

    public String getFechaEfecto() {
        return fechaEfecto;
    }

    public void setFechaEfecto(String fechaEfecto) {
        this.fechaEfecto = fechaEfecto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNumeroQuincena() {
        return numeroQuincena;
    }

    public void setNumeroQuincena(int numeroQuincena) {
        this.numeroQuincena = numeroQuincena;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getNumeroZonaEducativa() {
        return numeroZonaEducativa;
    }

    public void setNumeroZonaEducativa(String numeroZonaEducativa) {
        this.numeroZonaEducativa = numeroZonaEducativa;
    }

    public String getCargoAdicional() {
        return cargoAdicional;
    }

    public void setCargoAdicional(String cargoAdicional) {
        this.cargoAdicional = cargoAdicional;
    }

    public int getEstado0() {
        return estado0;
    }

    public void setEstado0(int estado0) {
        this.estado0 = estado0;
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

    public int getEstado1() {
        return estado1;
    }

    public void setEstado1(int estado1) {
        this.estado1 = estado1;
    }

    public int getMunicipio1() {
        return municipio1;
    }

    public void setMunicipio1(int municipio1) {
        this.municipio1 = municipio1;
    }

    public int getSector1() {
        return sector1;
    }

    public void setSector1(int sector1) {
        this.sector1 = sector1;
    }


    

    
    public boolean registrarTramiteAdministrativo() {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("INSERT INTO tramite_administrativo(\n" +
"            fecha_preparacion, fecha_efecto, municipio, numero_quincena, \n" +
"            tipo_movimiento, numero_zona_educativa, cedula,cargo_adicional,status,motivo)\n" +
"    VALUES ('"+this.fechaPreparacion+"', '"+this.fechaEfecto+"', '"+this.estado+"', '"+this.numeroQuincena+"', '"+this.tipoMovimiento+"', '"+this.numeroZonaEducativa+"', '"+this.cedula+"', '"+this.cargoAdicional+"', 'Pendiente','"+this.motivo_tramite+"');");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                                    }
    

     public void listarHistorialTramites(DefaultTableModel tablaModel) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT p.nombres as \"Nombres\", \n" +
"p.apellidos as \"Apellidos\", \n" +
"p.cedula as \"Cédula\", \n" +
"ta.tipo_movimiento as \"Tipo de Trámite\",\n" +
"ta.numero_zona_educativa as \"Número Zona Educativa\", \n" +
"ta.status as \"Estatus\",\n" +
"ta.id_tramite as \"Número de Identificación\"\n" +
"FROM tramite_administrativo AS ta  \n" +
"INNER JOIN personal as p ON ta.cedula = p.cedula \n" +
"INNER JOIN municipio as e ON ta.municipio = e.id_municipio";
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
     
 public void consultarTramite(DefaultTableModel tablaModel, int ced) {
 boolean sw=false;
 conexion = new conexionBD();
 conexion.conectar();
 String sentencia= "SELECT p.nombres as \"Nombres\", \n" +
"p.apellidos as \"Apellidos\", \n" +
"p.cedula as \"Cédula\", \n" +
"ta.tipo_movimiento as \"Tipo de Trámite\",\n" +
"ta.numero_zona_educativa as \"Número Zona Educativa\", \n" +
"ta.status as \"Estatus\",\n" +
"ta.id_tramite as \"Número de Identificación\"\n" +
"FROM tramite_administrativo AS ta  \n" +
"INNER JOIN personal as p ON ta.cedula = p.cedula \n" +
"INNER JOIN municipio as e ON ta.municipio = e.id_municipio WHERE p.cedula = '"+ced+"'";
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
 
  public boolean verTramite(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT b.id_banco,p.nombres,p.apellidos,p.cedula,p.estado,p.municipio,p.sector,p.direccion,p.tipo,p.estado_civil,\n" +
"p.fecha_nac,p.nacionalidad,dir.id_direccion,ta.fecha_efecto,ta.municipio as \"municipio_ta\",ta.fecha_preparacion,\n" +
"ta.numero_zona_educativa,ta.tipo_movimiento,ta.cargo_adicional,cp.id_cargo_propuesto,c.id_cargo,db.numero_cuenta,db.codigo,\n" +
"db.tipo_cuenta,b.nombre,db.retroactivo\n" +
"FROM personal as p\n" +
"INNER JOIN tramite_administrativo AS ta ON p.cedula = ta.cedula\n" +
"INNER JOIN cargo AS c ON p.cedula = c.cedula\n" +
"LEFT OUTER JOIN cargo_propuesto AS cp ON p.cedula = cp.cedula\n" +
"LEFT OUTER JOIN datos_bancarios AS db ON p.cedula = db.cedula\n" +
"INNER JOIN banco AS b ON db.id_banco = b.id_banco\n" +
"INNER JOIN estado AS e ON p.estado = e.id_estado\n" +
"INNER JOIN municipio AS m ON p.municipio = m.id_municipio\n" +
"INNER JOIN sector AS s ON p.sector = s.id_sector\n" +
"INNER JOIN direccion AS dir ON p.direccion = dir.id_direccion\n" +
"WHERE p.cedula = '"+ced+"' ORDER BY id_cargo DESC LIMIT 1");
 
 if (result != null) {
 result.next();
 
 this.setNombres(result.getString("nombres"));
 this.setApellidos(result.getString("apellidos"));
 this.setTipo_personal(result.getString("tipo"));
 this.setEstado_civil(result.getString("estado_civil"));
 this.setNacionalidad(result.getString("nacionalidad"));
 this.setFecha_nac_salida(result.getDate("fecha_nac"));
 this.setEstado0(result.getInt("estado"));
 this.setMunicipio(result.getInt("municipio"));
 this.setSector(result.getInt("sector"));
 this.setId_direccion(result.getInt("id_direccion"));
 this.setFechaEfectos(result.getDate("fecha_efecto"));
 this.setFechaPreparacions(result.getDate("fecha_preparacion"));
 this.setNumeroZonaEducativa(result.getString("numero_zona_educativa"));
 this.setTipoMovimiento(result.getString("tipo_movimiento"));
 this.setCargoAdicional(result.getString("cargo_adicional"));
 this.setId_cargo_propuesto(result.getInt("id_cargo_propuesto"));
 this.setId_cargo(result.getInt("id_cargo"));
 this.setNumero_cuenta(result.getString("numero_cuenta"));
 this.setCodigo(result.getString("codigo"));
 this.setTipo_cuenta(result.getString("tipo_cuenta"));
 this.setBanco(result.getString("nombre"));
 this.setRetroactivo(result.getString("retroactivo"));
 this.setEstado(result.getInt("municipio_ta"));
 this.setId_banco(result.getInt("id_banco"));
  
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
  
          public boolean editarEstatusTramite(String estatus,int id_tramite) {
    boolean retorno = false;
    conexion = new conexionBD();
    conexion.conectar();
    int insert = conexion.actualizar("UPDATE tramite_administrativo\n" +
"   SET  status='"+estatus+"'\n" +
" WHERE id_tramite = '"+id_tramite+"';");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }
          
          
 public boolean consultarTramiteExistente(int ced) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT * FROM tramite_administrativo WHERE cedula = '"+ced+"'");
 
 if (result != null) {
 result.next();
 
 
 
 retorno = true;
                     }
 else {
 retorno = false;
      }
 
 conexion.cerrar();
 return retorno;
                                                                       }
          
     
   public boolean consultarTramiteId(int id_tramite) throws SQLException { //Inicio metodo consultar
 boolean retorno = true;
 conexion = new conexionBD();
 conexion.conectar();
 ResultSet result = conexion.query("SELECT p.nombres,p.apellidos,p.cedula,p.estado,p.municipio,p.sector,p.direccion,p.tipo,p.estado_civil,\n" +
"p.fecha_nac,p.nacionalidad,dir.id_direccion,ta.fecha_efecto,ta.municipio as \"municipio_ta\",ta.fecha_preparacion,\n" +
"ta.numero_zona_educativa,ta.tipo_movimiento,ta.cargo_adicional,cp.id_cargo_propuesto,c.id_cargo,db.numero_cuenta,db.codigo,\n" +
"db.tipo_cuenta,b.nombre,db.retroactivo\n" +
"FROM personal as p\n" +
"INNER JOIN tramite_administrativo AS ta ON p.cedula = ta.cedula\n" +
"INNER JOIN cargo AS c ON p.cedula = c.cedula\n" +
"INNER JOIN cargo_propuesto AS cp ON p.cedula = cp.cedula\n" +
"INNER JOIN datos_bancarios AS db ON p.cedula = db.cedula\n" +
"INNER JOIN banco AS b ON db.id_banco = b.id_banco\n" +
"INNER JOIN estado AS e ON p.estado = e.id_estado\n" +
"INNER JOIN municipio AS m ON p.municipio = m.id_municipio\n" +
"INNER JOIN sector AS s ON p.sector = s.id_sector\n" +
"INNER JOIN direccion AS dir ON p.direccion = dir.id_direccion\n" +
"WHERE ta.id_tramite = '"+id_tramite+"'");
 
 if (result != null) {
 result.next();
 
 this.setNombres(result.getString("nombres"));
 this.setApellidos(result.getString("apellidos"));
 this.setTipo_personal(result.getString("tipo"));
 this.setEstado_civil(result.getString("estado_civil"));
 this.setNacionalidad(result.getString("nacionalidad"));
 this.setFecha_nac_salida(result.getDate("fecha_nac"));
 this.setEstado0(result.getInt("estado"));
 this.setMunicipio(result.getInt("municipio"));
 this.setSector(result.getInt("sector"));
 this.setId_direccion(result.getInt("id_direccion"));
 this.setFechaEfectos(result.getDate("fecha_efecto"));
 this.setFechaPreparacions(result.getDate("fecha_preparacion"));
 this.setNumeroZonaEducativa(result.getString("numero_zona_educativa"));
 this.setTipoMovimiento(result.getString("tipo_movimiento"));
 this.setCargoAdicional(result.getString("cargo_adicional"));
 this.setId_cargo_propuesto(result.getInt("id_cargo_propuesto"));
 this.setId_cargo(result.getInt("id_cargo"));
 this.setNumero_cuenta(result.getString("numero_cuenta"));
 this.setCodigo(result.getString("codigo"));
 this.setTipo_cuenta(result.getString("tipo_cuenta"));
 this.setBanco(result.getString("nombre"));
 this.setRetroactivo(result.getString("retroactivo"));
 this.setEstado(result.getInt("municipio_ta"));
 this.setCedula(result.getInt("cedula"));
 
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
    int insert = conexion.actualizar("DELETE FROM tramite_administrativo \n" +
"    \n" +
" WHERE cedula = '"+ced+"'");
    conexion.cerrar(); 
    if (insert != 0) {
    retorno = true;
                     }
    
    return retorno;
                                               }

}
