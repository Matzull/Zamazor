package View;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPedidos extends JDialog {

    private JPanel contentPane;
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;
    private Pedido _pedido;
    private JButton pedidosButton;
    private PedidoController _pctrl;
    private CompradorController _cctrl;
    private Comprador comp;
    private JButton volverButton;

    public UserPedidos(Comprador c, CompradorController _cctrl){
        setModal(true);
        this.comp = c;
        this._pedido = comp.getPedidos().get(comp.getPedidos().size() - 1);

        this._cctrl = _cctrl;
        initGUI();
        setVisible(true);
    }

    private Map<Integer, ImageIcon> createImageMap(java.util.List<Articulo> fullTable) {

        Map<Integer, ImageIcon> map = new HashMap<>();
        for (Articulo s : fullTable) {
            map.put(s.getId(), s.getImage(1));
        }
        return map;
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 700, 601);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        modeloJLista = new DefaultListModel<>();

        _pctrl = new PedidoController();

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBorder(null);
        mainPanel.setLayout(new CardLayout());
        mainPanel.setBackground(Util._bodyColor);

        scrollPane = new JScrollPane();
        scrollPane.setBackground(Util._bodyColor);
        mainPanel.add(scrollPane, "name_179239712047600");


        JList<Articulo> list = new JList<Articulo>();

        imageMap = createImageMap(_pedido.getArticulos());
        crearModeloJlist(_pedido.getArticulos());
        list.setModel(modeloJLista);
        list.setCellRenderer(new UserPedidos.CellRenderer());
        scrollPane.setViewportView(list);


        list.setFixedCellHeight(250);
        list.setFixedCellWidth(250);

        JPanel Total_pay = new JPanel();
        Total_pay.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 0));
        Total_pay.setBorder(new EmptyBorder(5, 0, 5, 0));
        contentPane.add(Total_pay, BorderLayout.SOUTH);
        Total_pay.setBackground(Util._barColor);

        JButton volverButton = new JButton();
        volverButton.setBorder(null);
        volverButton.setPreferredSize(new Dimension(100,50));
        volverButton.setBackground(Util._bodyColor);
        volverButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        volverButton.setText("volver");
        Total_pay.add(volverButton);

        JLabel Total_lbl = new JLabel("Total:");
        Total_lbl.setFont(new Font("Arial", Font.PLAIN, 14));
        Total_pay.add(Total_lbl);


        Double Total = 0.0;
        for (Articulo art : _pedido.getArticulos()) {
            Total += art.getPrecio();
        }
        JLabel Precio = new JLabel(Double.toString(Total) + "\u20AC");
        Precio.setFont(new Font("Arial", Font.BOLD, 23));
        Total_pay.add(Precio);

    }

    private void crearModeloJlist(List<Articulo> arts) {
        modeloJLista.clear();

        for (Articulo ar : arts) {
            modeloJLista.addElement(ar);
        }
    }

    public class CellRenderer extends JPanel implements ListCellRenderer<Articulo> {

        Font fontt = new Font("Arial", Font.BOLD, 17);
        Font font = new Font("Arial", Font.PLAIN, 15);
        Font fontp = new Font("Arial", Font.BOLD, 23);

        private JLabel lblIcon = new JLabel();
        private JLabel lblNombre = new JLabel();
        private JLabel lblPrecio = new JLabel();
        private JLabel lblDescripcion = new JLabel();

        public CellRenderer() {
            setLayout(new BorderLayout(50, 10));
            setBorder(new LineBorder(new Color(120, 120, 120), 1));
            JPanel panelText = new JPanel(new GridLayout(4, 1));
            panelText.add(lblNombre);
            panelText.add(lblDescripcion);
            add(lblIcon, BorderLayout.WEST);
            lblIcon.setBorder(new EmptyBorder(5, 15, 5, 5));
            add(panelText, BorderLayout.CENTER);
            add(lblPrecio, BorderLayout.EAST);
            lblPrecio.setBorder(new EmptyBorder(5, 5, 5, 15));
            panelText.setBackground(Util._bodyColor);
            setBackground(Util._bodyColor);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Articulo> list, Articulo art, int index, boolean isSelected, boolean cellHasFocus) {

            lblIcon.setIcon(imageMap.get(art.getId()));
            lblNombre.setText(art.getNombre());
            lblPrecio.setText(Double.toString(art.getPrecio()) + "\u20AC");
            lblDescripcion.setText(art.getDescripcion());
            lblNombre.setFont(fontt);
            lblPrecio.setFont(fontp);
            lblDescripcion.setFont(font);
            if (isSelected) {
                setBorder(new LineBorder(new Color(50, 50, 120), 2));
            } else {
                setBorder(new LineBorder(new Color(120, 120, 120), 1));
            }

            return this;
        }
    }
}