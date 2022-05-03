package Subsistemas.Articulos;

import ModeloDominio.Articulo;

import java.util.List;
/**
 * esta clase representa la interfaz de la fachada de la clase SAarticulos
 * que se encarga de llamar a las funciones del SA según el cliente quiera
 */
public interface FachadaArticulos {                     //Fachada articulo
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del SA
     */
    public boolean altaArticulo(Articulo a);
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del SA
     */
    public boolean modificarArticulo(Articulo a);
    /**
     *
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del SA
     */
    public boolean bajaArticulo(int id);
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    public List<Articulo> buscarArticulo(String nombre);
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    public Articulo consultarArticulo(int id);

}
