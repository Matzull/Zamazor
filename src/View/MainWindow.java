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

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainWindow()
    {
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel topPanel = new JPanel();

        topPanel.setBackground(new Color(64, 23, 156)); //new Color(252, 135, 80)
        contentPane.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel zamazorIcon = new JLabel("");
        zamazorIcon.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon iconLogo = new ImageIcon(new ImageIcon("resources/zamazor.png").getImage().getScaledInstance(175, 50, Image.SCALE_SMOOTH));
        zamazorIcon.setIcon(iconLogo);
        topPanel.add(zamazorIcon);

        topPanel.add(Box.createRigidArea(new Dimension(115, 0)));
        barraBusqueda = new JTextField(40);
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
        barraBusqueda.setFont(new Font("Serif", Font.PLAIN, 20));
        topPanel.add(barraBusqueda);

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
        topPanel.add(search);

        topPanel.add(Box.createGlue());
        topPanel.add(Box.createRigidArea(new Dimension(10,10)));

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
        topPanel.add(user);

    }


}
