package datos;



import java.util.List;

import entidad.Turno;

public interface TurnoDao {
	public List<Turno> obtenerTodos();
	public Turno obtenerUno(String dnimedico);
	public boolean insertar(Turno turno);
	public boolean editar(Turno turno);
	public boolean borrar(String dnimedico);

}
