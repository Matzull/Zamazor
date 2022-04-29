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
 * TODO PONER MAS INFORMACION DE LAS CLASES SI ES QUE FALTAN
 */
public class MainWindow {

    private JFrame frame;
    private JTextField buscadorTXT;
    private DefaultListModel<Articulo> modeloJLista;
    JLabel loginIcon;
    JScrollPane scrollPane;
    JLabel[] labelsParaImagenes;
    private Map<Integer, ImageIcon> imageMap;

    private Comprador comp;
    private Vendedor vend;

    private int vendor = 0;//0 nothing, 1 vendor, 2 buyer
 
    private JList<Articulo> list;

    private ArticuloController _actrl = new ArticuloController();
    private CompradorController _cctrl = new CompradorController();
    private PedidoController _pctrl = new PedidoController();
    private VendedorController _vctrl = new VendedorController();


    /**
     * esta constructora solo inicia el metodo iniciar que inicializa la interfaz
     */
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
                if (vendor == 0)
                {
                    Login login = new Login(_cctrl, _vctrl);
                    login.setVisible(true);
                    if(login.getIsVendedor() == 1)
                    {
                        vend = login.getVendedor();
                        vendor = 1;
                    }
                    else
                    {
                        comp = login.getComprador();
                        vendor = 2;
                    }
                }
                else if(vendor == 1)
                {
                    UserInfoWindow userInfo = new UserInfoWindow(vend);
                }
                else if(vendor == 2)
                {
                    UserInfoWindow userInfo = new UserInfoWindow(comp);
                }
                else
                {
                    UserInfoWindow userInfo = new UserInfoWindow();
                }

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
    	ArticleWindow ventanaArticulo = new ArticleWindow(this, list.getSelectedValue());
    	ventanaArticulo.setVisible(true);
		
	}

    private void filter(String texto) {
        crearModeloJlist(_actrl.buscarArticulo(texto));
        list.setModel(modeloJLista);
    }

	private void crearModeloJlist(List<Articulo> arts) {
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
