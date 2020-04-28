package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.ReservaSala;

public class ReservaSalaAssembler {
	private static ReservaSalaAssembler instance;

	private ReservaSalaAssembler() {
	}

	public static ReservaSalaAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaSalaAssembler();
		}

		return instance;
	}

	public ReservaSalaDTO entityToDTO(ReservaSala sala) {
		ReservaSalaDTO dto = new ReservaSalaDTO();

		dto.setCod_Reserva_Sala(sala.getCod_Reserva_Sala());
		dto.setCod_Sala(sala.getCod_Sala());
		dto.setCod_Usuario(sala.getCod_Usuario());
		dto.setCalefaccion(sala.isCalefaccion());
		dto.setFecha(sala.getFecha());

		return dto;
	}

	public ReservaSala DTOtoEntity(ReservaSalaDTO dto) {
		ReservaSala reserva = new ReservaSala();

		reserva.setCod_Reserva_Sala(dto.getCod_Reserva_Sala());
		reserva.setCod_Sala(dto.getCod_Sala());
		reserva.setCod_Usuario(dto.getCod_Usuario());
		reserva.setFecha(dto.getFecha());
		reserva.setCalefaccion(dto.isCalefaccion());

		return reserva;
	}

}
