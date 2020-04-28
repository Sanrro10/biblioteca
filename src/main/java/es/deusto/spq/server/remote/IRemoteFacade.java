package es.deusto.spq.server.remote;

import javax.ws.rs.core.Response;

public interface IRemoteFacade{
	public Response registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya);
	public Response iniciarSesion(String email, String contrasenya);
}
