package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelNovaConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_anamnese;
	private JTextField textfield_avaliacaovocal;
	private JTextField textField_diagnostico;
	private JTextField textField_conduta;
	private JTextField textField_observacoes;

	/**
	 * Create the panel.
	 */
	public PanelNovaConsulta() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 42, 749, 482);
		add(panel);
		panel.setLayout(null);
		
		JLabel LabelNovaConsulta = new JLabel("Nova consulta");
		LabelNovaConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNovaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelNovaConsulta.setBounds(292, 25, 118, 21);
		panel.add(LabelNovaConsulta);
		
		JLabel LabelAnamnese = new JLabel("Anamnese");
		LabelAnamnese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelAnamnese.setBounds(23, 139, 65, 13);
		panel.add(LabelAnamnese);
		
		textField_anamnese = new JTextField();
		textField_anamnese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_anamnese.setBounds(115, 83, 199, 106);
		panel.add(textField_anamnese);
		textField_anamnese.setColumns(10);
		
		JLabel LabelAvaliacaoVocal = new JLabel("Avaliação vocal");
		LabelAvaliacaoVocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelAvaliacaoVocal.setBounds(9, 243, 96, 13);
		panel.add(LabelAvaliacaoVocal);
		
		JLabel LabelDiagnostico = new JLabel("Diagnóstico");
		LabelDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelDiagnostico.setBounds(23, 359, 73, 13);
		panel.add(LabelDiagnostico);
		
		textfield_avaliacaovocal = new JTextField();
		textfield_avaliacaovocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textfield_avaliacaovocal.setColumns(10);
		textfield_avaliacaovocal.setBounds(115, 199, 199, 106);
		panel.add(textfield_avaliacaovocal);
		
		textField_diagnostico = new JTextField();
		textField_diagnostico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_diagnostico.setColumns(10);
		textField_diagnostico.setBounds(115, 315, 199, 106);
		panel.add(textField_diagnostico);
		
		JLabel labelConduta = new JLabel("Conduta");
		labelConduta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelConduta.setBounds(370, 139, 53, 13);
		panel.add(labelConduta);
		
		JLabel labelObservacoes = new JLabel("Observações");
		labelObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelObservacoes.setBounds(370, 243, 79, 13);
		panel.add(labelObservacoes);
		
		textField_conduta = new JTextField();
		textField_conduta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_conduta.setColumns(10);
		textField_conduta.setBounds(469, 83, 199, 106);
		panel.add(textField_conduta);
		
		textField_observacoes = new JTextField();
		textField_observacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_observacoes.setColumns(10);
		textField_observacoes.setBounds(469, 199, 199, 106);
		panel.add(textField_observacoes);
		
		JButton BotaoRegistrarConsulta = new JButton("Registrar");
		BotaoRegistrarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BotaoRegistrarConsulta.setBounds(635, 430, 104, 42);
		panel.add(BotaoRegistrarConsulta);
		
		JButton BotaoAnexarExamesConsulta = new JButton("Anexar exames");
		BotaoAnexarExamesConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BotaoAnexarExamesConsulta.setBounds(495, 325, 140, 34);
		panel.add(BotaoAnexarExamesConsulta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelPaginaPaciente painelPaginaPaciente = new PanelPaginaPaciente();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelPaginaPaciente);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(9, 447, 96, 25);
		panel.add(btnVoltar);
	}
}
