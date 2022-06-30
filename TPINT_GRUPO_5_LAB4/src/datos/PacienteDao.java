package datos;
import java.util.ArrayList;
import entidad.Paciente;

public interface PacienteDao{

	public ArrayList<Paciente> obtenerTodos();
	public Paciente obtenerUno(String dni);
	public boolean insertar(Paciente paciente);
	public boolean editar(Paciente paciente);
	public boolean borrar(String dni);
	
	
}
