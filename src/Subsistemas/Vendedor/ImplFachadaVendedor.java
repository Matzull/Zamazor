package Subsistemas.Vendedor;

import ModeloDominio.Vendedor;

import java.util.List;

/**
 * esta clase representa la fachada de la clase SAVendedor
 * que se encarga de llamar a las funciones del SA según el cliente quiera
 */

public class ImplFachadaVendedor implements FachadaVendedor{

    private ISAVendedor sa;

    public ImplFachadaVendedor(){sa = new SAVendedor();}
    /**
     *
     * @param v este parametro es el Vendedor seleccionado por el cliente
     * @return llama a la funcion altaVendedor del SA
     */

    @Override
    public boolean altaVendedor(Vendedor v) {
        return sa.altaVendedor(v);
    }
    /**
     *
     * @param v este parametro es el Vendedor seleccionado por el cliente
     * @return llama a la funcion modificarVendedor del SA
     */
    @Override
    public boolean modificarVendedor(Vendedor v) {
        return sa.modificarVendedor(v);
    }
    /**
     *
     * @param id este parametro es el id del Vendedor seleccionado por el cliente
     * @return llama a la funcion bajaVendedor del SA
     */
    @Override
    public boolean bajaVendedor(int id) {
        return sa.bajaVendedor(id);
    }
    /**
     *
     * @param nombre este parametro es el nombre aproximado del Vendedor escrito por el cliente
     * @return llama a la funcion buscarVendedor del DAO
     */
    @Override
    public List<Vendedor> buscarVendedor(String nombre) {
        return sa.buscarVendedor(nombre);
    }
    /**
     *
     * @param username este parametro es el nombre de usuario del Vendedor seleccionado
     * @return llama a la funcion consultarVendedor del DAO
     */
    @Override
    public Vendedor consultarVendedor(String username) {
        return sa.consultarVendedor(username);
    }
}
