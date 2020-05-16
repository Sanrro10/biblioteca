package es.deusto.spq.server.remote;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.deusto.spq.server.data.*;
import es.deusto.spq.server.data.dto.ActividadDTO;
import es.deusto.spq.server.data.dto.LibroDTO;
import es.deusto.spq.server.data.dto.ReservaLibroDTO;
import es.deusto.spq.server.data.dto.ReservaSalaDTO;
import es.deusto.spq.server.data.dto.SalaTrabajoDTO;
import es.deusto.spq.server.data.dto.SolicitudDTO;
import es.deusto.spq.server.data.dto.UsuarioDTO;

/**
 * Interfaz de la fachada.
 * Contiene los métodos de la fachada
 *@author isanr
 */
public interface IRemoteFacade{
	public Response registrarUsuario(UsuarioDTO userDTO);
	public Response iniciarSesion(UsuarioDTO userDTO);
	public Response insertarReservaSala(ReservaSalaDTO rsalaDTO);
	public Response insertarReservaLibro(ReservaLibroDTO rlibroDTO);
	public Response insertarLibro(LibroDTO libroDTO);
	public Response insertarSolicitud(SolicitudDTO solicitudDTO);
	public Response editarUsuario(UsuarioDTO userDTO);
	public List<UsuarioDTO> cogerUsuarios();
	public List<SolicitudDTO> cogerSolicitudes();
	public List<ReservaSalaDTO> cogerReservasSala();
	public List<ReservaLibroDTO> cogerReservasLibro();
	public List<LibroDTO> cogerLibros();
	public List<SalaTrabajoDTO> cogerSalasTrabajo();
	public List<ActividadDTO> cogerActividades();
}
