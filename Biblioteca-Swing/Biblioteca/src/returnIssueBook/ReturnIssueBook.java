package returnIssueBook;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import components.librarianSection.LibrarianSection;
import repository.ReturnBook;

public class ReturnIssueBook {

	private JFrame returnIssueBook;
	private JTextField bookCallNoTextField;
	private JTextField studentIdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnIssueBook window = new ReturnIssueBook();
					window.returnIssueBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReturnIssueBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		returnIssueBook = new JFrame();
		returnIssueBook.setTitle("Retornar Livro");
		returnIssueBook.getContentPane().setLayout(null);
		returnIssueBook.setBounds(350, 350, 700, 500);
		returnIssueBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		@SuppressWarnings("unused")
		JLabel lblBookCallno = new JLabel("Livro Callno:");
		lblBookCallno.setLocation(107, 100);
		lblBookCallno.setSize(93, 15);
		returnIssueBook.getContentPane().add(lblBookCallno);

		@SuppressWarnings("unused")
		JLabel lblStudentId = new JLabel("Estudante Id:");
		lblStudentId.setLocation(100, 158);
		lblStudentId.setSize(100, 15);
		returnIssueBook.getContentPane().add(lblStudentId);

		bookCallNoTextField = new JTextField();
		bookCallNoTextField.setColumns(10);
		bookCallNoTextField.setBounds(268, 98, 156, 19);
		returnIssueBook.getContentPane().add(bookCallNoTextField);

		studentIdTextField = new JTextField();
		studentIdTextField.setColumns(10);
		studentIdTextField.setBounds(268, 154, 156, 19);
		returnIssueBook.getContentPane().add(studentIdTextField);

		JButton btnReturnBook = new JButton("Retornar Livro");
		btnReturnBook.setLocation(268, 198);
		btnReturnBook.setSize(140, 35);
		returnIssueBook.getContentPane().add(btnReturnBook);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookcallno = bookCallNoTextField.getText();
				String sstudentid = studentIdTextField.getText();
				int studentid = Integer.parseInt(sstudentid);
				int status = ReturnBook.delete(bookcallno, studentid);
				if (status > 0 && bookcallno != "" && sstudentid != "") {
					JOptionPane.showMessageDialog(null, "Livro retornado com sucesso!");
					new LibrarianSection();
					LibrarianSection.main(null);
					returnIssueBook.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Desculpe, não foi possível retornar o livro.");
				}
			}
		});

		@SuppressWarnings("unused")
		JLabel lblNewLabel = new JLabel("Note: Cheque a propriedade do livro!");

		JButton btnBack = new JButton("Voltar");
		btnBack.setLocation(278, 293);
		btnBack.setSize(100, 25);
		returnIssueBook.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSection.main(new String[] {});
				returnIssueBook.dispose();
			}
		});
	}

}
