package es.deusto.spq.client.base;

public class Usuario {

	public Usuario(int cod_Usuario, String email, String nombre, String apellidos, int telefono, String contrasenya, int cantReservas) {
		super();
		this.cod_Usuario = cod_Usuario;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.contrasenya = contrasenya;
		this.cantReservas = cantReservas;
	}
	int cod_Usuario;
	String email;
	String nombre;
	String apellidos;
	int telefono;
	String contrasenya;
	static int cantReservas;
	public Usuario() {
		
	}
	public int getCod_Usuario() {
		return cod_Usuario;
	}
	public void setCod_Usuario(int cod_Usuario) {
		this.cod_Usuario = cod_Usuario;
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
	public static int getCantReservas() {
		return cantReservas;
	}
	public void setCantReservas(int cantReservas) {
		this.telefono = 0;
	}
}
