package Subsistemas.Pedido;

import ModeloDominio.Pedido;

import java.util.List;
/**
 * Esta es la interfaz de la clase SAPedido que se encarga de recopilar
 * los datos del DAO y conectarlos con el controlador
 */
public interface ISAPedido {
    /**
     *
     * @param p este parametro es el Pedido seleccionado por el cliente
     * @return llama a la funcion altaPedido del SA
     */
    public boolean altaPedido(Pedido p);
    /**
     *
     * @param p este parametro es el Pedido seleccionado por el cliente
     * @return llama a la funcion modificarPedido del SA
     */
    public boolean modificarPedido(Pedido p);
    /**
     *
     * @param id este parametro es el id del Pedido seleccionado por el cliente
     * @return llama a la funcion bajaPedido del SA
     */
    public boolean bajaPedido(int id);
    /**
     *
     * @param nombre este parametro es el nombre aproximado del articulo escrito por el cliente
     * @return llama a la funcion buscarArticulos del DAO
     */
    public List<Pedido> buscarPedido(String nombre);
    /**
     *
     * @param id este parametro es el id delarticulo seleccionado por el cliente
     * @return llama a la funcion consultarArticulo del DAO
     */
    public Pedido consultarPedido(int id, boolean mode);

}
