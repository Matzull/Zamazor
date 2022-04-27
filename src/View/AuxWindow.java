package View;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ModeloDominio.Articulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AuxWindow extends JFrame {

	private JPanel contentPane;
	private JTextField idTxtField;
	private JTextField nombreTextField;
	private JTextField descTextField;
	private JTextField valTextField;
	private JTextField precioTxtField;
	private JTextField tipoTextField;
	private JTextField idVendTextField;
	private JCheckBox stockCheckBox;
	private MainWindowAdministrador mainWindowAdministrador;
	public static enum Emode {Modificar, Anadir, Consultar};
	private Emode mode;
	private ImageIcon _image;

	private JTable table;

	public AuxWindow(MainWindowAdministrador mainWindow, Emode mode,JTable table) {

		this.mainWindowAdministrador = mainWindow;

		this.mode = mode;

		this.table = table;

		//setBounds(100, 100, 500, 400);
		setLocation(100, 100);
		setMinimumSize(new Dimension(500, 500));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel idLabel = new JLabel("Id:");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(idLabel);
		
		idTxtField = new JTextField();
		idTxtField.setHorizontalAlignment(SwingConstants.LEFT);
		idTxtField.setBackground(new Color(250, 235, 215));
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
		nombreTextField.setBackground(new Color(250, 235, 215));
		nombreTextField.setColumns(10);
		nombreTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(nombreTextField);

		JLabel precioLbl = new JLabel("Precio:");
		precioLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(precioLbl);

		precioTxtField = new JTextField();
		precioTxtField.setHorizontalAlignment(SwingConstants.LEFT);
		precioTxtField.setBackground(new Color(250, 235, 215));
		precioTxtField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(precioTxtField);
		precioTxtField.setColumns(10);
		
		JLabel stocklbl = new JLabel("Stock:");
		stocklbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(stocklbl);
		
		stockCheckBox = new JCheckBox("");
		stockCheckBox.setBackground(new Color(250, 235, 215));
		stockCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(stockCheckBox);
		
		JLabel desclabel = new JLabel("Descripcion:");
		desclabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(desclabel);
		
		descTextField = new JTextField();
		descTextField.setBackground(new Color(250, 235, 215));
		descTextField.setColumns(10);
		descTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(descTextField);
		
		JLabel valLbl = new JLabel("Valoracion:");
		valLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(valLbl);
		
		valTextField = new JTextField();
		valTextField.setBackground(new Color(250, 235, 215));
		valTextField.setColumns(10);
		valTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(valTextField);
		
		JLabel tipoLbl = new JLabel("Tipo:");
		tipoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tipoLbl);
		
		tipoTextField = new JTextField();
		tipoTextField.setBackground(new Color(250, 235, 215));
		tipoTextField.setColumns(10);
		tipoTextField.setBorder(new EmptyBorder(0,0,0,0));
		panel.add(tipoTextField);
		
		JLabel lblVendedor = new JLabel("Id vendedor:");
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVendedor);
		
		idVendTextField = new JTextField();
		idVendTextField.setBackground(new Color(250, 235, 215));
		panel.add(idVendTextField);
		idVendTextField.setBorder(new EmptyBorder(0,0,0,0));
		idVendTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 0, 211));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel zamazorBlancoIcon = new JLabel("");
		ImageIcon iconLogo = new ImageIcon("resources/IconoZamazor.png");
		zamazorBlancoIcon.setIcon(iconLogo);
		panel_1.add(zamazorBlancoIcon);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(new Color(148, 0, 211));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBackground(new Color(148, 0, 211));
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
		aceptarButton.setBackground(new Color(148, 0, 211));
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
		panelImage.setBackground(new Color(250, 235, 215));
		panelImage.setLayout(new BorderLayout());
		contentPane.add(panelImage, BorderLayout.EAST);
		JLabel imageLabel = new JLabel(_image);
		panelImage.add(Box.createRigidArea(new Dimension(50, 0)), BorderLayout.WEST);
		panelImage.add(Box.createRigidArea(new Dimension(50, 0)), BorderLayout.EAST);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		JPanel fcpPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) fcpPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		fcpPanel.setBackground(new Color(250, 235, 215));
		panelImage.add(fcpPanel, BorderLayout.SOUTH);
		
		JButton botonArchivo = new JButton();
		botonArchivo.setForeground(new Color(250, 235, 215));
		botonArchivo.setHorizontalAlignment(SwingConstants.RIGHT);
		botonArchivo.setBackground(new Color(250, 235, 215));
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
			mainWindowAdministrador.modificarArticulo(a);
		}
		else
		{
			Articulo a = new Articulo(null,  Double.parseDouble((valTextField.getText().equals("") ? "0" : valTextField.getText())), Double.parseDouble((precioTxtField.getText().equals("") ? "0" : precioTxtField.getText())),
					Integer.parseInt(idVendTextField.getText().equals("") ? "0" : idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected(), _image);
			this.setVisible(false);
			 mainWindowAdministrador.altaArticulo(a);
		}

	}

	public void fillFields()
	{
		Articulo art = mainWindowAdministrador.consultarArticulo((Integer)table.getModel().getValueAt(table.convertRowIndexToModel(table.getSelectedRow()),0));
		if (art != null)
		{
			_image = art.getImage();
			idTxtField.setText(art.getId().toString());
			nombreTextField.setText(art.getNombre());
			descTextField.setText(art.getDescripcion());
			precioTxtField.setText(Double.toString(art.getPrecio()));
			valTextField.setText(Double.toString(art.getValoracion()));
			tipoTextField.setText(art.getTipo());
			idVendTextField.setText(Integer.toString(art.getVendedor_id()));
			stockCheckBox.setSelected(art.getStock());
		}

	}

}
