package es.deusto.spq.client.main;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.gui.InicioSesion;
import es.deusto.spq.client.remote.ServiceLocator;
import es.deusto.spq.client.resources.GetPropertyValues;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Client {
	// Base URI the Grizzly HTTP server will listen on
	


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

	public static void main(String[] args) {
		ServiceLocator servicelocator = new ServiceLocator();
		Controller controller = new Controller(servicelocator);

		InicioSesion inicioSesion = new InicioSesion(750, 422, controller); // quitar comentario para ver la ventana

		inicioSesion.setVisible(true);

		

	}
}
