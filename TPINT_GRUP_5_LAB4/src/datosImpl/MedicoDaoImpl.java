package datosImpl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import datos.MedicoDao;
import entidad.Especialidad;
import entidad.Medico;

public class MedicoDaoImpl implements MedicoDao{
	
	private Conexion cn;

	public MedicoDaoImpl()
	{
		
	}
	
	
	@Override
	public List<Medico> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Medico> list = new ArrayList<Medico>();
		 try
		 {
			 ResultSet rs= cn.query("Select dni, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, telefono, celular, correo,e.descripcion, estado from Medicos inner join Especialidades as e on id_especialidad=e.ID");
			 while(rs.next())
			 {
				 Medico medico = new Medico();
				 medico.setDni(rs.getString("dni"));
				 medico.setNombre(rs.getString("nombre"));
				 medico.setApellido(rs.getString("apellido"));
				 medico.setSexo(rs.getString("sexo"));
				 medico.setNacionalidad(rs.getString("nacionalidad"));
				 medico.setFechaNac(rs.getDate("fechaNac"));
				 medico.setDireccion(rs.getString("direccion"));
				 medico.setLocalidad(rs.getString("localidad"));
				 medico.setProvincia(rs.getString("provincia"));
				 medico.setTelefono(rs.getString("telefono"));
				 medico.setCelular(rs.getString("celular"));
				 medico.setCorreo(rs.getString("correo"));
				 medico.setEstado(rs.getBoolean("estado"));
				 
				 Especialidad esp = new Especialidad();
				 esp.setDescripción(rs.getString("e.descripcion"));
		 
				 medico.setID_especialidad(esp);	
				 list.add(medico);
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
	public Medico obtenerUno(String dni) {
		cn = new Conexion();
		cn.Open();
		Medico medico = new Medico();
		try
		 {
			 ResultSet rs= cn.query("Select dni, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, telefono, celular, correo, estado from Medicos where dni = " + dni);
			 rs.next();
			 
			 medico.setDni(rs.getString("dni"));
			 medico.setNombre(rs.getString("nombre"));
			 medico.setApellido(rs.getString("apellido"));
			 medico.setSexo(rs.getString("sexo"));
			 medico.setNacionalidad(rs.getString("nacionalidad"));
			 medico.setFechaNac(rs.getDate("fechaNac"));
			 medico.setDireccion(rs.getString("direccion"));
			 medico.setLocalidad(rs.getString("localidad"));
			 medico.setProvincia(rs.getString("provincia"));
			 medico.setTelefono(rs.getString("telefono"));
			 medico.setCelular(rs.getString("celular"));
			 medico.setCorreo(rs.getString("correo"));
			 medico.setEstado(rs.getBoolean("estado"));
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return medico;
	}

	@Override
	public boolean insertar(Medico medico) {
		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "INSERT INTO Medicos (dni, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, telefono, celular, correo, estado) VALUES ('"+medico.getDni()+"','"+medico.getNombre()+"','"+medico.getApellido()+"', '"+medico.getSexo()+"', '"+medico.getNacionalidad()+"', '"+medico.getFechaNac()+"', '"+medico.getDireccion()+"', '"+medico.getLocalidad()+"', '"+medico.getProvincia()+"', '"+medico.getTelefono()+"', '"+medico.getCelular()+"', '"+medico.getCorreo()+"', '"+medico.isEstado()+"')";
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
	public boolean editar(Medico medico) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "UPDATE Medicos SET dni='"+medico.getDni()+"', nombre='"+medico.getNombre()+"', apellido='"+medico.getApellido()+"', sexo = '"+medico.getSexo()+"', nacionalidad = '"+medico.getNacionalidad()+"', fechaNac='"+medico.getFechaNac()+"', direccion='"+medico.getDireccion()+"', localidad = '"+medico.getLocalidad()+"', provincia = '"+medico.getProvincia()+"', telefono='"+medico.getTelefono()+"', celular = '"+medico.getCelular()+"', correo='"+medico.getCorreo()+"', estado = '"+medico.isEstado()+"' WHERE dni='"+medico.getDni()+"'";
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
	public boolean borrar(String dni) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "UPDATE Medicos SET estado=0 WHERE dni="+dni;
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
