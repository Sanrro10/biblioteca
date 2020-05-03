package es.deusto.spq.server.remote;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import java.util.ArrayList;
import java.util.List;

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
import es.deusto.spq.server.data.Libro;
import es.deusto.spq.server.data.ReservaLibro;
import es.deusto.spq.server.data.ReservaSala;
import es.deusto.spq.server.data.SalaTrabajo;
import es.deusto.spq.server.data.Solicitud;
import es.deusto.spq.server.data.Usuario;
import es.deusto.spq.server.data.dto.LibroAssembler;
import es.deusto.spq.server.data.dto.LibroDTO;
import es.deusto.spq.server.data.dto.ReservaLibroAssembler;
import es.deusto.spq.server.data.dto.ReservaLibroDTO;
import es.deusto.spq.server.data.dto.ReservaSalaAssembler;
import es.deusto.spq.server.data.dto.ReservaSalaDTO;
import es.deusto.spq.server.data.dto.SalaTrabajoAssembler;
import es.deusto.spq.server.data.dto.SalaTrabajoDTO;
import es.deusto.spq.server.data.dto.SolicitudAssembler;
import es.deusto.spq.server.data.dto.SolicitudDTO;
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
	@POST
	@Path("/insertarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarSolicitud(SolicitudDTO solicitudDTO) {
		Solicitud solicitud = SolicitudAssembler.getInstance().DTOtoEntity(solicitudDTO);
		dbmanager.store(solicitud);
		return Response.ok().build();
	}
	@POST
	@Path("/insertarReservaSala")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarReservaSala(ReservaSalaDTO rsalaDTO) {
		ReservaSala rsala = ReservaSalaAssembler.getInstance().DTOtoEntity(rsalaDTO);
		dbmanager.store(rsala);
		return Response.ok().build();
	}
	@POST
	@Path("/insertarReservaLibro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarReservaLibro(ReservaLibroDTO rlibroDTO) {
		ReservaLibro rlibro = ReservaLibroAssembler.getInstance().DTOtoEntity(rlibroDTO);
		dbmanager.store(rlibro);
		return Response.ok().build();
	}
	@POST
	@Path("/insertarLibro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarLibro(LibroDTO libroDTO) {
		Libro libro = LibroAssembler.getInstance().DTOtoEntity(libroDTO);
		dbmanager.store(libro);
		return Response.ok().build();
	}
	@GET
	@Path("/cogerUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> cogerUsuarios() {
		List<Usuario> usuarios = dbmanager.getUsuarios();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for(int i = 0; i < usuarios.size(); i++) {
			UsuarioDTO uDTO = UsuarioAssembler.getInstance().entityToDTO(usuarios.get(i));
			usuariosDTO.add(uDTO);
		}
		return usuariosDTO;
	}
	@GET
	@Path("/cogerSolicitudes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SolicitudDTO> cogerSolicitudes() {
		List<Solicitud> usuarios = dbmanager.getSolicitudes();
		List<SolicitudDTO> usuariosDTO = new ArrayList<>();
		for(int i = 0; i < usuarios.size(); i++) {
			SolicitudDTO uDTO = SolicitudAssembler.getInstance().entityToDTO(usuarios.get(i));
			usuariosDTO.add(uDTO);
		}
		return usuariosDTO;
	}
	@GET
	@Path("/cogerReservasSala")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReservaSalaDTO> cogerReservasSala() {
		List<ReservaSala> reservasSala = dbmanager.getReserva_Salas();
		List<ReservaSalaDTO> reservasSalaDTO = new ArrayList<>();
		for(int i = 0; i < reservasSala.size(); i++) {
			ReservaSalaDTO uDTO = ReservaSalaAssembler.getInstance().entityToDTO(reservasSala.get(i));
			reservasSalaDTO.add(uDTO);
		}
		return reservasSalaDTO;
	}
	@GET
	@Path("/cogerReservasLibro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReservaLibroDTO> cogerReservasLibro() {
		List<ReservaLibro> reservasLibro = dbmanager.getReserva_Libros();
		List<ReservaLibroDTO> reservasLibroDTO = new ArrayList<>();
		for(int i = 0; i < reservasLibro.size(); i++) {
			ReservaLibroDTO uDTO = ReservaLibroAssembler.getInstance().entityToDTO(reservasLibro.get(i));
			reservasLibroDTO.add(uDTO);
		}
		return reservasLibroDTO;
	}
	@GET
	@Path("/cogerLibros")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LibroDTO> cogerLibros() {
		List<Libro> libro = dbmanager.getLibros();
		List<LibroDTO> librosDTO = new ArrayList<>();
		for(int i = 0; i < libro.size(); i++) {
			LibroDTO uDTO = LibroAssembler.getInstance().entityToDTO(libro.get(i));
			librosDTO.add(uDTO);
		}
		return librosDTO;
	}
	@GET
	@Path("/cogerSalasTrabajo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SalaTrabajoDTO> cogerSalasTrabajo() {
		List<SalaTrabajo> salaTrabajo = dbmanager.getSalaTrabajos();
		List<SalaTrabajoDTO> salasTrabajoDTO = new ArrayList<>();
		for(int i = 0; i < salaTrabajo.size(); i++) {
			SalaTrabajoDTO uDTO = SalaTrabajoAssembler.getInstance().entityToDTO(salaTrabajo.get(i));
			salasTrabajoDTO.add(uDTO);
		}
		return salasTrabajoDTO;
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
