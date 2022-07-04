package entidad;

import java.util.Date;

public class Medico extends Persona {

	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(String dni, String nombre, String apellido, String sexo, String nacionalidad, Date fechaNac,
			String direccion, String localidad, String provincia, String telefono, String celular, String correo,
			boolean estado) {
		super(dni, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, telefono, celular, correo,
				estado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Medico: " + super.toString() ;
	}

	
	
	
}
