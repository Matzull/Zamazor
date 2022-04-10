package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Articulos.Articulo;
import Articulos.ArticulosController;
import DAO.DAOarticulo;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField barraBusqueda;
	private JTable table;
	private DefaultTableModel interiorTabla;
	private ArticulosController _ctrl;
	
	
	public MainWindowAdministrador(ArticulosController ctrl) {
		
		this._ctrl = ctrl;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel zamazorIcon = new JLabel("");	
		zamazorIcon.setVerticalAlignment(SwingConstants.TOP);
		zamazorIcon.setForeground(Color.WHITE);
		
		ImageIcon iconLogo = new ImageIcon("resources/IconoZamazor.png");
		zamazorIcon.setIcon(iconLogo);
		
		panel.add(zamazorIcon);
		
		barraBusqueda = new JTextField();
		barraBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		panel.add(barraBusqueda);
		barraBusqueda.setColumns(10);
		
		
	
		
		JButton buscarButton = new JButton("");
		buscarButton.setBorderPainted(false);
		buscarButton.setBackground(Color.GRAY);
		iconLogo = new ImageIcon("resources/search.png");
		buscarButton.setIcon(iconLogo);
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = barraBusqueda.getText().toLowerCase();
				filter(texto);
			}
		});
		panel.add(buscarButton);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		
		table = new JTable();
		//table.setAutoCreateRowSorter(true);
		crearModeloTabla();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton modificarButton = new JButton("Modificar Articulo");
		modificarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearBotonModificar();
			}
		});
		panel_2.add(modificarButton);
		
		JButton eliminarButton = new JButton("Eliminar Articulo");
		panel_2.add(eliminarButton);
		
		JButton anadirArticulo = new JButton("A\u00F1adir Articulo");
		anadirArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearBotonModificar();
			}
		});
		panel_2.add(anadirArticulo);
	}
	
	private void crearBotonModificar() {
		ModificarArticulo prueba = new ModificarArticulo(this);
		prueba.setVisible(true);		
	}

	private List<Articulo> fullTable() {
		return _ctrl.fullTable();
	}

	private void filter(String texto) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(interiorTabla);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(texto));
	}
	public boolean modificarArticulo(Articulo a) {
		return _ctrl.modificarArticulo(a); //Añadir aqui el articulo creado a partir de los datos de los textField
	}

	public void crearModeloTabla()
	{
		interiorTabla = (DefaultTableModel) table.getModel();
		interiorTabla.addColumn("ID");
		interiorTabla.addColumn("Nombre");
		interiorTabla.addColumn( "Stock");
		interiorTabla.addColumn("Descripcion");
		interiorTabla.addColumn("Valoracion");
		interiorTabla.addColumn("Tipo");
		interiorTabla.addColumn("Vendedor_ID");

		List<Articulo> arts = fullTable();

		for(Articulo ar : arts) {
			Object[] interior = {ar.getId(), ar.getNombre(), ar.getStock(), ar.getDescripcion(), ar.getValoracion(), ar.getTipo(), ar.getVendedor_id()};
			interiorTabla.addRow(interior);
		}
	}
}
