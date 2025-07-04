import javax.swing.*;
import java.awt.*;

public class DetalhesConsultaUI extends JFrame {

    public DetalhesConsultaUI() {
        setTitle("Detalhes da Consulta");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titulo = new JLabel("Consulta - 01/07/2025", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel painelConteudo = new JPanel(new GridLayout(3, 2, 10, 10));
        painelConteudo.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        painelConteudo.add(criarCampo("Anamnese"));
        painelConteudo.add(criarCampo("Avaliação Vocal"));
        painelConteudo.add(criarCampo("Diagnóstico"));
        painelConteudo.add(criarCampo("Conduta"));
        painelConteudo.add(criarCampo("Observação"));
        painelConteudo.add(criarCampo("Exames Anexados"));

        add(painelConteudo, BorderLayout.CENTER);

        JButton botaoEditar = new JButton("Editar");
        botaoEditar.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotao.add(botaoEditar);

        add(painelBotao, BorderLayout.SOUTH);
    }

    private JPanel criarCampo(String titulo) {
        JPanel painel = new JPanel(new BorderLayout());
        JTextArea area = new JTextArea(3, 20);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createTitledBorder(titulo));
        painel.add(area, BorderLayout.CENTER);
        return painel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DetalhesConsultaUI().setVisible(true);
        });
    }
}  
