package es.deusto.spq.BD;
import java.sql.Connection;
import java.util.Date;
import java.util.Locale;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.deusto.spq.base.Gestor;
import es.deusto.spq.base.Libro;
import es.deusto.spq.base.Reserva;
import es.deusto.spq.base.Usuario;
 
public class Conexion {
    private static String url = "jdbc:sqlite:BibliotecaBD.db";
    private static Connection conexion = null;
    
    public static Connection conectar() {
    	if (conexion!=null) return conexion;
    	try {
    		conexion = DriverManager.getConnection(url);
    		log( Level.INFO, "Conectada base de datos BibliotecaBD", null );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            log( Level.WARNING, "Error en la conexi�n a la base de datos BibliotecaBD", null );
        }  
        return conexion;
    }
    


    public static ArrayList<Libro> cogerLibros(){
        ArrayList<Libro> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Libro, Titulo, Autor, Genero, Reserva_Max FROM Libro";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Libro l1 = new Libro();
            	l1.setCod_Libro(rs.getInt("Cod_Libro"));
            	l1.setTitulo(rs.getString("Titulo"));
            	l1.setAutor(rs.getString("Autor"));
            	l1.setGenero(rs.getString("Genero"));
            	l1.setReserva_Max(rs.getInt("Reserva_Max"));
                a1.add(l1);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return a1;
        
    }
    public static ArrayList<Reserva> cogerReservas() throws ParseException{
        ArrayList<Reserva> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Reserva, Cod_Usuario, Cod_Libro, Fecha_Devolucion FROM Reserva";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Reserva r1 = new Reserva();
            	r1.setCod_Reserva(rs.getInt("Cod_Reserva"));
            	r1.setCod_Usuario(rs.getInt("Cod_Usuario"));
            	r1.setCod_Libro(rs.getInt("Cod_Libro"));
            	DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            	r1.setFecha_Devolución(dateFormat.parse(rs.getString("Fecha_Devolucion")));
                a1.add(r1);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return a1;
        
    }
    public static ArrayList<Usuario> cogerUsuarios(){
        ArrayList<Usuario> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Usuario, email, Nombre, Apellidos, Telefono, Contrasenya FROM Usuario";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
            	Usuario u1 = new Usuario();
            	u1.setCod_Usuario(rs.getInt("Cod_Usuario"));
            	u1.setEmail(rs.getString("email"));
            	u1.setNombre(rs.getString("Nombre"));
            	u1.setApellidos(rs.getString("Apellidos"));
            	u1.setTelefono(rs.getInt("Telefono"));
            	u1.setContrasenya(rs.getString("Contrasenya"));
                a1.add(u1);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return a1;
        
    }
    public static ArrayList<Gestor> cogerGestores(){
        ArrayList<Gestor> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Gestor, email, Nombre, Apellidos, Telefono, Contrasenya FROM Gestor";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
            	Gestor g1 = new Gestor();
            	g1.setCod_Usuario(rs.getInt("Cod_Gestor"));
            	g1.setEmail(rs.getString("email"));
            	g1.setNombre(rs.getString("Nombre"));
            	g1.setApellidos(rs.getString("Apellidos"));
            	g1.setTelefono(rs.getInt("Telefono"));
            	g1.setContrasenya(rs.getString("Contrasenya"));
                a1.add(g1);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return a1;
        
    }
    public static void insertarLibro(Libro l1) { 
  	   Connection conn = conectar();
  	   String sql = "INSERT INTO Libro(Titulo, Autor, Genero, Reserva_Max) VALUES ('" + l1.getTitulo() + "' , '" + l1.getAutor() + "' , '" + l1.getGenero() + "' , '" + l1.getReserva_Max() + "')" ;	   
	  	 try {
	         Statement stmt  = conn.createStatement();
	   	 stmt.executeUpdate(sql);
	        
	    }catch (SQLException e) {
      	   e.printStackTrace();
           System.out.println(e.getMessage());
         }
  	return;
     }
    public static void modificararLibro(Libro l1) { 
   	   Connection conn = conectar();
   	   String sql = "UPDATE Libro SET Titulo = '" + l1.getTitulo() + "', Autor = '" + l1.getAutor() + "', Genero = '" + l1.getGenero() + "', Reserva_Max = " + l1.getReserva_Max() + " WHERE Cod_Libro = " + l1.getCod_Libro();	   
 	  	 try {
 	         Statement stmt  = conn.createStatement();
 	   	 stmt.executeUpdate(sql);
 	        
 	    }catch (SQLException e) {
       	   e.printStackTrace();
            System.out.println(e.getMessage());
          }
   	return;
      }
    
    
    public static void insertarReserva(Reserva reserva) { 
   	   Connection conn = conectar();
   	   String sql = "INSERT INTO Reserva (Cod_Usuario, Cod_Libro, Fecha_Devolucion) VALUES ('" + reserva.getCod_Usuario() + "' , '" + reserva.getCod_Libro() + "' , '" + reserva.getFecha_Devolución() + "')" ;	   
 	  	 try {
 	         Statement stmt  = conn.createStatement();
 	   	 stmt.executeUpdate(sql);
 	        
 	    }catch (SQLException e) {
       	   e.printStackTrace();
            System.out.println(e.getMessage());
          }
   	return;
      }
     public static void borrarLibro(Libro l1) { 
  	   Connection conn = conectar();
  	   String sql = "DELETE FROM Libro WHERE Cod_Libro ='" + l1.getCod_Libro() + "'";	   
         try {
              Statement stmt  = conn.createStatement();
        	 stmt.executeUpdate(sql);
             
         } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
         }
  	return;
     }
     public static void borrarReserva(Reserva r1) { 
    	   Connection conn = conectar();
    	   String sql = "DELETE FROM Reserva WHERE Cod_Libro ='" + r1.getCod_Libro() + "'";	   
           try {
                Statement stmt  = conn.createStatement();
          	 stmt.executeUpdate(sql);
               
           } catch (SQLException e) {
          	e.printStackTrace();
              System.out.println(e.getMessage());
           }
    	return;
       }
     public static void insertarUsuario(Usuario u1) { 
    	   Connection conn = conectar();
    	   String sql = "INSERT INTO USUARIO (email, Nombre, Apellidos, Telefono, Contrasenya) VALUES ('"  + u1.getEmail() + "' , '" + u1.getNombre() + "' , '" + u1.getApellidos() + "' , '" + u1.getTelefono() + "' , '" + u1.getContrasenya() + "')" ;	   
           try {
                Statement stmt  = conn.createStatement();
                stmt.executeUpdate(sql);
               
           } catch (SQLException e) {
        	  e.printStackTrace();
              System.out.println(e.getMessage());
           }
    	return;
       }
    
    private static Logger logger = null;

    private static void log( Level level, String msg, Throwable excepcion ) {
        if (logger==null) {  
            logger = Logger.getLogger( conexion.getClass().getName() );  
            logger.setLevel( Level.ALL );  
            try {
                
                logger.addHandler( new FileHandler( "bd.log.xml", true ) );  
            } catch (Exception e) {
                logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
            }
        }
        if (excepcion==null)
            logger.log( level, msg );
        else
            logger.log( level, msg, excepcion );
    }
    	
    

}