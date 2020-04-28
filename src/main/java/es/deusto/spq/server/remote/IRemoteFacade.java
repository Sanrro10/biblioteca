package es.deusto.spq.server.remote;

import javax.ws.rs.core.Response;

import es.deusto.spq.server.data.dto.UsuarioDTO;

public interface IRemoteFacade{
	public Response registrarUsuario(UsuarioDTO userDTO);
	public Response iniciarSesion(UsuarioDTO userDTO);
}
