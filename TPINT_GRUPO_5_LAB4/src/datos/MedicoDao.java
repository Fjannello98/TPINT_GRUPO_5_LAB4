package datos;
import java.util.List;
import entidad.Medico;

public interface MedicoDao{

	public List<Medico> obtenerTodos();
	public Medico obtenerUno(String dni);
	public boolean insertar(Medico medico);
	public boolean editar(Medico medico);
	public boolean borrar(String dni);
	
	
}
