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
import es.deusto.spq.server.data.Actividad;
import es.deusto.spq.server.data.Libro;
import es.deusto.spq.server.data.ReservaLibro;
import es.deusto.spq.server.data.ReservaSala;
import es.deusto.spq.server.data.SalaTrabajo;
import es.deusto.spq.server.data.Solicitud;
import es.deusto.spq.server.data.Usuario;
import es.deusto.spq.server.data.dto.ActividadAssembler;
import es.deusto.spq.server.data.dto.ActividadDTO;
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

/**
 * Fachada que conecta el servidor con el cliente a través de paths de la URL
 *@author isanr
 */
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
	
	/**
	  * Método para registrar usuario. 
	  * Llama al método getUsuario del DBManager y comprueba si el usuario existe.
	  * Si no existe, lo transforma con el Assembler y lo guarda en la BD
	  *
	  * @param userDTO UsuarioDTO a registrar.
	  * @return Un Response que es ok en caso de que no haya habido ningún error y es BAD_REQUEST en caso contrario
	  */	
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
	/**
	  * Método para iniciar sesión. 
	  * Llama al método getUsuario del DBManager y comprueba si el usuario existe.
	  * Si existe, y la contraseña coincide, lo transforma con el Assembler y lo guarda en la BD
	  *
	  * @param userDTO UsuarioDTO con el que iniciar sesión.
	  * @return Un Response que es ok en caso de que no haya habido ningún error y sea un Usuario normal, un accepted en caso de ser gestor y 
	  * un BAD_REQUEST en caso de haber un error o no cumplir los requisitos
	  */
	@POST
	@Path("/inicioSesion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response iniciarSesion(UsuarioDTO userDTO) {
		Usuario user = dbmanager.getUsuario(userDTO.getEmail());
		if(user!= null && user.getContrasenya().equals(userDTO.getContrasenya())) {
			if(user.isGestor()) {
				return Response.accepted().build();
			}else {
				return Response.ok().build();
			}	
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	/**
	  * Método para insertar una reserva de una sala en la BD. 
	  * Transforma el Objeto en DTO y llamaDTO a la función store del DBManager para guardarlo en la BD
	  *
	  * @param rsalaDTO ReservaSalaDTO a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	@POST
	@Path("/insertarReservaSala")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarReservaSala(ReservaSalaDTO rsalaDTO) {
		ReservaSala rsala = ReservaSalaAssembler.getInstance().DTOtoEntity(rsalaDTO);
		dbmanager.store(rsala);
		return Response.ok().build();
	}
	/**
	  * Método para insertar una solicitud en la BD. 
	  * Transforma el Objeto en DTO y llamaDTO a la función store del DBManager para guardarlo en la BD
	  *
	  * @param solicitudDTO SolicitudDTO a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	
	@POST
	@Path("/insertarSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarSolicitud(SolicitudDTO solicitudDTO) {
		Solicitud solicitud = SolicitudAssembler.getInstance().DTOtoEntity(solicitudDTO);
		dbmanager.store(solicitud);
		return Response.ok().build();
	}
	/**
	  * Método para insertar una reserva de un libro en la BD. 
	  * Transforma el Objeto en DTO y llamaDTO a la función store del DBManager para guardarlo en la BD
	  *
	  * @param rlibroDTO ReservaLibroDTO a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	@POST
	@Path("/insertarReservaLibro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarReservaLibro(ReservaLibroDTO rlibroDTO) {
		ReservaLibro rlibro = ReservaLibroAssembler.getInstance().DTOtoEntity(rlibroDTO);
		dbmanager.store(rlibro);
		return Response.ok().build();
	}
	/**
	  * Método para insertar un libro en la BD. 
	  * Transforma el Objeto en DTO y llamaDTO a la función store del DBManager para guardarlo en la BD
	  *
	  * @param libroDTO LibroDTO a insertar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	@POST
	@Path("/insertarLibro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarLibro(LibroDTO libroDTO) {
		Libro libro = LibroAssembler.getInstance().DTOtoEntity(libroDTO);
		dbmanager.store(libro);
		return Response.ok().build();
	}
	/**
	  * Método para editar los datos de un usuario en la BD. 
	  * Transforma el Objeto en DTO y llamaDTO a la función update del DBManager para actualizarlo en la BD
	  *
	  * @param userDTO UsuarioDTO a editar en la BD
	  * @return Un boolean que es true en caso de que no haya habido ningún error y es false en caso contrario
	  */
	@POST
	@Path("/editarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarUsuario(UsuarioDTO userDTO) {
		Usuario user = UsuarioAssembler.getInstance().DTOtoEntity(userDTO);
		dbmanager.update(user);
		return Response.ok().build();
	}
	/**
	  * Método para obtener la lista de los usuarios de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de los usuarios de la BD
	  */
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
	/**
	  * Método para obtener la lista de las solicitudes de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de las solicitudes de la BD
	  */
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
	/**
	  * Método para obtener la lista de las reservas de las salas de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de las reservas de las salas de la BD
	  */
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
	/**
	  * Método para obtener la lista de las reservas de los libros de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de las reservas de los libros de la BD
	  */
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
	/**
	  * Método para obtener la lista de los libros de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de los libros de la BD
	  */
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
	/**
	  * Método para obtener la lista de las salas de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de las salas de la BD
	  */
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
	/**
	  * Método para obtener la lista de las actividades de la BD. 
	  * Coge los datos de la BD y los transforma en DTO para devolverlos
	  *
	  * @return Lista de las actividades de la BD
	  */
	@GET
	@Path("/cogerActividades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadDTO> cogerActividades() {
		List<Actividad> actividades = dbmanager.getActividades();
		List<ActividadDTO> actividadesDTO = new ArrayList<>();
		for(int i = 0; i < actividades.size(); i++) {
			ActividadDTO uDTO = ActividadAssembler.getInstance().entityToDTO(actividades.get(i));
			actividadesDTO.add(uDTO);
		}
		return actividadesDTO;
	}
	

	/**
	  * Método para obtener la instancia del RemoteFacade. 
	  * En caso de no existir la crea
	  * Si ya existe la devuelve
	  *
	  * @return la instancia de la RemoteFacade
	  */
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
