package Subsistemas.Articulos;

import ModeloDominio.Articulo;

import java.util.List;
/**
 * esta clase representa la fachada de la clase SAarticulos
 * que se encarga de llamar a las funciones del SA según el cliente quiera
 */
public class ImplFachadaArticulos implements FachadaArticulos {           //Implementacion de la fachada del articulo

    private ISAArticulos sa;

    public ImplFachadaArticulos()
    {
        sa = new SAArticulos();
    }
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del SA
     */
    @Override
    public boolean altaArticulo(Articulo a) {
        return sa.altaArticulo(a);
    }
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del SA
     */
    @Override
    public boolean modificarArticulo(Articulo a) {
        return sa.modificarArticulo(a);
    }
    /**
     *
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del SA
     */
    @Override
    public boolean bajaArticulo(int id) {
        return sa.bajaArticulo(id);
    }
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    @Override
    public List<Articulo> buscarArticulo(String nombre) {
        return sa.buscarArticulos(nombre);
    }
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    @Override
    public Articulo consultarArticulo(int id) {
        return sa.consultarArticulo(id);
    }

}
