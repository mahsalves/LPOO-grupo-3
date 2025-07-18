package br.com.otorrinofono.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;

import br.com.otorrinofono.entities.Consulta;

public class PanelDetalhesConsultaCorrigido extends JPanel {
	private Consulta consulta;
    private JPanel painelAnterior;
    
    private JTextArea textAreaAnamnese;
    private JTextArea textAreaAvaliacaoVocal;
    private JTextArea textAreaDiagnostico;
    private JTextArea textAreaConduta;
    private JTextArea textAreaObservacoes;

	private static final long serialVersionUID = 1L;
	
	public PanelDetalhesConsultaCorrigido(Consulta consulta) {
        setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea();
        areaTexto.setText(
            "Data: " + consulta.getDataConsulta() + "\n" +
            "Anamnese: " + consulta.getAnamnese() + "\n" +
            "Avaliação Vocal: " + consulta.getAvaliacaoVocal() + "\n" +
            "Diagnóstico: " + consulta.getDiagnostico() + "\n" +
            "Conduta: " + consulta.getConduta() + "\n" +
            "Observações: " + consulta.getObservacoes()
        );
        areaTexto.setEditable(false);

        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 48, 793, 474);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsulta.setBounds(277, 21, 210, 20);
		panel.add(lblConsulta);
		
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
		
		textAreaAnamnese = new JTextArea();
		textAreaAnamnese.setBounds(112, 107, 199, 94);
		textAreaAnamnese.setLineWrap(true);
		textAreaAnamnese.setWrapStyleWord(true);
		textAreaAnamnese.setEditable(false);
		panel.add(textAreaAnamnese);
		
		JScrollPane scrollPaneAnamnese = new JScrollPane();
		scrollPaneAnamnese.setBounds(0, 0, 2, 2);
		textAreaAnamnese.add(scrollPaneAnamnese);
		
		textAreaAvaliacaoVocal = new JTextArea();
		textAreaAvaliacaoVocal.setBounds(112, 211, 199, 94);
		textAreaAvaliacaoVocal.setLineWrap(true);
		textAreaAvaliacaoVocal.setWrapStyleWord(true);
		textAreaAvaliacaoVocal.setEditable(false);
		panel.add(textAreaAvaliacaoVocal);
		
		JScrollPane scrollPaneAvaliacaoVocal = new JScrollPane();
		scrollPaneAvaliacaoVocal.setBounds(0, 0, 2, 2);
		textAreaAvaliacaoVocal.add(scrollPaneAvaliacaoVocal);
		
		textAreaDiagnostico = new JTextArea();
		textAreaDiagnostico.setBounds(112, 315, 199, 94);
		textAreaDiagnostico.setLineWrap(true);
		textAreaDiagnostico.setWrapStyleWord(true);
		textAreaDiagnostico.setEditable(false);
		panel.add(textAreaDiagnostico);
		
		JScrollPane scrollPaneDiagnostico = new JScrollPane();
		scrollPaneDiagnostico.setBounds(0, 0, 2, 2);
		textAreaDiagnostico.add(scrollPaneDiagnostico);
		
		textAreaConduta = new JTextArea();
		textAreaConduta.setBounds(457, 107, 199, 94);
		textAreaConduta.setLineWrap(true);
		textAreaConduta.setWrapStyleWord(true);
		textAreaConduta.setEditable(false);
		panel.add(textAreaConduta);
		
		JScrollPane scrollPaneConduta = new JScrollPane();
		scrollPaneConduta.setBounds(0, 0, 2, 2);
		textAreaConduta.add(scrollPaneConduta);
		
		textAreaObservacoes = new JTextArea();
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
		btnVoltar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(painelAnterior);
            frame.revalidate();
            frame.repaint();
        });
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(9, 435, 96, 25);
		panel.add(btnVoltar);
		
		preencherDados();
		
		JButton btnEditarConsulta = new JButton("Editar consulta");
		btnEditarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarConsulta.setBounds(642, 435, 141, 25);
		panel.add(btnEditarConsulta);
		
	}
		private void preencherDados() {
	        if (consulta != null) {
	            textAreaAnamnese.setText(consulta.getAnamnese());
	            textAreaAvaliacaoVocal.setText(consulta.getAvaliacaoVocal());
	            textAreaDiagnostico.setText(consulta.getDiagnostico());
	            textAreaConduta.setText(consulta.getConduta());
	            textAreaObservacoes.setText(consulta.getObservacoes());
	        }
	    }
	}