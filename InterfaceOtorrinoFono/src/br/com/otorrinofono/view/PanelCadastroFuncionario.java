package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PanelCadastroFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField_ConfirmacaoSenha;
	private JPasswordField passwordField_SenhaFunc;
	private JTextField textFieldTelefone;
	private JTextField textField_EmailFunc;
	private JTextField textField_CRMCRFaFunc;
	private JTextField textField_CPFFunc;
	private JTextField textField_DataNascFunc;
	private JTextField textField_NomeCompletoFunc;
	private String origem;

	private JPanel painelAnterior;
	
	/**
	 * Create the panel.
	 */
	public PanelCadastroFuncionario() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 65, 718, 443);
		add(panel);
		panel.setLayout(null);
		
		JLabel LabelCadastroFuncionarios = new JLabel("Cadastro de Funcionário");
		LabelCadastroFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		LabelCadastroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelCadastroFuncionarios.setBounds(257, 28, 199, 19);
		panel.add(LabelCadastroFuncionarios);
		
		JLabel LabelNomeCompleto = new JLabel("Nome completo");
		LabelNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNomeCompleto.setBounds(34, 79, 99, 13);
		panel.add(LabelNomeCompleto);
		
		JLabel labelDataNascimento = new JLabel("Data de nascimento");
		labelDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNascimento.setBounds(34, 112, 125, 13);
		panel.add(labelDataNascimento);
		
		JLabel labelCPF = new JLabel("CPF");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCPF.setBounds(34, 142, 24, 13);
		panel.add(labelCPF);
		
		JLabel labelGenero = new JLabel("Gênero");
		labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGenero.setBounds(34, 176, 45, 13);
		panel.add(labelGenero);
		
		JLabel labelFuncao = new JLabel("Função");
		labelFuncao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFuncao.setBounds(34, 208, 45, 13);
		panel.add(labelFuncao);
		
		JLabel labelCRMCRFa = new JLabel("CRM/CRFa");
		labelCRMCRFa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCRMCRFa.setBounds(34, 244, 66, 13);
		panel.add(labelCRMCRFa);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(34, 277, 36, 13);
		panel.add(labelEmail);
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefone.setBounds(34, 308, 56, 13);
		panel.add(labelTelefone);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSenha.setBounds(34, 343, 39, 13);
		panel.add(labelSenha);
		
		JLabel labelConfirmacaoSenha = new JLabel("Confirmação de senha");
		labelConfirmacaoSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelConfirmacaoSenha.setBounds(34, 376, 147, 13);
		panel.add(labelConfirmacaoSenha);
		
		JButton botaoCadastrarFuncionario = new JButton("Cadastrar");
		botaoCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textField_NomeCompletoFunc.getText();
				String password = String.valueOf(passwordField_SenhaFunc.getPassword());
				String confirmationPassword = String.valueOf(passwordField_ConfirmacaoSenha.getPassword());
				
				JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(PanelCadastroFuncionario.this);
				
				try {
					UserController controller = new UserController();
					controller.registerUser(login, password, confirmationPassword);
					JOptionPane.showMessageDialog(parentFrame, "Sucesso ao cadastrar usuário", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (BusinessException be) {
					JOptionPane.showMessageDialog(parentFrame, se.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (SystemException se) {
					JOptionPane.showMessageDialog(PanelCadastroFuncionario.this.frame, se.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botaoCadastrarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoCadastrarFuncionario.setBounds(581, 405, 125, 25);
		panel.add(botaoCadastrarFuncionario);
		
		passwordField_ConfirmacaoSenha = new JPasswordField();
		passwordField_ConfirmacaoSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField_ConfirmacaoSenha.setBounds(180, 372, 234, 19);
		panel.add(passwordField_ConfirmacaoSenha);
		
		passwordField_SenhaFunc = new JPasswordField();
		passwordField_SenhaFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField_SenhaFunc.setBounds(180, 340, 234, 19);
		panel.add(passwordField_SenhaFunc);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefone.setBounds(180, 303, 234, 19);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textField_EmailFunc = new JTextField();
		textField_EmailFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_EmailFunc.setColumns(10);
		textField_EmailFunc.setBounds(180, 276, 234, 19);
		panel.add(textField_EmailFunc);
		
		textField_CRMCRFaFunc = new JTextField();
		textField_CRMCRFaFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CRMCRFaFunc.setColumns(10);
		textField_CRMCRFaFunc.setBounds(180, 243, 234, 19);
		panel.add(textField_CRMCRFaFunc);
		
		textField_CPFFunc = new JTextField();
		textField_CPFFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CPFFunc.setColumns(10);
		textField_CPFFunc.setBounds(180, 143, 234, 19);
		panel.add(textField_CPFFunc);
		
		textField_DataNascFunc = new JTextField();
		textField_DataNascFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_DataNascFunc.setColumns(10);
		textField_DataNascFunc.setBounds(180, 110, 234, 19);
		panel.add(textField_DataNascFunc);
		
		textField_NomeCompletoFunc = new JTextField();
		textField_NomeCompletoFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_NomeCompletoFunc.setColumns(10);
		textField_NomeCompletoFunc.setBounds(180, 78, 234, 19);
		panel.add(textField_NomeCompletoFunc);
		
		JComboBox comboBox_GeneroFunc = new JComboBox();
		comboBox_GeneroFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_GeneroFunc.setBounds(180, 170, 234, 21);
		panel.add(comboBox_GeneroFunc);
		
		JComboBox comboBox_FuncaoFunc = new JComboBox();
		comboBox_FuncaoFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_FuncaoFunc.setBounds(180, 206, 234, 21);
		panel.add(comboBox_FuncaoFunc);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelPaginaFuncionario painelPaginaFuncionario = new PanelPaginaFuncionario();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelAnterior);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnVoltar.setBounds(11, 408, 125, 25);
		panel.add(btnVoltar);
	}
	
	public JPanel getPainelAnterior() {
		return painelAnterior;
	}

	public void setPainelAnterior(JPanel painelAnterior) {
		this.painelAnterior = painelAnterior;
	}
}
