package entidad;

import java.util.Date;

public class Medico extends Persona {
	private Especialidad ID_especialidad;
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(String dni, String nombre, String apellido, String sexo, String nacionalidad, Date fechaNac,
			String direccion, String localidad, String provincia, String telefono, String celular, String correo,
<<<<<<< HEAD
			int estado) {
=======
			Especialidad id_especialidad ,boolean estado) {
>>>>>>> aa73edb4fac06b7cf7d09c9eed4a2d8d81fc92da
		super(dni, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, telefono, celular, correo,
				estado);
		// TODO Auto-generated constructor stub
	}
	
	public Especialidad getID_especialidad() {
		return ID_especialidad;
	}

	public void setID_especialidad(Especialidad iD_especialidad) {
		ID_especialidad = iD_especialidad;
	}
	@Override
	public String toString() {
		return "Medico: " + super.toString() ;
	}

	
	
	
}
