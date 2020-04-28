package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.Usuario;
import es.deusto.spq.client.properties.GetPropertyValues;
import es.deusto.spq.client.remote.ServiceLocator;

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
	private final JButton btnNewButton = new JButton("PRUEBA");
	private final JButton btnNewButtonGestor = new JButton("Gestor");
	private Client client;

	public InicioSesion(int altura, int anchura, Controller controller, ServiceLocator servicelocator) {
		client = ClientBuilder.newClient();
		GetPropertyValues properties = new GetPropertyValues();
		String url = "";
		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		WebTarget appTarget = client.target(url);
		WebTarget inicioSesionTarget = appTarget.path("inicioSesion");
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		labelUser.setFont(new Font("Arial", Font.BOLD, 11));

		labelUser.setText(" Email:");
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
		buttonRegistrar.setBackground(SystemColor.inactiveCaptionBorder);

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
		labelBiblioteca.setIcon(new ImageIcon(InicioSesion.class.getResource("/azul.jpg")));
		labelBiblioteca.setForeground(SystemColor.text);
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBounds(0, 0, 534, 95);
		contentpane.add(labelBiblioteca);
		final Usuario user = new Usuario();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ReservaLibros reserva;
				try {
					reserva = new ReservaLibros(750, 422, user);
					reserva.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				InicioSesion.this.dispose();


			}
		});
		btnNewButton.setBackground(new Color(102, 204, 102));
		btnNewButton.setBounds(0, 293, 89, 23);

		contentpane.add(btnNewButton);

		btnNewButtonGestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaGestor gestor = new VentanaGestor(750, 422);

				gestor.setVisible(true);

				InicioSesion.this.dispose();


			}
		});
		btnNewButtonGestor.setBackground(new Color(102, 204, 102));
		btnNewButtonGestor.setBounds(200, 293, 89, 23);

		contentpane.add(btnNewButtonGestor);

		labelBackGround.setIcon(new ImageIcon(InicioSesion.class.getResource("/background3.jpg")));
		labelBackGround.setBounds(0, 0, altura, anchura);
		contentpane.add(labelBackGround);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 355);
		setTitle("Bilbioteca");

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int correcto = controller.iniciarSesion(textUser.getText(), textPass.getText());
				Usuario user2 = new Usuario();
				if(correcto == 1) {
					ReservaLibros reserva;
					try {
						reserva = new ReservaLibros(750, 422, user2);
						reserva.setVisible(true);
						InicioSesion.this.dispose();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}




				}else if(correcto == 2) {
					VentanaGestor gestor = new VentanaGestor(750, 422);

					gestor.setVisible(true);

					InicioSesion.this.dispose();
				}else if(correcto == 0) {
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
				}

			}
		});

		buttonRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro(750, 422, controller, servicelocator); // quitar comentario para ver la ventana

				registro.setVisible(true);

				InicioSesion.this.dispose();

			}
		});


		setLocationRelativeTo(null);
	}
}
