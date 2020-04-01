package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	public ReservaLibros (int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JButton btnMiCuenta = new JButton();
		btnMiCuenta.setText("Mi cuenta");
		btnMiCuenta.setBackground(SystemColor.inactiveCaption);
		btnMiCuenta.setBounds(45, 139, 161, 42);
		contentpane.add(btnMiCuenta);
		
		JButton btnVerDescripcin = new JButton();
		btnVerDescripcin.setText("Ver descripción");
		btnVerDescripcin.setForeground(SystemColor.desktop);
		btnVerDescripcin.setBackground(SystemColor.inactiveCaptionBorder);
		btnVerDescripcin.setBounds(271, 368, 183, 28);
		contentpane.add(btnVerDescripcin);
		
		JTextPane txtpnAquVaUna = new JTextPane();
		txtpnAquVaUna.setText("Aquí va una lista de libros disponibles");
		txtpnAquVaUna.setBounds(271, 139, 183, 218);
		contentpane.add(txtpnAquVaUna);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);
		
		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));
		
		buttonAtras.setBounds(45, 407, 161, 28);
		buttonAtras.setText("Cerrar sesión");
		contentpane.add(buttonAtras);
		buttonLibros.setBackground(SystemColor.inactiveCaption);
		
		buttonLibros.setBounds(45, 229, 161, 42);
		buttonLibros.setText("Mis libros");
		contentpane.add(buttonLibros);
		
		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca.setIcon(new ImageIcon(Gestor.class.getResource("/images/065580938b36e4c049ec033745248216.jpg")));
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
		btnReservarLibro.setBounds(271, 407, 183, 28);
		
		contentpane.add(btnReservarLibro);
		LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/images/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);
		
		contentpane.add(LabelBackground);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area gestor");
		
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