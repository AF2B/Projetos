package components.index;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import components.loginAdmin.LoginAdmin;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Index {

	private JFrame index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.index.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		index = new JFrame();
		index.getContentPane().setLayout(null);
		index.getContentPane().setBackground(new Color(245, 245, 245));
		index.setBackground(UIManager.getColor("Button.background"));
		index.setTitle("Administração - Biblioteca");
		index.setBounds(350, 350, 700, 500);
		index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAdminLogin = new JButton("Administrador");
		btnAdminLogin.setForeground(Color.BLACK);
		btnAdminLogin.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		btnAdminLogin.setBounds(269, 116, 137, 43);
		btnAdminLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginAdmin();
				LoginAdmin.main(null);
				index.dispose();
			}
		});
		
		index.getContentPane().add(btnAdminLogin);
		
		JButton btnLibrarianLogin = new JButton("Bibliotecário");
		btnLibrarianLogin.setForeground(Color.BLACK);
		btnLibrarianLogin.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		btnLibrarianLogin.setBounds(269, 241, 137, 43);
		btnLibrarianLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}});
		index.getContentPane().add(btnLibrarianLogin);
		
		JLabel lblWelcome = new JLabel("Bem vindo ao Sistema da Biblioteca");
		lblWelcome.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 20));
		lblWelcome.setBounds(169, 28, 363, 24);
		index.getContentPane().add(lblWelcome);
		
		JLabel lblYouAre = new JLabel("Você é:");
		lblYouAre.setBounds(162, 130, 70, 15);
		index.getContentPane().add(lblYouAre);
		
		JLabel lblYouAre2 = new JLabel("Você é:");
		lblYouAre2.setBounds(162, 255, 70, 15);
		index.getContentPane().add(lblYouAre2);
		
		
}
		}
