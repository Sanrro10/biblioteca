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

import org.apache.log4j.Logger;

import es.deusto.spq.server.DAO.DBManager;
import es.deusto.spq.server.data.Usuario;
import es.deusto.spq.server.data.dto.UsuarioAssembler;
import es.deusto.spq.server.data.dto.UsuarioDTO;

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class RemoteFacade implements IRemoteFacade{


		private int cont = 0;
		private DBManager dbmanager = null;
		private Logger logger = Logger.getLogger(RemoteFacade.class.getName());

		public RemoteFacade() {
			this.dbmanager = DBManager.getInstance();
		}
			
	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;

	
	
	
	
		
	@POST
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(UsuarioDTO userDTO) {
		Usuario user = dbmanager.getUsuario(userDTO.getEmail());
		if(user== null) {
			user = UsuarioAssembler.getInstance().DTOtoEntity(userDTO);
			dbmanager.store(user);
			return Response.ok().build();
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	@POST
	@Path("/inicioSesion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response iniciarSesion(UsuarioDTO userDTO) {
		Usuario user = dbmanager.getUsuario(userDTO.getEmail());
		if(user!= null && user.getContrasenya().equals(userDTO.getContrasenya())) {
			return Response.ok().build();
		}return Response.status(Response.Status.BAD_REQUEST).build();
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
