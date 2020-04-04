package ventanas;

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

public class VentanaLibros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private JButton buttonLibroNuevo = new JButton();
	private JButton buttonModificar = new JButton();
	private JLabel labelBackGround = new JLabel();
	private final JLabel lblNewLabel = new JLabel("Gestion de libros");

	public VentanaLibros(int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNewLabel.setBounds(70, 28, 309, 42);

		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(new Color(0, 102, 204));
		buttonAtras.setForeground(Color.WHITE);

		buttonAtras.setBounds(45, 297, 140, 28);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);
		buttonLibroNuevo.setBackground(SystemColor.inactiveCaptionBorder);

		buttonLibroNuevo.setBounds(45, 139, 140, 52);
		buttonLibroNuevo.setText("Añadir nuevo libro");
		contentpane.add(buttonLibroNuevo);

		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca
				.setIcon(new ImageIcon(Gestor.class.getResource("/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 414, 95);
		contentpane.add(labelBiblioteca);

		buttonModificar.setBounds(45, 213, 140, 52);
		buttonModificar.setText("Modificar estado libros");
		contentpane.add(buttonModificar);

		labelBackGround.setIcon(new ImageIcon(Gestor.class.getResource("/images/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(431, 394);
		setTitle("Gestion libros");

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				InicioSesion inicio = new InicioSesion(750, 422);

				inicio.setVisible(true);

				VentanaLibros.this.dispose();

			}
		});

		buttonLibroNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AnyadirLibro libros = new AnyadirLibro(750, 422);

				libros.setVisible(true);

				VentanaLibros.this.dispose();

			}
		});
		
		buttonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ModificarLibro modificar;
				try {
					
					modificar = new ModificarLibro(750, 422);
					modificar.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				

				VentanaLibros.this.dispose();

			}
		});
	
		setLocationRelativeTo(null);
	}
}
