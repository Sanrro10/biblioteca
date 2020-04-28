package es.deusto.spq.server.remote;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import es.deusto.spq.server.data.Usuario;

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class RemoteFacade implements IRemoteFacade{

	private int cont = 0;
	private PersistenceManager pm=null;
	private Transaction tx=null;
	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;

	public RemoteFacade(){
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}
	
	
	
	
		
	@POST
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya) {
		try
        {	
            tx.begin();
			Usuario user = null;
			try {
				user = pm.getObjectById(Usuario.class, email);
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				System.out.println("Exception launched: " + jonfe.getMessage());
			}
			if (user != null) {
				tx.commit();
				return Response.status(Response.Status.BAD_REQUEST).build();
			} else {
				user = new Usuario(email, nombre, apellidos, telefono, contrasenya, false);
				pm.makePersistent(user);					 
				System.out.println("Usuario registrado: " + user);
			}
			tx.commit();
			return Response.ok().build();
	       }
	       finally
	       {
	           if (tx.isActive())
	           {
	               tx.rollback();
	           }
	     
			}
	}@POST
	@Path("/inicioSesion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response iniciarSesion(String email, String contrasenya) {
		try
        {	
            tx.begin();
			Usuario user = null;
			try {
				user = pm.getObjectById(Usuario.class, email);
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				System.out.println("Exception launched: " + jonfe.getMessage());
			}if (user != null) {
				if(user.getContrasenya().equals(contrasenya)) {
					if(user.isGestor()) {
						tx.commit();
						return Response.accepted().build();
					}
					tx.commit();
					return Response.ok().build();
				}else {
					tx.commit();
					return Response.status(Response.Status.BAD_REQUEST).build();
					}
				
			}
			tx.commit();
			return Response.status(Response.Status.BAD_REQUEST).build();
	       }
	       finally
	       {
	           if (tx.isActive())
	           {
	               tx.rollback();
	           }
	     
			}
	}





	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

}
