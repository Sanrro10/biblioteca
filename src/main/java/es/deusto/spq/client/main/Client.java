package es.deusto.spq.client.main;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.gui.Actividades;
import es.deusto.spq.client.gui.InicioSesion;
import es.deusto.spq.client.remote.ServiceLocator;
import es.deusto.spq.client.resources.GetPropertyValues;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;

/**
 * Main class.
 * Lanza la primera ventana además de crear el servicelocator y el controller
 *@author isanr
 */
public class Client {

	public static void main(String[] args) {
		ServiceLocator servicelocator = new ServiceLocator();
		Controller controller = new Controller(servicelocator);

		InicioSesion inicio = new InicioSesion(controller);

		inicio.setVisible(true);

		

	}
}
