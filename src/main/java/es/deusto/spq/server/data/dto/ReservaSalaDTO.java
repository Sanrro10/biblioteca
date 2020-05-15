package es.deusto.spq.server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class ReservaSalaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cod_Reserva_Sala;
	private String email;
	private int cod_Sala;
	private Date fecha;
	private String usuariosExtra;
	
	private boolean calefaccion;
	public int getCod_Reserva_Sala() {
		return cod_Reserva_Sala;
	}
	public void setCod_Reserva_Sala(int cod_Reserva_Sala) {
		this.cod_Reserva_Sala = cod_Reserva_Sala;
	}
	public ReservaSalaDTO(int cod_Reserva_Sala, String email, int cod_Sala, Date fecha, boolean calefaccion, String usuariosExtra) {
		super();
		this.cod_Reserva_Sala = cod_Reserva_Sala;
		this.email = email;
		this.cod_Sala = cod_Sala;
		this.fecha = fecha;
		this.calefaccion = calefaccion;
		this.usuariosExtra = usuariosExtra;
	}
	public String getUsuariosExtra() {
		return usuariosExtra;
	}
	public void setUsuariosExtra(String usuariosExtra) {
		this.usuariosExtra = usuariosExtra;
	}
	public ReservaSalaDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
