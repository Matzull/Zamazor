package View;

import Misc.Util;
import ModeloDominio.Articulo;
import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;
import View.Controllers.ArticuloController;
import View.Controllers.CompradorController;
import View.Controllers.PedidoController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * esta clase es la ventana principal de la interfaz donde estan listados por defecto todos los productos
 * y con la barra de busqueda puedes buscar los productos que tengan un nombre similar a lo escrito.
 * Tambien hay un boton de login que sirve tambien para registrarse.
 */
public class MainWindow {

    private JFrame frame;
    private JTextField buscadorTXT;
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;

    private Comprador comp = null;
    private Vendedor vend = null;

    private int vendor = 0;//0 nothing, 1 vendor, 2 buyer
 
    private JList<Articulo> list;


    private ArticuloController _actrl;
    private CompradorController _cctrl;
    private PedidoController _pctrl;
    private VendedorController _vctrl;


    /**
     * esta constructora solo inicia el metodo iniciar que inicializa la interfaz
     */
    public MainWindow() {
        Util.startConnection();
        _actrl = new ArticuloController();
        _cctrl = new CompradorController();
        _pctrl = new PedidoController();
        _vctrl = new VendedorController();
        initialize();
    }

    private Map<Integer, ImageIcon> createImageMap(List<Articulo> fullTable) {
    
        Map<Integer, ImageIcon> map = new HashMap<>();
        for (Articulo s : fullTable) {
            map.put(s.getId(), s.getImage(1));            
        }
        return map;
    }

    /**
     * crea la interfaz principal que contiene todos los articulos enlistados por defecto
     * la barra de busqueda para buscar articulos en la base de datos y incluirlos en la interfaz, y un boton de
     * login que lleva a la clase de login para registrarse como comprador o vendedor
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 596, 428);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Util.closeConnection();
            }
        });

        modeloJLista = new DefaultListModel<>();

        JPanel panel = new JPanel();
        panel.setBackground(Util._barColor);
        frame.getContentPane().add(panel, BorderLayout.NORTH);


        JLabel fotoZamazor = new JLabel("");
        ImageIcon iconLogo = new ImageIcon("resources/zamazor.png");
        fotoZamazor.setIcon(Util.scaleImage(iconLogo, 500, 500));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(fotoZamazor);
        panel.add(Box.createRigidArea(new Dimension(300, 0)));

        buscadorTXT = new JTextField();
        buscadorTXT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        buscadorTXT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String texto = buscadorTXT.getText().toLowerCase();
                    filter(texto);
                }
            }
        });
        panel.add(buscadorTXT);
        buscadorTXT.setColumns(40);

        JButton botonBuscar = new JButton("");
        //botonBuscar.setBorderPainted(false);
        botonBuscar.setBackground(Util._barColor);
        botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        iconLogo = new ImageIcon("resources/search.png");
        botonBuscar.setIcon(iconLogo);
        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = buscadorTXT.getText().toLowerCase();
                filter(texto);
            }
        });
        panel.add(botonBuscar);
        panel.add(Box.createRigidArea(new Dimension(300, 0)));
        
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(Box.createGlue());
        JLabel logoutIcon = new JLabel();
        logoutIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if (vendor != 0)
                    {
                        vendor = 0;
                        vend = null;
                        comp = null;
                        JOptionPane.showMessageDialog(null, "Loged out");
                    }
                }
        });
        logoutIcon.setIcon(Util.scaleImage(new ImageIcon("resources/Log-out.png"), 0.04));

        panel.add(logoutIcon);
        
        loginIcon = new JLabel();
        loginIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vendor == 0)
                {
                    Login login = new Login(_cctrl, _vctrl, _pctrl);
                    login.setVisible(true);
                    if(login.getIsVendedor() == 1)
                    {
                        vend = login.getVendedor();
                        vendor = 1;
                    }
                    else if(login.getIsVendedor() == 2)
                    {
                        comp = login.getComprador();
                        vendor = 2;
                    }
                }
                else if(vendor == 1)
                {
                    UserInfoWindow userInfo = new UserInfoWindow(vend, _vctrl, _actrl);
                }
                else if(vendor == 2)
                {
                    UserInfoWindow userInfo = new UserInfoWindow(comp, _cctrl);
                }
                else
                {
                    UserInfoWindow userInfo = new UserInfoWindow();
                }

            }
        });
        iconLogo = Util.scaleImage(new ImageIcon("resources/user.png"), 0.04);
        loginIcon.setIcon(iconLogo);
        panel.add(loginIcon);


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
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                eventoClickArticulo();
            }
        });
        list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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

    protected void eventoClickArticulo() {
    	ArticleWindow ventanaArticulo = new ArticleWindow(list.getSelectedValue(), comp, _cctrl);
    	ventanaArticulo.setVisible(true);
		
	}

    private void filter(String texto) {
        crearModeloJlist(_actrl.buscarArticulo(texto));
        list.setModel(modeloJLista);
    }

	private void crearModeloJlist(List<Articulo> arts) {
        modeloJLista.clear();
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
    /**
     * esta funcion consulta un articulo en la base de datos llamando a la funcion
     * del controller, si no hay un articulo con el mismo id se muestra un mensaje de error
     * indicando la falta de un id igual al del articulo que se queria consultar
     * @param id es el id del articulo que se quiere modificar en la base de datos
     */
    
    public Articulo consultarArticulo(int id)
	{
		Articulo ret = _actrl.consultarArticulo(id);
		if(ret == null)
		{
			JOptionPane.showMessageDialog(frame, "Id not found", "error", JOptionPane.ERROR_MESSAGE);
		}
		
		return ret;
	}
    /**
     * esta funcion modifica un articulo en la base de datos llamando a la funcion
     * del controller, si no hay un articulo con el mismo id se muestra un mensaje de error
     * indicando la falta de un id igual al del articulo que se queria modificar
     * @param a es el articulo que se quiere modificar en la base de datos
     */
	public void modificarArticulo(Articulo a) {
		if(!_actrl.modificarArticulo(a))
		{
			JOptionPane.showMessageDialog(frame, "Id not found", "error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

    /**
     * esta funcion inserta un articulo en la base de datos llamando a la funcion
     * del controller, si ya hay un articulo con el mismo id se muestra un mensaje de error
     * indicando la existencia de un id igual al articulo que se queria insertar
     * @param a es el articulo que se quiere insertar en la base de datos
     */
	public void altaArticulo(Articulo a) {
		if(!_actrl.altaArticulo(a))
		{
			JOptionPane.showMessageDialog(frame, "Id already exists", "error", JOptionPane.ERROR_MESSAGE);
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
            lblIcon.setBorder(new EmptyBorder(5, 15, 5, 5));
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
