package Launcher;

import View.MainWindow;

import java.awt.EventQueue;

import javax.swing.*;

public class mainClass {     //El main sera la clase Amazon del diagrama de clases?
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					//MainWindowAdministrador frame = new MainWindowAdministrador(new ArticulosController());
					//frame.setVisible(true);
					MainWindow Wnd = new MainWindow();
					Wnd.setVisible(true);
					//Login log = new Login();
					//log.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
