package components.loginLibrarian;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import components.librarianSection.LibrarianSection;
import repository.Librarian;

public class LoginLibrarian {

	private JFrame loginLibrarian;
	private JTextField nameTextField;
	private JTextField passwordTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginLibrarian window = new LoginLibrarian();
					window.loginLibrarian.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginLibrarian() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginLibrarian = new JFrame();
		loginLibrarian.setTitle("Login");
		loginLibrarian.getContentPane().setLayout(null);
		loginLibrarian.getContentPane().setBackground(new Color(245, 245, 245));
		loginLibrarian.setBounds(350, 350, 700, 500);
		loginLibrarian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBounds(294, 275, 120, 35);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String password = String.valueOf(((JPasswordField) passwordTextField).getPassword());
				if (Librarian.validate(name, password)) {
					new LibrarianSection();
					LibrarianSection.main(null);
					loginLibrarian.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Desculpe, Usuário ou Senha Invalida!");
					nameTextField.setText("");
					passwordTextField.setText("");
				}
			}
		});
		loginLibrarian.getContentPane().add(btnLogin);

		nameTextField = new JTextField();
		nameTextField.setBounds(291, 109, 120, 19);
		loginLibrarian.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(291, 192, 120, 19);
		loginLibrarian.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);

		JLabel lblName = new JLabel("Nome");
		lblName.setBounds(152, 111, 70, 15);
		loginLibrarian.getContentPane().add(lblName);

		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(152, 194, 70, 15);
		loginLibrarian.getContentPane().add(lblPassword);

		JLabel lblBibliotecario = new JLabel("Bibliotecário");
		lblBibliotecario.setBounds(274, 22, 153, 15);
		lblBibliotecario.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 20));
		loginLibrarian.getContentPane().add(lblBibliotecario);
		
	}

}
