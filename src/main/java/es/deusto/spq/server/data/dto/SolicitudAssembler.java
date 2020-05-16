package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.Solicitud;

/**
 * Clase Assembler de Solicitud
 * Se encarga de convertir los objetos Solicitud en SolicitudDTO y viceversa
 *@author isanr
 */
public class SolicitudAssembler {

	private static SolicitudAssembler instance;

	private SolicitudAssembler() { }
	
	public static SolicitudAssembler getInstance() {
		if (instance == null) {
			instance = new SolicitudAssembler();
		}

		return instance;
	}

	public SolicitudDTO entityToDTO(Solicitud solicitud) {
		SolicitudDTO dto = new SolicitudDTO();
		
		dto.setAutorS(solicitud.getAutorS());
		dto.setCantidadS(solicitud.getCantidadS());
		dto.setCodigoS(solicitud.getCodigoS());
		dto.setGeneroS(solicitud.getGeneroS());
		dto.setTituloS(solicitud.getTituloS());
		
		return dto;
	}
	public Solicitud DTOtoEntity(SolicitudDTO dto) {
		Solicitud solicitud = new Solicitud();
		
		solicitud.setAutorS(dto.getAutorS());
		solicitud.setCantidadS(dto.getCantidadS());
		solicitud.setCodigoS(dto.getCodigoS());
		solicitud.setGeneroS(dto.getGeneroS());
		solicitud.setTituloS(dto.getTituloS());
		
		return solicitud;
	}
}
