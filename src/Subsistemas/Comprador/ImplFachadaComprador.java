package Subsistemas.Comprador;

import ModeloDominio.Comprador;

import java.util.List;

/**
 * esta clase representa la fachada de la clase SAarticulos
 * que se encarga de llamar a las funciones del SA según el cliente quiera
 */

public class ImplFachadaComprador implements FachadaComprador{

    private ISAComprador sa;

    public ImplFachadaComprador() { sa = new SAComprador(); }

    /**
     *
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion altaComprador del SA
     */

    @Override
    public boolean altaComprador(Comprador c) {
        return sa.altaComprador(c);
    }

    /**
     *
     * @param c este parametro es el comprador seleccionado por el cliente
     * @return llama a la funcion modificarComprador del SA
     */

    @Override
    public boolean modificarComprador(Comprador c) {
        return sa.modificarComprador(c);
    }

    /**
     *
     * @param id este parametro es el id del Comprador seleccionado por el cliente
     * @return llama a la funcion bajaComprador del SA
     */

    @Override
    public boolean bajaComprador(Integer id) { return sa.bajaComprador(id); }

    /**
     *
     * @param nombre este parametro es el nombre aproximado del Comprador escrito por el cliente
     * @return llama a la funcion buscarComprador del DAO
     */

    @Override
    public List<Comprador> buscarComprador(String nombre) {
        return sa.buscarComprador(nombre);
    }

    /**
     *
     * @param username este parametro es el id del Comprador seleccionado por el cliente
     * @return llama a la funcion consultarComprador del DAO
     */

    @Override
    public Comprador consultarComprador(String username) {
        return sa.consultarComprador(username);
    }
}
