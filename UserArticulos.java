package View;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Pedido;
import ModeloDominio.Vendedor;
import View.ArticleWindow.Emode;
import View.Controllers.ArticuloController;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private Vendedor v;
    private JButton volverButton;
    private JList<Articulo> list;
    private ArticuloController _actrl;

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


        list = new JList<Articulo>();

        imageMap = createImageMap(v.getArticulos());
        crearModeloJlist(v.getArticulos());
        list.setModel(modeloJLista);
        list.setCellRenderer(new UserArticulos.CellRenderer());
        scrollPane.setViewportView(list);


        list.setFixedCellHeight(250);
        list.setFixedCellWidth(250);

        JPanel Total_pay = new JPanel();
        Total_pay.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 0));
        Total_pay.setBorder(new EmptyBorder(5, 0, 5, 0));
        contentPane.add(Total_pay, BorderLayout.SOUTH);
        Total_pay.setBackground(Util._barColor);

        

        JButton anadirButton = new JButton();
        anadirButton.setBorder(null);
        anadirButton.setPreferredSize(new Dimension(100,50));
        anadirButton.setBackground(Util._bodyColor);
        anadirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anadirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	ArticleWindow ventanaArticulo = new ArticleWindow(list.getSelectedValue(),Emode.Anadir,_actrl);
            	ventanaArticulo.setVisible(true);
            	
            	
            }
        });
        anadirButton.setText("Elminar articulo");
        Total_pay.add(anadirButton);
        
        JButton eliminarButton = new JButton();
        eliminarButton.setBorder(null);
        eliminarButton.setPreferredSize(new Dimension(100,50));
        eliminarButton.setBackground(Util._bodyColor);
        eliminarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	//Falta borrar el articulo de la lista de articulos del vendedor
            	List<Articulo> articulos = v.getArticulos();
            	articulos.remove(list.getSelectedValue());    
            	v.setArticulos(articulos);
            	_vctrl.modificarVendedor(v);
            	
            	//_actrl.bajaArticulo(list.getSelectedValue().getId());
            }
        });
        eliminarButton.setText("Elminar articulo");
        Total_pay.add(eliminarButton);
        
        
        JButton editarButton = new JButton();
        editarButton.setBorder(null);
        editarButton.setPreferredSize(new Dimension(100,50));
        editarButton.setBackground(Util._bodyColor);
        editarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	ArticleWindow ventanaArticulo = new ArticleWindow(list.getSelectedValue(),Emode.Modificar,_actrl);
            	ventanaArticulo.setVisible(true);
            	
            	crearModeloJlist(v.getArticulos());
                list.setModel(modeloJLista);
                list.setCellRenderer(new UserArticulos.CellRenderer());
                scrollPane.setViewportView(list);
            }
        });
        editarButton.setText("Editar articulo");
        Total_pay.add(editarButton);
        
        
        
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
        for (Articulo art : v.getArticulos()) {
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
