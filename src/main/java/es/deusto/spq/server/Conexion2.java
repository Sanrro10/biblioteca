package es.deusto.spq.server;
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
import es.deusto.spq.base.Reserva_Libro;
import es.deusto.spq.base.Reserva_Sala;
import es.deusto.spq.base.SalaTrabajo;
import es.deusto.spq.base.Usuario;
 
public class Conexion2 {
    private static Connection conexion = null;
    
    public static Connection conectar() {
        try {
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }

            // Conectamos con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql:BibliotecaBD.db");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }return conexion;
    }    
     
    /**
     * Method to connect to the database by passing parameters.
     * Método para establecer la conexión a la base de datos mediante el paso de parámetros.
     * 
     * @param host <code>String</code> host name or ip. Nombre del host o ip.
     * @param port <code>String</code> listening database port. Puerto en el que escucha la base de datos.
     * @param database <code>String</code> database name for the connection. Nombre de la base de datos para la conexión.
     * @param user <code>String</code> user name. Nombre de usuario.
     * @param password  <code>String</code> user password. Password del usuario.
     */
    public void connectDatabase(String host, String port, String database,
            String user, String password) {
        String url = null;
        try {
            // We register the MySQL driver
            // Registramos el driver de MySQL
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            Connection connection = null;
            url ="jdbc:mysql://" + host + ":" + port + "/" + database;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    url,
                    user, password);           
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error al conectar con la base de datos de MySQL (" + url + "): " + sqle);
        }
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
    public static ArrayList<Reserva_Sala> cogerReserva_Salas() throws ParseException{
        ArrayList<Reserva_Sala> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Reserva, Cod_Usuario, Cod_Sala, Fecha, Calefaccion FROM Reserva_Sala";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Reserva_Sala r1 = new Reserva_Sala();
            	r1.setCod_Reserva_Sala(rs.getInt("Cod_Reserva"));
            	r1.setCod_Usuario(rs.getInt("Cod_Usuario"));
            	r1.setCod_Sala(rs.getInt("Cod_Sala"));
            	DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            	r1.setFecha(dateFormat.parse(rs.getString("Fecha")));
                a1.add(r1);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return a1;
        
    }
    public static ArrayList<Reserva_Libro> cogerReserva_Libros() throws ParseException{
        ArrayList<Reserva_Libro> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Reserva, Cod_Usuario, Cod_Libro, Fecha_Devolucion FROM Reserva_Libro";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Reserva_Libro r1 = new Reserva_Libro();
            	r1.setCod_Reserva_Libro(rs.getInt("Cod_Reserva"));
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
    public static ArrayList<SalaTrabajo> cogerSalas(){
        ArrayList<SalaTrabajo> a1 = new ArrayList<>();
    	
    	String sql = "SELECT Cod_Sala, Ubicacion, Usuarios FROM Sala";
    	Connection conn = conectar();
        try (Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
            	SalaTrabajo s1 = new SalaTrabajo();
            	s1.setCod_sala(rs.getInt("Cod_Sala"));
            	s1.setUbicacion(rs.getString("Ubicacion"));
            	s1.setNumMaxUsuarios(rs.getInt("Usuarios"));
                a1.add(s1);
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
    
    
    public static void insertarReserva_Libro(Reserva_Libro reserva) { 
   	   Connection conn = conectar();
   	   String sql = "INSERT INTO Reserva_Libro (Cod_Usuario, Cod_Libro, Fecha_Devolucion) VALUES ('" + reserva.getCod_Usuario() + "' , '" + reserva.getCod_Libro() + "' , '" + reserva.getFecha_Devolución() + "')" ;	   
 	  	 try {
 	         Statement stmt  = conn.createStatement();
 	   	 stmt.executeUpdate(sql);
 	        
 	    }catch (SQLException e) {
       	   e.printStackTrace();
            System.out.println(e.getMessage());
          }
   	return;
      }
    public static void insertarReserva_Sala(Reserva_Sala reserva) { 
    	   Connection conn = conectar();
    	   String sql = "INSERT INTO Reserva_Sala (Cod_Usuario, Cod_Sala, Fecha, Calefaccion) VALUES ('" + reserva.getCod_Usuario() + "' , '" + reserva.getCod_Sala() + "' , '" + reserva.getFecha() + "' , '" + reserva.isCalefaccion() +"')" ;	   
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
     public static void borrarReserva_Libro(Reserva_Libro r1) { 
    	   Connection conn = conectar();
    	   String sql = "DELETE FROM Reserva_Libro WHERE Cod_Libro ='" + r1.getCod_Libro() + "'";	   
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