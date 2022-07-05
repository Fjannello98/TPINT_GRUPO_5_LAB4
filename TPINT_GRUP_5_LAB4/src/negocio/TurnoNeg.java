package negocio;

import java.util.ArrayList;


import entidad.Turno;

public interface TurnoNeg {

	public ArrayList<Turno> listarTurnos();
	public Turno obtenerUno(int id);
	public boolean insertar(Turno turno);
	public boolean editar(Turno turno);
	public boolean agregarObservacion(Turno turno);
	public boolean cambiarEstadoAusente(int id);
	public boolean cambiarEstadoLibre(int id);
	public boolean cambiarEstadoOcupado(int id);
	public boolean cambiarEstadoPresente(int id);
}
