package es.deusto.spq.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class VentanaGestor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private JButton buttonLibros = new JButton();
	private JButton buttonReservas = new JButton();
	private JButton buttonUsuarios = new JButton();
	private JButton buttonHistorial = new JButton();
	private JLabel labelBackGround = new JLabel();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");

	public VentanaGestor(int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(79, 28, 309, 42);

		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(new Color(0, 102, 204));
		buttonAtras.setForeground(Color.WHITE);

		buttonAtras.setBounds(45, 297, 140, 28);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);
		buttonLibros.setBackground(SystemColor.inactiveCaptionBorder);

		buttonLibros.setBounds(45, 139, 140, 52);
		buttonLibros.setText("Gestion de libros");
		contentpane.add(buttonLibros);

		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca
				.setIcon(new ImageIcon(VentanaGestor.class.getResource("/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 414, 95);
		contentpane.add(labelBiblioteca);
		buttonReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Retrasos retrasos = new Retrasos(750, 422);

				retrasos.setVisible(true);

				VentanaGestor.this.dispose();
				
				
			}
		});
		buttonReservas.setBackground(SystemColor.inactiveCaptionBorder);

		buttonReservas.setBounds(226, 139, 140, 52);
		buttonReservas.setText("Retrasos y sanciones");
		contentpane.add(buttonReservas);
		buttonUsuarios.setBackground(SystemColor.inactiveCaptionBorder);

		buttonUsuarios.setBounds(45, 213, 140, 52);
		buttonUsuarios.setText("Gestion usuarios");
		contentpane.add(buttonUsuarios);
		buttonHistorial.setBackground(SystemColor.inactiveCaptionBorder);

		buttonHistorial.setBounds(226, 213, 140, 52);
		buttonHistorial.setText("Historial y calificaciones");
		contentpane.add(buttonHistorial);

		labelBackGround.setIcon(new ImageIcon(VentanaGestor.class.getResource("/images/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(431, 394);
		setTitle("Area gestor");

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				InicioSesion inicio = new InicioSesion(750, 422);

				inicio.setVisible(true);

				VentanaGestor.this.dispose();

			}
		});

		buttonLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaLibros ventanaLibros = new VentanaLibros(750, 422);

				ventanaLibros.setVisible(true);

				VentanaGestor.this.dispose();

			}
		});

		setLocationRelativeTo(null);
	}
}
