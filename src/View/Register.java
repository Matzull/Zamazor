package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public Register() {
		setTitle("Sign up");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(107, 38, 105, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(23, 44, 74, 14);
		panel.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 77, 105, 20);
		panel.add(passwordField);
		
		JLabel txtPassWord = new JLabel("Contrase\u00F1a:");
		txtPassWord.setBounds(23, 83, 74, 14);
		panel.add(txtPassWord);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 122, 46, 14);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(107, 116, 105, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(23, 161, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 155, 105, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_4.setBounds(23, 200, 60, 14);
		panel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 194, 105, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Vendedor");
		chckbxNewCheckBox.setBackground(new Color(250, 235, 215));
		chckbxNewCheckBox.setBounds(23, 225, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton okaybtn = new JButton("Ok");		
		okaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		okaybtn.setForeground(new Color(0, 0, 0));
		okaybtn.setBackground(new Color(148, 0, 211));
		ImageIcon iconLogo = new ImageIcon("resources/IconoOkey.png");
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton Cancelbtn = new JButton("Cancel");
		
		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cancelbtn.setHorizontalAlignment(SwingConstants.LEFT);
		Cancelbtn.setBackground(new Color(148, 0, 211));
		panel_1.add(Cancelbtn);
		
		JSeparator separator_1 = new JSeparator();
		panel_1.add(separator_1);
		
		JSeparator separator = new JSeparator();
		panel_1.add(separator);
		
		panel_1.add(okaybtn);
		
		JSeparator separator_2 = new JSeparator();
		panel_1.add(separator_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(148, 0, 211));
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resgistro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		iconLogo = new ImageIcon("resources/IconoZamazor.png");
		lblNewLabel_2.setIcon(iconLogo);
		panel_2.add(lblNewLabel_2);
	}
}
