package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPesquisaFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNomeOuCrmcrfa;

	/**
	 * Create the panel.
	 */
	public PanelPesquisaFuncionario() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 42, 756, 482);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisaDeFuncionrio = new JLabel("Pesquisa de Funcionário");
		lblPesquisaDeFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisaDeFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPesquisaDeFuncionrio.setBounds(265, 10, 194, 22);
		panel.add(lblPesquisaDeFuncionrio);
		
		JPanel painelBusca = new JPanel((LayoutManager) null);
		painelBusca.setBorder(BorderFactory.createTitledBorder("Buscar"));
		painelBusca.setBounds(0, 42, 612, 46);
		panel.add(painelBusca);
		painelBusca.setLayout(new BorderLayout(5, 5));
		
		txtNomeOuCrmcrfa = new JTextField("Nome ou CRM/CRFa");
		txtNomeOuCrmcrfa.setForeground(Color.GRAY);
		txtNomeOuCrmcrfa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelBusca.add(txtNomeOuCrmcrfa, BorderLayout.CENTER);
		
		JTextArea areaInformacoes = new JTextArea();
		areaInformacoes.setToolTipText("");
		areaInformacoes.setWrapStyleWord(true);
		areaInformacoes.setLineWrap(true);
		areaInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		areaInformacoes.setEditable(false);
		areaInformacoes.setBorder(BorderFactory.createTitledBorder("Informações"));
		areaInformacoes.setBounds(10, 118, 736, 304);
		panel.add(areaInformacoes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAdmin painelAdmin = new PanelAdmin();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelAdmin);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 451, 101, 21);
		panel.add(btnVoltar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProcurar.setBounds(630, 56, 105, 32);
		panel.add(btnProcurar);
		
		JButton btnVisualizarPaciente = new JButton("Visualizar paciente");
		btnVisualizarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVisualizarPaciente.setBounds(599, 436, 147, 36);
		panel.add(btnVisualizarPaciente);

	}
}
