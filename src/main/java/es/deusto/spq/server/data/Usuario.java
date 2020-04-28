package es.deusto.spq.server.data;


import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario {

	public Usuario(String email, String nombre, String apellidos, int telefono, String contrasenya, boolean gestor) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.contrasenya = contrasenya;
		this.gestor = gestor;
	}
	@PrimaryKey
	String email;
	
	String nombre;
	String apellidos;
	int telefono;
	String contrasenya;
	public boolean isGestor() {
		return gestor;
	}
	public void setGestor(boolean gestor) {
		this.gestor = gestor;
	}
	boolean gestor;
	public Usuario() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
