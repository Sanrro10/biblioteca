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
	LibroAssembler libroAs2;

	@Before
	public void setUp() {
		libro1 = new Libro();
		libroAs1 = new LibroAssembler();
		libroAs2 = new LibroAssembler();

		libro1.setTitulo("Titulo");
		libro1.setAutor("Kevin");
		libro1.setCod_Libro(01);
		libro1.setGenero("Infantil");
		libro1.setReserva_Max(2);
		
		libro2.setTitulo("Test");
		libro2.setAutor("Eneko");
		libro2.setCod_Libro(02);
		libro2.setGenero("Infantil");
		libro2.setReserva_Max(3);

	}
	
	@Test
	public void EntityToDTOTest() {
		libroDTO1 = libroAs1.entityToDTO(libro1);
		
		assertEquals(libroDTO1.getCod_Libro(), libro1.getCod_Libro());
		assertEquals(libroDTO1.getTitulo(), libro1.getTitulo());
		assertEquals(libroDTO1.getAutor(), libro1.getAutor());
		assertEquals(libroDTO1.getGenero(), libro1.getGenero());
		assertEquals(libroDTO1.getReserva_Max(), libro1.getReserva_Max());
		
	}
	
	@Test
	public void DTOToEntityTest() {
		libro2 = libroAs2.DTOtoEntity(libroDTO2);
		
		assertEquals(libroDTO2.getCod_Libro(), libro2.getCod_Libro());
		assertEquals(libroDTO2.getTitulo(), libro2.getTitulo());
		assertEquals(libroDTO2.getAutor(), libro2.getAutor());
		assertEquals(libroDTO2.getGenero(), libro2.getGenero());
		assertEquals(libroDTO2.getReserva_Max(), libro2.getReserva_Max());
		
	}

}
