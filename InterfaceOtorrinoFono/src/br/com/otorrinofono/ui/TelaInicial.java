package br.com.otorrinofono.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextFieldNome;
	private JTextField TextFieldDataNascimento;
	private JTextField TextFieldCPF;
	private JTextField textFieldCRMCRFa;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JPasswordField passwordFieldConfirmarSenha;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NomeCompleto = new JLabel("Nome completo");
		NomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NomeCompleto.setBounds(10, 39, 102, 13);
		contentPane.add(NomeCompleto);
		
		JLabel DataNascimento = new JLabel("Data de nascimento");
		DataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DataNascimento.setBounds(10, 62, 125, 13);
		contentPane.add(DataNascimento);
		
		JLabel CPF = new JLabel("CPF");
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CPF.setBounds(10, 85, 29, 13);
		contentPane.add(CPF);
		
		JLabel Genero = new JLabel("Gênero");
		Genero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genero.setBounds(10, 98, 45, 13);
		contentPane.add(Genero);
		
		JLabel Funcao = new JLabel("Função");
		Funcao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Funcao.setBounds(10, 120, 45, 13);
		contentPane.add(Funcao);
		
		JLabel CRMCRFa = new JLabel("CRM/CRFa");
		CRMCRFa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CRMCRFa.setBounds(10, 143, 66, 13);
		contentPane.add(CRMCRFa);
		
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Email.setBounds(10, 166, 34, 13);
		contentPane.add(Email);
		
		JLabel Telefone = new JLabel("Telefone");
		Telefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Telefone.setBounds(10, 193, 54, 13);
		contentPane.add(Telefone);
		
		JLabel Senha = new JLabel("Senha");
		Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Senha.setBounds(10, 217, 45, 13);
		contentPane.add(Senha);
		
		JLabel ConfirmacaoSenha = new JLabel("Confirmação de senha");
		ConfirmacaoSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ConfirmacaoSenha.setBounds(10, 240, 140, 13);
		contentPane.add(ConfirmacaoSenha);
		
		JLabel CadastroDeFuncionarios = new JLabel("Cadastro de funcionários");
		CadastroDeFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		CadastroDeFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CadastroDeFuncionarios.setBounds(117, 10, 199, 19);
		contentPane.add(CadastroDeFuncionarios);
		
		TextFieldNome = new JTextField();
		TextFieldNome.setBounds(157, 39, 102, 13);
		contentPane.add(TextFieldNome);
		TextFieldNome.setColumns(10);
		
		TextFieldDataNascimento = new JTextField();
		TextFieldDataNascimento.setBounds(157, 64, 102, 13);
		contentPane.add(TextFieldDataNascimento);
		TextFieldDataNascimento.setColumns(10);
		
		TextFieldCPF = new JTextField();
		TextFieldCPF.setBounds(157, 84, 102, 13);
		contentPane.add(TextFieldCPF);
		TextFieldCPF.setColumns(10);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(157, 100, 102, 13);
		contentPane.add(comboBoxGenero);
		
		JComboBox comboBoxFuncao = new JComboBox();
		comboBoxFuncao.setBounds(157, 118, 102, 13);
		contentPane.add(comboBoxFuncao);
		
		textFieldCRMCRFa = new JTextField();
		textFieldCRMCRFa.setBounds(157, 142, 102, 13);
		contentPane.add(textFieldCRMCRFa);
		textFieldCRMCRFa.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(157, 168, 102, 13);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(157, 192, 102, 13);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		passwordFieldConfirmarSenha = new JPasswordField();
		passwordFieldConfirmarSenha.setBounds(157, 242, 102, 13);
		contentPane.add(passwordFieldConfirmarSenha);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(157, 216, 102, 13);
		contentPane.add(passwordFieldSenha);
		
		JButton BotaoCadastrar = new JButton("Cadastrar");
		BotaoCadastrar.setBounds(300, 238, 125, 25);
		contentPane.add(BotaoCadastrar);

	}
}
