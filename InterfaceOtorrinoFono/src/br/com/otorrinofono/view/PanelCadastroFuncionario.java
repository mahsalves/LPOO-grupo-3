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

import br.com.otorrinofono.entities.Funcionario;
import br.com.otorrinofono.business.FuncionarioController;
import br.com.otorrinofono.exception.BusinessException;
import br.com.otorrinofono.exception.SystemException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
	private JComboBox<String> comboBox_GeneroFunc;
    private JComboBox<String> comboBox_FuncaoFunc;

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
				try {
		            Funcionario funcionario = new Funcionario();
		            funcionario.setNome(textField_NomeCompletoFunc.getText());
		            funcionario.setCpf(textField_CPFFunc.getText());
		            funcionario.setEmail(textField_EmailFunc.getText());
		            funcionario.setSenha(String.valueOf(passwordField_SenhaFunc.getPassword()));
		            funcionario.setGenero((String) comboBox_GeneroFunc.getSelectedItem());
		            funcionario.setFuncao((String) comboBox_FuncaoFunc.getSelectedItem());
		            funcionario.setCrmCrf(textField_CRMCRFaFunc.getText());
		            funcionario.setAdministrador(false);
		            try {
		                String dataStr = textField_DataNascFunc.getText();
		                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		                LocalDate dataNasc = LocalDate.parse(dataStr, formatter);
		                funcionario.setDataNascimento(dataNasc);
		            } catch (DateTimeParseException ex) {
		                JOptionPane.showMessageDialog(PanelCadastroFuncionario.this, "Data de nascimento inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
		    
		            String confirmacaoSenha = String.valueOf(passwordField_ConfirmacaoSenha.getPassword());
		            
		            
		            FuncionarioController controller = new FuncionarioController();
		            controller.cadastrarFuncionario(funcionario, confirmacaoSenha);
		            
		            
		            JOptionPane.showMessageDialog(PanelCadastroFuncionario.this, "Funcionário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		            limparCampos();
		            
		        } catch (BusinessException be) {
		            JOptionPane.showMessageDialog(PanelCadastroFuncionario.this, be.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
		        } catch (SystemException se) {
		            JOptionPane.showMessageDialog(PanelCadastroFuncionario.this, se.getMessage(), "Erro no sistema", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(PanelCadastroFuncionario.this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
		
		comboBox_GeneroFunc = new JComboBox<>();
		comboBox_GeneroFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_GeneroFunc.setBounds(180, 170, 234, 21);
		panel.add(comboBox_GeneroFunc);
		comboBox_GeneroFunc.addItem("Masculino");
		comboBox_GeneroFunc.addItem("Feminino");
		comboBox_GeneroFunc.addItem("Transgênero");
		comboBox_GeneroFunc.addItem("Outro");
		
		comboBox_FuncaoFunc = new JComboBox<>();
		comboBox_FuncaoFunc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_FuncaoFunc.setBounds(180, 206, 234, 21);
		panel.add(comboBox_FuncaoFunc);
		comboBox_FuncaoFunc.addItem("Fonoaudiólogo(a)");
		comboBox_FuncaoFunc.addItem("Otorrinolaringologista");
		comboBox_FuncaoFunc.addItem("Estagiário(a)");
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    
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
	
	
	public void limparCampos() {
	    textField_NomeCompletoFunc.setText("");
	    textField_CPFFunc.setText("");
	    textField_EmailFunc.setText("");
	    textField_DataNascFunc.setText("");
	    textField_CRMCRFaFunc.setText("");
	    textFieldTelefone.setText("");
	    
	    passwordField_SenhaFunc.setText("");
	    passwordField_ConfirmacaoSenha.setText("");
	    
	    comboBox_GeneroFunc.setSelectedIndex(0);
	    comboBox_FuncaoFunc.setSelectedIndex(0);
	}
	
	
	public JPanel getPainelAnterior() {
		return painelAnterior;
	}

	public void setPainelAnterior(JPanel painelAnterior) {
		this.painelAnterior = painelAnterior;
	}
}
