package es.deusto.spq.base;

public class SalaTrabajo {
	
	int cod_sala;
	int num_sala;
	String ubicacion;
	
	public SalaTrabajo(int cod_sala, int num_sala, String ubicacion) {
		super();
		this.cod_sala = cod_sala;
		this.num_sala = num_sala;
		this.ubicacion = ubicacion;
	}

	public int getCod_sala() {
		return cod_sala;
	}

	public void setCod_sala(int cod_sala) {
		this.cod_sala = cod_sala;
	}

	public int getNum_sala() {
		return num_sala;
	}

	public void setNum_sala(int num_sala) {
		this.num_sala = num_sala;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "SalaTrabajo [cod_sala=" + cod_sala + ", num_sala=" + num_sala + ", ubicacion=" + ubicacion + "]";
	}
	
	
	
	
	

}
