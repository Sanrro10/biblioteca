package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.SystemColor;

public class ModificarLibro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelUsuario = new JLabel();
	private JLabel labelNombre = new JLabel();
	private JLabel labelAutor = new JLabel();
	private JLabel labelGenero = new JLabel();
	private JTextField textUsuario = new JTextField();
	private JTextField textNombre = new JTextField();
	private JTextField textAutor = new JTextField();
	private JButton buttonAceptar = new JButton();
	private JButton buttonAtras = new JButton();
	private JLabel labelBackGround = new JLabel();
	private JComboBox genero = new JComboBox();

	public ModificarLibro(int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		labelUsuario.setFont(new Font("Arial", Font.BOLD, 11));
		labelUsuario.setText("Usuario: ");
		labelUsuario.setBackground(Color.white);
		labelUsuario.setOpaque(true);
		labelUsuario.setBounds(70, 120, 120, 20);
		contentpane.add(labelUsuario, BorderLayout.SOUTH);
		
		labelNombre.setFont(new Font("Arial", Font.BOLD, 11));
		labelNombre.setText("Titulo del libro: ");
		labelNombre.setBounds(70, 160, 120, 20);
		labelNombre.setBackground(Color.white);
		labelNombre.setOpaque(true);
		contentpane.add(labelNombre);
		
		labelAutor.setFont(new Font("Arial", Font.BOLD, 11));
		labelAutor.setText("Autor del libro: ");
		labelAutor.setBounds(70, 200, 120, 20);
		labelAutor.setBackground(Color.white);
		labelAutor.setOpaque(true);
		contentpane.add(labelAutor);
		
		labelGenero.setFont(new Font("Arial", Font.BOLD, 11));
		labelGenero.setText("Genero del libro: ");
		labelGenero.setBounds(70, 240, 120, 20);
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
		
		genero = new JComboBox();
		genero.setBounds(214, 240, 143, 20);
		genero.addItem("Novela de terror");
		genero.addItem("Ciencia ficcion");
		genero.addItem("Biografia");
		genero.addItem("Novela romantica");
		genero.addItem("Novela historica");
		genero.addItem("Poesia");
		genero.addItem("Literatura infantil");
		contentpane.add(genero);
		

		textUsuario.setBounds(214, 120, 143, 20);
		contentpane.add(textUsuario);

		textNombre.setBounds(214, 160, 143, 20);
		contentpane.add(textNombre);
		
		textAutor.setBounds(214, 200, 143, 20);
		contentpane.add(textAutor);
		
		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(92, 28, 309, 42);
		contentpane.add(lblNewLabel);
		
		JLabel labelBiblioteca = new JLabel("      Biblioteca Deusto");
		labelBiblioteca.setIcon(new ImageIcon(InicioSesion.class.getResource("/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(SystemColor.text);
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBounds(0, 0, 534, 95);
		contentpane.add(labelBiblioteca);
		
		
		labelBackGround.setIcon(new ImageIcon(InicioSesion.class.getResource("/images/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 355);
		setTitle("Bilbioteca");

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				AnyadirLibro anyadir = new AnyadirLibro(750, 422); 

				anyadir.setVisible(true);
				
				ModificarLibro.this.dispose();
				
				
			}
		});

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaLibros inicio = new VentanaLibros(750, 422);

				inicio.setVisible(true);

				ModificarLibro.this.dispose();

			}
		});
		setLocationRelativeTo(null);
	}
}



