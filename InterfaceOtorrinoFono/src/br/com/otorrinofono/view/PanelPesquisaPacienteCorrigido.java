package br.com.otorrinofono.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPesquisaPacienteCorrigido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelPesquisaPacienteCorrigido() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 42, 756, 482);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisarPaciente = new JLabel("Pesquisa de Paciente");
		lblPesquisarPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPesquisarPaciente.setBounds(287, 10, 170, 22);
		panel.add(lblPesquisarPaciente);
		
		JPanel painelBusca = new JPanel((LayoutManager) null);
		painelBusca.setBorder(BorderFactory.createTitledBorder("Buscar"));
		painelBusca.setBounds(0, 42, 756, 46);
		panel.add(painelBusca);
		painelBusca.setLayout(new BorderLayout(5, 5));
		
		textField = new JTextField("Nome ou Prontuário");
		painelBusca.add(textField, BorderLayout.CENTER);
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextArea areaInformacoes = new JTextArea();
		areaInformacoes.setWrapStyleWord(true);
		areaInformacoes.setLineWrap(true);
		areaInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		areaInformacoes.setEditable(false);
		areaInformacoes.setBorder(BorderFactory.createTitledBorder("Informações do Paciente"));
		areaInformacoes.setBounds(10, 98, 736, 328);
		panel.add(areaInformacoes);
		
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
		btnVoltar.setBounds(10, 451, 105, 21);
		panel.add(btnVoltar);

	}
}
