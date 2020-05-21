package es.deusto.spq.server.remote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import es.deusto.spq.server.data.dto.ActividadDTO;
import es.deusto.spq.server.data.dto.LibroDTO;
import es.deusto.spq.server.data.dto.ReservaLibroDTO;
import es.deusto.spq.server.data.dto.ReservaSalaDTO;
import es.deusto.spq.server.data.dto.SalaTrabajoDTO;
import es.deusto.spq.server.data.dto.SolicitudDTO;
import es.deusto.spq.server.data.dto.UsuarioDTO;

public class RemoteFacadeTest {
	
	RemoteFacade remote;
	ReservaSalaDTO reservaSala1;
	ReservaLibroDTO rlibro;
	Date d;
	LibroDTO libro;
	SolicitudDTO solicitud;
	UsuarioDTO user1;
	UsuarioDTO user2;
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	@Before
    public void setUp(){
		remote = RemoteFacade.getInstance();
		reservaSala1 = new ReservaSalaDTO();
        rlibro = new ReservaLibroDTO();
        d = new Date();
        libro = new LibroDTO();
        libro.setAutor("aa");
        libro.setCod_Libro(300);
        libro.setGenero("genero");
        libro.setReserva_Max(0);
        libro.setTitulo("aaaq");
        solicitud = new SolicitudDTO(300, "a", "a", "a", 2);
        user1 = new UsuarioDTO("a", "a", "a", 12345, "a", false);
        user2 = new UsuarioDTO("a@a.com", "A", "a", 12345, "123", false);
        rlibro.setCod_Libro(200);
		rlibro.setCod_Reserva_Libro(300);
		rlibro.setEmail("a@a.com");
		rlibro.setEstado_Libro(2);
		rlibro.setFecha_Devolución(d);
		reservaSala1.setCalefaccion(true);
		reservaSala1.setCod_Reserva_Sala(300);
		reservaSala1.setCod_Sala(0);
		reservaSala1.setEmail("a@a.com");
		reservaSala1.setFecha(d);
        
    }

	@Test
	public void registrarUsuarioTest(){
		assertEquals(Status.OK.getStatusCode(), remote.registrarUsuario(user1).getStatus());
	}
	@Test
	public void iniciarSesionTest() {
		assertEquals(Status.OK.getStatusCode(), remote.iniciarSesion(user2).getStatus());
	}
	@Test
	public void insertarReservaSalaTest() {
		assertEquals(Status.OK.getStatusCode(), remote.insertarReservaSala(reservaSala1).getStatus());
	}
	@Test
	public void insertarReservaLibroTest() {
		assertEquals(Status.OK.getStatusCode(), remote.insertarReservaLibro(rlibro).getStatus());
	}
	@Test
	public void insertarLibroTest() {
		assertEquals(Status.OK.getStatusCode(), remote.insertarLibro(libro).getStatus());
	}
	@Test
	public void insertarSolicitudTest() {
		assertEquals(Status.OK.getStatusCode(), remote.insertarSolicitud(solicitud).getStatus());
	}
	@Test
	public void editarUsuarioTest() {
		assertEquals(Status.OK.getStatusCode(), remote.editarUsuario(user2).getStatus());
	}
	@Test
	public void cogerUsuariosTest() {
		assertNotNull(remote.cogerUsuarios());
	}
	@Test
	public void cogerSolicitudesTest() {
		assertNotNull(remote.cogerSolicitudes());
	}
	@Test
	public void cogerReservasSalaTest() {
		assertNotNull(remote.cogerReservasSala());
	}
	@Test
	public void cogerReservasLibroTest() {
		assertNotNull(remote.cogerReservasLibro());
	}
	@Test
	public void cogerLibrosTest() {
		assertNotNull(remote.cogerLibros());
	}
	@Test
	public void cogerSalasTrabajoTest() {
		assertNotNull(remote.cogerSalasTrabajo());
	}
	@Test
	public void cogerActividadesTest() {
		assertNotNull(remote.cogerActividades());
	}
}
