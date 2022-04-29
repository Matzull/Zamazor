package View;

import Misc.Util;
import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;
import View.Controllers.CompradorController;
import View.Controllers.VendedorController;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale;

import static Misc.Util.hash256;

public class Login extends JDialog {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private VendedorController _vctrl;
	private CompradorController _cctrl;
	private JCheckBox vendor;
	private int isVendor;

	private Comprador comprador;
	private Vendedor vendedor;

	public Login(CompradorController cc, VendedorController vc) {
		setTitle("Log In");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 299, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setModal(true);
		_vctrl = vc;
		_cctrl = cc;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(107, 38, 105, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(23, 41, 60, 14);
		panel.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 76, 105, 20);
		panel.add(passwordField);
		
		JLabel txtPassWord = new JLabel("Contrase\u00F1a:");
		txtPassWord.setBounds(23, 79, 74, 14);
		panel.add(txtPassWord);
		
		JButton regbtn = new JButton("Registro");
		regbtn.setBackground(Util._bodyColor);
		regbtn.setForeground(new Color(0, 0, 0));
		regbtn.setBounds(117, 112, 86, 23);
		regbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if (vendor.isSelected())
				{
					Register_V regv = new Register_V(_vctrl);
				}
				else
				{
					Register_C regc = new Register_C(_cctrl);
				}
			}
		});
		panel.add(regbtn);
		
		vendor = new JCheckBox("Vendedor");
		vendor.setBackground(Util._bodyColor);
		vendor.setBounds(14, 112, 97, 23);
		panel.add(vendor);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(107, 147, 1, 2);
		panel.add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Util._barColor);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton okaybtn = new JButton("Ok");		
		okaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(login(txtUsuario.getText(), passwordField.getPassword()))
				{
					JOptionPane.showMessageDialog(null, "LogIn correcto");
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(panel_1, "Usuario o contrase\u00F1a erroneos", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		okaybtn.setForeground(new Color(0, 0, 0));
		okaybtn.setBackground(Util._barColor);
		ImageIcon iconLogo = new ImageIcon("resources/IconoOkey.png");
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton Cancelbtn = new JButton("Cancel");
		
		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Cancelbtn.setHorizontalAlignment(SwingConstants.LEFT);
		Cancelbtn.setBackground(Util._barColor);
		panel_1.add(Cancelbtn);
		
		JSeparator separator_1 = new JSeparator();
		panel_1.add(separator_1);
		
		JSeparator separator = new JSeparator();
		panel_1.add(separator);
		
		panel_1.add(okaybtn);
		
		JSeparator separator_2 = new JSeparator();
		panel_1.add(separator_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Util._barColor);
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Iniciar sesi\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Util._bodyColor);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		iconLogo = new ImageIcon("resources/IconoZamazor.png");
		lblNewLabel_2.setIcon(iconLogo);
		panel_2.add(lblNewLabel_2);
	}

	private boolean login(String username, char[] password)
	{
		boolean ret = false;
		if (!vendor.isSelected())
		{
			comprador = _cctrl.consultarComprador(username);
			if (comprador.getCuenta() != null)
			{
				if(comprador.getPassword().toLowerCase().equals(hash256(new String(password)).toLowerCase()))
				{
					isVendor = 0;
					ret = true;
				}
			}
		}
		else
		{
			vendedor = _vctrl.consultarVendedor(username);
			if (vendedor.getNombre() != null)
			{
				if(vendedor.getPassword().toLowerCase().equals(hash256(new String(password)).toLowerCase()))
				{
					isVendor = 1;
					ret = true;
				}
			}
		}
		return ret;
	}

	public Comprador getComprador()
	{
		return this.comprador;
	}

	public Vendedor getVendedor()
	{
		return this.vendedor;
	}

	public int getIsVendedor()
	{
		return this.isVendor;
	}
}
