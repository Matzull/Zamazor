package View;

import Misc.Util;
import ModeloDominio.Articulo;
import View.Controllers.ArticulosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainWindow {

    private JFrame frame;
    private JTextField buscadorTXT;
    private ArticulosController _ctrl;
    private DefaultListModel modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<String, ImageIcon> imageMap;


    public MainWindow(ArticulosController ctrl) {
        _ctrl = ctrl;
        initialize();
    }

    private Map<String, ImageIcon> createImageMap(List<Articulo> fullTable) {

        Map<String, ImageIcon> map = new HashMap<>();
        for (Articulo s : fullTable) {
            map.put(s.getNombre() + s.getDescripcion()+ s.getPrecio(), s.getImage(0.25));
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
        panel.add(panel_1);

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

        loginIcon = new JLabel();
        loginIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
            }
        });
        iconLogo = Util.scaleImage(new ImageIcon("resources/user.png"), 0.04);
        loginIcon.setIcon(iconLogo);
        panel_3.add(loginIcon);

        Panel panel_4 = new Panel();
        panel_4.setBackground(SystemColor.inactiveCaptionBorder);
        frame.getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new CardLayout(0, 0));

        scrollPane = new JScrollPane();
        panel_4.add(scrollPane, "name_179239712047600");


        JList list = new JList();
        imageMap = createImageMap(fullTable());
        crearModeloJlist(fullTable());
        list.setModel(modeloJLista);
        list.setCellRenderer(new metodoMeterFotos());
        scrollPane.setViewportView(list);


        list.setFixedCellHeight(50);
        list.setFixedCellWidth(100);

        //JLabel lblNewLabel = new JLabel("New label");
        //scrollPane.setRowHeaderView(lblNewLabel);

    }

    public void crearModeloJlist(List<Articulo> arts) {
        modeloJLista = new DefaultListModel();

        for (Articulo ar : arts) {
            Object[] interior = {ar.getId(), ar.getNombre(), ar.getPrecio(), ar.getStock(), ar.getDescripcion(), ar.getValoracion(), ar.getTipo(), ar.getVendedor_id()};
            modeloJLista.addElement(ar.getNombre()+ ar.getDescripcion()+  ar.getPrecio());
        }

    }
    private List<Articulo> fullTable() {

        return _ctrl.fullTable();
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);

    }

    public class metodoMeterFotos extends DefaultListCellRenderer {

        Font font = new Font("Arial", Font.BOLD, 15);

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }
}
