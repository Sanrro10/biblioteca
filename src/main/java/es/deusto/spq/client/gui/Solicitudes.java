package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.Solicitud;

public class Solicitudes extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JLabel LabelBackground = new JLabel("");
	private final JTextPane txtpnDatos = new JTextPane();

	public Solicitudes(int altura, int anchura, Controller controller) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);

		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));

		buttonAtras.setBounds(45, 407, 161, 28);
		buttonAtras.setText("Atras");
		contentpane.add(buttonAtras);

		JLabel labelBiblioteca = new JLabel("");
		//labelBiblioteca.setIcon(new ImageIcon(VentanaGestor.class.getResource("/es/deusto/spq/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);
	
		//LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/es/deusto/spq/images/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 106, 450, 280);
		contentpane.add(scrollPane);

		final JComboBox comboBox = new JComboBox();
		List<Solicitud> solicitud = controller.cogerSolicitudes();
		ArrayList<Integer> codigoS = new ArrayList<>();
		for (int i = 0; i < solicitud.size(); i++) {
			codigoS.add(solicitud.get(i).getCodigoS());
		}
		for (int i = 0; i < solicitud.size(); i++) {
			if (!codigoS.contains(solicitud.get(i).getCodigoS())) {
				comboBox.addItem(solicitud.get(i).toStringResumido());
			}
		}
		try {
			for (int i = 0; i < solicitud.size(); i++) {
				comboBox.addItem(solicitud.get(i).toStringResumido());
				if ((comboBox.getSelectedItem().equals((solicitud.get(i).toStringResumido())))) {
					txtpnDatos.setText(solicitud.get(i).toString());
				}
			}

		} catch (java.lang.NullPointerException e) {
			txtpnDatos.setText("No hay libros disponibles");
		}

		scrollPane.setColumnHeaderView(comboBox);

		scrollPane.setViewportView(txtpnDatos);

		contentpane.add(LabelBackground);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area gestor");
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					txtpnDatos.setText(comboBox.getSelectedItem().toString());
				} catch (java.lang.NullPointerException e) {
					txtpnDatos.setText("No hay solicituded disponibles");
				}

			}

		});
		

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				InicioSesion inicio = new InicioSesion(750, 422, controller);

				inicio.setVisible(true);

				Solicitudes.this.dispose();

			}
		});

		setLocationRelativeTo(null);
	}
}

