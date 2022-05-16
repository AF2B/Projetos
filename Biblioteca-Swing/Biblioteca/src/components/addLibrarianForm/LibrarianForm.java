package components.addLibrarianForm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import components.adminSection.AdminSection;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LibrarianForm {
	private JFrame librarianForm;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		textField = new JTextField();
		textField.setBounds(282, 47, 156, 19);
		librarianForm.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(282, 82, 156, 19);
		librarianForm.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(282, 117, 156, 19);
		librarianForm.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(282, 152, 156, 19);
		librarianForm.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(282, 187, 156, 19);
		librarianForm.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(282, 222, 156, 19);
		librarianForm.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(174, 49, 70, 15);
		librarianForm.getContentPane().add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(174, 84, 70, 15);
		librarianForm.getContentPane().add(lblSenha);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(174, 119, 70, 15);
		librarianForm.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Endereço");
		lblNewLabel.setBounds(174, 154, 70, 15);
		librarianForm.getContentPane().add(lblNewLabel);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(174, 189, 70, 15);
		librarianForm.getContentPane().add(lblCidade);
		
		JLabel lblNewLabel_1 = new JLabel("Contato");
		lblNewLabel_1.setBounds(174, 224, 70, 15);
		librarianForm.getContentPane().add(lblNewLabel_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(282, 270, 117, 35);
		librarianForm.getContentPane().add(btnAdicionar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(282, 391, 100, 25);
		librarianForm.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminSection();
				AdminSection.main(null);
				librarianForm.dispose();
			}
		});
	}
}
