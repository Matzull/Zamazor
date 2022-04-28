package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ModeloDominio.Comprador;
import ModeloDominio.Vendedor;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;

import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JToolBar;

import Misc.Util;

public class userInfoWindow extends JFrame {

    private JPanel contentPane;
    private Vendedor vendedor;
    private Comprador comprador;
    private ImageIcon user, cart, sad, edit, save, volver;
    private DefaultTableModel tabla;
    private JTextField nombreText;
    private JTextField emailText;
    private JTextField idText;
    private JTextField userText;
    private JPasswordField passwordField;
    private boolean editable;
    private JButton pedidosButton, modificarButton, eliminarButton, cartButtton, returnButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    userInfoWindow frame = new userInfoWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public userInfoWindow() {
        this.setTitle("Zamazor -> Informacion de usuario");
        loadIcon();
        initGUI();
        editable = false;
    }

    public userInfoWindow(Vendedor vendedor) {
        this.vendedor = vendedor;
        loadIcon();
        initGUI();
    }

    public userInfoWindow(Comprador comprador) {
        this.comprador = comprador;
        loadIcon();
        initGUI();
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 601);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel buttonsPanel = new JPanel();
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setLayout(new GridLayout(0, 3, 0, 0));

        pedidosButton = new JButton("Mis pedidos");
        pedidosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Mostrar los pedidos del usuario
            }
        });
        pedidosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonsPanel.add(pedidosButton);

        modificarButton = new JButton("Modificar cuenta");
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
                    }
                }

            }
        });
        modificarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonsPanel.add(modificarButton);

        eliminarButton = new JButton("Borrar cuenta");
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres borrar tu cuenta?", "Borrar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if(i == JOptionPane.YES_OPTION) {
                    int j = JOptionPane.showConfirmDialog(null, "¿Estas REALMENTE seguro de que quieres BORRAR tu cuenta?", "Borrar cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if(j == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Cuenta eliminada de Zamazor", "CUENTA BORRADA", 0 ,sad);
                        dispose();
                    }
                }
            }
        });
        eliminarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonsPanel.add(eliminarButton);

        JPanel infoPanel = new JPanel();
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

        JLabel passLabel = new JLabel("Contrase\u00F1a:");
        passLabel.setBounds(21, 358, 179, 53);
        passLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(171, 358, 384, 53);
        passwordField.setEditable(false);
        passwordField.setEchoChar('*');
        infoPanel.add(passwordField);

        /*JPanel userCarroPanel = new JPanel();
        userCarroPanel.setBackground(new Color(176, 224, 230));
        userCarroPanel.setForeground(new Color(147, 112, 219));
        contentPane.add(userCarroPanel, BorderLayout.EAST);
        userCarroPanel.setLayout(new BoxLayout(userCarroPanel, BoxLayout.LINE_AXIS));*/
        
        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(new Color(147, 112, 219));
        contentPane.add(toolBar, BorderLayout.NORTH);
        toolBar.setSize(120, 60);

        /*Component horizontalGlue_1 = Box.createHorizontalGlue();
        horizontalGlue_1.setMinimumSize(new Dimension(499, 499));
        horizontalGlue_1.setMaximumSize(new Dimension(500, 500));
        userCarroPanel.add(horizontalGlue_1);*/

        JLabel userLabel = new JLabel("");
        userLabel.setBounds(600, 50, 179, 53);
        userLabel.setIcon(Util.scaleImage(user,0.5));
        infoPanel.add(userLabel);
/*
        Component horizontalGlue = Box.createHorizontalGlue();
        userCarroPanel.add(horizontalGlue);*/

        
        returnButton = new JButton();
        returnButton.setBorder(null);
        returnButton.setBackground(new Color(255, 255, 0));
        returnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        returnButton.setIcon(volver);
        toolBar.add(returnButton);
        

        /*Component horizontalGlue_2 = Box.createHorizontalGlue();
        horizontalGlue_2.setMinimumSize(new Dimension(499, 499));
        horizontalGlue_2.setMaximumSize(new Dimension(500, 500));
        userCarroPanel.add(horizontalGlue_2);*/

        /*JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new GridLayout(0, 1, 0, 0));*/
        
        toolBar.add(Box.createHorizontalGlue());
       
        cartButtton = new JButton("");
        cartButtton.setBorderPainted(false);
        cartButtton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cartButtton.setBackground(new Color(100, 149, 237));
        cartButtton.setBorder(UIManager.getBorder("DesktopIcon.border"));
        //Util.scaleImage(cart,0.25);
        toolBar.add(cartButtton);
        cartButtton.setIcon(Util.scaleImage(cart,0.35));
       

        //this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void enableEdit() {

        if(!editable) {
            nombreText.setEditable(true);
            emailText.setEditable(true);
            idText.setEditable(true);
            userText.setEditable(true);
            passwordField.setEditable(true);
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
}