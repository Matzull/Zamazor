package DAO.Articulo;
import java.util.List;
import ModeloDominio.Articulo;

public interface IDAOArticulo {

    boolean altaArticulo(Articulo art);

    boolean bajaArticulo(int id);

    boolean modificarArticulo(Articulo art);

    List<Articulo> buscarArticulos(String nombre);

    Articulo consultarArticulo(int id);

}