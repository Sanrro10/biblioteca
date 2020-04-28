package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.Usuario;
import es.deusto.spq.client.remote.ServiceLocator;

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
	private JLabel labelEmail = new JLabel();
	private JLabel labelSurname= new JLabel();
	private JLabel labelTlfn = new JLabel();
	private JLabel labelConfirmPass = new JLabel();
	private JLabel labelBackGround = new JLabel();
	
	private JTextField textUser = new JTextField();
	private JTextField textEmail = new JTextField();
	private JTextField textSurname= new JTextField();
	private JTextField textTlfn = new JTextField();
	private JPasswordField textPass = new JPasswordField();
	private JPasswordField textConfirmPass = new JPasswordField();

	private JButton buttonAceptar = new JButton();
	private JButton btnAtrs = new JButton();
	


	public Registro(int altura, int anchura, Controller controller) {
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
		labelBiblioteca.setIcon(new ImageIcon(Registro.class.getResource("/azul.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 414, 95);
		contentpane.add(labelBiblioteca);

		labelUser.setText("Nombre:");
		labelUser.setBounds(60, 130, 130, 20);
		labelUser.setBackground(Color.white);
		labelUser.setOpaque(true);
		contentpane.add(labelUser, BorderLayout.SOUTH);

		labelSurname.setText("Apellido:");
		labelSurname.setBounds(60, 155, 130, 20);
		labelSurname.setBackground(Color.white);
		labelSurname.setOpaque(true);
		contentpane.add(labelSurname);
		
		labelEmail.setText("Email:");
		labelEmail.setBounds(60, 180, 130, 20);
		labelEmail.setBackground(Color.white);
		labelEmail.setOpaque(true);
		contentpane.add(labelEmail);
		
		labelTlfn.setText("Telefono:");
		labelTlfn.setBounds(60, 205, 130, 20);
		labelTlfn.setBackground(Color.white);
		labelTlfn.setOpaque(true);
		contentpane.add(labelTlfn);
		
		labelPass.setText("Contraseña:");
		labelPass.setBounds(60, 230, 130, 20);
		labelPass.setBackground(Color.white);
		labelPass.setOpaque(true);
		contentpane.add(labelPass);
		
		labelConfirmPass.setText("Confirmar contraseña:");
		labelConfirmPass.setBounds(60, 255, 130, 20);
		labelConfirmPass.setBackground(Color.white);
		labelConfirmPass.setOpaque(true);
		contentpane.add(labelConfirmPass);
		
		textUser.setBounds(195, 130, 150, 20);
		contentpane.add(textUser);
		
		textSurname.setBounds(195, 155, 150, 20);
		contentpane.add(textSurname);
		
		textEmail.setBounds(195, 180, 150, 20);
		contentpane.add(textEmail);
		
		textTlfn.setBounds(195, 205, 150, 20);
		contentpane.add(textTlfn);
		
		textPass.setBounds(195, 230, 150, 20);
		contentpane.add(textPass);
		
		textConfirmPass.setBounds(195, 255, 150, 20);
		contentpane.add(textConfirmPass);
		
		buttonAceptar.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAceptar.setText("Aceptar");
		buttonAceptar.setBounds(200, 288, 130, 23);
		buttonAceptar.setBackground(new Color(0, 102, 204));
		contentpane.add(buttonAceptar);

		btnAtrs.setBackground(SystemColor.inactiveCaptionBorder);
		btnAtrs.setText("Atrás");
		btnAtrs.setBounds(63, 288, 130, 23);
		contentpane.add(btnAtrs);
		
		labelBackGround.setIcon(new ImageIcon(Registro.class.getResource("/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(431, 394);
		setTitle("Registro biblioteca");
		
		//Eventos
		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean correcto = false;
				boolean error = false;
				if(!textEmail.getText().contains("@") && !(textEmail.getText().contains(".es") || textEmail.getText().contains(".com"))){
					JOptionPane.showMessageDialog(null, "Email no válido");
					error = true;
					Registro.this.repaint();
				}else if (!String.valueOf(textPass.getPassword()).equals(String.valueOf(textConfirmPass.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Error. Las contraseñas no coinciden");
					Registro.this.repaint();
					error = true;
				}else if (!error){
					controller.registrarUsuario(textEmail.getText(), textUser.getText(), textSurname.getText(), Integer.parseInt(textTlfn.getText()), String.valueOf(textPass.getPassword()));
				}
				
				
				if ( correcto) {
					
					JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
					
					
					InicioSesion inicio = new InicioSesion(750, 422, controller); 

					inicio.setVisible(true);
					
					Registro.this.dispose();
					
				}else if (!error){
						JOptionPane.showMessageDialog(null, "Ese email ya ha sido registrado");
						Registro.this.repaint();
				}
			}
		});
		
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InicioSesion inicio = new InicioSesion(750, 422, controller); 

				inicio.setVisible(true);
				
				Registro.this.dispose();
				
			}
		});

		setLocationRelativeTo(null);
	}
}
