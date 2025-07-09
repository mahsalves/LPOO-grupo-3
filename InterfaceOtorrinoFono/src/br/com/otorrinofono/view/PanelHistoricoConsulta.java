package br.com.otorrinofono.view;

import javax.swing.*;
import java.awt.*;

public class PanelHistoricoConsulta extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelHistoricoConsulta() {
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("HISTÓRICO DE CONSULTA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        DefaultListModel<String> listaConsultas = new DefaultListModel<>();
        listaConsultas.addElement("Consulta - 01/07/2025");
        listaConsultas.addElement("Consulta - 18/06/2025");
        listaConsultas.addElement("Consulta - 05/06/2025");

        JList<String> list = new JList<>(listaConsultas);
        list.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Consultas"));

        add(scrollPane, BorderLayout.CENTER);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                JFrame detalhesFrame = new JFrame("Detalhes da Consulta");
                detalhesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                detalhesFrame.setSize(900, 600);
                detalhesFrame.setLocationRelativeTo(null);
                detalhesFrame.setContentPane(new PanelDetalhesConsulta());
                detalhesFrame.setVisible(true);
            }
        });
    }

    // Para testar o JPanel de forma isolada
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Histórico de Consulta");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new PanelHistoricoConsulta());
            frame.setVisible(true);
        });
    }
}
