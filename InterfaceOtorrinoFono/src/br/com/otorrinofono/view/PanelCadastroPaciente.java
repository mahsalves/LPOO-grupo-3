package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import br.com.otorrinofono.entities.Paciente;
import br.com.otorrinofono.business.PacienteController;
import br.com.otorrinofono.exception.BusinessException;
import br.com.otorrinofono.exception.SystemException;

public class PanelCadastroPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldCidade;
	private JTextField textFieldEndereco;
	private JTextField textFieldProntuario;
	private JComboBox<String> comboBoxGenero;
    private JComboBox<String> comboBoxEstado;
	
	private JTextField textFieldTelefone;
	private JTextField textFieldCEP;
	private JTextField textFieldCpf;
	private JTextField textFieldDataNascimento;
	
	private JPanel painelAnterior;

	public PanelCadastroPaciente(JPanel painelAnterior) {
	    this.painelAnterior = painelAnterior;
	    setLayout(null);
	}

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
		labelTituloCadastro.setBounds(275, 11, 200, 26);
		panelInternoCadastroP.add(labelTituloCadastro);
		
		JLabel labelNome = new JLabel("Nome Completo");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNome.setBounds(40, 40, 114, 22);
		panelInternoCadastroP.add(labelNome);
		
		JLabel labelDataNasc = new JLabel("Data de nascimento");
		labelDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNasc.setBounds(40, 70, 131, 22);
		panelInternoCadastroP.add(labelDataNasc);
		
		JLabel labelCpf = new JLabel("CPF");
		labelCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCpf.setBounds(40, 228, 29, 22);
		panelInternoCadastroP.add(labelCpf);
		
		JLabel labelGenero = new JLabel("Gênero");
		labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGenero.setBounds(375, 130, 51, 22);
		panelInternoCadastroP.add(labelGenero);
		
		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(40, 100, 44, 22);
		panelInternoCadastroP.add(labelEmail);
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefone.setBounds(40, 130, 56, 22);
		panelInternoCadastroP.add(labelTelefone);
		
		JLabel labelEndereco = new JLabel("Endereço");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEndereco.setBounds(40, 190, 66, 22);
		panelInternoCadastroP.add(labelEndereco);
		
		JLabel labelCidade = new JLabel("Cidade");
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCidade.setBounds(40, 160, 50, 22);
		panelInternoCadastroP.add(labelCidade);
		
		JLabel labelEstado = new JLabel("Estado");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEstado.setBounds(375, 160, 47, 22);
		panelInternoCadastroP.add(labelEstado);
		
		JLabel labelCep = new JLabel("CEP");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCep.setBounds(375, 190, 29, 22);
		panelInternoCadastroP.add(labelCep);
		
		JLabel labelProntuario = new JLabel("Número de prontuário");
		labelProntuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelProntuario.setBounds(40, 256, 144, 22);
		panelInternoCadastroP.add(labelProntuario);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Paciente paciente = new Paciente();
					paciente.setNome(textFieldNome.getText());
					paciente.setCpf(textFieldCpf.getText());
					paciente.setEmail(textFieldEmail.getText());
					paciente.setTelefone(textFieldTelefone.getText());
					paciente.setCidade(textFieldCidade.getText());
					paciente.setEndereco(textFieldEndereco.getText());
					paciente.setCep(textFieldCEP.getText());
					paciente.setNumeroProntuario(textFieldProntuario.getText());
					
					paciente.setGenero(comboBoxGenero.getSelectedItem() != null ? comboBoxGenero.getSelectedItem().toString() : "");
					paciente.setEstado(comboBoxEstado.getSelectedItem() != null ? comboBoxEstado.getSelectedItem().toString() : "");

	
					String dataNascTexto = textFieldDataNascimento.getText();
					if (!dataNascTexto.isEmpty()) {
						try {
							paciente.setDataNascimento(LocalDate.parse(dataNascTexto, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
						} catch (DateTimeParseException ex) {
							JOptionPane.showMessageDialog(PanelCadastroPaciente.this, "Formato de Data de Nascimento inválido. Use DD/MM/YYYY.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} else {
						paciente.setDataNascimento(null);
					}

					PacienteController controller = new PacienteController();
					controller.cadastrarPaciente(paciente);

					JOptionPane.showMessageDialog(PanelCadastroPaciente.this, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
					
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(botaoCadastrar);
			        PanelPaginaPaciente painelPerfil = new PanelPaginaPaciente(paciente);
			        frame.getContentPane().removeAll();
			        frame.getContentPane().add(painelPerfil);
			        frame.revalidate();
			        frame.repaint();

				} catch (BusinessException be) {
					JOptionPane.showMessageDialog(PanelCadastroPaciente.this, be.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
				} catch (SystemException se) {
					JOptionPane.showMessageDialog(PanelCadastroPaciente.this, se.getMessage(), "Erro no sistema", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(PanelCadastroPaciente.this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			
			}
		});
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoCadastrar.setBounds(578, 454, 150, 25);
		panelInternoCadastroP.add(botaoCadastrar);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNome.setBounds(172, 39, 303, 20);
		panelInternoCadastroP.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		comboBoxGenero = new JComboBox<>();
		comboBoxGenero.setBounds(445, 130, 137, 22);
		panelInternoCadastroP.add(comboBoxGenero);
		comboBoxGenero.addItem("Masculino");
		comboBoxGenero.addItem("Feminino");
		comboBoxGenero.addItem("Transgênero");
		comboBoxGenero.addItem("Outro");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(172, 100, 303, 20);
		panelInternoCadastroP.add(textFieldEmail);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCidade.setBounds(172, 159, 194, 20);
		panelInternoCadastroP.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(172, 189, 194, 20);
		panelInternoCadastroP.add(textFieldEndereco);
		
		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setBounds(445, 158, 137, 22);
		panelInternoCadastroP.add(comboBoxEstado);
		comboBoxEstado.addItem("AC");
		comboBoxEstado.addItem("AL");
		comboBoxEstado.addItem("AP");
		comboBoxEstado.addItem("AM");
		comboBoxEstado.addItem("BA");
		comboBoxEstado.addItem("CE");
		comboBoxEstado.addItem("DF");
		comboBoxEstado.addItem("ES");
		comboBoxEstado.addItem("GO");
		comboBoxEstado.addItem("MA");
		comboBoxEstado.addItem("MT");
		comboBoxEstado.addItem("MS");
		comboBoxEstado.addItem("MG");
		comboBoxEstado.addItem("PA");
		comboBoxEstado.addItem("PB");
		comboBoxEstado.addItem("PR");
		comboBoxEstado.addItem("PE");
		comboBoxEstado.addItem("PI");
		comboBoxEstado.addItem("RJ");
		comboBoxEstado.addItem("RN");
		comboBoxEstado.addItem("RS");
		comboBoxEstado.addItem("RO");
		comboBoxEstado.addItem("RR");
		comboBoxEstado.addItem("SC");
		comboBoxEstado.addItem("SP");
		comboBoxEstado.addItem("SE");
		comboBoxEstado.addItem("TO");

		
		textFieldProntuario = new JTextField();
		textFieldProntuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldProntuario.setColumns(10);
		textFieldProntuario.setBounds(191, 255, 174, 20);
		panelInternoCadastroP.add(textFieldProntuario);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);
			    
			    JPanel painelAnterior = getPainelAnterior();

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelAnterior);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(20, 454, 150, 25);
		panelInternoCadastroP.add(btnVoltar);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefone.setBounds(172, 129, 194, 20);
		panelInternoCadastroP.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(444, 192, 138, 20);
		panelInternoCadastroP.add(textFieldCEP);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(172, 227, 193, 20);
		panelInternoCadastroP.add(textFieldCpf);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(172, 69, 194, 20);
		panelInternoCadastroP.add(textFieldDataNascimento);
	}
		
	
		public void limparCampos() {
			textFieldNome.setText("");
			textFieldCpf.setText("");
			textFieldEmail.setText("");
			textFieldDataNascimento.setText("");
			textFieldProntuario.setText("");
			textFieldTelefone.setText("");
			textFieldCEP.setText("");
			textFieldCidade.setText("");
			textFieldEndereco.setText("");
	    
			comboBoxGenero.setSelectedIndex(0);
			comboBoxEstado.setSelectedIndex(0);
		}
	
	
		public JPanel getPainelAnterior() {
			return painelAnterior;
		}

		public void setPainelAnterior(JPanel painelAnterior) {
			this.painelAnterior = painelAnterior;
	}
}
