package View;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
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
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;
    private Pedido _pedido;



    public CarritoCompra(Comprador comp) {
        this._pedido = comp.getPedidos().get(comp.getPedidos().length() - 1);
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

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(SystemColor.inactiveCaptionBorder);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBorder(null);
        mainPanel.setLayout(new CardLayout());

        scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, "name_179239712047600");


        JList<Articulo> list = new JList<Articulo>();
        imageMap = createImageMap(_pedido.getArticulos());
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

    }

    public void crearModeloJlist(List<Articulo> arts) {
        modeloJLista = new DefaultListModel<>();

        for (Articulo ar : arts) {
            modeloJLista.addElement(ar);
        }

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

}
