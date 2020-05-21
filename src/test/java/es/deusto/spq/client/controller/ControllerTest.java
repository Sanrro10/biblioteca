package es.deusto.spq.client.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.data.Actividad;
import es.deusto.spq.client.data.Libro;
import es.deusto.spq.client.data.ReservaLibro;
import es.deusto.spq.client.data.ReservaSala;
import es.deusto.spq.client.data.SalaTrabajo;
import es.deusto.spq.client.data.Solicitud;
import es.deusto.spq.client.data.Usuario;
import es.deusto.spq.client.remote.ServiceLocator;


public class ControllerTest {
	

	ServiceLocator servicelocator;
	Controller controller;
	ReservaSala reservaSala1;
	ReservaLibro rlibro;
	Date d;
	Libro libro;
	Solicitud solicitud;
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
    public void setUp(){
		servicelocator = new ServiceLocator();
        controller = new Controller(servicelocator);
        reservaSala1 = new ReservaSala();
        rlibro = new ReservaLibro();
        d = new Date();
        libro = new Libro(200, "a", "a", "a", 20);
        solicitud = new Solicitud(200, "a", "a", "a", 2);
        
    }
	@Test
    public void registrarUsuarioTest(){	
		assertEquals(controller.registrarUsuario("a", "a", "a", 12345, "a"), true);
	}
	@Test
    public void iniciarSesionTest(){	
		assertEquals(controller.iniciarSesion("a@a.com", "123"), 1);
	}
	@Test
    public void insertarReservaSalaTest(){
		reservaSala1.setCalefaccion(true);
		reservaSala1.setCod_Reserva_Sala(200);
		reservaSala1.setCod_Sala(0);
		reservaSala1.setEmail("a@a.com");
		reservaSala1.setFecha(d);
		assertEquals(controller.insertarReservaSala(reservaSala1), true);
	}
	@Test
    public void insertarSolicitudTest(){	
		assertEquals(controller.insertarSolicitud(solicitud), true);
	}
	@Test
    public void insertarReservaLibroTest(){	
		rlibro.setCod_Libro(200);
		rlibro.setCod_Reserva_Libro(200);
		rlibro.setEmail("a@a.com");
		rlibro.setEstado_Libro(2);
		rlibro.setFecha_Devolución(d);
		assertEquals(controller.insertarReservaLibro(rlibro), true);
	}
	@Test
    public void insertarLibroTest(){	
		assertEquals(controller.insertarLibro(libro), true);
	}
	
	@Test
    public void editarUsuarioTest(){	
		Usuario u1 = new Usuario("a@a.com", "a", "A", 942687531, "123", false);
		assertEquals(controller.editarUsuario(u1), true);
	}
	@Test
    public void cogerUsuariosTest(){	
		assertNotNull(controller.cogerUsuarios());
	}
	@Test
    public void cogerReservasSalaTest(){	
		assertNotNull(controller.cogerReservasSala());
	}
	@Test
    public void cogerReservasLibroTest(){	
		assertNotNull(controller.cogerReservasLibro());
	}
	@Test
    public void cogerSalasTest(){	
		assertNotNull(controller.cogerSalas());
	}
	@Test
    public void cogerLibrosTest(){	
		assertNotNull(controller.cogerLibros());
	}
	@Test
    public void cogerActividadesTest(){	
		assertNotNull(controller.cogerActividades());
	}
}
