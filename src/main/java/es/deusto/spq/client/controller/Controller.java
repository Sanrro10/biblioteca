package es.deusto.spq.client.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.client.data.*;
import es.deusto.spq.client.remote.ServiceLocator;


public class Controller {
	
	
	public ServiceLocator serviceLocator;

	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya){
		return serviceLocator.registrarUsuario(email, nombre, apellidos, telefono, contrasenya);
	}
	public int iniciarSesion(String email, String contrasenya){
		return serviceLocator.iniciarSesion(email, contrasenya);
	}

	
	public boolean insertarReservaSala(ReservaSala rsala) {
		if(serviceLocator.insertarReservaSala(rsala).equals(Response.ok().build())) {
			return true;
		}
		return false;
	}
	public boolean insertarSolicitud(Solicitud rsala) {
		if(serviceLocator.insertarSolicitud(rsala).equals(Response.ok().build())) {
			return true;
		}
		return false;
	}
	public boolean insertarReservaLibro(ReservaLibro rsala) {
		if(serviceLocator.insertarReservaLibro(rsala).equals(Response.ok().build())) {
			return true;
		}
		return false;
	}
	public boolean insertarLibro(Libro rsala) {
		if(serviceLocator.insertarLibro(rsala).equals(Response.ok().build())) {
			return true;
		}
		return false;
	}
	public List<Usuario> cogerUsuarios() {
		return serviceLocator.cogerUsuarios();
	}
	public List<Solicitud> cogerSolicitudes(){
		return serviceLocator.cogerSolicitudes();
	}
	public List<ReservaSala> cogerReservasSala() {
		return serviceLocator.cogerReservasSala();
	}
	public List<ReservaLibro> cogerReservasLibro() {
		return serviceLocator.cogerReservasLibro();
	}
	public List<SalaTrabajo> cogerSalas() {
		return serviceLocator.cogerSalas();
	}
	public List<Libro> cogerLibros() {
		return serviceLocator.cogerLibros();
	}
	public List<Actividad> cogerActividades(){
		return serviceLocator.cogerActividades();
	}




		
		

}
