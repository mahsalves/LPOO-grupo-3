package br.com.otorrinofono.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.com.otorrinofono.business.PacienteController;
import br.com.otorrinofono.entities.Paciente;
import br.com.otorrinofono.exception.SystemException;

import java.util.List;

public class PanelPesquisaPacienteCorrigido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextArea areaInformacoes;
    private Paciente pacienteSelecionado = null;

	/**
	 * Create the panel.
	 */
	public PanelPesquisaPacienteCorrigido() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 42, 756, 482);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisarPaciente = new JLabel("Pesquisa de Paciente");
		lblPesquisarPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPesquisarPaciente.setBounds(287, 10, 170, 22);
		panel.add(lblPesquisarPaciente);
		
		JPanel painelBusca = new JPanel();
		painelBusca.setLayout(null);
		painelBusca.setBorder(BorderFactory.createTitledBorder("Buscar"));
		painelBusca.setBounds(10, 42, 606, 46);
		panel.add(painelBusca);
		painelBusca.setLayout(new BorderLayout(5, 5));
		
		textField = new JTextField("Nome ou Prontuário");
		painelBusca.add(textField, BorderLayout.CENTER);
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelMenu painelMenu = new PanelMenu();

			    
			    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnVoltar);

			    frame.getContentPane().removeAll();
			    frame.getContentPane().add(painelMenu);
			    frame.revalidate();
			    frame.repaint();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 451, 105, 21);
		panel.add(btnVoltar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProcurar.setBounds(626, 56, 105, 32);
		panel.add(btnProcurar);
		btnProcurar.addActionListener(e -> procurarPaciente());
		
		JButton btnVisualizarPaciente = new JButton("Visualizar paciente");
		btnVisualizarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVisualizarPaciente.setBounds(599, 436, 147, 36);
		panel.add(btnVisualizarPaciente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 736, 296);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(list);
	}
		
		private void procurarPaciente() {
	        String termo = textField.getText().trim().toLowerCase();
	        pacienteSelecionado = null;

	        try {
	            PacienteController controller = new PacienteController();
	            List<Paciente> pacientes = controller.listarPacientes();

	            for (Paciente p : pacientes) {
	                if (p.getNome().toLowerCase().contains(termo) || 
	                    p.getNumeroProntuario().toLowerCase().contains(termo)) {
	                    
	                    pacienteSelecionado = p; // pega o primeiro que encontrar
	                    areaInformacoes.setText(formatarPaciente(p));
	                    return;
	                }
	            }
	        } catch (SystemException e) {
	            JOptionPane.showMessageDialog(null, "Erro ao buscar pacientes: " + e.getMessage());
	        }
		}
	        private String formatarPaciente(Paciente p) {
	            return String.format(
	                "Nome: %s\nData de Nascimento: %s\nCPF: %s\nGênero: %s\nEmail: %s\nTelefone: %s\nEndereço: %s\nCEP: %s\nEstado: %s\nProntuário: %s",
	                p.getNome(), p.getDataNascimento(), p.getCpf(), p.getGenero(), p.getEmail(),
	                p.getTelefone(), p.getEndereco(), p.getCep(), p.getEstado(), p.getNumeroProntuario()
	            );
	        }
}
