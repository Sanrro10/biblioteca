package es.deusto.spq.client.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.data.Libro;
import es.deusto.spq.client.data.ReservaLibro;
import es.deusto.spq.client.data.ReservaSala;
import es.deusto.spq.client.data.Solicitud;
import es.deusto.spq.client.remote.ServiceLocator;


public class ControllerTest {
	
//
//	ServiceLocator servicelocator;
//	Controller controller;
//	ReservaSala reservaSala1;
//	ReservaLibro rlibro;
//	Date d;
//	Libro libro;
//	Solicitud solicitud;
//	@Before
//    public void setUp(){
//		servicelocator = new ServiceLocator();
//        controller = new Controller(servicelocator);
//        reservaSala1 = new ReservaSala();
//        rlibro = new ReservaLibro();
//        d = new Date();
//        libro = new Libro(0, "a", "a", "a", 20);
//        solicitud = new Solicitud(0, "a", "a", "a", 2);
//        
//    }
//	@Test
//    public void registrarUsuarioTest(){	
//		assertEquals(controller.registrarUsuario("a", "a", "a", 12345, "a"), true);
//	}
//	@Test
//    public void iniciarSesionTest(){	
//		assertEquals(controller.iniciarSesion("a", "a"), true);
//	}
//	@Test
//    public void insertarReservaSalaTest(){
//		reservaSala1.setCalefaccion(true);
//		reservaSala1.setCod_Reserva_Sala(0);
//		reservaSala1.setCod_Sala(0);
//		reservaSala1.setEmail("a@a.com");
//		reservaSala1.setFecha(d);
//		assertEquals(controller.insertarReservaSala(reservaSala1), true);
//	}
//	@Test
//    public void insertarSolicitudTest(){	
//		assertEquals(controller.insertarSolicitud(solicitud), true);
//	}
//	@Test
//    public void insertarReservaLibroTest(){	
//		rlibro.setCod_Libro(0);
//		rlibro.setCod_Reserva_Libro(2);
//		rlibro.setEmail("a@a.com");
//		rlibro.setEstado_Libro(2);
//		rlibro.setFecha_Devolución(d);
//		assertEquals(controller.insertarReservaLibro(rlibro), true);
//	}
//	@Test
//    public void insertarLibroTest(){	
//		assertEquals(controller.insertarLibro(libro), true);
//	}
}
