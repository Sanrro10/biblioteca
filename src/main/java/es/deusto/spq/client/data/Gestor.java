package es.deusto.spq.client.data;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Gestor extends Usuario {

	public Gestor() {
		super();
	}
	public Gestor(String email, String nombre, String apellidos, int telefono, String contrasenya) {
		super(email, nombre, apellidos, telefono, contrasenya);
		// TODO Auto-generated constructor stub
	}
}
