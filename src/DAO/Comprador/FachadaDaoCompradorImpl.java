package DAO.Comprador;

import Misc.Util;
import ModeloDominio.Comprador;

import java.util.List;

/**
 * esta clase representa la fachada de la clase DAOcomprador
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public class FachadaDaoCompradorImpl implements IFachadaDaoComprador {

    private IDAOAComprador Dao;

    public FachadaDaoCompradorImpl(){Dao = new DAOcomprador(Util.conn);}
    /**
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion altaComprador del DAO y devuelve el booleano
     * de confirmacion de exito de la operacion
     */
    @Override
    public boolean altaComprador(Comprador c) {
        return Dao.altaComprador(c);
    }
    /**
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion modificarComprador del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean modificarComprador(Comprador c) {
        return Dao.modificarComprador(c);
    }
    /**
     * @param id este parametro es el id del comprador seleccionado por el cliente
     * @return llama a la funcion bajaComprador del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean bajaComprador(int id) {
        return Dao.bajaComprador(id);
    }
    /**
     * @param nombre este parametro es el nombre aproximado del comprador escrito por el cliente
     * @return llama a la funcion buscarComprador del DAO y devuelve la lista de compradores a
     *          mostrar
     */
    @Override
    public List<Comprador> buscarComprador(String nombre) {return Dao.buscarComprador(nombre);}
    /**
     * @param username este parametro es el nombre de usuario del comprador seleccionado por el cliente
     * @return llama a la funcion consultarComprador del DAO y devuelve el comprador a mostrar
     */
    @Override
    public Comprador consultarComprador(String username) {
        return Dao.consultarComprador(username);
    }
}
