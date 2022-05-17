package components.checkLibrarian;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
		
		table = new JTable(data, column);
		checkLibrarian.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 676, 324);
		checkLibrarian.getContentPane().add(scrollPane);
		
		
		
		
		
	}
}
