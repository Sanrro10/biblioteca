package com.example;

public class Gestor extends Usuario {

	int cod_Usuario;
	String email;
	String nombre;
	String Apellidos;
	int telefono;
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
	public Gestor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gestor(int cod_Usuario, String email, String nombre, String apellidos, int telefono) {
		super(cod_Usuario, email, nombre, apellidos, telefono);
		// TODO Auto-generated constructor stub
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
