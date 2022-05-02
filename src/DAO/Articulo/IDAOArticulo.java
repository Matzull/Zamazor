package DAO.Articulo;

import ModeloDominio.Articulo;

import java.util.List;
/**
 * Esta es la interfaz de la clase DAOarticulo que se encarga de recopilar
 * los datos de la tabla Articulo de la base de datos y conectarlos con la logica del programa
 */
public interface IDAOArticulo {
    /**
     * @param art este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del DAO y devuelve el booleano
     *          de confirmacion de exito de la operacion
     */
    boolean altaArticulo(Articulo art);
    /**
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    boolean bajaArticulo(int id);
    /**
     * @param art este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    boolean modificarArticulo(Articulo art);
    /**
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO y devuelve la lista de articulos a
     *          mostrar
     */
    List<Articulo> buscarArticulos(String nombre);
    /**
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO y devuelve el articulo a mostrar
     */
    Articulo consultarArticulo(int id);

}
