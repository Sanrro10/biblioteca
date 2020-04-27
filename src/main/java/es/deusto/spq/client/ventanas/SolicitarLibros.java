package es.deusto.spq.client.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.BD.Conexion;
import es.deusto.spq.client.data.Solicitud;

public class SolicitarLibros extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelTituloS = new JLabel();
	private JLabel labelAutorS = new JLabel();
	private JLabel labelGeneroS = new JLabel();
	private JSpinner cantidadS = new JSpinner();
	private JTextField textAutorS = new JTextField();
	private JButton buttonSolicitar = new JButton();
	private JButton buttonAtras = new JButton();
	private JLabel labelBackGround = new JLabel();
	private JLabel labelCantidadS = new JLabel();
	private JComboBox generoS = new JComboBox();
	private JTextField textTituloS = new JTextField();

	public SolicitarLibros(int altura, int anchura) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		labelTituloS.setFont(new Font("Arial", Font.BOLD, 11));
		labelTituloS.setText("Título: ");
		labelTituloS.setBackground(Color.white);
		labelTituloS.setOpaque(true);
		labelTituloS.setBounds(70, 116, 120, 20);
		contentpane.add(labelTituloS, BorderLayout.SOUTH);
		
		
		labelAutorS.setFont(new Font("Arial", Font.BOLD, 11));
		labelAutorS.setText("Autor del libro: ");
		labelAutorS.setBounds(70, 158, 120, 20);
		labelAutorS.setBackground(Color.white);
		labelAutorS.setOpaque(true);
		contentpane.add(labelAutorS);
		
		labelGeneroS.setFont(new Font("Arial", Font.BOLD, 11));
		labelGeneroS.setText("Genero del libro: ");
		labelGeneroS.setBounds(70, 200, 120, 20);
		labelGeneroS.setBackground(Color.white);
		labelGeneroS.setOpaque(true);
		contentpane.add(labelGeneroS);
		
		buttonAtras.setForeground(SystemColor.text);
		buttonAtras.setBackground(new Color(0, 102, 204));
		buttonAtras.setBounds(10, 313, 143, 32);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);
		
		buttonSolicitar.setForeground(SystemColor.text);
		buttonSolicitar.setBackground(new Color(0, 102, 204));
		buttonSolicitar.setBounds(263, 313, 143, 32);
		buttonSolicitar.setText("Solicitar");
		contentpane.add(buttonSolicitar);
		

		generoS.setBounds(214, 200, 120, 20);
		generoS.addItem("Novela de terror");
		generoS.addItem("Ciencia ficcion");
		generoS.addItem("Biografia");
		generoS.addItem("Novela romantica");
		generoS.addItem("Novela historica");
		generoS.addItem("Poesia");
		generoS.addItem("Literatura infantil");
		contentpane.add(generoS);
		

		cantidadS.setBounds(214, 240, 143, 20);
		contentpane.add(cantidadS);
		
		textAutorS.setBounds(214, 158, 120, 20);
		contentpane.add(textAutorS);
		
		labelCantidadS.setText("Cantidad: ");
		labelCantidadS.setOpaque(true);
		labelCantidadS.setFont(new Font("Arial", Font.BOLD, 11));
		labelCantidadS.setBackground(Color.WHITE);
		labelCantidadS.setBounds(70, 240, 120, 20);
		contentpane.add(labelCantidadS);
		
		textTituloS.setBounds(214, 116, 120, 20);
		contentpane.add(textTituloS);
		
		
		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(92, 28, 309, 42);
		contentpane.add(lblNewLabel);
		
		JLabel labelBiblioteca = new JLabel("      Biblioteca Deusto");
		labelBiblioteca.setIcon(new ImageIcon(InicioSesion.class.getResource("/es/deusto/spq/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(SystemColor.text);
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBounds(0, 0, 534, 95);
		contentpane.add(labelBiblioteca);
		
		
		labelBackGround.setIcon(new ImageIcon(InicioSesion.class.getResource("/es/deusto/spq/images/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 395);
		setTitle("Bilbioteca");
		
		buttonSolicitar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Solicitud so1 = new Solicitud();
				so1.setTituloS(textTituloS.getText());
				so1.setAutorS(textAutorS.getText());
				so1.setGeneroS(generoS.getSelectedItem().toString());
				so1.setCantidadS(cantidadS.getComponentCount());
				Conexion.insertarSolicitud(so1);
				
				SolicitarLibros solicitar;
				try {
					solicitar = new SolicitarLibros(750, 422);
					solicitar.setVisible(true);
					
					SolicitarLibros.this.dispose();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				
				
				
			}
		});

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaLibros inicio = new VentanaLibros(750, 422);

				inicio.setVisible(true);

				SolicitarLibros.this.dispose();

			}
		});
		setLocationRelativeTo(null);
	}
}
