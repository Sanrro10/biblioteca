package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.Conexion;
import com.example.Usuario;

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

	public InicioSesion(int altura, int anchura) {
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

		buttonAceptar.setBounds(350, 300, 100, 50);
		buttonAceptar.setText("Aceptar");
		contentpane.add(buttonAceptar);

		buttonRegistrar.setBounds(200, 300, 100, 50);
		buttonRegistrar.setText("Registrar");
		contentpane.add(buttonRegistrar);

		textUser.setBounds(340, 100, 100, 20);
		contentpane.add(textUser);

		textPass.setBounds(340, 130, 100, 20);
		contentpane.add(textPass);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(altura, anchura);
		setTitle("Bilbioteca");

		buttonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				usuarios = Conexion.cogerUsuarios();

				for (Usuario u : usuarios) {
					if (textUser.getText().equals(u.getNombre())) {
						JOptionPane.showConfirmDialog(null, "Usuario correcto");
						//avanzar a la siguiente pantalla de usuario
					}
				}
				JOptionPane.showConfirmDialog(null, "Usuario no registrado");
			}
		});

		buttonRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro(750, 422); // quitar comentario para ver la ventana

				registro.setVisible(true);

			}
		});
	}

}
