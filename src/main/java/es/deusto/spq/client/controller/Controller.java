package es.deusto.spq.client.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import es.deusto.spq.client.remote.ServiceLocator;


public class Controller {
	
	
	public ServiceLocator serviceLocator;

	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya){
		Response r = serviceLocator.getService().registrarUsuario(email, nombre,  apellidos, telefono, contrasenya);
		if(r == Response.ok().build()) {
			return true;
		}
		return false;		
	}
	public int iniciarSesion(String email, String contrasenya){
		Response r = serviceLocator.getService().iniciarSesion(email, contrasenya);
		if(r == Response.ok().build()) {
			return 1;
		}else if (r == Response.accepted().build()) {
			return 2;
		}
		return 0;		
	}

//		private Client client; 
//		private WebTarget webTarget; 
//		private static Logger logger = Logger.getLogger(Controller.class.getName());
//
//		public Controller(String hostname, String port) { 
//			client = ClientBuilder.newClient();
//			webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
//		}
//
//		/** REGISTERS a new User in the db giving its parameters 
//		 * @param login - nick of the user
//		 * @param icon  - icon of the user
//		 * @param email - email of the user
//		 * @param password - pass of the user
//		 */
//		public void registerUser(String login, String icon, String email, String password) {
//			WebTarget registerUserWebTarget = webTarget.path("server/register");
//			Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
//			
//			UserData userData = new UserData();
//			userData.setLogin(login);
//			userData.setPassword(password);
//			userData.setEmail(email);
//			userData.setIcon(icon);
//			Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
//			if (response.getStatus() != Status.OK.getStatusCode()) {
//				logger.error("Error connecting with the server. Code: " + response.getStatus());
//			} else {
//				logger.info("User correctly registered");
//			}
//		}
//
//		/** CHECKS if the login is correct
//		 * @param login - login of the user
//		 * @param password - pass of the user
//		 * @return boolean - if correct true else false 
//		 */
//		public boolean login(String login, String password) {
//			WebTarget loginWebTarget = webTarget.path("server/login");		
//			Invocation.Builder invocationBuilder = loginWebTarget.request(MediaType.APPLICATION_JSON);
//			
//			UserData userData = new UserData();
//			userData.setLogin(login);
//			userData.setPassword(password);
//
//			Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
//			if(response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
//				String responseMessage2 = response.readEntity(String.class);
//				logger.error("* ERROR: '" + responseMessage2 + "'");
//				return false;
//				
//			}else if (response.getStatus() != Status.OK.getStatusCode()) {
//				logger.error("Error connecting with the server. Code: " + response.getStatus());
//				return false;
//				
//			}else {
//				return true;
//			}
//		}



		
		

}
