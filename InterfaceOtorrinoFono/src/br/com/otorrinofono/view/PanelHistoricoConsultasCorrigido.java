package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHistoricoConsultasCorrigido extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelHistoricoConsultasCorrigido() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoPagPaciente = new JPanel();
		panelInternoPagPaciente.setBounds(42, 61, 784, 474);
		add(panelInternoPagPaciente);
		panelInternoPagPaciente.setLayout(null);
		
		JLabel labelHistoricoConsultas = new JLabel("Histórico de consultas");
		labelHistoricoConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		labelHistoricoConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelHistoricoConsultas.setBounds(261, 27, 200, 19);
		panelInternoPagPaciente.add(labelHistoricoConsultas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(49, 85, 680, 318);
		panelInternoPagPaciente.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(list);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 443, 126, 21);
		panelInternoPagPaciente.add(btnVoltar);
		 
	}
}
