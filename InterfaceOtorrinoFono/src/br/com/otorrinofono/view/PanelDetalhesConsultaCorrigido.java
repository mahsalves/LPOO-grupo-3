package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class PanelDetalhesConsultaCorrigido extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelDetalhesConsultaCorrigido() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 48, 793, 474);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta dia XX/YY/ZZZZ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(277, 21, 210, 20);
		panel.add(lblNewLabel);
		
		JLabel LabelAnamnese = new JLabel("Anamnese");
		LabelAnamnese.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelAnamnese.setBounds(23, 139, 65, 17);
		panel.add(LabelAnamnese);
		
		
		JLabel LabelAvaliacaoVocal = new JLabel("Avaliação vocal");
		LabelAvaliacaoVocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelAvaliacaoVocal.setBounds(9, 243, 96, 17);
		panel.add(LabelAvaliacaoVocal);
		
		JLabel LabelDiagnostico = new JLabel("Diagnóstico");
		LabelDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelDiagnostico.setBounds(23, 359, 73, 17);
		panel.add(LabelDiagnostico);
		
		
		JLabel labelConduta = new JLabel("Conduta");
		labelConduta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelConduta.setBounds(370, 139, 53, 17);
		panel.add(labelConduta);
		
		JLabel labelObservacoes = new JLabel("Observações");
		labelObservacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelObservacoes.setBounds(370, 243, 79, 17);
		panel.add(labelObservacoes);
		
		JTextArea textAreaAnamnese = new JTextArea();
		textAreaAnamnese.setBounds(112, 107, 199, 94);
		textAreaAnamnese.setLineWrap(true);
		textAreaAnamnese.setWrapStyleWord(true);
		textAreaAnamnese.setEditable(false);
		panel.add(textAreaAnamnese);
		
		JScrollPane scrollPaneAnamnese = new JScrollPane();
		scrollPaneAnamnese.setBounds(0, 0, 2, 2);
		textAreaAnamnese.add(scrollPaneAnamnese);
		
		JTextArea textAreaAvaliacaoVocal = new JTextArea();
		textAreaAvaliacaoVocal.setBounds(112, 211, 199, 94);
		textAreaAvaliacaoVocal.setLineWrap(true);
		textAreaAvaliacaoVocal.setWrapStyleWord(true);
		textAreaAvaliacaoVocal.setEditable(false);
		panel.add(textAreaAvaliacaoVocal);
		
		JScrollPane scrollPaneAvaliacaoVocal = new JScrollPane();
		scrollPaneAvaliacaoVocal.setBounds(0, 0, 2, 2);
		textAreaAvaliacaoVocal.add(scrollPaneAvaliacaoVocal);
		
		JTextArea textAreaDiagnostico = new JTextArea();
		textAreaDiagnostico.setBounds(112, 315, 199, 94);
		textAreaDiagnostico.setLineWrap(true);
		textAreaDiagnostico.setWrapStyleWord(true);
		textAreaDiagnostico.setEditable(false);
		panel.add(textAreaDiagnostico);
		
		JScrollPane scrollPaneDiagnostico = new JScrollPane();
		scrollPaneDiagnostico.setBounds(0, 0, 2, 2);
		textAreaDiagnostico.add(scrollPaneDiagnostico);
		
		JTextArea textAreaConduta = new JTextArea();
		textAreaConduta.setBounds(457, 107, 199, 94);
		textAreaConduta.setLineWrap(true);
		textAreaConduta.setWrapStyleWord(true);
		textAreaConduta.setEditable(false);
		panel.add(textAreaConduta);
		
		JScrollPane scrollPaneConduta = new JScrollPane();
		scrollPaneConduta.setBounds(0, 0, 2, 2);
		textAreaConduta.add(scrollPaneConduta);
		
		JTextArea textAreaObservacoes = new JTextArea();
		textAreaObservacoes.setBounds(457, 211, 199, 94);
		textAreaObservacoes.setLineWrap(true);
		textAreaObservacoes.setWrapStyleWord(true);
		textAreaObservacoes.setEditable(false);
		panel.add(textAreaObservacoes);
		
		JScrollPane scrollPaneAreaObservacoes = new JScrollPane();
		scrollPaneAreaObservacoes.setBounds(0, 0, 2, 2);
		textAreaObservacoes.add(scrollPaneAreaObservacoes);
		
		JButton BotaoExamesAnexadosConsulta = new JButton("Exames anexados");
		BotaoExamesAnexadosConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BotaoExamesAnexadosConsulta.setBounds(483, 315, 145, 34);
		panel.add(BotaoExamesAnexadosConsulta);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(9, 435, 96, 25);
		panel.add(btnVoltar);
		
		JButton btnEditarConsulta = new JButton("Editar consulta");
		btnEditarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarConsulta.setBounds(642, 435, 141, 25);
		panel.add(btnEditarConsulta);
		
	}
}
