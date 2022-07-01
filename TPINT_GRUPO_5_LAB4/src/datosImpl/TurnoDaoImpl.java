package datosImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datos.TurnoDao;
import entidad.Turno;

public class TurnoDaoImpl implements TurnoDao {
	
	private Conexion cn;

	public TurnoDaoImpl()
	{
		
	}

	@Override
	public List<Turno> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Turno obtenerUno(String dnimedico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(Turno turno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(Turno turno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(String dnimedico) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
