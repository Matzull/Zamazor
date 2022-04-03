import java.util.List;

public interface IFachadaDao {
    boolean altaArticulo(Articulo art);
    boolean bajaArticulo(int id);
    boolean modificarArticulo(Articulo art);
    List<Articulo> buscarArticulos(String nombre);
    Articulo consultarArticulo(int id);
}
