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

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Actividad {
	public Actividad() {
		super();
	}
	public Actividad(int dia, String hora, String texto) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.texto = texto;
	}
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
