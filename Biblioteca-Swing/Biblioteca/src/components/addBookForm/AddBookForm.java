package components.addBookForm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import components.librarianSection.LibrarianSection;
import repository.Book;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class AddBookForm {

	private JFrame addBookForm;
	private JTextField callNoTextField;
	private JTextField nameTextField;
	private JTextField authorTextField;
	private JTextField publisherTextField;
	private JTextField quantityTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookForm window = new AddBookForm();
					window.addBookForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddBookForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addBookForm = new JFrame();
		addBookForm.setTitle("Adicionar Livro");
		addBookForm.getContentPane().setLayout(null);
		addBookForm.setBounds(350, 350, 700, 500);
		addBookForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		callNoTextField = new JTextField();
		callNoTextField.setBounds(282, 47, 156, 19);
		addBookForm.getContentPane().add(callNoTextField);
		callNoTextField.setColumns(10);

		nameTextField = new JTextField();
		nameTextField.setBounds(282, 97, 156, 19);
		addBookForm.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		authorTextField = new JTextField();
		authorTextField.setBounds(282, 147, 156, 19);
		addBookForm.getContentPane().add(authorTextField);
		authorTextField.setColumns(10);

		publisherTextField = new JTextField();
		publisherTextField.setBounds(282, 197, 156, 19);
		addBookForm.getContentPane().add(publisherTextField);
		publisherTextField.setColumns(10);

		quantityTextField = new JTextField();
		quantityTextField.setBounds(282, 247, 156, 19);
		addBookForm.getContentPane().add(quantityTextField);
		quantityTextField.setColumns(10);

		JLabel lblCallno = new JLabel("CallNo:");
		lblCallno.setBounds(175, 49, 70, 15);
		addBookForm.getContentPane().add(lblCallno);

		JLabel lblName = new JLabel("Nome:");
		lblName.setBounds(175, 99, 70, 15);
		addBookForm.getContentPane().add(lblName);

		JLabel lblAuthor = new JLabel("Autor:");
		lblAuthor.setBounds(175, 149, 70, 15);
		addBookForm.getContentPane().add(lblAuthor);

		JLabel lblPublisher = new JLabel("Editora:");
		lblPublisher.setBounds(175, 199, 70, 15);
		addBookForm.getContentPane().add(lblPublisher);

		JLabel lblQuantity = new JLabel("Quantidade:");
		lblQuantity.setBounds(175, 249, 89, 15);
		addBookForm.getContentPane().add(lblQuantity);

		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setBounds(289, 299, 120, 35);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String callno = callNoTextField.getText();
				String name = nameTextField.getText();
				String author = authorTextField.getText();
				String publisher = publisherTextField.getText();
				String squantity = quantityTextField.getText();

				int quantity = Integer.parseInt(squantity);

				int status = Book.save(callno, name, author, publisher, quantity);

				if (status > 0 && callno != "" && name != "" && author != "" && publisher != "" && squantity != "") {
					JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
					new LibrarianSection();
					LibrarianSection.main(null);
					addBookForm.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Desculpe, ocorreu um erro ao salvar!");
					callNoTextField.setText("");
					nameTextField.setText("");
					authorTextField.setText("");
					publisherTextField.setText("");
					quantityTextField.setText("");
				}
			}
		});
		addBookForm.getContentPane().add(btnAdd);

		JButton btnBack = new JButton("Voltar");
		btnBack.setBounds(289, 387, 100, 25);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LibrarianSection();
				LibrarianSection.main(null);
				addBookForm.dispose();
			}
		});
		addBookForm.getContentPane().add(btnBack);
	}
}
