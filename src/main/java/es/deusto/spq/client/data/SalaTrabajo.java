package es.deusto.spq.client.data;

import java.io.Serializable;

public class SalaTrabajo implements Serializable{
	
	public SalaTrabajo(int cod_sala, String ubicacion, int numMaxUsuarios) {
		super();
		this.cod_sala = cod_sala;
		this.ubicacion = ubicacion;
		this.numMaxUsuarios = numMaxUsuarios;
	}
	public SalaTrabajo() {
		// TODO Auto-generated constructor stub
	}
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
	public String toCombo() {
		return "Sala" + cod_sala ;
	}

	@Override
	public String toString() {
		return "Ubicacion: " + ubicacion
				+"\n" + "Límite de Usuarios:" + numMaxUsuarios;
	}

}
