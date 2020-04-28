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
		dto.setContrasenya(user.getContrasenya());
		
		return dto;
	}
	public Usuario DTOtoEntity(UsuarioDTO dto) {
		Usuario user = new Usuario();
		
		user.setEmail(dto.getEmail());
		user.setApellidos(dto.getApellidos());
		user.setNombre(dto.getNombre());
		user.setTelefono(dto.getTelefono());
		user.setGestor(dto.isGestor());
		user.setContrasenya(dto.getContrasenya());
		
		return user;
	}
}
