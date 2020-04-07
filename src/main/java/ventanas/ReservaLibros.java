package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.BD.Conexion;
import es.deusto.spq.base.Libro;
import es.deusto.spq.base.Reserva;
import es.deusto.spq.base.Usuario;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextPane;

public class ReservaLibros extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private JButton buttonLibros = new JButton();
	private JButton buttonUsuarios = new JButton();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JButton btnReservarLibro = new JButton();
	private final JLabel LabelBackground = new JLabel("");
	private final JTextPane txtpnDatos = new JTextPane();
	

	public ReservaLibros (int altura, int anchura, final Usuario user) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JButton btnMiCuenta = new JButton();
		btnMiCuenta.setText("Mi cuenta");
		btnMiCuenta.setBackground(SystemColor.inactiveCaption);
		btnMiCuenta.setBounds(45, 139, 161, 42);
		contentpane.add(btnMiCuenta);
		
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);
		
		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));
		
		buttonAtras.setBounds(45, 407, 161, 28);
		buttonAtras.setText("Cerrar sesion");
		contentpane.add(buttonAtras);
		buttonLibros.setBackground(SystemColor.inactiveCaption);
		
		buttonLibros.setBounds(45, 229, 161, 42);
		buttonLibros.setText("Mis libros");
		contentpane.add(buttonLibros);
		
		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca.setIcon(new ImageIcon(VentanaGestor.class.getResource("/es/deusto/spq/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);
		buttonUsuarios.setBackground(SystemColor.inactiveCaption);
		
		buttonUsuarios.setBounds(45, 315, 161, 42);
		buttonUsuarios.setText("Mi historial");
		contentpane.add(buttonUsuarios);
		btnReservarLibro.setText("Reservar libro");
		btnReservarLibro.setForeground(Color.WHITE);
		btnReservarLibro.setBackground(new Color(0, 102, 204));
		btnReservarLibro.setBounds(260, 376, 213, 28);
		
		contentpane.add(btnReservarLibro);
		LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/es/deusto/spq/images/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 106, 213, 251);
		contentpane.add(scrollPane);
		
		final JComboBox comboBox = new JComboBox();
		final ArrayList<Libro> libros = Conexion.cogerLibros();
		ArrayList<Reserva> reservas = Conexion.cogerReservas();
		ArrayList<Integer> cods_Libro = new ArrayList<>();
		for(int i = 0; i<reservas.size(); i++) {
			cods_Libro.add(reservas.get(i).getCod_Libro());
		}
		for(int i = 0; i<libros.size(); i++) {
			if(!cods_Libro.contains(libros.get(i).getCod_Libro())) {
				comboBox.addItem(libros.get(i).toStringResumido());
			}	  
		}try {
			for(int i = 0; i<libros.size(); i++) {
				if((comboBox.getSelectedItem().equals((libros.get(i).toStringResumido())))) {
					txtpnDatos.setText(libros.get(i).toString());
				}	  
			}
			
		} catch (java.lang.NullPointerException e) {
			txtpnDatos.setText("No hay libros disponibles");
		}
		
		scrollPane.setColumnHeaderView(comboBox);
		
		
		scrollPane.setViewportView(txtpnDatos);

		
		contentpane.add(LabelBackground);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area usuario");
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					txtpnDatos.setText(comboBox.getSelectedItem().toString());
				} catch (java.lang.NullPointerException e) {
					txtpnDatos.setText("No hay libros disponibles");
				}
				
			}
			
		});
		btnReservarLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reserva reserva = new Reserva();
				Libro libro = libros.get(comboBox.getSelectedIndex());
				reserva.setCod_Libro(libro.getCod_Libro());
				reserva.setCod_Usuario(user.getCod_Usuario()); //Poner aquí el código del usuario que le llegue del inicio de sesión
				reserva.setFecha_Devolución(libro.fechaReserva());
				Conexion.insertarReserva(reserva);
				comboBox.remove(comboBox.getSelectedIndex());
				comboBox.revalidate();
				try {
					for(int i = 0; i<libros.size(); i++) {
						if((comboBox.getSelectedItem().equals((libros.get(i).toStringResumido())))) {
							txtpnDatos.setText(libros.get(i).toString());
						}	  
					}
					
				} catch (java.lang.NullPointerException a) {
					txtpnDatos.setText("No hay libros disponibles");
				}
				comboBox.repaint();
				txtpnDatos.repaint();
				contentpane.repaint();
			}
		});
		
		buttonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InicioSesion inicio = new InicioSesion(750, 422); 

				inicio.setVisible(true);
				
				ReservaLibros.this.dispose();
				
			}
		});
		
		setLocationRelativeTo(null);
	}
}