package br.com.otorrinofono.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPaginaFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel painelAnterior;

	/**
	 * Create the panel.
	 */
	
	public PanelPaginaFuncionario() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoPagPaciente = new JPanel();
		panelInternoPagPaciente.setBounds(94, 61, 700, 450);
		add(panelInternoPagPaciente);
		panelInternoPagPaciente.setLayout(null);
		
		JLabel labelTituloPagPaciente = new JLabel("Página do Funcionario");
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
		labelDataNasc.setBounds(10, 70, 127, 15);
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
		
		JLabel labelFuncao = new JLabel("Função:");
		labelFuncao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFuncao.setBounds(10, 220, 127, 15);
		panelInternoPagPaciente.add(labelFuncao);
		
		JLabel labelLicensa = new JLabel("CMR/CRF");
		labelLicensa.setHorizontalAlignment(SwingConstants.LEFT);
		labelLicensa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLicensa.setBounds(10, 250, 127, 15);
		panelInternoPagPaciente.add(labelLicensa);
		
		JLabel labelNomeFuncionario = new JLabel("Nome do funcionario");
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNomeFuncionario.setBounds(147, 40, 200, 15);
		panelInternoPagPaciente.add(labelNomeFuncionario);
		
		JLabel labelDataNascFuncionario = new JLabel("00/00/0000");
		labelDataNascFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDataNascFuncionario.setBounds(147, 70, 200, 15);
		panelInternoPagPaciente.add(labelDataNascFuncionario);
		
		JLabel labelCpfFuncionario = new JLabel("000.000.000-00");
		labelCpfFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCpfFuncionario.setBounds(147, 100, 200, 15);
		panelInternoPagPaciente.add(labelCpfFuncionario);
		
		JLabel labelGeneroFuncionario = new JLabel("Gênero do funcionario");
		labelGeneroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGeneroFuncionario.setBounds(147, 130, 200, 15);
		panelInternoPagPaciente.add(labelGeneroFuncionario);
		
		JLabel labelEmailFuncionario = new JLabel("E-mail do funcionario");
		labelEmailFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEmailFuncionario.setBounds(147, 160, 200, 15);
		panelInternoPagPaciente.add(labelEmailFuncionario);
		
		JLabel labelTelefoneFuncionario = new JLabel("(00) 00000-0000");
		labelTelefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTelefoneFuncionario.setBounds(147, 190, 200, 15);
		panelInternoPagPaciente.add(labelTelefoneFuncionario);
		
		JLabel labelFuncaoFuncionario = new JLabel("Função do funcionario");
		labelFuncaoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelFuncaoFuncionario.setBounds(147, 220, 200, 15);
		panelInternoPagPaciente.add(labelFuncaoFuncionario);
		
		JLabel labelLicensaFuncionario = new JLabel("???");
		labelLicensaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLicensaFuncionario.setBounds(147, 250, 200, 15);
		panelInternoPagPaciente.add(labelLicensaFuncionario);
		
		JButton btnEditarCadastro = new JButton("Editar Cadastro");
		btnEditarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelCadastroFuncionario painelCadastroFuncionario = new PanelCadastroFuncionario();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnEditarCadastro);

			    painelCadastroFuncionario.setPainelAnterior(PanelPaginaFuncionario.this);
			    
			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelCadastroFuncionario);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnEditarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarCadastro.setBounds(470, 231, 200, 30);
		panelInternoPagPaciente.add(btnEditarCadastro);
		
		JButton btnHistoricoDeConsultas = new JButton("Histórico de Consultas");
		btnHistoricoDeConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelHistoricoConsultasCorrigido painelHistoricoConsultas = new PanelHistoricoConsultasCorrigido(PanelPaginaFuncionario.this);

		        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnHistoricoDeConsultas);
		        frame.getContentPane().removeAll();
		        frame.getContentPane().add(painelHistoricoConsultas);
		        frame.revalidate();
		        frame.repaint();
			}
		});
		btnHistoricoDeConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistoricoDeConsultas.setBounds(470, 122, 200, 30);
		panelInternoPagPaciente.add(btnHistoricoDeConsultas);
		
		JButton btnRemoverFuncionario = new JButton("Remover Funcionario");
		btnRemoverFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoverFuncionario.setBounds(470, 175, 200, 30);
		panelInternoPagPaciente.add(btnRemoverFuncionario);
		
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
		btnVoltar.setBounds(470, 285, 200, 30);
		panelInternoPagPaciente.add(btnVoltar);
	}
	
	
	public JPanel getPainelAnterior() {
		return painelAnterior;
	}

	public void setPainelAnterior(JPanel painelAnterior) {
		this.painelAnterior = painelAnterior;
	}


}
