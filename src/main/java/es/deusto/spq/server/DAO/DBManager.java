package es.deusto.spq.server.DAO;

import java.awt.print.Printable;
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
import es.deusto.spq.server.data.dto.SolicitudDTO;

/**
 * Clase DBManager en el Servidor.
 * Se encarga de la gestión de la BD
 *@author isanr
 */
public class DBManager {	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	private static boolean inicializado = false;
	
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	/**
	  * Método para obtener la instancia del DBManager. 
	  * En caso de no existir la crea
	  * Si ya existe la devuelve
	  *
	  * @return la instancia de DBManager
	  */
	public static DBManager getInstance() {
//		if (instance == null) {
			instance = new DBManager();	
//			System.out.println("Nuevo DBManager");
//		}
	if(!inicializado) {
			inicializado = true;
			instance.deleteData();
			instance.initializeData();
			
	}
		
		return instance;
	}
	
	/**
	  * Método para borrar un objeto de la BD
	  * @param object Object a borrar en la BD
	   */
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			
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
	}/**
	  * Método para borrar los objetos de la BD
	   */
	public void deleteData() {
		deleteUsuarios();
		deleteLibros();
		deleteReserva_Libros();
		deleteReserva_Salas();
		deleteSalaTrabajos();
		deleteSolicitudes();
		deleteActividades();
		
	}
	/**
	  * Método para insertar un objeto de la BD
	  * @param object Object a insertar en la BD
	   */
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
			System.out.println("Object:" + object);
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	/**
	  * Método para insertar un Usuario de la BD
	  * Para ello llama a storeObjectInDB
	  * @param user Usuario a insertar en la BD
	   */
	public void store(Usuario user) {
		DBManager.getInstance().storeObjectInDB(user);	
	}
	/**
	  * Método para insertar una Actividad de la BD
	  * Para ello llama a storeObjectInDB
	  * @param actividad Actividad a insertar en la BD
	   */
	public void store(Actividad actividad) {
		DBManager.getInstance().storeObjectInDB(actividad);	
	}
	/**
	  * Método para insertar una Solicitud de la BD
	  * Para ello llama a storeObjectInDB
	  * @param solicitud Solicitud a insertar en la BD
	   */
	public void store(Solicitud solicitud) {
		DBManager.getInstance().storeObjectInDB(solicitud);	
	}
	/**
	  * Método para insertar un Libro de la BD
	  * Para ello llama a storeObjectInDB
	  * @param libro Libro a insertar en la BD
	   */
	public void store(Libro libro) {
		DBManager.getInstance().storeObjectInDB(libro);	
	}
	/**
	  * Método para insertar una SalaTrabajo de la BD
	  * Para ello llama a storeObjectInDB
	  * @param sala SalaTrabajo a insertar en la BD
	   */
	public void store(SalaTrabajo sala) {
		DBManager.getInstance().storeObjectInDB(sala);
	}
	/**
	  * Método para insertar una ReservaSala de la BD
	  * Para ello llama a storeObjectInDB
	  * @param rsala ReservaSala a insertar en la BD
	   */
	public void store(ReservaSala rsala) {
		DBManager.getInstance().storeObjectInDB(rsala);
	}
	/**
	  * Método para insertar un ReservaLibro de la BD
	  * Para ello llama a storeObjectInDB
	  * @param rlibro ReservaLibro a insertar en la BD
	   */
	public void store(ReservaLibro rlibro) {
		DBManager.getInstance().storeObjectInDB(rlibro);
	}
	/**
	  * Método para borrar un Usuario de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param user Usuario a borrar en la BD
	   */
	public void delete(Usuario user) {
		DBManager.getInstance().deleteObjectFromDB(user);	
	}
	/**
	  * Método para borrar una Actividad de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param actividad Actividad a borrar en la BD
	   */
	public void delete(Actividad actividad) {
		DBManager.getInstance().deleteObjectFromDB(actividad);	
	}
	/**
	  * Método para borrar una Solicitud de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param solicitud Solicitud a borrar en la BD
	   */
	public void delete(Solicitud solicitud) {
		DBManager.getInstance().deleteObjectFromDB(solicitud);	
	}
	/**
	  * Método para borrar un Libro de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param libro Libro a borrar en la BD
	   */
	public void delete(Libro libro) {
		DBManager.getInstance().deleteObjectFromDB(libro);	
	}
	/**
	  * Método para borrar una SalaTrabajo de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param sala SalaTrabajo a borrar en la BD
	   */
	public void delete(SalaTrabajo sala) {
		DBManager.getInstance().deleteObjectFromDB(sala);
	}
	/**
	  * Método para borrar una ReservaSala de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param rsala ReservaSala a borrar en la BD
	   */
	public void delete(ReservaSala rsala) {
		DBManager.getInstance().deleteObjectFromDB(rsala);
	}
	/**
	  * Método para borrar una ReservaLibro de la BD
	  * Para ello llama a deleteObjectFromDB
	  * @param rlibro ReservaLibro a borrar en la BD
	   */
	public void delete(ReservaLibro rlibro) {
		DBManager.getInstance().deleteObjectFromDB(rlibro);
	}
	
	/**
	  * Método para actualizar un Usuario de la BD
	  * Para ello llama a getUsuario, lo borra con delete() e inserta el nuevo con store()
	  * @param user Usuario a actualizar en la BD
	   */
	public void update(Usuario user) {
		Usuario user2 = getUsuario(user.getEmail());
		if (user2!=null) {
			System.out.println(user2.getNombre()+user2.getApellidos()+user2.getEmail());
			delete(user2);
			store(user);
		}	
	}
	/**
	  * Método para actualizar un Libro de la BD
	  * Para ello llama a getLibro, lo borra con delete() e inserta el nuevo con store()
	  * @param libro Libro a actualizar en la BD
	   */
	public void update(Libro libro) {
		Libro libro2 = getLibro(libro.getCod_Libro());
		if (libro2!=null) {
		delete(libro2);
		store(libro);
		}
	}
	/**
	  * Método para actualizar una SalaTrabajo de la BD
	  * Para ello llama a getSala, la borra con delete() e inserta la nueva con store()
	  * @param sala SalaTrabajo a actualizar en la BD
	   */
	public void update(SalaTrabajo sala) {
		SalaTrabajo sala2 = getSala(sala.getCod_sala());
		if (sala2!=null) {
		delete(sala2);
		store(sala);
		}
	}
	/**
	  * Método para actualizar una ReservaSala de la BD
	  * Para ello llama a getReserva_Sala, la borra con delete() e inserta la nueva con store()
	  * @param rsala ReservaSala a actualizar en la BD
	   */
	public void update(ReservaSala rsala) {
		ReservaSala rsala2 = getReserva_Sala(rsala.getCod_Reserva_Sala());
		if (rsala2!=null) {
		delete(rsala2);
		store(rsala);
		}
	}
	/**
	  * Método para actualizar una ReservaLibro de la BD
	  * Para ello llama a getReserva_Libro, la borra con delete() e inserta la nueva con store()
	  * @param rlibro ReservaLibro a actualizar en la BD
	   */	
	public void update(ReservaLibro rlibro) {
		ReservaLibro rlibro2 = getReserva_Libro(rlibro.getCod_Reserva_Libro());
		if (rlibro2!=null) {
		delete(rlibro2);
		store(rlibro);
		}
	}

	/**
	  * Método para coger un Libro de la BD
	  * @param cod_Libro Código del Libro a coger de la BD
	  * @return el Libro a devolver
	   */
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
	/**
	  * Método para coger una Solicitud de la BD
	  * @param codigoS Código de la Solicitud a coger de la BD
	  * @return la Solicitud a devolver
	   */
	public Solicitud getSolicitud(int codigoS) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Solicitud solicitud = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Solicitud.class.getName() + " WHERE codigoS == '" + codigoS + "'");
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
	/**
	  * Método para coger un Usuario de la BD
	  * @param email email del Usuario a coger de la BD
	  * @return el Usuario a devolver
	   */
	public Usuario getUsuario(String email) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario user = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			user = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el usuario de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return user;
	}
	/**
	  * Método para coger una SalaTrabajo de la BD
	  * @param cod_sala Código de la SalaTrabajo a coger de la BD
	  * @return la SalaTrabajo a devolver
	   */
	public SalaTrabajo getSala(int cod_sala) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		SalaTrabajo sala = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + SalaTrabajo.class.getName() + " WHERE cod_sala == '" + cod_sala + "'");
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
	/**
	  * Método para coger una ReservaLibro de la BD
	  * @param cod_Reserva_Libro Código de la ReservaLibro a coger de la BD
	  * @return la ReservaLibro a devolver
	   */
	public ReservaLibro getReserva_Libro(int cod_Reserva_Libro) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		ReservaLibro reservaLibro = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + ReservaLibro.class.getName() + " WHERE cod_Reserva_Libro == '" + cod_Reserva_Libro + "'");
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
	/**
	  * Método para coger una ReservaSala de la BD
	  * @param cod_Reserva_Sala Código de la ReservaSala a coger de la BD
	  * @return la ReservaSala a devolver
	   */
	public ReservaSala getReserva_Sala (int cod_Reserva_Sala) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		ReservaSala reservaSala = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + ReservaSala.class.getName() + " WHERE cod_Reserva_Sala == '" + cod_Reserva_Sala + "'");
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

	/**
	  * Método para coger la Lista de Usuarios de la BD
	  * @return la Lista de Usuarios a devolver
	   */
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

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
	/**
	  * Método para coger la Lista de Solicitudes de la BD
	  * @return la Lista de Solicitudes a devolver
	   */
	public List<Solicitud> getSolicitudes() {
		List<Solicitud> solicitudes = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

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
	/**
	  * Método para coger la Lista de libros de la BD
	  * @return la Lista de Libros a devolver
	   */
	public List<Libro> getLibros() {
		List<Libro> libros = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

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
	/**
	  * Método para coger la Lista de SalaTrabajos de la BD
	  * @return la Lista de SalaTrabajos a devolver
	   */
	public List<SalaTrabajo> getSalaTrabajos() {
		List<SalaTrabajo> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

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
	/**
	  * Método para coger la Lista de ReservaLibros de la BD
	  * @return la Lista de ReservaLibros a devolver
	   */
	public List<ReservaLibro> getReserva_Libros() {
		List<ReservaLibro> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

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
	/**
	  * Método para coger la Lista de ReservaSalas de la BD
	  * @return la Lista de ReservaSalas a devolver
	   */
	public List<ReservaSala> getReserva_Salas() {
		List<ReservaSala> rsalas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

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
	/**
	  * Método para coger la Lista de Actividades de la BD
	  * @return la Lista de Actividades a devolver
	   */
	public List<Actividad> getActividades() {
		List<Actividad> actividades = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			
			Extent<Actividad> extent = pm.getExtent(Actividad.class, true);

			for (Actividad rsala : extent) {
				actividades.add(rsala);
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

		return actividades;		
	}
	/**
	  * Método para borrar la Lista de Usuarios de la BD
	   */
	public void deleteUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

			tx.begin();
			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);

			for (Usuario usuario : extent) {
				pm.deletePersistent(usuario);
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
		
	}
	/**
	  * Método para coger la Lista de Solicitudes de la BD
	   */
	public void deleteSolicitudes() {
		List<Solicitud> solicitudes = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

			tx.begin();
			
			Extent<Solicitud> extent = pm.getExtent(Solicitud.class, true);

			for (Solicitud solicitud : extent) {
				pm.deletePersistent(solicitud);
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
	
	}
	/**
	  * Método para borrar los libros de la BD
	   */
	public void deleteLibros() {
		List<Libro> libros = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

			tx.begin();
			
			Extent<Libro> extent = pm.getExtent(Libro.class, true);

			for (Libro libro : extent) {
				pm.deletePersistent(libro);
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
	
	}
	/**
	  * Método para borrar los SalaTrabajos de la BD
	   */
	public void deleteSalaTrabajos() {
		List<SalaTrabajo> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			

			tx.begin();
			
			Extent<SalaTrabajo> extent = pm.getExtent(SalaTrabajo.class, true);

			for (SalaTrabajo sala : extent) {
				pm.deletePersistent(sala);
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
		
	}
	/**
	  * Método para borrar los ReservaLibros de la BD
	   */
	public void deleteReserva_Libros() {
		List<ReservaLibro> salas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			
			Extent<ReservaLibro> extent = pm.getExtent(ReservaLibro.class, true);

			for (ReservaLibro sala : extent) {
				pm.deletePersistent(sala);
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
		
	}
	/**
	  * Método para borrar los ReservaSalas de la BD
	   */
	public void deleteReserva_Salas() {
		List<ReservaSala> rsalas = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			
			Extent<ReservaSala> extent = pm.getExtent(ReservaSala.class, true);

			for (ReservaSala rsala : extent) {
				pm.deletePersistent(rsala);
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
		
	}
	/**
	  * Método para borrar los Actividades de la BD
	   */
	public void deleteActividades() {
		List<Actividad> actividades = new ArrayList<>();		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();
			
			Extent<Actividad> extent = pm.getExtent(Actividad.class, true);

			for (Actividad rsala : extent) {
				pm.deletePersistent(rsala);
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
		
	}

	
	/**
	  * Método para inicializar los datos de la BD
	   */
	public void initializeData() {
		System.out.println(" * Initializing data base");
		Usuario u1 = new Usuario("a@a.com", "a", "a", 942687531, "123", false);
		Usuario g1 = new Usuario("gestor1@biblioteca.com", "Marcos", "Perez", 945167382, "root", true);
		Libro el_Quijote = new Libro(1, "Don Quijote de la Mancha", "Miguel de Cervantes", "Novela hitórica", 30);
		Libro el_Señor_de_los_anillos = new Libro(2, "El Señor de los Anillos", "J. R. R. Tolkien", "Novela fantástica", 25);
		SalaTrabajo sala1 = new SalaTrabajo(1, "Piso 1", 4);
		SalaTrabajo sala2 = new SalaTrabajo(2, "Piso 1", 5);
		SalaTrabajo sala3 = new SalaTrabajo(3, "Piso 2", 4);
		SalaTrabajo sala4 = new SalaTrabajo(4, "Piso 2", 5);
		SalaTrabajo sala5 = new SalaTrabajo(5, "Piso 3", 10);
		Actividad a1 = new Actividad(1, "12:00-13:30", "Cuentacuentos");
		Actividad a2 = new Actividad(2, "12:00-13:30", "Cuentacuentos");
		Actividad a3 = new Actividad(3, "12:00-13:30", "Cuentacuentos");
		Actividad a4 = new Actividad(4, "12:00-13:30", "Cuentacuentos");
		Actividad a5 = new Actividad(5, "12:00-13:30", "Cuentacuentos");
		Actividad a6 = new Actividad(1, "17:00-18:30", "Cuentacuentos");
		Actividad a7 = new Actividad(2, "17:00-18:30", "Cuentacuentos");
		Actividad a8 = new Actividad(3, "17:00-18:30", "Cuentacuentos");
		Actividad a9 = new Actividad(4, "17:00-18:30", "Cuentacuentos");
		Actividad a10 = new Actividad(5, "17:00-18:30", "Cuentacuentos");
		Actividad a11 = new Actividad(6, "10:00-14:00", "Apoyo escolar");
		Actividad a12 = new Actividad(6, "18:00-20:30", "Club del cómic");
		Solicitud solicitud = new Solicitud(0, "El sabueso de los Baskerville", "Arthur Conan Doyle", "Novela policíaca", 2);
		
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
			store(a1);
			store(a2);
			store(a3);
			store(a4);
			store(a5);
			store(a6);
			store(a7);
			store(a8);
			store(a9);
			store(a10);
			store(a11);
			store(a12);
			store(solicitud);
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}