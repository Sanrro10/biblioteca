package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import es.deusto.spq.BD.Conexion;
import es.deusto.spq.base.Reserva_Sala;
import es.deusto.spq.base.SalaTrabajo;
import es.deusto.spq.base.Usuario;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;

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
	private JComboBox<String> ComboDisponibilidad = new JComboBox<String>();
	private JTextPane textPane = new JTextPane();
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Calefacción");
	
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

		combo.setBounds(320, 10, 90, 25);
		ArrayList<SalaTrabajo> salas = Conexion.cogerSalas();
		for(int i = 0; i< salas.size(); i++) {
			combo.addItem(salas.get(i).toCombo());
		}
		contentpane.add(combo);
		
		ComboDisponibilidad.setBounds(320, 40, 90, 25);
		ArrayList<Reserva_Sala> reservas = Conexion.cogerReserva_Salas();
		for(int i = 0; i< reservas.size(); i++) {
//			if(reservas.get(i).getFecha().) {
//				for(int a = 0; a < calendario.)
//			}
		}
		
		 //añadir metodo que recorra las horas libres de la sala seleccionada en el dia seleccionado y añada al combo los stirng con los horarios disponibles
		ComboDisponibilidad.addItem("16:00-17:30"); //ejemplo
		contentpane.add(ComboDisponibilidad);
		
		
		textPane.setBounds(320, 76, 95, 137);
		textPane.setEditable(false);
		for(int i = 0; i< salas.size(); i++) {
			if(combo.getSelectedItem().toString().equals(salas.get(i).toCombo())) {
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

		
		
//		calendario.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for(int i = 0; i< reservas.size(); i++) {
//					if(reservas.get(i).getFecha().equals(calendario.getDate())) {
//						btnreservar.setEnabled(false);
//						break;
//					}
//				}btnreservar.setEnabled(true);
//			}
//		});
		btnreservar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SalaTrabajo s = new SalaTrabajo();
				for(int i = 0; i< salas.size(); i++) {
					if(combo.getSelectedItem().toString().equals(salas.get(i).toCombo())) {
						s= salas.get(i);
					}
				}
				Reserva_Sala reservaNueva = new Reserva_Sala();
				reservaNueva.setCalefaccion(chckbxNewCheckBox.isSelected());
				reservaNueva.setCod_Usuario(user.getCod_Usuario());
				reservaNueva.setCod_Reserva_Sala(reservas.size()+1);
				reservaNueva.setCod_Sala(s.getCod_sala());
				reservaNueva.setFecha(calendario.getDate());
				reservas.add(reservaNueva);
				Conexion.insertarReserva_Sala(reservaNueva);
				btnreservar.setEnabled(false);
				
			}
		});
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< salas.size(); i++) {
					if(combo.getSelectedItem().toString().equals(salas.get(i).toCombo())) {
						textPane.setText(salas.get(i).toString());
					}
				}
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
