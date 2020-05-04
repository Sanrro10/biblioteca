package es.deusto.spq.client.data;


import java.io.Serializable;


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
