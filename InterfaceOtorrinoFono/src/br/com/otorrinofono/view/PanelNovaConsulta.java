package br.com.otorrinofono.view;

import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import br.com.otorrinofono.entities.Paciente;
import br.com.otorrinofono.entities.Consulta;
import br.com.otorrinofono.business.ConsultaController;
import br.com.otorrinofono.exception.BusinessException;
import br.com.otorrinofono.exception.SystemException;

public class PanelNovaConsulta extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_anamnese;
    private JTextField textfield_avaliacaovocal;
    private JTextField textField_diagnostico;
    private JTextField textField_conduta;
    private JTextField textField_dataConsulta;
    private JTextField textField_observacoes;
    private byte[] anexoExameBytes = null;
    private JPanel painelAnterior;
    private Consulta consultaEmEdicao;
    private Paciente pacienteDaConsulta;

    public PanelNovaConsulta(JPanel previousPanel, Consulta consulta, Paciente paciente) {
        this.painelAnterior = previousPanel;
        this.consultaEmEdicao = consulta;
        this.pacienteDaConsulta = paciente;
        inicializar();
    }

    public PanelNovaConsulta() {
        inicializar();
    }

    private void inicializar() {
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
        textfield_avaliacaovocal.setBounds(115, 199, 199, 106);
        panel.add(textfield_avaliacaovocal);

        textField_diagnostico = new JTextField();
        textField_diagnostico.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
        textField_conduta.setBounds(469, 83, 199, 106);
        panel.add(textField_conduta);

        textField_observacoes = new JTextField();
        textField_observacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_observacoes.setBounds(469, 199, 199, 106);
        panel.add(textField_observacoes);

        textField_dataConsulta = new JTextField();
        textField_dataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_dataConsulta.setBounds(469, 25, 199, 25);
        panel.add(textField_dataConsulta);

        JButton BotaoRegistrarConsulta = new JButton("Registrar");
        BotaoRegistrarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        BotaoRegistrarConsulta.setBounds(635, 430, 104, 42);
        panel.add(BotaoRegistrarConsulta);

        JButton BotaoAnexarExamesConsulta = new JButton("Anexar exames");
        BotaoAnexarExamesConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        BotaoAnexarExamesConsulta.setBounds(495, 325, 140, 34);
        panel.add(BotaoAnexarExamesConsulta);

        BotaoAnexarExamesConsulta.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    anexoExameBytes = Files.readAllBytes(file.toPath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo.");
                }
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVoltar.setBounds(9, 447, 96, 25);
        panel.add(btnVoltar);

        btnVoltar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null && painelAnterior != null) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(painelAnterior);
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível voltar ao painel anterior.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        if (consultaEmEdicao != null) {
            LabelNovaConsulta.setText("Editar Consulta");
            BotaoRegistrarConsulta.setText("Atualizar");
            carregarDadosParaEdicao(consultaEmEdicao);
        } else {
            textField_dataConsulta.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }

        BotaoRegistrarConsulta.addActionListener(e -> salvarOuAtualizarConsulta());
    }

    private void carregarDadosParaEdicao(Consulta consulta) {
        textField_dataConsulta.setText(consulta.getDataConsulta() != null ?
                consulta.getDataConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "");
        textField_anamnese.setText(consulta.getAnamnese());
        textfield_avaliacaovocal.setText(consulta.getAvaliacaoVocal());
        textField_diagnostico.setText(consulta.getDiagnostico());
        textField_conduta.setText(consulta.getConduta());
        textField_observacoes.setText(consulta.getObservacoes());
    }

    private void salvarOuAtualizarConsulta() {
        Consulta consulta = (consultaEmEdicao != null) ? consultaEmEdicao : new Consulta();

        try {
            consulta.setDataConsulta(LocalDate.parse(textField_dataConsulta.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        consulta.setAnamnese(textField_anamnese.getText());
        consulta.setAvaliacaoVocal(textfield_avaliacaovocal.getText());
        consulta.setDiagnostico(textField_diagnostico.getText());
        consulta.setConduta(textField_conduta.getText());
        consulta.setObservacoes(textField_observacoes.getText());
        consulta.setAnexarExames(anexoExameBytes);

        if (pacienteDaConsulta != null && pacienteDaConsulta.getCpf() != null) {
            consulta.setPacienteCpf(pacienteDaConsulta.getCpf());
        } else {
            JOptionPane.showMessageDialog(this, "Paciente não definido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ConsultaController controller = new ConsultaController();
        try {
            controller.salvarOuAtualizarConsulta(consulta);
            JOptionPane.showMessageDialog(this, "Consulta salva com sucesso!");
            if (consultaEmEdicao == null) limparCampos();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (frame != null && painelAnterior != null) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(painelAnterior);
                frame.revalidate();
                frame.repaint();
            }
        } catch (BusinessException | SystemException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        textField_dataConsulta.setText("");
        textField_anamnese.setText("");
        textfield_avaliacaovocal.setText("");
        textField_diagnostico.setText("");
        textField_conduta.setText("");
        textField_observacoes.setText("");
        anexoExameBytes = null;
    }

    public JPanel getPainelAnterior() {
        return painelAnterior;
    }

    public void setPainelAnterior(JPanel painelAnterior) {
        this.painelAnterior = painelAnterior;
    }
}
