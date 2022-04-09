package DAO;
import java.util.List;
import Articulos.Articulo;
public interface IFachadaDao {

    boolean altaArticulo(Articulo art);

    boolean bajaArticulo(int id);

    boolean modificarArticulo(Articulo art);

    List<Articulo> buscarArticulos(String nombre);

    Articulo consultarArticulo(int id);
}
