package es.deusto.spq.client.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import es.deusto.spq.client.remote.ServiceLocator;


public class Controller {
	
	
	public ServiceLocator serviceLocator;

	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	public boolean registrarUsuario(String email, String nombre, String apellidos, int telefono, String contrasenya){
		return serviceLocator.registrarUsuario(email, nombre, apellidos, telefono, contrasenya);
	}
	public int iniciarSesion(String email, String contrasenya){
		return serviceLocator.iniciarSesion(email, contrasenya);
	}





		
		

}
