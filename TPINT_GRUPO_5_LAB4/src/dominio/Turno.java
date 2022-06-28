package dominio;

public class Turno {
	private Paciente DNI_paciente;
	private Medico DNI_medico;
	private int ID_estado;
	
	
	public Turno() {
		
	}
	
	public void Paciente(Paciente DNI_paciente, Medico DNI_medico, int ID_estado) {
		super();
		this.DNI_paciente = DNI_paciente;
		this.DNI_medico = DNI_medico;
		this.ID_estado = ID_estado;
		
	}
	
	@Override
	public String toString() {
		return "Paciente [DNI del medico=" + DNI_medico + ", DNI del paciente=" + DNI_paciente + ", Estado del turno=" + ID_estado + "]";
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
	public int getID_estado() {
		return ID_estado;
	}
	public void setID_estado(int ID_estado) {
		this.ID_estado = ID_estado;
	}
	
}


