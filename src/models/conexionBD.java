package models;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.URL;
import javax.swing.JOptionPane;

public class conexionBD {
	private Statement stmt;
	private String clave;
	private String usuario;
	private String driver;
	private String driverUrl;
	protected Connection con = null;

	public conexionBD() 
	{
		Ini1();
	}
	public void Ini1()
	{
		this.driver = "org.postgresql.Driver";
		this.driverUrl = "jdbc:postgresql://localhost/zonaeducativa";
		this.usuario = "postgres";
		this.clave = "123456";
	}
	

	public boolean conectar(){
	Boolean con_status = true;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(driverUrl, usuario, clave);
		} catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, e, "Error en la Conexión con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			con_status = false;
		} catch (SQLException e) {
			e.printStackTrace();
			con_status = false;
		}
		return con_status;
	}
        
        	public Connection conectar2(){
	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(driverUrl, usuario, clave);
		} catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, e, "Error en la Conexión con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return con;
	}
        
	public int actualizar(String sql) {
		Statement sen;
		int a;
		try {
			sen = con.createStatement();
			a = sen.executeUpdate(sql);
                        
			return a;
                        
		} 
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		return 0;
		}
	};
	public ResultSet query(String sql) {
		Statement sen;
		ResultSet rs;
		try { 
		    sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = sen.executeQuery(sql);
			if (rs.next()) {
				rs.beforeFirst();
				return rs;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void cerrar() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}
	public void setConnectString(String driverUrl) {
		this.driverUrl = driverUrl;
	}
}