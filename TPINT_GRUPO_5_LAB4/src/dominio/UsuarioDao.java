package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dominio.Usuario;

public class UsuarioDao implements Dao {
	
	public UsuarioDao(){
		
	}
	public Usuario buscarUsuario(String nombreUsuario) {
		Usuario usuario = new Usuario();
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
			
			ResultSet rs = st.executeQuery(String.format("Select ID, Contrasena, Nombre_Usuario, Tipo_Usuario FROM Usuarios where Nombre_usuario = '%s'", nombreUsuario));
			if (rs.next()) {	
				 usuario.setContrasena(rs.getString("Contrasena"));
				 usuario.setId(rs.getInt("ID"));
				 usuario.setNombre_usuario(rs.getString("Nombre_Usuario"));
				 usuario.setTipo_usuario(TipoUsuarioDao.buscarTipoUsuario(rs.getInt("Tipo_Usuario")));
			}
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return usuario;
	}
}