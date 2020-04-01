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

public class Retrasos extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JButton btnReservarLibro = new JButton();
	private final JLabel LabelBackground = new JLabel("");
	private final JButton btnBannearUsuario = new JButton();

	public Retrasos (int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		btnBannearUsuario.setText("Bannear usuario");
		btnBannearUsuario.setForeground(Color.WHITE);
		btnBannearUsuario.setBackground(new Color(0, 102, 204));
		btnBannearUsuario.setBounds(158, 357, 132, 28);
		
		contentpane.add(btnBannearUsuario);
		
		JTextPane txtpnAquVaUna = new JTextPane();
		txtpnAquVaUna.setText("Lista de usuarios que se han retrasado junto con el libro que han reservado");
		txtpnAquVaUna.setBounds(53, 139, 391, 184);
		contentpane.add(txtpnAquVaUna);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);
		
		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));
		
		buttonAtras.setBounds(53, 357, 76, 28);
		buttonAtras.setText("Atrás");
		contentpane.add(buttonAtras);
		
		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca.setIcon(new ImageIcon(Gestor.class.getResource("/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);
		btnReservarLibro.setText("Sancionar usuario");
		btnReservarLibro.setForeground(Color.WHITE);
		btnReservarLibro.setBackground(new Color(0, 102, 204));
		btnReservarLibro.setBounds(312, 357, 132, 28);
		
		contentpane.add(btnReservarLibro);
		LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/images/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);
		
		contentpane.add(LabelBackground);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 457);
		setTitle("Area gestor");
		
		buttonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Gestor gestion = new Gestor(750, 422); 

				gestion.setVisible(true);
				
				Retrasos.this.dispose();
				
			}
		});
		
		setLocationRelativeTo(null);
	}
}