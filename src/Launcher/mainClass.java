package Launcher;

import View.*;
import javax.swing.*;
import java.awt.*;

public class mainClass {     //El main sera la clase Amazon del diagrama de clases?
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    MainWindowAdministrador frame = new MainWindowAdministrador();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
