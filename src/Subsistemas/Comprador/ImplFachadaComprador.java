package Subsistemas.Comprador;

import ModeloDominio.Comprador;

import java.util.List;

public class ImplFachadaComprador implements FachadaComprador{

    private ISAComprador sa;

    public ImplFachadaComprador() { sa = new SAComprador(); }

    @Override
    public boolean altaComprador(Comprador c) {
        return sa.altaComprador(c);
    }

    @Override
    public boolean modificarComprador(Comprador c) {
        return sa.modificarComprador(c);
    }

    @Override
    public boolean bajaComprador(Integer id) { return sa.bajaComprador(id); }

    @Override
    public List<Comprador> buscarComprador(String nombre) {
        return sa.buscarComprador(nombre);
    }

    @Override
    public Comprador consultarComprador(String username) {
        return sa.consultarComprador(username);
    }
}
