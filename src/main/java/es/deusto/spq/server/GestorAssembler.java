package es.deusto.spq.server;

import es.deusto.spq.server.DTO.GestorDTO;
import es.deusto.spq.server.assembler.UsuarioAssembler;
import es.deusto.spq.server.base.Gestor;
import es.deusto.spq.server.base.Usuario;

public class GestorAssembler {
	private static GestorAssembler instance;

	private GestorAssembler() { }
	
	public static GestorAssembler getInstance() {
		if (instance == null) {
			instance = new GestorAssembler();
		}

		return instance;
	}

	public GestorDTO entityToDTO(Gestor gestorAssembler) {
		GestorDTO dto = new GestorDTO();
		
		dto.setEmail(gestorAssembler.getEmail());
		dto.setApellidos(gestorAssembler.getApellidos());
		dto.setNombre(gestorAssembler.getNombre());
		dto.setTelefono(gestorAssembler.getTelefono());
		
		return dto;
	}
}
