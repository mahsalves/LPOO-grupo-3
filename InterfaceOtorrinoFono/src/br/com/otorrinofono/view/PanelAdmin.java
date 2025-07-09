package br.com.otorrinofono.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAdmin extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAdmin() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoMenu = new JPanel();
		panelInternoMenu.setBounds(239, 141, 400, 300);
		add(panelInternoMenu);
		
		JButton btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
		btnCadastrarFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelCadastroFuncionario painelCadastroFuncionario = new PanelCadastroFuncionario();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnCadastrarFuncionario);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelCadastroFuncionario);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnCadastrarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarFuncionario.setBounds(115, 80, 175, 25);
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelInternoMenu.setLayout(null);
		panelInternoMenu.add(btnCadastrarFuncionario);
		
		JButton btnPesquisarFuncionario = new JButton("Pesquisar Funcionário");
		btnPesquisarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarFuncionario.setBounds(115, 120, 175, 25);
		panelInternoMenu.add(btnPesquisarFuncionario);
		
		JButton btnHistoricoAcesso = new JButton("Histórico de Acesso");
		btnHistoricoAcesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistoricoAcesso.setBounds(115, 160, 175, 25);
		panelInternoMenu.add(btnHistoricoAcesso);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelMenu painelMenu = new PanelMenu();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelMenu);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(165, 250, 75, 25);
		panelInternoMenu.add(btnVoltar);
		
		JLabel labelAdminTitulo = new JLabel("Página do Administrador");
		labelAdminTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelAdminTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelAdminTitulo.setBounds(100, 30, 200, 19);
		panelInternoMenu.add(labelAdminTitulo);
	}

}
