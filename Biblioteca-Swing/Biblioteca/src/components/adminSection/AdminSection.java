package components.adminSection;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import components.addLibrarianForm.LibrarianForm;
import components.checkLibrarian.CheckLibrarian;
import components.deleteLibrarian.DeleteLibrarian;
import components.index.Index;

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
		
		JButton btnAddLibrarian = new JButton("Adicionar Bibliotecário");
		btnAddLibrarian.setBounds(247, 74, 203, 25);
		adminSection.getContentPane().add(btnAddLibrarian);
		btnAddLibrarian.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LibrarianForm();
				LibrarianForm.main(null);
				adminSection.dispose();
			}
		});
		
		JButton btnCheckLibrarian = new JButton("Checar Bibliotecário");
		btnCheckLibrarian.setBounds(247, 139, 203, 25);
		btnCheckLibrarian.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckLibrarian();
				CheckLibrarian.main(null);
				adminSection.dispose();
			}
		});
		adminSection.getContentPane().add(btnCheckLibrarian);
		
		JButton btnDeleteLibrarian = new JButton("Deletar Bibliotecário");
		btnDeleteLibrarian.setBounds(247, 202, 203, 25);
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteLibrarian();
				DeleteLibrarian.main(null);
				adminSection.dispose();
			}
		});
		adminSection.getContentPane().add(btnDeleteLibrarian);
		
		JButton btnExit = new JButton("Sair");
		btnExit.setBounds(290, 306, 100, 25);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Index();
				Index.main(null);
				adminSection.dispose();
			}
		});
		adminSection.getContentPane().add(btnExit);
		
	}

}
