package datos;
import java.util.List;
import entidad.Turno;

import java.util.List;

public interface TurnoDao {
	public List<Turno> obtenerTodos();
	public List<Turno> obtenerPorDniMedico(String dniMedico);
	public Turno obtenerUno(int id);
	public boolean insertar(Turno turno);
	public boolean editar(Turno turno);
	public boolean agregarObservacion(Turno turno);
	public boolean cambiarEstadoAusente(int id);
	public boolean cambiarEstadoLibre(int id);
	public boolean cambiarEstadoOcupado(int id);
	public boolean cambiarEstadoPresente(int id);
	

}
