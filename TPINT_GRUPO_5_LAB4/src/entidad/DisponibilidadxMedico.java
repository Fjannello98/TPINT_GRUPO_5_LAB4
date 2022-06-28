package entidad;

import java.sql.Time;

public class DisponibilidadxMedico {

	private int ID;
	private Medico DNI_medico;
	private String dia;
	private Time horario_inicio;
	private Time horario_fin;
	

	
	public DisponibilidadxMedico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DisponibilidadxMedico(int iD, Medico dNI_medico, String dia, Time horario_inicio, Time horario_fin) {
		super();
		ID = iD;
		DNI_medico = dNI_medico;
		this.dia = dia;
		this.horario_inicio = horario_inicio;
		this.horario_fin = horario_fin;
	}
	@Override
	public String toString() {
		return "DisponibilidadxMedico [ID=" + ID + ", DNI_medico=" + DNI_medico.getDni() + ", dia=" + dia + ", horario_inicio="
				+ horario_inicio.getTime() + ", horario_fin=" + horario_fin.getTime() + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Medico getDNI_medico() {
		return DNI_medico;
	}
	public void setDNI_medico(Medico dNI_medico) {
		DNI_medico = dNI_medico;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Time getHorario_inicio() {
		return horario_inicio;
	}
	public void setHorario_inicio(Time horario_inicio) {
		this.horario_inicio = horario_inicio;
	}
	public Time getHorario_fin() {
		return horario_fin;
	}
	public void setHorario_fin(Time horario_fin) {
		this.horario_fin = horario_fin;
	}
	
	
	
	
}
