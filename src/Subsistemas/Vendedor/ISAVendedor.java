package Subsistemas.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;
/**
 * Esta es la interfaz de la clase SAvendedor que se encarga de recopilar
 * los datos del DAO y conectarlos con el controlador
 */
public interface ISAVendedor {
    /**
     *
     * @param v este parametro es el Vendedor seleccionado por el cliente
     * @return llama a la funcion altaVendedor del SA
     */
    public boolean altaVendedor(Vendedor v);
    /**
     *
     * @param v este parametro es el Vendedor seleccionado por el cliente
     * @return llama a la funcion modificarVendedor del SA
     */
    public boolean modificarVendedor(Vendedor v);
    /**
     *
     * @param id este parametro es el id del Vendedor seleccionado por el cliente
     * @return llama a la funcion bajaVendedor del SA
     */
    public boolean bajaVendedor(int id);
    /**
     *
     * @param nombre este parametro es el nombre aproximado del Vendedor escrito por el cliente
     * @return llama a la funcion buscarVendedor del DAO
     */
    public List<Vendedor> buscarVendedor(String nombre);
    /**
     *
     * @param username este parametro es el nombre de usuario del Vendedor seleccionado
     * @return llama a la funcion consultarVendedor del DAO
     */
    public Vendedor consultarVendedor(String username);

}
