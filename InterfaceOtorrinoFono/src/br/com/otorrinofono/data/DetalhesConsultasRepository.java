package br.com.otorrinofono.view;

import javax.swing.*;
import java.awt.*;
import br.com.otorrinofono.entities.DetalhesConsulta;
import br.com.otorrinofono.data.DetalhesConsultaRepository;
import br.com.otorrinofono.data.MySQLDetalhesConsultaRepository;

public class PanelDetalhesConsultaCorrigido extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextArea textArea_anamnese;
    private JTextArea textArea_avaliacaoVocal;
    private JTextArea textArea_diagnostico;
    private JTextArea textArea_conduta;
    private JTextArea textArea_observacoes;
    private JButton btnEditarConsulta;

    private int idConsulta; 

    private DetalhesConsultaRepository repo;

    public PanelDetalhesConsultaCorrigido(int idConsulta) {
        this.idConsulta = idConsulta;
        repo = new MySQLDetalhesConsultaRepository();

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

        textArea_anamnese = new JTextArea();
        textArea_anamnese.setBounds(112, 107, 199, 94);
        panel.add(textArea_anamnese);

        textArea_avaliacaoVocal = new JTextArea();
        textArea_avaliacaoVocal.setBounds(112, 211, 199, 94);
        panel.add(textArea_avaliacaoVocal);

        textArea_diagnostico = new JTextArea();
        textArea_diagnostico.setBounds(112, 315, 199, 94);
        panel.add(textArea_diagnostico);

        textArea_conduta = new JTextArea();
        textArea_conduta.setBounds(457, 107, 199, 94);
        panel.add(textArea_conduta);

        textArea_observacoes = new JTextArea();
        textArea_observacoes.setBounds(457, 211, 199, 94);
        panel.add(textArea_observacoes);

        JButton BotaoExamesAnexadosConsulta = new JButton("Exames anexados");
        BotaoExamesAnexadosConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        BotaoExamesAnexadosConsulta.setBounds(483, 315, 145, 34);
        panel.add(BotaoExamesAnexadosConsulta);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVoltar.setBounds(9, 435, 96, 25);
        panel.add(btnVoltar);

        btnEditarConsulta = new JButton("Editar consulta");
        btnEditarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEditarConsulta.setBounds(642, 435, 141, 25);
        panel.add(btnEditarConsulta);

        carregarDados();

        btnEditarConsulta.addActionListener(e -> salvarOuAtualizarConsulta());

        btnVoltar.addActionListener(e -> {
           
        });
    }

    private void carregarDados() {
        DetalhesConsulta detalhes = repo.buscarPorConsulta(idConsulta);
        if (detalhes != null) {
            textArea_anamnese.setText(detalhes.getAnamnese());
            textArea_avaliacaoVocal.setText(detalhes.getAvaliacaoVocal());
            textArea_diagnostico.setText(detalhes.getDiagnostico());
            textArea_conduta.setText(detalhes.getConduta());
            textArea_observacoes.setText(detalhes.getObservacoes());
        }
    }

    private void salvarOuAtualizarConsulta() {
        DetalhesConsulta detalhes = new DetalhesConsulta();
        detalhes.setIdConsulta(idConsulta);
        detalhes.setAnamnese(textArea_anamnese.getText());
        detalhes.setAvaliacaoVocal(textArea_avaliacaoVocal.getText());
        detalhes.setDiagnostico(textArea_diagnostico.getText());
        detalhes.setConduta(textArea_conduta.getText());
        detalhes.setObservacoes(textArea_observacoes.getText());

        if (repo.buscarPorConsulta(idConsulta) != null) {
            repo.atualizar(detalhes);
            JOptionPane.showMessageDialog(this, "Consulta atualizada com sucesso!");
        } else {
            repo.salvar(detalhes);
            JOptionPane.showMessageDialog(this, "Consulta salva com sucesso!");
        }
    }
}
