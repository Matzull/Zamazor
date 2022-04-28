package Launcher;

import Subsistemas.Articulos.SAArticulos;
import Subsistemas.Pedido.SAPedido;
import View.Login;
import View.MainWindow;

import java.awt.EventQueue;

import javax.swing.*;

public class mainClass {     //El main sera la clase Amazon del diagrama de clases?
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					//MainWindowAdministrador frame = new MainWindowAdministrador(new ArticuloController());
					//frame.setVisible(true);

					MainWindow Wnd = new MainWindow();
					Wnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//debug();

	}
	private static void debug()
	{
		SAPedido sa = new SAPedido();
		SAArticulos sa2 = new SAArticulos();
		int id2;
		id2 = sa.consultarPedido(2).getArticulos().get(1).getId();
		System.out.println(sa2.consultarArticulo(id2));

	}
}
