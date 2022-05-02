package DAO.Articulo;

import Misc.Util;
import ModeloDominio.Articulo;

import java.util.List;

/**
 * esta clase representa la fachada de la clase DAOarticulo
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public class FachadaDaoArticuloImpl implements IFachadaDaoArticulo {

    private IDAOArticulo Dao;

    public FachadaDaoArticuloImpl(){Dao = new DAOarticulo(Util.conn);}

    /**
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del DAO y devuelve el booleano
     *          de confirmacion de exito de la operacion
     */
    @Override
    public boolean altaArticulo(Articulo a) {
        return Dao.altaArticulo(a);
    }
    /**
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean modificarArticulo(Articulo a) {
        return Dao.modificarArticulo(a);
    }
    /**
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean bajaArticulo(int id) {
        return Dao.bajaArticulo(id);
    }
    /**
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO y devuelve la lista de articulos a
     *          mostrar
     */
    @Override
    public List<Articulo> buscarArticulos(String nombre) {return Dao.buscarArticulos(nombre);}
    /**
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO y devuelve el articulo a mostrar
     */
    @Override
    public Articulo consultarArticulo(int id) {
        return Dao.consultarArticulo(id);
    }
}
