package br.com.otorrinofono.view;

import javax.swing.*;
import java.awt.*;

public class PanelDetalhesConsulta extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelDetalhesConsulta() {
        setLayout(null);
        setBackground(new Color(0, 128, 255));

        JPanel panelInterno = new JPanel();
        panelInterno.setLayout(null);
        panelInterno.setBounds(100, 50, 700, 450);
        panelInterno.setBackground(Color.WHITE);
        add(panelInterno);

        JLabel titulo = new JLabel("Consulta - 01/07/2025", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        titulo.setBounds(200, 10, 300, 30);
        panelInterno.add(titulo);

        int largura = 300;
        int altura = 60;
        int espacamento = 10;
        int x1 = 30, x2 = 360;
        int y = 60;

        panelInterno.add(criarCampo("Anamnese", x1, y, largura, altura));
        panelInterno.add(criarCampo("Avaliação Vocal", x2, y, largura, altura));
        y += altura + espacamento;

        panelInterno.add(criarCampo("Diagnóstico", x1, y, largura, altura));
        panelInterno.add(criarCampo("Conduta", x2, y, largura, altura));
        y += altura + espacamento;

        panelInterno.add(criarCampo("Observação", x1, y, largura, altura));
        panelInterno.add(criarCampo("Exames Anexados", x2, y, largura, altura));

        JButton botaoEditar = new JButton("Editar");
        botaoEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
        botaoEditar.setBounds(550, 360, 120, 30);
        panelInterno.add(botaoEditar);
    }

    private JPanel criarCampo(String titulo, int x, int y, int largura, int altura) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBounds(x, y, largura, altura);
        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createTitledBorder(titulo));
        painel.add(area);
        return painel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Detalhes da Consulta");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new PanelDetalhesConsulta());
            frame.setVisible(true);
        });
    }
}
