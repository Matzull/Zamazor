package DAO.Pedido;

import Misc.Util;
import ModeloDominio.Pedido;

import java.util.List;
/**
 * esta clase representa la fachada de la clase DAOpedido
 * que se encarga de llamar a las funciones del DAO según el cliente quiera
 */
public class FachadaDaoPedidoImpl implements IFachadaDaoPedido {

    private IDAOPedido Dao;

    public FachadaDaoPedidoImpl(){Dao = new DAOpedido(Util.conn);}
    /**
     * @param p este parametro es el pedido seleccionado por el cliente
     * @return llama a la funcion altaPedido del DAO y devuelve el booleano
     *          de confirmacion de exito de la operacion
     */
    @Override
    public boolean altaPedido(Pedido p) {
        return Dao.altaPedido(p);
    }
    /**
     * @param p este parametro es el pedido seleccionado por el cliente
     * @return llama a la funcion modificarPedido del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean modificarPedido(Pedido p) {
        return Dao.modificarPedido(p);
    }
    /**
     * @param id este parametro es el id del pedido seleccionado por el cliente
     * @return llama a la funcion bajaPedido del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    @Override
    public boolean bajaPedido(int id) {
        return Dao.bajaPedido(id);
    }
    /**
     * @param id este parametro es el id aproximado del pedido escrito por el cliente
     * @return llama a la funcion buscarPedido del DAO y devuelve la lista de pedidos a
     *          mostrar
     */
    @Override
    public List<Pedido> buscarPedido(String id) {return Dao.buscarPedido(id);}
    /**
     * @param id este parametro es el id del pedido seleccionado por el cliente
     * @param mode TODO
     * @return llama a la funcion consultarPedido del DAO y devuelve el pedido a mostrar
     */
    @Override
    public Pedido consultarPedido(int id, boolean mode) {
        return Dao.consultarPedido(id, mode);
    }
}
