package components.checkLibrarian;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JTable;

import components.adminSection.AdminSection;
import repository.DB;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CheckLibrarian {

	private JFrame checkLibrarian;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckLibrarian window = new CheckLibrarian();
					window.checkLibrarian.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckLibrarian() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		checkLibrarian = new JFrame();
		checkLibrarian.setTitle("Bibliotecários");
		checkLibrarian.getContentPane().setLayout(null);
		checkLibrarian.setBounds(350, 350, 700, 500);
		checkLibrarian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String data[][] = null;
		String column[] = null;

		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from librarian", ResultSet.TYPE_SCROLL_SENSITIVE,
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
		checkLibrarian.getContentPane().add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 676, 324);
		checkLibrarian.getContentPane().add(scrollPane);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.setBounds(287, 395, 100, 30);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminSection();
				AdminSection.main(null);
				checkLibrarian.dispose();
			}
		});
		checkLibrarian.getContentPane().add(btnBack);

	}
}
