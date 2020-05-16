package es.deusto.spq.server.data.dto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.PrimaryKey;

/**
 * Clase UsuarioDTO en el Servidor.
 * Equivalente a Usuario en Cliente.
 * Como se utiliza en el intercambio de información entre el lado servidor y el cliente, implementa serializable
 *@author isanr kevin31000
 */
public class UsuarioDTO implements Serializable{
		

	private static final long serialVersionUID = 1L;
	
	public UsuarioDTO(String email, String nombre, String apellidos, int telefono, String contrasenya, boolean gestor) {
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
	public UsuarioDTO() {
		
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
