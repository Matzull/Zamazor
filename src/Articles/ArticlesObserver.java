package Articles;

public interface ArticlesObserver {     //Patron observer. Necesario para la conexion con la GUI. MVC

    public void searchArticle(String name); //Para la busqueda con nombre del articulo
    public void searchArticle(Integer id);  //Para la busqueda con el Id del articulo

}
