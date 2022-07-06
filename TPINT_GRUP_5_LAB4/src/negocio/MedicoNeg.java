package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.Medico;
import entidad.Paciente;

public interface MedicoNeg {

	public ArrayList<Medico> listarMedicos();
	public Medico obtenerUno(String dni);
	public boolean insertar(Medico medico);
	public boolean editar(Medico medico);
	public boolean borrar(String dni);
	
	public List<Medico> obtenerBusqueda(String parametro);
}
