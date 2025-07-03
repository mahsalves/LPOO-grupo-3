package tela_interface;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class PanelCadastroPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldCidade;
	private JTextField textFieldEndereco;

	/**
	 * Create the panel.
	 */
	public PanelCadastroPaciente() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoCadastroP = new JPanel();
		panelInternoCadastroP.setBounds(68, 32, 750, 500);
		add(panelInternoCadastroP);
		panelInternoCadastroP.setLayout(null);
		
		JLabel labelTituloCadastro = new JLabel("Cadastrar Paciente");
		labelTituloCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTituloCadastro.setBounds(275, 11, 200, 18);
		panelInternoCadastroP.add(labelTituloCadastro);
		
		JLabel labelNome = new JLabel("Nome Completo");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNome.setBounds(40, 40, 100, 14);
		panelInternoCadastroP.add(labelNome);
		
		JLabel labelDataNasc = new JLabel("Data de nascimento");
		labelDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNasc.setBounds(40, 70, 122, 14);
		panelInternoCadastroP.add(labelDataNasc);
		
		JLabel labelCpf = new JLabel("CPF");
		labelCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCpf.setBounds(275, 70, 29, 14);
		panelInternoCadastroP.add(labelCpf);
		
		JLabel labelGenero = new JLabel("Gênero");
		labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGenero.setBounds(445, 70, 51, 14);
		panelInternoCadastroP.add(labelGenero);
		
		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(40, 100, 36, 14);
		panelInternoCadastroP.add(labelEmail);
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefone.setBounds(40, 130, 51, 14);
		panelInternoCadastroP.add(labelTelefone);
		
		JLabel labelEndereco = new JLabel("Endereço");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEndereco.setBounds(40, 190, 58, 14);
		panelInternoCadastroP.add(labelEndereco);
		
		JLabel labelCidade = new JLabel("Cidade");
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCidade.setBounds(40, 160, 41, 14);
		panelInternoCadastroP.add(labelCidade);
		
		JLabel labelEstado = new JLabel("Estado");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEstado.setBounds(375, 160, 47, 14);
		panelInternoCadastroP.add(labelEstado);
		
		JLabel labelCep = new JLabel("CEP");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCep.setBounds(375, 190, 29, 14);
		panelInternoCadastroP.add(labelCep);
		
		JLabel labelProntuario = new JLabel("Prontuário");
		labelProntuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelProntuario.setBounds(40, 240, 100, 14);
		panelInternoCadastroP.add(labelProntuario);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoCadastrar.setBounds(300, 450, 150, 25);
		panelInternoCadastroP.add(botaoCadastrar);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNome.setBounds(172, 39, 303, 20);
		panelInternoCadastroP.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JFormattedTextField formattedTextFieldDataNasc = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		formattedTextFieldDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldDataNasc.setBounds(172, 67, 85, 20);
		panelInternoCadastroP.add(formattedTextFieldDataNasc);
		
		JFormattedTextField formattedTextFieldCpf = new JFormattedTextField();
		formattedTextFieldCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldCpf.setBounds(314, 67, 108, 20);
		panelInternoCadastroP.add(formattedTextFieldCpf);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(506, 68, 30, 22);
		panelInternoCadastroP.add(comboBoxGenero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(172, 95, 303, 20);
		panelInternoCadastroP.add(textFieldEmail);
		
		JFormattedTextField formattedTextFieldTelefone = new JFormattedTextField();
		formattedTextFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldTelefone.setBounds(172, 129, 114, 20);
		panelInternoCadastroP.add(formattedTextFieldTelefone);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCidade.setBounds(171, 159, 194, 20);
		panelInternoCadastroP.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(172, 189, 194, 20);
		panelInternoCadastroP.add(textFieldEndereco);
		
		JFormattedTextField formattedTextFieldCep = new JFormattedTextField();
		formattedTextFieldCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextFieldCep.setBounds(445, 189, 76, 20);
		panelInternoCadastroP.add(formattedTextFieldCep);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(445, 158, 30, 22);
		panelInternoCadastroP.add(comboBoxEstado);
		
		JButton botaoAddProtuario = new JButton("Adicionar Prontuário");
		botaoAddProtuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAddProtuario.setBounds(172, 238, 193, 23);
		panelInternoCadastroP.add(botaoAddProtuario);
	}
}
