package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.ReservaSala;
import es.deusto.spq.client.data.SalaTrabajo;
import es.deusto.spq.client.data.Usuario;
import es.deusto.spq.client.resources.JCalendario;

import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class CalendarioSalas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private static JButton btnreservar = new JButton();
	private JButton btnratras = new JButton();
	private static JComboBox<String> combo = new JComboBox<String>();
	private static JComboBox<String> ComboDisponibilidad = new JComboBox<String>();
	private static JTextPane textPane = new JTextPane();
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Calefacción");
	public static String codsala = "";
	public static String codsala2 = "";
	public static Date fecha;
	public static String fecha2 = "";
	public static String fecha3 = "";
	public static int maxPerso = 0;

	public CalendarioSalas(int altura, int anchura, final Usuario user, Controller controller) throws ParseException {
		contentpane = new JPanel();

		JCalendario calendario = new JCalendario(controller);

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		calendario.setBounds(10, 10, 300, 300);
		calendario.setTodayButtonVisible(true);
		calendario.setTodayButtonText("Hoy");
		calendario.setWeekOfYearVisible(false);
		calendario.setMaxDayCharacters(1);
		calendario.setWeekdayForeground(Color.BLUE);
		calendario.setSundayForeground(Color.RED);
		calendario.setVisible(true);
		contentpane.add(calendario);

		btnreservar.setBounds(320, 255, 90, 25);
		btnreservar.setText("Reservar");
		contentpane.add(btnreservar);

		btnratras.setBounds(320, 285, 90, 25);
		btnratras.setText("Atras");
		contentpane.add(btnratras);

		combo.setBounds(320, 10, 90, 25);
		List<SalaTrabajo> salas = controller.cogerSalas();
		for (int i = 0; i < salas.size(); i++) {
			combo.addItem(salas.get(i).toCombo());
		}
		contentpane.add(combo);

		ComboDisponibilidad.setBounds(320, 40, 90, 25);
		List<ReservaSala> reservas = controller.cogerReservasSala();
		for (int i = 0; i < reservas.size(); i++) {
//			if(reservas.get(i).getFecha().) {
//				for(int a = 0; a < calendario.)
//			}
		}

		// añadir metodo que recorra las horas libres de la sala seleccionada en el dia
		// seleccionado y añada al combo los stirng con los horarios disponibles
		ComboDisponibilidad.addItem("10:00-12:00");
		ComboDisponibilidad.addItem("16:00-18:00");
		ComboDisponibilidad.addItem("18:00-20:00");// ejemplo
		contentpane.add(ComboDisponibilidad);

		textPane.setBounds(320, 76, 95, 137);
		textPane.setEditable(false);
		for (int i = 0; i < salas.size(); i++) {
			if (combo.getSelectedItem().toString().equals(salas.get(i).toCombo())) {
				textPane.setText(salas.get(i).toString());
			}
		}
		contentpane.add(textPane);

		chckbxNewCheckBox.setBounds(316, 225, 97, 23);
		contentpane.add(chckbxNewCheckBox);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 355);
		setTitle("Bilbioteca");
		setLocationRelativeTo(null);

		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy");
		String fechaString = sdf.format(calendario.getDate());
		for (int i = 0; i < reservas.size(); i++) {
			if (sdf.format(reservas.get(i).getFecha()).equals(fechaString)) {
				combo.removeItem("SalaTrabajo" + reservas.get(i).getCod_Sala());
			}
		}
		if (combo.getItemCount() == 0) {
			btnreservar.setEnabled(false);
			textPane.setText("No hay salas disponibles");
		} else {
			btnreservar.setEnabled(true);
		}
		actualizar(false, false, controller, calendario);

		btnreservar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SalaTrabajo s = new SalaTrabajo();
				for (int i = 0; i < salas.size(); i++) {
					if (combo.getSelectedItem().toString().equals(salas.get(i).toCombo())) {
						s = salas.get(i);
					}
				}
				ReservaSala reservaNueva = new ReservaSala();
				reservaNueva.setCalefaccion(chckbxNewCheckBox.isSelected());
				reservaNueva.setEmail(user.getEmail());
				reservaNueva.setCod_Reserva_Sala(reservas.size() + 1);
				reservaNueva.setCod_Sala(s.getCod_sala());
				SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, dd MMM yyyy");
				String fechaString = sdf1.format(calendario.getDate());
				try {
					reservaNueva.setFecha(sdf1.parse(fechaString));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(reservaNueva.getFecha());

				if (ComboDisponibilidad.getSelectedItem().equals("16:00-18:00")) {
					cal.add(Calendar.HOUR_OF_DAY, 16);
				} else if (ComboDisponibilidad.getSelectedItem().equals("18:00-20:00")) {
					cal.add(Calendar.HOUR_OF_DAY, 18);
				} else if (ComboDisponibilidad.getSelectedItem().equals("10:00-12:00")) {
					cal.add(Calendar.HOUR_OF_DAY, 10);
				}
				reservaNueva.setFecha(cal.getTime());
				reservas.add(reservaNueva);
				codsala = (String) combo.getSelectedItem();
				codsala2 = codsala.substring(0, codsala.length() - 3);

				fecha = calendario.getDate();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String fecha2 = sdf.format(fecha);
				fecha3 = fecha2;
				if (combo.getSelectedIndex() == 0) {

					maxPerso = 4;

				} else if (combo.getSelectedIndex() == 1) {

					maxPerso = 5;

				} else if (combo.getSelectedIndex() == 2) {

					maxPerso = 5;

				} else if (combo.getSelectedIndex() == 3) {

					maxPerso = 7;

				} else if (combo.getSelectedIndex() == 4) {

					maxPerso = 7;

				}

				ReservaSalas reserva;

				try {
					reserva = new ReservaSalas(426, 463, user, reservaNueva, ComboDisponibilidad.getSelectedItem().toString(), controller, calendario);
					reserva.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				actualizar(false, false, controller, calendario);

			}
		});

		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < salas.size(); i++) {
					try {
						if (combo.getSelectedItem().toString().equals(salas.get(i).toCombo())) {
							textPane.setText(salas.get(i).toString());
						}
					} catch (NullPointerException e2) {
						// TODO: handle exception
					}

				}
			}
		});
		ComboDisponibilidad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizar(true, false, controller, calendario);

			}
		});

		btnratras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ReservaLibros reservalibros;
				try {
					reservalibros = new ReservaLibros(750, 422, user);
					reservalibros.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				CalendarioSalas.this.dispose();

			}
		});
	}

	public static void actualizar(boolean sala, boolean horas, Controller controller, JCalendario calendario) {

		List<SalaTrabajo> salas = controller.cogerSalas();
		List<ReservaSala> reservas = new ArrayList<>();
		if (sala) {
			combo.removeAllItems();
			for (int i = 0; i < salas.size(); i++) {
				combo.addItem(salas.get(i).toCombo());
			}
		}
		if (horas) {
			ComboDisponibilidad.removeAllItems();
			ComboDisponibilidad.addItem("10:00-12:00");
			ComboDisponibilidad.addItem("16:00-18:00");
			ComboDisponibilidad.addItem("18:00-20:00");

		}

		reservas = controller.cogerReservasSala();

		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy");
		String fechaString = sdf.format(calendario.getDate());
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(fechaString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (ComboDisponibilidad.getSelectedItem().equals("16:00-18:00")) {
				cal.add(Calendar.HOUR_OF_DAY, 16);
			} else if (ComboDisponibilidad.getSelectedItem().equals("18:00-20:00")) {
				cal.add(Calendar.HOUR_OF_DAY, 18);
			} else if (ComboDisponibilidad.getSelectedItem().equals("10:00-12:00")) {
				cal.add(Calendar.HOUR_OF_DAY, 10);
			}

		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		Date fecha = cal.getTime();
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getFecha().equals(fecha)) {
				combo.removeItem("Sala" + reservas.get(i).getCod_Sala());
			}
		}
		if (combo.getItemCount() == 0) {
			if (ComboDisponibilidad.getItemCount() == 0) {
				btnreservar.setEnabled(false);
				textPane.setText("No hay salas disponibles este día");
			} else {
				ComboDisponibilidad.removeItem(ComboDisponibilidad.getSelectedItem());
				actualizar(false, false, controller, calendario);
			}

		} else {
			btnreservar.setEnabled(true);
		}
	}

}
