package components.viewBook;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import components.librarianSection.LibrarianSection;
import repository.DB;
import javax.swing.JButton;

public class ViewBook {

	private JFrame viewBook;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBook window = new ViewBook();
					window.viewBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewBook = new JFrame();
		viewBook.setTitle("Livros");
		viewBook.getContentPane().setLayout(null);
		viewBook.setBounds(350, 350, 700, 500);
		viewBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String data[][] = null;
		String column[] = null;

		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from books", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			column = new String[cols];
			for (int i = 1; i <= cols; i++) {
				column[i - 1] = rsmd.getColumnName(i);
			}

			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();

			data = new String[rows][cols];
			int count = 0;
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					data[count][i - 1] = rs.getString(i);
				}
				count++;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		table = new JTable(data, column);
		viewBook.getContentPane().add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 676, 324);
		viewBook.getContentPane().add(scrollPane);
		
		btnBack = new JButton("Voltar");
		btnBack.setBounds(279, 390, 100, 25);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LibrarianSection();
				LibrarianSection.main(null);
				viewBook.dispose();
			}
		});
		viewBook.getContentPane().add(btnBack);
	}

}
