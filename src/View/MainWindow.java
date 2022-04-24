package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {

    private JPanel contentPane;
    private JTextField barraBusqueda;
    private JToolBar _toolbar;

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainWindow()
    {
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _toolbar = new JToolBar();
        //_toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        _toolbar.setLayout(new BorderLayout());
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel topPanel = new JPanel();

        topPanel.setBackground(new Color(64, 23, 156)); //new Color(252, 135, 80)
        contentPane.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        _toolbar.setOpaque(false);
        topPanel.add(_toolbar, BorderLayout.PAGE_START);


        JLabel zamazorIcon = new JLabel("");
        zamazorIcon.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon iconLogo = new ImageIcon(new ImageIcon("resources/zamazor.png").getImage().getScaledInstance(175, 50, Image.SCALE_SMOOTH));
        zamazorIcon.setIcon(iconLogo);
        _toolbar.add(zamazorIcon);

        _toolbar.addSeparator(new Dimension(115, 0));

        barraBusqueda = new JTextField(45);
        barraBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    String texto = barraBusqueda.getText().toLowerCase();
                    //filter(texto);
                }
            }
        });
        barraBusqueda.setFont(new Font("Serif", Font.PLAIN, 25));

        _toolbar.add(barraBusqueda);
        _toolbar.addSeparator(new Dimension(40, 0));
        JButton search = new JButton("");
        search.setBorderPainted(false);
        search.setBackground(new Color(252, 135, 80));
        iconLogo = new ImageIcon("resources/IconoLupa.png");
        search.setIcon(iconLogo);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = barraBusqueda.getText().toLowerCase();
                //filter(texto);
            }
        });
        _toolbar.add(search);


        //_toolbar.add(Box.createHorizontalGlue());
        _toolbar.addSeparator();


        JButton user = new JButton("");
        user.setBorderPainted(false);
        user.setBackground(new Color(252, 135, 80));
        ImageIcon userIcon = new ImageIcon(new ImageIcon("resources/user.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        user.setIcon(userIcon);
        user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = barraBusqueda.getText().toLowerCase();
                //filter(texto);
            }
        });
        _toolbar.add(user);

    }


}
