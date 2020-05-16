package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.Actividad;
import es.deusto.spq.server.data.Libro;

/**
 * Clase Assembler de Actividad
 * Se encarga de convertir los objetos Actividad en ActividadDTO y viceversa
 *@author isanr 
 */
public class ActividadAssembler {
	private static ActividadAssembler instance;

	ActividadAssembler() {
	}

	public static ActividadAssembler getInstance() {
		if (instance == null) {
			instance = new ActividadAssembler();
		}

		return instance;
	}

	public ActividadDTO entityToDTO(Actividad actividad) {
		ActividadDTO dto = new ActividadDTO();

		dto.setDia(actividad.getDia());
		dto.setHora(actividad.getHora());
		dto.setTexto(actividad.getTexto());

		return dto;
	}
	
	public Actividad DTOtoEntity(ActividadDTO dto) {
		Actividad actividad = new Actividad();

		actividad.setDia(dto.getDia());
		actividad.setHora(dto.getHora());
		actividad.setTexto(dto.getTexto());

		return actividad;
	}
}
