package DAO.Articulo;

import ModeloDominio.Articulo;

import java.util.List;
/**
 * esta clase representa la interfaz de la fachada de la clase DAOarticulo
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public interface IFachadaDaoArticulo {
    /**
     * @param art este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del DAO y devuelve el booleano
     *          de confirmacion de exito de la operacion
     */
    public boolean altaArticulo(Articulo art);
    /**
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    public boolean bajaArticulo(int id);
    /**
     * @param art este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    public boolean modificarArticulo(Articulo art);
    /**
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO y devuelve la lista de articulos a
     *          mostrar
     */
    public List<Articulo> buscarArticulos(String nombre);
    /**
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO y devuelve el articulo a mostrar
     */
    public Articulo consultarArticulo(int id);

}
