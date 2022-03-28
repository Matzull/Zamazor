package View;

import javax.swing.*;

public class MainFrameArticles extends JFrame{
    private JTextField nArticulo;
    private JButton searchButton;
    private JPanel mainArticlesPanel;


    public MainFrameArticles(){
        setContentPane(mainArticlesPanel);
        setTitle("Welcome to Zamazor");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
