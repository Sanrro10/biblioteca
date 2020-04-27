package es.deusto.spq.client.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.swing.JOptionPane;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class ReservaSala {

	@PrimaryKey
	int cod_Reserva_Sala;
	
	int cod_Usuario;
	int cod_Sala;
	Date fecha;
	boolean calefaccion;
	public boolean isCalefaccion() {
		return calefaccion;
	}
	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}
	public ReservaSala() {
		super();
	}
	public ReservaSala(int cod_Reserva_Sala, int cod_Usuario, int cod_Sala, Date fecha, boolean calefaccion) {
		super();
		this.cod_Reserva_Sala = cod_Reserva_Sala;
		this.cod_Usuario = cod_Usuario;
		this.cod_Sala = cod_Sala;
		this.calefaccion = calefaccion;
		this.fecha = fecha;
	}
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
	
			
}
