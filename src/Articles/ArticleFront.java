package Articles;

import java.util.ArrayList;

public interface ArticleFront {                     //Fachada articulo

    boolean createArticle(Articles a);              //Alta articulo
    boolean modifyArticle(Articles a);              //Modificar articulo
    boolean deleteArticle(Articles a);              //Baja articulo
    ArrayList<Articles> seekArticles(String name);  //Buscar articulo (lista de articulos)
    Articles searchArticle(int id);                 //Consultar articulo (articulo)

}
