package base;

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
	int cod_Libro;
	String titulo;
	String autor;
	String genero;
	int reserva_Max;

}
