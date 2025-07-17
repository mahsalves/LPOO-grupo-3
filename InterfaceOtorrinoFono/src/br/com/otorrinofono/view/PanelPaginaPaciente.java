package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Optional;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import br.com.otorrinofono.entities.Paciente;
import br.com.otorrinofono.data.PacienteRepository;

public class PanelPaginaPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private String pacienteCpf;
	
	private String nomePaciente;
	private String cpfPaciente;
	private String dataNascPaciente;
	private String telefonePaciente;
	private String emailPaciente;
	private String generoPaciente;
	private String enderecoPaciente;
	private String estadoPaciente;
	private String cepPaciente;
	private String prontuarioPaciente;

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getDataNascPaciente() {
		return dataNascPaciente;
	}

	public void setDataNascPaciente(String dataNascPaciente) {
		this.dataNascPaciente = dataNascPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getGeneroPaciente() {
		return generoPaciente;
	}

	public void setGeneroPaciente(String generoPaciente) {
		this.generoPaciente = generoPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public String getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public String getCepPaciente() {
		return cepPaciente;
	}

	public void setCepPaciente(String cepPaciente) {
		this.cepPaciente = cepPaciente;
	}

	public String getProntuarioPaciente() {
		return prontuarioPaciente;
	}

	public void setProntuarioPaciente(String prontuarioPaciente) {
		this.prontuarioPaciente = prontuarioPaciente;
	}

	/**
	 * Create the panel.
	 */
	public PanelPaginaPaciente(Paciente paciente) {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoPagPaciente = new JPanel();
		panelInternoPagPaciente.setBounds(94, 61, 700, 450);
		add(panelInternoPagPaciente);
		panelInternoPagPaciente.setLayout(null);
		
		JLabel labelTituloPagPaciente = new JLabel("Página do Paciente");
		labelTituloPagPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloPagPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTituloPagPaciente.setBounds(250, 11, 200, 19);
		panelInternoPagPaciente.add(labelTituloPagPaciente);
		
		JLabel labelNomeComp = new JLabel("Nome completo:");
		labelNomeComp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNomeComp.setBounds(10, 40, 127, 15);
		panelInternoPagPaciente.add(labelNomeComp);
		
		JLabel labelDataNasc = new JLabel("Data de nascimento:");
		labelDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNasc.setBounds(10, 70, 137, 15);
		panelInternoPagPaciente.add(labelDataNasc);
		
		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCpf.setBounds(10, 100, 127, 15);
		panelInternoPagPaciente.add(labelCpf);
		
		JLabel labelGenero = new JLabel("Gênero");
		labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGenero.setBounds(10, 130, 127, 15);
		panelInternoPagPaciente.add(labelGenero);
		
		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmail.setBounds(10, 160, 127, 15);
		panelInternoPagPaciente.add(labelEmail);
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefone.setBounds(10, 190, 127, 15);
		panelInternoPagPaciente.add(labelTelefone);
		
		JLabel labelEndereco = new JLabel("Endereço:");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEndereco.setBounds(10, 220, 127, 15);
		panelInternoPagPaciente.add(labelEndereco);
		
		JLabel labelEstado = new JLabel("Estado:");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEstado.setBounds(10, 250, 127, 15);
		panelInternoPagPaciente.add(labelEstado);
		
		JLabel labelCep = new JLabel("CEP:");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCep.setBounds(10, 280, 127, 15);
		panelInternoPagPaciente.add(labelCep);
		
		JLabel labelProntuario = new JLabel("Prontuário:");
		labelProntuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelProntuario.setBounds(10, 310, 127, 15);
		panelInternoPagPaciente.add(labelProntuario);
		
		JLabel labelNomePaciente = new JLabel(nomePaciente);
		labelNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNomePaciente.setBounds(147, 40, 200, 15);
		panelInternoPagPaciente.add(labelNomePaciente);
		
		JLabel labelDataNascPaciente = new JLabel(dataNascPaciente);
		labelDataNascPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNascPaciente.setBounds(147, 70, 200, 15);
		panelInternoPagPaciente.add(labelDataNascPaciente);
		
		JLabel labelCpfPaciente = new JLabel(cpfPaciente);
		labelCpfPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCpfPaciente.setBounds(147, 100, 200, 15);
		panelInternoPagPaciente.add(labelCpfPaciente);
		
		JLabel labelGeneroPaciente = new JLabel(generoPaciente);
		labelGeneroPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGeneroPaciente.setBounds(147, 130, 200, 15);
		panelInternoPagPaciente.add(labelGeneroPaciente);
		
		JLabel labelEmailPaciente = new JLabel(emailPaciente);
		labelEmailPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmailPaciente.setBounds(147, 160, 200, 15);
		panelInternoPagPaciente.add(labelEmailPaciente);
		
		JLabel labelTelefonePaciente = new JLabel(telefonePaciente);
		labelTelefonePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefonePaciente.setBounds(147, 190, 200, 15);
		panelInternoPagPaciente.add(labelTelefonePaciente);
		
		JLabel labelEnderecoPaciente = new JLabel(enderecoPaciente);
		labelEnderecoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEnderecoPaciente.setBounds(147, 220, 200, 15);
		panelInternoPagPaciente.add(labelEnderecoPaciente);
		
		JLabel labelEstadoPaciente = new JLabel(estadoPaciente);
		labelEstadoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEstadoPaciente.setBounds(147, 250, 200, 15);
		panelInternoPagPaciente.add(labelEstadoPaciente);
		
		JLabel labelCepPaciente = new JLabel(cepPaciente);
		labelCepPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCepPaciente.setBounds(147, 280, 200, 15);
		panelInternoPagPaciente.add(labelCepPaciente);
		
		
		JButton btnEditarCadastro = new JButton("Editar Cadastro");
		btnEditarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelCadastroPaciente painelCadastroPaciente = new PanelCadastroPaciente();
				
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnEditarCadastro);
			    
			    painelCadastroPaciente.setPainelAnterior(PanelPaginaPaciente.this);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelCadastroPaciente);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnEditarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarCadastro.setBounds(55, 375, 200, 25);
		panelInternoPagPaciente.add(btnEditarCadastro);
		
		JButton btnAdcionarConsultas = new JButton("Adicionar Consultas");
		btnAdcionarConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelNovaConsulta painelNovaConsulta = new PanelNovaConsulta();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnAdcionarConsultas);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelNovaConsulta);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnAdcionarConsultas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdcionarConsultas.setBounds(470, 122, 200, 30);
		panelInternoPagPaciente.add(btnAdcionarConsultas);
		
		JButton btnHistoricoDeConsultas = new JButton("Histórico de Consultas");
		btnHistoricoDeConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelHistoricoConsultasCorrigido painelHistoricoConsultas = new PanelHistoricoConsultasCorrigido();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnHistoricoDeConsultas);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelHistoricoConsultas);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnHistoricoDeConsultas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHistoricoDeConsultas.setBounds(470, 175, 200, 30);
		panelInternoPagPaciente.add(btnHistoricoDeConsultas);
		
		JLabel lblNmeroDoPronturio = new JLabel(prontuarioPaciente);
		lblNmeroDoPronturio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmeroDoPronturio.setBounds(147, 313, 200, 15);
		panelInternoPagPaciente.add(lblNmeroDoPronturio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(499, 415, 150, 25);
		panelInternoPagPaciente.add(btnVoltar);
		
		
	}
	
	public void setPacienteCpf(String cpf) {
		this.pacienteCpf = cpf;
		carregarDadosDoPaciente();
	}

	private void carregarDadosDoPaciente() {
		PacienteRepository repo = new PacienteRepository();
		Optional<Paciente> pacienteOptional = repo.buscarPorCpf(pacienteCpf);

		if (pacienteOptional.isPresent()) {
			Paciente paciente = pacienteOptional.get();
			
			String nome = (paciente.getNome());
			setNomePaciente(nome);
			String cpf = (paciente.getCpf());
			setCpfPaciente(cpf);
			String dataNasc = (paciente.getDataNascimento().toString());
			setDataNascPaciente(dataNasc);
			String telefone = (paciente.getTelefone());
			setTelefonePaciente(telefone);
			String email = (paciente.getEmail());
			setEmailPaciente(email);
			String genero = (paciente.getGenero());
			setGeneroPaciente(genero);
			String endereco = (paciente.getEndereco());
			setEnderecoPaciente(endereco);
			String estado = (paciente.getEstado());
			setEstadoPaciente(estado);
			String cep = (paciente.getCep());
			setCepPaciente(cep);
			String prontuario = (paciente.getNumeroProntuario());
			setProntuarioPaciente(prontuario);
			
		} else {
			JOptionPane.showMessageDialog(this, "Paciente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}