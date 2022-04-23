package Subsistemas.Comprador.DAO;

import ModeloDominio.Comprador;

import java.util.List;

public class FachadaDAOCompradorImpl implements IFachadaDAOComprador{
    @Override
    public boolean altaComprador(Comprador comprador) {
        return false;
    }

    @Override
    public boolean modificarComprador(Comprador comprador) {
        return false;
    }

    @Override
    public boolean bajaComprador(Integer id) {
        return false;
    }

    @Override
    public List<Comprador> buscarComprador(String nombre) {
        return null;
    }

    @Override
    public Comprador consultarComprador(Integer id) {
        return null;
    }
}
