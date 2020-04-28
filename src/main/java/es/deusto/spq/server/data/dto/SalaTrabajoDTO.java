package es.deusto.spq.server.data.dto;

import java.io.Serializable;

public class SalaTrabajoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cod_sala;
	private String ubicacion;
	private int numMaxUsuarios;
	
	public int getCod_sala() {
		return cod_sala;
	}
	public void setCod_sala(int cod_sala) {
		this.cod_sala = cod_sala;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getNumMaxUsuarios() {
		return numMaxUsuarios;
	}
	public void setNumMaxUsuarios(int numMaxUsuarios) {
		this.numMaxUsuarios = numMaxUsuarios;
	}
	@Override
	public String toString() {
		return "Ubicacion: " + ubicacion
				+"\n" + "Límite de Usuarios:" + numMaxUsuarios;
	}

}
