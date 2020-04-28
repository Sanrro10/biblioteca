package es.deusto.spq.server.main;

import java.io.IOException;
import java.net.URI;
import java.rmi.Naming;
import java.rmi.Remote;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import es.deusto.spq.client.gui.InicioSesion;
import es.deusto.spq.client.properties.GetPropertyValues;
import es.deusto.spq.server.DAO.DBManager;
import es.deusto.spq.server.data.Usuario;
import es.deusto.spq.server.remote.IRemoteFacade;
import es.deusto.spq.server.remote.RemoteFacade;

public class Server {

	// Base URI the Grizzly HTTP server will listen on
	

		/**
		 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
		 * application.
		 *
		 * @return Grizzly HTTP server.
		 */
		public static HttpServer startServer() {
			// create a resource config that scans for JAX-RS resources and providers
			// in com.example package
			final ResourceConfig rc = new ResourceConfig().packages("com.example");

			// create and start a new instance of grizzly http server
			// exposing the Jersey application at BASE_URI

			
			return GrizzlyHttpServerFactory.createHttpServer(URI.create(cogerUrl()), rc);
		}public static String cogerUrl(){
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
		
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException {
			DBManager.getInstance();
			final HttpServer server = startServer();
			System.out.println(String.format(
					"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
					cogerUrl()));
			System.in.read();
			server.stop();

			

		}
//		public static void main(String[] args) {
//			
//			Usuario u1 = new Usuario("a@a.com", "a", "a", 942687531, "123", false);
//			DBManager.getInstance().store(u1);
//			
//
//		}
		
		
		
		
		
}