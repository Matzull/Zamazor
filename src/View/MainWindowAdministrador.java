package View;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import ModeloDominio.Articulo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		setBounds(200, 200, 1000, 720);
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
		initTable();
		crearModeloTabla(fullTable());
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton modificarButton = new JButton("Modificar Articulo");
		modificarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearBotonModificar(AuxWindow.Emode.Modificar);
			}
		});
		panel_2.add(modificarButton);

		JButton eliminarButton = new JButton("Eliminar Articulo");

		eliminarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		panel_2.add(eliminarButton);

		JButton anadirArticulo = new JButton("A\u00F1adir Articulo");
		anadirArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearBotonModificar(AuxWindow.Emode.Anadir);
			}
		});
		panel_2.add(anadirArticulo);

		JButton consultarArticulo = new JButton("Consultar Articulo");
		consultarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearBotonModificar(AuxWindow.Emode.Consultar);
			}
		});
		panel_2.add(consultarArticulo);
	}

	private void crearBotonModificar(AuxWindow.Emode modificar) {
		AuxWindow prueba = new AuxWindow(this, modificar);
		prueba.setVisible(true);
	}


	private List<Articulo> fullTable() {
		return _ctrl.fullTable();
	}

	private void filter(String texto) {
		crearModeloTabla(_ctrl.buscarArticulo(texto));
	}

	public Articulo consultarArticulo(int id)
	{
		Articulo ret = _ctrl.consultarArticulo(id);
		if(ret == null)
		{
			JOptionPane.showMessageDialog(this, "Id not found", "error", JOptionPane.ERROR_MESSAGE);
		}
		crearModeloTabla(fullTable());
		return ret;
	}

	public void modificarArticulo(Articulo a) {
		if(!_ctrl.modificarArticulo(a))
		{
			JOptionPane.showMessageDialog(this, "Id not found", "error", JOptionPane.ERROR_MESSAGE);
		}
		crearModeloTabla(fullTable());
	}

	public void altaArticulo(Articulo a) {
		if(!_ctrl.altaArticulo(a))
		{
			JOptionPane.showMessageDialog(this, "Id already exists", "error", JOptionPane.ERROR_MESSAGE);
		}
		crearModeloTabla(fullTable());
	}

	public void crearModeloTabla(List<Articulo> arts) {
		interiorTabla.setRowCount(0);
		for (Articulo ar : arts) {
			Object[] interior = {ar.getId(), ar.getNombre(), ar.getPrecio(), ar.getStock(), ar.getDescripcion(), ar.getValoracion(), ar.getTipo(), ar.getVendedor_id()};
			interiorTabla.addRow(interior);
		}
	}

	public void initTable() {
		interiorTabla = (DefaultTableModel) table.getModel();
		interiorTabla.addColumn("ID");
		interiorTabla.addColumn("Nombre");
		interiorTabla.addColumn("Precio");
		interiorTabla.addColumn("Stock");
		interiorTabla.addColumn("Descripcion");
		interiorTabla.addColumn("Valoracion");
		interiorTabla.addColumn("Tipo");
		interiorTabla.addColumn("Vendedor_ID");
	}

	private void eliminar() {
		if (!_ctrl.bajaArticulo((Integer) table.getValueAt(table.getSelectedRow(), 0)))
		{
			JOptionPane.showMessageDialog(this, "Cannot delete record", "error", JOptionPane.ERROR_MESSAGE);
		}
		crearModeloTabla(fullTable());
	}
}
