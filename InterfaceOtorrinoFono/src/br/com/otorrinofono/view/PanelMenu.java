package br.com.otorrinofono.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PanelMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoMenu = new JPanel();
		panelInternoMenu.setBounds(239, 141, 400, 300);
		add(panelInternoMenu);
		
		JButton BotaoCadastrarPaciente = new JButton("Cadastrar paciente");
		BotaoCadastrarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                PanelCadastroPaciente painelCadastroPaciente = new PanelCadastroPaciente();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(BotaoCadastrarPaciente);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelCadastroPaciente);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		BotaoCadastrarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BotaoCadastrarPaciente.setBounds(125, 80, 159, 25);
		BotaoCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelCadastroPaciente painelCadastro = new PanelCadastroPaciente();
				painelCadastro.setPainelAnterior(PanelMenu.this);

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelMenu.this);
				frame.getContentPane().remove(PanelMenu.this);
				frame.getContentPane().add(painelCadastro);
				frame.revalidate();
				frame.repaint();
			}
		});
		panelInternoMenu.setLayout(null);
		panelInternoMenu.add(BotaoCadastrarPaciente);
		
		JButton PotaoPesquisarPaciente = new JButton("Pesquisar paciente");
		PotaoPesquisarPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelPesquisaPacienteCorrigido painelPesquisaPaciente = new PanelPesquisaPacienteCorrigido();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PotaoPesquisarPaciente);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelPesquisaPaciente);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		PotaoPesquisarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PotaoPesquisarPaciente.setBounds(125, 120, 159, 25);
		panelInternoMenu.add(PotaoPesquisarPaciente);
		
		JButton BotaoPerfilFuncionario = new JButton("Perfil do funcionário");
		BotaoPerfilFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelPaginaFuncionario painelPaginaFuncionario = new PanelPaginaFuncionario();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(BotaoPerfilFuncionario);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelPaginaFuncionario);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		BotaoPerfilFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BotaoPerfilFuncionario.setBounds(125, 160, 159, 25);
		panelInternoMenu.add(BotaoPerfilFuncionario);
		
		JButton BotaoFuncoesAdmin = new JButton("Funções do admin.");
		BotaoFuncoesAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    PanelAdmin painelAdmin = new PanelAdmin();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(BotaoFuncoesAdmin);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelAdmin);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		BotaoFuncoesAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BotaoFuncoesAdmin.setBounds(125, 200, 159, 25);
		panelInternoMenu.add(BotaoFuncoesAdmin);
		
		JLabel LabelMenuTitulo = new JLabel("Menu Principal");
		LabelMenuTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMenuTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelMenuTitulo.setBounds(125, 30, 150, 18);
		panelInternoMenu.add(LabelMenuTitulo);
	}

}
