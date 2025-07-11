package br.com.otorrinofono.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(0, 128, 255));
		panelLogin.setBounds(0, 0, 884, 561);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JPanel panelInternoLogin = new JPanel();
		panelInternoLogin.setBounds(239, 141, 400, 250);
		panelLogin.add(panelInternoLogin);
		panelInternoLogin.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Interface Otorrino./Fono.");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTitulo.setBounds(100, 11, 208, 14);
		panelInternoLogin.add(labelTitulo);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(100, 65, 50, 14);
		panelInternoLogin.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(100, 121, 46, 14);
		panelInternoLogin.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(100, 90, 197, 20);
		panelInternoLogin.add(textField);
		textField.setColumns(10);
		
		PanelMenu painelMenu = new PanelMenu();
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().remove(panelLogin);

		        getContentPane().add(painelMenu);

		        revalidate();
		        repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(150, 214, 100, 25);
		panelInternoLogin.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 146, 199, 20);
		panelInternoLogin.add(passwordField);

	}
}
