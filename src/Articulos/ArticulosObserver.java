package Articulos;

import java.util.List;

public interface ArticulosObserver {     //Patron observer. Necesario para la conexion con la GUI. MVC

    public void buscarArticulo(List<Articulo> resultado); //Conexion con la GUI para que reciba la lista resultado y lo imprima
    public void consultarArticulo(Articulo resultado);  //Conexion con la GUI para que reciba el articulo resultado y lo imprima

}
