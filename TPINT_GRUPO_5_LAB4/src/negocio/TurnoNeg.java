package negocio;

import java.util.ArrayList;
import entidad.Turno;

public interface TurnoNeg {
	public ArrayList<Turno> listarTurnos();
	public Turno obtenerUno(String dnimedico);
	public boolean insertar(Turno turno);
	public boolean editar(Turno turno);
	public boolean borrar(String dnimedico);

}
