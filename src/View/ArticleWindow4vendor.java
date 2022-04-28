package View;

import Misc.Util;
import ModeloDominio.Articulo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class ArticleWindow4vendor extends JDialog {

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
	public static enum Emode {Modificar, Anadir, Consultar};
	private Emode mode;
	private ImageIcon _image;

	private Articulo articulo;

	public ArticleWindow4vendor(MainWindow mainWindow, Emode mode,Articulo articulo) {

		setModal(true);

		this.mainWindow = mainWindow;

		this.mode = mode;

		this.articulo = articulo;

		//setBounds(100, 100, 500, 400);
		setLocation(100, 100);
		setMinimumSize(new Dimension(500, 500));
		contentPane = new JPanel();
		contentPane.setBackground(Util._bodyColor);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Util._bodyColor);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel idLabel = new JLabel("Id:");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(idLabel);
		
		idTxtField = new JTextField();
		idTxtField.setHorizontalAlignment(SwingConstants.LEFT);
		idTxtField.setBackground(Util._bodyColor);
		idTxtField.setBorder(new EmptyBorder(0,0,0,0));
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
		nombreTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nombreTextField.setBackground(Util._bodyColor);
		nombreTextField.setColumns(10);
		nombreTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(nombreTextField);

		JLabel precioLbl = new JLabel("Precio:");
		precioLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(precioLbl);

		precioTxtField = new JTextField();
		precioTxtField.setHorizontalAlignment(SwingConstants.LEFT);
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
		descTextField.setBackground(Util._bodyColor);
		descTextField.setColumns(10);
		descTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(descTextField);
		
		JLabel valLbl = new JLabel("Valoracion:");
		valLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(valLbl);
		
		valTextField = new JTextField();
		valTextField.setBackground(Util._bodyColor);
		valTextField.setColumns(10);
		valTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(valTextField);
		
		JLabel tipoLbl = new JLabel("Tipo:");
		tipoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tipoLbl);
		
		tipoTextField = new JTextField();
		tipoTextField.setBackground(Util._bodyColor);
		tipoTextField.setColumns(10);
		tipoTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(tipoTextField);
		
		JLabel lblVendedor = new JLabel("Id vendedor:");
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVendedor);
		
		idVendTextField = new JTextField();
		idVendTextField.setBackground(Util._bodyColor);
		panel.add(idVendTextField);
		idVendTextField.setBorder(new EmptyBorder(0,0,0,0));
		idVendTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Util._barColor);
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel zamazorBlancoIcon = new JLabel("");
		ImageIcon iconLogo = new ImageIcon("resources/IconoZamazor.png");
		zamazorBlancoIcon.setIcon(iconLogo);
		panel_1.add(zamazorBlancoIcon);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Util._barColor);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBackground(Util._barColor);
		iconLogo = new ImageIcon("resources/IconoCancel.png");
		cancelarButton.setIcon(iconLogo);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		panel_2.add(cancelarButton);

		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("resources/examples/"));

		JButton aceptarButton = new JButton("Aceptar");
		aceptarButton.setBackground(Util._barColor);
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		iconLogo = new ImageIcon("resources/IconoOkey.png");
		aceptarButton.setIcon(iconLogo);



		idTxtField.setEditable(false);
		if(mode == Emode.Consultar)
		{
			aceptarButton.setVisible(false);
			nombreTextField.setEditable(false);
			descTextField.setEditable(false);
			valTextField.setEditable(false);
			precioTxtField.setEditable(false);
			tipoTextField.setEditable(false);
			idVendTextField.setEditable(false);
			stockCheckBox.setEnabled(false);
		}
		panel_2.add(aceptarButton);
		if(mode != Emode.Anadir) {
			fillFields();
		}

		JPanel panelImage = new JPanel();
		panelImage.setBackground(Util._bodyColor);
		panelImage.setLayout(new BorderLayout());
		contentPane.add(panelImage, BorderLayout.EAST);
		JLabel imageLabel = new JLabel(_image);
		panelImage.add(Box.createRigidArea(new Dimension(50, 0)), BorderLayout.WEST);
		panelImage.add(Box.createRigidArea(new Dimension(50, 0)), BorderLayout.EAST);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		JPanel fcpPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) fcpPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		fcpPanel.setBackground(Util._bodyColor);
		panelImage.add(fcpPanel, BorderLayout.SOUTH);
		
		JButton botonArchivo = new JButton();
		botonArchivo.setForeground(Util._bodyColor);
		botonArchivo.setHorizontalAlignment(SwingConstants.RIGHT);
		botonArchivo.setBackground(Util._bodyColor);
		fcpPanel.add(botonArchivo, BorderLayout.SOUTH);
		
		botonArchivo.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("resources/IconoZamazor.png")));
		botonArchivo.setToolTipText("boton para abrir");

		botonArchivo.addActionListener((e)->{
			int i = fc.showOpenDialog(this);
			if (i == fc.APPROVE_OPTION) {

				File archivo = fc.getSelectedFile();
				try {
					BufferedImage image = ImageIO.read(archivo);
					_image = new ImageIcon(image.getScaledInstance(202, (int)((202.0 / image.getWidth()) * image.getHeight()), Image.SCALE_SMOOTH));
					imageLabel.setIcon(_image);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Cannot load file", "error", JOptionPane.ERROR_MESSAGE);
				}


			}
		});

	}

	public void cancelar() {
		this.setVisible(false);
	}

	public void aceptar(){
		if (mode == Emode.Modificar)
		{
			Articulo a = new Articulo(Integer.parseInt(idTxtField.getText()), Double.parseDouble((valTextField.getText() == "" ? "0" : valTextField.getText())), Double.parseDouble((precioTxtField.getText() == "" ? "0" : precioTxtField.getText())),
			Integer.parseInt(idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected(), _image);
			this.setVisible(false);
			mainWindow.modificarArticulo(a);
		}
		else
		{
			Articulo a = new Articulo(null,  Double.parseDouble((valTextField.getText().equals("") ? "0" : valTextField.getText())), Double.parseDouble((precioTxtField.getText().equals("") ? "0" : precioTxtField.getText())),
					Integer.parseInt(idVendTextField.getText().equals("") ? "0" : idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected(), _image);
			this.setVisible(false);
			 mainWindow.altaArticulo(a);
		}

	}

	public void fillFields()
	{
		//Articulo art = mainWindow.consultarArticulo(jList1.getSelectedValue());
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

}
