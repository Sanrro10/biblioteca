package es.deusto.spq.client.remote;

import java.io.IOException;

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

import es.deusto.spq.client.properties.GetPropertyValues;
import es.deusto.spq.server.data.dto.UsuarioDTO;
import es.deusto.spq.server.remote.IRemoteFacade;

public class ServiceLocator {
	

	private Client client; 
	private WebTarget webTarget; 
	private static Logger logger = Logger.getLogger(ServiceLocator.class.getName());

	public ServiceLocator() { 
		client = ClientBuilder.newClient();
		webTarget = client.target(cogerUrl());
	}
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya) {
		WebTarget registerUserWebTarget = webTarget.path("server/registro");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		UsuarioDTO u = new UsuarioDTO();
		u.setEmail(email);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setTelefono(telefono);
		u.setContrasenya(contrasenya);
		
		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
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
		WebTarget loginWebTarget = webTarget.path("server/inicioSesion");		
		Invocation.Builder invocationBuilder = loginWebTarget.request(MediaType.APPLICATION_JSON);
		
		UsuarioDTO u = new UsuarioDTO();
		u.setEmail(email);
		u.setContrasenya(contrasenya);

		Response response = invocationBuilder.post(Entity.entity(u, MediaType.APPLICATION_JSON));
		 if (response == Response.ok().build()) {
			return 1;
			
		}else if(response == Response.accepted().build()){
			return 2;
		}return 0;
	}
	
}