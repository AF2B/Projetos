package components.addLibrarianForm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import components.adminSection.AdminSection;
import repository.Librarian;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LibrarianForm {
	private JFrame librarianForm;
	private JTextField nameTextField;
	private JPasswordField passwordTextField;
	private JTextField emailTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField contactTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianForm window = new LibrarianForm();
					window.librarianForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibrarianForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		librarianForm = new JFrame();
		librarianForm.setTitle("Administrador");
		librarianForm.getContentPane().setLayout(null);
		librarianForm.setBounds(350, 350, 700, 500);
		librarianForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(282, 47, 156, 19);
		librarianForm.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(282, 82, 156, 19);
		librarianForm.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(282, 117, 156, 19);
		librarianForm.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(282, 152, 156, 19);
		librarianForm.getContentPane().add(addressTextField);
		addressTextField.setColumns(10);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(282, 187, 156, 19);
		librarianForm.getContentPane().add(cityTextField);
		cityTextField.setColumns(10);
		
		contactTextField = new JTextField();
		contactTextField.setBounds(282, 222, 156, 19);
		librarianForm.getContentPane().add(contactTextField);
		contactTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setBounds(174, 49, 70, 15);
		librarianForm.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(174, 84, 70, 15);
		librarianForm.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(174, 119, 70, 15);
		librarianForm.getContentPane().add(lblEmail);
		
		JLabel lblAddress = new JLabel("Endereço");
		lblAddress.setBounds(174, 154, 70, 15);
		librarianForm.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("Cidade");
		lblCity.setBounds(174, 189, 70, 15);
		librarianForm.getContentPane().add(lblCity);
		
		JLabel lblContact = new JLabel("Contato");
		lblContact.setBounds(174, 224, 70, 15);
		librarianForm.getContentPane().add(lblContact);
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setBounds(282, 270, 117, 35);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String password = passwordTextField.getText();
				String email = emailTextField.getText();
				String address = addressTextField.getText();
				String city = cityTextField.getText();
				String contact = contactTextField.getText();
				
				int status = Librarian.save(name, password, email, address, city, contact);
				
				if(name.equals(null) || password.equals(null) || email.equals(null) || address.equals(null) || city.equals(null) || contact.equals(null)) {
					JOptionPane.showMessageDialog(btnAdd, LibrarianForm.this, "Todos os campos precisam ser preenchidos!",  status, null);
					nameTextField.setText("");
					passwordTextField.setText("");
					emailTextField.setText("");
					addressTextField.setText("");
					cityTextField.setText("");
					contactTextField.setText("");
				}else {
				if(status > 0) {
					JOptionPane.showMessageDialog(btnAdd, LibrarianForm.this,"Bibliotecário adicionado com sucesso!", status, null);
						new AdminSection();
						AdminSection.main(null);
						librarianForm.dispose();
				}else {
					JOptionPane.showMessageDialog(btnAdd, LibrarianForm.this,"Desculpe!, Não foi possível salvar este bibliotecário!", status, null);
				}
			}
		}
		});
		librarianForm.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.setBounds(282, 391, 100, 25);
		librarianForm.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminSection();
				AdminSection.main(null);
				librarianForm.dispose();
			}
		});
	}
}
