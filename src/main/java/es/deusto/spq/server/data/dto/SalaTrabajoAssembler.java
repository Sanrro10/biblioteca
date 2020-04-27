package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.SalaTrabajo;

public class SalaTrabajoAssembler {
	private static SalaTrabajoAssembler instance;

	private SalaTrabajoAssembler() {
	}

	public static SalaTrabajoAssembler getInstance() {
		if (instance == null) {
			instance = new SalaTrabajoAssembler();
		}

		return instance;
	}

	public SalaTrabajoDTO entityToDTO(SalaTrabajo sala) {
		SalaTrabajoDTO dto = new SalaTrabajoDTO();

		dto.setCod_sala(sala.getCod_sala());
		dto.setUbicacion(sala.getUbicacion());
		dto.setNumMaxUsuarios(sala.getNumMaxUsuarios());

		return dto;
	}
}
