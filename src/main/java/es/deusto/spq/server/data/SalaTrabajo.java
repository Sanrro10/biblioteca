package es.deusto.spq.server.data;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class SalaTrabajo {

	@PrimaryKey
	int cod_sala;
	
	String ubicacion;
	int numMaxUsuarios;

	public SalaTrabajo(int cod_sala,  String ubicacion, int numMaxUsuarios) {
		super();
		this.cod_sala = cod_sala;
		this.ubicacion = ubicacion;
		this.numMaxUsuarios = numMaxUsuarios;
	}

	public SalaTrabajo() {
		// TODO Auto-generated constructor stub
	}

	public int getCod_sala() {
		return cod_sala;
	}

	public void setCod_sala(int cod_sala) {
		this.cod_sala = cod_sala;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getNumMaxUsuarios() {
		return numMaxUsuarios;
	}

	public void setNumMaxUsuarios(int numMaxUsuarios) {
		this.numMaxUsuarios = numMaxUsuarios;
	}
	public String toCombo() {
		return "SalaTrabajo" + cod_sala ;
	}

	@Override
	public String toString() {
		return "Ubicacion: " + ubicacion
				+"\n" + "Límite de Usuarios:" + numMaxUsuarios;
	}

}
