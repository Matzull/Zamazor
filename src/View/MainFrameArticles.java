package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameArticles extends JFrame{
    private JPanel mainArticlesPanel;
    private JTextField nArticulo;
    private JButton searchButton;
    private JLabel zamazor;


    public MainFrameArticles(){
        setContentPane(mainArticlesPanel);
        setTitle("Welcome to Zamazor");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Accion boton de busqueda
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
