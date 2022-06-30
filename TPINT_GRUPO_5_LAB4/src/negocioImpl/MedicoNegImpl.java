package negocioImpl;

import java.util.ArrayList;

import datos.MedicoDao;
import datosImpl.MedicoDaoImpl;
import entidad.Medico;
import negocio.MedicoNeg;

public class MedicoNegImpl implements MedicoNeg{

	private MedicoDao medicoDao = new MedicoDaoImpl();
	
	//Se puede recibir por constructor
	public MedicoNegImpl(MedicoDao medicoDao)
	{
		this.medicoDao = medicoDao;
	}
	
	public MedicoNegImpl()
	{
	}
	
	@Override
	public ArrayList<Medico> listarMedicos() {
		return (ArrayList<Medico>) medicoDao.obtenerTodos();
	}

	@Override
	public Medico obtenerUno(String dni) {
		return medicoDao.obtenerUno(dni);
	}

	@Override
	public boolean insertar(Medico medico) {
		return medicoDao.insertar(medico);
	}

	@Override
	public boolean editar(Medico medico) {
		return medicoDao.editar(medico);
	}

	@Override
	public boolean borrar(String dni) {
		
		return medicoDao.borrar(dni);
	}

	
	
}