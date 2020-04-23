package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ComboBoxModel;
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
import es.deusto.spq.base.Reserva_Libro;
import es.deusto.spq.base.Usuario;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ReservaLibros extends JFrame {

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
	private final JButton btnReservarSala = new JButton();
	private final JLabel LabelBackground = new JLabel("");
	private final JTextPane txtpnDatos = new JTextPane();

	public ReservaLibros(int altura, int anchura, final Usuario user) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		

		
		JLabel lblNewLabel_3 = new JLabel("Género:");
		lblNewLabel_3.setBounds(45, 165, 60, 25);
		contentpane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Autor:");
		lblNewLabel_2.setBounds(45, 204, 60, 14);
		contentpane.add(lblNewLabel_2);
		
		JComboBox comboBox_Genero = new JComboBox();
		comboBox_Genero.setBounds(96, 167, 139, 20);
		comboBox_Genero.addItem(" ");
		comboBox_Genero.addItem("Terror");
		comboBox_Genero.addItem("Fantasía");
		comboBox_Genero.addItem("Ciencia ficción");
		comboBox_Genero.addItem("Novela negra");
		comboBox_Genero.addItem("Aventura");
		comboBox_Genero.addItem("Romance");
		comboBox_Genero.addItem("Infantil");
		comboBox_Genero.addItem("Arte");
		contentpane.add(comboBox_Genero);
		
		JLabel lblNewLabel_1 = new JLabel("Filtrar por:");
		lblNewLabel_1.setBounds(45, 140, 89, 14);
		contentpane.add(lblNewLabel_1);

		JButton btnMiCuenta = new JButton();
		btnMiCuenta.setText("Mi cuenta");
		btnMiCuenta.setBackground(SystemColor.inactiveCaption);
		btnMiCuenta.setBounds(45, 266, 190, 28);
		contentpane.add(btnMiCuenta);

		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);

		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));

		buttonAtras.setBounds(45, 407, 190, 28);
		buttonAtras.setText("Cerrar sesion");
		contentpane.add(buttonAtras);
		buttonLibros.setBackground(SystemColor.inactiveCaption);

		buttonLibros.setBounds(45, 305, 190, 25);
		buttonLibros.setText("Mis libros");
		contentpane.add(buttonLibros);

		JLabel labelBiblioteca = new JLabel("");
		// labelBiblioteca.setIcon(new
		// ImageIcon(VentanaGestor.class.getResource("/azul.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);
		buttonUsuarios.setBackground(SystemColor.inactiveCaption);

		buttonUsuarios.setBounds(45, 341, 190, 28);
		buttonUsuarios.setText("Mi historial");
		contentpane.add(buttonUsuarios);

		btnReservarLibro.setText("Reservar libro");
		btnReservarLibro.setForeground(Color.WHITE);
		btnReservarLibro.setBackground(new Color(0, 102, 204));
		btnReservarLibro.setBounds(260, 376, 213, 28);
		contentpane.add(btnReservarLibro);

		btnReservarSala.setText("Reservar Sala");
		btnReservarSala.setForeground(Color.WHITE);
		btnReservarSala.setBackground(new Color(0, 102, 204));
		btnReservarSala.setBounds(260, 410, 213, 28);
		contentpane.add(btnReservarSala);

		// LabelBackground.setIcon(new
		// ImageIcon(ReservaLibros.class.getResource("/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 106, 213, 251);
		contentpane.add(scrollPane);

		final JComboBox<String> comboBox = new JComboBox();
		final ArrayList<Libro> libros = Conexion.cogerLibros();
		ArrayList<Libro> libros2 = new ArrayList<>();
		ArrayList<Reserva_Libro> reserva_Libros = Conexion.cogerReserva_Libros();
		ArrayList<Integer> cods_Libro = new ArrayList<>();
		for (int i = 0; i < reserva_Libros.size(); i++) {
			cods_Libro.add(reserva_Libros.get(i).getCod_Libro());
		}
		for (int i = 0; i < libros.size(); i++) {
			if (!cods_Libro.contains(libros.get(i).getCod_Libro())) {
				comboBox.addItem(libros.get(i).toStringResumido());
				libros2.add(libros.get(i));
			}
		}
		try {
			for (int i = 0; i < libros.size(); i++) {
				if ((comboBox.getSelectedItem().equals((libros.get(i).toStringResumido())))) {
					txtpnDatos.setText(libros.get(i).toString());
				}
			}

		} catch (java.lang.NullPointerException e) {
			txtpnDatos.setText("No hay libros disponibles");
		}ComboBoxModel modelo = comboBox.getModel();

		scrollPane.setColumnHeaderView(comboBox);

		scrollPane.setViewportView(txtpnDatos);
		
		//Combobox que saca los autores
		JComboBox comboBox_Autor = new JComboBox();
		comboBox_Autor.setBounds(96, 201, 139, 20);
		ArrayList<String> autores = new ArrayList<>();
		autores.add(" ");
		comboBox_Autor.addItem(" ");
		
		for (int i = 0; i < libros2.size(); i++) {
			if(!autores.contains(libros2.get(i).getAutor())) {
				comboBox_Autor.addItem(libros2.get(i).getAutor());
				autores.add(libros2.get(i).getAutor());
				}
		}
	
		contentpane.add(comboBox_Autor);

		contentpane.add(LabelBackground);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area usuario");
		
		comboBox_Genero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAllItems();
				if(comboBox_Genero.getSelectedIndex()!= 0) {
					for (int i = 0; i < libros2.size(); i++) {
						if(libros2.get(i).getGenero().toString().equals(comboBox_Genero.getSelectedItem()) && (libros2.get(i).getAutor().toString().equals(comboBox_Autor.getSelectedItem()) | comboBox_Autor.getSelectedItem().equals(" "))) {
								comboBox.addItem(libros2.get(i).toStringResumido());								
							}
						}
				}else {
					for (int i = 0; i < libros2.size(); i++) {
						if(libros2.get(i).getAutor().toString().equals(comboBox_Autor.getSelectedItem()) | comboBox_Autor.getSelectedItem().equals(" ")) {
								comboBox.addItem(libros2.get(i).toStringResumido());
					
					}
				}
				comboBox.revalidate();
				comboBox.repaint();
				try {
					txtpnDatos.setText(libros2.get(comboBox.getSelectedIndex()).toString());
				} catch (java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException e) {
					txtpnDatos.setText("No hay libros disponibles");
				}

			}
			}
		});
		comboBox_Autor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAllItems();
				if(comboBox_Autor.getSelectedIndex()!= 0) {
					for (int i = 0; i < libros2.size(); i++) {
						if(libros2.get(i).getAutor().toString().equals(comboBox_Autor.getSelectedItem()) && (libros2.get(i).getGenero().toString().equals(comboBox_Genero.getSelectedItem()) | comboBox_Genero.getSelectedItem().equals(" "))) {
								comboBox.addItem(libros2.get(i).toStringResumido());
						}
					}
				}else {
					for (int i = 0; i < libros2.size(); i++) {
						if(libros2.get(i).getGenero().toString().equals(comboBox_Genero.getSelectedItem()) | comboBox_Genero.getSelectedItem().equals(" ")) {
								comboBox.addItem(libros2.get(i).toStringResumido());
						}
					}
				}
				comboBox.revalidate();
				comboBox.repaint();
				try {
					txtpnDatos.setText(libros2.get(comboBox.getSelectedIndex()).toString());
				} catch (java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException e) {
					txtpnDatos.setText("No hay libros disponibles");
				}

			}

		});
		
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					txtpnDatos.setText(libros2.get(comboBox.getSelectedIndex()).toString());
				} catch (java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException e) {
					txtpnDatos.setText("No hay libros disponibles");
				}

			}
		});
		btnReservarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Reserva_Libro reserva_Libro = new Reserva_Libro();
				Libro libro = libros.get(comboBox.getSelectedIndex());
				reserva_Libro.setCod_Libro(libro.getCod_Libro());
				reserva_Libro.setCod_Usuario(user.getCod_Usuario()); // Poner aquí el código del usuario que le llegue del
																// inicio de sesión
				reserva_Libro.setFecha_Devolución(libro.fechaReserva());
				Conexion.insertarReserva_Libro(reserva_Libro);
				comboBox.remove(comboBox.getSelectedIndex());
				comboBox.setSelectedIndex(0);
				comboBox.revalidate();
				try {
					for (int i = 0; i < libros.size(); i++) {
						if ((comboBox.getSelectedItem().equals((libros.get(i).toStringResumido())))) {
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

		btnReservarSala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CalendarioSalas calendario;
				try {
					calendario = new CalendarioSalas(850, 522, user);
					calendario.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ReservaLibros.this.dispose();

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