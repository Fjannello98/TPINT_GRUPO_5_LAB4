package entidad;

public class Turno {
	private Paciente DNI_paciente;
	private Medico DNI_medico;
	private Estado ID_estado;
	
	
	public Turno() {
		
	}
	
	public Turno(Paciente DNI_paciente, Medico DNI_medico, int ID_estado) {
		super();
		this.DNI_paciente = DNI_paciente;
		this.DNI_medico = DNI_medico;
		this.ID_estado = ID_estado;
		
	}
	
	@Override
	public String toString() {
		return "Paciente [DNI del medico=" + DNI_medico.getDni() + ", DNI del paciente=" + DNI_paciente.getDni() + ", Estado del turno=" + ID_estado.getDescripción() + "]";
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


