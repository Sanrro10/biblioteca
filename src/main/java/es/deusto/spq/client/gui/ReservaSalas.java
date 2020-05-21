package es.deusto.spq.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.ReservaSala;
import es.deusto.spq.client.data.Usuario;
import es.deusto.spq.client.resources.JCalendario;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ReservaSalas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JButton buttonAtras = new JButton();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JLabel LabelBackground = new JLabel("");
	private final JLabel lblNewLabel_1 = new JLabel("Código:");
	private final JLabel lblNewLabel_1_1 = new JLabel("Fecha:");
	private final JLabel lblNewLabel_1_7 = new JLabel("Hora:");
	private final JLabel lblNewLabel_1_2 = new JLabel("Usuario 1");
	private final JLabel lblNewLabel_1_2_1 = new JLabel("Usuario 2");
	private final JLabel lblNewLabel_1_2_2 = new JLabel("Usuario 3");
	private final JLabel lblNewLabel_1_2_3 = new JLabel("Usuario 4");
	private final JLabel lblNewLabel_1_2_4 = new JLabel("Usuario 5");
	private final JLabel lblNewLabel_1_2_5 = new JLabel("Usuario 6");
	private final JLabel lblNewLabel_1_2_6 = new JLabel("Usuario 7");
	private String nomusu = "";

	// nomusu hace que en el primer apartado de usuarios siempre salga el usuario
	// con el que se ha hecho la reserva (en proceso)
	// (Al entrar desde prueba no sale nada porque no has utilizado un usuario)

	private JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JLabel lblFecha = new JLabel(CalendarioSalas.fecha3);
	private final JLabel lblHora = new JLabel();
	public String usuariosExtra(ArrayList<String> usuarios) {
		String usuariosExtra = "";
		for(int i=0; i<usuarios.size();i++) {
			if(!usuarios.get(i).isEmpty()) {
				usuariosExtra = usuariosExtra + usuarios.get(i) + ";";
			}
		}
		return usuariosExtra;
		
	}

	public ReservaSalas(final Usuario user, final ReservaSala reservaNueva, String horario, Controller controller, JCalendario jcalendario) throws ParseException {
		lblHora.setText(horario);
		textField.setText(user.getEmail());
		textField.setEditable(false);
		textField.setBounds(130, 167, 221, 20);
		textField.setColumns(10);
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		lblFecha.setBounds(94, 122, 74, 14);

		contentpane.add(lblFecha);

		lblHora.setBounds(94, 140, 74, 14);
		contentpane.add(lblHora);

		JLabel lblSala = new JLabel(CalendarioSalas.codsala2);
		lblSala.setBounds(94, 97, 46, 14);
		contentpane.add(lblSala);
		lblNewLabel_1_2_2.setBounds(45, 220, 74, 14);

		contentpane.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_1.setBounds(45, 195, 74, 14);

		contentpane.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2.setBounds(45, 170, 74, 14);

		contentpane.add(lblNewLabel_1_2);
		lblNewLabel_1_1.setBounds(45, 122, 74, 14);

		contentpane.add(lblNewLabel_1_1);
		lblNewLabel_1.setBounds(45, 97, 113, 14);

		contentpane.add(lblNewLabel_1);

		lblNewLabel_1_7.setBounds(45, 140, 113, 14);
		contentpane.add(lblNewLabel_1_7);

		JButton btnReservarSala = new JButton();
		btnReservarSala.setText("Reservar sala");
		btnReservarSala.setForeground(SystemColor.text);
		btnReservarSala.setBackground(SystemColor.textHighlight);
		btnReservarSala.setBounds(209, 370, 142, 28);
		contentpane.add(btnReservarSala);

		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(76, 25, 309, 42);

		contentpane.add(lblNewLabel);
		buttonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		buttonAtras.setForeground(new Color(0, 0, 0));

		buttonAtras.setBounds(45, 370, 142, 28);
		buttonAtras.setText("Atrás");
		contentpane.add(buttonAtras);

		JLabel labelBiblioteca = new JLabel("");
		// labelBiblioteca.setIcon(new
		// ImageIcon(VentanaGestor.class.getResource("/es/deusto/spq/images/065580938b36e4c049ec033745248216.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);
		lblNewLabel_1_2_3.setBounds(45, 245, 74, 14);

		contentpane.add(lblNewLabel_1_2_3);
		lblNewLabel_1_2_4.setBounds(45, 270, 74, 14);

		contentpane.add(lblNewLabel_1_2_4);
		lblNewLabel_1_2_5.setBounds(45, 295, 74, 14);

		contentpane.add(lblNewLabel_1_2_5);
		lblNewLabel_1_2_6.setBounds(45, 320, 74, 14);

		contentpane.add(lblNewLabel_1_2_6);

		contentpane.add(textField);

		textField_1.setColumns(10);
		textField_1.setBounds(130, 192, 221, 20);

		contentpane.add(textField_1);

		textField_2.setColumns(10);
		textField_2.setBounds(130, 217, 221, 20);

		contentpane.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(130, 242, 221, 20);

		contentpane.add(textField_3);
		textField_4.setColumns(10);
		textField_4.setBounds(130, 267, 221, 20);

		contentpane.add(textField_4);
		textField_5.setColumns(10);
		textField_5.setBounds(130, 292, 221, 20);

		contentpane.add(textField_5);
		textField_6.setColumns(10);
		textField_6.setBounds(130, 317, 221, 20);

		contentpane.add(textField_6);

		if (CalendarioSalas.maxPerso == 4) {

			textField_4.setEditable(false);
			textField_5.setEditable(false);
			textField_6.setEditable(false);

		} else if (CalendarioSalas.maxPerso == 5) {

			textField_5.setEditable(false);
			textField_6.setEditable(false);

		}

		// LabelBackground.setIcon(new
		// ImageIcon(ReservaLibros.class.getResource("/es/deusto/spq/images/background3.jpg")));
		LabelBackground.setBounds(0, 0, 409, 424);

		contentpane.add(LabelBackground);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(426, 463);
		setTitle("Area usuario");

		btnReservarSala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> usuarios = new ArrayList<>();
				usuarios.add(textField_1.getText());
				usuarios.add(textField_2.getText());
				usuarios.add(textField_3.getText());
				usuarios.add(textField_4.getText());
				usuarios.add(textField_5.getText());
				usuarios.add(textField_6.getText());
				reservaNueva.setUsuariosExtra(usuariosExtra(usuarios));
				controller.insertarReservaSala(reservaNueva);

				CalendarioSalas calendario;
				try {
					calendario = new CalendarioSalas(user, controller);
					calendario.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				ReservaSalas.this.dispose();

			}
		});

		buttonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CalendarioSalas calendario;
				try {
					calendario = new CalendarioSalas(user, controller);
					calendario.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				

				ReservaSalas.this.dispose();

			}
		});

		setLocationRelativeTo(null);
	}
}