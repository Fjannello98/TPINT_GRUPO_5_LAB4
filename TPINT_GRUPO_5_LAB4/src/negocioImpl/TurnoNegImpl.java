package negocioImpl;


import java.util.ArrayList;


import datos.TurnoDao;
import datosImpl.TurnoDaoImpl;
import entidad.Turno;
import negocio.TurnoNeg;


public class TurnoNegImpl implements TurnoNeg {
	
	private TurnoDao turnoDao = new TurnoDaoImpl();
	
	public TurnoNegImpl(TurnoDao turnoDao)
	{
		this.turnoDao = turnoDao;
	}
	
	public TurnoNegImpl()
	{
	}
	
	
	@Override
	public ArrayList<Turno> listarTurnos() {
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
