package es.deusto.spq.server.data.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.data.Libro;

public class LibroAssemblerTest {

	Libro libro1;
	LibroDTO libroDTO1;
	
	Libro libro2;
	LibroDTO libroDTO2;
	
	LibroAssembler libroAs1;

	@Before
	public void setUp() {
		libro1 = new Libro();

		libro1.setTitulo("Titulo");
		libro1.setAutor("Kevin");
		libro1.setCod_Libro(01);
		libro1.setGenero("Infantil");
		libro1.setReserva_Max(2);
		
		libroDTO2 = new LibroDTO();
		libroDTO2.setTitulo("Test");
		libroDTO2.setAutor("Eneko");
		libroDTO2.setCod_Libro(02);
		libroDTO2.setGenero("Infantil");
		libroDTO2.setReserva_Max(3);

	}
	
	@Test
	public void EntityToDTOTest() {
		libroDTO1 = LibroAssembler.getInstance().entityToDTO(libro1);
		
		assertEquals(libroDTO1.getCod_Libro(), libro1.getCod_Libro());
		assertEquals(libroDTO1.getTitulo(), libro1.getTitulo());
		assertEquals(libroDTO1.getAutor(), libro1.getAutor());
		assertEquals(libroDTO1.getGenero(), libro1.getGenero());
		assertEquals(libroDTO1.getReserva_Max(), libro1.getReserva_Max());
		
	}
	
	@Test
	public void DTOToEntityTest() {
		libro2 = LibroAssembler.getInstance().DTOtoEntity(libroDTO2);
		
		assertEquals(libroDTO2.getCod_Libro(), libro2.getCod_Libro());
		assertEquals(libroDTO2.getTitulo(), libro2.getTitulo());
		assertEquals(libroDTO2.getAutor(), libro2.getAutor());
		assertEquals(libroDTO2.getGenero(), libro2.getGenero());
		assertEquals(libroDTO2.getReserva_Max(), libro2.getReserva_Max());
		
	}

}
