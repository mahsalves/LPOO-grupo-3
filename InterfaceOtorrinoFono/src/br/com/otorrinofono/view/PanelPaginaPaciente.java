package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPaginaPaciente extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelPaginaPaciente() {
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
		
		JLabel labelNomePaciente = new JLabel("Nome do paciente");
		labelNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNomePaciente.setBounds(147, 40, 200, 15);
		panelInternoPagPaciente.add(labelNomePaciente);
		
		JLabel labelDataNascPaciente = new JLabel("00/00/0000");
		labelDataNascPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNascPaciente.setBounds(147, 70, 200, 15);
		panelInternoPagPaciente.add(labelDataNascPaciente);
		
		JLabel labelCpfPaciente = new JLabel("000.000.000-00");
		labelCpfPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCpfPaciente.setBounds(147, 100, 200, 15);
		panelInternoPagPaciente.add(labelCpfPaciente);
		
		JLabel labelGeneroPaciente = new JLabel("Gênero do paciente");
		labelGeneroPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGeneroPaciente.setBounds(147, 130, 200, 15);
		panelInternoPagPaciente.add(labelGeneroPaciente);
		
		JLabel labelEmailPaciente = new JLabel("E-mail do paciente");
		labelEmailPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmailPaciente.setBounds(147, 160, 200, 15);
		panelInternoPagPaciente.add(labelEmailPaciente);
		
		JLabel labelTelefonePaciente = new JLabel("(00) 00000-0000");
		labelTelefonePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefonePaciente.setBounds(147, 190, 200, 15);
		panelInternoPagPaciente.add(labelTelefonePaciente);
		
		JLabel labelEnderecoPaciente = new JLabel("Endereço do paciente");
		labelEnderecoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEnderecoPaciente.setBounds(147, 220, 200, 15);
		panelInternoPagPaciente.add(labelEnderecoPaciente);
		
		JLabel labelEstadoPaciente = new JLabel("Estado do paciente");
		labelEstadoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEstadoPaciente.setBounds(147, 250, 200, 15);
		panelInternoPagPaciente.add(labelEstadoPaciente);
		
		JLabel labelCepPaciente = new JLabel("00000-000");
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
		
		JLabel lblNmeroDoPronturio = new JLabel("Número do prontuário");
		lblNmeroDoPronturio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNmeroDoPronturio.setBounds(147, 313, 200, 15);
		panelInternoPagPaciente.add(lblNmeroDoPronturio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(499, 415, 150, 25);
		panelInternoPagPaciente.add(btnVoltar);
	}
}
