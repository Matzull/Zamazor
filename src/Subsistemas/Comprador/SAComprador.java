package Subsistemas.Comprador;

import DAO.Comprador.FachadaDaoCompradorImpl;
import ModeloDominio.Comprador;

import java.util.List;
/**
 * esta clase llama a las funciones de la fachada del DAO para hacer la conexion entre el DAO y la view
 */
public class SAComprador implements ISAComprador {

    private FachadaDaoCompradorImpl DAO;

    /**
     * la clase contiene solo un atributo que es el DAO ya que esta clase solo se encarga de relacionar
     * el DAO como la vista entre si
     */

    public SAComprador(){DAO = new FachadaDaoCompradorImpl();}

    /**
     *
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion altaComprador del DAO
     */

    @Override
    public boolean altaComprador(Comprador c) {
        return DAO.altaComprador(c);
    }

    /**
     *
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion modificarComprador del DAO
     */

    @Override
    public boolean modificarComprador(Comprador c) {
        return DAO.modificarComprador(c);
    }

    /**
     *
     * @param id este parametro es el id del comprador seleccionado por el cliente
     * @return llama a la funcion bajaComprador del DAO
     */


    @Override
    public boolean bajaComprador(Integer id) {
        return DAO.bajaComprador(id);
    }

    /**
     *
     * @param nombre este parametro es el nombre  del comprador
     * @return llama a la funcion buscarComprador del DAO
     */

    @Override
    public List<Comprador> buscarComprador(String nombre) {
        return DAO.buscarComprador(nombre);
    }

    /**
     *
     * @param username este parametro es el id del Comprador
     * @return llama a la funcion consultarComprador del DAO
     */

    @Override
    public Comprador consultarComprador(String username) {
        return DAO.consultarComprador(username);
    }
}
