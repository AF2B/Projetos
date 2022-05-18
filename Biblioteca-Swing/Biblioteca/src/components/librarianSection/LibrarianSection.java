package components.librarianSection;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import components.addBookForm.AddBookForm;
import components.index.Index;
import components.issueBookForm.IssueBookForm;
import components.viewBook.ViewBook;
import components.viewIssueBook.ViewIssueBook;
import returnIssueBook.ReturnIssueBook;

public class LibrarianSection {

	private JFrame librarianSection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianSection window = new LibrarianSection();
					window.librarianSection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibrarianSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		librarianSection = new JFrame();
		librarianSection.setTitle("Bibliotecário");
		librarianSection.getContentPane().setLayout(null);
		librarianSection.setBounds(350, 350, 700, 500);
		librarianSection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnAddBook = new JButton("Adicionar Livro");
		btnAddBook.setBounds(247, 74, 203, 25);
		btnAddBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookForm();
				AddBookForm.main(null);
				librarianSection.dispose();
			}
		});
		librarianSection.getContentPane().add(btnAddBook);

		JButton btnCheckBook = new JButton("Livros");
		btnCheckBook.setBounds(247, 124, 203, 25);
		btnCheckBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewBook();
				ViewBook.main(null);
				librarianSection.dispose();
			}
		});
		librarianSection.getContentPane().add(btnCheckBook);

		JButton btnIssueBook = new JButton("Issue Livro");
		btnIssueBook.setBounds(247, 174, 203, 25);
		btnIssueBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new IssueBookForm();
				IssueBookForm.main(null);
				librarianSection.dispose();
			}
		});
		librarianSection.getContentPane().add(btnIssueBook);

		JButton btnViewIssueBook = new JButton("Visualizar Issue Livros");
		btnViewIssueBook.setBounds(247, 224, 203, 25);
		btnViewIssueBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewIssueBook();
				ViewIssueBook.main(null);
				librarianSection.dispose();
			}
		});
		librarianSection.getContentPane().add(btnViewIssueBook);

		JButton btnReturnBook = new JButton("Retornar Livro");
		btnReturnBook.setBounds(247, 274, 203, 25);
		btnReturnBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReturnIssueBook();
				ReturnIssueBook.main(null);
				librarianSection.dispose();
			}
		});
		librarianSection.getContentPane().add(btnReturnBook);

		JButton btnLogout = new JButton("Sair");
		btnLogout.setBounds(247, 324, 203, 25);
		librarianSection.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Index();
				Index.main(null);
				librarianSection.dispose();
			}
		});
	}

}
