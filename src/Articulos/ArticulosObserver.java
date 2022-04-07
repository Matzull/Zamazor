package Articulos;

public interface ArticulosObserver {     //Patron observer. Necesario para la conexion con la GUI. MVC

    public void buscarArticulo(String nombre); //Para la busqueda con nombre del articulo
    public void consultarArticulo(Integer id);  //Para la busqueda con el Id del articulo

}
