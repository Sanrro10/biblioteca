package es.deusto.spq.server.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.swing.JOptionPane;

/**
 * Clase ReservaSala en el Servidor.
 * Como se utiliza en el intercambio de información entre el lado servidor y la BD es persistente
 *@author isanr
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class ReservaSala {

	@PrimaryKey
	int cod_Reserva_Sala;
	
	String email;
	int cod_Sala;
	Date fecha;
	boolean calefaccion;
	private String usuariosExtra;
	public boolean isCalefaccion() {
		return calefaccion;
	}
	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}
	public ReservaSala() {
		super();
	}
	public ReservaSala(int cod_Reserva_Sala, String email, int cod_Sala, Date fecha, boolean calefaccion, String usuariosExtra) {
		super();
		this.cod_Reserva_Sala = cod_Reserva_Sala;
		this.email = email;
		this.cod_Sala = cod_Sala;
		this.calefaccion = calefaccion;
		this.fecha = fecha;
		this.usuariosExtra = usuariosExtra;
	}
	public String getUsuariosExtra() {
		return usuariosExtra;
	}
	public void setUsuariosExtra(String usuariosExtra) {
		this.usuariosExtra = usuariosExtra;
	}
	public int getCod_Reserva_Sala() {
		return cod_Reserva_Sala;
	}
	public void setCod_Reserva_Sala(int cod_Reserva_Sala) {
		this.cod_Reserva_Sala = cod_Reserva_Sala;
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
	
			
}
