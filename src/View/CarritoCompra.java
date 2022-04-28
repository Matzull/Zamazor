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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;


public class CarritoCompra {

    private JFrame frame;
    private JTextField buscadorTXT;
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;

    private ArticuloController _actrl = new ArticuloController();
    private PedidoController _pctrl = new PedidoController();
    private final Action action = new SwingAction();;


    public CarritoCompra() {
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
        panel.setBackground(new Color(148, 0, 211));
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(147, 112, 219));
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.add(panel_1, BorderLayout.CENTER);

        JLabel fotoZamazor = new JLabel();
        ImageIcon iconLogo = Util.scaleImage(new ImageIcon("resources/IconoZamazor.png"), 3);
        fotoZamazor.setIcon(iconLogo);
        panel_1.add(fotoZamazor);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(147, 112, 219));
        panel.add(panel_2);

        buscadorTXT = new JTextField();
        buscadorTXT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_2.add(buscadorTXT);
        buscadorTXT.setColumns(40);

        JButton botonBuscar = new JButton("");
        botonBuscar.setBorderPainted(false);
        botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        iconLogo = new ImageIcon("resources/search.png");
        botonBuscar.setIcon(iconLogo);
        panel_2.add(botonBuscar);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(147, 112, 219));
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel.add(panel_3);

        iconLogo = Util.scaleImage(new ImageIcon("resources/user.png"), 0.04);
        loginIcon.setIcon(iconLogo);
        panel_3.add(loginIcon);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        frame.getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setBorder(null);
        panel_4.setLayout(new CardLayout());

        scrollPane = new JScrollPane();
        panel_4.add(scrollPane, "name_179239712047600");


        JList<Articulo> list = new JList<Articulo>();
        imageMap = createImageMap(fullTablePedidos());
        crearModeloJlist(fullTablePedidos());
        list.setModel(modeloJLista);
        list.setCellRenderer(new CellRenderer());
        scrollPane.setViewportView(list);


        list.setFixedCellHeight(250);
        list.setFixedCellWidth(250);
        
        JPanel panel_5 = new JPanel();
        scrollPane.setColumnHeaderView(panel_5);
        
        JButton btnNewButton = new JButton("Comprar");
        btnNewButton.setAction(action);
        btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_5.add(btnNewButton);
        //JLabel lblNewLabel = new JLabel("New label");
        //scrollPane.setRowHeaderView(lblNewLabel);

    }

    public void crearModeloJlist(List<Articulo> arts) {
        modeloJLista = new DefaultListModel<>();

        for (Articulo ar : arts) {
            modeloJLista.addElement(ar);
        }

    }
    private List<Articulo> fullTablePedidos() {

        return _pctrl.fullTableP();
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			_pctrl
		}
	}
}
