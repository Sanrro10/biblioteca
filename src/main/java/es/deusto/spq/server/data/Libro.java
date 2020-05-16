package es.deusto.spq.server.data;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Clase Libro en el Servidor.
 * Como se utiliza en el intercambio de información entre el lado servidor y la BD es persistente
 *@author isanr
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Libro {

	public Libro(int cod_Libro, String titulo, String autor, String genero, int reserva_Max) {
		super();
		this.cod_Libro = cod_Libro;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.reserva_Max = reserva_Max;
	}
	public Libro() {
		// TODO Auto-generated constructor stub
	}
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
	public Date fechaReserva() {
		Date today = new Date();
		 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, this.getReserva_Max());
		 
		// convert calendar to date
		Date fecha = cal.getTime();
		return  fecha;
	}
	@PrimaryKey
	int cod_Libro;
	
	String titulo;
	String autor;
	String genero;
	int reserva_Max;
	public String toStringResumido() {
		return this.getTitulo() + "  " + this.getAutor();
	}
	public String toString() {
		return "Título: " + this.getTitulo() + "\n" + "Autor: " + this.getAutor() + "\n" + "Genero: " + this.getGenero() + "\n" + "Reserva hasta: " + new SimpleDateFormat("dd-MM-yyyy").format(this.fechaReserva());
	}

}
