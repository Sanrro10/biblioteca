package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.SalaTrabajo;
import es.deusto.spq.server.data.Usuario;

/**
 * Clase Assembler de SalaTrabajo
 * Se encarga de convertir los objetos SalaTrabajo en SalaTrabajoDTO y viceversa
 *@author isanr kevin31000 
 */
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
	
	public SalaTrabajo DTOtoEntity(SalaTrabajoDTO dto) {
		SalaTrabajo sala = new SalaTrabajo();

		sala.setCod_sala(dto.getCod_sala());
		sala.setUbicacion(dto.getUbicacion());
		sala.setNumMaxUsuarios(dto.getNumMaxUsuarios());

		return sala;
	}

}

