package View;

import Misc.Util;
import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Misc.Util.hash256;

/**
 * esta clase es para hacer el login y ver los datos del usuario o para crear un usuario nuevo,
 * en esta clase se puede hacer el login tanto de un comprador como de un vendedor marcando una casilla,
 * o registrarse dando a register
 */
public class Login extends JDialog {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private VendedorController _vctrl;
	private CompradorController _cctrl;
	private JCheckBox vendor;
	private int isVendor;
	private JPanel panel_1;
	private PedidoController _pctrl;

	private Comprador comprador;
	private Vendedor vendedor;

	/**
	 * crea la interfaz del login, creando unos campos para poner el usuario y la contrasenia, un boton de registro
	 * para registrar el susario en la base de datos que llama a las clases Regsiter_C y Register_V
	 * @param cc se recibe el controller del comprador para insertar en el el registro
	 * @param vc se recibe el controller del vendedor para insertar en el el registro
	 */
	public Login(CompradorController cc, VendedorController vc, PedidoController pc) {
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
		_pctrl = pc;
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
					Register_C regc = new Register_C(_cctrl, _pctrl);
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

		panel_1 = new JPanel();
		panel_1 = new JPanel();
		panel_1.setBackground(Util._barColor);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton okaybtn = new JButton("Ok");
		okaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});

		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					aceptar();
				}
			}
		});

		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {

					aceptar();
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
		iconLogo = new ImageIcon("resources/zamazor.png");
		lblNewLabel_2.setIcon(iconLogo);
		panel_2.add(lblNewLabel_2);
	}



	/**
	 * al recibir esta funcion un nombre de ususario y una contrasenia si esta la checkbox desactivada
	 * intenta consultar el comprador en la base de datos y compara la contrasenia de la base de datos
	 * con la escrita por el usuario si es correcta la funcion devuelve true.
	 * @param username username insertado por el ususario
	 * @param password contraseña insertada por el usuario
	 * @return devuelve un booleano si es que se ha completado el login
	 */
	private boolean login(String username, char[] password)
	{
		boolean ret = false;
		if (!vendor.isSelected())
		{
			Comprador buffer = _cctrl.consultarComprador(username);
			if (buffer.getCuenta() != null)
			{
				String real = buffer.getPassword().toLowerCase();
				String in = hash256(new String(password)).toLowerCase();
				if(real.equals(in))
				{
					comprador = buffer;
					isVendor = 2;
					ret = true;
				}
			}
		}
		else
		{
			Vendedor buffer = _vctrl.consultarVendedor(username);
			if (buffer.getNombre() != null)
			{
				if(buffer.getPassword().toLowerCase().equals(hash256(new String(password)).toLowerCase()))
				{
					vendedor = buffer;
					isVendor = 1;
					ret = true;
				}
			}
		}
		return ret;
	}

	/**
	 * @return devuelve el comprador registrado
	 */
	public Comprador getComprador()
	{
		return this.comprador;
	}
	/**
	 * @return devuelve el vendedor registrado
	 */
	public Vendedor getVendedor()
	{
		return this.vendedor;
	}

	/**
	 * @return este entero simboliza si un usuario es un comprador, un vendedor,
	 * o si el login esta en su estado por defecto, ya que en la ventana pricipal
	 * al no haberse registrado,a interfaz es para registrarse pero al haberse
	 * registrado la interfaz cambia segun el valor que tenga este numero
	 */
	public int getIsVendedor()
	{
		return this.isVendor;
	}

	private void aceptar()
	{
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
}
