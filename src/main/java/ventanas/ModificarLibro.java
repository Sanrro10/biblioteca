package ventanas;


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

import BD.Conexion;
import base.Libro;
import base.Reserva;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JCheckBox;

public class ModificarLibro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelTitulo = new JLabel();
	private JLabel labelLibro = new JLabel();
	private JLabel labelAutor = new JLabel();
	private JLabel labelGenero = new JLabel();
	private JSpinner dias = new JSpinner();
	private JTextField textNombre = new JTextField();
	private JTextField textAutor = new JTextField();
	private JButton buttonAceptar = new JButton();
	private JButton buttonAtras = new JButton();
	private JLabel labelBackGround = new JLabel();
	private JLabel labelDias = new JLabel();
	private JComboBox genero = new JComboBox();
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Eliminar Libro");

	private JComboBox comboBox = new JComboBox();
	private JTextField textTitulo = new JTextField();

	public ModificarLibro(int altura, int anchura) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 11));
		labelTitulo.setText("Título: ");
		labelTitulo.setBackground(Color.white);
		labelTitulo.setOpaque(true);
		labelTitulo.setBounds(70, 158, 120, 20);
		contentpane.add(labelTitulo, BorderLayout.SOUTH);
		
		labelLibro.setFont(new Font("Arial", Font.BOLD, 11));
		labelLibro.setText("Libro a modificar: ");
		labelLibro.setBounds(70, 116, 120, 20);
		labelLibro.setBackground(Color.white);
		labelLibro.setOpaque(true);
		contentpane.add(labelLibro);
		
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
		buttonAtras.setBounds(10, 313, 143, 32);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);
		
		buttonAceptar.setForeground(SystemColor.text);
		buttonAceptar.setBackground(new Color(0, 102, 204));
		buttonAceptar.setBounds(163, 313, 143, 32);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);
		

		genero.setBounds(214, 240, 143, 20);
		genero.addItem("Novela de terror");
		genero.addItem("Ciencia ficcion");
		genero.addItem("Biografia");
		genero.addItem("Novela romantica");
		genero.addItem("Novela historica");
		genero.addItem("Poesia");
		genero.addItem("Literatura infantil");
		contentpane.add(genero);
		

		dias.setBounds(214, 282, 120, 20);
		contentpane.add(dias);
		final ArrayList<Libro> libros = Conexion.cogerLibros();
		ArrayList<Integer> cods_Libro = new ArrayList<>();
		for(int i = 0; i<libros.size(); i++) {
			cods_Libro.add(libros.get(i).getCod_Libro());
		}
		for(int i = 0; i<libros.size(); i++) {
				comboBox.addItem(cods_Libro.get(i));
			}	  
		
		
		
		textAutor.setBounds(214, 200, 120, 20);
		contentpane.add(textAutor);
		comboBox.setBounds(214, 116, 120, 20);
		contentpane.add(comboBox);
		
		labelDias.setText("Dias: ");
		labelDias.setOpaque(true);
		labelDias.setFont(new Font("Arial", Font.BOLD, 11));
		labelDias.setBackground(Color.WHITE);
		labelDias.setBounds(70, 282, 120, 20);
		contentpane.add(labelDias);
		
		textTitulo.setBounds(214, 158, 120, 20);
		contentpane.add(textTitulo);
		
		chckbxNewCheckBox.setBounds(322, 318, 97, 23);
		contentpane.add(chckbxNewCheckBox);
		
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
		setSize(441, 395);
		setTitle("Bilbioteca");

		buttonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Libro l1 = new Libro();
				l1.setCod_Libro((int) comboBox.getSelectedItem());
				if(!chckbxNewCheckBox.isSelected()) {
					if(textTitulo.getText().isEmpty() || textAutor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Compruebe los datos introducidos ");
					}else {
						l1.setTitulo(textTitulo.getText());
						l1.setAutor(textAutor.getText());
						l1.setReserva_Max((int) dias.getValue());
						Conexion.modificararLibro(l1);
					}
					
				}else{
					Conexion.borrarLibro(l1);
				}

				ModificarLibro inicio;
				try {
					inicio = new ModificarLibro(750, 422);
					inicio.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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

