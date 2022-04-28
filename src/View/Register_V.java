package View;

import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;
import View.Controllers.CompradorController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_V extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField name;
	private JTextField email;
	private JTextField direccion;

	private VendedorController _vctrl;
	private CompradorController _cctrl;
	private JTextField telefono;


	public Register_V(CompradorController cc, VendedorController vc) {
		setTitle("Sign up");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);

		_vctrl = vc;
		_cctrl = cc;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(107, 60, 105, 20);
		panel.add(passwordField);

		JLabel txtPassWord = new JLabel("Contrase\u00F1a:");
		txtPassWord.setBounds(23, 68, 74, 14);
		panel.add(txtPassWord);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 29, 46, 14);
		panel.add(lblNombre);

		name = new JTextField();
		name.setBounds(107, 21, 105, 20);
		panel.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(23, 107, 46, 14);
		panel.add(lblNewLabel_3);

		email = new JTextField();
		email.setBounds(107, 99, 105, 20);
		panel.add(email);
		email.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_4.setBounds(23, 146, 60, 14);
		panel.add(lblNewLabel_4);

		direccion = new JTextField();
		direccion.setBounds(107, 138, 105, 20);
		panel.add(direccion);
		direccion.setColumns(10);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(35, 246, 1, 2);
		panel.add(separator_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_5.setBounds(23, 185, 46, 14);
		panel.add(lblNewLabel_5);
		
		telefono = new JTextField();
		telefono.setBounds(107, 177, 105, 20);
		panel.add(telefono);
		telefono.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton okaybtn = new JButton("Ok");
		okaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (register())
				{
					setVisible(false);
				}
			}
		});
		okaybtn.setForeground(new Color(0, 0, 0));
		okaybtn.setBackground(new Color(148, 0, 211));
		ImageIcon iconLogo = new ImageIcon("resources/IconoOkey.png");
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton Cancelbtn = new JButton("Cancel");

		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
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

	private boolean register()
	{
		boolean ret = true;
		Vendedor vendedor = new Vendedor(null, name.getText(), email.getText(), Long.parseLong(telefono.getText()), null, new String(passwordField.getPassword()));
		if(!_vctrl.altaVendedor(vendedor))
		{
			JOptionPane.showMessageDialog(this, "No se ha podido crear el usuario", "error", JOptionPane.ERROR_MESSAGE);
			ret = false;
		}
		return ret;
	}
}
