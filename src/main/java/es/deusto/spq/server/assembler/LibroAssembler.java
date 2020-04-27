package es.deusto.spq.server.assembler;

import es.deusto.spq.client.base.Libro;
import es.deusto.spq.server.DTO.LibroDTO;

public class LibroAssembler {
	private static LibroAssembler instance;

	private LibroAssembler() {
	}

	public static LibroAssembler getInstance() {
		if (instance == null) {
			instance = new LibroAssembler();
		}

		return instance;
	}

	public LibroDTO entityToDTO(Libro libro) {
		LibroDTO dto = new LibroDTO();

		dto.setCod_Libro(libro.getCod_Libro());
		dto.setTitulo(libro.getTitulo());
		dto.setAutor(libro.getAutor());
		dto.setGenero(libro.getGenero());
		dto.setReserva_Max(libro.getReserva_Max());

		return dto;
	}
}
