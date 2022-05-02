package Subsistemas.Pedido;

import ModeloDominio.Pedido;

import java.util.List;
/**
 * esta clase representa la fachada de la clase SAarticulos
 * que se encarga de llamar a las funciones del SA según el cliente quiera
 */
public class ImplFachadaPedido implements FachadaPedido {

    private ISAPedido sa;

    public ImplFachadaPedido(){sa = new SAPedido();}
    /**
     *
     * @param p este parametro es el Pedido seleccionado por el cliente
     * @return llama a la funcion altaPedido del SA
     */

    @Override
    public boolean altaPedido(Pedido p) {
        return sa.altaPedido(p);
    }
    /**
     *
     * @param p este parametro es el Pedido seleccionado por el cliente
     * @return llama a la funcion modificarPedido del SA
     */
    @Override
    public boolean modificarPedido(Pedido p) {
        return sa.modificarPedido(p);
    }
    /**
     *
     * @param id este parametro es el id del Pedido seleccionado por el cliente
     * @return llama a la funcion bajaPedido del SA
     */
    @Override
    public boolean bajaPedido(int id) {
        return sa.bajaPedido(id);
    }
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    @Override
    public List<Pedido> buscarPedido(String nombre) {
        return sa.buscarPedido(nombre);
    }
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    @Override
    public Pedido consultarPedido(int id, boolean mode) {
        return sa.consultarPedido(id, mode);
    }
}
