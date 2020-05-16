package es.deusto.spq.client.data;


import java.io.Serializable;

/**
 * Clase Actividad en el cliente.
 * Equivalente a ActividadDTO en Server.
 * Como se utiliza en el intercambio de información entre el lado servidor y el cliente, implementa serializable
 *@author isanr
 */
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;
	int dia;
	String hora;
	String texto;
	public String toString() {
		return this.getHora() + ": " + this.texto + "\n" + "\n";
	}
	public Actividad() {
		super();
	}
	public Actividad(int dia, String hora, String texto) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.texto = texto;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
