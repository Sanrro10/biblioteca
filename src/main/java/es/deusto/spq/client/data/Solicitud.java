package es.deusto.spq.client.data;

import java.io.Serializable;

public class Solicitud implements Serializable{
	int codigoS;
	String tituloS;
	String autorS;
	String generoS;
	int cantidadS;
	
	public int getCodigoS() {
		return codigoS;
	}
	public void setCodigoS(int codigoS) {
		this.codigoS = codigoS;
	}
	public String getTituloS() {
		return tituloS;
	}
	public void setTituloS(String tituloS) {
		this.tituloS = tituloS;
	}
	public String getAutorS() {
		return autorS;
	}
	public void setAutorS(String autorS) {
		this.autorS = autorS;
	}
	public String getGeneroS() {
		return generoS;
	}
	public void setGeneroS(String generoS) {
		this.generoS = generoS;
	}	
	public int getCantidadS() {
		return cantidadS;
	}
	public void setCantidadS(int cantidadS) {
		this.cantidadS = cantidadS;
	}

	public String toStringResumido() {
		return this.getTituloS() + "  " + this.getAutorS();
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.getTituloS() + "\n" + "Autor: " + this.getAutorS() + "\n" + "Genero: " + this.getGeneroS() + "\n" + "Cantidad: " + this.getCantidadS();
	}
	
	
	
	public Solicitud(int codigoS, String tituloS, String autorS, String generoS, int cantidadS) {
		super();
		this.codigoS = codigoS;
		this.tituloS = tituloS;
		this.autorS = autorS;
		this.generoS = generoS;
		this.cantidadS = cantidadS;
	}
	

}