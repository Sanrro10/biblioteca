package es.deusto.spq.client.data;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.data.Libro;

public class LibroTest {
	private Libro libro1;

	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		 libro1 = new Libro(01, "Harry Potter", "J.K.Rowling", "Fantasía", 10);
		 libro1 = new Libro();
		 libro1.setAutor("J.K.Rowling");
		 libro1.setCod_Libro(01);
		 libro1.setGenero("Fantasía");
		 libro1.setReserva_Max(10);
		 libro1.setTitulo("Harry Potter");
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads =20)
	@Required(max=1200, average=250)
	public void testLibro() {
		
		
		assertEquals(01, libro1.getCod_Libro());
		assertEquals("Harry Potter", libro1.getTitulo());
		assertEquals("J.K.Rowling", libro1.getAutor());
		assertEquals("Fantasía", libro1.getGenero());
		assertEquals(10, libro1.getReserva_Max());
		assertEquals("Título: " + libro1.getTitulo() + "\n" + "Autor: " + libro1.getAutor() + "\n" + "Genero: " + libro1.getGenero() + "\n" + "Reserva hasta: " + new SimpleDateFormat("dd-MM-yyyy").format(libro1.fechaReserva()), libro1.toString());
		assertEquals(libro1.getTitulo() + "  " + libro1.getAutor(), libro1.toStringResumido());
	}
	
		
	

}
