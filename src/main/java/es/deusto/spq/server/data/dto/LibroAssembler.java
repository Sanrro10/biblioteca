package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.Libro;

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
	
	public Libro DTOtoEntity(LibroDTO dto) {
		Libro libro = new Libro();

		libro.setCod_Libro(dto.getCod_Libro());
		libro.setTitulo(dto.getTitulo());
		libro.setAutor(dto.getAutor());
		libro.setGenero(dto.getGenero());
		libro.setReserva_Max(dto.getReserva_Max());

		return libro;
	}
}
