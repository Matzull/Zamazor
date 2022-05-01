package View;

import Misc.Util;
import ModeloDominio.Articulo;
import View.AuxWindow.Emode;
import View.Controllers.ArticuloController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private ImageIcon _image;
	private Articulo articulo;
	
	private ArticuloController _actrl;
	public static enum Emode {Modificar, Anadir, Consultar};
	private Emode mode;
	
	public ArticleWindow(Articulo articulo, Emode emode,ArticuloController _actrl) {

		setModal(true);
		this.mode = emode;
		this._actrl = _actrl;

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
		
		if(mode == emode.Anadir && mode == emode.Modificar) {	
			
			idTxtField.setBackground(Color.WHITE);
			idTxtField.setBorder(new LineBorder(Color.BLACK, 1));
			nombreTextField.setBackground(Color.WHITE);
			nombreTextField.setBorder(new LineBorder(Color.BLACK, 1));
			descTextField.setBackground(Color.WHITE);
			descTextField.setBorder(new LineBorder(Color.BLACK, 1));
			valTextField.setBackground(Color.WHITE);
			valTextField.setBorder(new LineBorder(Color.BLACK, 1));
			precioTxtField.setBackground(Color.WHITE);
			precioTxtField.setBorder(new LineBorder(Color.BLACK, 1));
			tipoTextField.setBackground(Color.WHITE);
			tipoTextField.setBorder(new LineBorder(Color.BLACK, 1));
			idVendTextField.setBackground(Color.WHITE);
			idVendTextField.setBorder(new LineBorder(Color.BLACK, 1));
			stockCheckBox.setBackground(Color.WHITE);	
			stockCheckBox.setBorder(new LineBorder(Color.BLACK, 1));
			
		}else {

			nombreTextField.setEditable(false);
			descTextField.setEditable(false);
			valTextField.setEditable(false);
			precioTxtField.setEditable(false);
			tipoTextField.setEditable(false);
			idVendTextField.setEditable(false);
			stockCheckBox.setEnabled(false);
		}
		
		panel_2.add(aceptarButton);

		fillFields();

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



	}

	public void aceptar(){
		
		Articulo a = new Articulo(Integer.parseInt(idTxtField.getText()), Double.parseDouble((valTextField.getText() == "" ? "0" : valTextField.getText())), Double.parseDouble((precioTxtField.getText() == "" ? "0" : precioTxtField.getText())),
		Integer.parseInt(idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected(), _image);
		this.setVisible(false);
		_actrl.modificarArticulo(a);	
		this.setVisible(false);
	}

	public void fillFields()
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

}
