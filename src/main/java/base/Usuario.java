package base;

public class Usuario {

	public Usuario(int cod_Usuario, String email, String nombre, String apellidos, int telefono) {
		super();
		this.cod_Usuario = cod_Usuario;
		this.email = email;
		this.nombre = nombre;
		Apellidos = apellidos;
		this.telefono = telefono;
	}
	int cod_Usuario;
	String email;
	String nombre;
	String Apellidos;
	int telefono;
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
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
