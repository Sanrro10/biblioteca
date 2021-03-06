package es.deusto.spq.client.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.Libro;
import es.deusto.spq.client.data.ReservaLibro;

import java.awt.Font;
import java.awt.SystemColor;

public class AnyadirLibro extends JFrame {

	/**
	 *
	 */

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelDias = new JLabel();
	private JLabel labelNombre = new JLabel();
	private JLabel labelAutor = new JLabel();
	private JLabel labelGenero = new JLabel();
	private JSpinner dias = new JSpinner();
	private JTextField textAutor = new JTextField();
	private JButton buttonAceptar = new JButton();
	private JButton buttonAtras = new JButton();
	private JLabel labelBackGround = new JLabel();
	private JComboBox genero = new JComboBox();
	private JTextField textTitulo = new JTextField();

	public AnyadirLibro(Controller controller) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		labelDias.setFont(new Font("Arial", Font.BOLD, 11));
		labelDias.setText("Dias: ");
		labelDias.setBackground(Color.white);
		labelDias.setOpaque(true);
		labelDias.setBounds(70, 240, 120, 20);
		contentpane.add(labelDias, BorderLayout.SOUTH);

		labelNombre.setFont(new Font("Arial", Font.BOLD, 11));
		labelNombre.setText("Titulo del libro: ");
		labelNombre.setBounds(70, 120, 120, 20);
		labelNombre.setBackground(Color.white);
		labelNombre.setOpaque(true);
		contentpane.add(labelNombre);

		labelAutor.setFont(new Font("Arial", Font.BOLD, 11));
		labelAutor.setText("Autor del libro: ");
		labelAutor.setBounds(70, 160, 120, 20);
		labelAutor.setBackground(Color.white);
		labelAutor.setOpaque(true);
		contentpane.add(labelAutor);

		labelGenero.setFont(new Font("Arial", Font.BOLD, 11));
		labelGenero.setText("Genero del libro: ");
		labelGenero.setBounds(70, 200, 120, 20);
		labelGenero.setBackground(Color.white);
		labelGenero.setOpaque(true);
		contentpane.add(labelGenero);

		buttonAtras.setForeground(SystemColor.text);
		buttonAtras.setBackground(new Color(0, 102, 204));
		buttonAtras.setBounds(55, 270, 143, 32);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);

		buttonAceptar.setForeground(SystemColor.text);
		buttonAceptar.setBackground(new Color(0, 102, 204));
		buttonAceptar.setBounds(214, 270, 143, 32);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);


		genero.setBounds(214, 200, 143, 20);
		genero.addItem("Novela de terror");
		genero.addItem("Ciencia ficcion");
		genero.addItem("Biografia");
		genero.addItem("Novela romantica");
		genero.addItem("Novela historica");
		genero.addItem("Poesia");
		genero.addItem("Literatura infantil");
		contentpane.add(genero);


		dias.setBounds(214, 240, 120, 20);
		contentpane.add(dias);



		textAutor.setBounds(214, 160, 120, 20);
		contentpane.add(textAutor);

		textTitulo.setBounds(214, 120, 120, 20);
		contentpane.add(textTitulo);

		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(92, 28, 309, 42);
		contentpane.add(lblNewLabel);

		JLabel labelBiblioteca = new JLabel("      Biblioteca Deusto");
		labelBiblioteca.setIcon(new ImageIcon(InicioSesion.class.getResource("/azul.jpg")));
		labelBiblioteca.setForeground(SystemColor.text);
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBounds(0, 0, 534, 95);
		contentpane.add(labelBiblioteca);


		labelBackGround.setIcon(new ImageIcon(InicioSesion.class.getResource("/background3.jpg")));
		labelBackGround.setBounds(0, 0, 850, 480);
		contentpane.add(labelBackGround);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 355);
		setTitle("Bilbioteca");

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Libro l1 = new Libro();
				l1.setTitulo(textTitulo.getText());
				l1.setAutor(textAutor.getText());
				l1.setGenero(genero.getSelectedItem().toString());
				l1.setReserva_Max(dias.getComponentCount());
//				Conexion2.insertarLibro(l1);

				AnyadirLibro anyadir;
				try {
					anyadir = new AnyadirLibro(controller);
					anyadir.setVisible(true);

					AnyadirLibro.this.dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}




			}
		});

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaLibros inicio = new VentanaLibros(controller);

				inicio.setVisible(true);

				AnyadirLibro.this.dispose();

			}
		});
		setLocationRelativeTo(null);
	}
}
