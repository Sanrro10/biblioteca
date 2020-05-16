package es.deusto.spq.server.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.swing.JOptionPane;

import es.deusto.spq.server.DAO.DBManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase ReservaLibro en el Servidor.
 * Como se utiliza en el intercambio de información entre el lado servidor y la BD es persistente
 *@author isanr
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class ReservaLibro {

	@PrimaryKey
	int cod_Reserva_Libro;
	
	String email;
	int cod_Libro;
	Date fecha_Devolución;
	int estado_Libro;
	
	public static ArrayList<Integer> lista = new ArrayList<>();
	
	
	public ReservaLibro(int cod_Reserva_Libro, String email, int cod_Libro, Date fecha_Devolución, int estado_Libro) {
		super();
		this.cod_Reserva_Libro = cod_Reserva_Libro;
		this.email = email;
		this.cod_Libro = cod_Libro;
		this.fecha_Devolución = fecha_Devolución;
		this.estado_Libro = estado_Libro;
	}
	public int getEstado_Libro() {
		return estado_Libro;
	}
	public void setEstado_Libro(int estado_Libro) {
		this.estado_Libro = estado_Libro;
	}
	public ReservaLibro() {
		
		
	}
	public ArrayList<Integer> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Integer> lista) {
		this.lista = lista;
	}
	public int getCod_Reserva_Libro() {
		return cod_Reserva_Libro;
	}
	public void setCod_Reserva_Libro(int cod_Reserva_Libro) {
		this.cod_Reserva_Libro = cod_Reserva_Libro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String cod_Usuario) {
		this.email = cod_Usuario;
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
		
	
