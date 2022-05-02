package DAO.Pedido;

import ModeloDominio.Pedido;

import java.util.List;

/**
 * Esta es la interfaz de la clase DAOpedido que se encarga de recopilar
 * los datos de la tabla Pedido de la base de datos y conectarlos con la logica del programa
 */
public interface IDAOPedido {
    /**
     * @param p este parametro es el pedido seleccionado por el cliente
     * @return llama a la funcion altaPedido del DAO y devuelve el booleano
     *          de confirmacion de exito de la operacion
     */
    public boolean altaPedido(Pedido p);
    /**
     * @param id este parametro es el id del pedido seleccionado por el cliente
     * @return llama a la funcion bajaPedido del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    public boolean bajaPedido(int id);
    /**
     * @param p este parametro es el pedido seleccionado por el cliente
     * @return llama a la funcion modificarPedido del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    public boolean modificarPedido(Pedido p);
    /**
     * @param id este parametro es el id aproximado del pedido escrito por el cliente
     * @return llama a la funcion buscarPedido del DAO y devuelve la lista de pedidos a
     *          mostrar
     */
    public List<Pedido> buscarPedido(String id);
    /**
     * @param id este parametro es el id del pedido seleccionado por el cliente
     * @param mode TODO
     * @return llama a la funcion consultarPedido del DAO y devuelve el pedido a mostrar
     */
    public Pedido consultarPedido(int id, boolean mode);

}
