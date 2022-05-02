package View;

import Misc.Util;
import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;
import View.Controllers.ArticuloController;
import View.Controllers.CompradorController;
import View.Controllers.VendedorController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInfoWindow extends JFrame {

    private JPanel contentPane;
    private Vendedor vendedor;
    private Comprador comprador;
    private ImageIcon user, cart, sad, edit, save, volver;
    private DefaultTableModel tabla;
    private JTextField nombreText;
    private JTextField emailText;
    private JTextField idText;
    private JTextField userText;
    private JTextField telefonoText;
    private JPasswordField passwordField;
    private boolean editable;
    private JButton pedidosButton, modificarButton, eliminarButton, cartButtton, returnButton;
    private CompradorController _cctrl;
    private VendedorController _vctrl;
    private ArticuloController _actrl;


    /**
     * En esta constructora se activa cuando no se ha
     */
    public UserInfoWindow() {
        this.setTitle("Informacion de usuario");
        loadIcon();
        initGUI();
        this.setVisible(true);
        editable = false;
    }

    /**
     * esta constructora de la ventana se activa cuando se registra un vendedor
     * @param vendedor se pasa a la constructora el vendedor registrado y se cargaran
     *        todos sus datos (con fillVendor()) junto con la ventana en la funcion initGUI()
     */
    public UserInfoWindow(Vendedor vendedor, VendedorController _vctrl, ArticuloController _actrl) {
        this.vendedor = vendedor;
        this._actrl = _actrl;
        loadIcon();
        this.setVisible(true);
        initGUI();
        fillVendor();
    }
    /**
     * esta constructora de la ventana se activa cuando se registra un vendedor
     * @param comprador se pasa a la constructora el vendedor registrado y se cargaran
     *        todos sus datos (con fillBuyer()) junto con la ventana en la funcion initGUI()
     */
    public UserInfoWindow(Comprador comprador, CompradorController _cctrl) {
        this.comprador = comprador;
        loadIcon();
        this._cctrl = _cctrl;
        this.setVisible(true);
        initGUI();
        fillBuyer();
    }

    /**
     * se encarga de iniciar la ventana de informacion de usuario
     */
    private void initGUI() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 700, 601);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0,0,0,0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Util._barColor);
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setLayout(new GridLayout(0, 7, 0, 0));
        buttonsPanel.setBorder(new EmptyBorder(5, 0, 5 ,0));

        if(comprador != null) {
            pedidosButton = new JButton("Pedidos");
            pedidosButton.setBackground(Util._barColor);
            pedidosButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Mostrar los pedidos del usuario
                    UserPedidos pe = new UserPedidos(comprador, _cctrl);
                }
            });
        }
        else if(vendedor != null){
            pedidosButton = new JButton("Articulos");
            pedidosButton.setBackground(Util._barColor);
            pedidosButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Mostrar los pedidos del usuario
                    UserArticulos ar = new UserArticulos(vendedor, _vctrl, _actrl);
                }
            });
        }
        
        JSeparator separator = new JSeparator();
        separator.setForeground(Util._barColor);
        separator.setBackground(Util._barColor);
        buttonsPanel.add(separator);
        pedidosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonsPanel.add(pedidosButton);

        modificarButton = new JButton("Modificar");
        modificarButton.setBackground(Util._barColor);
        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(!editable) {
                    int i = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer modificar su cuenta?", "Modificar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(i == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Habilitado modo edicion de cuenta", "Modificar cuenta", 0 , edit);
                        enableEdit();
                    }
                }
                else {
                    int i = JOptionPane.showConfirmDialog(null, "¿Esta seguro de los datos modificados?", "Modificar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(i == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Datos actualizados. Desactivado modo edicion de cuenta", "Modificar cuenta", 0 , save);
                        enableEdit();
                        comprador.setNombre(nombreText.getText());
                        comprador.setEmail(emailText.getText());
                        comprador.setCuenta(userText.getText());
                        _cctrl.modificarComprador(comprador);
                    }
                }

            }
        });
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(Util._barColor);
        separator_1.setForeground(Util._barColor);
        buttonsPanel.add(separator_1);
        modificarButton.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        buttonsPanel.add(modificarButton);

        eliminarButton = new JButton("Borrar");
        eliminarButton.setBackground(Util._barColor);
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres borrar tu cuenta?", "Borrar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if(i == JOptionPane.YES_OPTION) {
                    int j = JOptionPane.showConfirmDialog(null, "¿Estas REALMENTE seguro de que quieres BORRAR tu cuenta?", "Borrar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if(j == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Cuenta eliminada de Zamazor", "CUENTA BORRADA", 0 ,sad);
                        dispose();
                        _cctrl.bajaComprador(comprador.getId());
                    }
                }
            }
        });
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBackground(Util._barColor);
        separator_2.setForeground(Util._barColor);
        buttonsPanel.add(separator_2);
        eliminarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonsPanel.add(eliminarButton);

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Util._bodyColor);
        contentPane.add(infoPanel, BorderLayout.CENTER);
        infoPanel.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(72, 39, 106, 53);
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        infoPanel.add(idLabel);

        idText = new JTextField();
        idText.setBounds(171, 39, 384, 53);
        idText.setHorizontalAlignment(SwingConstants.LEFT);
        idText.setEditable(false);
        infoPanel.add(idText);
        idText.setColumns(10);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(41, 120, 179, 53);
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(nombreLabel);

        nombreText = new JTextField();
        nombreText.setBounds(171, 120, 384, 53);
        nombreText.setHorizontalAlignment(SwingConstants.LEFT);
        nombreText.setEditable(false);
        infoPanel.add(nombreText);
        nombreText.setColumns(10);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(41, 201, 179, 53);
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(171, 201, 384, 53);
        emailText.setHorizontalAlignment(SwingConstants.LEFT);
        emailText.setEditable(false);
        infoPanel.add(emailText);
        emailText.setColumns(10);
        if(comprador != null) {
            JLabel cuentaLabel = new JLabel("Nombre de usuario:");
            cuentaLabel.setBounds(21, 280, 179, 53);
            cuentaLabel.setHorizontalAlignment(SwingConstants.CENTER);
            infoPanel.add(cuentaLabel);

            userText = new JTextField();
            userText.setBounds(171, 280, 384, 53);
            userText.setEditable(false);
            userText.setHorizontalAlignment(SwingConstants.LEFT);
            infoPanel.add(userText);
            userText.setColumns(10);
        }
        else if(vendedor != null) {
            JLabel telefonoLabel = new JLabel("Telefono:");
            telefonoLabel.setBounds(21, 280, 179, 53);
            telefonoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            infoPanel.add(telefonoLabel);

            telefonoText = new JTextField();
            telefonoText.setBounds(171, 280, 384, 53);
            telefonoText.setEditable(false);
            telefonoText.setHorizontalAlignment(SwingConstants.LEFT);
            infoPanel.add(telefonoText);
            telefonoText.setColumns(10);


        }

        JLabel passLabel = new JLabel("Contrase\u00F1a:");
        passLabel.setBounds(21, 358, 179, 53);
        passLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(171, 358, 384, 53);
        passwordField.setEditable(false);
        passwordField.setEchoChar('*');
        infoPanel.add(passwordField);
        
        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(Util._barColor);
        contentPane.add(toolBar, BorderLayout.NORTH);
        toolBar.setSize(120, 60);


        JLabel userLabel = new JLabel("");
        userLabel.setBounds(600, 50, 179, 53);
        userLabel.setIcon(Util.scaleImage(user,0.5));
        infoPanel.add(userLabel);

        returnButton = new JButton();
        returnButton.setBorder(null);
        returnButton.setBackground(Util._bodyColor);
        returnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        returnButton.setIcon(volver);
        toolBar.add(returnButton);
        
        toolBar.add(Box.createHorizontalGlue());

        if(vendedor == null)
        {
            cartButtton = new JButton("");
            cartButtton.setBorderPainted(false);
            cartButtton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cartButtton.setBackground(Util._barColor);
            cartButtton.setBorder(UIManager.getBorder("DesktopIcon.border"));
            toolBar.add(cartButtton);
            cartButtton.setIcon(Util.scaleImage(cart,0.35));
            cartButtton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CarritoCompra cart = new CarritoCompra(comprador, _cctrl);
                }
            });
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void enableEdit() {

        if(!editable) {
            nombreText.setEditable(true);
            emailText.setEditable(true);
            idText.setEditable(false);
            userText.setEditable(true);
            passwordField.setEditable(false);
            editable = true;
            passwordField.setEchoChar((char) 0);
            cartButtton.setEnabled(false);
            eliminarButton.setEnabled(false);
            pedidosButton.setEnabled(false);
            returnButton.setEnabled(false);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else {
            nombreText.setEditable(false);
            emailText.setEditable(false);
            idText.setEditable(false);
            userText.setEditable(false);
            passwordField.setEditable(false);
            editable = false;
            passwordField.setEchoChar('*');
            cartButtton.setEnabled(true);
            eliminarButton.setEnabled(true);
            pedidosButton.setEnabled(true);
            returnButton.setEnabled(true);
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    private void loadIcon() {
        try {
            this.user = new ImageIcon("resources/user1.png");
            this.cart = new ImageIcon("resources/cart.png");
            this.sad = new ImageIcon("resources/sad.gif");
            this.edit = new ImageIcon("resources/edit.png");
            this.save = new ImageIcon("resources/save.png");
            this.volver = new ImageIcon("resources/volver.png");
        } catch (Exception e) {
        }
    }

    private void fillVendor()
    {
        idText.setText(vendedor.getId().toString());
        nombreText.setText(vendedor.getNombre());
        emailText.setText(vendedor.getEmail());
        telefonoText.setText(vendedor.getTelefono().toString());
        passwordField.setText(vendedor.getPassword());
    }

    private void fillBuyer()
    {
        idText.setText(comprador.getId().toString());
        nombreText.setText(comprador.getNombre());
        emailText.setText(comprador.getEmail());
        userText.setText(comprador.getCuenta());
        passwordField.setText(comprador.getPassword());
    }
}