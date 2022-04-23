package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel contentPane;

    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainWindow()
    {
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setPreferredSize(new Dimension(0, 60));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout());

        JLabel zamazorIcon = new JLabel("");
        zamazorIcon.setForeground(Color.WHITE);
        panel.add(zamazorIcon, FlowLayout.LEFT);

        ImageIcon iconLogo = new ImageIcon("resources/IconoZamazor.png");
        zamazorIcon.setIcon(iconLogo);
    }


}
