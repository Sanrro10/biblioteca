package es.deusto.spq.base;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import es.deusto.spq.BD.Conexion;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Reserva {

	int cod_Reserva;
	int cod_Usuario;
	int cod_Libro;
	static Date fecha_Devolución;
	
	public static ArrayList<Integer> lista = new ArrayList<>();
	
	
	public Reserva(int cod_Reserva, int cod_Usuario, int cod_Libro, Date fecha_Devolución) {
		super();
		this.cod_Reserva = cod_Reserva;
		this.cod_Usuario = cod_Usuario;
		this.cod_Libro = cod_Libro;
		this.fecha_Devolución = fecha_Devolución;
	}
	public Reserva() {
		
		
		
		
	}
	public ArrayList<Integer> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Integer> lista) {
		this.lista = lista;
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
	
	
	
public static void main(String[] args) {
	fecha_Devolución = new Date();
	SimpleDateFormat formateador1 =new SimpleDateFormat("dd/MM/yyyy");
	String fechaSistema1 = formateador1.format(fecha_Devolución);
	
	Date fechaActual = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    String fechaSistema=formateador.format(fechaActual);
    
}
		
	String compararFechasConDate(String fecha_Devolución, String fechaActual1) throws ParseException {  
		  System.out.println("Parametro String Fecha 1 = "+fecha_Devolución+"\n" +
		    "Parametro String fechaActual = "+fechaActual1+"\n");  
		  String resultado="";
		  final ArrayList<Reserva> reservas = Conexion.cogerReservas();
		  try {
		   /**Obtenemos las fechas enviadas en el formato a comparar*/
		   SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
		   Date fechaDate1 = formateador.parse(fecha_Devolución);
		   Date fechaDate2 = formateador.parse(fechaActual1);
		    
		   System.out.println("Parametro Date Fecha 1 = "+fechaDate1+"\n" +
		     "Parametro Date fechaActual = "+fechaDate2+"\n");
		    
		    if (fechaDate2.before(fechaDate1) ){
		    	for(int i = 0; i<reservas.size(); i++) {
					lista.add(reservas.get(i).getCod_Libro());
					JOptionPane.showMessageDialog(null, "La reserva a llegado a su limite de tiempo.");
				}
		    }
		    
		  } catch (ParseException e) {
		   System.out.println("Se Produjo un Error!!!  "+e.getMessage());
		  }  
		  return resultado;
		 }
	 
	
	
	
	 
	 }
	
