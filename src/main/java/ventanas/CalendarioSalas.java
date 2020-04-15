package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import es.deusto.spq.base.Usuario;

public class CalendarioSalas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JCalendar calendario = new JCalendar();
	private JButton btnreservar = new JButton();
	private JButton btnratras = new JButton();

	private JComboBox<String> combo = new JComboBox<String>();

	public CalendarioSalas(int altura, int anchura, final Usuario user) throws ParseException {
		contentpane = new JPanel();

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

		combo.setBounds(320, 10, 80, 25);
		combo.addItem("Sala 1 (4)");
		combo.addItem("Sala 2 (5)");
		combo.addItem("Sala 3 (5)");
		combo.addItem("Sala 4 (7)");
		combo.addItem("Sala 5 (7)");
		contentpane.add(combo);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(441, 355);
		setTitle("Bilbioteca");
		setLocationRelativeTo(null);

		btnreservar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// lanzar formulario buscando disponibilidad de la sala seleccionada en la fecha
				// seleccionada
				// combo.getSelectedIndex();
				// calendario.getDate();
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

}
