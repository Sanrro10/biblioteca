package es.deusto.spq.server.data.dto;


import java.io.Serializable;


public class ActividadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	int dia;
	String hora;
	String texto;
	public String toString() {
		return this.getHora() + ": " + this.texto + "\n" ;
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
