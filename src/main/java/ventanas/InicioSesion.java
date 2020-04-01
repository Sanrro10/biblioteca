package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.Conexion;
import com.example.Usuario;
import java.awt.Font;
import java.awt.SystemColor;

public class InicioSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelUser = new JLabel();
	private JLabel labelPass = new JLabel();
	private JTextField textUser = new JTextField();
	private JTextField textPass = new JTextField();
	private JButton buttonAceptar = new JButton();
	private JButton buttonRegistrar = new JButton();
	private JLabel labelBackGround = new JLabel();

	public InicioSesion(int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		labelUser.setFont(new Font("Arial", Font.BOLD, 11));

		labelUser.setText(" Nombre de usuario:");
		labelUser.setBackground(Color.white);
		labelUser.setOpaque(true);
		labelUser.setBounds(70, 134, 120, 20);
		contentpane.add(labelUser, BorderLayout.SOUTH);
		labelPass.setFont(new Font("Arial", Font.BOLD, 11));

		labelPass.setText(" Contraseña:");
		labelPass.setBounds(70, 188, 120, 20);
		labelPass.setBackground(Color.white);
		labelPass.setOpaque(true);
		contentpane.add(labelPass);
		buttonAceptar.setForeground(SystemColor.text);
		buttonAceptar.setBackground(new Color(0, 102, 204));

		buttonAceptar.setBounds(214, 243, 143, 32);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);

		buttonRegistrar.setBounds(69, 243, 121, 32);
		buttonRegistrar.setText("Registrar");
		contentpane.add(buttonRegistrar);

		textUser.setBounds(214, 134, 143, 20);
		contentpane.add(textUser);

		textPass.setBounds(214, 188, 143, 20);
		contentpane.add(textPass);
		
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
				
				Gestor gestor = new Gestor(750, 422); // quitar comentario para ver la ventana

				gestor.setVisible(true);
				
				/*ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				usuarios = Conexion.cogerUsuarios();

				for (Usuario u : usuarios) {
				
					if (textUser.getText().equals(u.getNombre())) {
						JOptionPane.showConfirmDialog(null, "Usuario correcto");
						//avanzar a la siguiente pantalla de usuario
					}
				}
				JOptionPane.showConfirmDialog(null, "Usuario no registrado");*/
			}
		});

		buttonRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro(750, 422); // quitar comentario para ver la ventana

				registro.setVisible(true);

			}
		});
		
		
		setLocationRelativeTo(null);
	}
}
