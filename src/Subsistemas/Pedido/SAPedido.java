package Subsistemas.Pedido;

import DAO.Pedido.FachadaDaoPedidoImpl;
import ModeloDominio.Pedido;

import java.util.List;
/**
 * esta clase representa la fachada de la clase SApedido
 * que se encarga de llamar a las funciones del SA según el cliente quiera
 */
public class SAPedido implements ISAPedido {

    private FachadaDaoPedidoImpl DAO;

    public SAPedido(){DAO = new FachadaDaoPedidoImpl();}
    /**
     *
     * @param p este parametro es el Pedido seleccionado por el cliente
     * @return llama a la funcion altaPedido del SA
     */

    @Override
    public boolean altaPedido(Pedido p) {
        return DAO.altaPedido(p);
    }
    /**
     *
     * @param p este parametro es el Pedido seleccionado por el cliente
     * @return llama a la funcion modificarPedido del SA
     */
    @Override
    public boolean modificarPedido(Pedido p) {
        return DAO.modificarPedido(p);
    }
    /**
     *
     * @param id este parametro es el id del Pedido seleccionado por el cliente
     * @return llama a la funcion bajaPedido del SA
     */
    @Override
    public boolean bajaPedido(int id) {
        return DAO.bajaPedido(id);
    }
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    @Override
    public List<Pedido> buscarPedido(String nombre) {
        return DAO.buscarPedido(nombre);
    }
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    @Override
    public Pedido consultarPedido(int id, boolean mode) {
        return DAO.consultarPedido(id, mode);
    }
}
