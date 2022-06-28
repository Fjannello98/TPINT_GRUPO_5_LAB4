package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import datos.Dao;
import entidad.TiposUsuario;

public class TiposUsuarioDao implements Dao {
	public TiposUsuarioDao () {
		
	}
	public static TiposUsuario buscarTipoUsuario(int id) {
		TiposUsuario tipoUsuario = new TiposUsuario();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(String.format("Select ID, DESCRIPCION FROM TiposUsuario where ID= %d", id));
			if (rs.next()) {	
				 tipoUsuario.setID(rs.getInt("ID"));
				 tipoUsuario.setDescripcion(rs.getString("DESCRIPCION"));
			}
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return tipoUsuario;
	}
}
