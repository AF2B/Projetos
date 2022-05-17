package components.loginAdmin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import components.adminSection.AdminSection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class LoginAdmin {

	private JFrame loginAdmin;
	private JTextField nameTextField;
	private JTextField passwordTextField;

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

		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBounds(288, 333, 117, 30);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String password = String.valueOf(passwordTextField.getText());
				if (name.equals("admin") && password.equals("admin123")) {
					new AdminSection();
					AdminSection.main(null);
					loginAdmin.dispose();
				} else if(name.equals("") && password.equals("")){
					JOptionPane.showMessageDialog(btnLogin, LoginAdmin.this, 
							"Desculpe, O Campo usuário e senha não podem ser vázios!",
							JOptionPane.ERROR_MESSAGE);
					nameTextField.setText("");
					passwordTextField.setText("");
				}else {
					JOptionPane.showMessageDialog(btnLogin, LoginAdmin.this, 
							"Desculpe, Usuário ou Senha invalido!",
							JOptionPane.ERROR_MESSAGE);
					nameTextField.setText("");
					passwordTextField.setText("");
				}
			}
		});
		loginAdmin.getContentPane().add(btnLogin);

		nameTextField = new JTextField();
		nameTextField.setBounds(291, 109, 120, 19);
		loginAdmin.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(291, 192, 120, 19);
		loginAdmin.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);

		JLabel lblName = new JLabel("Nome");
		lblName.setBounds(152, 111, 70, 15);
		loginAdmin.getContentPane().add(lblName);

		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(152, 194, 70, 15);
		loginAdmin.getContentPane().add(lblPassword);

		JLabel lblAdmin = new JLabel("Administrador");
		lblAdmin.setBounds(274, 22, 153, 15);
		lblAdmin.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 20));
		loginAdmin.getContentPane().add(lblAdmin);

	}
}
