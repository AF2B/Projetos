package components.deleteLibrarian;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import components.adminSection.AdminSection;
import repository.Librarian;

import javax.swing.JButton;

public class DeleteLibrarian {

	private JFrame deleteLibrarian;
	private JTextField idTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLibrarian window = new DeleteLibrarian();
					window.deleteLibrarian.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteLibrarian() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deleteLibrarian = new JFrame();
		deleteLibrarian.setTitle("Deletar Bibliotecário");
		deleteLibrarian.getContentPane().setLayout(null);
		deleteLibrarian.setBounds(350, 350, 700, 500);
		deleteLibrarian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(168, 53, 30, 15);
		deleteLibrarian.getContentPane().add(lblId);

		idTextField = new JTextField();
		idTextField.setBounds(283, 51, 114, 19);
		deleteLibrarian.getContentPane().add(idTextField);
		idTextField.setColumns(10);

		JButton btnDelete = new JButton("Deletar");
		btnDelete.setBounds(283, 107, 117, 35);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sid = idTextField.getText();
				if (sid == null || sid.trim().equals("")) {
					JOptionPane.showMessageDialog(btnDelete, DeleteLibrarian.this, "O ID não pode ser vázio!", 0, null);
				} else {
					int id = Integer.parseInt(sid);
					int status = Librarian.delete(id);
					if (status > 0) {
						JOptionPane.showMessageDialog(btnDelete, DeleteLibrarian.this, "Bibliotecário apagado com sucesso!", status, null);
					} else {
						JOptionPane.showMessageDialog(btnDelete, DeleteLibrarian.this, "Impossível apagar este ID ou este ID não existe!", status, null);
					}
				}
			}
		});
		deleteLibrarian.getContentPane().add(btnDelete);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(294, 234, 100, 19);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminSection();
				AdminSection.main(null);
				deleteLibrarian.dispose();
			}
		});
		deleteLibrarian.getContentPane().add(btnCancel);

	}
}
