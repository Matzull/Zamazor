package DAO.Articulo;

import ModeloDominio.Articulo;

import java.util.List;
/**
 * Esta es la interfaz de la clase DAOarticulo que se encarga de recopilar
 * los datos de la tabla Articulo de la base de datos y conectarlos con la logica del programa
 */
public interface IDAOArticulo {

    boolean altaArticulo(Articulo art);

    boolean bajaArticulo(int id);

    boolean modificarArticulo(Articulo art);

    List<Articulo> buscarArticulos(String nombre);

    Articulo consultarArticulo(int id);

}
