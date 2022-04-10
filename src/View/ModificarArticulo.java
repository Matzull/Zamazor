package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Articulos.Articulo;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class ModificarArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField idTxtField;
	private JTextField nombreTextField;
	private JTextField descTextField;
	private JTextField valTextField;
	private JTextField tipoTextField;
	private JTextField idVendTextField;
	private JCheckBox stockCheckBox;
	private MainWindowAdministrador mainWindowAdministrador;

	public ModificarArticulo(MainWindowAdministrador mainWindow) {
		
		this.mainWindowAdministrador = mainWindow;
		
		
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
		
		JLabel nombrelbl = new JLabel("Nombre:");
		nombrelbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(nombrelbl);
		
		nombreTextField = new JTextField();
		nombreTextField.setColumns(10);
		panel.add(nombreTextField);
		
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
		
		panel_2.add(aceptarButton);
	}
	public void cancelar() {
		this.setVisible(false);
	}
	public boolean aceptar(){		
		Articulo a = new Articulo(Integer.parseInt(idTxtField.getText()), Integer.parseInt(valTextField.getText()), 
		Integer.parseInt(idVendTextField.getText()), nombreTextField.getText(), descTextField.getText(), tipoTextField.getText(), stockCheckBox.isSelected());
		return mainWindowAdministrador.modificarArticulo(a);
	}
}
