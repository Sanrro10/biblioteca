package es.deusto.spq.client.data;

import java.io.Serializable;
import java.util.Date;

public class ReservaSala implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cod_Reserva_Sala;
	private int cod_Usuario;
	private int cod_Sala;
	private Date fecha;
	
	private boolean calefaccion;
	public int getCod_Reserva_Sala() {
		return cod_Reserva_Sala;
	}
	public void setCod_Reserva_Sala(int cod_Reserva_Sala) {
		this.cod_Reserva_Sala = cod_Reserva_Sala;
	}
	public int getCod_Usuario() {
		return cod_Usuario;
	}
	public void setCod_Usuario(int cod_Usuario) {
		this.cod_Usuario = cod_Usuario;
	}
	public int getCod_Sala() {
		return cod_Sala;
	}
	public void setCod_Sala(int cod_Sala) {
		this.cod_Sala = cod_Sala;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isCalefaccion() {
		return calefaccion;
	}
	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}
	

}
