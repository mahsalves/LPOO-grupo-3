import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;

public class PesquisaPacienteUI extends JFrame {
    private JTextField campoBusca;
    private JTextArea areaInformacoes;

    public PesquisaPacienteUI() {
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setTitle("Pesquisa de Paciente");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        JLabel titulo = new JLabel("PESQUISA DE PACIENTE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new BorderLayout(10, 10));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JPanel painelBusca = new JPanel(new BorderLayout(5, 5));
        painelBusca.setBorder(BorderFactory.createTitledBorder("Buscar"));

        JLabel rotuloBusca = new JLabel("Pesquisar:");
        rotuloBusca.setFont(new Font("Arial", Font.PLAIN, 16));
        rotuloBusca.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        campoBusca = new JTextField("Nome ou Prontuário");
        campoBusca.setFont(new Font("Arial", Font.PLAIN, 16));
        campoBusca.setForeground(Color.GRAY);

        campoBusca.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campoBusca.getText().equals("Nome ou Prontuário")) {
                    campoBusca.setText("");
                    campoBusca.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campoBusca.getText().isEmpty()) {
                    campoBusca.setText("Nome ou Prontuário");
                    campoBusca.setForeground(Color.GRAY);
                }
            }
        });

        painelBusca.add(rotuloBusca, BorderLayout.WEST);
        painelBusca.add(campoBusca, BorderLayout.CENTER);

        areaInformacoes = new JTextArea();
        areaInformacoes.setEditable(false);
        areaInformacoes.setFont(new Font("Arial", Font.PLAIN, 14));
        areaInformacoes.setLineWrap(true);
        areaInformacoes.setWrapStyleWord(true);
        areaInformacoes.setBorder(BorderFactory.createTitledBorder("Informações do Paciente"));

        JScrollPane scroll = new JScrollPane(areaInformacoes);

        painelCentral.add(painelBusca, BorderLayout.NORTH);
        painelCentral.add(scroll, BorderLayout.CENTER);

        add(painelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PesquisaPacienteUI().setVisible(true);
        });
    }
}