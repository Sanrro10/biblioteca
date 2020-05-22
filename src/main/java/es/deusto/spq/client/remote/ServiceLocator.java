package es.deusto.spq.client.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import es.deusto.spq.client.data.*;
import es.deusto.spq.client.resources.GetPropertyValues;


/**
 * Clase que hace de conexión entre el Controller y el RemoteFacade de la parte servidora.
 * @author isanr
 */
public class ServiceLocator {
	

	private Client client; 
	private WebTarget webTarget; 
	private static Logger logger = Logger.getLogger(ServiceLocator.class.getName());

	public ServiceLocator() { 
		client = ClientBuilder.newClient();
		webTarget = client.target(cogerUrl());
	}
//	public ServiceLocator(String hostname, String port) { 
//	client = ClientBuilder.newClient();
//	webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
//}
	/**
	  * Método para registrar usuario. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param email Email del usuario a registrar.
	  * @param nombre Nombre del usuario a registrar.
	  * @param apellidos Apellidos del usuario a registrar.
	  * @param telefono Telefonodel usuario a registrar.
	  * @param contrasenya Contrasenya del usuario a registrar.
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya) {
		WebTarget registerUserWebTarget = webTarget.path("server/registro");
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setTelefono(telefono);
		u.setContrasenya(contrasenya);
		u.setGestor(false);
		
		Entity<Usuario> entity = Entity.entity(u, MediaType.APPLICATION_JSON);
		Response response = registerUserWebTarget.request().post(entity);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
			return false;
		} else {
			logger.info("User correctly registered");
			return true;
		}
	}
	public static String cogerUrl(){
		GetPropertyValues properties = new GetPropertyValues();
		String url = "";
		
		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return url;
		
	}

	/**
	  * Método para iniciarSesion con un usuario. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param email Email del usuario con el que iniciar Sesión.
	  * @param contrasenya Contrasenya con el que iniciar Sesión.
	  * @return Un int que es 0 en caso de que haya habido error o el usuario sea incorrecto, 1 en caso de que no sea un gestor y 2 en caso de que lo sea
	  */
	public int iniciarSesion(String email, String contrasenya) {
		WebTarget webTarget1 = webTarget.path("server/inicioSesion");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);
		
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setContrasenya(contrasenya);

		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		 if (response.getStatus() == Status.OK.getStatusCode()) {
			return 1;
			
		}else if(response.getStatus() == Status.ACCEPTED.getStatusCode()){
			return 2;
		}return 0;
	}
	/**
	  * Método para insertar una reserva de una sala en la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param rsala ReservaSala a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public Response insertarReservaSala(ReservaSala rsala) {
		WebTarget webTarget1 = webTarget.path("server/insertarReservaSala");	
		Entity<ReservaSala> entity = Entity.entity(rsala, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}
	/**
	  * Método para insertar una solicitud en la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param solicitud Solicitud a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public Response insertarSolicitud(Solicitud solicitud) {
		WebTarget webTarget1 = webTarget.path("server/insertarSolicitud");	
		Entity<Solicitud> entity = Entity.entity(solicitud, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}
	/**
	  * Método para insertar una reserva de un libro en la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param rlibro ReservaLibro a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public Response insertarReservaLibro(ReservaLibro rlibro) {
		WebTarget webTarget1 = webTarget.path("server/insertarReservaLibro");	
		Entity<ReservaLibro> entity = Entity.entity(rlibro, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
		 
	}
	/**
	  * Método para insertar un libro en la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param libro Libro a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public Response insertarLibro(Libro libro) {
		WebTarget webTarget1 = webTarget.path("server/insertarLibro");	
		Entity<Libro> entity = Entity.entity(libro, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}

	/**
	  * Método para editar los datos de un usuario en la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @param user Usuario a editar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	public Response editarUsuario(Usuario user) {
		WebTarget webTarget1 = webTarget.path("server/editarUsuario");	
		Entity<Usuario> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}
	/**
	  * Método para obtener la lista de los usuarios de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de los usuarios de la BD
	  */
	public List<Usuario> cogerUsuarios() {
		WebTarget webTarget1 = webTarget.path("server/cogerUsuarios");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Usuario> list = new ArrayList<Usuario>();
		GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	/**
	  * Método para obtener la lista de las solicitudes de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de las solicitudes de la BD
	  */
	public List<Solicitud> cogerSolicitudes() {
		WebTarget webTarget1 = webTarget.path("server/cogerSolicitudes");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Solicitud> list = new ArrayList<Solicitud>();
		GenericType<List<Solicitud>> genericType = new GenericType<List<Solicitud>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	/**
	  * Método para obtener la lista de las reservas de las salas de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de las reservas de las salas de la BD
	  */
	public List<ReservaSala> cogerReservasSala() {
		WebTarget webTarget1 = webTarget.path("server/cogerReservasSala");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<ReservaSala> list = new ArrayList<ReservaSala>();
		GenericType<List<ReservaSala>> genericType = new GenericType<List<ReservaSala>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	/**
	  * Método para obtener la lista de las reservas de los libros de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de las reservas de los libros de la BD
	  */
	public List<ReservaLibro> cogerReservasLibro() {
		WebTarget webTarget1 = webTarget.path("server/cogerReservasLibro");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<ReservaLibro> list = new ArrayList<ReservaLibro>();
		GenericType<List<ReservaLibro>> genericType = new GenericType<List<ReservaLibro>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	/**
	  * Método para obtener la lista de las salas de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de las salas de la BD
	  */
	public List<SalaTrabajo> cogerSalas() {
		WebTarget webTarget1 = webTarget.path("server/cogerSalasTrabajo");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<SalaTrabajo> list = new ArrayList<SalaTrabajo>();
		GenericType<List<SalaTrabajo>> genericType = new GenericType<List<SalaTrabajo>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	/**
	  * Método para obtener la lista de los libros de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de los libros de la BD
	  */
	public List<Libro> cogerLibros() {
		WebTarget webTarget1 = webTarget.path("server/cogerLibros");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Libro> list = new ArrayList<Libro>();
		GenericType<List<Libro>> genericType = new GenericType<List<Libro>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	/**
	  * Método para obtener la lista de las actividades de la BD. 
	  * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	  *
	  * @return Lista de las actividades de la BD
	  */
	public List<Actividad> cogerActividades(){
		WebTarget webTarget1 = webTarget.path("server/cogerActividades");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Actividad> list = new ArrayList<Actividad>();
		GenericType<List<Actividad>> genericType = new GenericType<List<Actividad>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	
	
}