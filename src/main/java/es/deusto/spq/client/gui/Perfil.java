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
import javax.swing.JTextField;

/**
 * Ventana para ver o modificar el perfil
 * @author isanr
 */
public class Perfil extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private final JLabel lblNewLabel = new JLabel("Biblioteca");
	private final JLabel LabelBackground = new JLabel("");
	private JTextField textField = new JTextField();
	private final JTextPane textPane = new JTextPane();
	private final JButton btnNewButton = new JButton("Editar Perfil");
	private final JTextPane textPane_1 = new JTextPane();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextPane textPane_2 = new JTextPane();
	private final JTextPane textPane_1_1 = new JTextPane();
	private final JTextField textField_3 = new JTextField();
	private final JTextPane textPane_1_1_1 = new JTextPane();
	private final JTextField textField_4 = new JTextField();
	private final JButton btnNewButton_1 = new JButton("Atrás");
	private boolean editar = false;

	public Perfil(Usuario usuario, Controller controller) throws ParseException {
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(519, 505);
		setTitle("Area usuario");
		
		
		textField.setBounds(117, 169, 141, 20);
		textField.setEditable(false);
		textField.setText(usuario.getEmail());
		contentpane.add(textField);
		textField.setColumns(10);
		textPane.setBackground(SystemColor.control);
		textPane.setText("Email:");
		textPane.setBounds(51, 169, 68, 20);
		contentpane.add(textPane);
		
		
		
		
		btnNewButton.setBounds(404, 106, 89, 23);
		contentpane.add(btnNewButton);
		textPane_1.setText("Nombre:");
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(51, 223, 68, 20);
				
		contentpane.add(textPane_1);
		textField_1.setColumns(10);
		textField_1.setBounds(117, 223, 141, 20);
		textField_1.setEditable(false);
		textField_1.setText(usuario.getNombre());
				
		contentpane.add(textField_1);
		textField_2.setColumns(10);
		textField_2.setBounds(117, 274, 141, 20);
		textField_2.setEditable(false);
		textField_2.setText(usuario.getApellidos());
		
		contentpane.add(textField_2);
		textPane_2.setText("Apellidos:");
		textPane_2.setBackground(SystemColor.menu);
		textPane_2.setBounds(51, 274, 68, 20);
		
		contentpane.add(textPane_2);
		textPane_1_1.setText("Teléfono:");
		textPane_1_1.setBackground(SystemColor.menu);
		textPane_1_1.setBounds(51, 328, 68, 20);
		
		contentpane.add(textPane_1_1);
		textField_3.setColumns(10);
		textField_3.setBounds(117, 328, 141, 20);
		textField_3.setEditable(false);
		textField_3.setText(""+usuario.getTelefono());
		
		contentpane.add(textField_3);
		textPane_1_1_1.setText("Contraseña:");
		textPane_1_1_1.setBackground(SystemColor.menu);
		textPane_1_1_1.setBounds(51, 378, 68, 20);
		
		contentpane.add(textPane_1_1_1);
		textField_4.setColumns(10);
		textField_4.setBounds(117, 378, 141, 20);
		textField_4.setEditable(false);
		textField_4.setText(usuario.getContrasenya());
		
		contentpane.add(textField_4);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!editar) {
					btnNewButton.setEnabled(false);
					btnNewButton_1.setText("Guardar");
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editar) {
					Usuario user = new Usuario();
					user.setEmail(textField.getText());
					user.setNombre(textField_1.getText());
					user.setApellidos(textField_2.getText());
					user.setTelefono(Integer.parseInt(textField_3.getText()));
					user.setContrasenya(textField_4.getText());
					controller.editarUsuario(user);
					btnNewButton.setEnabled(true);
					btnNewButton_1.setText("Atrás");
					textField_1.setEditable(true);
					textField_2.setEditable(true);
					textField_3.setEditable(true);
					textField_4.setEditable(true);
				}
			}
		});
		btnNewButton_1.setBounds(345, 378, 89, 23);
		
		contentpane.add(btnNewButton_1);
		LabelBackground.setIcon(new ImageIcon(ReservaLibros.class.getResource("/background3.jpg")));
		LabelBackground.setBounds(0, 0, 503, 466);
		
		contentpane.add(LabelBackground);
		

		setLocationRelativeTo(null);
	}
}
