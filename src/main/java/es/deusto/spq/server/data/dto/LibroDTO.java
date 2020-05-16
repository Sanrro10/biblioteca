package es.deusto.spq.server.data.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase LibroDTO en el Servidor.
 * Equivalente a Libro en Cliente.
 * Como se utiliza en el intercambio de información entre el lado servidor y el cliente, implementa serializable
 *@author isanr kevin31000
 */
public class LibroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cod_Libro;
	private String titulo;
	private String autor;
	private String genero;
	private int reserva_Max;

	public int getCod_Libro() {
		return cod_Libro;
	}

	public void setCod_Libro(int cod_Libro) {
		this.cod_Libro = cod_Libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getReserva_Max() {
		return reserva_Max;
	}

	public void setReserva_Max(int reserva_Max) {
		this.reserva_Max = reserva_Max;
	}
	public String toStringResumido() {
		return this.getTitulo() + "  " + this.getAutor();
	}
	public String toString() {
		return "Título: " + this.getTitulo() + "\n" + "Autor: " + this.getAutor() + "\n" + "Genero: " + this.getGenero() + "\n" + "Reserva hasta: " + new SimpleDateFormat("dd-MM-yyyy").format(this.fechaReserva());
	}
	public Date fechaReserva() {
		Date today = new Date();
		 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, this.getReserva_Max());
		 
		// convert calendar to date
		Date fecha = cal.getTime();
		return  fecha;
	}

	

}
