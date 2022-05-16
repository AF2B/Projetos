package components.adminSection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class AdminSection {
	private JFrame adminSection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
					window.adminSection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSection() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminSection = new JFrame();
		adminSection.setTitle("Administrador");
		adminSection.getContentPane().setLayout(null);
		adminSection.setBounds(350, 350, 700, 500);
		adminSection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_2 = new JButton("Adicionar Bibliotecário");
		btnNewButton_2.setBounds(247, 74, 203, 25);
		adminSection.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Checar Bibliotecário");
		btnNewButton_3.setBounds(247, 139, 203, 25);
		adminSection.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Deletar Bibliotecário");
		btnNewButton.setBounds(247, 202, 203, 25);
		adminSection.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBounds(290, 306, 100, 25);
		adminSection.getContentPane().add(btnNewButton_1);
	}

}
