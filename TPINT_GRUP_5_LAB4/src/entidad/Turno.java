package entidad;

/*import java.sql.Time;
import java.sql.Date;*/

public class Turno {
	private int id;
	private Paciente DNI_paciente;
	private Medico DNI_medico;
	private Estado ID_estado;
	private Especialidad ID_especialidad;
	private String observacion;
	//private  Date fecha;
	//private DateTime hora;
	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Especialidad getID_especialidad() {
		return ID_especialidad;
	}

	public void setID_especialidad(Especialidad iD_especialidad) {
		ID_especialidad = iD_especialidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public DateTime getHora() {
		return hora;
	}

	public void setHora(DateTime hora) {
		this.hora = hora;
	}*/
	
	
	
	public Turno() {
		
	}
	
	public Turno(int id, Paciente DNI_paciente, Medico DNI_medico, Estado ID_estado, Especialidad ID_especialidad, String observacion/*, Date fecha, DateTime hora*/) {
		super();
		this.id = id;
		this.DNI_paciente = DNI_paciente;
		this.DNI_medico = DNI_medico;
		this.ID_estado = ID_estado;
		this.ID_especialidad = ID_especialidad;
		this.observacion = observacion;
		/*this.fecha = fecha;
		this.hora = hora;*/
		
	}
	
	@Override
	public String toString() {
		return "Paciente [DNI del medico=" + DNI_medico.getDni() + ", DNI del paciente=" + DNI_paciente.getDni() + ", Estado del turno=" + ID_estado.getDescripcion() + "]";
	}
	
	public Paciente getDNI_paciente() {
		return DNI_paciente;
	}
	public void setDNI_paciente(Paciente DNI_paciente) {
		this.DNI_paciente = DNI_paciente;
	}
	public Medico getDNI_medico() {
		return DNI_medico;
	}
	public void setDNI_medico(Medico DNI_medico) {
		this.DNI_medico = DNI_medico;
	}
	public Estado getID_estado() {
		return ID_estado;
	}
	public void setID_estado(Estado ID_estado) {
		this.ID_estado = ID_estado;
	}
	
}


