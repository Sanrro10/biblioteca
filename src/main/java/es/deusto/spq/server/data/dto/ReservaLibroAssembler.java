package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.ReservaLibro;

public class ReservaLibroAssembler {
	private static ReservaLibroAssembler instance;

	private ReservaLibroAssembler() {
	}

	public static ReservaLibroAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaLibroAssembler();
		}

		return instance;
	}

	public ReservaLibroDTO entityToDTO(ReservaLibro libro) {
		ReservaLibroDTO dto = new ReservaLibroDTO();

		dto.setCod_Reserva_Libro(libro.getCod_Reserva_Libro());
		dto.setCod_Libro(libro.getCod_Libro());
		dto.setCod_Usuario(libro.getCod_Usuario());
		dto.setFecha_Devolución(libro.getFecha_Devolución());

		return dto;
	}
	
	public ReservaLibro DTOtoEntity(ReservaLibroDTO dto) {
		ReservaLibro rlibro = new ReservaLibro();

		rlibro.setCod_Reserva_Libro(dto.getCod_Reserva_Libro());
		rlibro.setCod_Libro(dto.getCod_Libro());
		rlibro.setCod_Usuario(dto.getCod_Usuario());
		rlibro.setFecha_Devolución(dto.getFecha_Devolución());

		return rlibro;
	}
}
