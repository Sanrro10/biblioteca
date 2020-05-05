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
		dto.setEmail(libro.getEmail());
		dto.setFecha_Devolución(libro.getFecha_Devolución());
		dto.setEstado_Libro(libro.getEstado_Libro());

		return dto;
	}
	
	public ReservaLibro DTOtoEntity(ReservaLibroDTO dto) {
		ReservaLibro rlibro = new ReservaLibro();

		rlibro.setCod_Reserva_Libro(dto.getCod_Reserva_Libro());
		rlibro.setCod_Libro(dto.getCod_Libro());
		rlibro.setEmail(dto.getEmail());
		rlibro.setFecha_Devolución(dto.getFecha_Devolución());
		rlibro.setEstado_Libro(dto.getEstado_Libro());

		return rlibro;
	}
}
