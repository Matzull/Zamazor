package DAO.Vendedor;

import Misc.Util;
import ModeloDominio.Vendedor;

import java.util.List;
/**
 * esta clase representa la fachada de la clase DAOvendedor
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public class FachadaDaoVendedorImpl implements IFachadaDaoVendedor{

    private IDAOAVendedor Dao;

    public FachadaDaoVendedorImpl(){Dao = new DAOvendedor(Util.conn);}
    /**
     * @param v este parametro es el vendedor seleccionado por el cliente
     * @return llama a la funcion altaVendedor del DAO y devuelve el booleano
     *          de confirmacion de exito de la operacion
     */
    @Override
    public boolean altaVendedor(Vendedor v) {
        return Dao.altaVendedor(v);
    }
    /**
     * @param v este parametro es el vendedor seleccionado por el cliente
     * @return llama a la funcion modificarVendedor del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean modificarVendedor(Vendedor v) {
        return Dao.modificarVendedor(v);
    }
    /**
     * @param id este parametro es el id del vendedor seleccionado por el cliente
     * @return llama a la funcion bajaVendedor del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean bajaVendedor(int id) {
        return Dao.bajaVendedor(id);
    }
    /**
     * @param nombre este parametro es el nombre aproximado del vendedor escrito por el cliente
     * @return llama a la funcion buscarVendedor del DAO y devuelve la lista de vendedores a
     *          mostrar
     */
    @Override
    public List<Vendedor> buscarVendedor(String nombre) {return Dao.buscarVendedor(nombre);}
    /**
     * @param username este parametro es el nombre de usuario del vendedor seleccionado por el cliente
     * @return llama a la funcion consultarVendedor del DAO y devuelve el vendedor a mostrar
     */
    @Override
    public Vendedor consultarVendedor(String username) {
        return Dao.consultarVendedor(username);
    }

}
