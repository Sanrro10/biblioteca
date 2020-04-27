package es.deusto.spq.client.base;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.data.Libro;

public class TestLibro {

	@Test
	public void testLibro() {
		
		Libro libro1 = new Libro(01, "Harry Potter", "J.K.Rowling", "Fantasía", 10);
		
		int test = 01;
		String titulo = "Harry Potter";
		String autor = "J.K.Rowling";
		String genero = "Fantasía";
		int reserva_Max = 10;
		
		assertTrue(libro1.getCod_Libro()== test);
		assertTrue(libro1.getTitulo()== titulo);
		assertTrue(libro1.getAutor()== autor);
		assertTrue(libro1.getGenero()== genero);
		assertTrue(libro1.getReserva_Max()== reserva_Max);
		
		

		
		
		
	}

}
