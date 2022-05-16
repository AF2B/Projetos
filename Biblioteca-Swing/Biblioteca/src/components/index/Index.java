package components.index;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Index {

	private JFrame frmAdministracaoBiblioteca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
					window.frmAdministracaoBiblioteca.setVisible(true);
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
		frmAdministracaoBiblioteca = new JFrame();
		frmAdministracaoBiblioteca.getContentPane().setLayout(null);
		frmAdministracaoBiblioteca.getContentPane().setBackground(new Color(245, 245, 245));
		frmAdministracaoBiblioteca.setBackground(UIManager.getColor("Button.background"));
		frmAdministracaoBiblioteca.setTitle("Administração - Biblioteca");
		frmAdministracaoBiblioteca.setBounds(350, 350, 700, 500);
		frmAdministracaoBiblioteca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setForeground(Color.BLACK);
		btnAdministrador.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		btnAdministrador.setBounds(269, 116, 137, 43);
		frmAdministracaoBiblioteca.getContentPane().add(btnAdministrador);
		
		JButton btnBibliotecario = new JButton("Bibliotecário");
		btnBibliotecario.setForeground(Color.BLACK);
		btnBibliotecario.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
		btnBibliotecario.setBounds(269, 241, 137, 43);
		frmAdministracaoBiblioteca.getContentPane().add(btnBibliotecario);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Sistema da Biblioteca");
		lblBemVindoAo.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 20));
		lblBemVindoAo.setBounds(169, 28, 363, 24);
		frmAdministracaoBiblioteca.getContentPane().add(lblBemVindoAo);
		
		JLabel lblVoc = new JLabel("Você é:");
		lblVoc.setBounds(162, 130, 70, 15);
		frmAdministracaoBiblioteca.getContentPane().add(lblVoc);
		
		JLabel lblVoc_1 = new JLabel("Você é:");
		lblVoc_1.setBounds(162, 255, 70, 15);
		frmAdministracaoBiblioteca.getContentPane().add(lblVoc_1);
		
		
}
		}
