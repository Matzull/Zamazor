package Subsistemas.Articulos;

import DAO.Articulo.FachadaDaoArticuloImpl;
import DAO.Articulo.IFachadaDaoArticulo;
import ModeloDominio.Articulo;

import java.util.List;

/**
 * esta clase llama a las funciones de la fachada del DAO para hacer la conexion entre el DAO y la view
 */
public class SAArticulos implements ISAArticulos{  //Servicio de aplicacion

    private IFachadaDaoArticulo DAO;

    /**
     * la clase contiene solo un atributo que es el DAO ya que esta clase solo se encarga de relacionar
     * el DAO como la vista entre si
     */
    public SAArticulos()
    {
        DAO = new FachadaDaoArticuloImpl();
    }
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion altaArticulo del DAO
     */
    public boolean altaArticulo(Articulo a) {
        return DAO.altaArticulo(a);
    }
    /**
     *
     * @param a este parametro es el articulo seleccionado por el cliente
     * @return llama a la funcion modificarArticulo del DAO
     */
    public boolean modificarArticulo(Articulo a) {
        return DAO.modificarArticulo(a);
    }
    /**
     *
     * @param id este parametro es el id del articulo seleccionado por el cliente
     * @return llama a la funcion bajaArticulo del DAO
     */
    public boolean bajaArticulo(int id) {
        return DAO.bajaArticulo(id);
    }
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    public List<Articulo> buscarArticulos(String nombre) {
        return DAO.buscarArticulos(nombre);
    }
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    public Articulo consultarArticulo(int id) {
        return DAO.consultarArticulo(id);
    }

}
