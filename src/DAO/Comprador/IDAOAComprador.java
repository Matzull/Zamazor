package DAO.Comprador;

import ModeloDominio.Comprador;

import java.util.List;
/**
 * Esta es la interfaz de la clase DAOarticulo que se encarga de recopilar
 * los datos de la tabla Comprador de la base de datos y conectarlos con la logica del programa
 */
public interface IDAOAComprador {
    /**
     * @param comp este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion altaComprador del DAO y devuelve el booleano
     * de confirmacion de exito de la operacion
     */
    public boolean altaComprador(Comprador comp);
    /**
     * @param id este parametro es el id del comprador seleccionado por el cliente
     * @return llama a la funcion bajaComprador del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    public boolean bajaComprador(int id);
    /**
     * @param comp este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion modificarComprador del DAO y devuelve el booleano
     *      de confirmacion de exito de la operacion
     */
    public boolean modificarComprador(Comprador comp);
    /**
     * @param nombre este parametro es el nombre aproximado del comprador escrito por el cliente
     * @return llama a la funcion buscarComprador del DAO y devuelve la lista de compradores a
     *          mostrar
     */
    public List<Comprador> buscarComprador(String nombre);
    /**
     * @param username este parametro es el nombre de usuario del comprador seleccionado por el cliente
     * @return llama a la funcion consultarComprador del DAO y devuelve el comprador a mostrar
     */
    public Comprador consultarComprador(String username);

}
