import View.MainFrameArticles;

import javax.swing.*;

public class main {     //El main sera la clase Amazon del diagrama de clases?
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {             //Thread para la GUI de articulo
            @Override
            public void run() {
                //ArticlesView av = new ArticlesView();
            }
        });
    }

}
