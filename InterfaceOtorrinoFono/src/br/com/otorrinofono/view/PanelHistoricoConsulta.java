package br.com.otorrinofono.view;
import javax.swing.*;
import java.awt.*;

public class PanelHistoricoConsulta extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelHistoricoConsulta() {
        setTitle("Histórico de Consulta");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                new PanelDetalhesConsulta().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PanelHistoricoConsulta().setVisible(true);
        });
    }
}