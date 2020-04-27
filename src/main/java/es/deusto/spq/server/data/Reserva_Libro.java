package es.deusto.spq.server.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.spq.server.DAO.DBManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Reserva_Libro {

	int cod_Reserva_Libro;
	int cod_Usuario;
	int cod_Libro;
	Date fecha_Devolución;
	
	public static ArrayList<Integer> lista = new ArrayList<>();
	
	
	public Reserva_Libro(int cod_Reserva_Libro, int cod_Usuario, int cod_Libro, Date fecha_Devolución) {
		super();
		this.cod_Reserva_Libro = cod_Reserva_Libro;
		this.cod_Usuario = cod_Usuario;
		this.cod_Libro = cod_Libro;
		this.fecha_Devolución = fecha_Devolución;
	}
	public Reserva_Libro() {
		
		
		
		
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
	public int getCod_Usuario() {
		return cod_Usuario;
	}
	public void setCod_Usuario(int cod_Usuario) {
		this.cod_Usuario = cod_Usuario;
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
		
	
