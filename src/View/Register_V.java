package View;

import Misc.Util;
import ModeloDominio.Vendedor;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * esta clase es para registrar a un nuevo vendedor en la base de datos,
 * para ello hacemos una interfaz donde el usuario debe rellenar los campos correctamente
 * para registrarse como vendedor en la base de datos
 */
public class Register_V extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField name;
	private JTextField email;

	private VendedorController _vctrl;
	private JTextField telefono;

	/**
	 * crea la interfaz donde se va a mostrar los datos y finalmente cogiendo el vendedor del controller los inserta
	 * @param vc esta funcion recibe un vendedor del controller para rellenar en los campos creados en la interfaz
	 */
	public Register_V(VendedorController vc) {
		setTitle("Sign up vendor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);

		_vctrl = vc;

		JPanel panel = new JPanel();
		panel.setBackground(Util._bodyColor);
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

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(35, 246, 1, 2);
		panel.add(separator_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_5.setBounds(23, 146, 46, 14);
		panel.add(lblNewLabel_5);
		
		telefono = new JTextField();
		telefono.setBounds(107, 138, 105, 20);
		panel.add(telefono);
		telefono.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Util._barColor);
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

		JLabel lblNewLabel_1 = new JLabel("Registro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Util._bodyColor);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		iconLogo = new ImageIcon("resources/IconoZamazor.png");
		lblNewLabel_2.setIcon(iconLogo);
		panel_2.add(lblNewLabel_2);
	}

	/**
	 * para registrarse se crea un nuevo vendedor con los valores introducidos en los campos respectivos
	 * y si falla el alta salta una ventana de aviso de que no se ha creado el usuario.
	 * @return devuelve true si el usuario ha sido creado en la base de datos y false si no.
	 */
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
