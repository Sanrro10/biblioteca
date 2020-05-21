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
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.client.data.*;
import es.deusto.spq.client.remote.ServiceLocator;

/**
 * Clase que hace de conexión entre el Servicelocator y las GUI.
 * @author isanr
 */

public class Controller {
	
	
	public ServiceLocator serviceLocator;

	/**
	  * Constructor de la clase Controller.
	  *
	  * @param serviceLocator El Servicelocator con el que se conectará.

	  */
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	/**
	  * Método para registrar usuario. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param email Email del usuario a registrar.
	  * @param nombre Nombre del usuario a registrar.
	  * @param apellidos Apellidos del usuario a registrar.
	  * @param telefono Telefonodel usuario a registrar.
	  * @param contrasenya Contrasenya del usuario a registrar.
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya){
		return serviceLocator.registrarUsuario(email, nombre, apellidos, telefono, contrasenya);
	}
	/**
	  * Método para iniciarSesion con un usuario. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param email Email del usuario con el que iniciar Sesión.
	  * @param contrasenya Contrasenya con el que iniciar Sesión.
	  * @return Un int que es 0 en caso de que haya habido error o el usuario sea incorrecto, 1 en caso de que no sea un gestor y 2 en caso de que lo sea
	  */
	public int iniciarSesion(String email, String contrasenya){
		return serviceLocator.iniciarSesion(email, contrasenya);
	}
	/**
	  * Método para insertar una reserva de una sala en la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param rsala ReservaSala a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean insertarReservaSala(ReservaSala rsala) {
		if(serviceLocator.insertarReservaSala(rsala).getStatus() == Status.OK.getStatusCode()) {
			return true;
		}
		return false;
	}
	/**
	  * Método para insertar una solicitud en la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param solicitud Solicitud a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean insertarSolicitud(Solicitud solicitud) {
		if(serviceLocator.insertarSolicitud(solicitud).getStatus() == Status.OK.getStatusCode()) {
			return true;
		}
		return false;
	}
	/**
	  * Método para insertar una reserva de un libro en la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param rlibro ReservaLibro a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean insertarReservaLibro(ReservaLibro rlibro) {
		if(serviceLocator.insertarReservaLibro(rlibro).getStatus() == Status.OK.getStatusCode()) {
			return true;
		}
		return false;
	}
	/**
	  * Método para insertar un libro en la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param libro Libro a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean insertarLibro(Libro libro) {
		if(serviceLocator.insertarLibro(libro).getStatus() == Status.OK.getStatusCode()) {
			return true;
		}
		return false;
	}
	/**
	  * Método para editar los datos de un usuario en la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @param user Usuario a editar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean editarUsuario(Usuario user) {
		if(serviceLocator.editarUsuario(user).getStatus() == Status.OK.getStatusCode()) {
			return true;
		}
		return false;
	}
	/**
	  * Método para obtener la lista de los usuarios de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de los usuarios de la BD
	  */
	public List<Usuario> cogerUsuarios() {
		return serviceLocator.cogerUsuarios();
	}
	/**
	  * Método para obtener la lista de las solicitudes de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de las solicitudes de la BD
	  */
	public List<Solicitud> cogerSolicitudes(){
		return serviceLocator.cogerSolicitudes();
	}
	/**
	  * Método para obtener la lista de las reservas de las salas de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de las reservas de las salas de la BD
	  */
	public List<ReservaSala> cogerReservasSala() {
		return serviceLocator.cogerReservasSala();
	}
	/**
	  * Método para obtener la lista de las reservas de los libros de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de las reservas de los libros de la BD
	  */
	public List<ReservaLibro> cogerReservasLibro() {
		return serviceLocator.cogerReservasLibro();
	}
	/**
	  * Método para obtener la lista de las salas de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de las salas de la BD
	  */
	public List<SalaTrabajo> cogerSalas() {
		return serviceLocator.cogerSalas();
	}
	/**
	  * Método para obtener la lista de los libros de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de los libros de la BD
	  */
	public List<Libro> cogerLibros() {
		return serviceLocator.cogerLibros();
	}
	/**
	  * Método para obtener la lista de las actividades de la BD. 
	  * Llama al método con el mismo nombre del ServiceLocator.
	  *
	  * @return Lista de las actividades de la BD
	  */
	public List<Actividad> cogerActividades(){
		return serviceLocator.cogerActividades();
	}




		
		

}
