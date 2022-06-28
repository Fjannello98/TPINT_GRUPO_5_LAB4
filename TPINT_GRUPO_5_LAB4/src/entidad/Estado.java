package entidad;

public class Estado {
	
private int ID;
private String descripcion;


public Estado() {
	super();
	
}
public Estado(int iD, String descripción) {
	super();
	ID = iD;
	this.descripcion = descripción;
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
public void setDescripcion(String descripción) {
	this.descripción = descripción;
}

@Override
public String toString() {
	return "Estado [ID=" + ID + ", descripcion=" + descripción + "]";
}

}
