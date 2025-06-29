package tela_interface;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class PanelCadastroPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public PanelCadastroPaciente() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 884, 561);
		setLayout(null);
		
		JPanel panelInternoCadastroP = new JPanel();
		panelInternoCadastroP.setBounds(68, 32, 750, 500);
		add(panelInternoCadastroP);
		panelInternoCadastroP.setLayout(null);
		
		JLabel LabelTituloCadastroP = new JLabel("Cadastrar Paciente");
		LabelTituloCadastroP.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTituloCadastroP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelTituloCadastroP.setBounds(275, 11, 200, 18);
		panelInternoCadastroP.add(LabelTituloCadastroP);
		
		JLabel lblNewLabel = new JLabel("Nome Completo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 40, 100, 14);
		panelInternoCadastroP.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data de nascimento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 70, 122, 14);
		panelInternoCadastroP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(275, 70, 29, 14);
		panelInternoCadastroP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gênero");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(445, 70, 51, 14);
		panelInternoCadastroP.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(40, 100, 36, 14);
		panelInternoCadastroP.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(40, 130, 51, 14);
		panelInternoCadastroP.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Endereço");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(40, 190, 58, 14);
		panelInternoCadastroP.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(40, 160, 41, 14);
		panelInternoCadastroP.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Estado");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(375, 160, 47, 14);
		panelInternoCadastroP.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CEP");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(375, 190, 29, 14);
		panelInternoCadastroP.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Prontuário");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(40, 240, 100, 14);
		panelInternoCadastroP.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(300, 450, 150, 25);
		panelInternoCadastroP.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(172, 39, 303, 20);
		panelInternoCadastroP.add(textField);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField.setText("00/00/0000");
		formattedTextField.setBounds(172, 67, 85, 20);
		panelInternoCadastroP.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_1.setText("888.888.888-88");
		formattedTextField_1.setBounds(314, 67, 108, 20);
		panelInternoCadastroP.add(formattedTextField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(506, 68, 30, 22);
		panelInternoCadastroP.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(172, 95, 303, 20);
		panelInternoCadastroP.add(textField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setText("(88) 88888-8888");
		formattedTextField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_2.setBounds(172, 129, 114, 20);
		panelInternoCadastroP.add(formattedTextField_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBounds(171, 159, 194, 20);
		panelInternoCadastroP.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(172, 189, 194, 20);
		panelInternoCadastroP.add(textField_3);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField_3.setText("88888-888");
		formattedTextField_3.setBounds(445, 189, 76, 20);
		panelInternoCadastroP.add(formattedTextField_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(445, 158, 30, 22);
		panelInternoCadastroP.add(comboBox_1);
	}
}
