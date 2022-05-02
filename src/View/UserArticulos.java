package View;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import ModeloDominio.Vendedor;
import View.Controllers.ArticuloController;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserArticulos extends JDialog {
    private JPanel contentPane;
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;
    private Articulo _articulo;
    private JButton ArticulosButton;
    private PedidoController _pctrl;
    private VendedorController _vctrl;
    private ArticuloController _actrl;
    private Vendedor v;
    private JButton volverButton;


    public UserArticulos(Vendedor v, VendedorController _vctrl, ArticuloController _actrl){
        setModal(true);
        this.v = v;
        this._vctrl = _vctrl;
        this._actrl = _actrl;
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

        imageMap = createImageMap(v.getArticulos());
        crearModeloJlist(v.getArticulos());
        list.setModel(modeloJLista);
        list.setCellRenderer(new UserArticulos.CellRenderer());
        scrollPane.setViewportView(list);


        list.setFixedCellHeight(250);
        list.setFixedCellWidth(250);

        JPanel Total_pay = new JPanel();
        Total_pay.setLayout(new FlowLayout(FlowLayout.CENTER, 55, 0));
        Total_pay.setBorder(new EmptyBorder(5, 0, 5, 0));
        contentPane.add(Total_pay, BorderLayout.SOUTH);
        Total_pay.setBackground(Util._barColor);

        JButton anadirButton = new JButton();
        anadirButton.setBackground(Util._barColor);
        anadirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anadirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArticleWindow ventanaArticulo = new ArticleWindow(list.getSelectedValue(), _actrl, Util.Emode.Anadir, _vctrl, v);
                ventanaArticulo.setVisible(true);
                crearModeloJlist(v.getArticulos());
                list.setModel(modeloJLista);
                list.setCellRenderer(new UserArticulos.CellRenderer());
                scrollPane.setViewportView(list);
            }
        });
        
        JButton volverButton_1 = new JButton();
        volverButton_1.setBackground(Util._barColor);
        volverButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        volverButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        volverButton_1.setText("volver");
        Total_pay.add(volverButton_1);

        anadirButton.setText("A\u00F1adir art\u00EDculo");
        Total_pay.add(anadirButton);

        JButton eliminarButton = new JButton();
        eliminarButton.setBackground(Util._barColor);
        eliminarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Articulo> articulos = v.getArticulos();
                articulos.remove(list.getSelectedValue());
                crearModeloJlist(v.getArticulos());
                list.setModel(modeloJLista);
                list.setCellRenderer(new UserArticulos.CellRenderer());
                scrollPane.setViewportView(list);
            }
        });
        
        JButton editarButton = new JButton();
        editarButton.setBackground(Util._barColor);
        editarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArticleWindow ventanaArticulo = new ArticleWindow(list.getSelectedValue(),_actrl, Util.Emode.Modificar, _vctrl, v);
                ventanaArticulo.setVisible(true);
                crearModeloJlist(v.getArticulos());
                list.setModel(modeloJLista);
                list.setCellRenderer(new UserArticulos.CellRenderer());
                scrollPane.setViewportView(list);
            }
        });
        editarButton.setText("Editar art\u00EDculo");
        Total_pay.add(editarButton);
        eliminarButton.setText("Elminar art\u00EDculo");
        Total_pay.add(eliminarButton);

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
