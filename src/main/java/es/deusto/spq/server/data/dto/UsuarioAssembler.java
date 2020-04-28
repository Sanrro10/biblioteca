package es.deusto.spq.server.data.dto;

import es.deusto.spq.server.data.Usuario;

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
		dto.setNombre(user.getNombre());
		dto.setTelefono(user.getTelefono());
		dto.setGestor(user.isGestor());
		
		return dto;
	}
}
