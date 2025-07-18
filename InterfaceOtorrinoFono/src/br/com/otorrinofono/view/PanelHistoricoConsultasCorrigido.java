package br.com.otorrinofono.view;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import java.util.List;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import br.com.otorrinofono.entities.Consulta;
import br.com.otorrinofono.business.ConsultaController;
import br.com.otorrinofono.view.PanelDetalhesConsultaCorrigido;

public class PanelHistoricoConsultasCorrigido extends JPanel {
	
	private Consulta consulta;
    private JPanel painelAnterior;
	private static final long serialVersionUID = 1L;
    private String cpfPaciente;
    private JList<String> listaConsultas;
    private DefaultListModel<String> listModel;
    private List<Consulta> consultasDoPaciente;

    public PanelHistoricoConsultasCorrigido(String cpfPaciente, JPanel painelAnterior) {
        this.cpfPaciente = cpfPaciente;
        this.painelAnterior = painelAnterior;
        inicializarComponentes();
        carregarConsultas();
        
    }

    private void inicializarComponentes() {
        setBackground(new Color(0, 128, 255));
        setBounds(0, 0, 884, 561);
        setLayout(null);

        JPanel panelInternoPagPaciente = new JPanel();
        panelInternoPagPaciente.setBounds(42, 61, 784, 474);
        add(panelInternoPagPaciente);
        panelInternoPagPaciente.setLayout(null);

        JLabel labelHistoricoConsultas = new JLabel("Histórico de Consultas");
        labelHistoricoConsultas.setHorizontalAlignment(SwingConstants.CENTER);
        labelHistoricoConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelHistoricoConsultas.setBounds(261, 27, 200, 19);
        panelInternoPagPaciente.add(labelHistoricoConsultas);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(49, 85, 680, 318);
        panelInternoPagPaciente.add(scrollPane);

        listModel = new DefaultListModel<>();
        listaConsultas = new JList<>(listModel);
        listaConsultas.setBorder(new TitledBorder(null, "Consultas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        listaConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        scrollPane.setViewportView(listaConsultas);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVoltar.setBounds(10, 443, 126, 21);
        panelInternoPagPaciente.add(btnVoltar);

        btnVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(painelAnterior);
                frame.revalidate();
                frame.repaint();
            }
        });

        JButton btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVisualizar.setBounds(648, 431, 126, 33);
        panelInternoPagPaciente.add(btnVisualizar);
        

        btnVisualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = listaConsultas.getSelectedIndex();
                if (index >= 0) {
                    Consulta consultaSelecionada = consultasDoPaciente.get(index);
                    System.out.println("Consulta selecionada: " + consultaSelecionada);

                    PanelDetalhesConsultaCorrigido detalhes = new PanelDetalhesConsultaCorrigido(consultaSelecionada);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVisualizar);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(detalhes);
                    frame.revalidate();
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma consulta para visualizar.");
                }
            }
        });
    }
    private void carregarConsultas() {
        try {
            ConsultaController controller = new ConsultaController();
            consultasDoPaciente = controller.listarConsultasPorPaciente(cpfPaciente);

            listModel.clear();
            for (Consulta c : consultasDoPaciente) {
                listModel.addElement(c.getDataConsulta().toString());
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar consultas: " + e.getMessage());
        }
    }
}