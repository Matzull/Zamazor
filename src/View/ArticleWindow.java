package View;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import ModeloDominio.Vendedor;
import View.Controllers.ArticuloController;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Misc.Util;
import View.Controllers.VendedorController;

/**
 * esta es la clase que muestra la informacion del articulo al pulsar con el raton sobre el
 */
public class ArticleWindow extends JDialog {

	private JPanel contentPane;
	private JTextField idTxtField;
	private JTextField nombreTextField;
	private JTextField descTextField;
	private JTextField valTextField;
	private JTextField precioTxtField;
	private JTextField tipoTextField;
	private JTextField idVendTextField;
	private JCheckBox stockCheckBox;
	private MainWindow mainWindow;
	private ImageIcon _image;
	private CompradorController _cctrl;
	private ArticuloController _actrl;
	private VendedorController _vctrl;
	private Util.Emode mode;//0 modif, 1 add

	private Articulo articulo;
	private Vendedor vendedor;

	private Comprador comp;
	JLabel imageLabel;

	/**
	 * inicializa la gui
	 * @wbp.parser.constructor
	 */
	public ArticleWindow(Articulo articulo, ArticuloController _actrl, Util.Emode mode, VendedorController _vctrl, Vendedor vend)
	{
		this._actrl = _actrl;
		this.articulo = articulo;
		this.mode = mode;
		this._vctrl = _vctrl;
		this.vendedor = vend;
		initGui();
	}

	/**
	 * inicializa la gui
	 * @param articulo es el articulo a mostrar
	 * @param comp el comprador que en su pedido tiene ese articulo
	 * @param _cctrl el controlador del comprador
	 */
	public ArticleWindow(Articulo articulo, Comprador comp, CompradorController _cctrl) {

		this.articulo = articulo;
		this.comp = comp;
		this._cctrl = _cctrl;
		mode = Util.Emode.Consultar;
		initGui();
	}

	/**
	 *  crea el jPanel con los campos inmodificalbles de id, nombre, precio,stock,descripcion
	 * valoracion tipo e id vendedor, despues podemos aniadir el articulo al carrito
	 * y salir con aceptar
	 */
	private void initGui(){
		setModal(true);
		setLocation(100, 100);
		setMinimumSize(new Dimension(500, 500));
		contentPane = new JPanel();
		contentPane.setBackground(Util._bodyColor);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Util._bodyColor);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 10));

		JLabel idLabel = new JLabel("Id:");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(idLabel);

		idTxtField = new JTextField();
		idTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		idTxtField.setBackground(Util._bodyColor);
		idTxtField.setBorder(new EmptyBorder(0, 5, 0, 0));
		panel.add(idTxtField);
		idTxtField.setColumns(10);
		idTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//fillFields();
			}
		});

		JLabel nombrelbl = new JLabel("Nombre:");
		nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(nombrelbl);

		nombreTextField = new JTextField();
		nombreTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nombreTextField.setBackground(Util._bodyColor);
		nombreTextField.setColumns(10);
		nombreTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(nombreTextField);

		JLabel precioLbl = new JLabel("Precio:");
		precioLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(precioLbl);

		precioTxtField = new JTextField();
		precioTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		precioTxtField.setBackground(Util._bodyColor);
		precioTxtField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(precioTxtField);
		precioTxtField.setColumns(10);

		JLabel stocklbl = new JLabel("Stock:");
		stocklbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(stocklbl);

		stockCheckBox = new JCheckBox("");
		stockCheckBox.setBackground(Util._bodyColor);
		stockCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(stockCheckBox);

		JLabel desclabel = new JLabel("Descripcion:");
		desclabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(desclabel);

		descTextField = new JTextField();
		descTextField.setHorizontalAlignment(SwingConstants.CENTER);
		descTextField.setBackground(Util._bodyColor);
		descTextField.setColumns(10);
		descTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(descTextField);

		JLabel valLbl = new JLabel("Valoracion:");
		valLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(valLbl);

		valTextField = new JTextField();
		valTextField.setHorizontalAlignment(SwingConstants.CENTER);
		valTextField.setBackground(Util._bodyColor);
		valTextField.setColumns(10);
		valTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(valTextField);

		JLabel tipoLbl = new JLabel("Tipo:");
		tipoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tipoLbl);

		tipoTextField = new JTextField();
		tipoTextField.setHorizontalAlignment(SwingConstants.CENTER);
		tipoTextField.setBackground(Util._bodyColor);
		tipoTextField.setColumns(10);
		tipoTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(tipoTextField);

		JLabel lblVendedor = new JLabel("Id vendedor:");
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVendedor);

		idVendTextField = new JTextField();
		idVendTextField.setHorizontalAlignment(SwingConstants.CENTER);
		idVendTextField.setBackground(Util._bodyColor);
		panel.add(idVendTextField);
		idVendTextField.setBorder(new EmptyBorder(0,0,0,0));
		idVendTextField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Util._barColor);
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel zamazorBlancoIcon = new JLabel("");
		ImageIcon iconLogo = new ImageIcon("resources/zamazor.png");
		zamazorBlancoIcon.setIcon(iconLogo);
		panel_1.add(zamazorBlancoIcon);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Util._barColor);
		contentPane.add(panel_2, BorderLayout.SOUTH);


		JButton aceptarButton = new JButton("Aceptar");
		aceptarButton.setBackground(Util._barColor);
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mode == Util.Emode.Anadir)
				{
					anadir();
				}
				else if(mode == Util.Emode.Modificar)
				{
					modificar();
				}
				aceptar();
			}
		});
		iconLogo = new ImageIcon("resources/IconoOkey.png");
		aceptarButton.setIcon(iconLogo);

		JButton cart = new JButton("A\u00F1adir al carrito");
		cart.setBackground(Util._barColor);
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToCart();
			}
		});
		if (comp != null)
		{
			panel_2.add(cart);
		}
		panel_2.add(aceptarButton);

		if(mode == Util.Emode.Anadir || mode == Util.Emode.Modificar) {
			setEditable(true);
			idTxtField.setBorder(new LineBorder(Color.BLACK, 1));
			nombreTextField.setBorder(new LineBorder(Color.BLACK, 1));
			descTextField.setBorder(new LineBorder(Color.BLACK, 1));
			valTextField.setBorder(new LineBorder(Color.BLACK, 1));
			precioTxtField.setBorder(new LineBorder(Color.BLACK, 1));
			tipoTextField.setBorder(new LineBorder(Color.BLACK, 1));
			idVendTextField.setBorder(new LineBorder(Color.BLACK, 1));
			stockCheckBox.setBorder(new LineBorder(Color.BLACK, 1));

			if(mode == Util.Emode.Anadir) {

				JLabel imagenLbl = new JLabel("Imagen:");
				imagenLbl.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(imagenLbl);

				JButton anadirImagen = new JButton("Anadir imagen");
				anadirImagen.setBackground(Util._bodyColor
				);
				anadirImagen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						anadirImagenBD();
					}
				});

				panel.add(anadirImagen);
			}
		}else {
			setEditable(false);
		}

		if (mode != Util.Emode.Anadir)
		{
			fillFields();
		}

		JPanel panelImage = new JPanel();
		panelImage.setBackground(Util._bodyColor);
		panelImage.setLayout(new BorderLayout());
		contentPane.add(panelImage, BorderLayout.EAST);
		imageLabel = new JLabel(_image);
		panelImage.add(Box.createRigidArea(new Dimension(50, 0)), BorderLayout.WEST);
		panelImage.add(Box.createRigidArea(new Dimension(50, 0)), BorderLayout.EAST);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		JPanel fcpPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) fcpPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		fcpPanel.setBackground(Util._bodyColor);
		panelImage.add(fcpPanel, BorderLayout.SOUTH);

	}

	private void aceptar(){
		this.setVisible(false);
	}

	private void fillFields()
	{
		System.out.print(articulo.getNombre());
		if (articulo != null)
		{
			_image = articulo.getImage();
			idTxtField.setText(articulo.getId().toString());
			nombreTextField.setText(articulo.getNombre());
			nombreTextField.setCaretPosition(0);
			descTextField.setText(articulo.getDescripcion());
			descTextField.setCaretPosition(0);
			precioTxtField.setText(Double.toString(articulo.getPrecio()));
			valTextField.setText(Double.toString(articulo.getValoracion()));
			tipoTextField.setText(articulo.getTipo());
			idVendTextField.setText(Integer.toString(articulo.getVendedor_id()));
			stockCheckBox.setSelected(articulo.getStock());
		}

	}

	private void addToCart()
	{
		PedidoController _pctrl = new PedidoController();//Temporal
		Pedido cart = _pctrl.consultarPedido(comp.getId(), true);
		List<Pedido> pedidos = comp.getPedidos();
		pedidos.remove(cart);
		List<Articulo> arts = cart.getArticulos();
		arts.add(articulo);
		cart.setArticulos(arts);
		pedidos.add(cart);
		comp.setPedidos(pedidos);
		_pctrl.modificarPedido(cart);
		JOptionPane.showMessageDialog(null, "Articulo añadido a su cesta");
		dispose();
	}

	public void setEditable(boolean editable) {
		if(editable) {
			nombreTextField.setEditable(true);
			descTextField.setEditable(true);
			valTextField.setEditable(true);
			precioTxtField.setEditable(true);
			tipoTextField.setEditable(true);
			idVendTextField.setEditable(false);
			idTxtField.setEditable(false);
			stockCheckBox.setEnabled(true);
		}else {
			nombreTextField.setEditable(false);
			descTextField.setEditable(false);
			valTextField.setEditable(false);
			precioTxtField.setEditable(false);
			tipoTextField.setEditable(false);
			idVendTextField.setEditable(false);
			stockCheckBox.setEnabled(false);
		}
	}
	private void anadirImagenBD() {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getAbsolutePath();
		try {
			_image = new ImageIcon(filename);//get the image from file chooser and scale it to match JLabel size
			imageLabel.setIcon(Util.scaleImage(_image, 125, 125));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void anadir()
	{
		Articulo a = new Articulo(null, Double.parseDouble((valTextField.getText() == "" ? "0" : valTextField.getText())), Double.parseDouble((precioTxtField.getText() == "" ? "0" : precioTxtField.getText())),
		vendedor.getId(), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected(), _image);
		_actrl.altaArticulo(a);
		vendedor.getArticulos().add(_actrl.buscarArticulo("_" + a.getNombre()).get(0));
		_vctrl.modificarVendedor(vendedor);
	}

	private void modificar()
	{
		Articulo a = new Articulo(Integer.parseInt(idTxtField.getText()), Double.parseDouble((valTextField.getText() == "" ? "0" : valTextField.getText())), Double.parseDouble((precioTxtField.getText() == "" ? "0" : precioTxtField.getText())),
		Integer.parseInt(idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected(), _image);;
		articulo = a;
		vendedor.getArticulos().remove(_actrl.consultarArticulo(a.getId()));
		_actrl.modificarArticulo(a);
		vendedor.getArticulos().add(a);
	}


}
