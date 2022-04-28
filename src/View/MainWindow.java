package View;

import Misc.Util;
import ModeloDominio.Articulo;
import View.Controllers.ArticuloController;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainWindow {

    private JFrame frame;
    private JTextField buscadorTXT;
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;

    private ArticuloController _actrl = new ArticuloController();
    private CompradorController _cctrl = new CompradorController();
    private PedidoController _pctrl = new PedidoController();
    private VendedorController _vctrl = new VendedorController();
    JList<Articulo> list;

    public MainWindow() {
        initialize();
    }

    private Map<Integer, ImageIcon> createImageMap(List<Articulo> fullTable) {

        Map<Integer, ImageIcon> map = new HashMap<>();
        for (Articulo s : fullTable) {
            map.put(s.getId(), s.getImage(1));
        }
        return map;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 596, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setBackground(Util._barColor);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Util._barColor);
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.add(panel_1, BorderLayout.CENTER);

        JLabel fotoZamazor = new JLabel();
        ImageIcon iconLogo = Util.scaleImage(new ImageIcon("resources/IconoZamazor.png"), 3);
        fotoZamazor.setIcon(iconLogo);
        panel_1.add(fotoZamazor);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Util._barColor);
        panel.add(panel_2);

        buscadorTXT = new JTextField();
        buscadorTXT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        buscadorTXT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String texto = buscadorTXT.getText().toLowerCase();
					filter(texto);
				} //PARA QUE AL DARLE AL ENTER SE BUSQUE AUTOMATICAMENTE EN LA BARRA DE BUSQUEDA PRINCIPAL TRAS ESCRIBIR
			}
		});
        panel_2.add(buscadorTXT);
        buscadorTXT.setColumns(40);

        JButton botonBuscar = new JButton("");
        botonBuscar.setBorderPainted(false);
        botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        iconLogo = new ImageIcon("resources/search.png");
        botonBuscar.setIcon(iconLogo);
        botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = buscadorTXT.getText().toLowerCase();
				filter(texto);
			}
		});
        panel_2.add(botonBuscar);
        
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Util._barColor);
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel.add(panel_3);

        loginIcon = new JLabel();
        loginIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login(_cctrl, _vctrl);
                login.setVisible(true);
            }
        });
        iconLogo = Util.scaleImage(new ImageIcon("resources/user.png"), 0.04);
        loginIcon.setIcon(iconLogo);
        panel_3.add(loginIcon);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        frame.getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setBorder(null);
        panel_4.setBackground(Util._bodyColor);
        panel_4.setLayout(new CardLayout());

        scrollPane = new JScrollPane();
        scrollPane.setBackground(Util._bodyColor);
        panel_4.add(scrollPane, "name_179239712047600");


        list = new JList<Articulo>();
        imageMap = createImageMap(fullTable());
        crearModeloJlist(fullTable());
        list.setModel(modeloJLista);
        list.setCellRenderer(new CellRenderer());
        scrollPane.setViewportView(list);


        list.setFixedCellHeight(250);
        list.setFixedCellWidth(250);
        //JLabel lblNewLabel = new JLabel("New label");
        //scrollPane.setRowHeaderView(lblNewLabel);

    }

    private void filter(String texto) {
    	crearModeloJlist(_actrl.buscarArticulo(texto));
    	list.setModel(modeloJLista);
    }

    public void crearModeloJlist(List<Articulo> arts) {
        modeloJLista = new DefaultListModel<>();

        for (Articulo ar : arts) {
            modeloJLista.addElement(ar);
        }

    }
    private List<Articulo> fullTable() {

        return _actrl.fullTable();
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);

    }

    public class CellRenderer extends JPanel implements ListCellRenderer<Articulo> {

        Font fontt = new Font("Arial", Font.BOLD, 17);
        Font font = new Font("Arial", Font.PLAIN, 15);
        Font fontp = new Font("Arial", Font.BOLD, 23);

        private JLabel lblIcon = new JLabel();
        private JLabel lblNombre = new JLabel();
        private JLabel lblPrecio = new JLabel();
        private JLabel lblDescripcion = new JLabel();

        public CellRenderer()
        {
            setLayout(new BorderLayout(50, 10));
            setBorder(new LineBorder(new Color(120, 120, 120), 1));
            JPanel panelText = new JPanel(new GridLayout(4, 1));
            panelText.add(lblNombre);
            panelText.add(lblPrecio);
            panelText.add(lblDescripcion);
            add(Box.createRigidArea(new Dimension(5, 0)), BorderLayout.WEST);
            add(lblIcon, BorderLayout.WEST);
            add(panelText, BorderLayout.CENTER);
            panelText.setBackground(Util._bodyColor);
            setBackground(Util._bodyColor);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Articulo> list, Articulo art, int index,boolean isSelected, boolean cellHasFocus) {

            lblIcon.setIcon(imageMap.get(art.getId()));
            lblNombre.setText(art.getNombre());
            lblPrecio.setText(Double.toString(art.getPrecio()) + "\u20AC");
            lblDescripcion.setText(art.getDescripcion());
            lblNombre.setFont(fontt);
            lblPrecio.setFont(fontp);
            lblDescripcion.setFont(font);
            if (isSelected) {
            	setBorder(new LineBorder(new Color(50, 50, 120), 2));
			}
            else
            {
                setBorder(new LineBorder(new Color(120, 120, 120), 1));
            }
            return this;
        }
    }
}
