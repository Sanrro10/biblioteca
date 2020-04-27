package es.deusto.spq.server.data.dto;

import java.io.Serializable;

public class LibroDTO implements Serializable {

	/**
	 * 
	 */
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

	

}
