package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import datos.TurnoDao;
import entidad.Turno;
import entidad.Estado;
import entidad.Medico;
import entidad.Paciente;
import entidad.Especialidad;
/*import java.sql.Time;
import java.sql.Date;*/

public class TurnoDaoImpl implements TurnoDao{
	
	private Conexion cn;

	public TurnoDaoImpl()
	{
		
	}
	
	
	@Override
	public List<Turno> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Turno> list = new ArrayList<Turno>();
		 try
		 {
			 ResultSet rs= cn.query("Select T.id, T.dni_paciente, P.nombre, P.apellido, T.dni_medico, M.nombre, M.apellido, T.id_estado, E.descripcion, T.ID_especialidad, ES.descripcion, T.fecha, T.hora, T.observacion from Turnos T, Pacientes P, Medicos M, Estados E, Especialidades ES WHERE T.dni_paciente = P.dni AND T.dni_medico = M.dni AND T.id_estado = E.ID AND ES.ID = T.ID_Especialidad");
			 while(rs.next())
			 {
				 Turno turno = new Turno();
				 turno.setId(rs.getInt("T.id"));			 
				 turno.setFecha(rs.getDate("T.fecha"));
				 turno.setHora(rs.getTime("T.hora"));
				 
				 Paciente paciente = new Paciente();
				 paciente.setDni(rs.getString("T.dni_paciente"));
				 paciente.setNombre(rs.getString("P.nombre"));
				 paciente.setApellido(rs.getString("P.apellido"));
				 
				 Medico medico = new Medico();
				 medico.setDni(rs.getString("T.dni_medico"));
				 medico.setNombre(rs.getString("M.nombre"));
				 medico.setApellido(rs.getString("M.apellido"));
				 
				 Estado estado = new Estado();
				 estado.setID(rs.getInt("T.id_estado"));
				 estado.setDescripcion(rs.getString("E.descripcion"));
				 
				 Especialidad especialidad = new Especialidad();
				 especialidad.setID(rs.getInt("T.ID_especialidad"));
				 especialidad.setDescripción(rs.getString("ES.descripcion"));
				 
				 turno.setObservacion(rs.getString("T.observacion"));
				 
				 
				 turno.setDNI_paciente(paciente);
				 turno.setDNI_medico(medico);
				 turno.setID_estado(estado);
				 turno.setID_especialidad(especialidad);
				 
	 
				 				 			 	
				 list.add(turno);
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}

	@Override
	public Turno obtenerUno(int id) {
		cn = new Conexion();
		cn.Open();
		Turno turno = new Turno();
		try
		 {
			ResultSet rs= cn.query("Select T.id, T.dni_paciente, P.nombre, P.apellido, T.dni_medico, M.nombre, M.apellido, T.id_estado, E.descripcion, T.ID_especialidad, ES.descripcion, T.fecha, T.hora, T.observacion from Turnos T, Pacientes P, Medicos M, Estados E, Especialidades ES WHERE T.dni_paciente = P.dni AND T.dni_medico = M.dni AND T.id_estado = E.ID AND ES.ID = T.ID_Especialidad AND T.id = "+id);
			 rs.next();
			 		
			 turno.setId(rs.getInt("T.id"));			 
			 //turno.setFecha(rs.getDate("T.fecha"));
			 //turno.setHora(rs.getDateTime("T.hora"));
			 
			 Paciente paciente = new Paciente();
			 paciente.setDni(rs.getString("T.dni_paciente"));
			 paciente.setNombre(rs.getString("P.nombre"));
			 paciente.setApellido(rs.getString("P.apellido"));
			 
			 Medico medico = new Medico();
			 medico.setDni(rs.getString("T.dni_medico"));
			 medico.setNombre(rs.getString("M.nombre"));
			 medico.setApellido(rs.getString("M.apellido"));
			 
			 Estado estado = new Estado();
			 estado.setID(rs.getInt("T.id_estado"));
			 estado.setDescripcion(rs.getString("E.descripcion"));
			 
			 Especialidad especialidad = new Especialidad();
			 especialidad.setID(rs.getInt("T.ID_especialidad"));
			 especialidad.setDescripción(rs.getString("ES.descripcion"));
			 
			 turno.setObservacion(rs.getString("T.observacion"));
			 
			 
			 turno.setDNI_paciente(paciente);
			 turno.setDNI_medico(medico);
			 turno.setID_estado(estado);
			 turno.setID_especialidad(especialidad);
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return turno;
	}

	@Override
	public boolean insertar(Turno turno) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO TURNOS (dni_paciente, dni_medico, id_estado, id_especialidad, fecha, hora) VALUES ('"+turno.getDNI_paciente()+"','"+turno.getDNI_medico()+"','"+turno.getID_estado()+"', '"+turno.getID_especialidad()+"', '2022-07-04', '2022-07-04 11:45:30')";
		System.out.println(query);
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	@Override
	public boolean editar(Turno turno) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE TURNOS SET dni_paciente = '"+turno.getDNI_paciente()+"' , dni_medico = '"+turno.getDNI_medico()+"' , id_estado = '"+turno.getID_estado()+"' , id_especialidad = '"+turno.getID_especialidad()+"', fecha = '2022-07-04', hora = '2022-07-04 11:45:30', observacion = '"+turno.getObservacion()+"' WHERE id='"+turno.getId()+"'";
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	
	
	public boolean agregarObservacion(Turno turno) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE TURNOS SET observacion = '"+turno.getObservacion()+"' WHERE id='"+turno.getId()+"'";
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	
	//METODO ESTADO LIBRE
	public boolean cambiarEstadoLibre(int id){
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE TURNOS SET id_estado = 1 WHERE id="+id;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	

	//METODO ESTADO OCUPADO
	public boolean cambiarEstadoOcupado(int id){
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE TURNOS SET id_estado = 2 WHERE id="+id;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	

	//METODO ESTADO AUSENTE
	public boolean cambiarEstadoAusente(int id){
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE TURNOS SET id_estado = 3 WHERE id="+id;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	

	//METODO ESTADO PRESENTE
	public boolean cambiarEstadoPresente(int id){
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE TURNOS SET id_estado = 4 WHERE id="+id;
		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	
	
	
	
	
}