package base;

import java.util.Date;

public class Reserva {

	int cod_Reserva;
	int cod_Usuario;
	int cod_Libro;
	Date fecha_Devolución;
	public Reserva(int cod_Reserva, int cod_Usuario, int cod_Libro, Date fecha_Devolución) {
		super();
		this.cod_Reserva = cod_Reserva;
		this.cod_Usuario = cod_Usuario;
		this.cod_Libro = cod_Libro;
		this.fecha_Devolución = fecha_Devolución;
	}
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	public int getCod_Reserva() {
		return cod_Reserva;
	}
	public void setCod_Reserva(int cod_Reserva) {
		this.cod_Reserva = cod_Reserva;
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
