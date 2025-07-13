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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import br.com.otorrinofono.entities.Funcionario;
import br.com.otorrinofono.data.FuncionarioRepository;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_login;
	private JPasswordField passwordField_senha;

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
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(100, 65, 50, 14);
		panelInternoLogin.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(100, 121, 46, 14);
		panelInternoLogin.add(lblSenha);
		
		textField_login = new JTextField();
		textField_login.setBounds(100, 90, 197, 20);
		panelInternoLogin.add(textField_login);
		textField_login.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cpf = textField_login.getText();
				String senha = new String(passwordField_senha.getPassword());

		        FuncionarioRepository repo = new FuncionarioRepository();
		        Funcionario funcionario = repo.autenticar(cpf, senha);

		        if (funcionario != null) {
		            JOptionPane.showMessageDialog(null, "Login bem-sucedido!");

		            PanelMenu painelMenu = new PanelMenu();
		            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnEntrar);
		            frame.setContentPane(painelMenu);
		            frame.revalidate();
		            frame.repaint();
		        } else {
		            JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
		        }
		    }
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(150, 214, 100, 25);
		panelInternoLogin.add(btnEntrar);
		
		passwordField_senha = new JPasswordField();
		passwordField_senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField_senha.setBounds(98, 146, 199, 20);
		panelInternoLogin.add(passwordField_senha);

	}
}
