package datosImpl;

import java.sql.ResultSet;
import java.util.List;

import datos.TiposUsuariosDao;
import entidad.TiposUsuario;

public class TiposUsuarioImpl  implements TiposUsuariosDao {
	private Conexion cn;


	@Override
	public List<TiposUsuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiposUsuario obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		TiposUsuario tipoUsuario = new TiposUsuario();
		try
		 {
			 ResultSet rs= cn.query("Select ID, DESCRIPCION FROM TiposUsuario where ID="+ id);
			 rs.next();
			 
			 tipoUsuario.setID(rs.getInt("ID"));
			 tipoUsuario.setDescripcion(rs.getString("DESCRIPCION"));
			 
			 
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return tipoUsuario;
	}

	@Override
	public boolean insertar(TiposUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(TiposUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
