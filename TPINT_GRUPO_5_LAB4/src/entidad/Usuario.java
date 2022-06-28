package entidad;

public class Usuario {
private int ID;
private String nombre_usuario;
private String contrasena;
private TiposUsuario tipo_usuario;




public Usuario() {
	super();
	// TODO Auto-generated constructor stub
}
public Usuario(int iD, String nombre_usuario, String contrasena, TiposUsuario tipo_usuario) {
	super();
	ID = iD;
	this.nombre_usuario = nombre_usuario;
	this.contrasena = contrasena;
	this.tipo_usuario = tipo_usuario;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getNombre_usuario() {
	return nombre_usuario;
}
public void setNombre_usuario(String nombre_usuario) {
	this.nombre_usuario = nombre_usuario;
}
public String getContrasena() {
	return contrasena;
}
public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}
public TiposUsuario getTipo_usuario() {
	return tipo_usuario;
}
public void setTipo_usuario(TiposUsuario tipo_usuario) {
	this.tipo_usuario = tipo_usuario;
}

@Override
public String toString() {
	return "Usuario [ID=" + ID + ", nombre_usuario=" + nombre_usuario + ", contrasena=" + contrasena + ", tipo_usuario="
			+ tipo_usuario.getDescripcion() + "]";
}

}
