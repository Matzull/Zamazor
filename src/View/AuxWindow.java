package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModeloDominio.Articulo;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

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
	public Emode mode;

	public AuxWindow(MainWindowAdministrador mainWindow, Emode mode) {
		
		this.mainWindowAdministrador = mainWindow;

		this.mode = mode;
		
		setBounds(100, 100, 289, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel idLabel = new JLabel("Id:");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(idLabel);
		
		idTxtField = new JTextField();
		panel.add(idTxtField);
		idTxtField.setColumns(10);
		idTxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				fillFields();
			}
		});
		
		JLabel nombrelbl = new JLabel("Nombre:");
		nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(nombrelbl);
		
		nombreTextField = new JTextField();
		nombreTextField.setColumns(10);
		panel.add(nombreTextField);

		JLabel precioLbl = new JLabel("Precio:");
		precioLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(precioLbl);

		precioTxtField = new JTextField();
		panel.add(precioTxtField);
		precioTxtField.setColumns(10);
		
		JLabel stocklbl = new JLabel("Stock:");
		stocklbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(stocklbl);
		
		stockCheckBox = new JCheckBox("");
		stockCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(stockCheckBox);
		
		JLabel desclabel = new JLabel("Descripcion:");
		desclabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(desclabel);
		
		descTextField = new JTextField();
		descTextField.setColumns(10);
		panel.add(descTextField);
		
		JLabel valLbl = new JLabel("Valoracion:");
		valLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(valLbl);
		
		valTextField = new JTextField();
		valTextField.setColumns(10);
		panel.add(valTextField);
		
		JLabel tipoLbl = new JLabel("Tipo:");
		tipoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tipoLbl);
		
		tipoTextField = new JTextField();
		tipoTextField.setColumns(10);
		panel.add(tipoTextField);
		
		JLabel lblVendedor = new JLabel("Id vendedor:");
		lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVendedor);


		
		idVendTextField = new JTextField();
		panel.add(idVendTextField);
		idVendTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel zamazorBlancoIcon = new JLabel("");
		ImageIcon iconLogo = new ImageIcon("resources/IconoZamazor.png");
		zamazorBlancoIcon.setIcon(iconLogo);
		panel_1.add(zamazorBlancoIcon);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton cancelarButton = new JButton("Cancelar");
		iconLogo = new ImageIcon("resources/IconoCancel.png");
		cancelarButton.setIcon(iconLogo);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		panel_2.add(cancelarButton);
		
		JButton aceptarButton = new JButton("Aceptar");
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		iconLogo = new ImageIcon("resources/IconoOkey.png");
		aceptarButton.setIcon(iconLogo);

		if(mode == Emode.Consultar)
		{
			aceptarButton.setVisible(false);
			nombreTextField.setEditable(false);
			descTextField.setEditable(false);
			valTextField.setEditable(false);
			tipoTextField.setEditable(false);
			idVendTextField.setEditable(false);
			stockCheckBox.setEnabled(false);
		}
		panel_2.add(aceptarButton);
	}

	public void cancelar() {
		this.setVisible(false);
	}

	public void aceptar(){
		if (mode == Emode.Modificar)
		{
			Articulo a = new Articulo(Integer.parseInt(idTxtField.getText()), Double.parseDouble(valTextField.getText()), Double.parseDouble(precioTxtField.getText()),
			Integer.parseInt(idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected());
			this.setVisible(false);
			mainWindowAdministrador.modificarArticulo(a);
		}
		else
		{
			Articulo a = new Articulo(Integer.parseInt(idTxtField.getText()),  Double.parseDouble(valTextField.getText()), Double.parseDouble(precioTxtField.getText()),
					Integer.parseInt(idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected());
			this.setVisible(false);
			 mainWindowAdministrador.altaArticulo(a);
		}

	}

	public void fillFields()
	{
		Articulo art = mainWindowAdministrador.consultarArticulo(Integer.parseInt(idTxtField.getText()));
		if (art != null)
		{
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
