package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Gestor extends JFrame{
	
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

	public Gestor (int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		buttonAtras.setBounds(100, 300, 100, 20);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);
		
		buttonLibros.setBounds(200, 100, 140, 20);
		buttonLibros.setText("Gestion libros");
		contentpane.add(buttonLibros);

		buttonReservas.setBounds(400, 100, 140, 20);
		buttonReservas.setText("Gestion reservas");
		contentpane.add(buttonReservas);
		
		buttonUsuarios.setBounds(200, 200, 140, 20);
		buttonUsuarios.setText("Gestion usuarios");
		contentpane.add(buttonUsuarios);
		
		buttonHistorial.setBounds(400, 200, 140, 20);
		buttonHistorial.setText("Historial de libros");
		contentpane.add(buttonHistorial);
		
		labelBackGround.setIcon(new ImageIcon(InicioSesion.class.getResource("/images/background.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(altura, anchura);
		setTitle("Area gestor");
		
		buttonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gestor.this.dispose();
				
			}
		});
		
	}

}
