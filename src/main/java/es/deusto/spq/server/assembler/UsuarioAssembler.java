package es.deusto.spq.server.assembler;

import es.deusto.spq.server.DTO.UsuarioDTO;
import es.deusto.spq.server.base.Usuario;

public class UsuarioAssembler {

	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO entityToDTO(Usuario user) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setEmail(user.getEmail());
		dto.setApellidos(user.getApellidos());
		dto.setCod_Usuario(user.getCod_Usuario());
		dto.setNombre(user.getNombre());
		dto.setTelefono(user.getTelefono());
		
		return dto;
	}
}
