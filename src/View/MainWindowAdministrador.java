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
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindowAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField barraBusqueda;
	private JTable table;
	private DefaultTableModel interiorTabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowAdministrador frame = new MainWindowAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindowAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 498);
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
				String texto = barraBusqueda.getText().toLowerCase();
				filter(texto);
			}
		});
		panel.add(barraBusqueda);
		barraBusqueda.setColumns(10);
		
		JLabel lupaIcon = new JLabel("");
		lupaIcon.setForeground(Color.WHITE);
		lupaIcon.setBackground(Color.WHITE);

		iconLogo = new ImageIcon("resources/IconoLupa.png");
		lupaIcon.setIcon(iconLogo);
		panel.add(lupaIcon);
		
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
		panel_2.add(modificarButton);
		
		JButton btnNewButton = new JButton("Eliminar Articulo");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir Articulo");
		panel_2.add(btnNewButton_1);
	}
	
	private void crearModeloTabla() {
		interiorTabla = (DefaultTableModel) table.getModel();
		interiorTabla.addColumn("ID");
		interiorTabla.addColumn("Nombre");
		interiorTabla.addColumn( "Stock");
		interiorTabla.addColumn("Descripcion");
		interiorTabla.addColumn("Valoracion");
		interiorTabla.addColumn("Tipo");
		interiorTabla.addColumn("Vendedor_ID");
		
		Object[] interior ={
				"prueba", "prueba", "Stoprueback", "prueba", "Valopruebaracion", "prueba", "Vepruebandedor_ID"
			};
		interiorTabla.addRow(interior);
	}

	private void filter(String texto) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(interiorTabla);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(texto));
	}
}
