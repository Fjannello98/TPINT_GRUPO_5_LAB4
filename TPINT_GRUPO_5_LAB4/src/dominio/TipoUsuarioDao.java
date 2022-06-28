package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TipoUsuarioDao implements Dao {
	public TipoUsuarioDao () {
		
	}
	public static TipoUsuario buscarTipoUsuario(int id) {
		TipoUsuario tipoUsuario = new TipoUsuario();
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
			
			ResultSet rs = st.executeQuery("Select ID, DESCRIPCION FROM TiposUsuario");
			if (rs.next()) {	
				 tipoUsuario.setId(rs.getInt("ID"));
				 tipoUsuario.setDescripcion(rs.getString("DESCRIPCION"));
			}
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return tipoUsuario;
	}
}
