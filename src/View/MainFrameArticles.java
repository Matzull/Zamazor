package View;

import javax.swing.*;

public class MainFrameArticles extends JFrame{
    private JPanel mainArticlesPanel;
    private JTextField nArticulo;
    private JButton searchButton;
    private JLabel zamazor;
    private JList list1;
    private JTable prueba;
    private JButton button1;


    public MainFrameArticles(){
        System.out.println("P");
        //setContentPane(mainArticlesPanel);
        setTitle("Welcome to Zamazor");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        /*searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Accion boton de busqueda
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nArticulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String de busqueda
            }
        });*/
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        MainFrameArticles prueba = new MainFrameArticles();
    }
}
