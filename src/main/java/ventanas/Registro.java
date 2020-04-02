package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.Conexion;
import base.Usuario;

import java.awt.SystemColor;
import java.awt.Font;

public class Registro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelUser = new JLabel();
	private JLabel labelPass = new JLabel();
	private JLabel labelConfirmPass = new JLabel();
	private JTextField textUser = new JTextField();
	private JPasswordField textPass = new JPasswordField();
	private JPasswordField textConfirmPass = new JPasswordField();
	private JButton buttonAceptar = new JButton();
	private JLabel labelBackGround = new JLabel();

	public Registro(int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(80, 26, 309, 42);
		contentpane.add(lblNewLabel);
		
		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca.setIcon(new ImageIcon(Registro.class.getResource("/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 414, 95);
		contentpane.add(labelBiblioteca);

		labelUser.setText("Nombre de Usuario:");
		labelUser.setBounds(63, 133, 130, 20);
		labelUser.setBackground(Color.white);
		labelUser.setOpaque(true);
		contentpane.add(labelUser, BorderLayout.SOUTH);

		labelPass.setText("Contraseña:");
		labelPass.setBounds(63, 177, 130, 20);
		labelPass.setBackground(Color.white);
		labelPass.setOpaque(true);
		contentpane.add(labelPass);

		labelConfirmPass.setText("Confirmar contraseña:");
		labelConfirmPass.setBounds(63, 222, 130, 20);
		labelConfirmPass.setBackground(Color.white);
		labelConfirmPass.setOpaque(true);
		contentpane.add(labelConfirmPass);
		buttonAceptar.setForeground(new Color(255, 255, 255));
		buttonAceptar.setBackground(new Color(0, 102, 204));

		buttonAceptar.setBounds(220, 288, 130, 23);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);

		textUser.setBounds(220, 133, 130, 20);
		contentpane.add(textUser);

		textPass.setBounds(220, 177, 130, 20);
		contentpane.add(textPass);

		textConfirmPass.setBounds(220, 222, 130, 20);
		contentpane.add(textConfirmPass);
		
		JButton btnAtrs = new JButton();
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InicioSesion inicio = new InicioSesion(750, 422); 

				inicio.setVisible(true);
				
				Registro.this.dispose();
				
			}
		});
		btnAtrs.setBackground(SystemColor.inactiveCaptionBorder);
		btnAtrs.setText("Atrás");
		btnAtrs.setBounds(63, 288, 130, 23);
		contentpane.add(btnAtrs);
		
		labelBackGround.setIcon(new ImageIcon(Registro.class.getResource("/images/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(431, 394);
		setTitle("Registro biblioteca");

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textPass.getText().equals(textConfirmPass.getText())) {
					Usuario nuevoUsuario = new Usuario();
//					nuevoUsuario.setApellidos(apellidos);
					nuevoUsuario.setContrasenya(textPass.getText());
//					nuevoUsuario.setEmail(email);
					nuevoUsuario.setNombre(textUser.getText());
					Conexion.insertarUsuario(nuevoUsuario);
					JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
					
					
					InicioSesion inicio = new InicioSesion(750, 422); 

					inicio.setVisible(true);
					
					Registro.this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos");
					Registro.this.repaint();
				}
			}
		});

		setLocationRelativeTo(null);
	}
}
