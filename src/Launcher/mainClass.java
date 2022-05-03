package Launcher;

import Subsistemas.Articulos.SAArticulos;
import Subsistemas.Pedido.SAPedido;
import View.MainWindow;

import javax.swing.*;
import java.awt.*;

/**
 * el main se encarga de ejecutar la ventana principal de la interfaz y ejecuta la hebra principal
 */
public class mainClass {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String looknfeel = UIManager.getSystemLookAndFeelClassName();
					UIManager.setLookAndFeel(looknfeel);
					//MainWindowAdministrador frame = new MainWindowAdministrador(new ArticuloController());
					//frame.setVisible(true);

					MainWindow Wnd = new MainWindow();
					Wnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
