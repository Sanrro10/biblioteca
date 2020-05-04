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
import es.deusto.spq.server.data.dto.ActividadDTO;



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
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya) {
		WebTarget registerUserWebTarget = webTarget.path("server/registro");
		System.out.println(registerUserWebTarget);
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setTelefono(telefono);
		u.setContrasenya(contrasenya);
		
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		System.err.println(response);
		if (response != Response.ok().build()) {
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

	public int iniciarSesion(String email, String contrasenya) {
		WebTarget webTarget1 = webTarget.path("server/inicioSesion");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);
		
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setContrasenya(contrasenya);

		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		System.err.println(response);
		 if (response == Response.ok().build()) {
			return 1;
			
		}else if(response == Response.accepted().build()){
			return 2;
		}return 0;
	}
	public Response insertarReservaSala(ReservaSala rsala) {
		WebTarget webTarget1 = webTarget.path("server/insertarReservaSala");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(rsala, MediaType.APPLICATION_JSON));
		return response;
	}
	public Response insertarSolicitud(Solicitud rsala) {
		WebTarget webTarget1 = webTarget.path("server/insertarSolicitud");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(rsala, MediaType.APPLICATION_JSON));
		return response;
	}
	public Response insertarReservaLibro(ReservaLibro rsala) {
		WebTarget webTarget1 = webTarget.path("server/insertarReservaLibro");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(rsala, MediaType.APPLICATION_JSON));
		return response;
	}
	public Response insertarLibro(Libro rsala) {
		WebTarget webTarget1 = webTarget.path("server/insertarLibro");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.post(Entity.entity(rsala, MediaType.APPLICATION_JSON));
		return response;
	}
	public List<Usuario> cogerUsuarios() {
		WebTarget webTarget1 = webTarget.path("server/cogerUsuarios");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Usuario> list = new ArrayList<Usuario>();
		GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	public List<Solicitud> cogerSolicitudes() {
		WebTarget webTarget1 = webTarget.path("server/cogerSolicitudes");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Solicitud> list = new ArrayList<Solicitud>();
		GenericType<List<Solicitud>> genericType = new GenericType<List<Solicitud>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	public List<ReservaSala> cogerReservasSala() {
		WebTarget webTarget1 = webTarget.path("server/cogerReservasSala");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<ReservaSala> list = new ArrayList<ReservaSala>();
		GenericType<List<ReservaSala>> genericType = new GenericType<List<ReservaSala>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	public List<ReservaLibro> cogerReservasLibro() {
		WebTarget webTarget1 = webTarget.path("server/cogerReservasLibro");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<ReservaLibro> list = new ArrayList<ReservaLibro>();
		GenericType<List<ReservaLibro>> genericType = new GenericType<List<ReservaLibro>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	public List<SalaTrabajo> cogerSalas() {
		WebTarget webTarget1 = webTarget.path("server/cogerSalas");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<SalaTrabajo> list = new ArrayList<SalaTrabajo>();
		GenericType<List<SalaTrabajo>> genericType = new GenericType<List<SalaTrabajo>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	public List<Libro> cogerLibros() {
		WebTarget webTarget1 = webTarget.path("server/cogerLibros");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Libro> list = new ArrayList<Libro>();
		GenericType<List<Libro>> genericType = new GenericType<List<Libro>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	public List<Actividad> cogerActividades(){
		WebTarget webTarget1 = webTarget.path("server/cogerActividades");	
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		List<Actividad> list = new ArrayList<Actividad>();
		GenericType<List<Actividad>> genericType = new GenericType<List<Actividad>>(){}; 
		list = webTarget1.request(MediaType.APPLICATION_JSON).get(genericType);
		return list;
	}
	
	
}