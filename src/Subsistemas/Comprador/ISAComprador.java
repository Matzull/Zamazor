package Subsistemas.Comprador;

import ModeloDominio.Comprador;

import java.util.List;
/**
 * Esta es la interfaz de la clase SAAComprador que se encarga de recopilar
 * los datos del DAO y conectarlos con el controlador
 */
public interface ISAComprador {
    /**
     *
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion altaComprador del SA
     */
    public boolean altaComprador(Comprador c);
    /**
     *
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion modificarComprador del SA
     */
    public boolean modificarComprador(Comprador c);
    /**
     *
     * @param id este parametro es el id del Comprador seleccionado por el cliente
     * @return llama a la funcion bajaComprador del SA
     */
    public boolean bajaComprador(Integer id);
    /**
     *
     * @param nombre este parametro es el nombre aproximado del Comprador escrito por el cliente
     * @return llama a la funcion buscarComprador del DAO
     */
    public List<Comprador> buscarComprador(String nombre);
    /**
     *
     * @param username este parametro es el id del Comprador seleccionado por el cliente
     * @return llama a la funcion consultarComprador del DAO
     */
    public Comprador consultarComprador(String username);

}
