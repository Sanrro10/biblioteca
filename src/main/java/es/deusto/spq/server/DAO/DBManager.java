package es.deusto.spq.server.DAO;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.glassfish.grizzly.http.server.HttpServer;

import es.deusto.spq.server.data.*;


public class DBManager {	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
//			SalaTrabajo sala1 = new SalaTrabajo(1, "Piso 1", 4);
//			if(instance.getSala(1)==null) {
				instance.initializeData();
//			}
			
		}		
		
		return instance;
	}
	
	
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an object: " + object);
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	public void storeObjectInDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	

	public void store(Usuario user) {
		DBManager.getInstance().storeObjectInDB(user);	
	}
	public void store(Solicitud solicitud) {
		DBManager.getInstance().storeObjectInDB(solicitud);	
	}
	
	public void store(Libro libro) {
		DBManager.getInstance().storeObjectInDB(libro);	
	}

	public void store(SalaTrabajo sala) {
		DBManager.getInstance().storeObjectInDB(sala);
	}
	public void store(ReservaSala rsala) {
		DBManager.getInstance().storeObjectInDB(rsala);
	}
	public void store(ReservaLibro rlibro) {
		DBManager.getInstance().storeObjectInDB(rlibro);
	}
	
	
	public void delete(Usuario user) {
		DBManager.getInstance().deleteObjectFromDB(user);	
	}
	public void delete(Solicitud solicitud) {
		DBManager.getInstance().deleteObjectFromDB(solicitud);	
	}

	public void delete(Libro libro) {
		DBManager.getInstance().deleteObjectFromDB(libro);	
	}

	public void delete(SalaTrabajo sala) {
		DBManager.getInstance().deleteObjectFromDB(sala);
	}
	public void delete(ReservaSala rsala) {
		DBManager.getInstance().deleteObjectFromDB(rsala);
	}
	public void delete(ReservaLibro rlibro) {
		DBManager.getInstance().deleteObjectFromDB(rlibro);
	}
	
	
	public void update(Usuario user) {
		Usuario user2 = getUsuario(user.getEmail());
		delete(user2);
		store(user);	
	}

	public void update(Libro libro) {
		Libro libro2 = getLibro(libro.getCod_Libro());
		delete(libro2);
		store(libro);
	}

	public void update(SalaTrabajo sala) {
		SalaTrabajo sala2 = getSala(sala.getCod_sala());
		delete(sala2);
		store(sala);
	}
	public void update(ReservaSala rsala) {
		ReservaSala rsala2 = getReserva_Sala(rsala.getCod_Reserva_Sala());
		delete(rsala2);
		store(rsala);
	}
	public void update(ReservaLibro rlibro) {
		ReservaLibro rlibro2 = getReserva_Libro(rlibro.getEmail());
		delete(rlibro2);
		store(rlibro);
	}

	public Libro getLibro(int cod_Libro) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Libro libro = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_Libro == '" + cod_Libro + "'");
			query.setUnique(true);
			libro = (Libro) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el libro de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return libro;
	}
	public Solicitud getSolicitud(int codigoS) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Solicitud solicitud = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE codigoS == '" + codigoS + "'");
			query.setUnique(true);
			solicitud = (Solicitud) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el libro de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return solicitud;
	}
	public Usuario getUsuario(String email) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario user = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			user = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el sala de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return user;
	}
	public SalaTrabajo getSala(int cod_sala) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		SalaTrabajo sala = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_sala == '" + cod_sala + "'");
			query.setUnique(true);
			sala = (SalaTrabajo) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo la sala de trabajo de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return sala;
	}
	public ReservaLibro getReserva_Libro(String email) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		ReservaLibro reservaLibro = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			reservaLibro = (ReservaLibro) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo la reserva de libro de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return reservaLibro;
	}
	public ReservaSala getReserva_Sala (int cod_Reserva_Sala) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		ReservaSala reservaSala = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_Reserva_Sala == '" + cod_Reserva_Sala + "'");
			query.setUnique(true);
			reservaSala = (ReservaSala) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el libro de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return reservaSala;
	}

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);

			for (Usuario usuario : extent) {
				usuarios.add(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;		
	}
	public List<Solicitud> getSolicitudes() {
		List<Solicitud> solicitudes = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<Solicitud> extent = pm.getExtent(Solicitud.class, true);

			for (Solicitud solicitud : extent) {
				solicitudes.add(solicitud);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return solicitudes;		
	}	
	public List<Libro> getLibros() {
		List<Libro> libros = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<Libro> extent = pm.getExtent(Libro.class, true);

			for (Libro libro : extent) {
				libros.add(libro);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return libros;		
	}
	public List<SalaTrabajo> getSalaTrabajos() {
		List<SalaTrabajo> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<SalaTrabajo> extent = pm.getExtent(SalaTrabajo.class, true);

			for (SalaTrabajo sala : extent) {
				salas.add(sala);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return salas;		
	}
	public List<ReservaLibro> getReserva_Libros() {
		List<ReservaLibro> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<ReservaLibro> extent = pm.getExtent(ReservaLibro.class, true);

			for (ReservaLibro sala : extent) {
				salas.add(sala);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return salas;		
	}
	public List<ReservaSala> getReserva_Salas() {
		List<ReservaSala> rsalas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<ReservaSala> extent = pm.getExtent(ReservaSala.class, true);

			for (ReservaSala rsala : extent) {
				rsalas.add(rsala);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return rsalas;		
	}

	
	
	public void initializeData() {
		System.out.println(" * Initializing data base");
		Calendar c = Calendar.getInstance();
		Usuario u1 = new Usuario("a@a.com", "a", "a", 942687531, "123", false);
		Usuario g1 = new Usuario("gestor1@biblioteca.com", "Marcos", "Perez", 945167382, "root", true);
		Libro el_Quijote = new Libro(1, "Don Quijote de la Mancha", "Miguel de Cervantes", "Novela hitórica", 30);
		Libro el_Señor_de_los_anillos = new Libro(2, "El Señor de los Anillos", "J. R. R. Tolkien", "Novela fantástica", 25);
		SalaTrabajo sala1 = new SalaTrabajo(1, "Piso 1", 4);
		SalaTrabajo sala2 = new SalaTrabajo(2, "Piso 1", 5);
		SalaTrabajo sala3 = new SalaTrabajo(3, "Piso 2", 4);
		SalaTrabajo sala4 = new SalaTrabajo(4, "Piso 2", 5);
		SalaTrabajo sala5 = new SalaTrabajo(5, "Piso 3", 10);
		
		try {
			store(u1);
			store(g1);
			store(el_Quijote);
			store(el_Señor_de_los_anillos);
			store(sala1);
			store(sala2);
			store(sala3);
			store(sala4);
			store(sala5);
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}