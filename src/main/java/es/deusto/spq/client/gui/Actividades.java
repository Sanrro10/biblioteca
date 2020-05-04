package es.deusto.spq.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.controller.Controller;
import es.deusto.spq.client.data.Actividad;
import es.deusto.spq.client.data.Libro;
import es.deusto.spq.client.data.ReservaLibro;
import es.deusto.spq.client.data.Usuario;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class Actividades extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private final JTextPane lunes = new JTextPane();
	private final JTextPane martes = new JTextPane();
	private final JTextPane miercoles = new JTextPane();
	private final JTextPane jueves = new JTextPane();
	private final JTextPane viernes = new JTextPane();
	private final JTextPane sabado = new JTextPane();
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JLabel LabelBackground = new JLabel("");

	public Actividades(Controller controller) throws ParseException {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 54));
		lblNewLabel.setBounds(123, 27, 309, 42);

		contentpane.add(lblNewLabel);

		JLabel labelBiblioteca = new JLabel("");
		labelBiblioteca.setIcon(new
		ImageIcon(VentanaGestor.class.getResource("/azul.jpg")));
		labelBiblioteca.setForeground(Color.WHITE);
		labelBiblioteca.setFont(new Font("Tahoma", Font.PLAIN, 48));
		labelBiblioteca.setBackground(SystemColor.textHighlight);
		labelBiblioteca.setBounds(0, 0, 503, 95);
		contentpane.add(labelBiblioteca);
		List<Actividad> actividades = controller.cogerActividades();
//		List<Actividad> actividades = new ArrayList<Actividad>();
		String lunesText = "                Lunes:" + "\n" + "\n";
		String martesText = "                 Martes:" + "\n" + "\n";
		String miercolesText = "              Miércoles:" + "\n" + "\n";
		String juevesText = "                Jueves:" + "\n" + "\n";
		String viernesText = "               Viernes:" + "\n" + "\n";
		String sabadoText = "               Sábado:" + "\n" + "\n";
//		Actividad a1 = new Actividad(1, "12:00-13:30", "Cuentacuentos");
//		Actividad a2 = new Actividad(2, "12:00-13:30", "Cuentacuentos");
//		Actividad a3 = new Actividad(3, "12:00-13:30", "Cuentacuentos");
//		Actividad a4 = new Actividad(4, "12:00-13:30", "Cuentacuentos");
//		Actividad a5 = new Actividad(5, "12:00-13:30", "Cuentacuentos");
//		Actividad a6 = new Actividad(1, "17:00-18:30", "Cuentacuentos");
//		Actividad a7 = new Actividad(2, "17:00-18:30", "Cuentacuentos");
//		Actividad a8 = new Actividad(3, "17:00-18:30", "Cuentacuentos");
//		Actividad a9 = new Actividad(4, "17:00-18:30", "Cuentacuentos");
//		Actividad a10 = new Actividad(5, "17:00-18:30", "Cuentacuentos");
//		Actividad a11 = new Actividad(6, "18:00-20:30", "Club del cómic");
//		Actividad a12 = new Actividad(6, "10:00-14:00", "Apoyo escolar");
//		actividades.add(a1);
//		actividades.add(a2);
//		actividades.add(a3);
//		actividades.add(a4);
//		actividades.add(a5);
//		actividades.add(a6);
//		actividades.add(a7);
//		actividades.add(a8);
//		actividades.add(a9);
//		actividades.add(a10);
//		actividades.add(a11);
//		actividades.add(a12);
		
		for(int i = 0; i< actividades.size(); i++) {
			if(actividades.get(i).getDia()==1) {
				lunesText = lunesText + actividades.get(i).toString();
			}
			else if(actividades.get(i).getDia()==2) {
				martesText = martesText + actividades.get(i).toString();
			}
			else if(actividades.get(i).getDia()==3) {
				miercolesText = miercolesText + actividades.get(i).toString();
			}
			else if(actividades.get(i).getDia()==4) {
				juevesText = juevesText + actividades.get(i).toString();
			}
			else if(actividades.get(i).getDia()==5) {
				viernesText = viernesText + actividades.get(i).toString();
			}
			else if(actividades.get(i).getDia()==6) {
				sabadoText = sabadoText + actividades.get(i).toString();
			}
		}
		lunes.setBounds(10, 121, 142, 153);
		lunes.setText(lunesText);
		contentpane.add(lunes);
		martes.setBounds(179, 121, 142, 153);
		martes.setText(martesText);
		contentpane.add(martes);
		miercoles.setBounds(351, 121, 142, 153);
		miercoles.setText(miercolesText);
		contentpane.add(miercoles);
		jueves.setBounds(10, 302, 142, 153);
		jueves.setText(juevesText);
		contentpane.add(jueves);
		viernes.setBounds(179, 302, 142, 153);
		viernes.setText(viernesText);
		contentpane.add(viernes);
		sabado.setBounds(351, 302, 142, 153);
		sabado.setText(sabadoText);
		contentpane.add(sabado);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area usuario");
		LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);

		contentpane.add(LabelBackground);
		

		setLocationRelativeTo(null);
	}
}
