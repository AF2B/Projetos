package components.issueBookForm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import components.librarianSection.LibrarianSection;
import repository.Issue;

public class IssueBookForm {

	private JFrame issueBookForm;
	private JTextField bookCallNoTextField;
	private JTextField studentIdTextField;
	private JTextField studentNameTextField;
	private JTextField studentContactTextField;
	private JButton btnIssueBook;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBookForm window = new IssueBookForm();
					window.issueBookForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IssueBookForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		issueBookForm = new JFrame();
		issueBookForm.setTitle("Issue Book");
		issueBookForm.getContentPane().setLayout(null);
		issueBookForm.setBounds(350, 350, 700, 500);
		issueBookForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bookCallNoTextField = new JTextField();
		bookCallNoTextField.setBounds(282, 47, 156, 19);
		issueBookForm.getContentPane().add(bookCallNoTextField);
		bookCallNoTextField.setColumns(10);

		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(282, 82, 156, 19);
		studentIdTextField.setColumns(10);
		issueBookForm.getContentPane().add(studentIdTextField);

		studentNameTextField = new JTextField();
		studentNameTextField.setBounds(282, 117, 156, 19);
		studentNameTextField.setColumns(10);
		issueBookForm.getContentPane().add(studentNameTextField);

		studentContactTextField = new JTextField();
		studentContactTextField.setBounds(282, 152, 156, 19);
		studentContactTextField.setColumns(10);
		issueBookForm.getContentPane().add(studentContactTextField);

		JLabel lblCallNo = new JLabel("CallNo:");
		lblCallNo.setBounds(174, 49, 70, 15);
		issueBookForm.getContentPane().add(lblCallNo);

		JLabel lblStudentId = new JLabel("Estudante ID:");
		lblStudentId.setBounds(174, 84, 70, 15);
		issueBookForm.getContentPane().add(lblStudentId);

		JLabel lblStudentName = new JLabel("Nome:");
		lblStudentName.setBounds(174, 119, 70, 15);
		issueBookForm.getContentPane().add(lblStudentName);

		JLabel lblStudentPhone = new JLabel("Contato:");
		lblStudentPhone.setBounds(174, 154, 70, 15);
		issueBookForm.getContentPane().add(lblStudentPhone);

		btnIssueBook = new JButton("Issue Book");
		btnIssueBook.setBounds(282, 270, 120, 35);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String bookcallno = bookCallNoTextField.getText();
				int studentid = Integer.parseInt(studentIdTextField.getText());
				String studentname = studentNameTextField.getText();
				String studentcontact = studentContactTextField.getText();

				if (Issue.checkBook(bookcallno)) {

					int status = Issue.save(bookcallno, studentid, studentname, studentcontact);
					if (status > 0 && bookcallno != "") {
						JOptionPane.showMessageDialog(btnIssueBook ,IssueBookForm.this, "Livro issued com Sucesso!", status, null);
						LibrarianSection.main(new String[] {});
						issueBookForm.dispose();

					} else {
						JOptionPane.showMessageDialog(btnIssueBook ,IssueBookForm.this, "Desculpe, ocorreu um erro com o issue!", status, null);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Callno não existe!");
				}

			}
		});
		issueBookForm.getContentPane().add(btnIssueBook);

		btnBack = new JButton("Voltar");
		btnBack.setBounds(282, 391, 100, 25);
		issueBookForm.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LibrarianSection();
				LibrarianSection.main(null);
				issueBookForm.dispose();
			}
		});
	}
}
