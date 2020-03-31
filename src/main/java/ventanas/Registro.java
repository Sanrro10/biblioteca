package ventanas;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

	public Registro(int altura, int anchura) {
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		labelUser.setText("Nombre de Usuario:");
		labelUser.setBounds(200, 100, 200, 20);
		contentpane.add(labelUser, BorderLayout.SOUTH);

		labelPass.setText("Contraseña:");
		labelPass.setBounds(200, 130, 200, 20);
		contentpane.add(labelPass);

		labelConfirmPass.setText("Confirmar contraseña:");
		labelConfirmPass.setBounds(200, 160, 200, 20);
		contentpane.add(labelConfirmPass);

		buttonAceptar.setBounds(350, 300, 100, 50);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);

		textUser.setBounds(340, 100, 100, 20);
		contentpane.add(textUser);

		textPass.setBounds(340, 130, 100, 20);
		contentpane.add(textPass);

		textConfirmPass.setBounds(340, 160, 100, 20);
		contentpane.add(textConfirmPass);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(altura, anchura);
		setTitle("Registro biblioteca");

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textPass.getText().equals(textConfirmPass.getText())) {
					JOptionPane.showConfirmDialog(null, "Usuario registrado correctamente");
					Registro.this.dispose();
				}else {
					JOptionPane.showConfirmDialog(null, "Datos incorrectos");
					Registro.this.repaint();
				}
			}
		});

	}

}
