package es.deusto.spq.server.data.dto;

import java.io.Serializable;
import java.util.ArrayList;


public class GestorDTO implements Serializable{
		
	private String email;
	private String nombre;
	private String apellidos;
	private int telefono;
	
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
		
		


	
}
