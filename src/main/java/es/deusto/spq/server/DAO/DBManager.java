package es.deusto.spq.server.DAO;

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

import es.deusto.spq.client.base.Gestor;
import es.deusto.spq.client.base.Libro;
import es.deusto.spq.client.base.Reserva_Libro;
import es.deusto.spq.client.base.Reserva_Sala;
import es.deusto.spq.client.base.SalaTrabajo;
import es.deusto.spq.client.base.Usuario;

public class DBManager {	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
			instance.initializeData();
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
	
	public void store(Gestor gestor) {
		DBManager.getInstance().storeObjectInDB(gestor);	
	}

	public void store(Libro libro) {
		DBManager.getInstance().storeObjectInDB(libro);	
	}

	public void store(SalaTrabajo sala) {
		DBManager.getInstance().storeObjectInDB(sala);
	}
	public void store(Reserva_Sala rsala) {
		DBManager.getInstance().storeObjectInDB(rsala);
	}
	public void store(Reserva_Libro rlibro) {
		DBManager.getInstance().storeObjectInDB(rlibro);
	}
	
	
	public void delete(Usuario user) {
		DBManager.getInstance().deleteObjectFromDB(user);	
	}
	
	public void delete(Gestor gestor) {
		DBManager.getInstance().deleteObjectFromDB(gestor);	
	}

	public void delete(Libro libro) {
		DBManager.getInstance().deleteObjectFromDB(libro);	
	}

	public void delete(SalaTrabajo sala) {
		DBManager.getInstance().deleteObjectFromDB(sala);
	}
	public void delete(Reserva_Sala rsala) {
		DBManager.getInstance().deleteObjectFromDB(rsala);
	}
	public void delete(Reserva_Libro rlibro) {
		DBManager.getInstance().deleteObjectFromDB(rlibro);
	}
	
	
	public void update(Usuario user) {
		Usuario user2 = getUsuario(""+user.getCod_Usuario());
		delete(user2);
		store(user);	
	}
	
	public void update(Gestor gestor) {
		Gestor gestor2 = getGestor(""+gestor.getCod_Usuario());
		delete(gestor2);
		store(gestor);
	}

	public void update(Libro libro) {
		Libro libro2 = getLibro(""+libro.getCod_Libro());
		delete(libro2);
		store(libro);
	}

	public void update(SalaTrabajo sala) {
		SalaTrabajo sala2 = getSala(""+sala.getCod_sala());
		delete(sala2);
		store(sala);
	}
	public void update(Reserva_Sala rsala) {
		Reserva_Sala rsala2 = getReserva_Sala(""+rsala.getCod_Usuario());
		delete(rsala2);
		store(rsala);
	}
	public void update(Reserva_Libro rlibro) {
		Reserva_Libro rlibro2 = getReserva_Libro(""+rlibro.getCod_Reserva_Libro());
		delete(rlibro2);
		store(rlibro);
	}

	public Libro getLibro(String cod_Libro) {		
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
	public Usuario getUsuario(String cod_Usuario) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario sala = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_Usuario == '" + cod_Usuario + "'");
			query.setUnique(true);
			sala = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el sala de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return sala;
	}
	public Gestor getGestor(String cod_Usuario) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Gestor gestor = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_Usuario == '" + cod_Usuario + "'");
			query.setUnique(true);
			gestor = (Gestor) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el gestor de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return gestor;
	}
	public SalaTrabajo getSala(String cod_sala) {		
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
	public Reserva_Libro getReserva_Libro(String cod_Reserva_Libro) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Reserva_Libro reserva_Libro = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_Reserva_Libro == '" + cod_Reserva_Libro + "'");
			query.setUnique(true);
			reserva_Libro = (Reserva_Libro) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo la reserva de libro de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return reserva_Libro;
	}
	public Reserva_Sala getReserva_Sala (String cod_Reserva_Sala) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Reserva_Sala reserva_Sala = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Libro.class.getName() + " WHERE cod_Reserva_Sala == '" + cod_Reserva_Sala + "'");
			query.setUnique(true);
			reserva_Sala = (Reserva_Sala) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el libro de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return reserva_Sala;
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
	public List<Gestor> getGestores() {
		List<Gestor> gestores = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<Gestor> extent = pm.getExtent(Gestor.class, true);

			for (Gestor gestor : extent) {
				gestores.add(gestor);
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

		return gestores;		
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
	public List<Reserva_Libro> getReserva_Libros() {
		List<Reserva_Libro> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<Reserva_Libro> extent = pm.getExtent(Reserva_Libro.class, true);

			for (Reserva_Libro sala : extent) {
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
	public List<Reserva_Sala> getReserva_Salas() {
		List<Reserva_Sala> rsalas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			System.out.println("  * Retrieving all the flights");

			tx.begin();
			
			Extent<Reserva_Sala> extent = pm.getExtent(Reserva_Sala.class, true);

			for (Reserva_Sala rsala : extent) {
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

	
	
	private void initializeData() {
		System.out.println(" * Initializing data base");
		Calendar c = Calendar.getInstance();
		Usuario u1 = new Usuario(1, "a@a.com", "a", "a", 942687531, "123");
		Gestor g1 = new Gestor(1, "gestor1@biblioteca.com", "Marcos", "Perez", 945167382, "root");
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