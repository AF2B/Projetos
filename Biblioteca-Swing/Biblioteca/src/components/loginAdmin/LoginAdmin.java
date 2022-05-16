package components.loginAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LoginAdmin {

	private JFrame loginAdmin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
					window.loginAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginAdmin = new JFrame();
		loginAdmin.setTitle("Login");
		loginAdmin.getContentPane().setLayout(null);
		loginAdmin.getContentPane().setBackground(new Color(245, 245, 245));
		loginAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginAdmin.setBounds(350, 350, 700, 500);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(288, 333, 117, 30);
		loginAdmin.getContentPane().add(btnEntrar);
		
		textField = new JTextField();
		textField.setBounds(291, 109, 120, 19);
		loginAdmin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(291, 192, 120, 19);
		loginAdmin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(152, 111, 70, 15);
		loginAdmin.getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(152, 194, 70, 15);
		loginAdmin.getContentPane().add(lblSenha);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setBounds(274, 22, 153, 15);
		lblAdministrador.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 20));
		loginAdmin.getContentPane().add(lblAdministrador);
		
		
	}
}
