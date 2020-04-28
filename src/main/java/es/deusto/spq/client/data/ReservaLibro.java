package es.deusto.spq.client.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ReservaLibro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<Integer> lista = new ArrayList<>();

	private int cod_Reserva_Libro;
	private String email;
	private int cod_Libro;
	private Date fecha_Devolución;

	public int getCod_Reserva_Libro() {
		return cod_Reserva_Libro;
	}

	public void setCod_Reserva_Libro(int cod_Reserva_Libro) {
		this.cod_Reserva_Libro = cod_Reserva_Libro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCod_Libro() {
		return cod_Libro;
	}

	public void setCod_Libro(int cod_Libro) {
		this.cod_Libro = cod_Libro;
	}

	public Date getFecha_Devolución() {
		return fecha_Devolución;
	}

	public void setFecha_Devolución(Date fecha_Devolución) {
		this.fecha_Devolución = fecha_Devolución;
	}

}
