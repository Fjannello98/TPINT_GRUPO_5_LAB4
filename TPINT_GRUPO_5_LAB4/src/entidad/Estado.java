package entidad;

public class Estado {
	
private int ID;
private String descripcion;


public Estado() {
	super();
	
}
public Estado(int iD, String descripci�n) {
	super();
	ID = iD;
	this.descripcion = descripci�n;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripci�n) {
	this.descripci�n = descripci�n;
}

@Override
public String toString() {
	return "Estado [ID=" + ID + ", descripcion=" + descripci�n + "]";
}

}
