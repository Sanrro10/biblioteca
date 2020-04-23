package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.BD.Conexion;
import es.deusto.spq.base.Libro;
import es.deusto.spq.base.Reserva_Libro;
import es.deusto.spq.base.Usuario;

public class GestorReservas extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JButton btnCancelarReserva = new JButton();
	private final JLabel LabelBackground = new JLabel("");
	private final JTextPane txtpnDatos = new JTextPane();

	public GestorReservas(int altura, int anchura) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);

		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));

		buttonAtras.setBounds(45, 407, 161, 28);
		buttonAtras.setText("Cerrar sesion");
		contentpane.add(buttonAtras);

		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca.setIcon(
				new ImageIcon(VentanaGestor.class.getResource("/azul.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);

		btnCancelarReserva.setText("Eliminar reserva");
		btnCancelarReserva.setForeground(Color.WHITE);
		btnCancelarReserva.setBackground(new Color(0, 102, 204));
		btnCancelarReserva.setBounds(260, 407, 213, 28);

		contentpane.add(btnCancelarReserva);
		LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 106, 450, 280);
		contentpane.add(scrollPane);

		final JComboBox comboBox = new JComboBox();
		final ArrayList<Libro> libros = Conexion.cogerLibros();
		ArrayList<Reserva_Libro> reserva_Libros = Conexion.cogerReserva_Libros();
		ArrayList<Integer> cods_Libro = new ArrayList<>();
		for (int i = 0; i < reserva_Libros.size(); i++) {
			cods_Libro.add(reserva_Libros.get(i).getCod_Libro());
		}
		for (int i = 0; i < libros.size(); i++) {
			if (!cods_Libro.contains(libros.get(i).getCod_Libro())) {
				comboBox.addItem(libros.get(i).toStringResumido());
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
		}

		scrollPane.setColumnHeaderView(comboBox);

		scrollPane.setViewportView(txtpnDatos);

		contentpane.add(LabelBackground);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area gestor");
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
		btnCancelarReserva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Reserva_Libro reserva_Libro = new Reserva_Libro();
				Libro libro = libros.get(comboBox.getSelectedIndex());
				reserva_Libro.setCod_Libro(libro.getCod_Libro());
				Conexion.borrarReserva_Libro(reserva_Libro);
				comboBox.remove(comboBox.getSelectedIndex());
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

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				InicioSesion inicio = new InicioSesion(750, 422);

				inicio.setVisible(true);

				GestorReservas.this.dispose();

			}
		});

		setLocationRelativeTo(null);
	}
}
