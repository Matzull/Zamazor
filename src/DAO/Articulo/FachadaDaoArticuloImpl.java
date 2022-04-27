package DAO.Articulo;

import ModeloDominio.Articulo;

import java.util.List;

/**
 * esta clase representa la fachada de la clase DAOarticulo
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public class FachadaDaoArticuloImpl implements IFachadaDaoArticulo {

    private IDAOArticulo Dao;

    public FachadaDaoArticuloImpl(){Dao = new DAOarticulo();}

    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del DAO
     */
    @Override
    public boolean altaArticulo(Articulo a) {
        return Dao.altaArticulo(a);
    }
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del DAO
     */
    @Override
    public boolean modificarArticulo(Articulo a) {
        return Dao.modificarArticulo(a);
    }
    /**
     *
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del DAO
     */
    @Override
    public boolean bajaArticulo(int id) {
        return Dao.bajaArticulo(id);
    }
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    @Override
    public List<Articulo> buscarArticulos(String nombre) {return Dao.buscarArticulos(nombre);}
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    @Override
    public Articulo consultarArticulo(int id) {
        return Dao.consultarArticulo(id);
    }
}
